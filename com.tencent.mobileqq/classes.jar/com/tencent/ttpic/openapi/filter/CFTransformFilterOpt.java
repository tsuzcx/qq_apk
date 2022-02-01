package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.model.FaceFeature;
import com.tencent.ttpic.model.FaceFeatureTex;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CFTransformFilterOpt
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n uniform float alphaBlend;\n uniform int method;\n uniform int order;\n uniform int clampToEdge;\n uniform vec4 cropRect1; //used for crop rect\n uniform vec4 cropRect2; //used for crop rect\n \n float alphaOfRatio(vec2 tCoord, float targetAlpha){\n     if (tCoord.x > 0.5) tCoord.x = 1.0 - tCoord.x;\n     if (tCoord.y > 0.5) tCoord.y = 1.0 - tCoord.y;\n     float minR = tCoord.x < tCoord.y ? tCoord.x : tCoord.y;\n     if (minR > 0.1) minR = 0.1;\n     float mAlpha = 1.0 - (1.0 - targetAlpha) * 2.0;\n     if (mAlpha < 0.0) mAlpha = 0.0;\n     return smoothstep(0.1, 0.9, minR * 10.0 * (1.0 - mAlpha) + mAlpha);\n }\n \n void main()\n {\n     vec2 minPos = vec2(0.0, 0.0);\n     vec2 maxPos = vec2(1.0, 1.0);\n     vec4 color1 = vec4(0.0, 0.0, 0.0, 1.0);\n     vec4 color2 = vec4(0.0, 0.0, 0.0, 1.0);\n     if (method == -1){\n         color1 = texture2D(inputImageTexture,textureCoordinate);\n         color2 = texture2D(inputImageTexture2,textureCoordinate);\n         //check if color1 and color2 in rect\n         if (textureCoordinate.x < cropRect1.r || textureCoordinate.x > cropRect1.g ||\n             textureCoordinate.y < cropRect1.b || textureCoordinate.y > cropRect1.a) {\n             color1 = vec4(0.0);\n         }\n         if (textureCoordinate.x < cropRect2.r || textureCoordinate.x > cropRect2.g ||\n             textureCoordinate.y < cropRect2.b || textureCoordinate.y > cropRect2.a) {\n             color2 = vec4(0.0);\n         }\n         gl_FragColor = vec4(color1.rgb + color2.rgb, 1.0);\n         return;\n     }\n     if (order == 1 || order == 0){\n         if (method >= 2){\n             color1 = texture2D(inputImageTexture,clamp(textureCoordinate, cropRect1.rg, cropRect1.ba));\n         } else if (textureCoordinate.x >= 0.0 && textureCoordinate.x <= 1.0 && textureCoordinate.y >= 0.0 && textureCoordinate.y <= 1.0) {\n             color1 = texture2D(inputImageTexture,textureCoordinate);\n         } else if (clampToEdge == 1 && method == 1) {\n             vec2 extPos = clamp(textureCoordinate, minPos, maxPos);\n             color1 = texture2D(inputImageTexture, extPos);\n         }\n     }\n     if (order == 2 || order == 0){\n         if (method >= 2){\n             color2 = texture2D(inputImageTexture2,clamp(textureCoordinate2, cropRect2.rg, cropRect2.ba));\n         } else if (textureCoordinate2.x >= 0.0 && textureCoordinate2.x <= 1.0 && textureCoordinate2.y >= 0.0 && textureCoordinate2.y <= 1.0) {\n             color2 = texture2D(inputImageTexture2,textureCoordinate2);\n         } else if (clampToEdge == 1 && method == 1) {\n             vec2 extPos = clamp(textureCoordinate2, minPos, maxPos);\n             color2 = texture2D(inputImageTexture2, extPos);\n         }\n     }\n     if (order == 1){\n         gl_FragColor = vec4(color1.rgb * (1.0 - alphaBlend), 1.0);\n     } else if (order == 2){\n         gl_FragColor = vec4(color2.rgb * alphaBlend, 1.0);\n     } else {\n         gl_FragColor = color1 * (1.0 - alphaBlend) + color2 * alphaBlend;\n     }\n }\n";
  private static final String TAG = "CFTransformFilterOpt";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec2 inputTextureCoordinate2;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n void main(){\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate;\n     textureCoordinate2 = inputTextureCoordinate2;\n }\n";
  private static final int nTriangles = 196;
  private static int[] triangleArray = new int[588];
  private int backgroundMode1;
  private int backgroundMode2;
  private boolean clampToEdge = true;
  private Frame clipFrame = new Frame();
  VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private FaceFeatureTex faceFeatureBitmap1;
  private FaceFeatureTex faceFeatureBitmap2;
  private PointF firstFaceAnchor = null;
  private Rect firstSmartRect = null;
  private final float[] fragCoord1 = new float[1176];
  private final float[] fragCoord2 = new float[1176];
  private PointF newAnchor = new PointF(0.0F, 0.0F);
  private Frame outFrame = new Frame();
  private int outHeight;
  private int outWidth;
  private int procMethod = 1;
  private PointF secondFaceAnchor = null;
  private Rect secondSmartRect = null;
  private final float[][] tPT1 = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
  private final float[][] tPT2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
  private final float[][] vPT1 = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
  private final float[][] vPT2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
  private final float[] vertexCoord = new float[1176];
  
  public CFTransformFilterOpt()
  {
    super(" attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec2 inputTextureCoordinate2;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n void main(){\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate;\n     textureCoordinate2 = inputTextureCoordinate2;\n }\n", " precision highp float;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n uniform float alphaBlend;\n uniform int method;\n uniform int order;\n uniform int clampToEdge;\n uniform vec4 cropRect1; //used for crop rect\n uniform vec4 cropRect2; //used for crop rect\n \n float alphaOfRatio(vec2 tCoord, float targetAlpha){\n     if (tCoord.x > 0.5) tCoord.x = 1.0 - tCoord.x;\n     if (tCoord.y > 0.5) tCoord.y = 1.0 - tCoord.y;\n     float minR = tCoord.x < tCoord.y ? tCoord.x : tCoord.y;\n     if (minR > 0.1) minR = 0.1;\n     float mAlpha = 1.0 - (1.0 - targetAlpha) * 2.0;\n     if (mAlpha < 0.0) mAlpha = 0.0;\n     return smoothstep(0.1, 0.9, minR * 10.0 * (1.0 - mAlpha) + mAlpha);\n }\n \n void main()\n {\n     vec2 minPos = vec2(0.0, 0.0);\n     vec2 maxPos = vec2(1.0, 1.0);\n     vec4 color1 = vec4(0.0, 0.0, 0.0, 1.0);\n     vec4 color2 = vec4(0.0, 0.0, 0.0, 1.0);\n     if (method == -1){\n         color1 = texture2D(inputImageTexture,textureCoordinate);\n         color2 = texture2D(inputImageTexture2,textureCoordinate);\n         //check if color1 and color2 in rect\n         if (textureCoordinate.x < cropRect1.r || textureCoordinate.x > cropRect1.g ||\n             textureCoordinate.y < cropRect1.b || textureCoordinate.y > cropRect1.a) {\n             color1 = vec4(0.0);\n         }\n         if (textureCoordinate.x < cropRect2.r || textureCoordinate.x > cropRect2.g ||\n             textureCoordinate.y < cropRect2.b || textureCoordinate.y > cropRect2.a) {\n             color2 = vec4(0.0);\n         }\n         gl_FragColor = vec4(color1.rgb + color2.rgb, 1.0);\n         return;\n     }\n     if (order == 1 || order == 0){\n         if (method >= 2){\n             color1 = texture2D(inputImageTexture,clamp(textureCoordinate, cropRect1.rg, cropRect1.ba));\n         } else if (textureCoordinate.x >= 0.0 && textureCoordinate.x <= 1.0 && textureCoordinate.y >= 0.0 && textureCoordinate.y <= 1.0) {\n             color1 = texture2D(inputImageTexture,textureCoordinate);\n         } else if (clampToEdge == 1 && method == 1) {\n             vec2 extPos = clamp(textureCoordinate, minPos, maxPos);\n             color1 = texture2D(inputImageTexture, extPos);\n         }\n     }\n     if (order == 2 || order == 0){\n         if (method >= 2){\n             color2 = texture2D(inputImageTexture2,clamp(textureCoordinate2, cropRect2.rg, cropRect2.ba));\n         } else if (textureCoordinate2.x >= 0.0 && textureCoordinate2.x <= 1.0 && textureCoordinate2.y >= 0.0 && textureCoordinate2.y <= 1.0) {\n             color2 = texture2D(inputImageTexture2,textureCoordinate2);\n         } else if (clampToEdge == 1 && method == 1) {\n             vec2 extPos = clamp(textureCoordinate2, minPos, maxPos);\n             color2 = texture2D(inputImageTexture2, extPos);\n         }\n     }\n     if (order == 1){\n         gl_FragColor = vec4(color1.rgb * (1.0 - alphaBlend), 1.0);\n     } else if (order == 2){\n         gl_FragColor = vec4(color2.rgb * alphaBlend, 1.0);\n     } else {\n         gl_FragColor = color1 * (1.0 - alphaBlend) + color2 * alphaBlend;\n     }\n }\n");
    initTriangleIndices();
    initParams();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(588);
  }
  
  public CFTransformFilterOpt(FaceFeatureTex paramFaceFeatureTex1, FaceFeatureTex paramFaceFeatureTex2, int paramInt1, int paramInt2)
  {
    super(" attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec2 inputTextureCoordinate2;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n void main(){\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate;\n     textureCoordinate2 = inputTextureCoordinate2;\n }\n", " precision highp float;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n uniform float alphaBlend;\n uniform int method;\n uniform int order;\n uniform int clampToEdge;\n uniform vec4 cropRect1; //used for crop rect\n uniform vec4 cropRect2; //used for crop rect\n \n float alphaOfRatio(vec2 tCoord, float targetAlpha){\n     if (tCoord.x > 0.5) tCoord.x = 1.0 - tCoord.x;\n     if (tCoord.y > 0.5) tCoord.y = 1.0 - tCoord.y;\n     float minR = tCoord.x < tCoord.y ? tCoord.x : tCoord.y;\n     if (minR > 0.1) minR = 0.1;\n     float mAlpha = 1.0 - (1.0 - targetAlpha) * 2.0;\n     if (mAlpha < 0.0) mAlpha = 0.0;\n     return smoothstep(0.1, 0.9, minR * 10.0 * (1.0 - mAlpha) + mAlpha);\n }\n \n void main()\n {\n     vec2 minPos = vec2(0.0, 0.0);\n     vec2 maxPos = vec2(1.0, 1.0);\n     vec4 color1 = vec4(0.0, 0.0, 0.0, 1.0);\n     vec4 color2 = vec4(0.0, 0.0, 0.0, 1.0);\n     if (method == -1){\n         color1 = texture2D(inputImageTexture,textureCoordinate);\n         color2 = texture2D(inputImageTexture2,textureCoordinate);\n         //check if color1 and color2 in rect\n         if (textureCoordinate.x < cropRect1.r || textureCoordinate.x > cropRect1.g ||\n             textureCoordinate.y < cropRect1.b || textureCoordinate.y > cropRect1.a) {\n             color1 = vec4(0.0);\n         }\n         if (textureCoordinate.x < cropRect2.r || textureCoordinate.x > cropRect2.g ||\n             textureCoordinate.y < cropRect2.b || textureCoordinate.y > cropRect2.a) {\n             color2 = vec4(0.0);\n         }\n         gl_FragColor = vec4(color1.rgb + color2.rgb, 1.0);\n         return;\n     }\n     if (order == 1 || order == 0){\n         if (method >= 2){\n             color1 = texture2D(inputImageTexture,clamp(textureCoordinate, cropRect1.rg, cropRect1.ba));\n         } else if (textureCoordinate.x >= 0.0 && textureCoordinate.x <= 1.0 && textureCoordinate.y >= 0.0 && textureCoordinate.y <= 1.0) {\n             color1 = texture2D(inputImageTexture,textureCoordinate);\n         } else if (clampToEdge == 1 && method == 1) {\n             vec2 extPos = clamp(textureCoordinate, minPos, maxPos);\n             color1 = texture2D(inputImageTexture, extPos);\n         }\n     }\n     if (order == 2 || order == 0){\n         if (method >= 2){\n             color2 = texture2D(inputImageTexture2,clamp(textureCoordinate2, cropRect2.rg, cropRect2.ba));\n         } else if (textureCoordinate2.x >= 0.0 && textureCoordinate2.x <= 1.0 && textureCoordinate2.y >= 0.0 && textureCoordinate2.y <= 1.0) {\n             color2 = texture2D(inputImageTexture2,textureCoordinate2);\n         } else if (clampToEdge == 1 && method == 1) {\n             vec2 extPos = clamp(textureCoordinate2, minPos, maxPos);\n             color2 = texture2D(inputImageTexture2, extPos);\n         }\n     }\n     if (order == 1){\n         gl_FragColor = vec4(color1.rgb * (1.0 - alphaBlend), 1.0);\n     } else if (order == 2){\n         gl_FragColor = vec4(color2.rgb * alphaBlend, 1.0);\n     } else {\n         gl_FragColor = color1 * (1.0 - alphaBlend) + color2 * alphaBlend;\n     }\n }\n");
    this.faceFeatureBitmap1 = paramFaceFeatureTex1;
    this.faceFeatureBitmap2 = paramFaceFeatureTex2;
    this.backgroundMode1 = paramInt1;
    this.backgroundMode2 = paramInt2;
    this.outWidth = this.faceFeatureBitmap2.faceFeature.width;
    this.outHeight = this.faceFeatureBitmap2.faceFeature.height;
    if ((this.faceFeatureBitmap1.faceFeature.points != null) && (this.faceFeatureBitmap1.faceFeature.points.size() > 64) && (this.faceFeatureBitmap2.faceFeature.points != null) && (this.faceFeatureBitmap2.faceFeature.points.size() > 64))
    {
      this.firstFaceAnchor = new PointF(((PointF)this.faceFeatureBitmap1.faceFeature.points.get(64)).x, ((PointF)this.faceFeatureBitmap1.faceFeature.points.get(64)).y);
      this.secondFaceAnchor = new PointF(((PointF)this.faceFeatureBitmap2.faceFeature.points.get(64)).x, ((PointF)this.faceFeatureBitmap2.faceFeature.points.get(64)).y);
    }
    initTriangleIndices();
    initParams();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(588);
    updateTextureCoords();
    this.copyFilter.ApplyGLSLFilter();
  }
  
  public static FaceFeatureTex genFaceFeatureTex(int paramInt1, int paramInt2, int paramInt3, PTFaceAttr paramPTFaceAttr)
  {
    if ((paramInt1 < 0) || (paramPTFaceAttr == null) || (paramPTFaceAttr.getAllFacePoints() == null) || (paramPTFaceAttr.getAllFacePoints().size() <= 0)) {
      return null;
    }
    FaceFeatureTex localFaceFeatureTex = new FaceFeatureTex();
    localFaceFeatureTex.faceTex = paramInt1;
    ArrayList localArrayList = new ArrayList();
    double d = (float)paramPTFaceAttr.getFaceDetectScale();
    paramPTFaceAttr = ((List)paramPTFaceAttr.getAllFacePoints().get(0)).iterator();
    while (paramPTFaceAttr.hasNext())
    {
      PointF localPointF = (PointF)paramPTFaceAttr.next();
      localArrayList.add(new PointF((float)(localPointF.x / d), (float)(localPointF.y / d)));
    }
    FaceOffUtil.getFullCoords(localArrayList, 2.0F);
    localFaceFeatureTex.faceFeature = new FaceFeature(localArrayList, paramInt2, paramInt3);
    return localFaceFeatureTex;
  }
  
  private static FaceFeatureTex genFaceFeatureTex(int paramInt, PTFaceAttr paramPTFaceAttr)
  {
    if ((paramInt < 0) || (paramPTFaceAttr == null) || (paramPTFaceAttr.getAllFacePoints() == null) || (paramPTFaceAttr.getAllFacePoints().size() <= 0)) {
      return null;
    }
    FaceFeatureTex localFaceFeatureTex = new FaceFeatureTex();
    localFaceFeatureTex.faceTex = paramInt;
    ArrayList localArrayList = new ArrayList();
    double d = (float)paramPTFaceAttr.getFaceDetectScale();
    paramInt = (int)(paramPTFaceAttr.getFaceDetWidth() * d);
    int i = (int)(paramPTFaceAttr.getFaceDetHeight() * d);
    paramPTFaceAttr = ((List)paramPTFaceAttr.getAllFacePoints().get(0)).iterator();
    while (paramPTFaceAttr.hasNext())
    {
      PointF localPointF = (PointF)paramPTFaceAttr.next();
      localArrayList.add(new PointF((float)(localPointF.x * d), (float)(localPointF.y * d)));
    }
    FaceOffUtil.getFullCoords(localArrayList, 2.0F);
    localFaceFeatureTex.faceFeature = new FaceFeature(localArrayList, paramInt, i);
    return localFaceFeatureTex;
  }
  
  private void generateTextureCoord(float[][] paramArrayOfFloat, float[] paramArrayOfFloat1)
  {
    int i = 0;
    int j = 0;
    while (i < 196)
    {
      int k = triangleArray[(i * 3)];
      int m = triangleArray[(i * 3 + 1)];
      int n = triangleArray[(i * 3 + 2)];
      paramArrayOfFloat1[j] = paramArrayOfFloat[k][0];
      paramArrayOfFloat1[(j + 1)] = paramArrayOfFloat[k][1];
      paramArrayOfFloat1[(j + 2)] = paramArrayOfFloat[m][0];
      paramArrayOfFloat1[(j + 3)] = paramArrayOfFloat[m][1];
      paramArrayOfFloat1[(j + 4)] = paramArrayOfFloat[n][0];
      paramArrayOfFloat1[(j + 5)] = paramArrayOfFloat[n][1];
      j += 6;
      i += 1;
    }
  }
  
  private void generateVertexCoordv1(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, float paramFloat, int paramInt)
  {
    int j = 0;
    float f1 = 2.0F / this.outWidth;
    float f2 = 2.0F / this.outHeight;
    float f3 = 1.0F - paramFloat;
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
    int i = 0;
    if (i < 117)
    {
      arrayOfFloat[i][0] = (paramArrayOfFloat2[i][0] * paramFloat + paramArrayOfFloat1[i][0] * f3);
      arrayOfFloat[i][1] = (paramArrayOfFloat2[i][1] * paramFloat + paramArrayOfFloat1[i][1] * f3);
      if ((i >= 109) && (paramInt == 1))
      {
        arrayOfFloat[i][0] = paramArrayOfFloat1[i][0];
        arrayOfFloat[i][1] = paramArrayOfFloat1[i][1];
      }
      for (;;)
      {
        i += 1;
        break;
        if ((i >= 109) && (paramInt == 2))
        {
          arrayOfFloat[i][0] = paramArrayOfFloat2[i][0];
          arrayOfFloat[i][1] = paramArrayOfFloat2[i][1];
        }
      }
    }
    this.newAnchor.x = arrayOfFloat[64][0];
    this.newAnchor.y = arrayOfFloat[64][1];
    paramInt = 0;
    i = j;
    while (paramInt < 196)
    {
      j = triangleArray[(paramInt * 3)];
      int k = triangleArray[(paramInt * 3 + 1)];
      int m = triangleArray[(paramInt * 3 + 2)];
      this.vertexCoord[i] = (arrayOfFloat[j][0] * f1 - 1.0F);
      this.vertexCoord[(i + 1)] = (arrayOfFloat[j][1] * f2 - 1.0F);
      this.vertexCoord[(i + 2)] = (arrayOfFloat[k][0] * f1 - 1.0F);
      this.vertexCoord[(i + 3)] = (arrayOfFloat[k][1] * f2 - 1.0F);
      this.vertexCoord[(i + 4)] = (arrayOfFloat[m][0] * f1 - 1.0F);
      this.vertexCoord[(i + 5)] = (arrayOfFloat[m][1] * f2 - 1.0F);
      i += 6;
      paramInt += 1;
    }
  }
  
  private void getPointsWithFeature(FaceFeature paramFaceFeature, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, int paramInt)
  {
    float[][] arrayOfFloat = VideoMaterial.listToFloatArray(paramFaceFeature.points);
    if (this.procMethod >= 1) {
      CosFunUtil.getExtFaceFeature(arrayOfFloat);
    }
    float f3 = this.outWidth / paramFaceFeature.width;
    float f4 = this.outHeight / paramFaceFeature.height;
    float f1 = Math.min(f3, f4);
    float f2 = Math.max(f3, f4);
    if (paramInt == 2) {
      f2 = f1;
    }
    for (;;)
    {
      f4 = (this.outWidth - paramFaceFeature.width * f2) / 2.0F;
      f3 = (this.outHeight - paramFaceFeature.height * f1) / 2.0F;
      paramInt = 0;
      for (;;)
      {
        if (paramInt < 107)
        {
          paramArrayOfFloat1[paramInt][0] = (arrayOfFloat[paramInt][0] * f2 + f4);
          paramArrayOfFloat1[paramInt][1] = (arrayOfFloat[paramInt][1] * f1 + f3);
          arrayOfFloat[paramInt][0] /= paramFaceFeature.width;
          arrayOfFloat[paramInt][1] /= paramFaceFeature.height;
          paramInt += 1;
          continue;
          if (paramInt != 3) {
            break label897;
          }
          f1 = f2;
          break;
        }
      }
      if (this.procMethod == 0)
      {
        paramArrayOfFloat1[109][0] = 0;
        paramArrayOfFloat1[109][1] = 0;
        paramArrayOfFloat1[110][0] = 0;
        paramArrayOfFloat1[110][1] = (this.outHeight / 2.0F);
        paramArrayOfFloat1[111][0] = 0;
        paramArrayOfFloat1[111][1] = this.outHeight;
        paramArrayOfFloat1[112][0] = (this.outWidth / 2.0F);
        paramArrayOfFloat1[112][1] = this.outHeight;
        paramArrayOfFloat1[113][0] = this.outWidth;
        paramArrayOfFloat1[113][1] = this.outHeight;
        paramArrayOfFloat1[114][0] = this.outWidth;
        paramArrayOfFloat1[114][1] = (this.outHeight / 2.0F);
        paramArrayOfFloat1[115][0] = this.outWidth;
        paramArrayOfFloat1[115][1] = 0;
        paramArrayOfFloat1[116][0] = (this.outWidth / 2.0F);
        paramArrayOfFloat1[116][1] = 0;
        f2 = f4 / (f2 * paramFaceFeature.width);
        f1 = f3 / (f1 * paramFaceFeature.height);
        paramArrayOfFloat2[109][0] = (-f2);
        paramArrayOfFloat2[109][1] = (-f1);
        paramArrayOfFloat2[110][0] = (-f2);
        paramArrayOfFloat2[110][1] = 1056964608;
        paramArrayOfFloat2[111][0] = (-f2);
        paramArrayOfFloat2[111][1] = (1.0F + f1);
        paramArrayOfFloat2[112][0] = 1056964608;
        paramArrayOfFloat2[112][1] = (1.0F + f1);
        paramArrayOfFloat2[113][0] = (1.0F + f2);
        paramArrayOfFloat2[113][1] = (1.0F + f1);
        paramArrayOfFloat2[114][0] = (1.0F + f2);
        paramArrayOfFloat2[114][1] = 1056964608;
        paramArrayOfFloat2[115][0] = (f2 + 1.0F);
        paramArrayOfFloat2[115][1] = (-f1);
        paramArrayOfFloat2[116][0] = 1056964608;
        paramArrayOfFloat2[116][1] = (-f1);
      }
      while ((this.procMethod == 1) || (this.procMethod != 2)) {
        return;
      }
      paramArrayOfFloat1[109][0] = f4;
      paramArrayOfFloat1[109][1] = f3;
      paramArrayOfFloat1[110][0] = f4;
      paramArrayOfFloat1[110][1] = (this.outHeight / 2.0F);
      paramArrayOfFloat1[111][0] = f4;
      paramArrayOfFloat1[111][1] = (this.outHeight - f3);
      paramArrayOfFloat1[112][0] = (this.outWidth / 2.0F);
      paramArrayOfFloat1[112][1] = (this.outHeight - f3);
      paramArrayOfFloat1[113][0] = (this.outWidth - f4);
      paramArrayOfFloat1[113][1] = (this.outHeight - f3);
      paramArrayOfFloat1[114][0] = (this.outWidth - f4);
      paramArrayOfFloat1[114][1] = (this.outHeight / 2.0F);
      paramArrayOfFloat1[115][0] = (this.outWidth - f4);
      paramArrayOfFloat1[115][1] = f3;
      paramArrayOfFloat1[116][0] = (this.outWidth / 2.0F);
      paramArrayOfFloat1[116][1] = f3;
      paramArrayOfFloat2[109][0] = 0;
      paramArrayOfFloat2[109][1] = 0;
      paramArrayOfFloat2[110][0] = 0;
      paramArrayOfFloat2[110][1] = 1056964608;
      paramArrayOfFloat2[111][0] = 0;
      paramArrayOfFloat2[111][1] = 1065353216;
      paramArrayOfFloat2[112][0] = 1056964608;
      paramArrayOfFloat2[112][1] = 1065353216;
      paramArrayOfFloat2[113][0] = 1065353216;
      paramArrayOfFloat2[113][1] = 1065353216;
      paramArrayOfFloat2[114][0] = 1065353216;
      paramArrayOfFloat2[114][1] = 1056964608;
      paramArrayOfFloat2[115][0] = 1065353216;
      paramArrayOfFloat2[115][1] = 0;
      paramArrayOfFloat2[116][0] = 1056964608;
      paramArrayOfFloat2[116][1] = 0;
      return;
      label897:
      f1 = f4;
      f2 = f3;
    }
  }
  
  private static void initTriangleIndices()
  {
    System.arraycopy(FaceOffUtil.FaceMeshTrianglesFaceAverage, 0, triangleArray, 0, FaceOffUtil.FaceMeshTrianglesFaceAverage.length);
    triangleArray[552] = 109;
    triangleArray[553] = 99;
    triangleArray[554] = 110;
    triangleArray[555] = 110;
    triangleArray[556] = 99;
    triangleArray[557] = 101;
    triangleArray[558] = 110;
    triangleArray[559] = 101;
    triangleArray[560] = 111;
    triangleArray[561] = 111;
    triangleArray[562] = 101;
    triangleArray[563] = 112;
    triangleArray[564] = 112;
    triangleArray[565] = 101;
    triangleArray[566] = 103;
    triangleArray[567] = 113;
    triangleArray[568] = 112;
    triangleArray[569] = 103;
    triangleArray[570] = 103;
    triangleArray[571] = 114;
    triangleArray[572] = 113;
    triangleArray[573] = 103;
    triangleArray[574] = 105;
    triangleArray[575] = 114;
    triangleArray[576] = 105;
    triangleArray[577] = 115;
    triangleArray[578] = 114;
    triangleArray[579] = 105;
    triangleArray[580] = 116;
    triangleArray[581] = 115;
    triangleArray[582] = 105;
    triangleArray[583] = 99;
    triangleArray[584] = 116;
    triangleArray[585] = 116;
    triangleArray[586] = 99;
    triangleArray[587] = 109;
  }
  
  private void updateTextureCoords()
  {
    getPointsWithFeature(this.faceFeatureBitmap1.faceFeature, this.vPT1, this.tPT1, this.backgroundMode1);
    getPointsWithFeature(this.faceFeatureBitmap2.faceFeature, this.vPT2, this.tPT2, this.backgroundMode2);
    generateTextureCoord(this.tPT1, this.fragCoord1);
    generateTextureCoord(this.tPT2, this.fragCoord2);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.outFrame.clear();
    this.clipFrame.clear();
    this.copyFilter.clearGLSLSelf();
    this.firstSmartRect = null;
    this.secondSmartRect = null;
  }
  
  public Frame getMergedFrame(float paramFloat)
  {
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    addParam(new UniformParam.IntParam("method", this.procMethod));
    addParam(new UniformParam.FloatParam("alphaBlend", paramFloat));
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.faceFeatureBitmap2.faceTex, 33986));
    FrameUtil.clearFrame(this.outFrame, 0.0F, 0.0F, 0.0F, 1.0F, this.outWidth, this.outHeight);
    GlUtil.setBlendMode(true);
    float f1;
    float f2;
    float f3;
    if (this.procMethod >= 2)
    {
      generateVertexCoordv1(this.vPT1, this.vPT2, paramFloat, 1);
      generateTextureCoord(this.tPT1, this.fragCoord1);
      setCoordNum(588);
      setPositions(this.vertexCoord);
      setTexCords(this.fragCoord1);
      addAttribParam("inputTextureCoordinate2", this.fragCoord1);
      addParam(new UniformParam.IntParam("order", 1));
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
      RenderProcess(this.faceFeatureBitmap1.faceTex, this.outWidth, this.outHeight, -1, 0.0D, this.outFrame);
      generateVertexCoordv1(this.vPT1, this.vPT2, paramFloat, 2);
      generateTextureCoord(this.tPT2, this.fragCoord2);
      setCoordNum(588);
      setPositions(this.vertexCoord);
      setTexCords(this.fragCoord2);
      addAttribParam("inputTextureCoordinate2", this.fragCoord2);
      addParam(new UniformParam.IntParam("order", 2));
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
      RenderProcess(this.faceFeatureBitmap1.faceTex, this.outWidth, this.outHeight, this.outFrame.getTextureId(), 0.0D, this.outFrame);
      if (this.procMethod == 3)
      {
        paramFloat = this.vPT1[109][0];
        f1 = this.vPT1[113][0];
        f2 = this.vPT1[109][1];
        f3 = this.vPT1[113][1];
        addParam(new UniformParam.Float4fParam("cropRect1", paramFloat / this.outWidth, f1 / this.outWidth, f2 / this.outHeight, f3 / this.outHeight));
        paramFloat = this.vPT2[109][0];
        f1 = this.vPT2[113][0];
        f2 = this.vPT2[109][1];
        f3 = this.vPT2[113][1];
        addParam(new UniformParam.Float4fParam("cropRect2", paramFloat / this.outWidth, f1 / this.outWidth, f2 / this.outHeight, f3 / this.outHeight));
      }
      for (;;)
      {
        setCoordNum(4);
        setPositions(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
        setTexCords(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
        addAttribParam("inputTextureCoordinate2", new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
        addParam(new UniformParam.IntParam("method", -1));
        setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
        RenderProcess(this.faceFeatureBitmap1.faceTex, this.outWidth, this.outHeight, this.outFrame.getTextureId(), 0.0D, this.outFrame);
        return this.outFrame;
        addParam(new UniformParam.Float4fParam("cropRect1", 0.0F, 1.0F, 0.0F, 1.0F));
        addParam(new UniformParam.Float4fParam("cropRect2", 0.0F, 1.0F, 0.0F, 1.0F));
      }
    }
    Object localObject1;
    PointF localPointF1;
    if (this.procMethod == 1)
    {
      Object localObject3 = (float[][])Array.newInstance(Float.TYPE, new int[] { 4, 2 });
      Object localObject2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 4, 2 });
      Object localObject4 = (float[][])Array.newInstance(Float.TYPE, new int[] { 4, 2 });
      i = 0;
      while (i < 4)
      {
        localObject2[i][0] = this.vPT1[(i + 99 + i)][0];
        localObject2[i][1] = this.vPT1[(i + 99 + i)][1];
        localObject4[i][0] = this.vPT2[(i + 99 + i)][0];
        localObject4[i][1] = this.vPT2[(i + 99 + i)][1];
        localObject3[i][0] = (localObject4[i][0] * paramFloat + localObject2[i][0] * (1.0F - paramFloat));
        localObject3[i][1] = (localObject4[i][1] * paramFloat + localObject2[i][1] * (1.0F - paramFloat));
        i += 1;
      }
      localObject1 = ptOfTransform((float[][])localObject3, (float[][])localObject2, new PointF(0.0F, 0.0F));
      localPointF1 = ptOfTransform((float[][])localObject3, (float[][])localObject2, new PointF(0.0F, this.outHeight));
      PointF localPointF2 = ptOfTransform((float[][])localObject3, (float[][])localObject2, new PointF(this.outWidth, this.outHeight));
      PointF localPointF5 = ptOfTransform((float[][])localObject3, (float[][])localObject2, new PointF(this.outWidth, 0.0F));
      localObject2 = ptOfTransform((float[][])localObject3, (float[][])localObject4, new PointF(0.0F, 0.0F));
      PointF localPointF3 = ptOfTransform((float[][])localObject3, (float[][])localObject4, new PointF(0.0F, this.outHeight));
      PointF localPointF4 = ptOfTransform((float[][])localObject3, (float[][])localObject4, new PointF(this.outWidth, this.outHeight));
      localObject3 = ptOfTransform((float[][])localObject3, (float[][])localObject4, new PointF(this.outWidth, 0.0F));
      localObject4 = this.faceFeatureBitmap1.faceFeature;
      f1 = Math.min(this.outWidth / ((FaceFeature)localObject4).width, this.outHeight / ((FaceFeature)localObject4).height);
      f2 = (this.outWidth - ((FaceFeature)localObject4).width * f1) / 2.0F;
      f3 = (this.outHeight - ((FaceFeature)localObject4).height * f1) / 2.0F;
      this.fragCoord1[0] = ((((PointF)localObject1).x - f2) / f1 / ((FaceFeature)localObject4).width);
      this.fragCoord1[1] = ((((PointF)localObject1).y - f3) / f1 / ((FaceFeature)localObject4).height);
      this.fragCoord1[2] = ((localPointF5.x - f2) / f1 / ((FaceFeature)localObject4).width);
      this.fragCoord1[3] = ((localPointF5.y - f3) / f1 / ((FaceFeature)localObject4).height);
      this.fragCoord1[4] = ((localPointF1.x - f2) / f1 / ((FaceFeature)localObject4).width);
      this.fragCoord1[5] = ((localPointF1.y - f3) / f1 / ((FaceFeature)localObject4).height);
      this.fragCoord1[6] = ((localPointF2.x - f2) / f1 / ((FaceFeature)localObject4).width);
      this.fragCoord1[7] = ((localPointF2.y - f3) / f1 / ((FaceFeature)localObject4).height);
      localObject1 = this.faceFeatureBitmap2.faceFeature;
      f1 = Math.min(this.outWidth / ((FaceFeature)localObject1).width, this.outHeight / ((FaceFeature)localObject1).height);
      f2 = (this.outWidth - ((FaceFeature)localObject1).width * f1) / 2.0F;
      f3 = (this.outHeight - ((FaceFeature)localObject1).height * f1) / 2.0F;
      this.fragCoord2[0] = ((((PointF)localObject2).x - f2) / f1 / ((FaceFeature)localObject1).width);
      this.fragCoord2[1] = ((((PointF)localObject2).y - f3) / f1 / ((FaceFeature)localObject1).height);
      this.fragCoord2[2] = ((((PointF)localObject3).x - f2) / f1 / ((FaceFeature)localObject1).width);
      this.fragCoord2[3] = ((((PointF)localObject3).y - f3) / f1 / ((FaceFeature)localObject1).height);
      this.fragCoord2[4] = ((localPointF3.x - f2) / f1 / ((FaceFeature)localObject1).width);
      this.fragCoord2[5] = ((localPointF3.y - f3) / f1 / ((FaceFeature)localObject1).height);
      this.fragCoord2[6] = ((localPointF4.x - f2) / f1 / ((FaceFeature)localObject1).width);
      this.fragCoord2[7] = ((localPointF4.y - f3) / f1 / ((FaceFeature)localObject1).height);
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
      setPositions(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
      setCoordNum(4);
      setTexCords(this.fragCoord1);
      addAttribParam("inputTextureCoordinate2", this.fragCoord2);
      RenderProcess(this.faceFeatureBitmap1.faceTex, this.outWidth, this.outHeight, -1, 0.0D, this.outFrame);
    }
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    generateVertexCoordv1(this.vPT1, this.vPT2, paramFloat, 0);
    generateTextureCoord(this.tPT1, this.fragCoord1);
    generateTextureCoord(this.tPT2, this.fragCoord2);
    if (this.procMethod == 1) {}
    for (int i = 184;; i = 196)
    {
      setCoordNum(i * 3);
      setPositions(this.vertexCoord);
      setTexCords(this.fragCoord1);
      addAttribParam("inputTextureCoordinate2", this.fragCoord2);
      addParam(new UniformParam.FloatParam("alphaBlend", paramFloat));
      RenderProcess(this.faceFeatureBitmap1.faceTex, this.outWidth, this.outHeight, -1, 0.0D, this.outFrame);
      if ((this.firstSmartRect == null) || (this.secondSmartRect == null)) {
        break;
      }
      localObject1 = new PointF(this.secondSmartRect.left, this.secondSmartRect.top);
      localPointF1 = new PointF(this.secondSmartRect.right, this.secondSmartRect.bottom);
      paramFloat = this.newAnchor.x - this.secondFaceAnchor.x;
      f1 = this.newAnchor.y - this.secondFaceAnchor.y;
      ((PointF)localObject1).x += paramFloat;
      ((PointF)localObject1).y += f1;
      localPointF1.x = (paramFloat + localPointF1.x);
      localPointF1.y += f1;
      this.copyFilter.setTexCords(new float[] { ((PointF)localObject1).x / this.outWidth, ((PointF)localObject1).y / this.outHeight, ((PointF)localObject1).x / this.outWidth, localPointF1.y / this.outHeight, localPointF1.x / this.outWidth, localPointF1.y / this.outHeight, localPointF1.x / this.outWidth, ((PointF)localObject1).y / this.outHeight });
      this.copyFilter.RenderProcess(this.outFrame.getTextureId(), this.outWidth, this.outHeight, -1, 0.0D, this.clipFrame);
      GlUtil.setBlendMode(false);
      return this.clipFrame;
    }
    GlUtil.setBlendMode(false);
    return this.outFrame;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam("inputTextureCoordinate2", AEOpenRenderConfig.ORIGIN_TEX_COORDS);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("alphaBlend", 0.0F));
    addParam(new UniformParam.IntParam("method", 1));
    addParam(new UniformParam.IntParam("order", 0));
    addParam(new UniformParam.IntParam("clampToEdge", 1));
    addParam(new UniformParam.Float4fParam("cropRect1", 0.0F, 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Float4fParam("cropRect2", 0.0F, 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  PointF ptOfTransform(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, PointF paramPointF)
  {
    float f1 = paramArrayOfFloat1[0][0];
    float f2 = paramArrayOfFloat1[1][0];
    float f3 = paramArrayOfFloat1[2][0];
    float f4 = paramArrayOfFloat1[0][1];
    float f5 = paramArrayOfFloat1[1][1];
    float f6 = paramArrayOfFloat1[2][1];
    float f7 = paramArrayOfFloat2[0][0];
    float f8 = paramArrayOfFloat2[1][0];
    float f9 = paramArrayOfFloat2[2][0];
    float f10 = paramArrayOfFloat2[0][1];
    float f11 = paramArrayOfFloat2[1][1];
    float f12 = paramArrayOfFloat2[2][1];
    double d6 = f1 * f5 + f4 * f3 + f2 * f6 - f3 * f5 - f2 * f4 - f1 * f6;
    if (d6 == 0.0D) {
      return paramPointF;
    }
    double d1 = (f7 * f5 + f9 * f4 + f8 * f6 - f9 * f5 - f8 * f4 - f7 * f6) / d6;
    double d2 = (f1 * f8 + f3 * f7 + f2 * f9 - f3 * f8 - f2 * f7 - f1 * f9) / d6;
    double d3 = (f1 * f5 * f9 + f4 * f8 * f3 + f7 * f2 * f6 - f7 * f5 * f3 - f9 * (f4 * f2) - f8 * f1 * f6) / d6;
    double d4 = (f10 * f5 + f12 * f4 + f11 * f6 - f12 * f5 - f11 * f4 - f10 * f6) / d6;
    double d5 = (f1 * f11 + f3 * f10 + f2 * f12 - f3 * f11 - f2 * f10 - f1 * f12) / d6;
    d6 = (f1 * f5 * f12 + f4 * f11 * f3 + f10 * f2 * f6 - f3 * (f5 * f10) - f2 * f4 * f12 - f1 * f11 * f6) / d6;
    double d7 = paramPointF.x;
    double d8 = paramPointF.y;
    return new PointF((float)(d3 + (d1 * d7 + d2 * d8)), (float)(d6 + (d7 * d4 + d8 * d5)));
  }
  
  public void setClampToEdge(boolean paramBoolean)
  {
    this.clampToEdge = paramBoolean;
  }
  
  public void setProcMethod(int paramInt)
  {
    this.procMethod = (paramInt % 4);
  }
  
  public void setSmartPicture(Rect paramRect1, Rect paramRect2)
  {
    if ((paramRect1 == null) || (paramRect2 == null)) {
      return;
    }
    this.firstSmartRect = paramRect1;
    this.secondSmartRect = paramRect2;
  }
  
  public void updateFaceParmas(int paramInt1, int paramInt2, PTFaceAttr paramPTFaceAttr1, PTFaceAttr paramPTFaceAttr2)
  {
    this.faceFeatureBitmap1 = genFaceFeatureTex(paramInt1, paramPTFaceAttr1);
    this.faceFeatureBitmap2 = genFaceFeatureTex(paramInt2, paramPTFaceAttr2);
    this.backgroundMode1 = 2;
    this.backgroundMode2 = 0;
    this.outWidth = this.faceFeatureBitmap2.faceFeature.width;
    this.outHeight = this.faceFeatureBitmap2.faceFeature.height;
    updateTextureCoords();
  }
  
  public void updateFaceParmas(FaceFeatureTex paramFaceFeatureTex1, FaceFeatureTex paramFaceFeatureTex2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.faceFeatureBitmap1 = paramFaceFeatureTex1;
    this.faceFeatureBitmap2 = paramFaceFeatureTex2;
    this.backgroundMode1 = paramInt3;
    this.backgroundMode2 = paramInt4;
    this.outWidth = paramInt1;
    this.outHeight = paramInt2;
    if ((this.faceFeatureBitmap1.faceFeature.points != null) && (this.faceFeatureBitmap1.faceFeature.points.size() > 64) && (this.faceFeatureBitmap2.faceFeature.points != null) && (this.faceFeatureBitmap2.faceFeature.points.size() > 64))
    {
      this.firstFaceAnchor = new PointF(((PointF)this.faceFeatureBitmap1.faceFeature.points.get(64)).x, ((PointF)this.faceFeatureBitmap1.faceFeature.points.get(64)).y);
      this.secondFaceAnchor = new PointF(((PointF)this.faceFeatureBitmap2.faceFeature.points.get(64)).x, ((PointF)this.faceFeatureBitmap2.faceFeature.points.get(64)).y);
    }
    updateTextureCoords();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CFTransformFilterOpt
 * JD-Core Version:    0.7.0.1
 */