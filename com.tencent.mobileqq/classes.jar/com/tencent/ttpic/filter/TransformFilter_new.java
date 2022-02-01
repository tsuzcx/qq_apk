package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.MeshDistortionType;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.DistortionItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.FIELD;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.ttpic.util.TransformUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TransformFilter_new
  extends VideoFilterBase
  implements AEFilterI
{
  private static final List<DistortionItem> EMPTY = new ArrayList();
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n varying vec2 textureCoordinate;\n\n \n uniform float item[210];\n uniform float cos_roll;\n uniform float sin_roll;\n uniform float cos_yaw;\n uniform float tan_yaw;\n uniform float tan_pitch;\nuniform float screenRatioX;\nuniform float screenRatioY;\nuniform vec2 texMapSize;\n\n //30 * 7, type, strength, pointX, pointY, radius, direction, depth\n\n float my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nvec2 distortedPosition(vec2 currentPosition) {\n    vec2 newPosition = currentPosition;\n    //if (newPosition.x <= -0.98 || newPosition.y <= -0.98 || newPosition.x >= 0.98 || newPosition.y >= 0.98) {\n    //    return newPosition;\n    //}\n    for (int i = 0; i < 30; i++) {\n        int idx = i * 7;\n        if (item[idx] < 0.1) {\n            continue;\n        }\n\n        vec2 centerPoint = vec2(item[idx+2], item[idx+3]);\n        vec2 ratioTransTargetPoint = vec2(newPosition.x * screenRatioX, newPosition.y * screenRatioY);\n\n        vec2 distVector = ratioTransTargetPoint - centerPoint;\n        // first, rotate vector by face roll\n        vec2 _v = vec2(distVector.x*cos_roll+distVector.y*sin_roll, -distVector.x*sin_roll+distVector.y*cos_roll);\n        float distX0 = abs(_v.x);\n        float distY0 = abs(_v.y);\n        float ddist = sqrt(distX0 * distX0 + distY0 * distY0);\n        if (ddist * 0.5 > item[idx+4]) continue;\n\n        // second, remove perspective effect\n        float d = _v.x * tan_yaw;\n        float d2 = _v.y * tan_pitch;\n\n        float depth = item[idx+6] + d;\n        if(depth <= 0.0) {\n            continue;\n        }\n        depth = clamp(depth, 1.0, 5.0);\n        float distX1 = distX0 * (depth / item[idx+6]);\n        float distY1 = distY0 * (depth / item[idx+6]);\n        // third, remove yaw and pitch effect\n        if(depth > 2.5) {\n          distX1 = distX1 / (1.0-(1.0-cos_yaw)*my_smoothstep(0.0, 0.05, depth-2.5));\n          //distX1 = distX1 / cos_yaw;\n        }\n        //distY1 = distY1 / cos_pitch;\n        float dist = sqrt(distX1 * distX1 + distY1 * distY1);\n        //float dist = distance(ratioTransTargetPoint, centerPoint);\n        if (item[idx] > 1.1) {\n            dist = dist / 1.2;\n        }\n        if (dist < item[idx+4]) {\n            vec2 strengthAdjust = vec2(cos_yaw, 1.0);\n            if(depth < 2.5) {\n                strengthAdjust.x = 1.0-(1.0-cos_yaw)*(1.0-my_smoothstep(0.0, 0.1, 2.5-depth));\n            }\n            float distRatio = dist / item[idx+4];\n            float dx = (centerPoint.x - ratioTransTargetPoint.x) / 1.2;\n            float dy = (centerPoint.y - ratioTransTargetPoint.y) / 1.2;\n            if (item[idx] < 1.1) {\n                dx = dx * 1.2;\n                dy = dy * 1.2;\n                float weight = 1.2 * (1.0 - my_smoothstep(0.0, 1.0, distRatio)) * item[idx+1];\n                dx = dx * weight;\n                dy = dy * weight;\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                newPosition.x -= (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y -= (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 2.1) {\n                float weight = (1.0 - my_smoothstep(0.0, 1.0, distRatio)) * item[idx+1];\n                dx = dx * weight;\n                dy = dy * weight;\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 3.1) {\n                float delta = 1.0 - distRatio*distRatio;\n                float deltaScale = my_smoothstep(0.0, 1.0, delta);\n                float weight = delta * deltaScale * item[idx+4] * 0.5 * item[idx+1];\n                //float weight = (cos(3.1415 * 0.5 * distRatio)) * item[idx+4] * 0.5 * item[idx+1];\n                vec2 vector = vec2(1.0, 1.0);\n                if (item[idx+5] < 1.1) {\n                    vector.x *= -weight; vector.y = 0.0;\n                } else if (item[idx+5] < 2.1) {\n                    vector.x = 0.0; vector.y *= -weight;\n                } else if (item[idx+5] < 3.1) {\n                    vector.x *= weight; vector.y = 0.0;\n                } else if (item[idx+5] < 4.1) {\n                    vector.x = 0.0; vector.y *= weight;\n                } else if (item[idx+5] < 5.1) {\n                    vector.x *= -weight; vector.y *= -weight;\n                } else if (item[idx+5] < 6.1) {\n                    vector.x *= weight; vector.y *= -weight;\n                } else if (item[idx+5] < 7.1) {\n                    vector.x *= -weight; vector.y *= weight;\n                } else if (item[idx+5] < 8.1) {\n                    vector.x *= weight; vector.y *= weight;\n                } else {\n                    vector.x = 0.0; vector.y = 0.0;\n                }\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                vector.y *= 9.0 / 16.0;\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 5.1) {\n                float delta = 1.0 - distRatio*distRatio;\n                float deltaScale = my_smoothstep(0.0, 1.0, delta);\n                float weight = delta * deltaScale * item[idx+4] * 0.5 * item[idx+1];\n                dx = weight*cos(item[idx+5]);\n                dy = weight*sin(item[idx+5]);\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                vector.y *= 9.0 / 16.0;\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            }\n        }\n    }\n    return newPosition;\n}\n\n void main() {\n     vec2 xTexCoord = (textureCoordinate * texMapSize - 0.5) / (texMapSize - 1.0);\n     vec2 position = xTexCoord * 2.0 - 1.0;\n     vec2 trueDiff = vec2(0.0, 0.0);\n\n     vec4 texDiff = texture2D(inputImageTexture, textureCoordinate);\n     trueDiff = (texDiff.xy * 255.0 + texDiff.zw) / 127.5 - 1.0;   //diff of raw\n     if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n        trueDiff = vec2(0.0, 0.0);\n     }\n    \n     vec2 nPosition;\n     vec2 diffPosition;\n     position += trueDiff * 2.0;\n     position.x *= screenRatioY;\n     position.y *= screenRatioX;\n     nPosition = 0.5 * (distortedPosition(position) + vec2(screenRatioY, screenRatioX));\n     diffPosition = (nPosition * vec2(1.0/screenRatioY, 1.0/screenRatioX) - xTexCoord);\n\n     /*if (screenRatio >= 1.0){\n         position.x *= screenRatio;\n         nPosition = 0.5 * (distortedPosition(position) + vec2(screenRatio, 1.0));\n         diffPosition = (nPosition * vec2(1.0 / screenRatio, 1.0) - xTexCoord) + trueDiff;\n     } else {\n         position.y /= screenRatio;\n         nPosition = 0.5 * (distortedPosition(position) + vec2(1.0, 1.0 / screenRatio));\n         diffPosition = (nPosition * vec2(1.0, screenRatio) - xTexCoord) + trueDiff;\n     }*/\n     \n     diffPosition = 0.5 * (diffPosition + 1.0) * 255.0;\n     vec2 a = floor(diffPosition) / 255.0;\n     vec2 b = fract(diffPosition);\n\n     gl_FragColor = vec4(a,b);\n }";
  private static final int MESH_DISTORTION_TYPE_COUNT = 30;
  private static final String VERTEX_SHADER = "precision highp float;\n attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate      = inputTextureCoordinate.xy;\n }";
  private static final int XCOORD_NUM = 64;
  private static final int YCOORD_NUM = 64;
  private static final List<Integer> chinFacePoints = Arrays.asList(new Integer[] { Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14) });
  private static final List<Integer> leftFacePoints;
  private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(64, 64, -1.0F, 1.0F, -1.0F, 1.0F);
  private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(64, 64, 0.0F, 1.0F, 0.0F, 1.0F);
  private static final List<Integer> rightFacePoints;
  float anotherStrength = 1.0F;
  private String dataPath;
  private float faceHeight;
  private float faceWidth;
  private float[] flatMesh = new float['Ò'];
  private int frameIdx;
  private List<DistortionItem> items;
  private FaceMeshItem mFaceMeshItem;
  private int mLastMeshIndex = -1;
  private Map<String, List<DistortionItem>> mMeshCache = new HashMap();
  private MeshDistortionType[] meshs = new MeshDistortionType[30];
  private boolean optimizeBoundary = false;
  private float optimizeBoundaryStrength = 0.25F;
  private float screenRatioX = 1.0F;
  private float screenRatioY = 1.0F;
  private List<StickerItem> stickerItems;
  private float strengthAdjust = 1.0F;
  private float[] texMapSize = { 65.0F, 65.0F };
  
  static
  {
    leftFacePoints = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8) });
    rightFacePoints = Arrays.asList(new Integer[] { Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18) });
  }
  
  public TransformFilter_new(FaceMeshItem paramFaceMeshItem, String paramString)
  {
    super("precision highp float;\n attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate      = inputTextureCoordinate.xy;\n }", "precision highp float;\n uniform sampler2D inputImageTexture;\n varying vec2 textureCoordinate;\n\n \n uniform float item[210];\n uniform float cos_roll;\n uniform float sin_roll;\n uniform float cos_yaw;\n uniform float tan_yaw;\n uniform float tan_pitch;\nuniform float screenRatioX;\nuniform float screenRatioY;\nuniform vec2 texMapSize;\n\n //30 * 7, type, strength, pointX, pointY, radius, direction, depth\n\n float my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nvec2 distortedPosition(vec2 currentPosition) {\n    vec2 newPosition = currentPosition;\n    //if (newPosition.x <= -0.98 || newPosition.y <= -0.98 || newPosition.x >= 0.98 || newPosition.y >= 0.98) {\n    //    return newPosition;\n    //}\n    for (int i = 0; i < 30; i++) {\n        int idx = i * 7;\n        if (item[idx] < 0.1) {\n            continue;\n        }\n\n        vec2 centerPoint = vec2(item[idx+2], item[idx+3]);\n        vec2 ratioTransTargetPoint = vec2(newPosition.x * screenRatioX, newPosition.y * screenRatioY);\n\n        vec2 distVector = ratioTransTargetPoint - centerPoint;\n        // first, rotate vector by face roll\n        vec2 _v = vec2(distVector.x*cos_roll+distVector.y*sin_roll, -distVector.x*sin_roll+distVector.y*cos_roll);\n        float distX0 = abs(_v.x);\n        float distY0 = abs(_v.y);\n        float ddist = sqrt(distX0 * distX0 + distY0 * distY0);\n        if (ddist * 0.5 > item[idx+4]) continue;\n\n        // second, remove perspective effect\n        float d = _v.x * tan_yaw;\n        float d2 = _v.y * tan_pitch;\n\n        float depth = item[idx+6] + d;\n        if(depth <= 0.0) {\n            continue;\n        }\n        depth = clamp(depth, 1.0, 5.0);\n        float distX1 = distX0 * (depth / item[idx+6]);\n        float distY1 = distY0 * (depth / item[idx+6]);\n        // third, remove yaw and pitch effect\n        if(depth > 2.5) {\n          distX1 = distX1 / (1.0-(1.0-cos_yaw)*my_smoothstep(0.0, 0.05, depth-2.5));\n          //distX1 = distX1 / cos_yaw;\n        }\n        //distY1 = distY1 / cos_pitch;\n        float dist = sqrt(distX1 * distX1 + distY1 * distY1);\n        //float dist = distance(ratioTransTargetPoint, centerPoint);\n        if (item[idx] > 1.1) {\n            dist = dist / 1.2;\n        }\n        if (dist < item[idx+4]) {\n            vec2 strengthAdjust = vec2(cos_yaw, 1.0);\n            if(depth < 2.5) {\n                strengthAdjust.x = 1.0-(1.0-cos_yaw)*(1.0-my_smoothstep(0.0, 0.1, 2.5-depth));\n            }\n            float distRatio = dist / item[idx+4];\n            float dx = (centerPoint.x - ratioTransTargetPoint.x) / 1.2;\n            float dy = (centerPoint.y - ratioTransTargetPoint.y) / 1.2;\n            if (item[idx] < 1.1) {\n                dx = dx * 1.2;\n                dy = dy * 1.2;\n                float weight = 1.2 * (1.0 - my_smoothstep(0.0, 1.0, distRatio)) * item[idx+1];\n                dx = dx * weight;\n                dy = dy * weight;\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                newPosition.x -= (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y -= (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 2.1) {\n                float weight = (1.0 - my_smoothstep(0.0, 1.0, distRatio)) * item[idx+1];\n                dx = dx * weight;\n                dy = dy * weight;\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 3.1) {\n                float delta = 1.0 - distRatio*distRatio;\n                float deltaScale = my_smoothstep(0.0, 1.0, delta);\n                float weight = delta * deltaScale * item[idx+4] * 0.5 * item[idx+1];\n                //float weight = (cos(3.1415 * 0.5 * distRatio)) * item[idx+4] * 0.5 * item[idx+1];\n                vec2 vector = vec2(1.0, 1.0);\n                if (item[idx+5] < 1.1) {\n                    vector.x *= -weight; vector.y = 0.0;\n                } else if (item[idx+5] < 2.1) {\n                    vector.x = 0.0; vector.y *= -weight;\n                } else if (item[idx+5] < 3.1) {\n                    vector.x *= weight; vector.y = 0.0;\n                } else if (item[idx+5] < 4.1) {\n                    vector.x = 0.0; vector.y *= weight;\n                } else if (item[idx+5] < 5.1) {\n                    vector.x *= -weight; vector.y *= -weight;\n                } else if (item[idx+5] < 6.1) {\n                    vector.x *= weight; vector.y *= -weight;\n                } else if (item[idx+5] < 7.1) {\n                    vector.x *= -weight; vector.y *= weight;\n                } else if (item[idx+5] < 8.1) {\n                    vector.x *= weight; vector.y *= weight;\n                } else {\n                    vector.x = 0.0; vector.y = 0.0;\n                }\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                vector.y *= 9.0 / 16.0;\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 5.1) {\n                float delta = 1.0 - distRatio*distRatio;\n                float deltaScale = my_smoothstep(0.0, 1.0, delta);\n                float weight = delta * deltaScale * item[idx+4] * 0.5 * item[idx+1];\n                dx = weight*cos(item[idx+5]);\n                dy = weight*sin(item[idx+5]);\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                vector.y *= 9.0 / 16.0;\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            }\n        }\n    }\n    return newPosition;\n}\n\n void main() {\n     vec2 xTexCoord = (textureCoordinate * texMapSize - 0.5) / (texMapSize - 1.0);\n     vec2 position = xTexCoord * 2.0 - 1.0;\n     vec2 trueDiff = vec2(0.0, 0.0);\n\n     vec4 texDiff = texture2D(inputImageTexture, textureCoordinate);\n     trueDiff = (texDiff.xy * 255.0 + texDiff.zw) / 127.5 - 1.0;   //diff of raw\n     if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n        trueDiff = vec2(0.0, 0.0);\n     }\n    \n     vec2 nPosition;\n     vec2 diffPosition;\n     position += trueDiff * 2.0;\n     position.x *= screenRatioY;\n     position.y *= screenRatioX;\n     nPosition = 0.5 * (distortedPosition(position) + vec2(screenRatioY, screenRatioX));\n     diffPosition = (nPosition * vec2(1.0/screenRatioY, 1.0/screenRatioX) - xTexCoord);\n\n     /*if (screenRatio >= 1.0){\n         position.x *= screenRatio;\n         nPosition = 0.5 * (distortedPosition(position) + vec2(screenRatio, 1.0));\n         diffPosition = (nPosition * vec2(1.0 / screenRatio, 1.0) - xTexCoord) + trueDiff;\n     } else {\n         position.y /= screenRatio;\n         nPosition = 0.5 * (distortedPosition(position) + vec2(1.0, 1.0 / screenRatio));\n         diffPosition = (nPosition * vec2(1.0, screenRatio) - xTexCoord) + trueDiff;\n     }*/\n     \n     diffPosition = 0.5 * (diffPosition + 1.0) * 255.0;\n     vec2 a = floor(diffPosition) / 255.0;\n     vec2 b = fract(diffPosition);\n\n     gl_FragColor = vec4(a,b);\n }");
    this.mFaceMeshItem = paramFaceMeshItem;
    this.dataPath = paramString;
    this.items = EMPTY;
    setRenderMode(1);
    initParams();
  }
  
  public TransformFilter_new(List<DistortionItem> paramList, List<StickerItem> paramList1)
  {
    super("precision highp float;\n attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate      = inputTextureCoordinate.xy;\n }", "precision highp float;\n uniform sampler2D inputImageTexture;\n varying vec2 textureCoordinate;\n\n \n uniform float item[210];\n uniform float cos_roll;\n uniform float sin_roll;\n uniform float cos_yaw;\n uniform float tan_yaw;\n uniform float tan_pitch;\nuniform float screenRatioX;\nuniform float screenRatioY;\nuniform vec2 texMapSize;\n\n //30 * 7, type, strength, pointX, pointY, radius, direction, depth\n\n float my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nvec2 distortedPosition(vec2 currentPosition) {\n    vec2 newPosition = currentPosition;\n    //if (newPosition.x <= -0.98 || newPosition.y <= -0.98 || newPosition.x >= 0.98 || newPosition.y >= 0.98) {\n    //    return newPosition;\n    //}\n    for (int i = 0; i < 30; i++) {\n        int idx = i * 7;\n        if (item[idx] < 0.1) {\n            continue;\n        }\n\n        vec2 centerPoint = vec2(item[idx+2], item[idx+3]);\n        vec2 ratioTransTargetPoint = vec2(newPosition.x * screenRatioX, newPosition.y * screenRatioY);\n\n        vec2 distVector = ratioTransTargetPoint - centerPoint;\n        // first, rotate vector by face roll\n        vec2 _v = vec2(distVector.x*cos_roll+distVector.y*sin_roll, -distVector.x*sin_roll+distVector.y*cos_roll);\n        float distX0 = abs(_v.x);\n        float distY0 = abs(_v.y);\n        float ddist = sqrt(distX0 * distX0 + distY0 * distY0);\n        if (ddist * 0.5 > item[idx+4]) continue;\n\n        // second, remove perspective effect\n        float d = _v.x * tan_yaw;\n        float d2 = _v.y * tan_pitch;\n\n        float depth = item[idx+6] + d;\n        if(depth <= 0.0) {\n            continue;\n        }\n        depth = clamp(depth, 1.0, 5.0);\n        float distX1 = distX0 * (depth / item[idx+6]);\n        float distY1 = distY0 * (depth / item[idx+6]);\n        // third, remove yaw and pitch effect\n        if(depth > 2.5) {\n          distX1 = distX1 / (1.0-(1.0-cos_yaw)*my_smoothstep(0.0, 0.05, depth-2.5));\n          //distX1 = distX1 / cos_yaw;\n        }\n        //distY1 = distY1 / cos_pitch;\n        float dist = sqrt(distX1 * distX1 + distY1 * distY1);\n        //float dist = distance(ratioTransTargetPoint, centerPoint);\n        if (item[idx] > 1.1) {\n            dist = dist / 1.2;\n        }\n        if (dist < item[idx+4]) {\n            vec2 strengthAdjust = vec2(cos_yaw, 1.0);\n            if(depth < 2.5) {\n                strengthAdjust.x = 1.0-(1.0-cos_yaw)*(1.0-my_smoothstep(0.0, 0.1, 2.5-depth));\n            }\n            float distRatio = dist / item[idx+4];\n            float dx = (centerPoint.x - ratioTransTargetPoint.x) / 1.2;\n            float dy = (centerPoint.y - ratioTransTargetPoint.y) / 1.2;\n            if (item[idx] < 1.1) {\n                dx = dx * 1.2;\n                dy = dy * 1.2;\n                float weight = 1.2 * (1.0 - my_smoothstep(0.0, 1.0, distRatio)) * item[idx+1];\n                dx = dx * weight;\n                dy = dy * weight;\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                newPosition.x -= (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y -= (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 2.1) {\n                float weight = (1.0 - my_smoothstep(0.0, 1.0, distRatio)) * item[idx+1];\n                dx = dx * weight;\n                dy = dy * weight;\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 3.1) {\n                float delta = 1.0 - distRatio*distRatio;\n                float deltaScale = my_smoothstep(0.0, 1.0, delta);\n                float weight = delta * deltaScale * item[idx+4] * 0.5 * item[idx+1];\n                //float weight = (cos(3.1415 * 0.5 * distRatio)) * item[idx+4] * 0.5 * item[idx+1];\n                vec2 vector = vec2(1.0, 1.0);\n                if (item[idx+5] < 1.1) {\n                    vector.x *= -weight; vector.y = 0.0;\n                } else if (item[idx+5] < 2.1) {\n                    vector.x = 0.0; vector.y *= -weight;\n                } else if (item[idx+5] < 3.1) {\n                    vector.x *= weight; vector.y = 0.0;\n                } else if (item[idx+5] < 4.1) {\n                    vector.x = 0.0; vector.y *= weight;\n                } else if (item[idx+5] < 5.1) {\n                    vector.x *= -weight; vector.y *= -weight;\n                } else if (item[idx+5] < 6.1) {\n                    vector.x *= weight; vector.y *= -weight;\n                } else if (item[idx+5] < 7.1) {\n                    vector.x *= -weight; vector.y *= weight;\n                } else if (item[idx+5] < 8.1) {\n                    vector.x *= weight; vector.y *= weight;\n                } else {\n                    vector.x = 0.0; vector.y = 0.0;\n                }\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                vector.y *= 9.0 / 16.0;\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            } else if (item[idx] < 5.1) {\n                float delta = 1.0 - distRatio*distRatio;\n                float deltaScale = my_smoothstep(0.0, 1.0, delta);\n                float weight = delta * deltaScale * item[idx+4] * 0.5 * item[idx+1];\n                dx = weight*cos(item[idx+5]);\n                dy = weight*sin(item[idx+5]);\n                // rotate\n                vec2 vector = vec2(dx*cos_roll+dy*sin_roll, -dx*sin_roll+dy*cos_roll);\n                // add yaw and pitch\n                vector = vector * strengthAdjust;\n                // rotate back\n                vector.y *= 9.0 / 16.0;\n                newPosition.x += (vector.x * cos_roll - vector.y * sin_roll) / screenRatioX;\n                newPosition.y += (vector.y * cos_roll + vector.x * sin_roll) / screenRatioY;\n            }\n        }\n    }\n    return newPosition;\n}\n\n void main() {\n     vec2 xTexCoord = (textureCoordinate * texMapSize - 0.5) / (texMapSize - 1.0);\n     vec2 position = xTexCoord * 2.0 - 1.0;\n     vec2 trueDiff = vec2(0.0, 0.0);\n\n     vec4 texDiff = texture2D(inputImageTexture, textureCoordinate);\n     trueDiff = (texDiff.xy * 255.0 + texDiff.zw) / 127.5 - 1.0;   //diff of raw\n     if ((trueDiff.x < -0.9 && trueDiff.y < -0.9) || (trueDiff.x > 0.9 && trueDiff.y > 0.9)){\n        trueDiff = vec2(0.0, 0.0);\n     }\n    \n     vec2 nPosition;\n     vec2 diffPosition;\n     position += trueDiff * 2.0;\n     position.x *= screenRatioY;\n     position.y *= screenRatioX;\n     nPosition = 0.5 * (distortedPosition(position) + vec2(screenRatioY, screenRatioX));\n     diffPosition = (nPosition * vec2(1.0/screenRatioY, 1.0/screenRatioX) - xTexCoord);\n\n     /*if (screenRatio >= 1.0){\n         position.x *= screenRatio;\n         nPosition = 0.5 * (distortedPosition(position) + vec2(screenRatio, 1.0));\n         diffPosition = (nPosition * vec2(1.0 / screenRatio, 1.0) - xTexCoord) + trueDiff;\n     } else {\n         position.y /= screenRatio;\n         nPosition = 0.5 * (distortedPosition(position) + vec2(1.0, 1.0 / screenRatio));\n         diffPosition = (nPosition * vec2(1.0, screenRatio) - xTexCoord) + trueDiff;\n     }*/\n     \n     diffPosition = 0.5 * (diffPosition + 1.0) * 255.0;\n     vec2 a = floor(diffPosition) / 255.0;\n     vec2 b = fract(diffPosition);\n\n     gl_FragColor = vec4(a,b);\n }");
    this.items = paramList;
    this.stickerItems = paramList1;
    setRenderMode(1);
    initParams();
  }
  
  private List<DistortionItem> getNextFrame(int paramInt)
  {
    String str = this.mFaceMeshItem.id + "_" + paramInt;
    ArrayList localArrayList;
    if (!this.mMeshCache.containsKey(str))
    {
      localArrayList = new ArrayList();
      Object localObject = FileUtils.load(AEModule.getContext(), this.dataPath + "/" + this.mFaceMeshItem.id, str + ".json");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = GsonUtils.optJsonArray(GsonUtils.json2JsonObject((String)localObject), VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
          if (localObject != null)
          {
            paramInt = 0;
            while (paramInt < ((JsonArray)localObject).size())
            {
              DistortionItem localDistortionItem = new DistortionItem();
              JsonObject localJsonObject = ((JsonArray)localObject).get(paramInt).getAsJsonObject();
              localDistortionItem.position = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
              localDistortionItem.distortion = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
              localDistortionItem.direction = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
              localDistortionItem.radius = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
              localDistortionItem.strength = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
              localDistortionItem.x = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
              localDistortionItem.y = GsonUtils.optInt(localJsonObject, VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
              localArrayList.add(localDistortionItem);
              paramInt += 1;
            }
          }
          this.mMeshCache.put(str, localArrayList);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return (List)this.mMeshCache.get(str);
  }
  
  private float getStrengthAdjust(int paramInt)
  {
    if (DeviceInstance.getInstance().isOppoX909Device()) {}
    for (float f1 = 0.2F;; f1 = 1.0F)
    {
      float f2 = f1;
      if (this.optimizeBoundary)
      {
        f2 = f1;
        if (this.faceWidth > 0.0F)
        {
          f2 = f1;
          if (this.width > 0)
          {
            f2 = f1;
            if (this.mFaceDetScale > 0.0D)
            {
              float f4 = this.faceWidth;
              float f5 = this.optimizeBoundaryStrength;
              f2 = this.width * (float)this.mFaceDetScale;
              float f3 = this.height * (float)this.mFaceDetScale;
              float f6 = Math.min(f2, f3);
              f4 = Math.min(0.15F * f6, Math.min(f4 * f5, f6 * this.meshs[paramInt].radius));
              f2 = f1 * (1.0F - 0.9F + Math.min(Math.min(Math.min(1.0F, Math.max(0.0F, (this.meshs[paramInt].point.x + this.meshs[paramInt].offsetX) / f4)), Math.min(1.0F, Math.max(0.0F, (f2 - this.meshs[paramInt].point.x - this.meshs[paramInt].offsetX) / f4))), Math.min(Math.min(1.0F, Math.max(0.0F, (this.meshs[paramInt].point.y + this.meshs[paramInt].offsetY) / f4)), Math.min(1.0F, Math.max(0.0F, (f3 - this.meshs[paramInt].point.y - this.meshs[paramInt].offsetY) / f4)))) * 0.9F);
            }
          }
        }
      }
      return f2;
    }
  }
  
  private void updateMeshParam()
  {
    int i = this.frameIdx;
    if (i == this.mLastMeshIndex) {
      return;
    }
    this.items = getNextFrame(i);
    this.mLastMeshIndex = i;
  }
  
  private float yawPitchStrengthAdjust(float paramFloat1, float paramFloat2, int paramInt)
  {
    float f2 = 1.0F;
    float f1;
    if ((paramFloat1 >= -0.6D) || (!leftFacePoints.contains(Integer.valueOf(paramInt))))
    {
      f1 = f2;
      if (paramFloat1 > 0.6D)
      {
        f1 = f2;
        if (!rightFacePoints.contains(Integer.valueOf(paramInt))) {}
      }
    }
    else
    {
      f1 = (float)(1.0F * Math.min(1.0D - this.strengthAdjust * (Math.abs(paramFloat1) - 0.6D), 1.0D));
    }
    paramFloat1 = f1;
    if (paramFloat2 < -0.6D)
    {
      paramFloat1 = f1;
      if (chinFacePoints.contains(Integer.valueOf(paramInt))) {
        paramFloat1 = (float)(f1 * Math.min(1.0D - 0.7D * this.strengthAdjust * (Math.abs(paramFloat2) - 0.6D), 1.0D));
      }
    }
    return paramFloat1;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
  }
  
  public FaceMeshItem getFaceMeshItem()
  {
    return this.mFaceMeshItem;
  }
  
  public void initAttribParams()
  {
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(8257);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("screenRatioX", 0.0F));
    addParam(new UniformParam.FloatParam("screenRatioY", 0.0F));
    addParam(new UniformParam.Float1sParam("item", this.flatMesh));
    addParam(new UniformParam.FloatParam("faceRatio", 1.0F));
    addParam(new UniformParam.FloatParam("sin_roll", 0.0F));
    addParam(new UniformParam.FloatParam("cos_roll", 0.0F));
    addParam(new UniformParam.FloatParam("tan_yaw", 0.0F));
    addParam(new UniformParam.FloatParam("cos_yaw", 0.0F));
    addParam(new UniformParam.FloatParam("tan_pitch", 0.0F));
    addParam(new UniformParam.FloatParam("cos_pitch", 0.0F));
    addParam(new UniformParam.FloatsParam("texMapSize", this.texMapSize));
    int i = 0;
    while (i < 30)
    {
      this.meshs[i] = new MeshDistortionType();
      i += 1;
    }
  }
  
  public void reset() {}
  
  public void setDistortionItems(List<DistortionItem> paramList)
  {
    this.items = paramList;
  }
  
  public void setOptimizeBoundary(boolean paramBoolean)
  {
    this.optimizeBoundary = paramBoolean;
  }
  
  public void updateFaceFeatures(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 131)) {
      return;
    }
    float f1 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
    float f2 = ((PointF)paramList.get(18)).y - ((PointF)paramList.get(0)).y;
    float f3 = ((PointF)paramList.get(9)).x - ((PointF)paramList.get(89)).x;
    float f4 = ((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y;
    this.faceWidth = ((float)Math.sqrt(f1 * f1 + f2 * f2));
    this.faceHeight = ((float)Math.sqrt(f4 * f4 + f3 * f3));
    f1 = this.faceHeight / this.faceWidth;
    f2 = ((PointF)paramList.get(9)).x;
    f3 = ((PointF)paramList.get(84)).x;
    f4 = -((PointF)paramList.get(9)).y;
    float f5 = ((PointF)paramList.get(84)).y;
    f2 = (float)(Math.atan2(f2 - f3, f5 + f4) + 3.141592653589793D);
    f3 = this.height / this.width;
    f4 = (float)(2.0D / (this.width * this.mFaceDetScale));
    f5 = (float)(2.0D / (this.height * this.mFaceDetScale));
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    PointF localPointF3 = new PointF();
    int i = 0;
    label354:
    if (i < 131) {
      if ((i < 99) || (i > 106)) {
        break label385;
      }
    }
    for (;;)
    {
      i += 1;
      break label354;
      break;
      label385:
      localPointF1.x = (((PointF)paramList.get(i)).x * f4 - 1.0F);
      localPointF1.y = (((PointF)paramList.get(i)).y * f5 - 1.0F);
      int j = 0;
      if (j < this.meshs.length)
      {
        if (this.meshs[j].type <= 0) {}
        float f8;
        float f7;
        label789:
        do
        {
          for (;;)
          {
            j += 1;
            break;
            localPointF2.x = ((this.meshs[j].point.x + this.meshs[j].offsetX) * f4 - 1.0F);
            localPointF2.y = (((this.meshs[j].point.y + this.meshs[j].offsetY) * f5 - 1.0F) * f3);
            localPointF3.x = localPointF1.x;
            localPointF1.y *= f3;
            f6 = AlgoUtils.getDistance(localPointF2, localPointF3);
            if (f6 < this.meshs[j].radius)
            {
              f8 = f6 / this.meshs[j].radius;
              f6 = localPointF2.x - localPointF3.x;
              f7 = (localPointF2.y - localPointF3.y) / f3;
              if (this.meshs[j].type == 1)
              {
                f8 = (float)(1.5D * (1.0D - Math.sin(f8 * 3.1415D * 0.5D)) * this.meshs[j].strength);
                localPointF1.x -= f6 * f8;
                localPointF1.y -= f8 * f7;
              }
              else
              {
                if (this.meshs[j].type != 2) {
                  break label789;
                }
                f8 = (float)(Math.cos(1.57075D * f8) * this.meshs[j].strength);
                localPointF1.x = (f6 * f8 + localPointF1.x);
                localPointF1.y = (f8 * f7 + localPointF1.y);
              }
            }
          }
        } while (this.meshs[j].type != 3);
        float f6 = (float)(Math.cos(f8 * 1.57075D) * this.meshs[j].radius * 0.5D / f1 * this.meshs[j].strength);
        PointF localPointF4 = new PointF(f1, f1 / f3);
        if (this.meshs[j].direction == 1.0F)
        {
          f7 = localPointF4.x;
          localPointF4.x = (-f6 * f7);
          localPointF4.y = 0.0F;
        }
        for (;;)
        {
          localPointF1.x = ((float)(localPointF1.x + (localPointF4.x * Math.cos(f2) - localPointF4.y * Math.sin(f2))));
          double d1 = localPointF1.y;
          double d2 = localPointF4.y;
          double d3 = Math.cos(f2);
          localPointF1.y = ((float)((localPointF4.x * Math.sin(f2) + d2 * d3) / f3 + d1));
          break;
          if (this.meshs[j].direction == 2.0F)
          {
            localPointF4.x = 0.0F;
            f7 = localPointF4.y;
            localPointF4.y = (-f6 * f7);
          }
          else if (this.meshs[j].direction == 3.0F)
          {
            localPointF4.x = (f6 * localPointF4.x);
            localPointF4.y = 0.0F;
          }
          else if (this.meshs[j].direction == 4.0F)
          {
            localPointF4.x = 0.0F;
            localPointF4.y = (f6 * localPointF4.y);
          }
          else if (this.meshs[j].direction == 5.0F)
          {
            localPointF4.x *= -f6;
            f7 = localPointF4.y;
            localPointF4.y = (-f6 * f7);
          }
          else if (this.meshs[j].direction == 6.0F)
          {
            localPointF4.x *= f6;
            f7 = localPointF4.y;
            localPointF4.y = (-f6 * f7);
          }
          else if (this.meshs[j].direction == 7.0F)
          {
            localPointF4.x *= -f6;
            localPointF4.y = (f6 * localPointF4.y);
          }
          else if (this.meshs[j].direction == 8.0F)
          {
            localPointF4.x *= f6;
            localPointF4.y = (f6 * localPointF4.y);
          }
          else
          {
            localPointF4.x = 0.0F;
            localPointF4.y = 0.0F;
          }
        }
      }
      ((PointF)paramList.get(i)).x = ((localPointF1.x + 1.0F) / f4);
      ((PointF)paramList.get(i)).y = ((localPointF1.y + 1.0F) / f5);
    }
  }
  
  public void updateParams(List<PointF> paramList, Set<Integer> paramSet, double paramDouble, float[] paramArrayOfFloat)
  {
    Object localObject = VideoMaterialUtil.copyList(paramList);
    Arrays.fill(this.flatMesh, -1.0F);
    if ((localObject == null) || (((List)localObject).size() < 90) || (CollectionUtils.isEmpty(this.items)) || (!VideoFilterUtil.actionTriggered(paramList, this.stickerItems, paramSet))) {
      addParam(new UniformParam.FloatParam("faceRatio", 1.0F));
    }
    for (;;)
    {
      addParam(new UniformParam.Float1sParam("item", this.flatMesh));
      return;
      List localList = TransformUtil.getFullPoints((List)localObject);
      float f1 = ((PointF)localList.get(18)).x - ((PointF)localList.get(0)).x;
      float f2 = ((PointF)localList.get(18)).y - ((PointF)localList.get(0)).y;
      float f3 = ((PointF)localList.get(9)).x - ((PointF)localList.get(89)).x;
      float f4 = ((PointF)localList.get(9)).y - ((PointF)localList.get(89)).y;
      this.faceWidth = ((float)Math.sqrt(f1 * f1 + f2 * f2));
      this.faceHeight = ((float)Math.sqrt(f4 * f4 + f3 * f3));
      f3 = this.faceHeight / this.faceWidth;
      f1 = ((PointF)localList.get(9)).x;
      f2 = ((PointF)localList.get(84)).x;
      f4 = -((PointF)localList.get(9)).y;
      float f5 = ((PointF)localList.get(84)).y;
      f4 = (float)(Math.atan2(f1 - f2, f5 + f4) + 3.141592653589793D);
      paramList = new PointF((float)(((PointF)localList.get(9)).x * 2.0F / paramDouble / this.width - 1.0D), (float)(((PointF)localList.get(9)).y * 2.0F / paramDouble / this.height - 1.0D) * this.height / this.width);
      paramSet = new PointF((float)(((PointF)localList.get(89)).x * 2.0F / paramDouble / this.width - 1.0D), (float)(((PointF)localList.get(89)).y * 2.0F / paramDouble / this.height - 1.0D) * this.height / this.width);
      f5 = AlgoUtils.getDistance(paramList, paramSet);
      float f6 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat[1] * 1.5D));
      float f7 = (float)Math.tan(f6);
      f1 = (float)Math.cos(f6);
      f2 = ((PointF)localList.get(43)).x;
      float f8 = (((PointF)localList.get(9)).x - ((PointF)localList.get(43)).x) / 3.0F;
      float f9 = ((PointF)localList.get(43)).y;
      localObject = new PointF(f2 + f8, (((PointF)localList.get(9)).y - ((PointF)localList.get(43)).y) / 3.0F + f9);
      ((PointF)localObject).x = ((float)(2.0F * ((PointF)localObject).x / paramDouble / this.width - 1.0D));
      ((PointF)localObject).y = ((float)(2.0F * ((PointF)localObject).y / paramDouble / this.height - 1.0D) * this.height / this.width);
      f2 = ((PointF)localList.get(53)).x;
      f8 = (((PointF)localList.get(9)).x - ((PointF)localList.get(53)).x) / 3.0F;
      f9 = ((PointF)localList.get(53)).y;
      PointF localPointF1 = new PointF(f2 + f8, (((PointF)localList.get(9)).y - ((PointF)localList.get(53)).y) / 3.0F + f9);
      localPointF1.x = ((float)(2.0F * localPointF1.x / paramDouble / this.width - 1.0D));
      localPointF1.y = ((float)(2.0F * localPointF1.y / paramDouble / this.height - 1.0D) * this.height / this.width);
      f8 = AlgoUtils.getDistance((PointF)localObject, localPointF1);
      f9 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat[0] * 1.4D));
      float f10 = (float)Math.tan(f9);
      f2 = (float)Math.cos(f9);
      float f11 = (float)Math.cos(f4);
      float f12 = (float)Math.sin(f4);
      int j = localList.size();
      int i = 0;
      float f13;
      float f14;
      while (i < this.items.size())
      {
        paramArrayOfFloat = (DistortionItem)this.items.get(i);
        this.meshs[i].type = paramArrayOfFloat.distortion;
        if (paramArrayOfFloat.position < j) {
          this.meshs[i].point = ((PointF)localList.get(paramArrayOfFloat.position));
        }
        f13 = getStrengthAdjust(i);
        this.meshs[i].strength = (f13 * paramArrayOfFloat.strength * yawPitchStrengthAdjust(f7, f10, paramArrayOfFloat.position));
        this.meshs[i].radius = ((float)(paramArrayOfFloat.radius * this.faceWidth / paramDouble / Math.min(this.width, this.height) / 375.0D));
        f13 = paramArrayOfFloat.x * f1;
        f14 = paramArrayOfFloat.y * f2;
        this.meshs[i].offsetX = ((f13 * f11 + f14 * f12) * this.faceWidth / 375.0F);
        this.meshs[i].offsetY = ((f13 * f12 - f14 * f11) * this.faceWidth / 375.0F);
        this.meshs[i].direction = paramArrayOfFloat.direction;
        if ((paramArrayOfFloat.distortion == 4) || (paramArrayOfFloat.distortion == 5))
        {
          PointF localPointF2 = (PointF)localList.get(paramArrayOfFloat.direction);
          f13 = (paramArrayOfFloat.targetDx * f11 * f1 + paramArrayOfFloat.targetDy * f12 * f2) * this.faceWidth / 375.0F;
          f14 = (paramArrayOfFloat.targetDx * f12 * f1 - paramArrayOfFloat.targetDy * f11 * f2) * this.faceWidth / 375.0F;
          this.meshs[i].direction = ((float)Math.atan2(f14 + localPointF2.y - this.meshs[i].point.y - this.meshs[i].offsetY, localPointF2.x + f13 - this.meshs[i].point.x - this.meshs[i].offsetX));
          if (paramArrayOfFloat.distortion == 5) {
            this.meshs[i].direction = (3.141593F + this.meshs[i].direction);
          }
        }
        this.meshs[i].faceDegree = f4;
        this.meshs[i].faceRatio = f3;
        i += 1;
      }
      i = this.items.size();
      while (i < 30)
      {
        this.meshs[i].type = -1;
        i += 1;
      }
      j = 0;
      i = 0;
      while (i < this.items.size())
      {
        paramArrayOfFloat = this.flatMesh;
        int k = j + 1;
        paramArrayOfFloat[j] = this.meshs[i].type;
        paramArrayOfFloat = this.flatMesh;
        j = k + 1;
        paramArrayOfFloat[k] = this.meshs[i].strength;
        f11 = (float)(2.0F * (this.meshs[i].point.x + this.meshs[i].offsetX) / paramDouble / this.width - 1.0D);
        f12 = (float)(2.0F * (this.meshs[i].point.y + this.meshs[i].offsetY) / paramDouble / this.height - 1.0D);
        paramArrayOfFloat = this.flatMesh;
        k = j + 1;
        paramArrayOfFloat[j] = (this.screenRatioX * f11);
        paramArrayOfFloat = this.flatMesh;
        j = k + 1;
        paramArrayOfFloat[k] = (this.screenRatioY * f12);
        f2 = AlgoUtils.distanceOfPoint2Line(paramList, paramSet, f5, new PointF(f11, this.height * f12 / this.width)) * f7;
        f1 = f2;
        if ((paramList.x - paramSet.x) * (f12 - paramSet.y) - (paramList.y - paramSet.y) * (f11 - paramSet.x) > 0.0F) {
          f1 = -f2;
        }
        f2 = AlgoUtils.distanceOfPoint2Line((PointF)localObject, localPointF1, f8, new PointF(f11, this.height * f12 / this.width));
        f13 = ((PointF)localObject).x;
        f14 = localPointF1.x;
        float f15 = localPointF1.y;
        float f16 = ((PointF)localObject).y;
        float f17 = localPointF1.y;
        if ((f12 - f15) * (f13 - f14) - (f11 - localPointF1.x) * (f16 - f17) > 0.0F) {
          f2 = -(f2 * f10);
        }
        f1 = 2.5F + f1;
        this.meshs[i].radius = (this.meshs[i].radius * 2.5F / f1);
        paramArrayOfFloat = this.flatMesh;
        k = j + 1;
        paramArrayOfFloat[j] = this.meshs[i].radius;
        paramArrayOfFloat = this.flatMesh;
        int m = k + 1;
        paramArrayOfFloat[k] = this.meshs[i].direction;
        paramArrayOfFloat = this.flatMesh;
        j = m + 1;
        paramArrayOfFloat[m] = f1;
        i += 1;
      }
      addParam(new UniformParam.FloatParam("faceRatio", f3));
      addParam(new UniformParam.FloatParam("sin_roll", (float)Math.sin(f4)));
      addParam(new UniformParam.FloatParam("cos_roll", (float)Math.cos(f4)));
      addParam(new UniformParam.FloatParam("tan_yaw", (float)Math.tan(f6)));
      addParam(new UniformParam.FloatParam("cos_yaw", (float)Math.cos(f6)));
      addParam(new UniformParam.FloatParam("tan_pitch", (float)Math.tan(f9)));
      addParam(new UniformParam.FloatParam("cos_pitch", (float)Math.cos(f9)));
      addParam(new UniformParam.FloatsParam("texMapSize", new float[] { 65.0F, 65.0F }));
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    PTDetectInfo localPTDetectInfo;
    if ((paramObject instanceof PTDetectInfo))
    {
      localPTDetectInfo = (PTDetectInfo)paramObject;
      paramObject = localPTDetectInfo.faceAngles;
      if ((localPTDetectInfo.phoneAngle == 90.0F) || (localPTDetectInfo.phoneAngle == 270.0F))
      {
        paramObject = new float[3];
        paramObject[0] = (-localPTDetectInfo.faceAngles[1]);
        paramObject[1] = (-localPTDetectInfo.faceAngles[0]);
        paramObject[2] = localPTDetectInfo.faceAngles[2];
      }
      this.frameIdx = localPTDetectInfo.frameIndex;
      if (this.dataPath != null)
      {
        if ((localPTDetectInfo.facePoints != null) && (localPTDetectInfo.facePoints.size() > 0)) {
          break label136;
        }
        this.items = EMPTY;
        this.mLastMeshIndex = -1;
      }
    }
    for (;;)
    {
      updateParams(localPTDetectInfo.facePoints, localPTDetectInfo.triggeredExpression, this.mFaceDetScale, paramObject);
      return;
      label136:
      updateMeshParam();
    }
  }
  
  public void updateStrength(float paramFloat)
  {
    this.anotherStrength = paramFloat;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    float f3 = 1.0F;
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    float f2 = this.height / this.width;
    if (f2 > 1.0F) {}
    for (float f1 = 1.0F;; f1 = 1.0F / f2)
    {
      this.screenRatioX = f1;
      f1 = f3;
      if (f2 > 1.0F) {
        f1 = f2;
      }
      this.screenRatioY = f1;
      addParam(new UniformParam.FloatParam("screenRatioX", this.screenRatioX));
      addParam(new UniformParam.FloatParam("screenRatioY", this.screenRatioY));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransformFilter_new
 * JD-Core Version:    0.7.0.1
 */