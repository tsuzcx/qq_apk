package com.tencent.mobileqq.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SlideBottomDialog$1
  implements View.OnClickListener
{
  SlideBottomDialog$1(SlideBottomDialog paramSlideBottomDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.dialog.SlideBottomDialog.1
 * JD-Core Version:    0.7.0.1
 */