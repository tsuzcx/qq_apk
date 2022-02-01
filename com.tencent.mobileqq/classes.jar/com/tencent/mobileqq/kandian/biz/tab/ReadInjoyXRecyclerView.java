package com.tencent.mobileqq.kandian.biz.tab;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.kandian.base.view.widget.AbsPullToRefreshViewFix;
import com.tencent.mobileqq.kandian.base.view.widget.RecyclerViewWithHeaderFooterFix;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshAnimFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;

public class ReadInjoyXRecyclerView
  extends AbsPullToRefreshViewFix
  implements LoadingMoreHelper.OnLoadMoreListener, PullToRefreshListener
{
  public static int i = 1001;
  private ReadInJoyAnimBaseManager h;
  public boolean j = true;
  protected RecyclerViewWithHeaderFooterFix k;
  private Handler l = new ReadInjoyXRecyclerView.1(this, Looper.getMainLooper());
  private ReadInjoyXRecyclerView.RefreshCallback m;
  private LoadingMoreHelper n;
  private XLoadMoreLayout o;
  private int p = 0;
  private int q = 0;
  private int r = 0;
  private ThreadLocal<Boolean> s = new ReadInjoyXRecyclerView.2(this);
  
  public ReadInjoyXRecyclerView(Context paramContext)
  {
    super(paramContext);
    l();
  }
  
  public ReadInjoyXRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    l();
  }
  
  public ReadInjoyXRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    l();
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof ReadInjoyXRecyclerView.ScrollableHeader)) {
      return ((ReadInjoyXRecyclerView.ScrollableHeader)paramView).a(paramMotionEvent);
    }
    if ((paramView instanceof HorizontalListView))
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      return localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  private ReadInJoyAnimBaseManager b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAnimType animType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("XRecyclerView", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if ((localObject != null) && ((localObject instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoyAnimBaseManager)localObject).onDestroy();
    }
    this.h = ReadInJoyRefreshAnimFactory.INSTANCE.getAnimManger(getContext(), paramInt);
    return this.h;
  }
  
  private ReadInJoyAnimBaseManager j()
  {
    return b(0);
  }
  
  private void k()
  {
    this.l.removeMessages(i);
    this.l.sendEmptyMessageDelayed(i, 1500L);
  }
  
  private void l()
  {
    j();
    setPullToRefreshListener(this);
    this.o = new XLoadMoreLayout(getContext());
    this.k = new ReadInjoyXRecyclerView.3(this, getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.k, localLayoutParams);
    this.n = new LoadingMoreHelper(this.o, getContext());
    this.n.setLoadMoreEnabled(true);
    this.n.setOnLoadMoreListener(this);
    this.k.b(this.o);
    this.k.addOnScrollListener(new ReadInjoyXRecyclerView.4(this));
  }
  
  protected int a()
  {
    return this.h.getPullRefreshAreaHeight();
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ReadInjoyXRecyclerView.RefreshCallback localRefreshCallback = this.m;
    if (localRefreshCallback != null) {
      localRefreshCallback.q();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.h != null)
    {
      k();
      this.h.showRefreshResult(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMoreComplete(): hasMoreData=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("XRecyclerView", 2, localStringBuilder.toString());
    }
    this.n.setLoadMoreComplete(paramBoolean1, paramBoolean2);
    this.n.setLoadMoreEnabled(paramBoolean2);
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.k.getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      localObject = (StaggeredGridLayoutManager)localObject;
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)localObject).findFirstVisibleItemPositions(arrayOfInt);
      return a(((StaggeredGridLayoutManager)localObject).findViewByPosition(arrayOfInt[0]), paramMotionEvent);
    }
    if ((localObject instanceof LinearLayoutManager))
    {
      localObject = (LinearLayoutManager)localObject;
      return a(((LinearLayoutManager)localObject).findViewByPosition(((LinearLayoutManager)localObject).findFirstVisibleItemPosition()), paramMotionEvent);
    }
    return false;
  }
  
  protected void b(boolean paramBoolean)
  {
    this.k.a = paramBoolean;
  }
  
  protected View c()
  {
    View localView = this.h.getRefreshView(this);
    if ((this.h instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839580));
    return localView;
  }
  
  protected View d()
  {
    return null;
  }
  
  @TargetApi(14)
  protected boolean e()
  {
    return this.k.canScrollVertically(-1) ^ true;
  }
  
  @TargetApi(14)
  protected boolean f()
  {
    return this.k.canScrollVertically(1) ^ true;
  }
  
  public void g()
  {
    ReadInJoyAnimBaseManager localReadInJoyAnimBaseManager = this.h;
    if (localReadInJoyAnimBaseManager != null) {
      localReadInJoyAnimBaseManager.endOfRefresh();
    }
    a(true);
  }
  
  public LoadingMoreHelper getLoadMoreLayoutHelper()
  {
    return this.n;
  }
  
  public RecyclerViewWithHeaderFooterFix getRecyclerView()
  {
    return this.k;
  }
  
  public int getScrollPositionX()
  {
    return this.q;
  }
  
  public int getScrollPositionY()
  {
    return this.r;
  }
  
  public void h()
  {
    this.s.set(Boolean.valueOf(true));
    a(1);
  }
  
  public void i()
  {
    this.k.stopScroll();
    this.k.scrollToPosition(0);
  }
  
  public boolean onLoadMore(boolean paramBoolean)
  {
    ReadInjoyXRecyclerView.RefreshCallback localRefreshCallback = this.m;
    if (localRefreshCallback != null) {
      localRefreshCallback.a(this, 0);
    }
    return true;
  }
  
  public void onLoadMoreComplete() {}
  
  public void onNotCompleteVisable(View paramView, int paramInt)
  {
    ReadInJoyAnimBaseManager localReadInJoyAnimBaseManager = this.h;
    if ((localReadInJoyAnimBaseManager != null) && (paramView == localReadInJoyAnimBaseManager.getRefreshView(this))) {
      this.h.onPullRefreshing(paramInt, this.a);
    }
  }
  
  public void onRefreshCompleted(View paramView, boolean paramBoolean) {}
  
  public void onViewCompleteVisable(View paramView)
  {
    ReadInJoyAnimBaseManager localReadInJoyAnimBaseManager = this.h;
    if ((localReadInJoyAnimBaseManager != null) && (paramView == localReadInJoyAnimBaseManager.getRefreshView(this))) {
      this.h.onPullRefreshing(100, this.a);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(View paramView)
  {
    boolean bool = ((Boolean)this.s.get()).booleanValue();
    this.s.set(Boolean.valueOf(false));
    ReadInJoyAnimBaseManager localReadInJoyAnimBaseManager = this.h;
    if ((localReadInJoyAnimBaseManager != null) && (paramView == localReadInJoyAnimBaseManager.getRefreshView(this)))
    {
      this.h.onPullRefreshComplete(bool);
      paramView = this.m;
      if (paramView != null) {
        paramView.a(this, bool);
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(View paramView) {}
  
  public void setRefreshCallback(ReadInjoyXRecyclerView.RefreshCallback paramRefreshCallback)
  {
    this.m = paramRefreshCallback;
  }
  
  protected void setVerticalScrollDisable(boolean paramBoolean)
  {
    this.j = (paramBoolean ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView
 * JD-Core Version:    0.7.0.1
 */