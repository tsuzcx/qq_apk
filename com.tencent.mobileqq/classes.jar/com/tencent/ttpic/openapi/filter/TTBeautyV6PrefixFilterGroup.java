package com.tencent.ttpic.openapi.filter;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class TTBeautyV6PrefixFilterGroup
{
  private int age = 0;
  private boolean isFemale = true;
  private boolean isOverall = false;
  private String lastLutPath;
  private BeautyAIParam mBeautyAIParam = new BeautyAIParam();
  private float mBlurStrength = 0.4F;
  private boolean mCurveArrayAssignNeeded = true;
  private byte[] mCurveByteArray = new byte[1024];
  private ByteBuffer mCurveByteBuffer;
  private int mCurveCounter = 5;
  private int[] mCurveIntArray = new int[256];
  private boolean mCurveStable = false;
  private TTV6SmoothMultiFaceMaskFilter mFaceMaskFilter = new TTV6SmoothMultiFaceMaskFilter();
  private float mFaceSizeFactor = 0.0F;
  private TTV6SmoothFirstBlurFilter mFirstBlurFilter = new TTV6SmoothFirstBlurFilter();
  private TTV6SmoothFirstBlurMixFilter mFirstBlurMixFilter = new TTV6SmoothFirstBlurMixFilter();
  private boolean mForce = false;
  private TTV6SmoothSecondBlurBorder1Filter mSecondBlurBorder1Filter = new TTV6SmoothSecondBlurBorder1Filter();
  private TTV6SmoothSecondBlurBorder2Filter mSecondBlurBorder2Filter = new TTV6SmoothSecondBlurBorder2Filter();
  private TTV6SmoothSecondBorderBlurFilter mSecondBorderBlurFilter = new TTV6SmoothSecondBorderBlurFilter();
  private float mSharpenStrength = 1.2F;
  private TTV6SmoothSmoothProcessFilter mSmoothProcessFilter = new TTV6SmoothSmoothProcessFilter();
  private int[] mTextures = new int[3];
  
  private void updateBlurAndSharpenStrength(boolean paramBoolean, PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramPTFaceAttr != null)
    {
      f1 = f2;
      if (paramPTFaceAttr.getAllFacePoints() != null)
      {
        f1 = f2;
        if (!paramPTFaceAttr.getAllFacePoints().isEmpty())
        {
          f1 = f2;
          if (paramInt1 > 0)
          {
            f1 = f2;
            if (paramInt2 > 0)
            {
              Iterator localIterator = paramPTFaceAttr.getAllFacePoints().iterator();
              f1 = 0.0F;
              if (localIterator.hasNext())
              {
                RectF localRectF = AlgoUtils.getFaceRectF((List)localIterator.next());
                if (localRectF == null) {
                  break label282;
                }
                f2 = (float)(paramInt1 * paramPTFaceAttr.getFaceDetectScale());
                float f3 = (float)(paramInt2 * paramPTFaceAttr.getFaceDetectScale());
                float f4 = localRectF.width();
                f1 = Math.max(f1, localRectF.height() * f4 / f2 / f3);
              }
            }
          }
        }
      }
    }
    label282:
    for (;;)
    {
      break;
      if (this.isOverall)
      {
        this.mFaceSizeFactor = 1.0F;
        f1 = this.mBlurStrength / 0.6F;
        this.mSmoothProcessFilter.setBlurAlpha(f1);
        this.mFirstBlurFilter.setBlurStrength(f1);
        this.mFirstBlurMixFilter.setBlurStrength(Math.max(0.0F, Math.min(1.0F, 10.0F * f1)));
        f1 = Math.max(0.0F, Math.min(0.2F, f1)) * 1.2F / 0.2F;
        this.mSmoothProcessFilter.setSharpenAlpha(f1);
        return;
      }
      f1 = Math.min(0.04F, f1) / 0.04F;
      if (paramBoolean) {}
      for (;;)
      {
        this.mFaceSizeFactor = f1;
        break;
        f1 = f1 * 0.2F + this.mFaceSizeFactor * 0.8F;
      }
    }
  }
  
  public void apply()
  {
    this.mFaceMaskFilter.apply();
    this.mFirstBlurFilter.apply();
    this.mFirstBlurMixFilter.apply();
    this.mSecondBlurBorder1Filter.apply();
    this.mSecondBlurBorder2Filter.apply();
    this.mSecondBorderBlurFilter.apply();
    this.mSmoothProcessFilter.apply();
    GLES20.glGenTextures(this.mTextures.length, this.mTextures, 0);
    this.lastLutPath = null;
  }
  
  public void clear()
  {
    this.mFaceMaskFilter.clearGLSLSelf();
    this.mFirstBlurFilter.clearGLSL();
    this.mFirstBlurMixFilter.clearGLSL();
    this.mSecondBlurBorder1Filter.clearGLSL();
    this.mSecondBlurBorder2Filter.clearGLSL();
    this.mSecondBorderBlurFilter.clearGLSL();
    this.mSmoothProcessFilter.clearGLSL();
    GLES20.glDeleteTextures(this.mTextures.length, this.mTextures, 0);
    this.lastLutPath = null;
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    if ((paramFrame.width == 0) || (paramFrame.height == 0)) {
      return paramFrame;
    }
    this.mBeautyAIParam.setBeautyParam(this.isFemale, this.age, true);
    this.mBlurStrength = (this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.BEAUTY, this.mBlurStrength / 0.6F) * 0.6F);
    updateBlurAndSharpenStrength(this.mForce, paramPTFaceAttr, paramFrame.width, paramFrame.height);
    float f = Math.min(1.0F, 360.0F / Math.min(paramFrame.width, paramFrame.height));
    int i = Math.round(paramFrame.width * f);
    int j = Math.round(f * paramFrame.height);
    f = Math.min(1.0F, 180.0F / Math.min(paramFrame.width, paramFrame.height));
    int k = Math.round(paramFrame.width * f);
    int m = Math.round(f * paramFrame.height);
    Frame localFrame2 = FrameBufferCache.getInstance().get(k, m);
    FrameUtil.clearFrame(localFrame2, 0.0F, 0.0F, 0.0F, 1.0F, k, m);
    Frame localFrame1 = paramFrame;
    if (this.mBlurStrength > 0.0D)
    {
      GlUtil.setBlendMode(true);
      if ((paramPTFaceAttr != null) && (!paramPTFaceAttr.getAllFacePoints().isEmpty()))
      {
        this.mFaceMaskFilter.updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
        this.mFaceMaskFilter.updateParam(paramPTFaceAttr.getAllFacePoints());
        this.mFaceMaskFilter.OnDrawFrameGLSL();
        this.mFaceMaskFilter.renderTexture(paramFrame.getTextureId(), k, m);
      }
      GlUtil.setBlendMode(false);
      this.mFirstBlurFilter.setTextureOffset(0.0F, 2.5F / j);
      this.mFirstBlurFilter.setFaceSkinMaskTexture(localFrame2.getTextureId());
      paramPTFaceAttr = this.mFirstBlurFilter.RenderProcess(paramFrame.getTextureId(), i, j);
      this.mFirstBlurFilter.setTextureOffset(2.5F / i, 0.0F);
      localFrame3 = this.mFirstBlurFilter.RenderProcess(paramPTFaceAttr.getTextureId(), i, j);
      this.mFirstBlurMixFilter.setFaceSkinMaskTexture(localFrame2.getTextureId());
      this.mFirstBlurMixFilter.setBlurTexture(localFrame3.getTextureId());
      localFrame1 = this.mFirstBlurMixFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      paramPTFaceAttr.unlock();
      localFrame3.unlock();
      paramFrame.unlock();
    }
    this.mSecondBlurBorder1Filter.setTextureOffset(1.0F / k, 0.0F);
    paramFrame = this.mSecondBlurBorder1Filter.RenderProcess(localFrame1.getTextureId(), k, m);
    this.mSecondBlurBorder2Filter.setTextureOffset(0.0F, 1.0F / m);
    paramPTFaceAttr = this.mSecondBlurBorder2Filter.RenderProcess(paramFrame.getTextureId(), k, m);
    this.mSecondBorderBlurFilter.setTextureOffset(0.0F, 1.0F / m);
    Frame localFrame3 = this.mSecondBorderBlurFilter.RenderProcess(paramPTFaceAttr.getTextureId(), k, m);
    this.mSecondBorderBlurFilter.setTextureOffset(1.0F / k, 0.0F);
    Frame localFrame4 = this.mSecondBorderBlurFilter.RenderProcess(localFrame3.getTextureId(), k, m);
    this.mSmoothProcessFilter.setTextureOffset(1.0F / localFrame1.width, 1.0F / localFrame1.height);
    this.mSmoothProcessFilter.setTextures(localFrame4.getTextureId(), localFrame2.getTextureId());
    Frame localFrame5 = this.mSmoothProcessFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
    localFrame1.unlock();
    localFrame2.unlock();
    paramFrame.unlock();
    paramPTFaceAttr.unlock();
    localFrame3.unlock();
    localFrame4.unlock();
    return localFrame5;
  }
  
  public void resetToneCurveTexture()
  {
    this.mCurveStable = true;
    int i = 0;
    while (i < 256)
    {
      this.mCurveIntArray[i] = i;
      i += 1;
    }
    i = 0;
    while (i < 256)
    {
      this.mCurveByteArray[(i * 4)] = ((byte)this.mCurveIntArray[i]);
      this.mCurveByteArray[(i * 4 + 1)] = ((byte)this.mCurveIntArray[i]);
      this.mCurveByteArray[(i * 4 + 2)] = ((byte)this.mCurveIntArray[i]);
      this.mCurveByteArray[(i * 4 + 3)] = -1;
      i += 1;
    }
    this.mCurveByteBuffer = ByteBuffer.wrap(this.mCurveByteArray);
    GLES20.glBindTexture(3553, this.mTextures[0]);
    GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, this.mCurveByteBuffer);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindTexture(3553, 0);
    this.mSmoothProcessFilter.setLookUpCurve(this.mTextures[0]);
  }
  
  public void setExposureValue(int paramInt)
  {
    this.mSmoothProcessFilter.setExposureValue(paramInt);
  }
  
  public void setLookUpLeftIntensity(float paramFloat)
  {
    this.mSmoothProcessFilter.setLutLeftIntensity(paramFloat);
  }
  
  public void setLookUpLeftPath(String paramString)
  {
    if ((this.lastLutPath != null) && (this.lastLutPath.equals(paramString))) {}
    do
    {
      return;
      this.lastLutPath = paramString;
      paramString = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
    } while (!BitmapUtils.isLegal(paramString));
    GlUtil.loadTexture(this.mTextures[1], paramString);
    this.mSmoothProcessFilter.setLookUpLeft(this.mTextures[1]);
    BitmapUtils.recycle(paramString);
  }
  
  public void setLookUpLeftTexture(int paramInt)
  {
    this.mSmoothProcessFilter.setLookUpLeft(paramInt);
  }
  
  public void setLookUpPosition(float paramFloat)
  {
    this.mSmoothProcessFilter.setLutPosition(paramFloat);
  }
  
  public void setLookUpRightIntensity(float paramFloat)
  {
    this.mSmoothProcessFilter.setLutRightIntensity(paramFloat);
  }
  
  public void setLookUpRightPath(String paramString)
  {
    paramString = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
    if (BitmapUtils.isLegal(paramString))
    {
      GlUtil.loadTexture(this.mTextures[2], paramString);
      this.mSmoothProcessFilter.setLookUpRight(this.mTextures[2]);
      BitmapUtils.recycle(paramString);
    }
  }
  
  public void setLookUpRightTexture(int paramInt)
  {
    this.mSmoothProcessFilter.setLookUpRight(paramInt);
  }
  
  public void setOverall(boolean paramBoolean)
  {
    this.isOverall = paramBoolean;
  }
  
  public void setSmoothBlurAlpha(float paramFloat)
  {
    this.mBlurStrength = paramFloat;
  }
  
  public void setSmoothSharpenSize(float paramFloat1, float paramFloat2)
  {
    this.mSmoothProcessFilter.setTextureOffset(1.0F / paramFloat1, 1.0F / paramFloat2);
  }
  
  public void setSmoothSharpenStrength(float paramFloat)
  {
    this.mSharpenStrength = paramFloat;
  }
  
  public void setWhitenStrength(float paramFloat)
  {
    this.mSmoothProcessFilter.setWhitenStrength(paramFloat);
  }
  
  public void updateBlurAndSharpenStrength(boolean paramBoolean)
  {
    this.mForce = paramBoolean;
  }
  
  public void updateToneCurveTexture(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      this.mCurveStable = true;
      this.mCurveArrayAssignNeeded = false;
      System.arraycopy(paramArrayOfInt, 0, this.mCurveIntArray, 0, 256);
      i = 0;
      while (i < 256)
      {
        this.mCurveByteArray[(i * 4)] = ((byte)this.mCurveIntArray[i]);
        this.mCurveByteArray[(i * 4 + 1)] = ((byte)this.mCurveIntArray[i]);
        this.mCurveByteArray[(i * 4 + 2)] = ((byte)this.mCurveIntArray[i]);
        this.mCurveByteArray[(i * 4 + 3)] = -1;
        i += 1;
      }
    }
    if (this.mCurveArrayAssignNeeded)
    {
      this.mCurveArrayAssignNeeded = false;
      System.arraycopy(paramArrayOfInt, 0, this.mCurveIntArray, 0, 256);
    }
    if (paramArrayOfInt[''] == this.mCurveIntArray['']) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((this.mCurveStable) && (!paramBoolean)) {
        this.mCurveCounter = 5;
      }
      this.mCurveStable = paramBoolean;
      if (paramBoolean) {
        break;
      }
      this.mCurveCounter = Math.max(1, this.mCurveCounter - 1);
      int[] arrayOfInt = new int[256];
      i = 0;
      while (i < 256)
      {
        arrayOfInt[i] = ((paramArrayOfInt[i] - this.mCurveIntArray[i]) / this.mCurveCounter + this.mCurveIntArray[i]);
        this.mCurveIntArray[i] = arrayOfInt[i];
        i += 1;
      }
      break;
    }
    this.mCurveByteBuffer = ByteBuffer.wrap(this.mCurveByteArray);
    GLES20.glBindTexture(3553, this.mTextures[0]);
    GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, this.mCurveByteBuffer);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindTexture(3553, 0);
    this.mSmoothProcessFilter.setLookUpCurve(this.mTextures[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV6PrefixFilterGroup
 * JD-Core Version:    0.7.0.1
 */