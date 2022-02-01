package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.BlurEffectItem;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.GaussianMaskFilter;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;

public class BlurMaskFilter
{
  private static final String TAG = "BlurMaskFilter:" + BlurMaskFilter.class.getSimpleName();
  private int height = 0;
  private Frame mBlurFrame;
  private BlurMaskFilter.IBlurMaskFactory mBlurMaskFactory;
  private BlurMaskFilter.IBlurMaskFilter mBlurMaskFilter;
  private final double mBlurStrength;
  private final int mBlurType;
  private int mRenderOrder = BlurMaskFilter.RENDER_ORDER.access$000(BlurMaskFilter.RENDER_ORDER.NONE);
  private int originHeight = 0;
  private int originWidth = 0;
  private int width = 0;
  
  public BlurMaskFilter(BlurMaskParam paramBlurMaskParam)
  {
    if ((paramBlurMaskParam == null) || (paramBlurMaskParam.maskType == 0))
    {
      this.mBlurType = 0;
      this.mBlurStrength = 0.0D;
      return;
    }
    this.mBlurType = paramBlurMaskParam.blurType;
    this.mBlurStrength = paramBlurMaskParam.blurStrength;
    initMask(paramBlurMaskParam.maskType, null);
    initFilter(paramBlurMaskParam.blurType, paramBlurMaskParam.blurStrength);
  }
  
  public BlurMaskFilter(BlurEffectItem paramBlurEffectItem)
  {
    if (paramBlurEffectItem == null)
    {
      this.mBlurType = 0;
      this.mBlurStrength = 0.0D;
      return;
    }
    this.mRenderOrder = paramBlurEffectItem.getRenderOrder();
    initMask(paramBlurEffectItem.getMaskType(), paramBlurEffectItem);
    this.mBlurType = paramBlurEffectItem.getBlurType();
    this.mBlurStrength = paramBlurEffectItem.getBlurStrength();
    initFilter(this.mBlurType, this.mBlurStrength);
  }
  
  private void initFilter(int paramInt, double paramDouble)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramDouble < 1.0D)
    {
      localObject = null;
      this.mBlurMaskFilter = ((BlurMaskFilter.IBlurMaskFilter)localObject);
      return;
    }
    if (AEOfflineConfig.isGausResize())
    {
      if (this.mBlurMaskFactory != null) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = new OptimGaussianMaskFilter(bool, (float)paramDouble, this.mBlurMaskFactory instanceof ImageMaskFactory);
        break;
      }
    }
    if (this.mBlurMaskFactory != null) {}
    for (Object localObject = GaussianMaskFilter.getGaussianFilter((float)paramDouble, this.mBlurMaskFactory instanceof ImageMaskFactory);; localObject = new GaussinNoMaskFilter((float)paramDouble))
    {
      localObject = (BlurMaskFilter.IBlurMaskFilter)localObject;
      break;
    }
  }
  
  private void initMask(int paramInt, BlurEffectItem paramBlurEffectItem)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (paramBlurEffectItem.getImageMaskItem() != null)
      {
        this.mBlurMaskFactory = new ImageMaskFactory(paramBlurEffectItem.getImageMaskItem());
        return;
      }
      this.mBlurMaskFactory = null;
      return;
    case 1: 
      this.mBlurMaskFactory = new BodySegMaskFactory();
      return;
    }
    if (paramBlurEffectItem == null)
    {
      paramBlurEffectItem = null;
      if (paramBlurEffectItem != null) {
        break label102;
      }
    }
    label102:
    for (paramBlurEffectItem = new FaceMaskFilter();; paramBlurEffectItem = new FaceMaskFilter(paramBlurEffectItem))
    {
      this.mBlurMaskFactory = paramBlurEffectItem;
      return;
      paramBlurEffectItem = paramBlurEffectItem.getFaceMaskItem();
      break;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    if (this.mBlurMaskFilter != null) {
      this.mBlurMaskFilter.applyFilterChain(false, this.width, this.height);
    }
    if (this.mBlurMaskFactory != null) {
      this.mBlurMaskFactory.apply();
    }
    this.mBlurFrame = new Frame();
  }
  
  public void clear()
  {
    if (this.mBlurMaskFilter != null) {
      this.mBlurMaskFilter.clear();
    }
    if (this.mBlurMaskFactory != null) {
      this.mBlurMaskFactory.clear();
    }
    if (this.mBlurFrame != null) {
      this.mBlurFrame.clear();
    }
  }
  
  public BlurMaskFilter.IBlurMaskFactory getBlurMaskFactory()
  {
    return this.mBlurMaskFactory;
  }
  
  public boolean isRequiedSegment()
  {
    return this.mBlurMaskFactory instanceof BodySegMaskFactory;
  }
  
  public void pauseMask()
  {
    if (this.mBlurMaskFactory != null) {
      this.mBlurMaskFactory.pause();
    }
  }
  
  public Frame renderBlur(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mBlurMaskFilter != null)
    {
      if (this.mBlurMaskFactory == null) {
        break label92;
      }
      paramPTFaceAttr = this.mBlurMaskFactory.renderMask(paramPTFaceAttr, paramPTSegAttr);
      if (paramPTFaceAttr != null)
      {
        this.mBlurMaskFilter.setMaskTextureId(paramPTFaceAttr.getTextureId());
        this.mBlurMaskFilter.updateVideoSize(this.width, this.height);
        localFrame = this.mBlurMaskFilter.RenderProcess(paramFrame, this.mBlurFrame);
      }
    }
    else
    {
      return localFrame;
    }
    LogUtils.e(TAG, "mBlurMaskFactory.renderMask outFrame is null!");
    return paramFrame;
    label92:
    this.mBlurMaskFilter.updateVideoSize(this.width, this.height);
    return this.mBlurMaskFilter.RenderProcess(paramFrame, this.mBlurFrame);
  }
  
  public Frame renderBlurAfter(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mRenderOrder == BlurMaskFilter.RENDER_ORDER.access$000(BlurMaskFilter.RENDER_ORDER.AFTER)) {
      localFrame = renderBlur(paramFrame, paramPTFaceAttr, paramPTSegAttr);
    }
    return localFrame;
  }
  
  public Frame renderBlurBefore(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mRenderOrder == BlurMaskFilter.RENDER_ORDER.access$000(BlurMaskFilter.RENDER_ORDER.BEFORE)) {
      localFrame = renderBlur(paramFrame, paramPTFaceAttr, paramPTSegAttr);
    }
    return localFrame;
  }
  
  public void reset()
  {
    if ((this.mBlurMaskFactory instanceof ImageMaskFactory)) {
      ((ImageMaskFactory)this.mBlurMaskFactory).reset();
    }
  }
  
  public void resumeMask()
  {
    if (this.mBlurMaskFactory != null) {
      this.mBlurMaskFactory.resume();
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if ((this.originWidth == 0) || (this.originHeight == 0))
    {
      this.originWidth = paramInt1;
      this.originHeight = paramInt2;
    }
    if ((this.width != paramInt1) && (this.width != 0) && (this.originWidth != 0) && (this.mBlurMaskFilter != null))
    {
      this.mBlurMaskFilter.clear();
      float f = paramInt1 / this.originWidth;
      initFilter(this.mBlurType, this.mBlurStrength * f);
      if (this.mBlurMaskFilter != null) {
        this.mBlurMaskFilter.applyFilterChain(false, paramInt1, paramInt2);
      }
    }
    this.width = paramInt1;
    this.height = paramInt2;
    if (this.mBlurMaskFilter != null) {
      this.mBlurMaskFilter.updateVideoSize(paramInt1, paramInt2);
    }
    if (this.mBlurMaskFactory != null) {
      this.mBlurMaskFactory.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.BlurMaskFilter
 * JD-Core Version:    0.7.0.1
 */