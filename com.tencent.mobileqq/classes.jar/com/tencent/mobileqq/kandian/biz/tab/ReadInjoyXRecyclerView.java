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
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshAnimFactory;
import com.tencent.mobileqq.qroute.QRoute;
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
  public static int b = 1001;
  private Handler jdField_a_of_type_AndroidOsHandler = new ReadInjoyXRecyclerView.1(this, Looper.getMainLooper());
  protected RecyclerViewWithHeaderFooterFix a;
  private ReadInJoyAnimBaseManager jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager;
  private ReadInjoyXRecyclerView.RefreshCallback jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView$RefreshCallback;
  private LoadingMoreHelper jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new ReadInjoyXRecyclerView.2(this);
  private int c = 0;
  private int d = 0;
  private int e;
  public boolean e;
  
  public ReadInjoyXRecyclerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    f();
  }
  
  public ReadInjoyXRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    f();
  }
  
  public ReadInjoyXRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    f();
  }
  
  private ReadInJoyAnimBaseManager a()
  {
    return a(0);
  }
  
  private ReadInJoyAnimBaseManager a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAnimType animType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("XRecyclerView", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager;
    if ((localObject != null) && ((localObject instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoyAnimBaseManager)localObject).onDestroy();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager = ((ReadInJoyAnimBaseManager)((IReadInJoyRefreshAnimFactory)QRoute.api(IReadInJoyRefreshAnimFactory.class)).getAnimManger(getContext(), paramInt));
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager;
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
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(b);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(b, 1500L);
  }
  
  private void f()
  {
    a();
    a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix = new ReadInjoyXRecyclerView.3(this, getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper = new LoadingMoreHelper(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper.setLoadMoreEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper.setOnLoadMoreListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix.addOnScrollListener(new ReadInjoyXRecyclerView.4(this));
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager.getPullRefreshAreaHeight();
  }
  
  protected View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager.getRefreshView(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839396));
    return localView;
  }
  
  public RecyclerViewWithHeaderFooterFix a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix;
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = (paramBoolean ^ true);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager != null)
    {
      e();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager.showRefreshResult(paramBoolean, paramString);
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
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper.setLoadMoreComplete(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper.setLoadMoreEnabled(paramBoolean2);
  }
  
  @TargetApi(14)
  protected boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix.canScrollVertically(-1) ^ true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix.getLayoutManager();
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
  
  protected View b()
  {
    return null;
  }
  
  public void b()
  {
    ReadInJoyAnimBaseManager localReadInJoyAnimBaseManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager;
    if (localReadInJoyAnimBaseManager != null) {
      localReadInJoyAnimBaseManager.endOfRefresh();
    }
    b(true);
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    ReadInjoyXRecyclerView.RefreshCallback localRefreshCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView$RefreshCallback;
    if (localRefreshCallback != null) {
      localRefreshCallback.n();
    }
  }
  
  @TargetApi(14)
  protected boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix.canScrollVertically(1) ^ true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(true));
    a(1);
  }
  
  protected void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix.stopScroll();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRecyclerViewWithHeaderFooterFix.scrollToPosition(0);
  }
  
  public boolean onLoadMore(boolean paramBoolean)
  {
    ReadInjoyXRecyclerView.RefreshCallback localRefreshCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView$RefreshCallback;
    if (localRefreshCallback != null) {
      localRefreshCallback.a(this, 0);
    }
    return true;
  }
  
  public void onLoadMoreComplete() {}
  
  public void onNotCompleteVisable(View paramView, int paramInt)
  {
    ReadInJoyAnimBaseManager localReadInJoyAnimBaseManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager;
    if ((localReadInJoyAnimBaseManager != null) && (paramView == localReadInJoyAnimBaseManager.getRefreshView(this))) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager.onPullRefreshing(paramInt, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void onRefreshCompleted(View paramView, boolean paramBoolean) {}
  
  public void onViewCompleteVisable(View paramView)
  {
    ReadInJoyAnimBaseManager localReadInJoyAnimBaseManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager;
    if ((localReadInJoyAnimBaseManager != null) && (paramView == localReadInJoyAnimBaseManager.getRefreshView(this))) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager.onPullRefreshing(100, this.jdField_a_of_type_Boolean);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(View paramView)
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_JavaLangThreadLocal.get()).booleanValue();
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(false));
    ReadInJoyAnimBaseManager localReadInJoyAnimBaseManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager;
    if ((localReadInJoyAnimBaseManager != null) && (paramView == localReadInJoyAnimBaseManager.getRefreshView(this)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPullrefreshReadInJoyAnimBaseManager.onPullRefreshComplete(bool);
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView$RefreshCallback;
      if (paramView != null) {
        paramView.a(this, bool);
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(View paramView) {}
  
  public void setRefreshCallback(ReadInjoyXRecyclerView.RefreshCallback paramRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView$RefreshCallback = paramRefreshCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView
 * JD-Core Version:    0.7.0.1
 */