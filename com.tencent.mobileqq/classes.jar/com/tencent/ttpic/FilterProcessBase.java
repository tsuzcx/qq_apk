package com.tencent.ttpic;

import com.tencent.algo.PtuFilterFactory;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.ttpic.model.CameraFilterParamSDK;
import com.tencent.util.PhoneProperty;

public class FilterProcessBase
{
  public static int SHOW_DELAY_COUNT = 0;
  private int effectIndex = 0;
  private int filterId = 0;
  private String flagId;
  int flipX = 0;
  int flipY = 0;
  int height = 0;
  double mAspectRatio = 0.0D;
  BaseFilter mFilter = PtuFilterFactory.createFilter(0);
  int mHaveFrameCount = 0;
  protected CameraFilterParamSDK mParam = new CameraFilterParamSDK();
  Frame mPreviewFrame = new Frame();
  protected int mSrcIndex = -1;
  int rotation = 0;
  int width = 0;
  
  static
  {
    SHOW_DELAY_COUNT = PhoneProperty.instance().getDelayFrameCount();
    if ((PhoneProperty.instance().isDelayDisplayGSLView()) || (!PhoneProperty.instance().isAdaptive())) {
      SHOW_DELAY_COUNT = 7;
    }
  }
  
  public boolean changeFilter(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mFilter != null) {
      this.mFilter.ClearGLSL();
    }
    this.flagId = paramString;
    this.filterId = paramInt1;
    this.effectIndex = paramInt2;
    this.mFilter = PtuFilterFactory.createFilter(this.filterId);
    this.mFilter.needFlipBlend = true;
    this.mFilter.setSrcFilterIndex(this.mSrcIndex);
    this.mFilter.setEffectIndex(paramInt2);
    this.mFilter.ApplyGLSLFilter(true, this.width, this.height);
    return true;
  }
  
  public void clear()
  {
    if (this.mPreviewFrame != null) {
      this.mPreviewFrame.clear();
    }
    if (this.mFilter != null)
    {
      this.mFilter.ClearGLSL();
      this.mFilter = null;
    }
    this.filterId = 0;
    this.effectIndex = 0;
  }
  
  public CameraFilterParamSDK getFilterParam()
  {
    return this.mParam;
  }
  
  public void initial() {}
  
  public boolean isNormalFilter()
  {
    return (this.mFilter != null) && (this.mFilter.isNormal());
  }
  
  public void previewStart()
  {
    this.mHaveFrameCount = 0;
  }
  
  public void setRotationAndFlip(int paramInt1, int paramInt2, int paramInt3)
  {
    this.rotation = paramInt1;
    this.flipX = paramInt2;
    this.flipY = paramInt3;
  }
  
  public void setScreenAspectRatio(double paramDouble)
  {
    this.mAspectRatio = paramDouble;
  }
  
  public void setupSmoothLevel(int paramInt) {}
  
  public void showPreview(int paramInt1, int paramInt2) {}
  
  public void update() {}
  
  public void updatePreviewSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  void updateRotation(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.FilterProcessBase
 * JD-Core Version:    0.7.0.1
 */