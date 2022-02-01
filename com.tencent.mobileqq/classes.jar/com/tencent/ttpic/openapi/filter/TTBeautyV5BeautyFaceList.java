package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class TTBeautyV5BeautyFaceList
{
  public static final String TAG = BeautyFaceList.class.getName();
  private int age = 0;
  private float beautyLevel = 0.0F;
  private ByteBuffer dstByteBuffer = ByteBuffer.allocateDirect(1048).order(ByteOrder.nativeOrder());
  private float eyepouchLevel = 0.0F;
  private float[] faceVertices = new float[1380];
  private int height;
  private boolean isFemale = true;
  private boolean isGenderGhanged = false;
  private boolean isLUT1LoadSuccess = false;
  private boolean isLUT2LoadSuccess = false;
  private String lastLutPath = null;
  private String lastLutStyleMaskPath = null;
  private BeautyAIParam mBeautyAIParam = new BeautyAIParam();
  private TTBeautyV5BeautyEffectCombineFilter2 mBeautyEffectCombineFilter = new TTBeautyV5BeautyEffectCombineFilter2();
  private TTBeautyV5EyeBagBlurFilter mBlurFilter1 = new TTBeautyV5EyeBagBlurFilter();
  private Frame mBlurFrame1 = new Frame();
  private Frame mBlurFrame2 = new Frame();
  private SkinColorAndContrastFilter mContrastFilter = new SkinColorAndContrastFilter();
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  byte[] mData = null;
  private TTBeautyV5DeepBlurFilter mDeepBlurFilter = new TTBeautyV5DeepBlurFilter();
  private double mFaceDetScale;
  private TTBeautyV5FaceFeatureAndTeethWhitenFilter mFaceFeatureAndTeethWhitenFilter = new TTBeautyV5FaceFeatureAndTeethWhitenFilter();
  private TTBeautyV5FaceFeatureFilter mFaceFeatureFilter = new TTBeautyV5FaceFeatureFilter();
  private int mRenderIndex = 0;
  private boolean mRenderLipsLut = false;
  private float mSmoothOpacity = 0.0F;
  private float mSmoothOpacity2 = 0.0F;
  private int[] mTextures = new int[5];
  private float mToothWhiten = 0.0F;
  private TTBeautyV5WrinklesRemoveFilter2 mWrinklesRemoveFilter2 = new TTBeautyV5WrinklesRemoveFilter2();
  private boolean openFaceFeture = true;
  private float[] pointVisVertices = new float[1380];
  private float smoothLevel = 0.0F;
  private float smoothLevel2 = 0.0F;
  private FloatBuffer srcByteBuffer = ByteBuffer.allocateDirect(1440).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private int width;
  
  private List<PointF> getFullCoords(List<PointF> paramList)
  {
    if (paramList.size() < 90) {
      return paramList;
    }
    int i = paramList.size();
    int j = 0;
    Object localObject = paramList;
    if (i > 90) {
      localObject = paramList.subList(0, 90);
    }
    paramList = new float[262];
    float[] arrayOfFloat = new float[((List)localObject).size() * 2];
    i = 0;
    while (i < ((List)localObject).size())
    {
      int k = i * 2;
      arrayOfFloat[k] = ((PointF)((List)localObject).get(i)).x;
      arrayOfFloat[(k + 1)] = ((PointF)((List)localObject).get(i)).y;
      i += 1;
    }
    this.srcByteBuffer.rewind();
    this.srcByteBuffer.put(arrayOfFloat).position(0);
    FaceOffUtil.getFullCoords(this.srcByteBuffer, ((List)localObject).size(), 5.0F, this.dstByteBuffer);
    this.dstByteBuffer.asFloatBuffer().get(paramList);
    localObject = new ArrayList();
    i = j;
    while (i < paramList.length)
    {
      ((List)localObject).add(new PointF(paramList[i], paramList[(i + 1)]));
      i += 2;
    }
    return localObject;
  }
  
  private void initData(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.mData == null) || (this.mData.length < paramInt1 * paramInt2 * 4)) {
        this.mData = new byte[paramInt1 * paramInt2 * 4];
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private boolean isFirstFewFrames()
  {
    return this.mRenderIndex < 20;
  }
  
  private boolean loadLut(Bitmap paramBitmap, int paramInt)
  {
    if (BitmapUtils.isLegal(paramBitmap))
    {
      GlUtil.loadTexture(paramInt, paramBitmap);
      return true;
    }
    return false;
  }
  
  private void updateSmoothOpacity()
  {
    if (this.mSmoothOpacity > 0.01F)
    {
      float f = this.mSmoothOpacity2;
      if (f > 0.01F)
      {
        this.mWrinklesRemoveFilter2.setSmoothOpacity(f);
        this.mBeautyEffectCombineFilter.setSmoothOpacity2(0.0F);
        this.mBeautyEffectCombineFilter.setSmoothOpacity(this.mSmoothOpacity);
        return;
      }
    }
    if (this.mSmoothOpacity > 0.01F)
    {
      this.mWrinklesRemoveFilter2.setSmoothOpacity(0.0F);
      this.mBeautyEffectCombineFilter.setSmoothOpacity2(0.0F);
      this.mBeautyEffectCombineFilter.setSmoothOpacity(this.mSmoothOpacity);
      return;
    }
    if (this.mSmoothOpacity2 > 0.01F)
    {
      this.mWrinklesRemoveFilter2.setSmoothOpacity(0.0F);
      this.mBeautyEffectCombineFilter.setSmoothOpacity2(this.mSmoothOpacity2);
      this.mBeautyEffectCombineFilter.setSmoothOpacity(0.0F);
      return;
    }
    this.mWrinklesRemoveFilter2.setSmoothOpacity(0.0F);
    this.mBeautyEffectCombineFilter.setSmoothOpacity2(0.0F);
    this.mBeautyEffectCombineFilter.setSmoothOpacity(0.0F);
  }
  
  public void apply()
  {
    this.mBeautyEffectCombineFilter.ApplyGLSLFilter();
    this.mFaceFeatureAndTeethWhitenFilter.ApplyGLSLFilter();
    this.mFaceFeatureFilter.ApplyGLSLFilter();
    this.mWrinklesRemoveFilter2.ApplyGLSLFilter();
    this.mBlurFilter1.ApplyGLSLFilter();
    this.mContrastFilter.apply();
    this.mCopyFilter.apply();
    this.mDeepBlurFilter.applyFilterChain(true, 0.0F, 0.0F);
    this.lastLutPath = null;
  }
  
  public void clear()
  {
    this.isFemale = true;
    this.isGenderGhanged = false;
    this.lastLutPath = null;
    this.mBeautyEffectCombineFilter.clearGLSLSelf();
    this.mFaceFeatureAndTeethWhitenFilter.clearGLSLSelf();
    this.mFaceFeatureFilter.clearGLSLSelf();
    this.mWrinklesRemoveFilter2.clearGLSLSelf();
    this.mBlurFilter1.clearGLSLSelf();
    this.mDeepBlurFilter.clearGLSL();
    this.mCopyFilter.clearGLSL();
    this.mContrastFilter.clearGLSL();
    this.mBlurFrame1.clear();
    this.mBlurFrame2.clear();
    int[] arrayOfInt = this.mTextures;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void forceAvgEyeBag() {}
  
  public void initial()
  {
    apply();
    loadBitmaps();
  }
  
  public void loadBitmaps()
  {
    Bitmap localBitmap1 = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_hongrun.png");
    Bitmap localBitmap2 = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_baixi.png");
    int[] arrayOfInt = this.mTextures;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    if (loadLut(localBitmap1, this.mTextures[0])) {
      this.isLUT1LoadSuccess = true;
    }
    if (loadLut(localBitmap2, this.mTextures[1])) {
      this.isLUT2LoadSuccess = true;
    }
    this.mFaceFeatureFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "female_beauty_normal.png", "female_beauty_multiply.png", "female_beauty_softlight.png"));
    this.mFaceFeatureAndTeethWhitenFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "female_beauty_normal.png", "female_beauty_multiply.png", "female_beauty_softlight.png"));
  }
  
  public float[] pointsVis(Float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0))
    {
      float[] arrayOfFloat = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        arrayOfFloat[i] = paramArrayOfFloat[i].floatValue();
        i += 1;
      }
      return arrayOfFloat;
    }
    return null;
  }
  
  public Frame render2(Frame paramFrame, List<List<PointF>> paramList, List<Float[]> paramList1, List<FaceStatus> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    while (i < paramList.size())
    {
      List localList = VideoMaterial.copyList((List)paramList.get(i));
      Object localObject = FaceOffUtil.getFullCoords(localList, 5.0F);
      double d2 = this.width;
      double d1 = this.mFaceDetScale;
      Double.isNaN(d2);
      int j = (int)(d2 * d1);
      d2 = this.height;
      Double.isNaN(d2);
      FaceOffUtil.initFacePositions((List)localObject, j, (int)(d2 * d1), this.faceVertices);
      localObject = new float[0];
      if (paramList1.size() > i) {
        localObject = FaceOffUtil.initPointVis(FaceOffUtil.getFullPointsVisForFaceOffFilter(pointsVis((Float[])paramList1.get(i))), this.pointVisVertices);
      }
      if ((paramList2 != null) && (paramList2.size() > i))
      {
        boolean bool1;
        if (((FaceStatus)paramList2.get(i)).gender == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2;
        if (this.isFemale != bool1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.isGenderGhanged = bool2;
        this.isFemale = bool1;
        if (BeautyAIParam.needAIBeautyValid()) {
          j = ((FaceStatus)paramList2.get(i)).age;
        } else {
          j = 0;
        }
        this.age = j;
      }
      this.mBeautyAIParam.setBeautyParam(this.isFemale, this.age, paramBoolean2);
      this.mSmoothOpacity = (this.smoothLevel + this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.WRINKLES, this.beautyLevel));
      this.mSmoothOpacity2 = (this.smoothLevel2 + this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.FLW, this.beautyLevel));
      updateSmoothOpacity();
      this.mBeautyEffectCombineFilter.setEyePouchOpacity((this.eyepouchLevel + this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.POUCH, this.beautyLevel)) * 1.2F);
      if (this.isGenderGhanged) {
        if (this.isFemale)
        {
          this.mFaceFeatureFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "female_beauty_normal.png", "female_beauty_multiply.png", "female_beauty_softlight.png"));
          this.mFaceFeatureAndTeethWhitenFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "female_beauty_normal.png", "female_beauty_multiply.png", "female_beauty_softlight.png"));
        }
        else
        {
          this.mFaceFeatureFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "male_beauty_normal.png", "male_beauty_multiply.png", "beauty_softlight.png"));
          this.mFaceFeatureAndTeethWhitenFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "male_beauty_normal.png", "male_beauty_multiply.png", "beauty_softlight.png"));
        }
      }
      Frame localFrame1;
      if ((((FaceStatus)paramList2.get(i)).gender != 2) && (this.openFaceFeture == true))
      {
        if ((this.mToothWhiten <= 0.01F) && (!this.mRenderLipsLut))
        {
          if ((!paramBoolean1) && (this.mFaceFeatureFilter.needRender()))
          {
            localObject = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
            this.mFaceFeatureFilter.updateParam(this.faceVertices);
            this.mFaceFeatureFilter.OnDrawFrameGLSL();
            this.mFaceFeatureFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
            paramFrame.unlock();
            paramFrame = (Frame)localObject;
          }
        }
        else if (this.mFaceFeatureAndTeethWhitenFilter.needRender())
        {
          localFrame1 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          this.mFaceFeatureAndTeethWhitenFilter.updateParam(localList, this.faceVertices, (float[])localObject);
          this.mFaceFeatureAndTeethWhitenFilter.OnDrawFrameGLSL();
          this.mFaceFeatureAndTeethWhitenFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          paramFrame.unlock();
          paramFrame = localFrame1;
        }
      }
      else if ((this.mToothWhiten <= 0.01F) && (!this.mRenderLipsLut))
      {
        if ((!paramBoolean1) && (this.mFaceFeatureFilter.needRender()))
        {
          localObject = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          this.mFaceFeatureFilter.updateParam(this.faceVertices);
          this.mFaceFeatureFilter.OnDrawFrameGLSL();
          this.mFaceFeatureFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          paramFrame.unlock();
          paramFrame = (Frame)localObject;
        }
      }
      else if (this.mFaceFeatureAndTeethWhitenFilter.needRender())
      {
        localFrame1 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        this.mFaceFeatureAndTeethWhitenFilter.updateParam(localList, this.faceVertices, (float[])localObject);
        this.mFaceFeatureAndTeethWhitenFilter.OnDrawFrameGLSL();
        this.mFaceFeatureAndTeethWhitenFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        paramFrame.unlock();
        paramFrame = localFrame1;
      }
      float f;
      int k;
      Frame localFrame2;
      if (this.mWrinklesRemoveFilter2.needRender())
      {
        f = Math.min(1.0F, 360.0F / Math.min(paramFrame.width, paramFrame.height));
        j = Math.round(paramFrame.width * f);
        k = Math.round(paramFrame.height * f);
        this.mDeepBlurFilter.updateSize(j, k);
        localFrame1 = this.mDeepBlurFilter.RenderProcess(paramFrame.getTextureId(), j, k);
        localFrame2 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), j, k);
        this.mWrinklesRemoveFilter2.setSmallTexture(localFrame2.getTextureId());
        this.mWrinklesRemoveFilter2.setBlurTexture(localFrame1.getTextureId());
        localObject = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        this.mWrinklesRemoveFilter2.updateParam(localList, this.faceVertices);
        this.mWrinklesRemoveFilter2.OnDrawFrameGLSL();
        this.mWrinklesRemoveFilter2.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        paramFrame.unlock();
        localFrame1.unlock();
        localFrame2.unlock();
        paramFrame = (Frame)localObject;
      }
      if (this.mBeautyEffectCombineFilter.needRender())
      {
        j = Math.min(paramFrame.width, paramFrame.height);
        f = this.mBeautyEffectCombineFilter.getEyePouchOpacity();
        localFrame1 = null;
        if ((f <= 0.0F) && (this.mBeautyEffectCombineFilter.getSmoothOpacity() <= 0.0F) && (this.mBeautyEffectCombineFilter.getSmoothOpacity2() <= 0.0F))
        {
          localObject = null;
        }
        else
        {
          f = Math.min(1.0F, 360.0F / j);
          k = Math.round(paramFrame.width * f);
          int m = Math.round(paramFrame.height * f);
          this.mDeepBlurFilter.updateSize(k, m);
          localFrame1 = this.mDeepBlurFilter.RenderProcess(paramFrame.getTextureId(), k, m);
          localObject = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), k, m);
          this.mBeautyEffectCombineFilter.setSmallTexture(((Frame)localObject).getTextureId());
          this.mBeautyEffectCombineFilter.setBlurTexture(localFrame1.getTextureId());
        }
        f = Math.min(1.0F, 480.0F / j);
        j = Math.round(paramFrame.width * f);
        k = Math.round(paramFrame.height * f);
        this.mBeautyEffectCombineFilter.setLightenSize(j, k);
        localFrame2 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        this.mBeautyEffectCombineFilter.updateParam(localList, this.faceVertices);
        this.mBeautyEffectCombineFilter.OnDrawFrameGLSL();
        this.mBeautyEffectCombineFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        paramFrame.unlock();
        if (localFrame1 != null) {
          localFrame1.unlock();
        }
        paramFrame = localFrame2;
        if (localObject != null)
        {
          ((Frame)localObject).unlock();
          paramFrame = localFrame2;
        }
      }
      i += 1;
    }
    if ((this.mContrastFilter.needRender()) && (this.isLUT1LoadSuccess) && (this.isLUT2LoadSuccess))
    {
      paramList = this.mContrastFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      paramFrame.unlock();
      paramFrame = paramList;
    }
    this.mRenderIndex += 1;
    return paramFrame;
  }
  
  public void resetCosDefaultEffect()
  {
    this.mFaceFeatureFilter.resetCosDefaultEffect();
    this.mFaceFeatureAndTeethWhitenFilter.resetCosDefaultEffect();
  }
  
  public void resetEyeBagColors()
  {
    this.mRenderIndex = 0;
  }
  
  public void setBeautyLevel(float paramFloat)
  {
    this.beautyLevel = paramFloat;
  }
  
  public void setContrastLevel(int paramInt)
  {
    this.mContrastFilter.setContrastLevel(paramInt);
  }
  
  public void setEyeOpacity(float paramFloat)
  {
    this.mBeautyEffectCombineFilter.setEyeOpacity(paramFloat);
  }
  
  public void setEyePouchOpacity(float paramFloat)
  {
    this.eyepouchLevel = paramFloat;
    this.mBeautyEffectCombineFilter.setEyePouchOpacity(paramFloat * 1.2F);
  }
  
  public void setFaceFeatureMultiplyAlpha(float paramFloat)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setMultiplyAlphaValue(paramFloat);
    this.mFaceFeatureFilter.setMultiplyAlphaValue(paramFloat);
  }
  
  public void setFaceFeatureNormalAlpha(float paramFloat)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setNormalAlphaValue(paramFloat);
    this.mFaceFeatureFilter.setNormalAlphaValue(paramFloat);
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setFaceFeatureParam(paramFaceFeatureParam);
    this.mFaceFeatureFilter.setFaceFeatureParam(paramFaceFeatureParam);
  }
  
  public void setFaceFeatureSoftlightAlpha(float paramFloat)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setSoftlightAlphaValue(paramFloat);
    this.mFaceFeatureFilter.setSoftlightAlphaValue(paramFloat);
  }
  
  public void setLipsLut(String paramString)
  {
    Object localObject = this.lastLutPath;
    if ((localObject != null) && (((String)localObject).equals(paramString))) {
      return;
    }
    this.lastLutPath = paramString;
    localObject = null;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.startsWith("assets://")) {
        localObject = BitmapUtils.decodeSampledBitmapFromFile(paramString, 1);
      } else {
        localObject = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 1);
      }
    }
    if (BitmapUtils.isLegal((Bitmap)localObject))
    {
      this.mRenderLipsLut = true;
      GlUtil.loadTexture(this.mTextures[3], (Bitmap)localObject);
      this.mFaceFeatureAndTeethWhitenFilter.setLipsLutTexture(this.mTextures[3]);
      return;
    }
    this.mRenderLipsLut = false;
    this.mFaceFeatureAndTeethWhitenFilter.setLipsLutTexture(0);
  }
  
  public void setLipsLutAlpha(int paramInt)
  {
    if (this.mRenderLipsLut)
    {
      this.mFaceFeatureAndTeethWhitenFilter.setLipsLutAlpha(paramInt);
      return;
    }
    this.mFaceFeatureAndTeethWhitenFilter.setLipsLutAlpha(0);
  }
  
  public void setLipsStyleMaskPath(String paramString)
  {
    Object localObject = this.lastLutStyleMaskPath;
    if ((localObject != null) && (((String)localObject).equals(paramString))) {
      return;
    }
    this.lastLutStyleMaskPath = paramString;
    localObject = null;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.startsWith("assets://")) {
        localObject = BitmapUtils.decodeSampledBitmapFromFile(paramString, 1);
      } else {
        localObject = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 1);
      }
    }
    if (BitmapUtils.isLegal((Bitmap)localObject))
    {
      GlUtil.loadTexture(this.mTextures[4], (Bitmap)localObject);
      this.mFaceFeatureAndTeethWhitenFilter.setLipsStyleMaskPath(this.mTextures[4]);
      return;
    }
    this.mFaceFeatureAndTeethWhitenFilter.setLipsStyleMaskPath(0);
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    this.mFaceFeatureAndTeethWhitenFilter.setNormalAlphaFactor(paramFloat);
    this.mFaceFeatureFilter.setNormalAlphaFactor(paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mBeautyEffectCombineFilter.setRenderMode(paramInt);
    this.mFaceFeatureAndTeethWhitenFilter.setRenderMode(paramInt);
    this.mFaceFeatureFilter.setRenderMode(paramInt);
    this.mWrinklesRemoveFilter2.setRenderMode(paramInt);
    this.mContrastFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public void setShowFaceFeatureFilter(boolean paramBoolean)
  {
    this.openFaceFeture = paramBoolean;
  }
  
  public void setSkinColorAlpha(float paramFloat)
  {
    Bitmap localBitmap;
    boolean bool;
    if (!this.isLUT1LoadSuccess)
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_hongrun.png");
      if (localBitmap != null) {
        bool = true;
      } else {
        bool = false;
      }
      AEOpenRenderConfig.checkStrictMode(bool, "color_tone_hongrun.png is null");
      if (loadLut(localBitmap, this.mTextures[0])) {
        this.isLUT1LoadSuccess = true;
      }
    }
    if (!this.isLUT2LoadSuccess)
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_baixi.png");
      if (localBitmap != null) {
        bool = true;
      } else {
        bool = false;
      }
      AEOpenRenderConfig.checkStrictMode(bool, "color_tone_baixi.png is null");
      if (loadLut(localBitmap, this.mTextures[1])) {
        this.isLUT2LoadSuccess = true;
      }
    }
    if (paramFloat < 0.0F)
    {
      this.mContrastFilter.updateSkinColorValue(Math.abs(paramFloat), this.mTextures[0]);
      return;
    }
    this.mContrastFilter.updateSkinColorValue(Math.abs(paramFloat), this.mTextures[1]);
  }
  
  public void setSmoothOpacity(float paramFloat)
  {
    this.smoothLevel = paramFloat;
    this.mSmoothOpacity = this.smoothLevel;
    updateSmoothOpacity();
  }
  
  public void setSmoothOpacity2(float paramFloat)
  {
    this.smoothLevel2 = paramFloat;
    this.mSmoothOpacity2 = this.smoothLevel2;
    updateSmoothOpacity();
  }
  
  public void setToothWhitenAlpha(float paramFloat)
  {
    this.mToothWhiten = paramFloat;
    this.mFaceFeatureAndTeethWhitenFilter.setToothWhitenAlphaValue(paramFloat);
  }
  
  public void updateFilterBlendImage(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt >= 0))
    {
      paramString = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
      GlUtil.loadTexture(this.mTextures[2], paramString);
      if (BitmapUtils.isLegal(paramString)) {
        paramString.recycle();
      }
      this.mContrastFilter.setBlendImage(this.mTextures[2], paramInt);
      return;
    }
    this.mContrastFilter.clearBlendImage();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mBeautyEffectCombineFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mWrinklesRemoveFilter2.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mFaceFeatureAndTeethWhitenFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mFaceFeatureFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.width = paramInt1;
    this.height = paramInt2;
    this.mFaceDetScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5BeautyFaceList
 * JD-Core Version:    0.7.0.1
 */