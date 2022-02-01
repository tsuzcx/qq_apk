package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardFileOption$3
  implements View.OnClickListener
{
  ForwardFileOption$3(ForwardFileOption paramForwardFileOption) {}
  
  public void onClick(View paramView)
  {
    ForwardFileOption.b(this.a);
    ForwardFileOption.a(this.a, paramView);
    ReportController.b(null, "dc00898", "", "", "0X800AEEA", "0X800AEEA", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.3
 * JD-Core Version:    0.7.0.1
 */