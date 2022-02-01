package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;

public class HippyWaterfallView
  extends RecyclerView
  implements HippyViewBase
{
  HippyWaterfallAdapter a;
  boolean b;
  boolean c;
  HippyArray d;
  private HippyEngineContext e;
  private NativeGestureDispatcher f;
  private Runnable g = null;
  private HippyWaterfallView.OnInitialListReadyEvent h;
  private boolean i = false;
  private ViewTreeObserver.OnPreDrawListener j = null;
  private ViewTreeObserver k = null;
  
  public HippyWaterfallView(Context paramContext)
  {
    super(paramContext);
    this.e = ((HippyInstanceContext)paramContext).getEngineContext();
    setLayoutManager(new HippyWaterfallLayoutManager(paramContext));
    this.a = new HippyWaterfallAdapter(this, this, this.e);
    setRecycledViewPool(new HippyWaterfallView.RNWFRecyclerPool());
    this.b = true;
    this.c = false;
    this.d = null;
    addOnListScrollListener(this.a.b());
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int n = paramView.getChildCount();
      int m = 0;
      while (m < n)
      {
        a(paramView.getChildAt(m));
        m += 1;
      }
    }
  }
  
  private HippyWaterfallView.OnInitialListReadyEvent getOnInitialListReadyEvent()
  {
    if (this.h == null) {
      this.h = new HippyWaterfallView.OnInitialListReadyEvent(this, "initialListReady");
    }
    return this.h;
  }
  
  protected HippyWaterfallView.ExposureForReport a(int paramInt1, int paramInt2)
  {
    return this.a.b(paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.a.c().send(this, null);
    this.a.setLoadingStatus(1);
  }
  
  public void a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    scrollToPosition(0, (int)-PixelUtil.dp2px(paramDouble2));
    post(new HippyWaterfallView.3(this));
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    scrollToPosition(paramInt2, 0);
    post(new HippyWaterfallView.2(this));
  }
  
  protected void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void checkNotifyFooterAppearWithFewChild(int paramInt) {}
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.f;
  }
  
  public void handleInTraversal(int paramInt1, int paramInt2, View paramView)
  {
    if (paramInt1 == 1001) {
      a(paramView);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!this.i)
    {
      this.k = getViewTreeObserver();
      if (this.j == null) {
        this.j = new HippyWaterfallView.4(this);
      }
      this.k.removeOnPreDrawListener(this.j);
      this.k.addOnPreDrawListener(this.j);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    ViewTreeObserver.OnPreDrawListener localOnPreDrawListener = this.j;
    if (localOnPreDrawListener != null)
    {
      ViewTreeObserver localViewTreeObserver = this.k;
      if (localViewTreeObserver != null) {
        localViewTreeObserver.removeOnPreDrawListener(localOnPreDrawListener);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public void onScrollStateChanged(int paramInt1, int paramInt2)
  {
    super.onScrollStateChanged(paramInt1, paramInt2);
    if (getAdapter() != null)
    {
      this.a.a();
      this.a.a(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    NativeGestureDispatcher localNativeGestureDispatcher = this.f;
    boolean bool1 = bool2;
    if (localNativeGestureDispatcher != null) {
      bool1 = bool2 | localNativeGestureDispatcher.handleTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
  
  public void scrollToTopAtOnce()
  {
    super.scrollToTopAtOnce();
  }
  
  public void setEnableExposureReport(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public void setEnableScrollForReport(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.f = paramNativeGestureDispatcher;
  }
  
  public void setListData()
  {
    if (getAdapter() == null) {
      setAdapter(this.a);
    }
    this.a.notifyDataSetChanged();
    if (this.g == null) {
      this.g = new HippyWaterfallView.1(this);
    }
    removeCallbacks(this.g);
    post(this.g);
  }
  
  protected void setPreloadItemNumber(int paramInt)
  {
    this.a.setPreloadItemNumber(paramInt);
  }
  
  public void setPreloadPixel(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setRefreshColors(HippyArray paramHippyArray)
  {
    this.d = paramHippyArray;
  }
  
  public void setRefreshEnabled(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected boolean shouldStopOnInterceptTouchEvent(MotionEvent paramMotionEvent, int paramInt, boolean paramBoolean)
  {
    if ((this.mOffsetY >= 0) && (getHeight() <= paramInt)) {
      return false;
    }
    return paramBoolean ^ true;
  }
  
  protected boolean shouldStopOnTouchEvent(MotionEvent paramMotionEvent, int paramInt, boolean paramBoolean)
  {
    if ((this.mOffsetY >= 0) && (getHeight() <= paramInt)) {
      return false;
    }
    return paramBoolean ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView
 * JD-Core Version:    0.7.0.1
 */