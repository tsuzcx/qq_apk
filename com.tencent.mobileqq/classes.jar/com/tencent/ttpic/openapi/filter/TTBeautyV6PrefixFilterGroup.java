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
    if ((paramPTFaceAttr != null) && (paramPTFaceAttr.getAllFacePoints() != null) && (!paramPTFaceAttr.getAllFacePoints().isEmpty()) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      Iterator localIterator = paramPTFaceAttr.getAllFacePoints().iterator();
      f1 = 0.0F;
      for (;;)
      {
        f2 = f1;
        if (!localIterator.hasNext()) {
          break;
        }
        RectF localRectF = AlgoUtils.getFaceRectF((List)localIterator.next());
        if (localRectF != null)
        {
          double d1 = paramInt1;
          double d2 = paramPTFaceAttr.getFaceDetectScale();
          Double.isNaN(d1);
          f2 = (float)(d1 * d2);
          d1 = paramInt2;
          d2 = paramPTFaceAttr.getFaceDetectScale();
          Double.isNaN(d1);
          float f3 = (float)(d1 * d2);
          f1 = Math.max(f1, localRectF.width() * localRectF.height() / f2 / f3);
        }
      }
    }
    float f2 = 0.0F;
    if (this.isOverall)
    {
      this.mFaceSizeFactor = 1.0F;
    }
    else
    {
      f1 = Math.min(0.04F, f2) / 0.04F;
      if (!paramBoolean) {
        f1 = f1 * 0.2F + this.mFaceSizeFactor * 0.8F;
      }
      this.mFaceSizeFactor = f1;
    }
    float f1 = this.mBlurStrength / 0.6F;
    this.mSmoothProcessFilter.setBlurAlpha(f1);
    this.mFirstBlurFilter.setBlurStrength(f1);
    this.mFirstBlurMixFilter.setBlurStrength(Math.max(0.0F, Math.min(1.0F, 10.0F * f1)));
    f1 = Math.max(0.0F, Math.min(0.2F, f1)) * 1.2F / 0.2F;
    this.mSmoothProcessFilter.setSharpenAlpha(f1);
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
    int[] arrayOfInt = this.mTextures;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
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
    int[] arrayOfInt = this.mTextures;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.lastLutPath = null;
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame2 = paramFrame;
    if (localFrame2.width != 0)
    {
      if (localFrame2.height == 0) {
        return localFrame2;
      }
      this.mBeautyAIParam.setBeautyParam(this.isFemale, this.age, true);
      this.mBlurStrength = (this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.BEAUTY, this.mBlurStrength / 0.6F) * 0.6F);
      updateBlurAndSharpenStrength(this.mForce, paramPTFaceAttr, localFrame2.width, localFrame2.height);
      float f1 = Math.min(1.0F, 360.0F / Math.min(localFrame2.width, localFrame2.height));
      int i = Math.round(localFrame2.width * f1);
      int j = Math.round(localFrame2.height * f1);
      f1 = Math.min(1.0F, 180.0F / Math.min(localFrame2.width, localFrame2.height));
      int k = Math.round(localFrame2.width * f1);
      int m = Math.round(localFrame2.height * f1);
      Frame localFrame3 = FrameBufferCache.getInstance().get(k, m);
      FrameUtil.clearFrame(localFrame3, 0.0F, 0.0F, 0.0F, 1.0F, k, m);
      Frame localFrame1 = localFrame2;
      if (this.mBlurStrength > 0.0D)
      {
        GlUtil.setBlendMode(true);
        if ((paramPTFaceAttr != null) && (!paramPTFaceAttr.getAllFacePoints().isEmpty()))
        {
          this.mFaceMaskFilter.updateVideoSize(localFrame2.width, localFrame2.height, paramPTFaceAttr.getFaceDetectScale());
          this.mFaceMaskFilter.updateParam(paramPTFaceAttr.getAllFacePoints());
          this.mFaceMaskFilter.OnDrawFrameGLSL();
          this.mFaceMaskFilter.renderTexture(paramFrame.getTextureId(), k, m);
        }
        GlUtil.setBlendMode(false);
        this.mFirstBlurFilter.setTextureOffset(0.0F, 2.5F / j);
        this.mFirstBlurFilter.setFaceSkinMaskTexture(localFrame3.getTextureId());
        paramPTFaceAttr = this.mFirstBlurFilter.RenderProcess(paramFrame.getTextureId(), i, j);
        this.mFirstBlurFilter.setTextureOffset(2.5F / i, 0.0F);
        localFrame4 = this.mFirstBlurFilter.RenderProcess(paramPTFaceAttr.getTextureId(), i, j);
        this.mFirstBlurMixFilter.setFaceSkinMaskTexture(localFrame3.getTextureId());
        this.mFirstBlurMixFilter.setBlurTexture(localFrame4.getTextureId());
        localFrame1 = this.mFirstBlurMixFilter.RenderProcess(paramFrame.getTextureId(), localFrame2.width, localFrame2.height);
        paramPTFaceAttr.unlock();
        localFrame4.unlock();
        paramFrame.unlock();
      }
      paramFrame = this.mSecondBlurBorder1Filter;
      f1 = 1.0F / k;
      paramFrame.setTextureOffset(f1, 0.0F);
      paramFrame = this.mSecondBlurBorder1Filter.RenderProcess(localFrame1.getTextureId(), k, m);
      paramPTFaceAttr = this.mSecondBlurBorder2Filter;
      float f2 = 1.0F / m;
      paramPTFaceAttr.setTextureOffset(0.0F, f2);
      paramPTFaceAttr = this.mSecondBlurBorder2Filter.RenderProcess(paramFrame.getTextureId(), k, m);
      this.mSecondBorderBlurFilter.setTextureOffset(0.0F, f2);
      localFrame2 = this.mSecondBorderBlurFilter.RenderProcess(paramPTFaceAttr.getTextureId(), k, m);
      this.mSecondBorderBlurFilter.setTextureOffset(f1, 0.0F);
      Frame localFrame4 = this.mSecondBorderBlurFilter.RenderProcess(localFrame2.getTextureId(), k, m);
      this.mSmoothProcessFilter.setTextureOffset(1.0F / localFrame1.width, 1.0F / localFrame1.height);
      this.mSmoothProcessFilter.setTextures(localFrame4.getTextureId(), localFrame3.getTextureId());
      Frame localFrame5 = this.mSmoothProcessFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
      localFrame1.unlock();
      localFrame3.unlock();
      paramFrame.unlock();
      paramPTFaceAttr.unlock();
      localFrame2.unlock();
      localFrame4.unlock();
      return localFrame5;
    }
    return localFrame2;
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
      byte[] arrayOfByte = this.mCurveByteArray;
      int j = i * 4;
      int[] arrayOfInt = this.mCurveIntArray;
      arrayOfByte[j] = ((byte)arrayOfInt[i]);
      arrayOfByte[(j + 1)] = ((byte)arrayOfInt[i]);
      arrayOfByte[(j + 2)] = ((byte)arrayOfInt[i]);
      arrayOfByte[(j + 3)] = -1;
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
    String str = this.lastLutPath;
    if ((str != null) && (str.equals(paramString))) {
      return;
    }
    this.lastLutPath = paramString;
    paramString = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
    if (BitmapUtils.isLegal(paramString))
    {
      GlUtil.loadTexture(this.mTextures[1], paramString);
      this.mSmoothProcessFilter.setLookUpLeft(this.mTextures[1]);
      BitmapUtils.recycle(paramString);
    }
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
    int[] arrayOfInt1;
    int j;
    if (paramBoolean)
    {
      this.mCurveStable = true;
      this.mCurveArrayAssignNeeded = false;
      System.arraycopy(paramArrayOfInt, 0, this.mCurveIntArray, 0, 256);
    }
    else
    {
      if (this.mCurveArrayAssignNeeded)
      {
        this.mCurveArrayAssignNeeded = false;
        System.arraycopy(paramArrayOfInt, 0, this.mCurveIntArray, 0, 256);
      }
      if (paramArrayOfInt[''] == this.mCurveIntArray['']) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if ((this.mCurveStable) && (!paramBoolean)) {
        this.mCurveCounter = 5;
      }
      this.mCurveStable = paramBoolean;
      if (!paramBoolean)
      {
        this.mCurveCounter = Math.max(1, this.mCurveCounter - 1);
        arrayOfInt1 = new int[256];
        i = 0;
        while (i < 256)
        {
          j = paramArrayOfInt[i];
          int[] arrayOfInt2 = this.mCurveIntArray;
          arrayOfInt1[i] = ((j - arrayOfInt2[i]) / this.mCurveCounter + arrayOfInt2[i]);
          arrayOfInt2[i] = arrayOfInt1[i];
          i += 1;
        }
      }
    }
    int i = 0;
    while (i < 256)
    {
      paramArrayOfInt = this.mCurveByteArray;
      j = i * 4;
      arrayOfInt1 = this.mCurveIntArray;
      paramArrayOfInt[j] = ((byte)arrayOfInt1[i]);
      paramArrayOfInt[(j + 1)] = ((byte)arrayOfInt1[i]);
      paramArrayOfInt[(j + 2)] = ((byte)arrayOfInt1[i]);
      paramArrayOfInt[(j + 3)] = -1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV6PrefixFilterGroup
 * JD-Core Version:    0.7.0.1
 */