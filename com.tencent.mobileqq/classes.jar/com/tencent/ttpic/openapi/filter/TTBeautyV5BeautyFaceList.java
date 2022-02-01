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
import java.util.List<Landroid.graphics.PointF;>;

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
    int j = 0;
    if (paramList.size() < 90) {
      return paramList;
    }
    Object localObject = paramList;
    if (paramList.size() > 90) {
      localObject = paramList.subList(0, 90);
    }
    float[] arrayOfFloat = new float[262];
    paramList = new float[((List)localObject).size() * 2];
    int i = 0;
    while (i < ((List)localObject).size())
    {
      paramList[(i * 2)] = ((PointF)((List)localObject).get(i)).x;
      paramList[(i * 2 + 1)] = ((PointF)((List)localObject).get(i)).y;
      i += 1;
    }
    this.srcByteBuffer.rewind();
    this.srcByteBuffer.put(paramList).position(0);
    FaceOffUtil.getFullCoords(this.srcByteBuffer, ((List)localObject).size(), 5.0F, this.dstByteBuffer);
    this.dstByteBuffer.asFloatBuffer().get(arrayOfFloat);
    localObject = new ArrayList();
    i = j;
    for (;;)
    {
      paramList = (List<PointF>)localObject;
      if (i >= arrayOfFloat.length) {
        break;
      }
      ((List)localObject).add(new PointF(arrayOfFloat[i], arrayOfFloat[(i + 1)]));
      i += 2;
    }
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
    if ((this.mSmoothOpacity > 0.01F) && (this.mSmoothOpacity2 > 0.01F))
    {
      this.mWrinklesRemoveFilter2.setSmoothOpacity(this.mSmoothOpacity2);
      this.mBeautyEffectCombineFilter.setSmoothOpacity2(0.0F);
      this.mBeautyEffectCombineFilter.setSmoothOpacity(this.mSmoothOpacity);
      return;
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
    GLES20.glDeleteTextures(this.mTextures.length, this.mTextures, 0);
  }
  
  public void forceAvgEyeBag() {}
  
  public void initial()
  {
    this.mBeautyEffectCombineFilter.ApplyGLSLFilter();
    this.mFaceFeatureAndTeethWhitenFilter.ApplyGLSLFilter();
    this.mFaceFeatureFilter.ApplyGLSLFilter();
    this.mWrinklesRemoveFilter2.ApplyGLSLFilter();
    this.mBlurFilter1.ApplyGLSLFilter();
    this.mContrastFilter.apply();
    this.mCopyFilter.apply();
    this.mDeepBlurFilter.applyFilterChain(true, 0.0F, 0.0F);
    Bitmap localBitmap1 = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_hongrun.png");
    Bitmap localBitmap2 = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_baixi.png");
    GLES20.glGenTextures(this.mTextures.length, this.mTextures, 0);
    if (loadLut(localBitmap1, this.mTextures[0])) {
      this.isLUT1LoadSuccess = true;
    }
    if (loadLut(localBitmap2, this.mTextures[1])) {
      this.isLUT2LoadSuccess = true;
    }
    this.mFaceFeatureFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "female_beauty_normal.png", "female_beauty_multiply.png", "female_beauty_softlight.png"));
    this.mFaceFeatureAndTeethWhitenFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "female_beauty_normal.png", "female_beauty_multiply.png", "female_beauty_softlight.png"));
    this.lastLutPath = null;
  }
  
  public float[] pointsVis(Float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {
      return null;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i].floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public Frame render2(Frame paramFrame, List<List<PointF>> paramList, List<Float[]> paramList1, List<FaceStatus> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    Frame localFrame1 = paramFrame;
    List localList;
    if (i < paramList.size())
    {
      localList = VideoMaterial.copyList((List)paramList.get(i));
      FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(localList, 5.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices);
      if (paramList1.size() <= i) {
        break label1515;
      }
    }
    label147:
    label159:
    label194:
    label1239:
    label1515:
    for (Object localObject = FaceOffUtil.initPointVis(FaceOffUtil.getFullPointsVisForFaceOffFilter(pointsVis((Float[])paramList1.get(i))), this.pointVisVertices);; localObject = new float[0])
    {
      boolean bool1;
      boolean bool2;
      int j;
      if ((paramList2 != null) && (paramList2.size() > i))
      {
        if (((FaceStatus)paramList2.get(i)).gender == 1)
        {
          bool1 = true;
          if (this.isFemale == bool1) {
            break label1066;
          }
          bool2 = true;
          this.isGenderGhanged = bool2;
          this.isFemale = bool1;
          if (!BeautyAIParam.needAIBeautyValid()) {
            break label1072;
          }
          j = ((FaceStatus)paramList2.get(i)).age;
          this.age = j;
        }
      }
      else
      {
        this.mBeautyAIParam.setBeautyParam(this.isFemale, this.age, paramBoolean2);
        this.mSmoothOpacity = (this.smoothLevel + this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.WRINKLES, this.beautyLevel));
        this.mSmoothOpacity2 = (this.smoothLevel2 + this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.FLW, this.beautyLevel));
        updateSmoothOpacity();
        this.mBeautyEffectCombineFilter.setEyePouchOpacity((this.eyepouchLevel + this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.POUCH, this.beautyLevel)) * 1.2F);
        if (this.isGenderGhanged)
        {
          if (!this.isFemale) {
            break label1078;
          }
          this.mFaceFeatureFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "female_beauty_normal.png", "female_beauty_multiply.png", "female_beauty_softlight.png"));
          this.mFaceFeatureAndTeethWhitenFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "female_beauty_normal.png", "female_beauty_multiply.png", "female_beauty_softlight.png"));
        }
        label375:
        if ((((FaceStatus)paramList2.get(i)).gender == 2) || (this.openFaceFeture != true)) {
          break label1239;
        }
        if ((this.mToothWhiten <= 0.01F) && (!this.mRenderLipsLut)) {
          break label1145;
        }
        paramFrame = localFrame1;
        if (this.mFaceFeatureAndTeethWhitenFilter.needRender())
        {
          paramFrame = this.mCopyFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
          this.mFaceFeatureAndTeethWhitenFilter.updateParam(localList, this.faceVertices, (float[])localObject);
          this.mFaceFeatureAndTeethWhitenFilter.OnDrawFrameGLSL();
          this.mFaceFeatureAndTeethWhitenFilter.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
          localFrame1.unlock();
        }
      }
      for (;;)
      {
        localFrame1 = paramFrame;
        float f;
        int k;
        Frame localFrame2;
        if (this.mWrinklesRemoveFilter2.needRender())
        {
          f = Math.min(1.0F, 360.0F / Math.min(paramFrame.width, paramFrame.height));
          j = Math.round(paramFrame.width * f);
          k = Math.round(f * paramFrame.height);
          this.mDeepBlurFilter.updateSize(j, k);
          localObject = this.mDeepBlurFilter.RenderProcess(paramFrame.getTextureId(), j, k);
          localFrame2 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), j, k);
          this.mWrinklesRemoveFilter2.setSmallTexture(localFrame2.getTextureId());
          this.mWrinklesRemoveFilter2.setBlurTexture(((Frame)localObject).getTextureId());
          localFrame1 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          this.mWrinklesRemoveFilter2.updateParam(localList, this.faceVertices);
          this.mWrinklesRemoveFilter2.OnDrawFrameGLSL();
          this.mWrinklesRemoveFilter2.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          paramFrame.unlock();
          ((Frame)localObject).unlock();
          localFrame2.unlock();
        }
        paramFrame = localFrame1;
        if (this.mBeautyEffectCombineFilter.needRender())
        {
          j = Math.min(localFrame1.width, localFrame1.height);
          localObject = null;
          paramFrame = null;
          if ((this.mBeautyEffectCombineFilter.getEyePouchOpacity() > 0.0F) || (this.mBeautyEffectCombineFilter.getSmoothOpacity() > 0.0F) || (this.mBeautyEffectCombineFilter.getSmoothOpacity2() > 0.0F))
          {
            f = Math.min(1.0F, 360.0F / j);
            k = Math.round(localFrame1.width * f);
            int m = Math.round(f * localFrame1.height);
            this.mDeepBlurFilter.updateSize(k, m);
            localObject = this.mDeepBlurFilter.RenderProcess(localFrame1.getTextureId(), k, m);
            paramFrame = this.mCopyFilter.RenderProcess(localFrame1.getTextureId(), k, m);
            this.mBeautyEffectCombineFilter.setSmallTexture(paramFrame.getTextureId());
            this.mBeautyEffectCombineFilter.setBlurTexture(((Frame)localObject).getTextureId());
          }
          f = Math.min(1.0F, 480.0F / j);
          j = Math.round(localFrame1.width * f);
          k = Math.round(f * localFrame1.height);
          this.mBeautyEffectCombineFilter.setLightenSize(j, k);
          localFrame2 = this.mCopyFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
          this.mBeautyEffectCombineFilter.updateParam(localList, this.faceVertices);
          this.mBeautyEffectCombineFilter.OnDrawFrameGLSL();
          this.mBeautyEffectCombineFilter.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
          localFrame1.unlock();
          if (localObject != null) {
            ((Frame)localObject).unlock();
          }
          if (paramFrame != null) {
            paramFrame.unlock();
          }
          paramFrame = localFrame2;
        }
        i += 1;
        localFrame1 = paramFrame;
        break;
        bool1 = false;
        break label147;
        bool2 = false;
        break label159;
        j = 0;
        break label194;
        this.mFaceFeatureFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "male_beauty_normal.png", "male_beauty_multiply.png", "beauty_softlight.png"));
        this.mFaceFeatureAndTeethWhitenFilter.setFaceFeatureParam(new FaceFeatureParam(0.8F, 0.8F, 0.8F, "male_beauty_normal.png", "male_beauty_multiply.png", "beauty_softlight.png"));
        break label375;
        label1145:
        paramFrame = localFrame1;
        if (!paramBoolean1)
        {
          paramFrame = localFrame1;
          if (this.mFaceFeatureFilter.needRender())
          {
            paramFrame = this.mCopyFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
            this.mFaceFeatureFilter.updateParam(this.faceVertices);
            this.mFaceFeatureFilter.OnDrawFrameGLSL();
            this.mFaceFeatureFilter.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
            localFrame1.unlock();
            continue;
            if ((this.mToothWhiten > 0.01F) || (this.mRenderLipsLut))
            {
              paramFrame = localFrame1;
              if (this.mFaceFeatureAndTeethWhitenFilter.needRender())
              {
                paramFrame = this.mCopyFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
                this.mFaceFeatureAndTeethWhitenFilter.updateParam(localList, this.faceVertices, (float[])localObject);
                this.mFaceFeatureAndTeethWhitenFilter.OnDrawFrameGLSL();
                this.mFaceFeatureAndTeethWhitenFilter.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
                localFrame1.unlock();
              }
            }
            else
            {
              paramFrame = localFrame1;
              if (!paramBoolean1)
              {
                paramFrame = localFrame1;
                if (this.mFaceFeatureFilter.needRender())
                {
                  paramFrame = this.mCopyFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
                  this.mFaceFeatureFilter.updateParam(this.faceVertices);
                  this.mFaceFeatureFilter.OnDrawFrameGLSL();
                  this.mFaceFeatureFilter.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
                  localFrame1.unlock();
                }
              }
            }
          }
        }
      }
      paramFrame = localFrame1;
      if (this.mContrastFilter.needRender())
      {
        paramFrame = localFrame1;
        if (this.isLUT1LoadSuccess)
        {
          paramFrame = localFrame1;
          if (this.isLUT2LoadSuccess)
          {
            paramFrame = this.mContrastFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
            localFrame1.unlock();
          }
        }
      }
      this.mRenderIndex += 1;
      return paramFrame;
    }
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
    this.mBeautyEffectCombineFilter.setEyePouchOpacity(1.2F * paramFloat);
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
    if ((this.lastLutPath != null) && (this.lastLutPath.equals(paramString))) {
      return;
    }
    this.lastLutPath = paramString;
    Bitmap localBitmap = null;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("assets://")) {
        break label85;
      }
    }
    label85:
    for (localBitmap = BitmapUtils.decodeSampledBitmapFromFile(paramString, 1); BitmapUtils.isLegal(localBitmap); localBitmap = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 1))
    {
      this.mRenderLipsLut = true;
      GlUtil.loadTexture(this.mTextures[3], localBitmap);
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
    if ((this.lastLutStyleMaskPath != null) && (this.lastLutStyleMaskPath.equals(paramString))) {
      return;
    }
    this.lastLutStyleMaskPath = paramString;
    Bitmap localBitmap = null;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("assets://")) {
        break label80;
      }
    }
    label80:
    for (localBitmap = BitmapUtils.decodeSampledBitmapFromFile(paramString, 1); BitmapUtils.isLegal(localBitmap); localBitmap = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 1))
    {
      GlUtil.loadTexture(this.mTextures[4], localBitmap);
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
    if (!this.isLUT1LoadSuccess)
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_hongrun.png");
      if (localBitmap == null) {
        break label122;
      }
      bool = true;
      AEOpenRenderConfig.checkStrictMode(bool, "color_tone_hongrun.png is null");
      if (loadLut(localBitmap, this.mTextures[0])) {
        this.isLUT1LoadSuccess = true;
      }
    }
    if (!this.isLUT2LoadSuccess)
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap("color_tone_baixi.png");
      if (localBitmap == null) {
        break label127;
      }
    }
    label122:
    label127:
    for (boolean bool = true;; bool = false)
    {
      AEOpenRenderConfig.checkStrictMode(bool, "color_tone_baixi.png is null");
      if (loadLut(localBitmap, this.mTextures[1])) {
        this.isLUT2LoadSuccess = true;
      }
      if (paramFloat >= 0.0F) {
        break label132;
      }
      this.mContrastFilter.updateSkinColorValue(Math.abs(paramFloat), this.mTextures[0]);
      return;
      bool = false;
      break;
    }
    label132:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5BeautyFaceList
 * JD-Core Version:    0.7.0.1
 */