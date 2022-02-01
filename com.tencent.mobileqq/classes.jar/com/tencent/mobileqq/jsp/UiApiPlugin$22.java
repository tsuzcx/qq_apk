package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UiApiPlugin$22
  implements View.OnClickListener
{
  UiApiPlugin$22(UiApiPlugin paramUiApiPlugin, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.d.a(this.a, this.b, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.22
 * JD-Core Version:    0.7.0.1
 */