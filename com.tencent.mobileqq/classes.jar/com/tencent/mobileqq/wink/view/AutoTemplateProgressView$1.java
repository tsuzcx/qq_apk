package com.tencent.mobileqq.wink.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoTemplateProgressView$1
  implements View.OnClickListener
{
  AutoTemplateProgressView$1(AutoTemplateProgressView paramAutoTemplateProgressView) {}
  
  public void onClick(View paramView)
  {
    AutoTemplateProgressView.a(this.a).stopLoading();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.AutoTemplateProgressView.1
 * JD-Core Version:    0.7.0.1
 */