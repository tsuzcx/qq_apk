package com.tencent.mobileqq.onlinestatus.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.utils.ViewUtils;

class OnlineStatusAIOPopUpWindow$3
  extends ViewOutlineProvider
{
  OnlineStatusAIOPopUpWindow$3(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), ViewUtils.dip2px(28.0F));
    paramOutline.setAlpha(0.3F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.3
 * JD-Core Version:    0.7.0.1
 */