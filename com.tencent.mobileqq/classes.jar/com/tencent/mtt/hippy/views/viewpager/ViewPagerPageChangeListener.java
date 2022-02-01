package com.tencent.mtt.hippy.views.viewpager;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageItemExposureEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageScrollEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageScrollStateChangedEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageSelectedEvent;
import com.tencent.mtt.supportui.views.viewpager.ViewPager.OnPageChangeListener;

public class ViewPagerPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private int mCurrPageIndex;
  private int mLastPageIndex;
  private HippyPageScrollEvent mPageScrollEmitter;
  private HippyPageScrollStateChangedEvent mPageScrollStateChangeEmitter;
  private HippyPageSelectedEvent mPageSelectedEmitter;
  private HippyViewPager mPager;
  
  public ViewPagerPageChangeListener(HippyViewPager paramHippyViewPager)
  {
    this.mPager = paramHippyViewPager;
    this.mPageScrollEmitter = new HippyPageScrollEvent(paramHippyViewPager);
    this.mPageScrollStateChangeEmitter = new HippyPageScrollStateChangedEvent(paramHippyViewPager);
    this.mPageSelectedEmitter = new HippyPageSelectedEvent(paramHippyViewPager);
    this.mLastPageIndex = 0;
    this.mCurrPageIndex = 0;
  }
  
  private void onScrollStateChangeToIdle()
  {
    if ((this.mPager != null) && (this.mCurrPageIndex != this.mLastPageIndex))
    {
      Object localObject = this.mPager.getCallBackPromise();
      if (localObject != null)
      {
        HippyMap localHippyMap = new HippyMap();
        localHippyMap.pushString("msg", "on set index successful!");
        ((Promise)localObject).resolve(localHippyMap);
        this.mPager.setCallBackPromise(null);
      }
      localObject = this.mPager.getViewFromAdapter(this.mCurrPageIndex);
      new HippyPageItemExposureEvent("onDidAppear").send((View)localObject, this.mCurrPageIndex);
      localObject = this.mPager.getViewFromAdapter(this.mLastPageIndex);
      new HippyPageItemExposureEvent("onDidDisAppear").send((View)localObject, this.mLastPageIndex);
      this.mLastPageIndex = this.mCurrPageIndex;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt1, int paramInt2)
  {
    String str;
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("Unsupported pageScrollState");
    case 0: 
      str = "idle";
      onScrollStateChangeToIdle();
    }
    for (;;)
    {
      this.mPageScrollStateChangeEmitter.send(str);
      return;
      str = "dragging";
      continue;
      str = "settling";
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.mPageScrollEmitter.send(paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.mCurrPageIndex = paramInt;
    this.mPageSelectedEmitter.send(paramInt);
    if (this.mPager != null)
    {
      View localView = this.mPager.getViewFromAdapter(this.mCurrPageIndex);
      new HippyPageItemExposureEvent("onWillAppear").send(localView, this.mCurrPageIndex);
      localView = this.mPager.getViewFromAdapter(this.mLastPageIndex);
      new HippyPageItemExposureEvent("onWillDisAppear").send(localView, this.mLastPageIndex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.ViewPagerPageChangeListener
 * JD-Core Version:    0.7.0.1
 */