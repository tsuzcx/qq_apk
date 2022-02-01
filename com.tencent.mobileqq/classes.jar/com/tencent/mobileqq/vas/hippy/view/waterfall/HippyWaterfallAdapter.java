package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.ViewHolderWrapper;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder;
import com.tencent.mtt.supportui.views.recyclerview.Scroller;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class HippyWaterfallAdapter
  extends HippyListAdapter
{
  protected boolean a;
  private final HippyWaterfallView b;
  private final HippyEngineContext c;
  private HippyViewEvent d;
  private HippyViewEvent e;
  private HippyViewEvent f;
  private HippyViewEvent g;
  private int h;
  private boolean i;
  private int j;
  private boolean k;
  private boolean l;
  private HippyMap m;
  private HippyMap n;
  private RecyclerView.OnListScrollListener o;
  private int p;
  
  public HippyWaterfallAdapter(HippyWaterfallView paramHippyWaterfallView, RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    super(paramRecyclerView, paramHippyEngineContext);
    this.b = paramHippyWaterfallView;
    this.c = paramHippyEngineContext;
    setLoadingStatus(1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, HippyArray paramHippyArray)
  {
    if (this.m == null) {
      this.m = new HippyMap();
    }
    this.m.clear();
    this.m.pushInt("startEdgePos", paramInt1);
    this.m.pushInt("endEdgePos", paramInt2);
    this.m.pushInt("firstVisibleRowIndex", paramInt3);
    this.m.pushInt("lastVisibleRowIndex", paramInt4);
    this.m.pushInt("scrollState", paramInt5);
    this.m.pushArray("visibleRowFrames", paramHippyArray);
    f().send(this.mParentRecyclerView, this.m);
  }
  
  private HippyViewEvent d()
  {
    if (this.e == null) {
      this.e = new HippyWaterfallAdapter.HippyWaterfallEvent("onFooterAppeared");
    }
    return this.e;
  }
  
  private HippyViewEvent e()
  {
    if (this.f == null) {
      this.f = new HippyWaterfallAdapter.HippyWaterfallEvent("onRefresh");
    }
    return this.f;
  }
  
  private HippyViewEvent f()
  {
    if (this.g == null) {
      this.g = new HippyWaterfallAdapter.HippyWaterfallEvent("onScrollForReport");
    }
    return this.g;
  }
  
  protected void a()
  {
    if (!this.k) {
      return;
    }
    int i3 = (int)PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
    int i4 = (int)PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
    int i2 = ((HippyWaterfallLayoutManager)this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int i5 = ((HippyWaterfallLayoutManager)this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    if (this.mParentRecyclerView.mViewFlinger.getScroller() == null) {
      return;
    }
    float f1 = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
    int i6 = this.mParentRecyclerView.getScrollState();
    HippyArray localHippyArray = new HippyArray();
    int i1 = i2;
    while (i1 <= i5)
    {
      View localView = this.mParentRecyclerView.getLayoutManager().findViewByPosition(i1);
      if (localView != null)
      {
        HippyMap localHippyMap = new HippyMap();
        localHippyMap.pushInt("x", localView.getLeft());
        localHippyMap.pushInt("y", localView.getTop() + this.b.mOffsetY);
        localHippyMap.pushInt("width", (int)PixelUtil.px2dp(getItemWidth(i1)));
        localHippyMap.pushInt("height", (int)PixelUtil.px2dp(getItemHeight(i1)));
        localHippyArray.pushMap(localHippyMap);
      }
      i1 += 1;
    }
    a(i3, i4, i2, i5, f1, i6, localHippyArray);
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (!this.l) {
      return;
    }
    HippyWaterfallView.ExposureForReport localExposureForReport = this.b.a(paramInt1, paramInt2);
    if (localExposureForReport == null) {
      return;
    }
    if (a(localExposureForReport.e, paramInt2))
    {
      if (this.n == null) {
        this.n = new HippyMap();
      }
      this.n.clear();
      this.n.pushInt("startEdgePos", localExposureForReport.a);
      this.n.pushInt("endEdgePos", localExposureForReport.b);
      this.n.pushInt("firstVisibleRowIndex", localExposureForReport.c);
      this.n.pushInt("lastVisibleRowIndex", localExposureForReport.d);
      this.n.pushInt("scrollState", localExposureForReport.f);
      this.n.pushArray("visibleRowFrames", localExposureForReport.g);
      localExposureForReport.send(this.mParentRecyclerView, this.n);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, HippyArray paramHippyArray)
  {
    if (((paramInt5 == 0) || (paramInt5 == 1)) && (a(0.0F, paramInt5)))
    {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramHippyArray);
      return;
    }
    if (paramFloat < this.mParentRecyclerView.getHeight() * 2) {
      a(paramFloat, paramInt5);
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (paramInt != 1)
    {
      setLoadingStatus(paramInt);
      if (this.mDefaultLoadingView != null)
      {
        this.mDefaultLoadingView.measure(View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getHeight(), 1073741824));
        this.mDefaultLoadingView.layout(this.mDefaultLoadingView.getLeft(), this.mDefaultLoadingView.getTop(), this.mDefaultLoadingView.getRight(), this.mDefaultLoadingView.getBottom());
        this.mDefaultLoadingView.invalidate();
      }
      this.a = false;
      return;
    }
    setLoadingStatus(paramInt);
  }
  
  public void a(RecyclerView.ViewHolderWrapper paramViewHolderWrapper)
  {
    onViewAbandon(paramViewHolderWrapper);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  protected boolean a(float paramFloat, int paramInt)
  {
    return true;
  }
  
  protected HippyWaterfallView.ExposureForReport b(int paramInt1, int paramInt2)
  {
    if (!this.l) {
      return null;
    }
    if (this.mParentRecyclerView.mViewFlinger.getScroller() == null) {
      return null;
    }
    int i2 = (int)PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
    int i3 = (int)PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
    int i1 = ((HippyWaterfallLayoutManager)this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int i4 = ((HippyWaterfallLayoutManager)this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    HippyArray localHippyArray = new HippyArray();
    paramInt1 = i1;
    while (paramInt1 <= i4)
    {
      View localView = this.mParentRecyclerView.getLayoutManager().findViewByPosition(paramInt1);
      if (localView != null)
      {
        HippyMap localHippyMap = new HippyMap();
        localHippyMap.pushInt("x", localView.getLeft());
        localHippyMap.pushInt("y", localView.getTop() + this.b.mOffsetY);
        localHippyMap.pushInt("width", (int)PixelUtil.px2dp(getItemWidth(paramInt1)));
        localHippyMap.pushInt("height", (int)PixelUtil.px2dp(getItemHeight(paramInt1)));
        localHippyArray.pushMap(localHippyMap);
      }
      paramInt1 += 1;
    }
    float f1 = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
    return new HippyWaterfallView.ExposureForReport(this.mParentRecyclerView.getId(), i2, i3, i1, i4, (int)f1, paramInt2, localHippyArray);
  }
  
  public RecyclerView.OnListScrollListener b()
  {
    if (this.o == null) {
      this.o = new HippyWaterfallAdapter.1(this);
    }
    return this.o;
  }
  
  protected void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public HippyViewEvent c()
  {
    if (this.d == null) {
      this.d = new HippyWaterfallAdapter.HippyWaterfallEvent("onEndReached");
    }
    return this.d;
  }
  
  public int calcPreloadThresholdWithItemNumber()
  {
    if (this.i)
    {
      int i2 = getItemCount() - 1;
      int i3 = getItemCount() - this.h;
      int i1 = i3;
      if (i3 < 0) {
        i1 = 0;
      }
      this.j = 0;
      while (i2 >= i1)
      {
        this.j += getItemHeight(i2);
        i2 -= 1;
      }
      this.i = false;
    }
    return this.j;
  }
  
  public int getHeightBefore(int paramInt)
  {
    return ((HippyWaterfallLayoutManager)this.b.getLayoutManager()).getHeightBefore(paramInt);
  }
  
  public int getItemHeight(int paramInt)
  {
    return super.getItemHeight(paramInt) + ((HippyWaterfallLayoutManager)this.mParentRecyclerView.getLayoutManager()).b();
  }
  
  public int getPreloadThresholdInPixels()
  {
    return this.p;
  }
  
  public View getRecyclerItemView(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = getClass().getSuperclass();
        localObject1.getClass();
        localObject1 = ((Class)localObject1).getDeclaredField("mListViewHolder");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        if (!(localObject1 instanceof ArrayList)) {
          break label104;
        }
        localObject1 = (ArrayList)localObject1;
        if (localObject1 != null)
        {
          if (paramInt < ((ArrayList)localObject1).size()) {
            return ((RecyclerViewBase.ViewHolder)((ArrayList)localObject1).get(paramInt)).mContent;
          }
          localObject1 = this.mParentRecyclerView.getChildAt(paramInt - ((ArrayList)localObject1).size());
          return localObject1;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      return null;
      label104:
      Object localObject2 = null;
    }
  }
  
  public int getTotalHeight()
  {
    this.mContentHeight = ((HippyWaterfallLayoutManager)this.b.getLayoutManager()).getTotalHeight();
    return this.mContentHeight;
  }
  
  public boolean hasCustomRecycler()
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    setPreloadItemNumber(getPreloadThresholdInItemNumber());
    super.notifyDataSetChanged();
  }
  
  public void notifyLastFooterAppeared()
  {
    super.notifyLastFooterAppeared();
    if ((this.mLoadingStatus != 1) && (this.mLoadingStatus != 100) && (this.mLoadingStatus != 6)) {
      setLoadingStatus(1);
    }
    if (!this.a)
    {
      int i1 = getPreloadThresholdInPixels();
      int i2 = getPreloadThresholdInItemNumber();
      if ((i1 > 0) || (i2 > 0)) {
        c().send(this.mParentRecyclerView, null);
      }
    }
    if (this.mLoadingStatus == 1) {
      d().send(this.mParentRecyclerView, null);
    }
  }
  
  public void onPreload()
  {
    this.a = true;
    c().send(this.mParentRecyclerView, null);
  }
  
  public void onSuddenStop()
  {
    a();
  }
  
  protected void setPreloadItemNumber(int paramInt)
  {
    super.setPreloadItemNumber(paramInt);
    this.h = paramInt;
    this.i = true;
  }
  
  public void startRefreshData()
  {
    e().send(this.mParentRecyclerView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallAdapter
 * JD-Core Version:    0.7.0.1
 */