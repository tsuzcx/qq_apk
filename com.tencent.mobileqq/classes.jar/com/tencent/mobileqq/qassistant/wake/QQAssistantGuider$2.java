package com.tencent.mobileqq.qassistant.wake;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQAssistantGuider$2
  implements View.OnClickListener
{
  QQAssistantGuider$2(QQAssistantGuider paramQQAssistantGuider) {}
  
  public void onClick(View paramView)
  {
    QQAssistantGuider localQQAssistantGuider = this.a;
    localQQAssistantGuider.g = 3;
    localQQAssistantGuider.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuider.2
 * JD-Core Version:    0.7.0.1
 */