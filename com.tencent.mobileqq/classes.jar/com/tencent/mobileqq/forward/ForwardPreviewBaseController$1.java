package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardPreviewBaseController$1
  implements View.OnClickListener
{
  ForwardPreviewBaseController$1(ForwardPreviewBaseController paramForwardPreviewBaseController) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewBaseController.1
 * JD-Core Version:    0.7.0.1
 */