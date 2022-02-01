package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.model.FaceFeature;
import com.tencent.ttpic.model.FaceFeatureTex;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.lang.reflect.Array;

public class CFTransformFilterForWesee
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n varying vec2 textureCoordinate;\n uniform lowp sampler2D inputImageTexture;\n uniform vec4 cropRect;\n\n uniform lowp float alphaBlend;\n\n void main()\n {\n     float x = clamp(textureCoordinate.x, cropRect.r, cropRect.g);\n     float y = clamp(textureCoordinate.y, cropRect.b, cropRect.a);\n     vec4 color1 = texture2D(inputImageTexture, vec2(x, y));\n\n     gl_FragColor = color1 * alphaBlend;\n }";
  private static final int nTriangles = 196;
  private static int[] triangleArray = new int[588];
  private int backgroundMode1;
  private int backgroundMode2;
  private FaceFeatureTex faceFeatureBitmap1;
  private FaceFeatureTex faceFeatureBitmap2;
  private final float[] fragCoord1 = new float[1176];
  private final float[] fragCoord2 = new float[1176];
  private Frame outFrame = new Frame();
  private int outHeight;
  private int outWidth;
  private int procMethod = 2;
  private final float[][] tPT1 = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
  private final float[][] tPT2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
  private final float[][] vPT1 = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
  private final float[][] vPT2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
  private final float[] vertexCoord = new float[1176];
  
  public CFTransformFilterForWesee()
  {
    super("precision highp float;\n varying vec2 textureCoordinate;\n uniform lowp sampler2D inputImageTexture;\n uniform vec4 cropRect;\n\n uniform lowp float alphaBlend;\n\n void main()\n {\n     float x = clamp(textureCoordinate.x, cropRect.r, cropRect.g);\n     float y = clamp(textureCoordinate.y, cropRect.b, cropRect.a);\n     vec4 color1 = texture2D(inputImageTexture, vec2(x, y));\n\n     gl_FragColor = color1 * alphaBlend;\n }");
    initTriangleIndices();
    initParams();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(588);
  }
  
  public CFTransformFilterForWesee(FaceFeatureTex paramFaceFeatureTex1, FaceFeatureTex paramFaceFeatureTex2, int paramInt1, int paramInt2)
  {
    super("precision highp float;\n varying vec2 textureCoordinate;\n uniform lowp sampler2D inputImageTexture;\n uniform vec4 cropRect;\n\n uniform lowp float alphaBlend;\n\n void main()\n {\n     float x = clamp(textureCoordinate.x, cropRect.r, cropRect.g);\n     float y = clamp(textureCoordinate.y, cropRect.b, cropRect.a);\n     vec4 color1 = texture2D(inputImageTexture, vec2(x, y));\n\n     gl_FragColor = color1 * alphaBlend;\n }");
    this.faceFeatureBitmap1 = paramFaceFeatureTex1;
    this.faceFeatureBitmap2 = paramFaceFeatureTex2;
    this.backgroundMode1 = paramInt1;
    this.backgroundMode2 = paramInt2;
    this.outWidth = 720;
    this.outHeight = 1280;
    initTriangleIndices();
    initParams();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(588);
    updateTextureCoords();
  }
  
  private void generateTextureCoord(float[][] paramArrayOfFloat, float[] paramArrayOfFloat1)
  {
    int i = 0;
    int j = 0;
    while (i < 196)
    {
      int[] arrayOfInt = triangleArray;
      int n = i * 3;
      int k = arrayOfInt[n];
      int m = arrayOfInt[(n + 1)];
      n = arrayOfInt[(n + 2)];
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
    float f1 = 2.0F / this.outWidth;
    float f2 = 2.0F / this.outHeight;
    float f3 = 1.0F - paramFloat;
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 131, 2 });
    int i = 0;
    while (i < 117)
    {
      arrayOfFloat[i][0] = (paramArrayOfFloat2[i][0] * paramFloat + paramArrayOfFloat1[i][0] * f3);
      arrayOfFloat[i][1] = (paramArrayOfFloat2[i][1] * paramFloat + paramArrayOfFloat1[i][1] * f3);
      if ((i >= 109) && (paramInt == 1))
      {
        arrayOfFloat[i][0] = paramArrayOfFloat1[i][0];
        arrayOfFloat[i][1] = paramArrayOfFloat1[i][1];
      }
      else if ((i >= 109) && (paramInt == 2))
      {
        arrayOfFloat[i][0] = paramArrayOfFloat2[i][0];
        arrayOfFloat[i][1] = paramArrayOfFloat2[i][1];
      }
      i += 1;
    }
    paramInt = 0;
    i = 0;
    while (paramInt < 196)
    {
      paramArrayOfFloat1 = triangleArray;
      int m = paramInt * 3;
      int j = paramArrayOfFloat1[m];
      int k = paramArrayOfFloat1[(m + 1)];
      m = paramArrayOfFloat1[(m + 2)];
      paramArrayOfFloat1 = this.vertexCoord;
      paramArrayOfFloat1[i] = (arrayOfFloat[j][0] * f1 - 1.0F);
      paramArrayOfFloat1[(i + 1)] = (arrayOfFloat[j][1] * f2 - 1.0F);
      paramArrayOfFloat1[(i + 2)] = (arrayOfFloat[k][0] * f1 - 1.0F);
      paramArrayOfFloat1[(i + 3)] = (arrayOfFloat[k][1] * f2 - 1.0F);
      paramArrayOfFloat1[(i + 4)] = (arrayOfFloat[m][0] * f1 - 1.0F);
      paramArrayOfFloat1[(i + 5)] = (arrayOfFloat[m][1] * f2 - 1.0F);
      i += 6;
      paramInt += 1;
    }
  }
  
  private void getPointsWithFeature(FaceFeature paramFaceFeature, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, int paramInt)
  {
    Object localObject = VideoMaterial.listToFloatArray(paramFaceFeature.points);
    if (this.procMethod == 2) {
      CosFunUtil.getExtFaceFeature((float[][])localObject);
    }
    float f1 = this.outWidth / paramFaceFeature.width;
    float f2 = this.outHeight / paramFaceFeature.height;
    float f4 = Math.min(f1, f2);
    float f3 = Math.max(f1, f2);
    if (paramInt == 2) {}
    for (f1 = f4;; f1 = f3)
    {
      f2 = f1;
      break;
      if (paramInt != 3) {
        break;
      }
    }
    f4 = (this.outWidth - paramFaceFeature.width * f1) / 2.0F;
    f3 = (this.outHeight - paramFaceFeature.height * f2) / 2.0F;
    paramInt = 0;
    while (paramInt < 107)
    {
      paramArrayOfFloat1[paramInt][0] = (localObject[paramInt][0] * f1 + f4);
      paramArrayOfFloat1[paramInt][1] = (localObject[paramInt][1] * f2 + f3);
      localObject[paramInt][0] /= paramFaceFeature.width;
      localObject[paramInt][1] /= paramFaceFeature.height;
      paramInt += 1;
    }
    paramInt = this.procMethod;
    int i;
    if (paramInt == 0)
    {
      paramArrayOfFloat1[109][0] = 0;
      paramArrayOfFloat1[109][1] = 0;
      paramArrayOfFloat1[110][0] = 0;
      localObject = paramArrayOfFloat1[110];
      paramInt = this.outHeight;
      localObject[1] = (paramInt / 2.0F);
      paramArrayOfFloat1[111][0] = 0;
      paramArrayOfFloat1[111][1] = paramInt;
      localObject = paramArrayOfFloat1[112];
      i = this.outWidth;
      localObject[0] = (i / 2.0F);
      paramArrayOfFloat1[112][1] = paramInt;
      paramArrayOfFloat1[113][0] = i;
      paramArrayOfFloat1[113][1] = paramInt;
      paramArrayOfFloat1[114][0] = i;
      paramArrayOfFloat1[114][1] = (paramInt / 2.0F);
      paramArrayOfFloat1[115][0] = i;
      paramArrayOfFloat1[115][1] = 0;
      paramArrayOfFloat1[116][0] = (i / 2.0F);
      paramArrayOfFloat1[116][1] = 0;
      f1 = f4 / (paramFaceFeature.width * f1);
      f3 /= paramFaceFeature.height * f2;
      paramFaceFeature = paramArrayOfFloat2[109];
      f4 = -f1;
      paramFaceFeature[0] = f4;
      paramFaceFeature = paramArrayOfFloat2[109];
      f2 = -f3;
      paramFaceFeature[1] = f2;
      paramArrayOfFloat2[110][0] = f4;
      paramArrayOfFloat2[110][1] = 1056964608;
      paramArrayOfFloat2[111][0] = f4;
      paramFaceFeature = paramArrayOfFloat2[111];
      f3 += 1.0F;
      paramFaceFeature[1] = f3;
      paramArrayOfFloat2[112][0] = 1056964608;
      paramArrayOfFloat2[112][1] = f3;
      paramFaceFeature = paramArrayOfFloat2[113];
      f1 += 1.0F;
      paramFaceFeature[0] = f1;
      paramArrayOfFloat2[113][1] = f3;
      paramArrayOfFloat2[114][0] = f1;
      paramArrayOfFloat2[114][1] = 1056964608;
      paramArrayOfFloat2[115][0] = f1;
      paramArrayOfFloat2[115][1] = f2;
      paramArrayOfFloat2[116][0] = 1056964608;
      paramArrayOfFloat2[116][1] = f2;
      return;
    }
    if (paramInt == 1) {
      return;
    }
    if (paramInt == 2)
    {
      paramArrayOfFloat1[109][0] = f4;
      paramArrayOfFloat1[109][1] = f3;
      paramArrayOfFloat1[110][0] = f4;
      paramFaceFeature = paramArrayOfFloat1[110];
      paramInt = this.outHeight;
      paramFaceFeature[1] = (paramInt / 2.0F);
      paramArrayOfFloat1[111][0] = f4;
      paramArrayOfFloat1[111][1] = (paramInt - f3);
      paramFaceFeature = paramArrayOfFloat1[112];
      i = this.outWidth;
      paramFaceFeature[0] = (i / 2.0F);
      paramArrayOfFloat1[112][1] = (paramInt - f3);
      paramArrayOfFloat1[113][0] = (i - f4);
      paramArrayOfFloat1[113][1] = (paramInt - f3);
      paramArrayOfFloat1[114][0] = (i - f4);
      paramArrayOfFloat1[114][1] = (paramInt / 2.0F);
      paramArrayOfFloat1[115][0] = (i - f4);
      paramArrayOfFloat1[115][1] = f3;
      paramArrayOfFloat1[116][0] = (i / 2.0F);
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
    }
  }
  
  private static void initTriangleIndices()
  {
    System.arraycopy(FaceOffUtil.FaceMeshTrianglesFaceAverage, 0, triangleArray, 0, FaceOffUtil.FaceMeshTrianglesFaceAverage.length);
    int[] arrayOfInt = triangleArray;
    arrayOfInt[552] = 109;
    arrayOfInt[553] = 99;
    arrayOfInt[554] = 110;
    arrayOfInt[555] = 110;
    arrayOfInt[556] = 99;
    arrayOfInt[557] = 101;
    arrayOfInt[558] = 110;
    arrayOfInt[559] = 101;
    arrayOfInt[560] = 111;
    arrayOfInt[561] = 111;
    arrayOfInt[562] = 101;
    arrayOfInt[563] = 112;
    arrayOfInt[564] = 112;
    arrayOfInt[565] = 101;
    arrayOfInt[566] = 103;
    arrayOfInt[567] = 113;
    arrayOfInt[568] = 112;
    arrayOfInt[569] = 103;
    arrayOfInt[570] = 103;
    arrayOfInt[571] = 114;
    arrayOfInt[572] = 113;
    arrayOfInt[573] = 103;
    arrayOfInt[574] = 105;
    arrayOfInt[575] = 114;
    arrayOfInt[576] = 105;
    arrayOfInt[577] = 115;
    arrayOfInt[578] = 114;
    arrayOfInt[579] = 105;
    arrayOfInt[580] = 116;
    arrayOfInt[581] = 115;
    arrayOfInt[582] = 105;
    arrayOfInt[583] = 99;
    arrayOfInt[584] = 116;
    arrayOfInt[585] = 116;
    arrayOfInt[586] = 99;
    arrayOfInt[587] = 109;
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
  }
  
  public Frame getMergedFrame(float paramFloat)
  {
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    FrameUtil.clearFrame(this.outFrame, 0.0F, 0.0F, 0.0F, 1.0F, this.outWidth, this.outHeight);
    GlUtil.setBlendMode(true);
    generateVertexCoordv1(this.vPT1, this.vPT2, paramFloat, 1);
    setPositions(this.vertexCoord);
    setTexCords(this.fragCoord1);
    addParam(new UniformParam.FloatParam("alphaBlend", 1.0F - paramFloat));
    float[][] arrayOfFloat = this.vPT1;
    int i = arrayOfFloat[109][0];
    i = arrayOfFloat[113][0];
    i = arrayOfFloat[109][1];
    i = arrayOfFloat[113][1];
    addParam(new UniformParam.Float4fParam("cropRect", 0.0F, 1.0F, 0.0F, 1.0F));
    RenderProcess(this.faceFeatureBitmap1.faceTex, this.outWidth, this.outHeight, -1, 0.0D, this.outFrame);
    generateVertexCoordv1(this.vPT1, this.vPT2, paramFloat, 2);
    setPositions(this.vertexCoord);
    setTexCords(this.fragCoord2);
    addParam(new UniformParam.FloatParam("alphaBlend", paramFloat));
    arrayOfFloat = this.vPT2;
    i = arrayOfFloat[109][0];
    i = arrayOfFloat[113][0];
    i = arrayOfFloat[109][1];
    i = arrayOfFloat[113][1];
    addParam(new UniformParam.Float4fParam("cropRect", 0.0F, 1.0F, 0.0F, 1.0F));
    RenderProcess(this.faceFeatureBitmap2.faceTex, this.outWidth, this.outHeight, -1, 0.0D, this.outFrame);
    GlUtil.setBlendMode(false);
    return this.outFrame;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("alphaBlend", 0.0F));
    addParam(new UniformParam.Float4fParam("cropRect", 0.0F, 1.0F, 0.0F, 1.0F));
  }
  
  public void updateFaceParmas(FaceFeatureTex paramFaceFeatureTex1, FaceFeatureTex paramFaceFeatureTex2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.faceFeatureBitmap1 = paramFaceFeatureTex1;
    this.faceFeatureBitmap2 = paramFaceFeatureTex2;
    this.outWidth = paramInt1;
    this.outHeight = paramInt2;
    this.backgroundMode1 = paramInt3;
    this.backgroundMode2 = paramInt4;
    updateTextureCoords();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.outWidth = paramInt1;
    this.outHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CFTransformFilterForWesee
 * JD-Core Version:    0.7.0.1
 */