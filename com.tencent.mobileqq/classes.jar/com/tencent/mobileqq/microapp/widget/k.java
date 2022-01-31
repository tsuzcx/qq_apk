package com.tencent.mobileqq.microapp.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.microapp.apkg.s.a;

final class k
  implements View.OnClickListener
{
  k(TabBarView paramTabBarView, int paramInt, s.a parama) {}
  
  public void onClick(View paramView)
  {
    if (TabBarView.a(this.c) != null) {
      TabBarView.a(this.c).onTabItemClick(this.a, this.b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.k
 * JD-Core Version:    0.7.0.1
 */