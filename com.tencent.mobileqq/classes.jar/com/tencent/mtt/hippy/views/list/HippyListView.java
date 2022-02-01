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
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
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
  protected final boolean mEnableRefresh = true;
  protected boolean mExposureEventEnable = false;
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
      int i;
      if (this.mLayout.canScrollHorizontally()) {
        i = this.mState.mCustomHeaderWidth;
      } else {
        i = this.mState.mCustomHeaderHeight;
      }
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
  
  private HippyMap getItemViewProps(int paramInt)
  {
    Object localObject = this.mHippyContext;
    if (localObject == null) {
      return null;
    }
    localObject = ((HippyEngineContext)localObject).getRenderManager().getRenderNode(paramInt);
    if (localObject == null) {
      return null;
    }
    return ((RenderNode)localObject).getProps();
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
    setRepeatableSuspensionMode(false);
    this.mListAdapter = createAdapter(this, this.mHippyContext);
    setAdapter(this.mListAdapter);
  }
  
  private boolean shouldStopReleaseGlowsForHorizontal(boolean paramBoolean)
  {
    int i = this.mAdapter.getTotalHeight();
    if ((this.mOffsetX > 0) && (getWidth() <= i - this.mState.mCustomHeaderWidth))
    {
      int j = i - getWidth() + this.mState.mCustomFooterWidth;
      if ((i - this.mState.mCustomHeaderWidth < getWidth()) || (this.mOffsetX >= j))
      {
        if (this.mFooterRefreshState == 0)
        {
          sendPullFooterEvent("onFooterReleased", new HippyMap());
          this.mFooterRefreshState = 1;
        }
        View localView = getCustomFooterView();
        if (((localView instanceof HippyPullFooterView)) && (((HippyPullFooterView)localView).getStickEnabled()))
        {
          smoothScrollBy(j - this.mOffsetX, 0, false, true);
          return true;
        }
      }
      return false;
    }
    if ((this.mHeaderRefreshState == 0) && (paramBoolean))
    {
      sendPullHeaderEvent("onHeaderReleased", new HippyMap());
      this.mHeaderRefreshState = 1;
    }
    if (this.mOffsetX < 0) {
      smoothScrollBy(-this.mOffsetX, 0, false, true);
    }
    return true;
  }
  
  private boolean shouldStopReleaseGlowsForVertical(boolean paramBoolean)
  {
    int i = this.mAdapter.getTotalHeight();
    if ((getOffsetY() > 0) && (getHeight() <= i - this.mState.mCustomHeaderHeight))
    {
      int j = i - getHeight() + this.mState.mCustomFooterHeight;
      if ((i - this.mState.mCustomHeaderHeight < getHeight()) || (getOffsetY() >= j))
      {
        if (this.mFooterRefreshState == 0)
        {
          sendPullFooterEvent("onFooterReleased", new HippyMap());
          this.mFooterRefreshState = 1;
        }
        View localView = getCustomFooterView();
        if (((localView instanceof HippyPullFooterView)) && (((HippyPullFooterView)localView).getStickEnabled()))
        {
          smoothScrollBy(0, j - this.mOffsetY, false, true);
          return true;
        }
      }
      return false;
    }
    if ((this.mHeaderRefreshState == 0) && (paramBoolean))
    {
      sendPullHeaderEvent("onHeaderReleased", new HippyMap());
      this.mHeaderRefreshState = 1;
    }
    if (getOffsetY() < 0) {
      smoothScrollBy(0, -this.mOffsetY, false, true);
    }
    return true;
  }
  
  protected void checkExposureView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!(paramView instanceof HippyListItemView)) {
      return;
    }
    if (this.mLayout.canScrollHorizontally()) {
      paramInt4 = paramView.getLeft();
    } else {
      paramInt4 = paramView.getTop();
    }
    int i;
    if (this.mLayout.canScrollHorizontally()) {
      i = paramView.getRight();
    } else {
      i = paramView.getBottom();
    }
    paramInt4 += paramInt3;
    i += paramInt3;
    HippyListItemView localHippyListItemView = (HippyListItemView)paramView;
    HippyMap localHippyMap = getItemViewProps(localHippyListItemView.getId());
    if (localHippyMap == null) {
      return;
    }
    int j = localHippyListItemView.getExposureState();
    if (this.mLayout.canScrollHorizontally()) {
      paramInt3 = paramView.getWidth();
    } else {
      paramInt3 = paramView.getHeight();
    }
    paramInt3 = (int)Math.ceil(paramInt3 * 0.1F);
    if ((i > paramInt1 + paramInt3) && (paramInt4 < paramInt2 - paramInt3))
    {
      if (((paramInt4 < paramInt1) && (i > paramInt1)) || ((paramInt4 < paramInt2) && (i > paramInt2)))
      {
        if (j == 1) {
          sendExposureEvent(paramView, "onWillDisappear", localHippyMap);
        }
        for (paramInt1 = 3;; paramInt1 = 0)
        {
          localHippyListItemView.setExposureState(paramInt1);
          return;
          if (j != 2) {
            break;
          }
          sendExposureEvent(paramView, "onWillAppear", localHippyMap);
        }
      }
      if (((paramInt4 >= paramInt1) && (i <= paramInt2)) || ((paramInt4 <= paramInt1) && (i > paramInt2) && (localHippyListItemView.getExposureState() != 1)))
      {
        if (localHippyListItemView.getExposureState() == 2) {
          sendExposureEvent(paramView, "onWillAppear", localHippyMap);
        }
        sendExposureEvent(paramView, "onAppear", localHippyMap);
        localHippyListItemView.setExposureState(1);
      }
    }
    else if (localHippyListItemView.getExposureState() != 2)
    {
      if (localHippyListItemView.getExposureState() == 1) {
        sendExposureEvent(paramView, "onWillDisappear", localHippyMap);
      }
      sendExposureEvent(paramView, "onDisAppear", localHippyMap);
      localHippyListItemView.setExposureState(2);
    }
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
  
  protected void onAttachedToWindow()
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
  
  protected void onDetachedFromWindow()
  {
    ViewTreeObserver.OnPreDrawListener localOnPreDrawListener = this.mPreDrawListener;
    if (localOnPreDrawListener != null)
    {
      ViewTreeObserver localViewTreeObserver = this.mViewTreeObserver;
      if (localViewTreeObserver != null) {
        localViewTreeObserver.removeOnPreDrawListener(localOnPreDrawListener);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public void onFooterRefreshFinish()
  {
    if (this.mFooterRefreshState == 1)
    {
      int i;
      if (this.mLayout.canScrollHorizontally())
      {
        i = getTotalHeight() - getWidth();
        if (this.mOffsetX > i) {
          smoothScrollBy(i - this.mOffsetX, 0, false, true);
        }
      }
      else
      {
        i = getTotalHeight() - getHeight();
        if (this.mOffsetY > i) {
          smoothScrollBy(0, i - this.mOffsetY, false, true);
        }
      }
      this.mFooterRefreshState = 0;
    }
  }
  
  public void onHeaderRefresh()
  {
    if (this.mHeaderRefreshState == 0)
    {
      if (this.mLayout.canScrollHorizontally())
      {
        smoothScrollBy(-this.mOffsetX, 0, false, true);
        return;
      }
      smoothScrollBy(0, -this.mOffsetY, false, true);
    }
  }
  
  public void onHeaderRefreshFinish()
  {
    if (this.mHeaderRefreshState == 1)
    {
      if (this.mLayout.canScrollHorizontally())
      {
        if (this.mOffsetX < this.mState.mCustomHeaderWidth) {
          smoothScrollBy(-this.mOffsetX + this.mState.mCustomHeaderWidth, 0, false, true);
        }
      }
      else if (this.mOffsetY < this.mState.mCustomHeaderHeight) {
        smoothScrollBy(0, -this.mOffsetY + this.mState.mCustomHeaderHeight, false, true);
      }
      this.mHeaderRefreshState = 0;
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.mExposureEventEnable)) {
      dispatchExposureEvent();
    }
  }
  
  protected void onScrollDragEnded()
  {
    if (this.mScrollEndDragEventEnable) {
      getOnScrollDragEndedEvent().send(this, generateScrollEvent());
    }
  }
  
  protected void onScrollDragStarted()
  {
    if (this.mScrollBeginDragEventEnable) {
      getOnScrollDragStartedEvent().send(this, generateScrollEvent());
    }
  }
  
  protected void onScrollFlingEnded()
  {
    if (this.mMomentumScrollEndEventEnable) {
      getOnScrollFlingEndedEvent().send(this, generateScrollEvent());
    }
  }
  
  protected void onScrollFlingStarted()
  {
    if (this.mMomentumScrollBeginEventEnable) {
      getOnScrollFlingStartedEvent().send(this, generateScrollEvent());
    }
  }
  
  public void onScrolled(int paramInt1, int paramInt2)
  {
    super.onScrolled(paramInt1, paramInt2);
    sendOnScrollEvent();
    if (this.mExposureEventEnable) {
      dispatchExposureEvent();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnable) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void onTouchMove(int paramInt1, int paramInt2)
  {
    paramInt1 = this.mAdapter.getTotalHeight();
    HippyMap localHippyMap = new HippyMap();
    if (this.mLayout.canScrollHorizontally())
    {
      if (this.mOffsetX < this.mState.mCustomHeaderWidth)
      {
        paramInt2 = this.mOffsetX;
        paramInt1 = this.mState.mCustomHeaderWidth;
      }
      else
      {
        if (this.mOffsetX <= paramInt1 - getWidth()) {
          break label167;
        }
        paramInt1 = this.mOffsetX - paramInt1;
        paramInt2 = getWidth();
        break label152;
      }
    }
    else
    {
      if (getOffsetY() >= this.mState.mCustomHeaderHeight) {
        break label127;
      }
      paramInt2 = getOffsetY();
      paramInt1 = this.mState.mCustomHeaderHeight;
    }
    float f = Math.abs(paramInt2 - paramInt1);
    String str = "onHeaderPulling";
    break label174;
    label127:
    if (getOffsetY() > paramInt1 - getHeight())
    {
      paramInt1 = getOffsetY() - paramInt1;
      paramInt2 = getHeight();
      f = Math.abs(paramInt1 - paramInt2);
      str = "onFooterPulling";
    }
    else
    {
      f = 0.0F;
      str = "";
    }
    label152:
    label167:
    label174:
    localHippyMap.pushDouble("contentOffset", PixelUtil.px2dp(f));
    paramInt1 = -1;
    paramInt2 = str.hashCode();
    if (paramInt2 != -390145597)
    {
      if ((paramInt2 == 263952529) && (str.equals("onHeaderPulling"))) {
        paramInt1 = 0;
      }
    }
    else if (str.equals("onFooterPulling")) {
      paramInt1 = 1;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return;
      }
      sendPullFooterEvent(str, localHippyMap);
      return;
    }
    sendPullHeaderEvent(str, localHippyMap);
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
      }
      else {
        smoothScrollBy(0, i);
      }
    }
    else
    {
      scrollBy(0, i - getOffsetY());
      post(new HippyListView.3(this));
    }
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
      }
      else {
        smoothScrollBy(0, paramInt1);
      }
    }
    else
    {
      scrollToPosition(paramInt2, 0);
      post(new HippyListView.2(this));
    }
  }
  
  protected void sendExposureEvent(View paramView, String paramString, HippyMap paramHippyMap)
  {
    if (paramHippyMap.containsKey(paramString)) {
      new HippyViewEvent(paramString).send(paramView, null);
    }
  }
  
  protected void sendOnScrollEvent()
  {
    if (this.mScrollEventEnable)
    {
      long l = System.currentTimeMillis();
      if (l - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle) {
        return;
      }
      this.mLastScrollEventTimeStamp = l;
      getOnScrollEvent().send(this, generateScrollEvent());
    }
  }
  
  protected void sendPullFooterEvent(String paramString, HippyMap paramHippyMap)
  {
    paramString = new HippyListView.PullElementEvent(this, paramString);
    View localView = getCustomFooterView();
    if ((localView instanceof HippyPullFooterView)) {
      paramString.send(localView, paramHippyMap);
    }
  }
  
  protected void sendPullHeaderEvent(String paramString, HippyMap paramHippyMap)
  {
    paramString = new HippyListView.PullElementEvent(this, paramString);
    View localView = getCustomHeaderView();
    if ((localView instanceof HippyPullHeaderView)) {
      paramString.send(localView, paramHippyMap);
    }
  }
  
  public void setExposureEventEnable(boolean paramBoolean)
  {
    this.mExposureEventEnable = paramBoolean;
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.mGestureDispatcher = paramNativeGestureDispatcher;
  }
  
  public void setListData()
  {
    LogUtils.d("hippylistview", "setListData");
    this.mListAdapter.notifyDataSetChanged();
    int i = getChildCount();
    dispatchLayout();
    int j = getChildCount();
    if ((i == 0) && (j > i) && (this.mExposureEventEnable)) {
      dispatchExposureEvent();
    }
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
  
  protected boolean shouldStopReleaseGlows(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      return false;
    }
    if (this.mLayout.canScrollHorizontally()) {
      return shouldStopReleaseGlowsForHorizontal(paramBoolean2);
    }
    return shouldStopReleaseGlowsForVertical(paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.HippyListView
 * JD-Core Version:    0.7.0.1
 */