package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShortVideoCommentsView$6
  implements View.OnClickListener
{
  ShortVideoCommentsView$6(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.a.j();
    ShortVideoCommentsView.a(this.a).setVisibility(8);
    ShortVideoCommentsView.a(this.a, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.6
 * JD-Core Version:    0.7.0.1
 */