package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;

public class XRecyclerView
  extends AbsPullToRefreshView2
  implements LoadingMoreHelper.OnLoadMoreListener, PullToRefreshListener
{
  private int jdField_a_of_type_Int = 0;
  private LoadingMoreHelper jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper;
  protected RecyclerViewWithHeaderFooter a;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  private XRecyclerView.RefreshCallback jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new XRecyclerView.1(this);
  private int b = 0;
  private int c = 0;
  
  public XRecyclerView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    a(this);
    LayoutInflater.from(getContext()).inflate(2131563262, this, true);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = ((RecyclerViewWithHeaderFooter)findViewById(2131374768));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper = new LoadingMoreHelper(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper.a(true);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper.a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.addOnScrollListener(new XRecyclerView.2(this));
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a();
  }
  
  protected View a()
  {
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839540));
    return localView;
  }
  
  public LoadingMoreHelper a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper;
  }
  
  public RecyclerViewWithHeaderFooter a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && (paramView == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(100, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && (paramView == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(paramInt, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(paramBoolean, "");
    }
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback.a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XRecyclerView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean2);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper.a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshLoadingMoreHelper.a(paramBoolean2);
  }
  
  @TargetApi(14)
  protected boolean a()
  {
    return !this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.canScrollVertically(-1);
  }
  
  public boolean a(View paramView)
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_JavaLangThreadLocal.get()).booleanValue();
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(false));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && (paramView == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(bool);
      if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback != null) {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback.a(this, bool);
      }
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback.a(this, 0);
    }
    return true;
  }
  
  protected View b()
  {
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(true));
    a(1);
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @TargetApi(14)
  protected boolean b()
  {
    return !this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.canScrollVertically(1);
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.stopScroll();
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.scrollToPosition(0);
  }
  
  public void setRefreshCallback(XRecyclerView.RefreshCallback paramRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback = paramRefreshCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */