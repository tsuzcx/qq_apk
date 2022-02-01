package com.tencent.qqlive.module.videoreport.report.scroll;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
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
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ViewPager.onPageScrollStateChanged: state = ");
      ((StringBuilder)localObject).append(paramInt);
      Log.d("ScrollStateObserver", ((StringBuilder)localObject).toString());
    }
    Object localObject = (ViewPager)this.mViewPagerRef.get();
    if (localObject == null) {
      return;
    }
    ScrollStateObserver localScrollStateObserver = this.this$0;
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ScrollStateObserver.access$100(localScrollStateObserver, (View)localObject, bool);
    if (paramInt == 0) {
      this.this$0.onIdle((View)localObject);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollStateObserver.PageChangeListenerImpl
 * JD-Core Version:    0.7.0.1
 */