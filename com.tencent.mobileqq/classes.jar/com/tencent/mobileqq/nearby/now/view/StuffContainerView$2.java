package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StuffContainerView$2
  implements View.OnClickListener
{
  StuffContainerView$2(StuffContainerView paramStuffContainerView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.e != null) {
      this.a.e.a(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.StuffContainerView.2
 * JD-Core Version:    0.7.0.1
 */