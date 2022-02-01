package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StructMsgItemLayoutBirthdayReminder$2
  implements View.OnClickListener
{
  StructMsgItemLayoutBirthdayReminder$2(StructMsgItemLayoutBirthdayReminder paramStructMsgItemLayoutBirthdayReminder, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", StructMsgItemLayoutBirthdayReminder.a(this.b));
    RouteUtils.a(this.a, localIntent, "/base/browser");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutBirthdayReminder.2
 * JD-Core Version:    0.7.0.1
 */