package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.offlineset.enumclass.ScaleMode;
import com.tencent.ttpic.openapi.filter.GaussianMaskFilter;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;

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
  private ScaleMode mScaleMode = AEOfflineConfig.getGauScaleMode();
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
  }
  
  private void clearExtraFilter()
  {
    BaseFilter localBaseFilter = this.mReSizeFilter;
    if (localBaseFilter != null)
    {
      localBaseFilter.clearGLSL();
      this.mReSizeFilter = null;
    }
    localBaseFilter = this.mMixFilter;
    if (localBaseFilter != null)
    {
      localBaseFilter.clearGLSL();
      this.mMixFilter = null;
    }
  }
  
  private String getMixShader(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("precision mediump float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvoid main(){\n    vec4 base = texture2D(inputImageTexture, textureCoordinate);\n    vec4 overlay = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y));\n    vec4 mask = texture2D(inputImageTexture3, textureCoordinate);\n");
    String str;
    if (paramBoolean) {
      str = "    gl_FragColor = mix(base, overlay, mask.r);\n";
    } else {
      str = "    gl_FragColor = mix(overlay, base,  mask.r);\n";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  private void initFromPhoneYear() {}
  
  private void initScaleFactor()
  {
    if (ScaleMode.USE_MAX_SIZE == this.mScaleMode)
    {
      if (AEOfflineConfig.getGauMaxSize() > 10)
      {
        this.MAX_LENGTH = AEOfflineConfig.getGauMaxSize();
        return;
      }
      initFromPhoneYear();
      return;
    }
    if (ScaleMode.USE_SCALE_VALE == this.mScaleMode)
    {
      if (AEOfflineConfig.getGauScaleValue() > 0.0F)
      {
        this.mScale = AEOfflineConfig.getGauScaleValue();
        return;
      }
      initFromPhoneYear();
    }
  }
  
  private void resizeGaussianText(int paramInt1, int paramInt2)
  {
    if ((this.mOrignWidth == paramInt1) && (this.mOrignHeight == paramInt2)) {
      return;
    }
    this.mOrignWidth = paramInt1;
    this.mOrignHeight = paramInt2;
    if (ScaleMode.USE_MAX_SIZE == this.mScaleMode)
    {
      int i;
      if (paramInt1 > paramInt2) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (i != 0) {
        j = paramInt1;
      } else {
        j = paramInt2;
      }
      int k = this.MAX_LENGTH;
      if (j > k) {
        d1 = k;
      } else {
        d1 = j;
      }
      if (i != 0) {
        d2 = paramInt1;
      } else {
        d2 = paramInt2;
      }
      Double.isNaN(d2);
      this.mScale = (d1 / d2);
    }
    float f = this.mStrength;
    double d1 = f;
    double d3 = this.mScale;
    Double.isNaN(d1);
    double d2 = d1 * d3;
    d1 = d2;
    if (d2 < 2.0D)
    {
      d1 = d2;
      if (d3 < 1.0D)
      {
        if (f < 2.0F) {
          d1 = f;
        } else {
          d1 = 2.0D;
        }
        d2 = this.mStrength;
        Double.isNaN(d2);
        this.mScale = (d1 / d2);
      }
    }
    d3 = this.mOrignWidth;
    d2 = this.mScale;
    Double.isNaN(d3);
    this.mGaussianWidth = ((int)(d3 * d2));
    d3 = this.mOrignHeight;
    Double.isNaN(d3);
    this.mGaussianHeight = ((int)(d3 * d2));
    this.mStrength = ((float)d1);
  }
  
  public Frame RenderProcess(Frame paramFrame1, Frame paramFrame2)
  {
    Frame localFrame1 = paramFrame1;
    if (this.notNeedGaussBlur) {
      return localFrame1;
    }
    Object localObject = this.mReSizeFilter;
    if (localObject != null)
    {
      localObject = ((BaseFilter)localObject).RenderProcess(paramFrame1.getTextureId(), this.mOrignWidth, this.mOrignHeight, this.mGaussianWidth, this.mGaussianHeight);
      if (this.mGaussMaskFitler != null)
      {
        localFrame1 = FrameBufferCache.getInstance().get(this.mGaussianWidth, this.mGaussianHeight);
        Frame localFrame2 = this.mGaussMaskFitler.RenderProcess((Frame)localObject, localFrame1);
        BaseFilter localBaseFilter = this.mMixFilter;
        if (localBaseFilter != null)
        {
          localBaseFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", localFrame2.getTextureId(), 33986));
          this.mMixFilter.RenderProcess(paramFrame1.getTextureId(), this.mOrignWidth, this.mOrignHeight, -1, 0.0D, paramFrame2);
        }
        else
        {
          this.mReSizeFilter.RenderProcess(localFrame2.getTextureId(), this.mGaussianWidth, this.mGaussianHeight, this.mOrignWidth, this.mOrignHeight, -1, 0.0D, paramFrame2);
        }
        if (localFrame2 != paramFrame2) {
          localFrame2.unlock();
        }
        if (localObject != paramFrame2) {
          ((Frame)localObject).unlock();
        }
        if (localFrame1 != paramFrame2) {
          localFrame1.unlock();
        }
        return paramFrame2;
      }
      return localFrame1;
    }
    localObject = this.mGaussMaskFitler;
    paramFrame1 = localFrame1;
    if (localObject != null) {
      paramFrame1 = ((BlurMaskFilter.IBlurMaskFilter)localObject).RenderProcess(localFrame1, paramFrame2);
    }
    return paramFrame1;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.notNeedGaussBlur) {
      return;
    }
    resizeGaussianText((int)paramFloat1, (int)paramFloat2);
    if (this.mGaussMaskFitler == null)
    {
      Object localObject;
      if (this.mNeedMask) {
        localObject = GaussianMaskFilter.getGaussianFilter(this.mStrength, this.mIsBlackBg);
      } else {
        localObject = new GaussinNoMaskFilter(this.mStrength);
      }
      this.mGaussMaskFitler = ((BlurMaskFilter.IBlurMaskFilter)localObject);
    }
    this.mGaussMaskFitler.applyFilterChain(paramBoolean, this.mGaussianWidth, this.mGaussianHeight);
    if (this.mScale != 1.0D)
    {
      if (this.mReSizeFilter == null) {
        this.mReSizeFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      }
      this.mReSizeFilter.apply();
      if (this.mNeedMask)
      {
        if (this.mMixFilter == null) {
          this.mMixFilter = new BaseFilter(getMixShader(this.mIsBlackBg));
        }
        this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
        this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
        this.mMixFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      }
    }
    else
    {
      clearExtraFilter();
    }
  }
  
  public void applyForCustomFilter(boolean paramBoolean)
  {
    applyFilterChain(paramBoolean, this.customSizeW, this.customSizeH);
  }
  
  public void clear()
  {
    clearExtraFilter();
    BlurMaskFilter.IBlurMaskFilter localIBlurMaskFilter = this.mGaussMaskFitler;
    if (localIBlurMaskFilter != null)
    {
      localIBlurMaskFilter.clear();
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
    Object localObject = this.mGaussMaskFitler;
    if (localObject != null) {
      ((BlurMaskFilter.IBlurMaskFilter)localObject).setMaskTextureId(paramInt);
    }
    localObject = this.mMixFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    if (this.notNeedGaussBlur) {
      return;
    }
    resizeGaussianText(paramInt1, paramInt2);
    BlurMaskFilter.IBlurMaskFilter localIBlurMaskFilter = this.mGaussMaskFitler;
    if (localIBlurMaskFilter != null) {
      localIBlurMaskFilter.updateVideoSize(this.mGaussianWidth, this.mGaussianHeight);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.OptimGaussianMaskFilter
 * JD-Core Version:    0.7.0.1
 */