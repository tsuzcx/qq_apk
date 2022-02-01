package com.tencent.mobileqq.qassistant.wake;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WakeDialog$1
  implements View.OnClickListener
{
  WakeDialog$1(WakeDialog paramWakeDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeDialog.1
 * JD-Core Version:    0.7.0.1
 */