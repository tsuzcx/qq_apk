package com.tencent.mobileqq.microapp.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.microapp.apkg.k.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class f
  implements View.OnClickListener
{
  f(TabBarView paramTabBarView, int paramInt, k.a parama) {}
  
  public void onClick(View paramView)
  {
    if (TabBarView.a(this.c) != null) {
      TabBarView.a(this.c).onTabItemClick(this.a, this.b.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.f
 * JD-Core Version:    0.7.0.1
 */