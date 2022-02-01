package com.tencent.mobileqq.structmsg.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.utils.ViewUtils;

class StructMsgItemLayoutBirthdayReminder$3
  extends ViewOutlineProvider
{
  StructMsgItemLayoutBirthdayReminder$3(StructMsgItemLayoutBirthdayReminder paramStructMsgItemLayoutBirthdayReminder, int paramInt) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), ViewUtils.dip2px(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutBirthdayReminder.3
 * JD-Core Version:    0.7.0.1
 */