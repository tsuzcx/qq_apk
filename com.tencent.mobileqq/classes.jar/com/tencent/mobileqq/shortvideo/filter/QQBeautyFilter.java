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
    if (!SdkContext.getInstance().getDpcSwitcher().isBeautySwitchOpen()) {
      return false;
    }
    if (this.isLevel0) {
      return false;
    }
    if (QmcfManager.getInstance().isQmcfNoNeedBeauty()) {
      return false;
    }
    return getQQFilterRenderManager().getBusinessOperation().getAVFilterFilterType() != 3;
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
    int i = getQQFilterRenderManager().getBusinessOperation().getAVFilterFilterType();
    return (i != 1) && (i != 2);
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    BeautyRender localBeautyRender = this.mBeautyRender;
    if (localBeautyRender == null)
    {
      initBeautyRender();
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    if ((localBeautyRender != null) && (beNeedShowBeauty()))
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
    int i = this.lastHeight;
    if ((i != paramInt1) || (i != paramInt2))
    {
      BeautyRender localBeautyRender = this.mBeautyRender;
      if (localBeautyRender != null)
      {
        localBeautyRender.destroy();
        this.mBeautyRender = null;
      }
    }
  }
  
  public void onSurfaceDestroy()
  {
    BeautyRender localBeautyRender = this.mBeautyRender;
    if (localBeautyRender != null)
    {
      localBeautyRender.destroy();
      this.mBeautyRender = null;
    }
  }
  
  public void updateBeautyFilter(float paramFloat)
  {
    boolean bool;
    if (paramFloat == 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    this.isLevel0 = bool;
    float f = paramFloat / 100.0F;
    Object localObject = this.mBeautyRender;
    if (localObject != null)
    {
      ((BeautyRender)localObject).setBeautyLevel(f * this.mediaCodecRate);
      if (SLog.isEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setBeautyLevel ");
        ((StringBuilder)localObject).append(paramFloat);
        ((StringBuilder)localObject).append(" rate: ");
        ((StringBuilder)localObject).append(this.mediaCodecRate);
        SLog.i("FilterBeauty", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void updateBeautyFilterParam(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool;
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F) && (paramFloat3 == 0.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    this.isLevel0 = bool;
    BeautyRender localBeautyRender = this.mBeautyRender;
    if (localBeautyRender != null)
    {
      float f = this.mediaCodecRate;
      localBeautyRender.setBeautyLevel(paramFloat1 * f, paramFloat2 * f, paramFloat3 * f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQBeautyFilter
 * JD-Core Version:    0.7.0.1
 */