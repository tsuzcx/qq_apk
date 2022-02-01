package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.model.FaceFeature;
import com.tencent.ttpic.openapi.model.ChangedFaceParam;
import com.tencent.ttpic.openapi.model.CosFunParam;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.openapi.util.YoutuPointsUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CFFaceOffFilter
  extends VideoFilterBase
{
  private static final String TAG = "CFFaceOffFilter";
  private FaceImageLayer mFaceLayer;
  private String mFolder;
  private int mImageHeight;
  private int mImageWidth;
  private List<PointF> mMergedFacePoints;
  private int[] maskTex = new int[1];
  private float[] maskTexVertices = new float[1104];
  private float[] materialTexVertices = new float[1104];
  private float[] positions = new float[1104];
  private float[] userTexVertices = new float[1104];
  
  public CFFaceOffFilter(String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.CFFACEOFF));
    this.mFolder = paramString;
    initParams();
  }
  
  private List<PointF> adjustUsrFacePoints(List<PointF> paramList, FaceImageLayer paramFaceImageLayer)
  {
    if (paramFaceImageLayer.extraFacePointsArray == null) {
      return paramList;
    }
    int i = 0;
    while ((i < paramFaceImageLayer.extraFacePointsArray.size()) && (i < paramFaceImageLayer.extraDistortionAlphaArray.size()))
    {
      List localList = (List)paramFaceImageLayer.extraFacePointsArray.get(i);
      if (localList.size() >= 166)
      {
        double d1 = ((Double)paramFaceImageLayer.extraDistortionAlphaArray.get(i)).doubleValue();
        if (d1 > 0.9D) {
          return paramList;
        }
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        double d2;
        double d3;
        while (j < localList.size() / 2)
        {
          int k = j * 2;
          d2 = ((Double)localList.get(k)).doubleValue();
          d3 = ((Double)localList.get(k + 1)).doubleValue();
          localArrayList.add(new PointF((float)d2, (float)d3));
          j += 1;
        }
        FaceDetectUtil.facePointf83to90(localArrayList);
        FaceOffUtil.getFullCoords(localArrayList, 2.0F);
        FaceOffUtil.getCropNormalFaceFeature(localArrayList);
        localList = VideoMaterial.copyList(paramList);
        j = 0;
        while (j < localArrayList.size())
        {
          if ((j < 99) || (j > 106))
          {
            PointF localPointF = (PointF)localList.get(j);
            d3 = ((PointF)localArrayList.get(j)).x;
            d2 = 1.0D - d1;
            Double.isNaN(d3);
            double d4 = ((PointF)paramList.get(j)).x;
            Double.isNaN(d4);
            localPointF.x = ((float)(d3 * d2 + d4 * d1));
            localPointF = (PointF)localList.get(j);
            d3 = ((PointF)localArrayList.get(j)).y;
            Double.isNaN(d3);
            d4 = ((PointF)paramList.get(j)).y;
            Double.isNaN(d4);
            localPointF.y = ((float)(d3 * d2 + d4 * d1));
          }
          j += 1;
        }
        float f1 = ((PointF)localList.get(18)).x;
        float f2 = ((PointF)localList.get(0)).x;
        float f3 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
        f1 = f3 / ((f1 - f2 - f3) * 0.6F + f3);
        j = 0;
        while (j < localArrayList.size())
        {
          if ((j < 99) || (j > 106))
          {
            ((PointF)localList.get(j)).x = (((PointF)localList.get(64)).x + (((PointF)localList.get(j)).x - ((PointF)localList.get(64)).x) * f1);
            ((PointF)localList.get(j)).y = (((PointF)localList.get(64)).y + (((PointF)localList.get(j)).y - ((PointF)localList.get(64)).y) * f1);
          }
          j += 1;
        }
        paramList = VideoMaterial.copyList(localList);
      }
      i += 1;
    }
    return paramList;
  }
  
  private List<PointF> getVertexCoords(List<PointF> paramList1, List<PointF> paramList2, int paramInt1, int paramInt2, float paramFloat, FaceImageLayer paramFaceImageLayer)
  {
    Object localObject1 = VideoMaterial.copyList(paramList1);
    YoutuPointsUtil.normalizePoints((List)localObject1);
    FaceDetectUtil.facePointf83to90((List)localObject1);
    Object localObject2 = FaceOffUtil.getFullCoords((List)localObject1, 2.0F);
    ArrayList localArrayList = new ArrayList();
    localObject1 = new ArrayList();
    float f1 = AlgoUtils.getDistance((PointF)paramList1.get(99), (PointF)paramList1.get(105));
    float f2 = AlgoUtils.getDistance((PointF)paramList1.get(99), (PointF)paramList1.get(101));
    PointF localPointF1 = new PointF(((PointF)paramList1.get(105)).x - ((PointF)paramList1.get(99)).x, ((PointF)paramList1.get(105)).y - ((PointF)paramList1.get(99)).y);
    PointF localPointF2 = new PointF(((PointF)paramList1.get(101)).x - ((PointF)paramList1.get(99)).x, ((PointF)paramList1.get(101)).y - ((PointF)paramList1.get(99)).y);
    int i = 0;
    while (i < paramList1.size())
    {
      ((List)localObject1).add(new PointF(((PointF)((List)localObject2).get(i)).x / f1, ((PointF)((List)localObject2).get(i)).y / f2));
      localArrayList.add(new PointF(((PointF)paramList2.get(i)).x / paramInt1, ((PointF)paramList2.get(i)).y / paramInt2));
      i += 1;
    }
    paramList2 = adjustUsrFacePoints(localArrayList, paramFaceImageLayer);
    paramFaceImageLayer = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < ((List)localObject1).size())
    {
      paramFaceImageLayer.add(new PointF());
      if ((paramInt1 >= 99) && (paramInt1 <= 106))
      {
        ((PointF)paramFaceImageLayer.get(paramInt1)).x = ((PointF)((List)localObject1).get(paramInt1)).x;
        ((PointF)paramFaceImageLayer.get(paramInt1)).y = ((PointF)((List)localObject1).get(paramInt1)).y;
      }
      else
      {
        localObject2 = (PointF)paramFaceImageLayer.get(paramInt1);
        f1 = ((PointF)paramList2.get(paramInt1)).x;
        f2 = 1.0F - paramFloat;
        ((PointF)localObject2).x = (f1 * f2 + ((PointF)((List)localObject1).get(paramInt1)).x * paramFloat);
        ((PointF)paramFaceImageLayer.get(paramInt1)).y = (((PointF)paramList2.get(paramInt1)).y * f2 + ((PointF)((List)localObject1).get(paramInt1)).y * paramFloat);
      }
      paramInt1 += 1;
    }
    paramFloat = ((PointF)paramFaceImageLayer.get(18)).x;
    i = 0;
    f1 = ((PointF)paramFaceImageLayer.get(0)).x;
    f2 = ((PointF)((List)localObject1).get(18)).x - ((PointF)((List)localObject1).get(0)).x;
    paramFloat = f2 / ((paramFloat - f1 - f2) * 0.6F + f2);
    paramInt1 = 0;
    for (;;)
    {
      paramInt2 = i;
      if (paramInt1 >= ((List)localObject1).size()) {
        break;
      }
      if ((paramInt1 < 99) || (paramInt1 > 106))
      {
        ((PointF)paramFaceImageLayer.get(paramInt1)).x = (((PointF)paramFaceImageLayer.get(64)).x + (((PointF)paramFaceImageLayer.get(paramInt1)).x - ((PointF)paramFaceImageLayer.get(64)).x) * paramFloat);
        ((PointF)paramFaceImageLayer.get(paramInt1)).y = (((PointF)paramFaceImageLayer.get(64)).y + (((PointF)paramFaceImageLayer.get(paramInt1)).y - ((PointF)paramFaceImageLayer.get(64)).y) * paramFloat);
      }
      paramInt1 += 1;
    }
    while (paramInt2 < paramFaceImageLayer.size())
    {
      paramFloat = ((PointF)paramFaceImageLayer.get(paramInt2)).x;
      f1 = ((PointF)paramFaceImageLayer.get(paramInt2)).y;
      ((PointF)paramFaceImageLayer.get(paramInt2)).x = (((PointF)paramList1.get(99)).x + localPointF1.x * paramFloat + localPointF2.x * f1);
      ((PointF)paramFaceImageLayer.get(paramInt2)).y = (((PointF)paramList1.get(99)).y + localPointF1.y * paramFloat + localPointF2.y * f1);
      paramInt2 += 1;
    }
    return paramFaceImageLayer;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    int[] arrayOfInt = this.maskTex;
    GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void clearGLSLSelf()
  {
    int[] arrayOfInt = this.maskTex;
    GlUtil.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    super.clearGLSLSelf();
  }
  
  public FaceFeature getFaceFeature()
  {
    return new FaceFeature(this.mMergedFacePoints, this.width, this.height);
  }
  
  public List<PointF> getMergedFacePoints()
  {
    return this.mMergedFacePoints;
  }
  
  public void initAttribParams()
  {
    addAttribParam("position", this.positions);
    addAttribParam("inputTextureCoordinate", this.materialTexVertices);
    addAttribParam("inputTextureCoordinate2", this.userTexVertices);
    addAttribParam("inputTextureCoordinate3", this.maskTexVertices);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("drawTypeFragment", 0));
    addParam(new UniformParam.Float3fParam("userColor1", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Float3fParam("userColor2", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Float3fParam("modelColor1", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Float3fParam("modelColor2", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.FloatParam("alphaBlend", 0.0F));
  }
  
  public void setFaceLayer(FaceImageLayer paramFaceImageLayer)
  {
    this.mFaceLayer = paramFaceImageLayer;
    if ((TextUtils.isEmpty(this.mFaceLayer.faceMaskImagePath) ^ true))
    {
      paramFaceImageLayer = new StringBuilder();
      paramFaceImageLayer.append(this.mFolder);
      paramFaceImageLayer.append(File.separator);
      paramFaceImageLayer.append(this.mFaceLayer.faceMaskImagePath);
      paramFaceImageLayer = FaceOffUtil.getFaceBitmap(paramFaceImageLayer.toString());
    }
    else
    {
      Bitmap localBitmap = FaceOffUtil.getCrazySkinMergeMask(this.mFolder);
      paramFaceImageLayer = localBitmap;
      if (!BitmapUtils.isLegal(localBitmap)) {
        paramFaceImageLayer = FaceOffUtil.getGrayBitmap(this.mFaceLayer.featureType);
      }
    }
    if (!BitmapUtils.isLegal(paramFaceImageLayer)) {
      return;
    }
    this.mImageWidth = paramFaceImageLayer.getWidth();
    this.mImageHeight = paramFaceImageLayer.getHeight();
    GlUtil.loadTexture(this.maskTex[0], paramFaceImageLayer);
    BitmapUtils.recycle(paramFaceImageLayer);
    addParam(new UniformParam.TextureParam("inputImageTexture3", this.maskTex[0], 33987));
    addParam(new UniformParam.FloatParam("alphaBlend", (float)this.mFaceLayer.blendAlpha));
  }
  
  public void setFacePointsInfo(List<PointF> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    List localList = FaceOffUtil.genPointsDouble(this.mFaceLayer.imageFacePoint);
    FaceOffUtil.scalePoints(localList, this.mFaceDetScale);
    FaceDetectUtil.facePointf83to90(localList);
    localList = FaceOffUtil.getFullCoords(localList, 2.0F);
    FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(localList, this.width, this.height, this.materialTexVertices, paramInt3);
    paramList = VideoMaterial.copyList(paramList);
    FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(paramList, paramInt1, paramInt2, this.userTexVertices, paramInt3);
    this.mMergedFacePoints = getVertexCoords(localList, paramList, paramInt1, paramInt2, (float)this.mFaceLayer.distortionAlpha, this.mFaceLayer);
    FaceOffUtil.initFacePositionsFaceAverage(this.mMergedFacePoints, this.width, this.height, this.positions, paramInt3);
    if ((this.mFaceLayer.faceMaskFacePoint != null) && (this.mFaceLayer.faceMaskFacePoint.size() > 0)) {
      paramList = FaceOffUtil.getMaskCoords(this.mFaceLayer.faceMaskFacePoint);
    } else {
      paramList = FaceOffUtil.getGrayCoords(this.mFaceLayer.featureType);
    }
    FaceDetectUtil.facePointf83to90(paramList);
    FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(FaceOffUtil.getFullCoords(paramList, 2.0F), this.mImageWidth, this.mImageHeight, this.maskTexVertices, paramInt3);
    initAttribParams();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(552);
  }
  
  public void setSkinColorParams(ChangedFaceParam paramChangedFaceParam)
  {
    addParam(new UniformParam.IntParam("drawTypeFragment", this.mFaceLayer.getVersion()));
    addParam(paramChangedFaceParam.userColor1);
    addParam(paramChangedFaceParam.userColor2);
    addParam(paramChangedFaceParam.modelColor1);
    addParam(paramChangedFaceParam.modelColor2);
  }
  
  public void setSkinColorParams(CosFunParam paramCosFunParam)
  {
    addParam(new UniformParam.IntParam("drawTypeFragment", this.mFaceLayer.getVersion()));
    addParam(paramCosFunParam.userColor1);
    addParam(paramCosFunParam.userColor2);
    addParam(paramCosFunParam.modelColor1);
    addParam(paramCosFunParam.modelColor2);
  }
  
  public void setUserFaceTex(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.CFFaceOffFilter
 * JD-Core Version:    0.7.0.1
 */