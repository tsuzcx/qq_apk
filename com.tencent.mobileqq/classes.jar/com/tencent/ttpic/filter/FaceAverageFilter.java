package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.VideoMaterial.FaceImageLayer;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceDetectUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FaceAverageFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision mediump float;\n varying lowp vec2 textureCoordinate;\n varying lowp vec2 textureCoordinate2;\n varying lowp vec2 textureCoordinate3;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D inputImageTexture4;\n \n uniform int drawTypeFragment;\n uniform float alphaBlend;\n \n void main(void) {\n     \n     vec4 modelColor = texture2D(inputImageTexture4, textureCoordinate);\n     vec4 userColor  = texture2D(inputImageTexture2, textureCoordinate2);\n     vec4 grayColor  = texture2D(inputImageTexture3, textureCoordinate3);\n     \n     \n     float xAlpha = alphaBlend + (1.0 - alphaBlend) * grayColor.r;\n     vec3 resultColor = userColor.rgb * (1.0 - xAlpha) + modelColor.rgb * xAlpha;\n     gl_FragColor = vec4(resultColor, 1.0);\n     \n }";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n attribute vec4 inputTextureCoordinate2;\n varying vec2 textureCoordinate2;\n \n attribute vec4 inputTextureCoordinate3;\n varying vec2 textureCoordinate3;\n \n uniform int drawTypeVertex;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     textureCoordinate2 = inputTextureCoordinate2.xy;\n     textureCoordinate3 = inputTextureCoordinate3.xy;\n }";
  private float[] faceVertices = new float[1092];
  private float[] grayVertices = new float[1092];
  private VideoMaterial.FaceImageLayer mFaceLayer = null;
  private FaceItem mItem = null;
  private Bitmap maskBitmap = null;
  private Bitmap materialBitmap = null;
  private float[] positions = new float[1092];
  private float[] texVertices = new float[1092];
  private int userTex = 0;
  
  public FaceAverageFilter(String paramString, VideoMaterial.FaceImageLayer paramFaceImageLayer)
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n attribute vec4 inputTextureCoordinate2;\n varying vec2 textureCoordinate2;\n \n attribute vec4 inputTextureCoordinate3;\n varying vec2 textureCoordinate3;\n \n uniform int drawTypeVertex;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     textureCoordinate2 = inputTextureCoordinate2.xy;\n     textureCoordinate3 = inputTextureCoordinate3.xy;\n }", " precision mediump float;\n varying lowp vec2 textureCoordinate;\n varying lowp vec2 textureCoordinate2;\n varying lowp vec2 textureCoordinate3;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D inputImageTexture4;\n \n uniform int drawTypeFragment;\n uniform float alphaBlend;\n \n void main(void) {\n     \n     vec4 modelColor = texture2D(inputImageTexture4, textureCoordinate);\n     vec4 userColor  = texture2D(inputImageTexture2, textureCoordinate2);\n     vec4 grayColor  = texture2D(inputImageTexture3, textureCoordinate3);\n     \n     \n     float xAlpha = alphaBlend + (1.0 - alphaBlend) * grayColor.r;\n     vec3 resultColor = userColor.rgb * (1.0 - xAlpha) + modelColor.rgb * xAlpha;\n     gl_FragColor = vec4(resultColor, 1.0);\n     \n }", null);
    this.dataPath = paramString;
    this.mFaceLayer = paramFaceImageLayer;
    this.materialBitmap = FaceOffUtil.getFaceBitmap(paramString + File.separator + this.mFaceLayer.imagePath);
    if (this.mFaceLayer.faceMaskImagePath != null) {}
    for (this.maskBitmap = FaceOffUtil.getFaceBitmap(paramString + File.separator + this.mFaceLayer.faceMaskImagePath);; this.maskBitmap = FaceOffUtil.getGrayBitmap(this.mFaceLayer.featureType))
    {
      initParams();
      return;
    }
  }
  
  private List<PointF> getVertexCoords(List<PointF> paramList1, List<PointF> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, float[] paramArrayOfFloat)
  {
    paramList1 = VideoMaterialUtil.copyList(paramList1);
    paramList2 = VideoMaterialUtil.copyList(paramList2);
    PointF localPointF1 = new PointF(((PointF)paramList2.get(64)).x, ((PointF)paramList2.get(64)).y);
    Object localObject = new PointF(((PointF)paramList1.get(64)).x, ((PointF)paramList1.get(64)).y);
    float f1 = (float)-Math.atan((((PointF)paramList1.get(35)).y - ((PointF)paramList1.get(45)).y) / (((PointF)paramList1.get(35)).x - ((PointF)paramList1.get(45)).x));
    f1 = paramArrayOfFloat[2] - f1;
    paramInt3 = 0;
    if (paramInt3 < paramList1.size())
    {
      if ((paramInt3 > 98) && (paramInt3 < 107)) {}
      for (;;)
      {
        paramInt3 += 1;
        break;
        f2 = ((PointF)paramList2.get(paramInt3)).x - localPointF1.x;
        f3 = ((PointF)paramList2.get(paramInt3)).y - localPointF1.y;
        double d1 = f2;
        double d2 = Math.cos(f1);
        double d3 = f3;
        double d4 = Math.sin(f1);
        double d5 = f2;
        double d6 = Math.sin(f1);
        double d7 = f3;
        double d8 = Math.cos(f1);
        ((PointF)paramList2.get(paramInt3)).x = ((float)(d1 * d2 - d3 * d4) + localPointF1.x);
        ((PointF)paramList2.get(paramInt3)).y = ((float)(d5 * d6 + d7 * d8) + localPointF1.y);
      }
    }
    f1 = localPointF1.x;
    float f2 = ((PointF)localObject).x;
    float f3 = localPointF1.y;
    float f4 = ((PointF)localObject).y;
    paramInt3 = 0;
    while (paramInt3 < paramList1.size())
    {
      ((PointF)paramList2.get(paramInt3)).x -= f1 - f2;
      ((PointF)paramList2.get(paramInt3)).y -= f3 - f4;
      paramInt3 += 1;
    }
    localPointF1 = new PointF(((PointF)paramList2.get(43)).x, ((PointF)paramList2.get(43)).y);
    PointF localPointF2 = new PointF(((PointF)paramList2.get(53)).x, ((PointF)paramList2.get(53)).y);
    new PointF(((PointF)paramList2.get(99)).x, ((PointF)paramList2.get(99)).y);
    new PointF(((PointF)paramList2.get(101)).x, ((PointF)paramList2.get(101)).y);
    new PointF(((PointF)paramList2.get(105)).x, ((PointF)paramList2.get(105)).y);
    PointF localPointF3 = new PointF(((PointF)paramList1.get(43)).x, ((PointF)paramList1.get(43)).y);
    PointF localPointF4 = new PointF(((PointF)paramList1.get(53)).x, ((PointF)paramList1.get(53)).y);
    new PointF(((PointF)paramList1.get(99)).x, ((PointF)paramList1.get(99)).y);
    new PointF(((PointF)paramList1.get(101)).x, ((PointF)paramList1.get(101)).y);
    new PointF(((PointF)paramList1.get(105)).x, ((PointF)paramList1.get(105)).y);
    f1 = AlgoUtils.getDistance(localPointF3, localPointF4) / AlgoUtils.getDistance(localPointF1, localPointF2);
    f2 = AlgoUtils.getDistance(localPointF3, localPointF4) / AlgoUtils.getDistance(localPointF1, localPointF2);
    paramInt3 = 0;
    if (paramInt3 < paramList1.size())
    {
      if ((paramInt3 >= 99) && (paramInt3 <= 106)) {}
      for (;;)
      {
        paramInt3 += 1;
        break;
        f3 = ((PointF)paramList2.get(paramInt3)).x;
        f4 = ((PointF)localObject).x;
        float f5 = ((PointF)paramList2.get(paramInt3)).y;
        float f6 = ((PointF)localObject).y;
        ((PointF)paramList2.get(paramInt3)).x += (f1 - 1.0F) * (f3 - f4);
        ((PointF)paramList2.get(paramInt3)).y += (f2 - 1.0F) * (f5 - f6);
      }
    }
    paramInt3 = 99;
    while (paramInt3 < 107)
    {
      ((PointF)paramList2.get(paramInt3)).x = ((PointF)paramList1.get(paramInt3)).x;
      ((PointF)paramList2.get(paramInt3)).y = ((PointF)paramList1.get(paramInt3)).y;
      paramInt3 += 1;
    }
    localObject = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramList2.size())
    {
      ((List)localObject).add(new PointF(((PointF)paramList2.get(paramInt3)).x, ((PointF)paramList2.get(paramInt3)).y));
      paramInt3 += 1;
    }
    paramFloat *= smootherstep(0.9F, 1.0F, (float)(Math.abs(Math.cos(paramArrayOfFloat[0])) + Math.abs(Math.cos(paramArrayOfFloat[1])) + Math.abs(Math.cos(paramArrayOfFloat[2]))) / 3.0F);
    paramInt3 = 0;
    if (paramInt3 < paramList1.size())
    {
      if ((paramInt3 >= 99) && (paramInt3 <= 106)) {}
      for (;;)
      {
        paramInt3 += 1;
        break;
        paramArrayOfFloat = (PointF)((List)localObject).get(paramInt3);
        f1 = ((PointF)paramList2.get(paramInt3)).x;
        paramArrayOfFloat.x = (((PointF)paramList1.get(paramInt3)).x * paramFloat + (1.0F - paramFloat) * f1);
        paramArrayOfFloat = (PointF)((List)localObject).get(paramInt3);
        f1 = ((PointF)paramList2.get(paramInt3)).y;
        paramArrayOfFloat.y = (((PointF)paramList1.get(paramInt3)).y * paramFloat + (1.0F - paramFloat) * f1);
      }
    }
    f1 = paramInt2 / this.height;
    paramFloat = paramInt1 / f1;
    f1 = paramInt2 / f1;
    paramList1 = new PointF((this.width - paramFloat) / 2.0F, (this.height - f1) / 2.0F);
    f2 = paramFloat / this.width;
    f2 = f1 / this.height;
    f2 = 2.0F / paramFloat;
    f2 = 2.0F / f1;
    paramFloat /= paramInt1;
    f1 /= paramInt2;
    paramInt1 = 0;
    while (paramInt1 < ((List)localObject).size())
    {
      ((PointF)((List)localObject).get(paramInt1)).x = (((PointF)((List)localObject).get(paramInt1)).x * paramFloat + paramList1.x);
      ((PointF)((List)localObject).get(paramInt1)).y = (((PointF)((List)localObject).get(paramInt1)).y * f1 + paramList1.y);
      paramInt1 += 1;
    }
    return localObject;
  }
  
  float clampf(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    List localList = FaceOffUtil.genPointsDouble(this.mFaceLayer.imageFacePoint);
    FaceDetectUtil.facePointf83to90(localList);
    addAttribParam("inputTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(FaceOffUtil.getFullCoords(localList, 3.0F), this.materialBitmap.getWidth(), this.materialBitmap.getHeight(), this.texVertices));
    if (this.mFaceLayer.faceMaskImagePath == null) {}
    for (localList = FaceOffUtil.getGrayCoords(FaceOffUtil.FEATURE_TYPE.CRAZY_FACE);; localList = FaceOffUtil.genPointsDouble(this.mFaceLayer.faceMaskFacePoint))
    {
      FaceDetectUtil.facePointf83to90(localList);
      addAttribParam("inputTextureCoordinate3", FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(FaceOffUtil.getFullCoords(localList, 3.0F), this.maskBitmap.getWidth(), this.maskBitmap.getHeight(), this.grayVertices));
      addAttribParam("inputTextureCoordinate2", this.faceVertices);
      setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
      setCoordNum(546);
      return;
    }
  }
  
  public void initParams()
  {
    addParam(new Param.TextureParam("inputImageTexture2", this.userTex, 33986));
    addParam(new Param.TextureBitmapParam("inputImageTexture3", this.maskBitmap, 33987, true));
    addParam(new Param.TextureBitmapParam("inputImageTexture4", this.materialBitmap, 33988, true));
    addParam(new Param.FloatParam("alphaBlend", (float)this.mFaceLayer.blendAlpha));
    addParam(new Param.IntParam("drawTypeFragment", 1));
    addParam(new Param.IntParam("drawTypeVertex", 1));
  }
  
  public void setUserTexture(int paramInt)
  {
    this.userTex = paramInt;
  }
  
  float smootherstep(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = clampf((paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1), 0.0F, 1.0F);
    return paramFloat1 * paramFloat1 * paramFloat1 * ((6.0F * paramFloat1 - 15.0F) * paramFloat1 + 10.0F);
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    addParam(new Param.TextureParam("inputImageTexture2", this.userTex, 33986));
    paramMap = FaceOffUtil.genPointsDouble(this.mFaceLayer.imageFacePoint);
    FaceDetectUtil.facePointf83to90(paramMap);
    paramMap = FaceOffUtil.getFullCoords(paramMap, 3.0F);
    paramList = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList), 3.0F);
    addAttribParam("inputTextureCoordinate2", FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(paramList, (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.faceVertices));
    addAttribParam("position", FaceOffUtil.initFacePositionsFaceAverage(getVertexCoords(paramMap, paramList, this.materialBitmap.getWidth(), this.materialBitmap.getHeight(), this.width, this.height, (float)this.mFaceLayer.distortionAlpha, paramArrayOfFloat), this.width, this.height, this.positions));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceAverageFilter
 * JD-Core Version:    0.7.0.1
 */