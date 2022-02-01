package com.tencent.mobileqq.nearby.now.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShortVideoCommentsView$16
  implements View.OnClickListener
{
  ShortVideoCommentsView$16(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    ((Activity)this.a.getContext()).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.16
 * JD-Core Version:    0.7.0.1
 */