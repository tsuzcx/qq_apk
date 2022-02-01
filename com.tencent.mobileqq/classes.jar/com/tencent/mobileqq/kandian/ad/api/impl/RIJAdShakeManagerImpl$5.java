package com.tencent.mobileqq.kandian.ad.api.impl;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class RIJAdShakeManagerImpl$5
  extends ViewOutlineProvider
{
  RIJAdShakeManagerImpl$5(RIJAdShakeManagerImpl paramRIJAdShakeManagerImpl) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), 16.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdShakeManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */