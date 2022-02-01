package com.tencent.mobileqq.structmsg.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class StructMsgItemLayoutPromotion$2
  extends ViewOutlineProvider
{
  StructMsgItemLayoutPromotion$2(StructMsgItemLayoutPromotion paramStructMsgItemLayoutPromotion, int paramInt) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion.2
 * JD-Core Version:    0.7.0.1
 */