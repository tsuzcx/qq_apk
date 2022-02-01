package com.tencent.mobileqq.flashshow.personal.widget;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.flashshow.fragment.FSPersonalFeedFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSPersonalBottomWidget$4
  implements View.OnClickListener
{
  FSPersonalBottomWidget$4(FSPersonalBottomWidget paramFSPersonalBottomWidget, FSPersonalFeedFragment paramFSPersonalFeedFragment) {}
  
  public void onClick(View paramView)
  {
    FSPersonalBottomWidget.a(this.b).setCurrentItem(0);
    this.a.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalBottomWidget.4
 * JD-Core Version:    0.7.0.1
 */