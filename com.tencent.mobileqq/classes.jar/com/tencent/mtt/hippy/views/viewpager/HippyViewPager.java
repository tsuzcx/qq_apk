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
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private final Runnable mMeasureAndLayout = new HippyViewPager.1(this);
  private ViewPagerPageChangeListener mPageListener;
  private final boolean mReNotifyOnAttach = false;
  
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAttachedToWindow: ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", childCount=");
    localStringBuilder.append(getChildCount());
    localStringBuilder.append(", repopulate=");
    localStringBuilder.append(this.mNeedRepopulate);
    localStringBuilder.append(", renotifyOnAttach=");
    localStringBuilder.append(false);
    LogUtils.d("HippyViewPager", localStringBuilder.toString());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetachedFromWindow: ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", childCount=");
    localStringBuilder.append(getChildCount());
    localStringBuilder.append(", repopulate=");
    localStringBuilder.append(this.mNeedRepopulate);
    localStringBuilder.append(", renotifyOnAttach=");
    localStringBuilder.append(false);
    LogUtils.d("HippyViewPager", localStringBuilder.toString());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isScrollEnabled()) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isScrollEnabled()) {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doUpdateInternal: ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", childCount=");
    localStringBuilder.append(paramInt);
    LogUtils.d("HippyViewPager", localStringBuilder.toString());
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
    if (!TextUtils.isEmpty(paramString))
    {
      int i = -1;
      int j = paramString.hashCode();
      if (j != -1217487446)
      {
        if ((j == 466743410) && (paramString.equals("visible"))) {
          i = 0;
        }
      }
      else if (paramString.equals("hidden")) {
        i = 1;
      }
      if (i != 0)
      {
        if (i == 1) {
          setClipChildren(true);
        }
      }
      else {
        setClipChildren(false);
      }
    }
    invalidate();
  }
  
  public void switchToPage(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToPage: ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", item=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", animated=");
    localStringBuilder.append(paramBoolean);
    LogUtils.d("HippyViewPager", localStringBuilder.toString());
    if (getAdapter().getCount() == 0) {
      return;
    }
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
    if (!isFirstLayout()) {
      this.mPageListener.onPageSelected(paramInt);
    }
  }
  
  public void triggerRequestLayout()
  {
    this.mHandler.post(this.mMeasureAndLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.HippyViewPager
 * JD-Core Version:    0.7.0.1
 */