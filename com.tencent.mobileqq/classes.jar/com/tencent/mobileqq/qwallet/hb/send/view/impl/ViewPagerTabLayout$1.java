package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViewPagerTabLayout$1
  implements View.OnClickListener
{
  ViewPagerTabLayout$1(ViewPagerTabLayout paramViewPagerTabLayout) {}
  
  public void onClick(View paramView)
  {
    int i = ViewPagerTabLayout.a(this.a).indexOfChild(paramView);
    if (i != -1) {
      if (ViewPagerTabLayout.a(this.a).getCurrentItem() != i)
      {
        if (!ViewPagerTabLayout.a(this.a)) {
          this.a.setCurrentTab(i, false);
        } else {
          this.a.setCurrentTab(i);
        }
        if (ViewPagerTabLayout.a(this.a) != null) {
          ViewPagerTabLayout.a(this.a).a(i);
        }
      }
      else if (ViewPagerTabLayout.a(this.a) != null)
      {
        ViewPagerTabLayout.a(this.a).b(i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.ViewPagerTabLayout.1
 * JD-Core Version:    0.7.0.1
 */