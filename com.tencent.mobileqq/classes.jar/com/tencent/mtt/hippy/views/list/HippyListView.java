package com.tencent.mtt.hippy.views.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.State;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem;

public class HippyListView
  extends RecyclerView
  implements HippyViewBase
{
  public static final String EVENT_TYPE_FOOTER_PULLING = "onFooterPulling";
  public static final String EVENT_TYPE_FOOTER_RELEASED = "onFooterReleased";
  public static final String EVENT_TYPE_HEADER_PULLING = "onHeaderPulling";
  public static final String EVENT_TYPE_HEADER_RELEASED = "onHeaderReleased";
  public static final int REFRESH_STATE_IDLE = 0;
  public static final int REFRESH_STATE_LOADING = 1;
  private Context mContext;
  protected boolean mEnableRefresh = true;
  protected int mFooterRefreshState = 0;
  private NativeGestureDispatcher mGestureDispatcher;
  private boolean mHasRemovePreDraw = false;
  protected int mHeaderRefreshState = 0;
  private HippyEngineContext mHippyContext;
  protected int mLastOffsetX = -2147483648;
  protected int mLastOffsetY = -2147483648;
  protected long mLastScrollEventTimeStamp = -1L;
  private HippyListAdapter mListAdapter;
  protected boolean mMomentumScrollBeginEventEnable = false;
  protected boolean mMomentumScrollEndEventEnable = false;
  private HippyListView.OnInitialListReadyEvent mOnInitialListReadyEvent;
  private HippyListView.OnScrollDragEndedEvent mOnScrollDragEndedEvent;
  private HippyListView.OnScrollDragStartedEvent mOnScrollDragStartedEvent;
  private HippyListView.OnScrollEvent mOnScrollEvent;
  private HippyListView.OnScrollFlingEndedEvent mOnScrollFlingEndedEvent;
  private HippyListView.OnScrollFlingStartedEvent mOnScrollFlingStartedEvent;
  private ViewTreeObserver.OnPreDrawListener mPreDrawListener = null;
  protected boolean mScrollBeginDragEventEnable = false;
  protected boolean mScrollEnable = true;
  protected boolean mScrollEndDragEventEnable = false;
  protected boolean mScrollEventEnable = true;
  protected int mScrollEventThrottle = 400;
  private ViewTreeObserver mViewTreeObserver = null;
  
  public HippyListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, 1);
  }
  
  public HippyListView(Context paramContext, int paramInt)
  {
    super(paramContext);
    init(paramContext, paramInt);
  }
  
  private void dispatchExposureEvent()
  {
    if ((this.mLayout instanceof BaseLayoutManager))
    {
      BaseLayoutManager.OrientationHelper localOrientationHelper = ((BaseLayoutManager)this.mLayout).mOrientationHelper;
      int k = getChildCount();
      if (this.mLayout.canScrollHorizontally()) {}
      for (int i = this.mState.mCustomHeaderWidth;; i = this.mState.mCustomHeaderHeight)
      {
        int m = localOrientationHelper.getStartAfterPadding();
        int n = localOrientationHelper.getEndAfterPadding();
        int j = 0;
        while (j < k)
        {
          Object localObject = getChildAt(j);
          int i1 = localOrientationHelper.getDecoratedStart((View)localObject);
          int i2 = localOrientationHelper.getDecoratedEnd((View)localObject);
          if ((localObject instanceof RecyclerViewItem))
          {
            localObject = (RecyclerViewItem)localObject;
            if (((RecyclerViewItem)localObject).getChildCount() > 0) {
              checkExposureView(((RecyclerViewItem)localObject).getChildAt(0), m + i, n - i, i1, i2);
            }
          }
          j += 1;
        }
      }
    }
  }
  
  private HippyListView.OnInitialListReadyEvent getOnInitialListReadyEvent()
  {
    if (this.mOnInitialListReadyEvent == null) {
      this.mOnInitialListReadyEvent = new HippyListView.OnInitialListReadyEvent(this, "initialListReady");
    }
    return this.mOnInitialListReadyEvent;
  }
  
  private void init(Context paramContext, int paramInt)
  {
    this.mHippyContext = ((HippyInstanceContext)paramContext).getEngineContext();
    setLayoutManager(new LinearLayoutManager(paramContext, paramInt, false));
    this.mContext = paramContext;
    setRepeatableSuspensionMode(false);
    this.mListAdapter = createAdapter(this, this.mHippyContext);
    setAdapter(this.mListAdapter);
  }
  
  private boolean shouldStopReleaseGlowsForHorizontal()
  {
    int i = this.mAdapter.getTotalHeight();
    if ((this.mOffsetX <= 0) || (getWidth() > i - this.mState.mCustomHeaderWidth))
    {
      if (this.mHeaderRefreshState == 0)
      {
        sendPullHeaderEvent("onHeaderReleased", new HippyMap());
        this.mHeaderRefreshState = 1;
      }
      smoothScrollBy(-this.mOffsetX, 0, false, true);
      return true;
    }
    int j = i - getWidth() + this.mState.mCustomFooterWidth;
    if ((i - this.mState.mCustomHeaderWidth < getWidth()) || (this.mOffsetX >= j))
    {
      if (this.mFooterRefreshState == 0)
      {
        sendPullFooterEvent("onFooterReleased", new HippyMap());
        this.mFooterRefreshState = 1;
      }
      View localView = getCustomFooterView();
      if ((localView != null) && ((localView instanceof HippyPullFooterView)) && (((HippyPullFooterView)localView).getStickEnabled()))
      {
        smoothScrollBy(j - this.mOffsetX, 0, false, true);
        return true;
      }
    }
    return false;
  }
  
  private boolean shouldStopReleaseGlowsForVertical()
  {
    int i = this.mAdapter.getTotalHeight();
    if ((getOffsetY() <= 0) || (getHeight() > i - this.mState.mCustomHeaderHeight))
    {
      if (this.mHeaderRefreshState == 0)
      {
        sendPullHeaderEvent("onHeaderReleased", new HippyMap());
        this.mHeaderRefreshState = 1;
      }
      smoothScrollBy(0, -this.mOffsetY, false, true);
      return true;
    }
    int j = i - getHeight() + this.mState.mCustomFooterHeight;
    if ((i - this.mState.mCustomHeaderHeight < getHeight()) || (getOffsetY() >= j))
    {
      if (this.mFooterRefreshState == 0)
      {
        sendPullFooterEvent("onFooterReleased", new HippyMap());
        this.mFooterRefreshState = 1;
      }
      View localView = getCustomFooterView();
      if ((localView != null) && ((localView instanceof HippyPullFooterView)) && (((HippyPullFooterView)localView).getStickEnabled()))
      {
        smoothScrollBy(0, j - this.mOffsetY, false, true);
        return true;
      }
    }
    return false;
  }
  
  protected void checkExposureView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView == null) || (!(paramView instanceof HippyListItemView))) {}
    label28:
    HippyListItemView localHippyListItemView;
    label135:
    label144:
    do
    {
      return;
      if (this.mLayout.canScrollHorizontally())
      {
        paramInt4 = paramView.getLeft();
        if (!this.mLayout.canScrollHorizontally()) {
          break label135;
        }
      }
      for (int i = paramView.getRight();; i = paramView.getBottom())
      {
        paramInt4 += paramInt3;
        paramInt3 = i + paramInt3;
        localHippyListItemView = (HippyListItemView)paramView;
        if (((paramInt4 < paramInt1) && (paramInt3 > paramInt1)) || ((paramInt4 < paramInt2) && (paramInt3 > paramInt2))) {
          break;
        }
        if ((paramInt3 > paramInt1) && (paramInt4 < paramInt2 - 1)) {
          break label144;
        }
        if (localHippyListItemView.getExposureState() == 3) {
          break;
        }
        sendExposureEvent(paramView, "onDisAppear");
        localHippyListItemView.setExposureState(3);
        return;
        paramInt4 = paramView.getTop();
        break label28;
      }
    } while (((paramInt4 < paramInt1) || (paramInt3 > paramInt2)) && ((paramInt4 > paramInt1) || (paramInt3 <= paramInt2) || (localHippyListItemView.getExposureState() == 1)));
    sendExposureEvent(paramView, "onAppear");
    localHippyListItemView.setExposureState(1);
  }
  
  protected HippyListAdapter createAdapter(RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    return new HippyListAdapter(paramRecyclerView, paramHippyEngineContext);
  }
  
  protected HippyMap generateScrollEvent()
  {
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushDouble("x", PixelUtil.px2dp(0.0F));
    localHippyMap1.pushDouble("y", PixelUtil.px2dp(getOffsetY()));
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushMap("contentOffset", localHippyMap1);
    return localHippyMap2;
  }
  
  public View getCustomFooterView()
  {
    if (getChildCount() > 0)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(getChildCount() - 1));
      if (localViewHolder != null) {
        return localViewHolder.mContent;
      }
    }
    return null;
  }
  
  public View getCustomHeaderView()
  {
    if (getChildCount() > 0)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(0));
      if (localViewHolder != null) {
        return localViewHolder.mContent;
      }
    }
    return null;
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.mGestureDispatcher;
  }
  
  protected HippyListView.OnScrollDragEndedEvent getOnScrollDragEndedEvent()
  {
    if (this.mOnScrollDragEndedEvent == null) {
      this.mOnScrollDragEndedEvent = new HippyListView.OnScrollDragEndedEvent(this, "onScrollEndDrag");
    }
    return this.mOnScrollDragEndedEvent;
  }
  
  protected HippyListView.OnScrollDragStartedEvent getOnScrollDragStartedEvent()
  {
    if (this.mOnScrollDragStartedEvent == null) {
      this.mOnScrollDragStartedEvent = new HippyListView.OnScrollDragStartedEvent(this, "onScrollBeginDrag");
    }
    return this.mOnScrollDragStartedEvent;
  }
  
  protected HippyListView.OnScrollEvent getOnScrollEvent()
  {
    if (this.mOnScrollEvent == null) {
      this.mOnScrollEvent = new HippyListView.OnScrollEvent(this, "onScroll");
    }
    return this.mOnScrollEvent;
  }
  
  protected HippyListView.OnScrollFlingEndedEvent getOnScrollFlingEndedEvent()
  {
    if (this.mOnScrollFlingEndedEvent == null) {
      this.mOnScrollFlingEndedEvent = new HippyListView.OnScrollFlingEndedEvent(this, "onMomentumScrollEnd");
    }
    return this.mOnScrollFlingEndedEvent;
  }
  
  protected HippyListView.OnScrollFlingStartedEvent getOnScrollFlingStartedEvent()
  {
    if (this.mOnScrollFlingStartedEvent == null) {
      this.mOnScrollFlingStartedEvent = new HippyListView.OnScrollFlingStartedEvent(this, "onMomentumScrollBegin");
    }
    return this.mOnScrollFlingStartedEvent;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!this.mHasRemovePreDraw)
    {
      this.mViewTreeObserver = getViewTreeObserver();
      if (this.mPreDrawListener == null) {
        this.mPreDrawListener = new HippyListView.1(this);
      }
      this.mViewTreeObserver.removeOnPreDrawListener(this.mPreDrawListener);
      this.mViewTreeObserver.addOnPreDrawListener(this.mPreDrawListener);
    }
  }
  
  public void onDetachedFromWindow()
  {
    if ((this.mPreDrawListener != null) && (this.mViewTreeObserver != null)) {
      this.mViewTreeObserver.removeOnPreDrawListener(this.mPreDrawListener);
    }
    super.onDetachedFromWindow();
  }
  
  public void onFooterRefreshFinish()
  {
    int i;
    if (this.mFooterRefreshState == 1)
    {
      if (!this.mLayout.canScrollHorizontally()) {
        break label55;
      }
      i = getTotalHeight() - getWidth();
      if (this.mOffsetX > i) {
        smoothScrollBy(i - this.mOffsetX, 0, false, true);
      }
    }
    for (;;)
    {
      this.mFooterRefreshState = 0;
      return;
      label55:
      i = getTotalHeight() - getHeight();
      if (this.mOffsetY > i) {
        smoothScrollBy(0, i - this.mOffsetY, false, true);
      }
    }
  }
  
  public void onHeaderRefresh()
  {
    if (this.mHeaderRefreshState == 0)
    {
      if (this.mLayout.canScrollHorizontally()) {
        smoothScrollBy(-this.mOffsetX, 0, false, true);
      }
    }
    else {
      return;
    }
    smoothScrollBy(0, -this.mOffsetY, false, true);
  }
  
  public void onHeaderRefreshFinish()
  {
    if (this.mHeaderRefreshState == 1)
    {
      if (!this.mLayout.canScrollHorizontally()) {
        break label58;
      }
      if (this.mOffsetX < this.mState.mCustomHeaderWidth) {
        smoothScrollBy(-this.mOffsetX + this.mState.mCustomHeaderWidth, 0, false, true);
      }
    }
    for (;;)
    {
      this.mHeaderRefreshState = 0;
      return;
      label58:
      if (this.mOffsetY < this.mState.mCustomHeaderHeight) {
        smoothScrollBy(0, -this.mOffsetY + this.mState.mCustomHeaderHeight, false, true);
      }
    }
  }
  
  protected void onInitialListReady() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnable) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      dispatchExposureEvent();
    }
  }
  
  public void onScrollDragEnded()
  {
    if (this.mScrollEndDragEventEnable) {
      getOnScrollDragEndedEvent().send(this, generateScrollEvent());
    }
  }
  
  public void onScrollDragStarted()
  {
    if (this.mScrollBeginDragEventEnable) {
      getOnScrollDragStartedEvent().send(this, generateScrollEvent());
    }
  }
  
  public void onScrollFlingEnded()
  {
    if (this.mMomentumScrollEndEventEnable) {
      getOnScrollFlingEndedEvent().send(this, generateScrollEvent());
    }
  }
  
  public void onScrollFlingStarted()
  {
    if (this.mMomentumScrollBeginEventEnable) {
      getOnScrollFlingStartedEvent().send(this, generateScrollEvent());
    }
  }
  
  public void onScrolled(int paramInt1, int paramInt2)
  {
    super.onScrolled(paramInt1, paramInt2);
    sendOnScrollEvent();
    dispatchExposureEvent();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnable) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onTouchMove(int paramInt1, int paramInt2)
  {
    paramInt1 = this.mAdapter.getTotalHeight();
    HippyMap localHippyMap = new HippyMap();
    float f = 0.0F;
    String str = "";
    if (this.mLayout.canScrollHorizontally()) {
      if (this.mOffsetX < this.mState.mCustomHeaderWidth)
      {
        f = Math.abs(this.mOffsetX - this.mState.mCustomHeaderWidth);
        str = "onHeaderPulling";
        label69:
        localHippyMap.pushDouble("contentOffset", PixelUtil.px2dp(f));
        paramInt1 = -1;
        switch (str.hashCode())
        {
        }
      }
    }
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        return;
        if (this.mOffsetX <= paramInt1 - getWidth()) {
          break label69;
        }
        f = Math.abs(this.mOffsetX - paramInt1 - getWidth());
        str = "onFooterPulling";
        break label69;
        if (getOffsetY() < this.mState.mCustomHeaderHeight)
        {
          f = Math.abs(getOffsetY() - this.mState.mCustomHeaderHeight);
          str = "onHeaderPulling";
          break label69;
        }
        if (getOffsetY() <= paramInt1 - getHeight()) {
          break label69;
        }
        f = Math.abs(getOffsetY() - paramInt1 - getHeight());
        str = "onFooterPulling";
        break label69;
        if (str.equals("onHeaderPulling"))
        {
          paramInt1 = 0;
          continue;
          if (str.equals("onFooterPulling")) {
            paramInt1 = 1;
          }
        }
        break;
      }
    }
    sendPullHeaderEvent(str, localHippyMap);
    return;
    sendPullFooterEvent(str, localHippyMap);
  }
  
  public void scrollToContentOffset(double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt)
  {
    int i = (int)PixelUtil.dp2px(paramDouble2);
    if (paramBoolean)
    {
      i -= getOffsetY();
      if (paramInt != 0)
      {
        if ((i != 0) && (!this.mState.didStructureChange())) {
          this.mViewFlinger.smoothScrollBy(0, i, paramInt, true);
        }
        return;
      }
      smoothScrollBy(0, i);
      return;
    }
    scrollBy(0, i - getOffsetY());
    post(new HippyListView.3(this));
  }
  
  public void scrollToIndex(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramBoolean)
    {
      paramInt1 = getHeightBefore(paramInt2) - getOffsetY();
      if (paramInt3 != 0)
      {
        if ((paramInt1 != 0) && (!this.mState.didStructureChange())) {
          this.mViewFlinger.smoothScrollBy(0, paramInt1, paramInt3, true);
        }
        return;
      }
      smoothScrollBy(0, paramInt1);
      return;
    }
    scrollToPosition(paramInt2, 0);
    post(new HippyListView.2(this));
  }
  
  protected void sendExposureEvent(View paramView, String paramString)
  {
    if ((paramString.equals("onAppear")) || (paramString.equals("onDisAppear"))) {
      new HippyViewEvent(paramString).send(paramView, null);
    }
  }
  
  protected void sendOnScrollEvent()
  {
    long l;
    if (this.mScrollEventEnable)
    {
      l = System.currentTimeMillis();
      if (l - this.mLastScrollEventTimeStamp >= this.mScrollEventThrottle) {}
    }
    else
    {
      return;
    }
    this.mLastScrollEventTimeStamp = l;
    getOnScrollEvent().send(this, generateScrollEvent());
  }
  
  protected void sendPullFooterEvent(String paramString, HippyMap paramHippyMap)
  {
    paramString = new HippyListView.PullElementEvent(this, paramString);
    View localView = getCustomFooterView();
    if ((localView != null) && ((localView instanceof HippyPullFooterView))) {
      paramString.send(localView, paramHippyMap);
    }
  }
  
  protected void sendPullHeaderEvent(String paramString, HippyMap paramHippyMap)
  {
    paramString = new HippyListView.PullElementEvent(this, paramString);
    View localView = getCustomHeaderView();
    if ((localView != null) && ((localView instanceof HippyPullHeaderView))) {
      paramString.send(localView, paramHippyMap);
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.mGestureDispatcher = paramNativeGestureDispatcher;
  }
  
  public void setListData()
  {
    LogUtils.d("hippylistview", "setListData");
    this.mListAdapter.notifyDataSetChanged();
    dispatchLayout();
  }
  
  public void setMomentumScrollBeginEventEnable(boolean paramBoolean)
  {
    this.mMomentumScrollBeginEventEnable = paramBoolean;
  }
  
  public void setMomentumScrollEndEventEnable(boolean paramBoolean)
  {
    this.mMomentumScrollEndEventEnable = paramBoolean;
  }
  
  public void setOnScrollEventEnable(boolean paramBoolean)
  {
    this.mScrollEventEnable = paramBoolean;
  }
  
  public void setScrollBeginDragEventEnable(boolean paramBoolean)
  {
    this.mScrollBeginDragEventEnable = paramBoolean;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.mScrollEnable = paramBoolean;
  }
  
  public void setScrollEndDragEventEnable(boolean paramBoolean)
  {
    this.mScrollEndDragEventEnable = paramBoolean;
  }
  
  public void setScrollEventThrottle(int paramInt)
  {
    this.mScrollEventThrottle = paramInt;
  }
  
  public boolean shouldStopReleaseGlows(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.mEnableRefresh) || (!paramBoolean1)) {
      return false;
    }
    if (this.mLayout.canScrollHorizontally()) {
      return shouldStopReleaseGlowsForHorizontal();
    }
    return shouldStopReleaseGlowsForVertical();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.HippyListView
 * JD-Core Version:    0.7.0.1
 */