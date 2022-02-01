package com.tencent.mobileqq.nearby.now.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StartLiveTopicLabelListView$1$1
  implements View.OnClickListener
{
  StartLiveTopicLabelListView$1$1(StartLiveTopicLabelListView.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (StartLiveTopicLabelListView.a(this.a.a) != null) {
        StartLiveTopicLabelListView.a(this.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView.1.1
 * JD-Core Version:    0.7.0.1
 */