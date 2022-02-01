package com.tencent.qqlive.module.videoreport.report.scroll;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.ref.WeakReference;

class ScrollStateObserver$PageChangeListenerImpl
  implements ViewPager.OnPageChangeListener
{
  private WeakReference<ViewPager> mViewPagerRef;
  
  ScrollStateObserver$PageChangeListenerImpl(ScrollStateObserver paramScrollStateObserver, ViewPager paramViewPager)
  {
    this.mViewPagerRef = new WeakReference(paramViewPager);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ScrollStateObserver", "ViewPager.onPageScrollStateChanged: state = " + paramInt);
    }
    ViewPager localViewPager = (ViewPager)this.mViewPagerRef.get();
    if (localViewPager == null) {
      return;
    }
    ScrollStateObserver localScrollStateObserver = this.this$0;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ScrollStateObserver.access$100(localScrollStateObserver, localViewPager, bool);
      if (paramInt != 0) {
        break;
      }
      this.this$0.onIdle(localViewPager);
      return;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollStateObserver.PageChangeListenerImpl
 * JD-Core Version:    0.7.0.1
 */