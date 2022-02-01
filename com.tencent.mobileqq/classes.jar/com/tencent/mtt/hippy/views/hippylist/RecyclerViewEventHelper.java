package com.tencent.mtt.hippy.views.hippylist;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.OverPullListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListItemView;

public class RecyclerViewEventHelper
  extends RecyclerView.OnScrollListener
  implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener, OverPullListener
{
  public static final String EVENT_ON_END_REACHED = "onEndReached";
  public static final String EVENT_ON_TOP_REACHED = "onTopReached";
  public static final String INITIAL_LIST_READY = "initialListReady";
  private int currentState;
  private boolean exposureEventEnable;
  protected final HippyRecyclerView hippyRecyclerView;
  private boolean isInitialListReadyNotified = false;
  private long lastScrollEventTimeStamp;
  private boolean momentumScrollBeginEventEnable;
  private boolean momentumScrollEndEventEnable;
  private HippyViewEvent onScrollDragEndedEvent;
  private HippyViewEvent onScrollDragStartedEvent;
  private HippyViewEvent onScrollEvent;
  protected boolean onScrollEventEnable = true;
  private HippyViewEvent onScrollFlingEndedEvent;
  private HippyViewEvent onScrollFlingStartedEvent;
  private ViewTreeObserver.OnPreDrawListener preDrawListener;
  private boolean scrollBeginDragEventEnable;
  private boolean scrollEndDragEventEnable;
  private int scrollEventThrottle;
  private ViewTreeObserver viewTreeObserver;
  
  public RecyclerViewEventHelper(HippyRecyclerView paramHippyRecyclerView)
  {
    this.hippyRecyclerView = paramHippyRecyclerView;
    this.hippyRecyclerView.addOnScrollListener(this);
    this.hippyRecyclerView.addOnAttachStateChangeListener(this);
    this.hippyRecyclerView.addOnLayoutChangeListener(this);
    this.preDrawListener = new RecyclerViewEventHelper.1(this);
  }
  
  private boolean canNotifyInit()
  {
    return (!this.isInitialListReadyNotified) && (this.hippyRecyclerView.getAdapter().getItemCount() > 0) && (this.hippyRecyclerView.getChildCount() > 0) && (this.viewTreeObserver.isAlive());
  }
  
  private void checkSendExposureEvent()
  {
    if (!this.exposureEventEnable) {
      return;
    }
    int j = this.hippyRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      checkExposureView(findHippyListItemView((ViewGroup)this.hippyRecyclerView.getChildAt(i)));
      i += 1;
    }
  }
  
  private void checkSendOnScrollEvent()
  {
    if (this.onScrollEventEnable)
    {
      long l = System.currentTimeMillis();
      if (l - this.lastScrollEventTimeStamp >= this.scrollEventThrottle)
      {
        this.lastScrollEventTimeStamp = l;
        sendOnScrollEvent();
      }
    }
  }
  
  private View findHippyListItemView(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup instanceof HippyListItemView)) {
      return paramViewGroup;
    }
    if (paramViewGroup.getChildCount() > 0)
    {
      paramViewGroup = paramViewGroup.getChildAt(0);
      if ((paramViewGroup instanceof HippyListItemView)) {
        return paramViewGroup;
      }
    }
    return null;
  }
  
  private boolean isOverPulling(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean isReleaseDrag(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0) {
        return bool;
      }
      if (paramInt2 == 2) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private boolean isViewVisible(View paramView)
  {
    boolean bool = false;
    if (paramView == null) {
      return false;
    }
    Rect localRect = new Rect();
    if (!paramView.getGlobalVisibleRect(localRect)) {
      return false;
    }
    if (localRect.height() * localRect.width() > paramView.getMeasuredWidth() * paramView.getMeasuredHeight() * 0.1F) {
      bool = true;
    }
    return bool;
  }
  
  private void observePreDraw()
  {
    if ((!this.isInitialListReadyNotified) && (this.viewTreeObserver == null))
    {
      this.viewTreeObserver = this.hippyRecyclerView.getViewTreeObserver();
      this.viewTreeObserver.addOnPreDrawListener(this.preDrawListener);
    }
  }
  
  protected void checkExposureView(View paramView)
  {
    if ((paramView instanceof HippyListItemView))
    {
      HippyListItemView localHippyListItemView = (HippyListItemView)paramView;
      int j;
      int i;
      String str;
      if (isViewVisible(paramView))
      {
        j = localHippyListItemView.getExposureState();
        i = 1;
        if (j == 1) {
          return;
        }
        str = "onAppear";
      }
      else
      {
        j = localHippyListItemView.getExposureState();
        i = 2;
        if (j == 2) {
          return;
        }
        str = "onDisAppear";
      }
      sendExposureEvent(paramView, str);
      localHippyListItemView.setExposureState(i);
    }
  }
  
  public final HippyMap generateScrollEvent()
  {
    HippyMap localHippyMap1 = new HippyMap();
    float f2 = this.hippyRecyclerView.getContentOffsetX();
    float f3 = this.hippyRecyclerView.getContentOffsetY();
    float f1 = f2;
    if (f2 != 0.0F) {
      f1 = PixelUtil.px2dp(f2);
    }
    f2 = f3;
    if (f3 != 0.0F) {
      f2 = PixelUtil.px2dp(f3);
    }
    localHippyMap1.pushDouble("x", f1);
    localHippyMap1.pushDouble("y", f2);
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushMap("contentOffset", localHippyMap1);
    return localHippyMap2;
  }
  
  protected HippyViewEvent getOnScrollDragEndedEvent()
  {
    if (this.onScrollDragEndedEvent == null) {
      this.onScrollDragEndedEvent = new HippyViewEvent("onScrollEndDrag");
    }
    return this.onScrollDragEndedEvent;
  }
  
  protected HippyViewEvent getOnScrollDragStartedEvent()
  {
    if (this.onScrollDragStartedEvent == null) {
      this.onScrollDragStartedEvent = new HippyViewEvent("onScrollBeginDrag");
    }
    return this.onScrollDragStartedEvent;
  }
  
  protected HippyViewEvent getOnScrollEvent()
  {
    if (this.onScrollEvent == null) {
      this.onScrollEvent = new HippyViewEvent("onScroll");
    }
    return this.onScrollEvent;
  }
  
  protected HippyViewEvent getOnScrollFlingEndedEvent()
  {
    if (this.onScrollFlingEndedEvent == null) {
      this.onScrollFlingEndedEvent = new HippyViewEvent("onMomentumScrollEnd");
    }
    return this.onScrollFlingEndedEvent;
  }
  
  protected HippyViewEvent getOnScrollFlingStartedEvent()
  {
    if (this.onScrollFlingStartedEvent == null) {
      this.onScrollFlingStartedEvent = new HippyViewEvent("onMomentumScrollBegin");
    }
    return this.onScrollFlingStartedEvent;
  }
  
  protected View getParentView()
  {
    return (View)this.hippyRecyclerView.getParent();
  }
  
  void notifyInitialListReady()
  {
    if (canNotifyInit())
    {
      this.isInitialListReadyNotified = true;
      this.viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
      this.hippyRecyclerView.post(new RecyclerViewEventHelper.2(this));
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    checkSendExposureEvent();
  }
  
  public void onOverPullStateChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("oldState:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",newState:");
    localStringBuilder.append(paramInt2);
    LogUtils.d("QBRecyclerViewEventHelper", localStringBuilder.toString());
    if ((paramInt1 == 0) && (isOverPulling(paramInt2)))
    {
      sendOnEndReachedEvent();
      getOnScrollDragStartedEvent().send(getParentView(), generateScrollEvent());
    }
    if ((isOverPulling(paramInt1)) && (isOverPulling(paramInt2))) {
      sendOnScrollEvent();
    }
    if ((paramInt2 == 4) && (paramInt1 != 4)) {
      getOnScrollDragEndedEvent().send(getParentView(), generateScrollEvent());
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = this.currentState;
    this.currentState = paramInt;
    sendDragEvent(paramInt);
    sendDragEndEvent(i, this.currentState);
    sendFlingEvent(paramInt);
    sendFlingEndEvent(i, this.currentState);
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      checkSendOnScrollEvent();
    }
    checkSendExposureEvent();
    if (!paramRecyclerView.canScrollVertically(1)) {
      sendOnEndReachedEvent();
    }
    if (!paramRecyclerView.canScrollVertically(-1)) {
      sendOnTopReachedEvent();
    }
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    observePreDraw();
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
  
  protected void sendDragEndEvent(int paramInt1, int paramInt2)
  {
    if ((this.scrollEndDragEventEnable) && (isReleaseDrag(paramInt1, paramInt2)) && (!this.hippyRecyclerView.isOverPulling())) {
      getOnScrollDragEndedEvent().send(getParentView(), generateScrollEvent());
    }
  }
  
  protected void sendDragEvent(int paramInt)
  {
    if ((this.scrollBeginDragEventEnable) && (paramInt == 1)) {
      getOnScrollDragStartedEvent().send(getParentView(), generateScrollEvent());
    }
  }
  
  protected void sendExposureEvent(View paramView, String paramString)
  {
    if ((paramString.equals("onAppear")) || (paramString.equals("onDisAppear"))) {
      new HippyViewEvent(paramString).send(paramView, null);
    }
  }
  
  protected void sendFlingEndEvent(int paramInt1, int paramInt2)
  {
    if ((this.momentumScrollEndEventEnable) && (paramInt1 == 2) && (paramInt2 != 2)) {
      getOnScrollFlingEndedEvent().send(getParentView(), generateScrollEvent());
    }
  }
  
  protected void sendFlingEvent(int paramInt)
  {
    if ((this.momentumScrollBeginEventEnable) && (paramInt == 2)) {
      getOnScrollFlingStartedEvent().send(getParentView(), generateScrollEvent());
    }
  }
  
  protected void sendOnEndReachedEvent()
  {
    new HippyViewEvent("onEndReached").send(getParentView(), null);
  }
  
  public void sendOnScrollEvent()
  {
    getOnScrollEvent().send(getParentView(), generateScrollEvent());
  }
  
  protected void sendOnTopReachedEvent()
  {
    new HippyViewEvent("onTopReached").send(getParentView(), null);
  }
  
  public void setExposureEventEnable(boolean paramBoolean)
  {
    this.exposureEventEnable = paramBoolean;
  }
  
  public void setMomentumScrollBeginEventEnable(boolean paramBoolean)
  {
    this.momentumScrollBeginEventEnable = paramBoolean;
  }
  
  public void setMomentumScrollEndEventEnable(boolean paramBoolean)
  {
    this.momentumScrollEndEventEnable = paramBoolean;
  }
  
  public void setOnScrollEventEnable(boolean paramBoolean)
  {
    this.onScrollEventEnable = paramBoolean;
  }
  
  public void setScrollBeginDragEventEnable(boolean paramBoolean)
  {
    this.scrollBeginDragEventEnable = paramBoolean;
  }
  
  public void setScrollEndDragEventEnable(boolean paramBoolean)
  {
    this.scrollEndDragEventEnable = paramBoolean;
  }
  
  public void setScrollEventThrottle(int paramInt)
  {
    this.scrollEventThrottle = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper
 * JD-Core Version:    0.7.0.1
 */