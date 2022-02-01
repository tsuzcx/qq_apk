package com.tencent.mtt.hippy.views.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.supportui.views.viewpager.ViewPager;

public class HippyViewPager
  extends ViewPager
  implements HippyViewBase
{
  private static final String TAG = "HippyViewPager";
  private Promise mCallBackPromise;
  private boolean mFirstUpdateChild = true;
  private NativeGestureDispatcher mGestureDispatcher;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private final Runnable mMeasureAndLayout = new HippyViewPager.1(this);
  private String mOverflow;
  private ViewPagerPageChangeListener mPageListener;
  private boolean mReNotifyOnAttach = false;
  private boolean mScrollEnabled = true;
  
  public HippyViewPager(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public HippyViewPager(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setCallPageChangedOnFirstLayout(true);
    setEnableReLayoutOnAttachToWindow(false);
    this.mPageListener = new ViewPagerPageChangeListener(this);
    setOnPageChangeListener(this.mPageListener);
    setAdapter(createAdapter(paramContext));
    setLeftDragOutSizeEnabled(false);
    setRightDragOutSizeEnabled(false);
  }
  
  protected void addViewToAdapter(HippyViewPagerItem paramHippyViewPagerItem, int paramInt)
  {
    HippyViewPagerAdapter localHippyViewPagerAdapter = getAdapter();
    if (localHippyViewPagerAdapter != null) {
      localHippyViewPagerAdapter.addView(paramHippyViewPagerItem, paramInt);
    }
  }
  
  protected HippyViewPagerAdapter createAdapter(Context paramContext)
  {
    return new HippyViewPagerAdapter((HippyInstanceContext)paramContext, this);
  }
  
  public HippyViewPagerAdapter getAdapter()
  {
    return (HippyViewPagerAdapter)super.getAdapter();
  }
  
  protected int getAdapterViewSize()
  {
    HippyViewPagerAdapter localHippyViewPagerAdapter = getAdapter();
    if (localHippyViewPagerAdapter != null) {
      return localHippyViewPagerAdapter.getItemViewSize();
    }
    return 0;
  }
  
  public Promise getCallBackPromise()
  {
    return this.mCallBackPromise;
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.mGestureDispatcher;
  }
  
  public View getViewFromAdapter(int paramInt)
  {
    HippyViewPagerAdapter localHippyViewPagerAdapter = getAdapter();
    if (localHippyViewPagerAdapter != null) {
      return localHippyViewPagerAdapter.getViewAt(paramInt);
    }
    return null;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    LogUtils.d("HippyViewPager", "onAttachedToWindow: " + hashCode() + ", childCount=" + getChildCount() + ", repopulate=" + this.mNeedRepopulate + ", renotifyOnAttach=" + this.mReNotifyOnAttach);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    LogUtils.d("HippyViewPager", "onDetachedFromWindow: " + hashCode() + ", childCount=" + getChildCount() + ", repopulate=" + this.mNeedRepopulate + ", renotifyOnAttach=" + this.mReNotifyOnAttach);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void removeViewFromAdapter(HippyViewPagerItem paramHippyViewPagerItem)
  {
    HippyViewPagerAdapter localHippyViewPagerAdapter = getAdapter();
    if (localHippyViewPagerAdapter != null) {
      localHippyViewPagerAdapter.removeView(paramHippyViewPagerItem);
    }
  }
  
  public void setCallBackPromise(Promise paramPromise)
  {
    this.mCallBackPromise = paramPromise;
  }
  
  public void setChildCountAndUpdate(int paramInt)
  {
    LogUtils.d("HippyViewPager", "doUpdateInternal: " + hashCode() + ", childCount=" + paramInt);
    if (this.mFirstUpdateChild)
    {
      setFirstLayoutParameter(true);
      this.mFirstUpdateChild = false;
    }
    getAdapter().setChildSize(paramInt);
    getAdapter().notifyDataSetChanged();
    triggerRequestLayout();
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.mGestureDispatcher = paramNativeGestureDispatcher;
  }
  
  public void setInitialPageIndex(int paramInt)
  {
    getAdapter().setInitPageIndex(paramInt);
  }
  
  public void setOverflow(String paramString)
  {
    this.mOverflow = paramString;
    int i;
    if (!TextUtils.isEmpty(this.mOverflow))
    {
      paramString = this.mOverflow;
      i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      if (!paramString.equals("visible")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("hidden")) {
        break;
      }
      i = 1;
      break;
      setClipChildren(false);
      continue;
      setClipChildren(true);
    }
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.mScrollEnabled = paramBoolean;
  }
  
  public void switchToPage(int paramInt, boolean paramBoolean)
  {
    LogUtils.d("HippyViewPager", "switchToPage: " + hashCode() + ", item=" + paramInt + ", animated=" + paramBoolean);
    if (getAdapter().getCount() == 0) {}
    do
    {
      return;
      if (getCurrentItem() != paramInt)
      {
        if (isSettling())
        {
          setScrollingCacheEnabled(false);
          this.mScroller.abortAnimation();
          int i = getScrollX();
          int j = getScrollY();
          int k = this.mScroller.getCurrX();
          int m = this.mScroller.getCurrY();
          if ((i != k) || (j != m)) {
            scrollTo(k, m);
          }
          setScrollState(0);
        }
        setCurrentItem(paramInt, paramBoolean);
        return;
      }
    } while (isFirstLayout());
    this.mPageListener.onPageSelected(paramInt);
  }
  
  public void triggerRequestLayout()
  {
    this.mHandler.post(this.mMeasureAndLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.HippyViewPager
 * JD-Core Version:    0.7.0.1
 */