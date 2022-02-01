package com.tencent.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NegativeChildrenLayout$1
  implements View.OnClickListener
{
  NegativeChildrenLayout$1(NegativeChildrenLayout paramNegativeChildrenLayout) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d != null) {
      this.a.d.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.NegativeChildrenLayout.1
 * JD-Core Version:    0.7.0.1
 */