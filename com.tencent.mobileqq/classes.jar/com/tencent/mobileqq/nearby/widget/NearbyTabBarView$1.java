package com.tencent.mobileqq.nearby.widget;

import android.view.View;
import android.view.View.OnClickListener;

class NearbyTabBarView$1
  implements View.OnClickListener
{
  NearbyTabBarView$1(NearbyTabBarView paramNearbyTabBarView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - NearbyTabBarView.a(this.b) < 500L) {
      return;
    }
    NearbyTabBarView.a(this.b, l);
    this.b.setSelectedTab(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyTabBarView.1
 * JD-Core Version:    0.7.0.1
 */