package com.tencent.mobileqq.olympic.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ARTipsManager$5
  implements View.OnClickListener
{
  ARTipsManager$5(ARTipsManager paramARTipsManager, ARTipsManager.TipsInfo paramTipsInfo) {}
  
  public void onClick(View paramView)
  {
    ARTipsManager.c(this.b).removeMessages(101);
    ARTipsManager.c(this.b).obtainMessage(101).sendToTarget();
    this.a.l.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.5
 * JD-Core Version:    0.7.0.1
 */