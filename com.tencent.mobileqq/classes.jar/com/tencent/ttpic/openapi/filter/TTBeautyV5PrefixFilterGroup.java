package com.tencent.ttpic.openapi.filter;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.util.AlgoUtils;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class TTBeautyV5PrefixFilterGroup
{
  private int age = 0;
  private boolean isFemale = true;
  private boolean isOverall = false;
  private String lastLutPath;
  private BeautyAIParam mBeautyAIParam = new BeautyAIParam();
  private TTBeautyV5BlurFilter mBlurFilter = new TTBeautyV5BlurFilter();
  private float mBlurStrength = 0.4F;
  private TTBeautyV5BorderFilter mBorderFilter = new TTBeautyV5BorderFilter();
  private boolean mCurveArrayAssignNeeded = true;
  private byte[] mCurveByteArray = new byte[1024];
  private ByteBuffer mCurveByteBuffer;
  private int mCurveCounter = 5;
  private int[] mCurveIntArray = new int[256];
  private boolean mCurveStable = false;
  private float mFaceSizeFactor = 0.0F;
  private boolean mForce = false;
  private float mSharpenStrength = 1.2F;
  private TTBeautyV5SmoothFilter mSmoothFilter = new TTBeautyV5SmoothFilter();
  private int[] mTextures = new int[3];
  
  private void updateBlurAndSharpenStrength(boolean paramBoolean, PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2)
  {
    float f3 = 0.0F;
    float f1 = 0.0F;
    float f2 = f3;
    if (paramPTFaceAttr != null)
    {
      f2 = f3;
      if (paramPTFaceAttr.getAllFacePoints() != null)
      {
        f2 = f3;
        if (!paramPTFaceAttr.getAllFacePoints().isEmpty())
        {
          f2 = f3;
          if (paramInt1 > 0)
          {
            f2 = f3;
            if (paramInt2 > 0)
            {
              Iterator localIterator = paramPTFaceAttr.getAllFacePoints().iterator();
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
                  f3 = (float)(d1 * d2);
                  f1 = Math.max(f1, localRectF.width() * localRectF.height() / f2 / f3);
                }
              }
            }
          }
        }
      }
    }
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
    f1 = this.mBlurStrength;
    f2 = this.mFaceSizeFactor;
    this.mSmoothFilter.setBlurStrength(f1 * f2);
    f1 = this.mSharpenStrength * this.mFaceSizeFactor * Math.min(0.2F, this.mBlurStrength) / 0.2F;
    this.mSmoothFilter.setSharpenStrength(f1);
  }
  
  public void apply()
  {
    this.mBlurFilter.applyFilterChain(true, 0.0F, 0.0F);
    this.mBorderFilter.apply();
    this.mSmoothFilter.apply();
    int[] arrayOfInt = this.mTextures;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.lastLutPath = null;
  }
  
  public void clear()
  {
    this.mBlurFilter.clearGLSL();
    this.mBorderFilter.clearGLSL();
    this.mSmoothFilter.clearGLSL();
    int[] arrayOfInt = this.mTextures;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.lastLutPath = null;
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    if (paramFrame.width != 0)
    {
      if (paramFrame.height == 0) {
        return paramFrame;
      }
      this.mBeautyAIParam.setBeautyParam(this.isFemale, this.age, true);
      this.mBlurStrength = (this.mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.BEAUTY, this.mBlurStrength / 0.6F) * 0.6F);
      updateBlurAndSharpenStrength(this.mForce, paramPTFaceAttr, paramFrame.width, paramFrame.height);
      float f = Math.min(1.0F, 360.0F / Math.min(paramFrame.width, paramFrame.height));
      int i = Math.round(paramFrame.width * f);
      int j = Math.round(paramFrame.height * f);
      this.mBlurFilter.updateSize(i, j);
      paramPTFaceAttr = this.mBlurFilter.RenderProcess(paramFrame.getTextureId(), i, j);
      this.mBorderFilter.setBlurTexture(paramPTFaceAttr.getTextureId());
      Frame localFrame1 = this.mBorderFilter.RenderProcess(paramFrame.getTextureId(), i, j);
      Frame localFrame2 = this.mBlurFilter.RenderProcess(localFrame1.getTextureId(), i, j);
      this.mSmoothFilter.setBlurTexture(paramPTFaceAttr.getTextureId());
      this.mSmoothFilter.setShowBorderTexture(localFrame2.getTextureId());
      Frame localFrame3 = this.mSmoothFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      paramPTFaceAttr.unlock();
      localFrame1.unlock();
      localFrame2.unlock();
      paramFrame.unlock();
      return localFrame3;
    }
    return paramFrame;
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
    this.mSmoothFilter.setLookUpCurve(this.mTextures[0]);
  }
  
  public void setExposureValue(int paramInt)
  {
    this.mSmoothFilter.setExposureValue(paramInt);
  }
  
  public void setLookUpLeftIntensity(float paramFloat)
  {
    this.mSmoothFilter.setLutLeftIntensity(paramFloat);
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
      this.mSmoothFilter.setLookUpLeft(this.mTextures[1]);
      BitmapUtils.recycle(paramString);
    }
  }
  
  public void setLookUpLeftTexture(int paramInt)
  {
    this.mSmoothFilter.setLookUpLeft(paramInt);
  }
  
  public void setLookUpPosition(float paramFloat)
  {
    this.mSmoothFilter.setLutPosition(paramFloat);
  }
  
  public void setLookUpRightIntensity(float paramFloat)
  {
    this.mSmoothFilter.setLutRightIntensity(paramFloat);
  }
  
  public void setLookUpRightPath(String paramString)
  {
    paramString = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
    if (BitmapUtils.isLegal(paramString))
    {
      GlUtil.loadTexture(this.mTextures[2], paramString);
      this.mSmoothFilter.setLookUpRight(this.mTextures[2]);
      BitmapUtils.recycle(paramString);
    }
  }
  
  public void setLookUpRightTexture(int paramInt)
  {
    this.mSmoothFilter.setLookUpRight(paramInt);
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
    this.mSmoothFilter.setSharpenSize(paramFloat1, paramFloat2);
  }
  
  public void setSmoothSharpenStrength(float paramFloat)
  {
    this.mSharpenStrength = paramFloat;
  }
  
  public void setWhitenStrength(float paramFloat)
  {
    this.mSmoothFilter.setWhitenStrength(paramFloat);
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
    this.mSmoothFilter.setLookUpCurve(this.mTextures[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5PrefixFilterGroup
 * JD-Core Version:    0.7.0.1
 */