package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.device.YearClass;
import com.tencent.ttpic.offlineset.enumclass.ScaleMode;
import com.tencent.ttpic.openapi.filter.GaussianMaskFilter;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;

public class OptimGaussianMaskFilter
  implements BlurMaskFilter.IBlurMaskFilter
{
  private int MAX_LENGTH = 360;
  private final float MIN_SCALE_STRENGTH = 2.0F;
  private int customSizeH;
  private int customSizeW;
  private BlurMaskFilter.IBlurMaskFilter mGaussMaskFitler;
  private int mGaussianHeight;
  private int mGaussianWidth;
  private boolean mIsAlphaBlur;
  private boolean mIsBlackBg;
  private BaseFilter mMixFilter;
  private boolean mNeedMask;
  private int mOrignHeight;
  private int mOrignWidth;
  private BaseFilter mReSizeFilter;
  private double mScale = 1.0D;
  private ScaleMode mScaleMode = OfflineConfig.getGauScaleMode();
  private float mStrength;
  private boolean notNeedGaussBlur = false;
  
  public OptimGaussianMaskFilter(boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this(paramBoolean1, paramFloat, paramBoolean2, false);
  }
  
  public OptimGaussianMaskFilter(boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramFloat <= 1.0F)
    {
      this.notNeedGaussBlur = true;
      return;
    }
    this.mNeedMask = paramBoolean1;
    this.mStrength = paramFloat;
    this.mIsBlackBg = paramBoolean2;
    this.mIsAlphaBlur = paramBoolean3;
    initScaleFactor();
  }
  
  private void clearExtraFilter()
  {
    if (this.mReSizeFilter != null)
    {
      this.mReSizeFilter.clearGLSL();
      this.mReSizeFilter = null;
    }
    if (this.mMixFilter != null)
    {
      this.mMixFilter.clearGLSL();
      this.mMixFilter = null;
    }
  }
  
  private String getMixShader(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("precision mediump float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvoid main(){\n    vec4 base = texture2D(inputImageTexture, textureCoordinate);\n    vec4 overlay = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y));\n    vec4 mask = texture2D(inputImageTexture3, textureCoordinate);\n");
    if (paramBoolean) {}
    for (String str = "    gl_FragColor = mix(base, overlay, mask.r);\n";; str = "    gl_FragColor = mix(overlay, base,  mask.r);\n") {
      return str + "}\n";
    }
  }
  
  private void initFromPhoneYear()
  {
    int i = YearClass.get(null);
    if ((i < 2009) || (!OfflineConfig.isGaussSettingUpdate()))
    {
      this.mScaleMode = ScaleMode.USE_SCALE_VALE;
      this.mScale = 0.5D;
    }
    do
    {
      return;
      if (ScaleMode.USE_MAX_SIZE == this.mScaleMode)
      {
        this.MAX_LENGTH = ((int)OfflineConfig.getGauScaleFromPhoneYear(i));
        return;
      }
    } while (ScaleMode.USE_SCALE_VALE != this.mScaleMode);
    this.mScale = OfflineConfig.getGauScaleFromPhoneYear(i);
  }
  
  private void initScaleFactor()
  {
    if (ScaleMode.USE_MAX_SIZE == this.mScaleMode) {
      if (OfflineConfig.getGauMaxSize() > 10) {
        this.MAX_LENGTH = OfflineConfig.getGauMaxSize();
      }
    }
    while (ScaleMode.USE_SCALE_VALE != this.mScaleMode)
    {
      return;
      initFromPhoneYear();
      return;
    }
    if (OfflineConfig.getGauScaleValue() > 0.0F)
    {
      this.mScale = OfflineConfig.getGauScaleValue();
      return;
    }
    initFromPhoneYear();
  }
  
  private void resizeGaussianText(int paramInt1, int paramInt2)
  {
    if ((this.mOrignWidth == paramInt1) && (this.mOrignHeight == paramInt2)) {
      return;
    }
    this.mOrignWidth = paramInt1;
    this.mOrignHeight = paramInt2;
    int i;
    int j;
    if (ScaleMode.USE_MAX_SIZE == this.mScaleMode)
    {
      if (paramInt1 > paramInt2)
      {
        i = 1;
        if (i == 0) {
          break label188;
        }
        j = paramInt1;
        label53:
        if (j <= this.MAX_LENGTH) {
          break label194;
        }
        d1 = this.MAX_LENGTH;
        label68:
        if (i == 0) {
          break label201;
        }
        d1 /= paramInt1;
        label78:
        this.mScale = d1;
      }
    }
    else
    {
      double d2 = this.mStrength * this.mScale;
      d1 = d2;
      if (d2 < 2.0D)
      {
        d1 = d2;
        if (this.mScale < 1.0D) {
          if (this.mStrength >= 2.0F) {
            break label209;
          }
        }
      }
    }
    label188:
    label194:
    label201:
    label209:
    for (double d1 = this.mStrength;; d1 = 2.0D)
    {
      this.mScale = (d1 / this.mStrength);
      this.mGaussianWidth = ((int)(this.mOrignWidth * this.mScale));
      this.mGaussianHeight = ((int)(this.mOrignHeight * this.mScale));
      this.mStrength = ((float)d1);
      return;
      i = 0;
      break;
      j = paramInt2;
      break label53;
      d1 = j;
      break label68;
      d1 /= paramInt2;
      break label78;
    }
  }
  
  public Frame RenderProcess(Frame paramFrame1, Frame paramFrame2)
  {
    if (this.notNeedGaussBlur) {}
    do
    {
      Frame localFrame1;
      do
      {
        return paramFrame1;
        if (this.mReSizeFilter == null) {
          break;
        }
        localFrame1 = this.mReSizeFilter.RenderProcess(paramFrame1.getTextureId(), this.mOrignWidth, this.mOrignHeight, this.mGaussianWidth, this.mGaussianHeight);
      } while (this.mGaussMaskFitler == null);
      Frame localFrame2 = FrameBufferCache.getInstance().get(this.mGaussianWidth, this.mGaussianHeight);
      Frame localFrame3 = this.mGaussMaskFitler.RenderProcess(localFrame1, localFrame2);
      if (this.mMixFilter != null)
      {
        this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", localFrame3.getTextureId(), 33986));
        this.mMixFilter.RenderProcess(paramFrame1.getTextureId(), this.mOrignWidth, this.mOrignHeight, -1, 0.0D, paramFrame2);
      }
      for (;;)
      {
        if (localFrame3 != paramFrame2) {
          localFrame3.unlock();
        }
        if (localFrame1 != paramFrame2) {
          localFrame1.unlock();
        }
        if (localFrame2 != paramFrame2) {
          localFrame2.unlock();
        }
        return paramFrame2;
        this.mReSizeFilter.RenderProcess(localFrame3.getTextureId(), this.mGaussianWidth, this.mGaussianHeight, this.mOrignWidth, this.mOrignHeight, -1, 0.0D, paramFrame2);
      }
    } while (this.mGaussMaskFitler == null);
    return this.mGaussMaskFitler.RenderProcess(paramFrame1, paramFrame2);
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.notNeedGaussBlur) {
      return;
    }
    resizeGaussianText((int)paramFloat1, (int)paramFloat2);
    if (this.mGaussMaskFitler == null) {
      if (!this.mNeedMask) {
        break label192;
      }
    }
    label192:
    for (Object localObject = GaussianMaskFilter.getGaussianFilter(this.mStrength, this.mIsBlackBg);; localObject = new GaussinNoMaskFilter(this.mStrength))
    {
      this.mGaussMaskFitler = ((BlurMaskFilter.IBlurMaskFilter)localObject);
      this.mGaussMaskFitler.applyFilterChain(paramBoolean, this.mGaussianWidth, this.mGaussianHeight);
      if (this.mScale == 1.0D) {
        break label208;
      }
      if (this.mReSizeFilter == null) {
        this.mReSizeFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      }
      this.mReSizeFilter.apply();
      if (!this.mNeedMask) {
        break;
      }
      if (this.mMixFilter == null) {
        this.mMixFilter = new BaseFilter(getMixShader(this.mIsBlackBg));
      }
      this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
      this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
      this.mMixFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    label208:
    clearExtraFilter();
  }
  
  public void applyForCustomFilter(boolean paramBoolean)
  {
    applyFilterChain(paramBoolean, this.customSizeW, this.customSizeH);
  }
  
  public void clear()
  {
    clearExtraFilter();
    if (this.mGaussMaskFitler != null)
    {
      this.mGaussMaskFitler.clear();
      this.mGaussMaskFitler = null;
    }
  }
  
  public void setCustomSizeH(int paramInt)
  {
    this.customSizeH = paramInt;
  }
  
  public void setCustomSizeW(int paramInt)
  {
    this.customSizeW = paramInt;
  }
  
  public void setMaskTextureId(int paramInt)
  {
    if (this.mGaussMaskFitler != null) {
      this.mGaussMaskFitler.setMaskTextureId(paramInt);
    }
    if (this.mMixFilter != null) {
      this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    if (this.notNeedGaussBlur) {}
    do
    {
      return;
      resizeGaussianText(paramInt1, paramInt2);
    } while (this.mGaussMaskFitler == null);
    this.mGaussMaskFitler.updateVideoSize(this.mGaussianWidth, this.mGaussianHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.OptimGaussianMaskFilter
 * JD-Core Version:    0.7.0.1
 */