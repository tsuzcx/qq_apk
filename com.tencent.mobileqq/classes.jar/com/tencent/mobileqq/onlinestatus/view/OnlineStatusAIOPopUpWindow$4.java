package com.tencent.mobileqq.onlinestatus.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.utils.ViewUtils;

class OnlineStatusAIOPopUpWindow$4
  extends ViewOutlineProvider
{
  OnlineStatusAIOPopUpWindow$4(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), ViewUtils.a(28.0F));
    paramOutline.setAlpha(0.3F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.4
 * JD-Core Version:    0.7.0.1
 */