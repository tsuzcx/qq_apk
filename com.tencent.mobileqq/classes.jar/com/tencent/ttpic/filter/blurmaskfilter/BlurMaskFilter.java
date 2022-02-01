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
  private static final String TAG;
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
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BlurMaskFilter:");
    localStringBuilder.append(BlurMaskFilter.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  public BlurMaskFilter(BlurMaskParam paramBlurMaskParam)
  {
    if ((paramBlurMaskParam != null) && (paramBlurMaskParam.maskType != 0))
    {
      this.mBlurType = paramBlurMaskParam.blurType;
      this.mBlurStrength = paramBlurMaskParam.blurStrength;
      initMask(paramBlurMaskParam.maskType, null);
      initFilter(paramBlurMaskParam.blurType, paramBlurMaskParam.blurStrength);
      return;
    }
    this.mBlurType = 0;
    this.mBlurStrength = 0.0D;
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
    boolean bool = true;
    if (paramInt != 1) {
      return;
    }
    Object localObject;
    if (paramDouble < 1.0D)
    {
      localObject = null;
    }
    else if (AEOfflineConfig.isGausResize())
    {
      if (this.mBlurMaskFactory == null) {
        bool = false;
      }
      localObject = new OptimGaussianMaskFilter(bool, (float)paramDouble, this.mBlurMaskFactory instanceof ImageMaskFactory);
    }
    else
    {
      localObject = this.mBlurMaskFactory;
      if (localObject != null) {
        localObject = GaussianMaskFilter.getGaussianFilter((float)paramDouble, localObject instanceof ImageMaskFactory);
      } else {
        localObject = new GaussinNoMaskFilter((float)paramDouble);
      }
      localObject = (BlurMaskFilter.IBlurMaskFilter)localObject;
    }
    this.mBlurMaskFilter = ((BlurMaskFilter.IBlurMaskFilter)localObject);
  }
  
  private void initMask(int paramInt, BlurEffectItem paramBlurEffectItem)
  {
    Object localObject = null;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (paramBlurEffectItem == null) {
          paramBlurEffectItem = localObject;
        } else {
          paramBlurEffectItem = paramBlurEffectItem.getFaceMaskItem();
        }
        if (paramBlurEffectItem == null) {
          paramBlurEffectItem = new FaceMaskFilter();
        } else {
          paramBlurEffectItem = new FaceMaskFilter(paramBlurEffectItem);
        }
        this.mBlurMaskFactory = paramBlurEffectItem;
        return;
      }
      this.mBlurMaskFactory = new BodySegMaskFactory();
      return;
    }
    if (paramBlurEffectItem.getImageMaskItem() != null)
    {
      this.mBlurMaskFactory = new ImageMaskFactory(paramBlurEffectItem.getImageMaskItem());
      return;
    }
    this.mBlurMaskFactory = null;
  }
  
  public void ApplyGLSLFilter()
  {
    Object localObject = this.mBlurMaskFilter;
    if (localObject != null) {
      ((BlurMaskFilter.IBlurMaskFilter)localObject).applyFilterChain(false, this.width, this.height);
    }
    localObject = this.mBlurMaskFactory;
    if (localObject != null) {
      ((BlurMaskFilter.IBlurMaskFactory)localObject).apply();
    }
    this.mBlurFrame = new Frame();
  }
  
  public void clear()
  {
    Object localObject = this.mBlurMaskFilter;
    if (localObject != null) {
      ((BlurMaskFilter.IBlurMaskFilter)localObject).clear();
    }
    localObject = this.mBlurMaskFactory;
    if (localObject != null) {
      ((BlurMaskFilter.IBlurMaskFactory)localObject).clear();
    }
    localObject = this.mBlurFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
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
    BlurMaskFilter.IBlurMaskFactory localIBlurMaskFactory = this.mBlurMaskFactory;
    if (localIBlurMaskFactory != null) {
      localIBlurMaskFactory.pause();
    }
  }
  
  public Frame renderBlur(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    BlurMaskFilter.IBlurMaskFilter localIBlurMaskFilter = this.mBlurMaskFilter;
    Object localObject = paramFrame;
    if (localIBlurMaskFilter != null)
    {
      localObject = this.mBlurMaskFactory;
      if (localObject != null)
      {
        paramPTFaceAttr = ((BlurMaskFilter.IBlurMaskFactory)localObject).renderMask(paramPTFaceAttr, paramPTSegAttr);
        if (paramPTFaceAttr != null)
        {
          this.mBlurMaskFilter.setMaskTextureId(paramPTFaceAttr.getTextureId());
          this.mBlurMaskFilter.updateVideoSize(this.width, this.height);
          return this.mBlurMaskFilter.RenderProcess(paramFrame, this.mBlurFrame);
        }
        LogUtils.e(TAG, "mBlurMaskFactory.renderMask outFrame is null!");
        return paramFrame;
      }
      localIBlurMaskFilter.updateVideoSize(this.width, this.height);
      localObject = this.mBlurMaskFilter.RenderProcess(paramFrame, this.mBlurFrame);
    }
    return localObject;
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
    BlurMaskFilter.IBlurMaskFactory localIBlurMaskFactory = this.mBlurMaskFactory;
    if ((localIBlurMaskFactory instanceof ImageMaskFactory)) {
      ((ImageMaskFactory)localIBlurMaskFactory).reset();
    }
  }
  
  public void resumeMask()
  {
    BlurMaskFilter.IBlurMaskFactory localIBlurMaskFactory = this.mBlurMaskFactory;
    if (localIBlurMaskFactory != null) {
      localIBlurMaskFactory.resume();
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if ((this.originWidth == 0) || (this.originHeight == 0))
    {
      this.originWidth = paramInt1;
      this.originHeight = paramInt2;
    }
    int i = this.width;
    if ((i != paramInt1) && (i != 0) && (this.originWidth != 0))
    {
      localObject = this.mBlurMaskFilter;
      if (localObject != null)
      {
        ((BlurMaskFilter.IBlurMaskFilter)localObject).clear();
        float f1 = paramInt1;
        float f2 = f1 / this.originWidth;
        i = this.mBlurType;
        double d1 = this.mBlurStrength;
        double d2 = f2;
        Double.isNaN(d2);
        initFilter(i, d1 * d2);
        localObject = this.mBlurMaskFilter;
        if (localObject != null) {
          ((BlurMaskFilter.IBlurMaskFilter)localObject).applyFilterChain(false, f1, paramInt2);
        }
      }
    }
    this.width = paramInt1;
    this.height = paramInt2;
    Object localObject = this.mBlurMaskFilter;
    if (localObject != null) {
      ((BlurMaskFilter.IBlurMaskFilter)localObject).updateVideoSize(paramInt1, paramInt2);
    }
    localObject = this.mBlurMaskFactory;
    if (localObject != null) {
      ((BlurMaskFilter.IBlurMaskFactory)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.BlurMaskFilter
 * JD-Core Version:    0.7.0.1
 */