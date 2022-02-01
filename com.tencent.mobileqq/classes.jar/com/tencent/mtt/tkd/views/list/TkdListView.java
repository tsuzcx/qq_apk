package com.tencent.mtt.tkd.views.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.HippyTag;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.list.HippyListView.OnScrollEvent;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.State;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;

public class TkdListView
  extends HippyListView
  implements RecyclerView.OnListScrollListener
{
  public static final String EVENT_TYPE_DRAG_END = "onDragEnd";
  public static final String EVENT_TYPE_SCROLL_END = "onScrollEnd";
  private boolean mIsLoading = false;
  private int mPreloadDistance = 0;
  private Promise mPromise = null;
  protected int mScrollMinOffset = 0;
  
  public TkdListView(Context paramContext)
  {
    super(paramContext);
    addOnListScrollListener(this);
  }
  
  public TkdListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    addOnListScrollListener(this);
  }
  
  public void checkExposureView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView == null) || ((paramView instanceof HippyPullHeaderView)) || ((paramView instanceof HippyPullFooterView))) {
      return;
    }
    if (this.mLayout.canScrollHorizontally())
    {
      paramInt4 = paramView.getLeft();
      if (!this.mLayout.canScrollHorizontally()) {
        break label130;
      }
    }
    Object localObject;
    label130:
    for (int i = paramView.getRight();; i = paramView.getBottom())
    {
      paramInt4 += paramInt3;
      i += paramInt3;
      if (!(paramView instanceof ViewGroup)) {
        break label139;
      }
      localObject = (ViewGroup)paramView;
      int j = ((ViewGroup)localObject).getChildCount();
      paramInt3 = 0;
      while (paramInt3 < j)
      {
        checkExposureView(((ViewGroup)localObject).getChildAt(paramInt3), paramInt1, paramInt2, paramInt4, i);
        paramInt3 += 1;
      }
      paramInt4 = paramView.getTop();
      break;
    }
    label139:
    paramInt3 = HippyTag.getExposureState(paramView);
    if (paramInt3 == -1) {
      paramInt3 = 2;
    }
    for (;;)
    {
      localObject = null;
      if ((paramView instanceof TkdListItemView)) {
        localObject = (TkdListItemView)paramView;
      }
      if (((paramInt4 < paramInt1) && (i > paramInt1)) || ((paramInt4 < paramInt2) && (i > paramInt2)))
      {
        if (paramInt3 == 1)
        {
          sendExposureEvent(paramView, "onDidDisappear");
          sendExposureEvent(paramView, "onWillAppear");
          HippyTag.setExposureState(paramView, 0);
          return;
        }
        if (paramInt3 != 2) {
          break;
        }
        sendExposureEvent(paramView, "onWillAppear");
        HippyTag.setExposureState(paramView, 0);
        return;
      }
      if ((i <= paramInt1) || (paramInt4 >= paramInt2 - 1))
      {
        if (paramInt3 == 0)
        {
          sendExposureEvent(paramView, "onDidAppear");
          sendExposureEvent(paramView, "onDidDisappear");
          HippyTag.setExposureState(paramView, 2);
          return;
        }
        if (paramInt3 == 1)
        {
          sendExposureEvent(paramView, "onDidDisappear");
          HippyTag.setExposureState(paramView, 2);
          return;
        }
        if ((localObject == null) || (((TkdListItemView)localObject).getExposureState() == 3)) {
          break;
        }
        sendExposureEvent(paramView, "onDisAppear");
        ((TkdListItemView)localObject).setExposureState(3);
        return;
      }
      if (((paramInt4 < paramInt1) || (i > paramInt2)) && ((paramInt4 > paramInt1) || (i <= paramInt2))) {
        break;
      }
      if (paramInt3 == 0)
      {
        sendExposureEvent(paramView, "onDidAppear");
        HippyTag.setExposureState(paramView, 1);
        return;
      }
      if (paramInt3 == 2)
      {
        sendExposureEvent(paramView, "onWillAppear");
        sendExposureEvent(paramView, "onDidAppear");
        HippyTag.setExposureState(paramView, 1);
        return;
      }
      if ((localObject == null) || (((TkdListItemView)localObject).getExposureState() == 1)) {
        break;
      }
      sendExposureEvent(paramView, "onAppear");
      ((TkdListItemView)localObject).setExposureState(1);
      return;
    }
  }
  
  public HippyListAdapter createAdapter(RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    return new TkdListViewAdapter(paramRecyclerView, paramHippyEngineContext);
  }
  
  public HippyMap generateScrollEvent()
  {
    HippyMap localHippyMap1 = new HippyMap();
    HippyMap localHippyMap2 = new HippyMap();
    HippyMap localHippyMap3 = new HippyMap();
    if (this.mLayout.canScrollHorizontally())
    {
      localHippyMap1.pushInt("x", (int)PixelUtil.px2dp(this.mOffsetX - this.mState.mCustomHeaderWidth));
      localHippyMap1.pushInt("y", (int)PixelUtil.px2dp(0.0F));
      localHippyMap2.pushInt("width", (int)PixelUtil.px2dp(this.mState.mTotalHeight));
      localHippyMap2.pushInt("height", (int)PixelUtil.px2dp(getHeight()));
      localHippyMap3.pushInt("x", (int)PixelUtil.px2dp(getX()));
      localHippyMap3.pushInt("y", (int)PixelUtil.px2dp(getY()));
      localHippyMap3.pushInt("width", (int)PixelUtil.px2dp(getWidth()));
      localHippyMap3.pushInt("height", (int)PixelUtil.px2dp(getHeight()));
    }
    for (;;)
    {
      HippyMap localHippyMap4 = new HippyMap();
      localHippyMap4.pushMap("contentOffset", localHippyMap1);
      localHippyMap4.pushMap("contentSize", localHippyMap2);
      localHippyMap4.pushMap("frame", localHippyMap3);
      return localHippyMap4;
      localHippyMap1.pushInt("x", (int)PixelUtil.px2dp(0.0F));
      localHippyMap1.pushInt("y", (int)PixelUtil.px2dp(this.mOffsetY - this.mState.mCustomHeaderHeight));
      localHippyMap2.pushInt("width", (int)PixelUtil.px2dp(getWidth()));
      localHippyMap2.pushInt("height", (int)PixelUtil.px2dp(this.mState.mTotalHeight));
      localHippyMap3.pushInt("x", (int)PixelUtil.px2dp(getX()));
      localHippyMap3.pushInt("y", (int)PixelUtil.px2dp(getY()));
      localHippyMap3.pushInt("width", (int)PixelUtil.px2dp(getWidth()));
      localHippyMap3.pushInt("height", (int)PixelUtil.px2dp(getHeight()));
    }
  }
  
  public boolean isLoading()
  {
    return this.mIsLoading;
  }
  
  public void onDragEnd()
  {
    new HippyListView.OnScrollEvent(this, "onDragEnd").send(this, null);
  }
  
  public void onScroll(int paramInt1, int paramInt2) {}
  
  public void onScrollEnd()
  {
    new HippyListView.OnScrollEvent(this, "onScrollEnd").send(this, null);
    if (this.mPromise != null)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("msg", "on scroll end!");
      this.mPromise.resolve(localHippyMap);
      this.mPromise = null;
    }
  }
  
  public void onScrolled(int paramInt1, int paramInt2)
  {
    super.onScrolled(paramInt1, paramInt2);
    this.mAdapter.notifyEndReached();
  }
  
  public void onStartDrag() {}
  
  public void onStartFling() {}
  
  public void scrollWithDistance(int paramInt1, int paramInt2, Promise paramPromise)
  {
    if (!this.mState.didStructureChange())
    {
      if (!this.mLayout.canScrollHorizontally()) {
        break label37;
      }
      this.mViewFlinger.smoothScrollBy(paramInt1, 0, paramInt2, true);
    }
    for (;;)
    {
      this.mPromise = paramPromise;
      return;
      label37:
      this.mViewFlinger.smoothScrollBy(0, paramInt1, paramInt2, true);
    }
  }
  
  public void sendExposureEvent(View paramView, String paramString)
  {
    super.sendExposureEvent(paramView, paramString);
    if (HippyTag.isContainTheSpecKey(paramView, paramString)) {
      new HippyViewEvent(paramString).send(paramView, null);
    }
  }
  
  public void sendOnScrollEvent()
  {
    long l;
    if (this.mScrollEventEnable)
    {
      l = System.currentTimeMillis();
      if (this.mScrollMinOffset <= 0) {
        break label144;
      }
      if (!this.mLayout.canScrollHorizontally()) {
        break label86;
      }
      if (this.mLastOffsetX == -2147483648) {
        this.mLastOffsetX = this.mState.mCustomHeaderWidth;
      }
      if (this.mOffsetX - this.mLastOffsetX >= this.mScrollMinOffset)
      {
        this.mLastOffsetX = this.mOffsetX;
        getOnScrollEvent().send(this, generateScrollEvent());
      }
    }
    label86:
    while ((this.mScrollMinOffset != 0) || (l - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle))
    {
      do
      {
        return;
        if (this.mLastOffsetY == -2147483648) {
          this.mLastOffsetY = this.mState.mCustomHeaderHeight;
        }
      } while (this.mOffsetY - this.mLastOffsetY < this.mScrollMinOffset);
      this.mLastOffsetY = this.mOffsetY;
      getOnScrollEvent().send(this, generateScrollEvent());
      return;
    }
    label144:
    this.mLastScrollEventTimeStamp = l;
    getOnScrollEvent().send(this, generateScrollEvent());
  }
  
  public void setIsLoading(boolean paramBoolean)
  {
    this.mIsLoading = paramBoolean;
  }
  
  public void setPreloadDistance(int paramInt)
  {
    this.mPreloadDistance = ((int)PixelUtil.dp2px(Math.max(0, paramInt)));
  }
  
  public void setScrollMinOffset(int paramInt)
  {
    this.mScrollMinOffset = ((int)PixelUtil.dp2px(Math.max(200, paramInt)));
  }
  
  public boolean shouldEmitEndReachedEvent()
  {
    if (this.mLayout.canScrollHorizontally())
    {
      if (this.mState.mTotalHeight - this.mOffsetX - getWidth() > this.mPreloadDistance) {}
    }
    else {
      while (this.mState.mTotalHeight - this.mOffsetY - getHeight() <= this.mPreloadDistance) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.list.TkdListView
 * JD-Core Version:    0.7.0.1
 */