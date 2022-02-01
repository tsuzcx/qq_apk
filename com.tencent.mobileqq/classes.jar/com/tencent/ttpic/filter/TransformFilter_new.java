package com.tencent.ttpic.filter;

import android.content.Context;
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
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.openapi.model.VideoMaterial.FIELD;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.ttpic.util.TransformUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Set<Ljava.lang.Integer;>;

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
  private static final List<Integer> chinFacePoints;
  private static final List<Integer> leftFacePoints;
  private static List<PointF> mFullscreenVerticesPortrait = VideoMaterial.genFullScreenVertices(64, 64, -1.0F, 1.0F, -1.0F, 1.0F);
  private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterial.genFullScreenVertices(64, 64, 0.0F, 1.0F, 0.0F, 1.0F);
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
    Integer localInteger1 = Integer.valueOf(4);
    Integer localInteger2 = Integer.valueOf(5);
    Integer localInteger3 = Integer.valueOf(6);
    Integer localInteger4 = Integer.valueOf(7);
    Integer localInteger5 = Integer.valueOf(8);
    leftFacePoints = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), localInteger1, localInteger2, localInteger3, localInteger4, localInteger5 });
    Integer localInteger6 = Integer.valueOf(10);
    Integer localInteger7 = Integer.valueOf(11);
    rightFacePoints = Arrays.asList(new Integer[] { localInteger6, localInteger7, Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18) });
    chinFacePoints = Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3, localInteger4, localInteger5, Integer.valueOf(9), localInteger6, localInteger7, Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14) });
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mFaceMeshItem.id);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    ArrayList localArrayList;
    if (!this.mMeshCache.containsKey(localObject1))
    {
      localArrayList = new ArrayList();
      Object localObject2 = AEModule.getContext();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.dataPath);
      ((StringBuilder)localObject3).append("/");
      ((StringBuilder)localObject3).append(this.mFaceMeshItem.id);
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(".json");
      localObject2 = FileUtils.load((Context)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        try
        {
          localObject2 = GsonUtils.optJsonArray(GsonUtils.json2JsonObject((String)localObject2), VideoMaterial.FIELD.DISTORTION_LIST.value);
          if (localObject2 != null)
          {
            paramInt = 0;
            while (paramInt < ((JsonArray)localObject2).size())
            {
              localObject3 = new DistortionItem();
              localObject4 = ((JsonArray)localObject2).get(paramInt).getAsJsonObject();
              ((DistortionItem)localObject3).position = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.POSITION.value);
              ((DistortionItem)localObject3).distortion = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.DISTORTION.value);
              ((DistortionItem)localObject3).direction = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.DIRECTION.value);
              ((DistortionItem)localObject3).radius = ((float)GsonUtils.optDouble((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.RADIUS.value));
              ((DistortionItem)localObject3).strength = ((float)GsonUtils.optDouble((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.STRENGH.value));
              ((DistortionItem)localObject3).x = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.X.value);
              ((DistortionItem)localObject3).y = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.Y.value);
              localArrayList.add(localObject3);
              paramInt += 1;
            }
          }
          this.mMeshCache.put(localObject1, localArrayList);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return (List)this.mMeshCache.get(localObject1);
  }
  
  private float getStrengthAdjust(int paramInt)
  {
    float f1;
    if (DeviceInstance.getInstance().isOppoX909Device()) {
      f1 = 0.2F;
    } else {
      f1 = 1.0F;
    }
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
            f4 = Math.min(0.15F * f6, Math.min(f4 * f5, this.meshs[paramInt].radius * f6));
            f2 = f1 * (0.1F + Math.min(Math.min(Math.min(1.0F, Math.max(0.0F, (this.meshs[paramInt].point.x + this.meshs[paramInt].offsetX) / f4)), Math.min(1.0F, Math.max(0.0F, (f2 - this.meshs[paramInt].point.x - this.meshs[paramInt].offsetX) / f4))), Math.min(Math.min(1.0F, Math.max(0.0F, (this.meshs[paramInt].point.y + this.meshs[paramInt].offsetY) / f4)), Math.min(1.0F, Math.max(0.0F, (f3 - this.meshs[paramInt].point.y - this.meshs[paramInt].offsetY) / f4)))) * 0.9F);
          }
        }
      }
    }
    return f2;
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
    double d1 = paramFloat1;
    float f2 = 1.0F;
    float f1;
    double d2;
    double d3;
    if ((d1 >= -0.6D) || (!leftFacePoints.contains(Integer.valueOf(paramInt))))
    {
      f1 = f2;
      if (d1 > 0.6D)
      {
        f1 = f2;
        if (!rightFacePoints.contains(Integer.valueOf(paramInt))) {}
      }
    }
    else
    {
      d1 = 1.0F;
      d2 = this.strengthAdjust;
      d3 = Math.abs(paramFloat1);
      Double.isNaN(d3);
      Double.isNaN(d2);
      d2 = Math.min(1.0D - d2 * (d3 - 0.6D), 1.0D);
      Double.isNaN(d1);
      f1 = (float)(d1 * d2);
    }
    paramFloat1 = f1;
    if (paramFloat2 < -0.6D)
    {
      paramFloat1 = f1;
      if (chinFacePoints.contains(Integer.valueOf(paramInt)))
      {
        d1 = f1;
        d2 = this.strengthAdjust;
        Double.isNaN(d2);
        d3 = Math.abs(paramFloat2);
        Double.isNaN(d3);
        d2 = Math.min(1.0D - d2 * 0.7D * (d3 - 0.6D), 1.0D);
        Double.isNaN(d1);
        paramFloat1 = (float)(d1 * d2);
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
    setPositions(VideoMaterial.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterial.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
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
    Object localObject1 = this;
    if (paramList != null)
    {
      if (paramList.size() < 131) {
        return;
      }
      float f1 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
      float f2 = ((PointF)paramList.get(18)).y - ((PointF)paramList.get(0)).y;
      float f3 = ((PointF)paramList.get(9)).x - ((PointF)paramList.get(89)).x;
      float f4 = ((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y;
      ((TransformFilter_new)localObject1).faceWidth = ((float)Math.sqrt(f1 * f1 + f2 * f2));
      ((TransformFilter_new)localObject1).faceHeight = ((float)Math.sqrt(f3 * f3 + f4 * f4));
      f1 = ((TransformFilter_new)localObject1).faceHeight / ((TransformFilter_new)localObject1).faceWidth;
      f2 = ((PointF)paramList.get(9)).x;
      f3 = ((PointF)paramList.get(84)).x;
      f4 = -((PointF)paramList.get(9)).y;
      float f5 = ((PointF)paramList.get(84)).y;
      f5 = (float)(Math.atan2(f2 - f3, f4 + f5) + 3.141592653589793D);
      float f6 = ((TransformFilter_new)localObject1).height / ((TransformFilter_new)localObject1).width;
      double d1 = ((TransformFilter_new)localObject1).width;
      double d2 = ((TransformFilter_new)localObject1).mFaceDetScale;
      Double.isNaN(d1);
      f2 = (float)(2.0D / (d1 * d2));
      d1 = ((TransformFilter_new)localObject1).height;
      d2 = ((TransformFilter_new)localObject1).mFaceDetScale;
      Double.isNaN(d1);
      f3 = (float)(2.0D / (d1 * d2));
      PointF localPointF = new PointF();
      Object localObject2 = new PointF();
      localObject1 = new PointF();
      int i = 0;
      while (i < 131)
      {
        if ((i >= 99) && (i <= 106))
        {
          f4 = f3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          f3 = f1;
          localObject1 = localObject3;
          f1 = f4;
        }
        else
        {
          localPointF.x = (((PointF)paramList.get(i)).x * f2 - 1.0F);
          localPointF.y = (((PointF)paramList.get(i)).y * f3 - 1.0F);
          int j = 0;
          for (;;)
          {
            localObject3 = this;
            Object localObject4 = ((TransformFilter_new)localObject3).meshs;
            if (j >= localObject4.length) {
              break;
            }
            if (localObject4[j].type > 0)
            {
              ((PointF)localObject2).x = ((localObject3.meshs[j].point.x + localObject3.meshs[j].offsetX) * f2 - 1.0F);
              ((PointF)localObject2).y = (((localObject3.meshs[j].point.y + localObject3.meshs[j].offsetY) * f3 - 1.0F) * f6);
              ((PointF)localObject1).x = localPointF.x;
              ((PointF)localObject1).y = (localPointF.y * f6);
              f4 = AlgoUtils.getDistance((PointF)localObject2, (PointF)localObject1);
              if (f4 < localObject3.meshs[j].radius)
              {
                float f8 = f4 / localObject3.meshs[j].radius;
                f4 = ((PointF)localObject2).x - ((PointF)localObject1).x;
                float f7 = (((PointF)localObject2).y - ((PointF)localObject1).y) / f6;
                if (localObject3.meshs[j].type == 1)
                {
                  d1 = f8;
                  Double.isNaN(d1);
                  d1 = Math.sin(d1 * 3.1415D * 0.5D);
                  d2 = localObject3.meshs[j].strength;
                  Double.isNaN(d2);
                  f8 = (float)(d2 * ((1.0D - d1) * 1.5D));
                  localPointF.x -= f4 * f8;
                  localPointF.y -= f7 * f8;
                }
                for (;;)
                {
                  break;
                  if (localObject3.meshs[j].type == 2)
                  {
                    d1 = f8;
                    Double.isNaN(d1);
                    d1 = Math.cos(d1 * 1.57075D);
                    d2 = localObject3.meshs[j].strength;
                    Double.isNaN(d2);
                    f8 = (float)(d1 * d2);
                    localPointF.x += f4 * f8;
                    localPointF.y += f7 * f8;
                  }
                  else if (localObject3.meshs[j].type == 3)
                  {
                    d1 = f8;
                    Double.isNaN(d1);
                    d1 = Math.cos(d1 * 1.57075D);
                    d2 = localObject3.meshs[j].radius;
                    Double.isNaN(d2);
                    double d3 = f1;
                    Double.isNaN(d3);
                    d1 = d1 * d2 * 0.5D / d3;
                    d2 = localObject3.meshs[j].strength;
                    Double.isNaN(d2);
                    f7 = (float)(d1 * d2);
                    localObject4 = new PointF(f1, f1 / f6);
                    if (localObject3.meshs[j].direction == 1.0F)
                    {
                      ((PointF)localObject4).x *= -f7;
                      ((PointF)localObject4).y = 0.0F;
                    }
                    else if (localObject3.meshs[j].direction == 2.0F)
                    {
                      ((PointF)localObject4).x = 0.0F;
                      ((PointF)localObject4).y *= -f7;
                    }
                    else if (localObject3.meshs[j].direction == 3.0F)
                    {
                      ((PointF)localObject4).x *= f7;
                      ((PointF)localObject4).y = 0.0F;
                    }
                    else if (localObject3.meshs[j].direction == 4.0F)
                    {
                      ((PointF)localObject4).x = 0.0F;
                      ((PointF)localObject4).y *= f7;
                    }
                    else if (localObject3.meshs[j].direction == 5.0F)
                    {
                      f4 = ((PointF)localObject4).x;
                      f7 = -f7;
                      ((PointF)localObject4).x = (f4 * f7);
                      ((PointF)localObject4).y *= f7;
                    }
                    else if (localObject3.meshs[j].direction == 6.0F)
                    {
                      ((PointF)localObject4).x *= f7;
                      ((PointF)localObject4).y *= -f7;
                    }
                    else if (localObject3.meshs[j].direction == 7.0F)
                    {
                      ((PointF)localObject4).x *= -f7;
                      ((PointF)localObject4).y *= f7;
                    }
                    else if (localObject3.meshs[j].direction == 8.0F)
                    {
                      ((PointF)localObject4).x *= f7;
                      ((PointF)localObject4).y *= f7;
                    }
                    else
                    {
                      ((PointF)localObject4).x = 0.0F;
                      ((PointF)localObject4).y = 0.0F;
                    }
                    d2 = localPointF.x;
                    d3 = ((PointF)localObject4).x;
                    d1 = f5;
                    double d4 = Math.cos(d1);
                    Double.isNaN(d3);
                    f4 = ((PointF)localObject4).y;
                    double d5 = f4;
                    double d6 = Math.sin(d1);
                    Double.isNaN(d5);
                    Double.isNaN(d2);
                    localPointF.x = ((float)(d2 + (d3 * d4 - d5 * d6)));
                    d2 = localPointF.y;
                    d3 = ((PointF)localObject4).y;
                    d4 = Math.cos(d1);
                    Double.isNaN(d3);
                    d5 = ((PointF)localObject4).x;
                    d1 = Math.sin(d1);
                    Double.isNaN(d5);
                    d6 = f6;
                    Double.isNaN(d6);
                    d1 = (d3 * d4 + d5 * d1) / d6;
                    Double.isNaN(d2);
                    localPointF.y = ((float)(d2 + d1));
                    break;
                  }
                }
              }
            }
            j += 1;
          }
          f4 = f1;
          f1 = f3;
          localObject3 = localObject1;
          ((PointF)paramList.get(i)).x = ((localPointF.x + 1.0F) / f2);
          ((PointF)paramList.get(i)).y = ((localPointF.y + 1.0F) / f1);
          localObject1 = localObject2;
          f3 = f4;
          localObject2 = localObject3;
        }
        i += 1;
        Object localObject3 = localObject2;
        f4 = f1;
        f1 = f3;
        f3 = f4;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
  }
  
  public void updateParams(List<PointF> paramList, Set<Integer> paramSet, double paramDouble, float[] paramArrayOfFloat)
  {
    Object localObject1 = VideoMaterial.copyList(paramList);
    Arrays.fill(this.flatMesh, -1.0F);
    Object localObject2 = "faceRatio";
    if ((localObject1 != null) && (((List)localObject1).size() >= 90) && (!CollectionUtils.isEmpty(this.items)) && (VideoFilterUtil.actionTriggered(paramList, this.stickerItems, paramSet)))
    {
      Object localObject3 = TransformUtil.getFullPoints((List)localObject1);
      float f1 = ((PointF)((List)localObject3).get(18)).x - ((PointF)((List)localObject3).get(0)).x;
      float f2 = ((PointF)((List)localObject3).get(18)).y - ((PointF)((List)localObject3).get(0)).y;
      float f3 = ((PointF)((List)localObject3).get(9)).x - ((PointF)((List)localObject3).get(89)).x;
      float f4 = ((PointF)((List)localObject3).get(9)).y - ((PointF)((List)localObject3).get(89)).y;
      this.faceWidth = ((float)Math.sqrt(f1 * f1 + f2 * f2));
      this.faceHeight = ((float)Math.sqrt(f3 * f3 + f4 * f4));
      float f6 = this.faceHeight / this.faceWidth;
      f1 = ((PointF)((List)localObject3).get(9)).x;
      f2 = ((PointF)((List)localObject3).get(84)).x;
      f3 = -((PointF)((List)localObject3).get(9)).y;
      f4 = ((PointF)((List)localObject3).get(84)).y;
      float f5 = (float)(Math.atan2(f1 - f2, f3 + f4) + 3.141592653589793D);
      double d1 = ((PointF)((List)localObject3).get(9)).x * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      double d2 = this.width;
      Double.isNaN(d2);
      f1 = (float)(d1 / d2 - 1.0D);
      d1 = ((PointF)((List)localObject3).get(9)).y * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d2 = this.height;
      Double.isNaN(d2);
      paramSet = new PointF(f1, (float)(d1 / d2 - 1.0D) * this.height / this.width);
      d1 = ((PointF)((List)localObject3).get(89)).x * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d2 = this.width;
      Double.isNaN(d2);
      f1 = (float)(d1 / d2 - 1.0D);
      d1 = ((PointF)((List)localObject3).get(89)).y * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d2 = this.height;
      Double.isNaN(d2);
      PointF localPointF = new PointF(f1, (float)(d1 / d2 - 1.0D) * this.height / this.width);
      f2 = AlgoUtils.getDistance(paramSet, localPointF);
      d1 = paramArrayOfFloat[1];
      Double.isNaN(d1);
      d2 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d1 * 1.5D));
      f1 = (float)Math.tan(d2);
      float f7 = (float)Math.cos(d2);
      paramList = new PointF(((PointF)((List)localObject3).get(43)).x + (((PointF)((List)localObject3).get(9)).x - ((PointF)((List)localObject3).get(43)).x) / 3.0F, ((PointF)((List)localObject3).get(43)).y + (((PointF)((List)localObject3).get(9)).y - ((PointF)((List)localObject3).get(43)).y) / 3.0F);
      d1 = paramList.x * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      double d3 = this.width;
      Double.isNaN(d3);
      paramList.x = ((float)(d1 / d3 - 1.0D));
      d1 = paramList.y * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d3 = this.height;
      Double.isNaN(d3);
      paramList.y = ((float)(d1 / d3 - 1.0D) * this.height / this.width);
      localObject1 = new PointF(((PointF)((List)localObject3).get(53)).x + (((PointF)((List)localObject3).get(9)).x - ((PointF)((List)localObject3).get(53)).x) / 3.0F, ((PointF)((List)localObject3).get(53)).y + (((PointF)((List)localObject3).get(9)).y - ((PointF)((List)localObject3).get(53)).y) / 3.0F);
      d1 = ((PointF)localObject1).x * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d3 = this.width;
      Double.isNaN(d3);
      ((PointF)localObject1).x = ((float)(d1 / d3 - 1.0D));
      d1 = ((PointF)localObject1).y * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d3 = this.height;
      Double.isNaN(d3);
      ((PointF)localObject1).y = ((float)(d1 / d3 - 1.0D) * this.height / this.width);
      f3 = AlgoUtils.getDistance(paramList, (PointF)localObject1);
      d1 = paramArrayOfFloat[0];
      Double.isNaN(d1);
      d3 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d1 * 1.4D));
      f4 = (float)Math.tan(d3);
      float f8 = (float)Math.cos(d3);
      d1 = f5;
      float f9 = (float)Math.cos(d1);
      paramArrayOfFloat = paramSet;
      float f10 = (float)Math.sin(d1);
      int i = ((List)localObject3).size();
      int j = 0;
      paramSet = (Set<Integer>)localObject2;
      localObject2 = localObject3;
      double d4;
      double d5;
      while (j < this.items.size())
      {
        localObject3 = (DistortionItem)this.items.get(j);
        this.meshs[j].type = ((DistortionItem)localObject3).distortion;
        if (((DistortionItem)localObject3).position < i) {
          this.meshs[j].point = ((PointF)((List)localObject2).get(((DistortionItem)localObject3).position));
        }
        float f11 = getStrengthAdjust(j);
        this.meshs[j].strength = (((DistortionItem)localObject3).strength * f11 * yawPitchStrengthAdjust(f1, f4, ((DistortionItem)localObject3).position));
        Object localObject4 = this.meshs[j];
        d4 = ((DistortionItem)localObject3).radius * this.faceWidth;
        Double.isNaN(d4);
        d4 /= paramDouble;
        d5 = Math.min(this.width, this.height);
        Double.isNaN(d5);
        ((MeshDistortionType)localObject4).radius = ((float)(d4 / d5 / 375.0D));
        f11 = ((DistortionItem)localObject3).x * f7;
        float f12 = ((DistortionItem)localObject3).y * f8;
        localObject4 = this.meshs;
        Object localObject5 = localObject4[j];
        float f13 = this.faceWidth;
        localObject5.offsetX = ((f11 * f9 + f12 * f10) * f13 / 375.0F);
        localObject4[j].offsetY = ((f11 * f10 - f12 * f9) * f13 / 375.0F);
        localObject4[j].direction = ((DistortionItem)localObject3).direction;
        if ((((DistortionItem)localObject3).distortion != 4) && (((DistortionItem)localObject3).distortion != 5)) {
          break label1719;
        }
        localObject4 = (PointF)((List)localObject2).get(((DistortionItem)localObject3).direction);
        f11 = (((DistortionItem)localObject3).targetDx * f9 * f7 + ((DistortionItem)localObject3).targetDy * f10 * f8) * this.faceWidth / 375.0F;
        f12 = (((DistortionItem)localObject3).targetDx * f10 * f7 - ((DistortionItem)localObject3).targetDy * f9 * f8) * this.faceWidth / 375.0F;
        this.meshs[j].direction = ((float)Math.atan2(((PointF)localObject4).y + f12 - this.meshs[j].point.y - this.meshs[j].offsetY, ((PointF)localObject4).x + f11 - this.meshs[j].point.x - this.meshs[j].offsetX));
        if (((DistortionItem)localObject3).distortion == 5)
        {
          localObject3 = this.meshs;
          localObject3[j].direction += 3.141593F;
        }
        label1719:
        localObject3 = this.meshs;
        localObject3[j].faceDegree = f5;
        localObject3[j].faceRatio = f6;
        j += 1;
      }
      i = this.items.size();
      while (i < 30)
      {
        this.meshs[i].type = -1;
        i += 1;
      }
      i = 0;
      j = 0;
      while (i < this.items.size())
      {
        localObject2 = this.flatMesh;
        int k = j + 1;
        localObject2[j] = this.meshs[i].type;
        localObject2 = this.flatMesh;
        j = k + 1;
        localObject2[k] = this.meshs[i].strength;
        d4 = (this.meshs[i].point.x + this.meshs[i].offsetX) * 2.0F;
        Double.isNaN(d4);
        d4 /= paramDouble;
        d5 = this.width;
        Double.isNaN(d5);
        f7 = (float)(d4 / d5 - 1.0D);
        d4 = (this.meshs[i].point.y + this.meshs[i].offsetY) * 2.0F;
        Double.isNaN(d4);
        d4 /= paramDouble;
        d5 = this.height;
        Double.isNaN(d5);
        f8 = (float)(d4 / d5 - 1.0D);
        localObject2 = this.flatMesh;
        k = j + 1;
        localObject2[j] = (this.screenRatioX * f7);
        j = k + 1;
        localObject2[k] = (this.screenRatioY * f8);
        f5 = AlgoUtils.distanceOfPoint2Line(paramArrayOfFloat, localPointF, f2, new PointF(f7, this.height * f8 / this.width)) * f1;
        f4 = f5;
        if ((paramArrayOfFloat.x - localPointF.x) * (f8 - localPointF.y) - (paramArrayOfFloat.y - localPointF.y) * (f7 - localPointF.x) > 0.0F) {
          f4 = -f5;
        }
        AlgoUtils.distanceOfPoint2Line(paramList, (PointF)localObject1, f3, new PointF(f7, this.height * f8 / this.width));
        f5 = paramList.x;
        f5 = ((PointF)localObject1).x;
        f5 = ((PointF)localObject1).y;
        f5 = paramList.y;
        f5 = ((PointF)localObject1).y;
        f5 = ((PointF)localObject1).x;
        f4 = 2.5F + f4;
        localObject2 = this.meshs;
        localObject2[i].radius = (localObject2[i].radius * 2.5F / f4);
        localObject2 = this.flatMesh;
        k = j + 1;
        localObject2[j] = this.meshs[i].radius;
        localObject2 = this.flatMesh;
        j = k + 1;
        localObject2[k] = this.meshs[i].direction;
        this.flatMesh[j] = f4;
        i += 1;
        j += 1;
      }
      addParam(new UniformParam.FloatParam(paramSet, f6));
      addParam(new UniformParam.FloatParam("sin_roll", (float)Math.sin(d1)));
      addParam(new UniformParam.FloatParam("cos_roll", (float)Math.cos(d1)));
      addParam(new UniformParam.FloatParam("tan_yaw", (float)Math.tan(d2)));
      addParam(new UniformParam.FloatParam("cos_yaw", (float)Math.cos(d2)));
      addParam(new UniformParam.FloatParam("tan_pitch", (float)Math.tan(d3)));
      addParam(new UniformParam.FloatParam("cos_pitch", (float)Math.cos(d3)));
      addParam(new UniformParam.FloatsParam("texMapSize", new float[] { 65.0F, 65.0F }));
    }
    else
    {
      addParam(new UniformParam.FloatParam("faceRatio", 1.0F));
    }
    addParam(new UniformParam.Float1sParam("item", this.flatMesh));
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      PTDetectInfo localPTDetectInfo = (PTDetectInfo)paramObject;
      paramObject = localPTDetectInfo.faceAngles;
      if ((localPTDetectInfo.phoneAngle == 90.0F) || (localPTDetectInfo.phoneAngle == 270.0F))
      {
        paramObject = new float[3];
        paramObject[0] = (-localPTDetectInfo.faceAngles[1]);
        paramObject[1] = (-localPTDetectInfo.faceAngles[0]);
        paramObject[2] = localPTDetectInfo.faceAngles[2];
      }
      this.frameIdx = localPTDetectInfo.frameIndex;
      if (this.dataPath != null) {
        if ((localPTDetectInfo.facePoints != null) && (localPTDetectInfo.facePoints.size() > 0))
        {
          updateMeshParam();
        }
        else
        {
          this.items = EMPTY;
          this.mLastMeshIndex = -1;
        }
      }
      updateParams(localPTDetectInfo.facePoints, localPTDetectInfo.triggeredExpression, this.mFaceDetScale, paramObject);
    }
  }
  
  public void updateStrength(float paramFloat)
  {
    this.anotherStrength = paramFloat;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    float f2 = this.height / this.width;
    float f1;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    } else {
      f1 = 1.0F / f2;
    }
    this.screenRatioX = f1;
    if (f2 > 1.0F) {
      f1 = f2;
    } else {
      f1 = 1.0F;
    }
    this.screenRatioY = f1;
    addParam(new UniformParam.FloatParam("screenRatioX", this.screenRatioX));
    addParam(new UniformParam.FloatParam("screenRatioY", this.screenRatioY));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransformFilter_new
 * JD-Core Version:    0.7.0.1
 */