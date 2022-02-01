package com.tencent.mobileqq.emotionintegrate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOEmotionFragment$1
  implements View.OnClickListener
{
  AIOEmotionFragment$1(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B71D", "0X800B71D", 0, 0, "", "", "", "");
    AIOEmotionFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.1
 * JD-Core Version:    0.7.0.1
 */