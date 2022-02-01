package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.resource.BeautyResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.DpcSwitcher;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;

public class QQBeautyFilter
  extends QQBaseFilter
{
  public static int sBeautyLevel = -1;
  private boolean bwork = false;
  private boolean isLevel0;
  private int lastHeight = 0;
  private int lastWidth = 0;
  private BeautyRender mBeautyRender;
  private float mediaCodecRate = 1.0F;
  
  public QQBeautyFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private boolean beNeedShowBeauty()
  {
    if (!SdkContext.getInstance().getDpcSwitcher().isBeautySwitchOpen()) {}
    while ((this.isLevel0) || (QmcfManager.getInstance().isQmcfNoNeedBeauty()) || (getQQFilterRenderManager().getBusinessOperation().getAVFilterFilterType() == 3)) {
      return false;
    }
    return true;
  }
  
  private void initBeautyRender()
  {
    if (this.mBeautyRender == null)
    {
      this.mBeautyRender = new BeautyRender(SdkContext.getInstance().getApplication(), SdkContext.getInstance().getResources().getBeautyResource().getBeautyFilePath());
      int i = sBeautyLevel;
      if (i >= 0) {
        updateBeautyFilter(i);
      }
    }
    this.mediaCodecRate = SdkContext.getInstance().getDpcSwitcher().getBeatyRate();
  }
  
  private boolean needSkinColor()
  {
    boolean bool = true;
    int i = getQQFilterRenderManager().getBusinessOperation().getAVFilterFilterType();
    if ((i == 1) || (i == 2)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    if (this.mBeautyRender == null)
    {
      initBeautyRender();
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    if ((this.mBeautyRender != null) && (beNeedShowBeauty()))
    {
      boolean bool = needSkinColor();
      this.mBeautyRender.setNeedSkinColor(bool);
      this.lastWidth = getQQFilterRenderManager().getFilterWidth();
      this.lastHeight = getQQFilterRenderManager().getFilterHeight();
      this.mOutputTextureID = this.mBeautyRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
      QQFilterLogManager.setFilterStatus("QQBeautyFilter", true);
      this.bwork = true;
      return;
    }
    this.mOutputTextureID = this.mInputTextureID;
    QQFilterLogManager.setFilterStatus("QQBeautyFilter", false);
    this.bwork = false;
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if (((this.lastHeight != paramInt1) || (this.lastHeight != paramInt2)) && (this.mBeautyRender != null))
    {
      this.mBeautyRender.destroy();
      this.mBeautyRender = null;
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (this.mBeautyRender != null)
    {
      this.mBeautyRender.destroy();
      this.mBeautyRender = null;
    }
  }
  
  public void updateBeautyFilter(float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.isLevel0 = bool;
      float f = paramFloat / 100.0F;
      if (this.mBeautyRender != null)
      {
        this.mBeautyRender.setBeautyLevel(f * this.mediaCodecRate);
        if (SLog.isEnable()) {
          SLog.i("FilterBeauty", "setBeautyLevel " + paramFloat + " rate: " + this.mediaCodecRate);
        }
      }
      return;
    }
  }
  
  public void updateBeautyFilterParam(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F) && (paramFloat3 == 0.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isLevel0 = bool;
      if (this.mBeautyRender != null) {
        this.mBeautyRender.setBeautyLevel(this.mediaCodecRate * paramFloat1, this.mediaCodecRate * paramFloat2, this.mediaCodecRate * paramFloat3);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQBeautyFilter
 * JD-Core Version:    0.7.0.1
 */