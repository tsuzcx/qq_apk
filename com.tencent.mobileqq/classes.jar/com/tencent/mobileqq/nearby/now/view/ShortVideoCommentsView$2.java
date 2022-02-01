package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShortVideoCommentsView$2
  implements View.OnClickListener
{
  ShortVideoCommentsView$2(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    ShortVideoCommentsView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.2
 * JD-Core Version:    0.7.0.1
 */