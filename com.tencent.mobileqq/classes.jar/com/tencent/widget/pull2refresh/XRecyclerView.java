package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

public class XRecyclerView
  extends AbsPullToRefreshView2
  implements LoadingMoreHelper.OnLoadMoreListener, PullToRefreshListener
{
  public static final boolean DEBUG = false;
  public static final String TAG = "XRecyclerView";
  private ThreadLocal<Boolean> mIsMachineRefresh = new XRecyclerView.1(this);
  private int mLastScrollState = 0;
  private XLoadMoreLayout mLoadMoreLayout;
  private LoadingMoreHelper mLoadMoreLayoutHelper;
  protected RecyclerViewWithHeaderFooter mRecyclerView;
  private XRecyclerView.RefreshCallback mRefreshCallback;
  private int mScrollX = 0;
  private int mScrollY = 0;
  
  public XRecyclerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setPullToRefreshListener(this);
    LayoutInflater.from(getContext()).inflate(2131629724, this, true);
    this.mLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.mRecyclerView = ((RecyclerViewWithHeaderFooter)findViewById(2131442467));
    this.mLoadMoreLayoutHelper = new LoadingMoreHelper(this.mLoadMoreLayout, getContext());
    this.mLoadMoreLayoutHelper.setLoadMoreEnabled(true);
    this.mLoadMoreLayoutHelper.setOnLoadMoreListener(this);
    this.mRecyclerView.addFooterView(this.mLoadMoreLayout);
    this.mRecyclerView.addOnScrollListener(new XRecyclerView.2(this));
  }
  
  public void backToTopAtOnce()
  {
    this.mRecyclerView.stopScroll();
    this.mRecyclerView.scrollToPosition(0);
  }
  
  protected void clearContentViewClickEvent(boolean paramBoolean)
  {
    this.mRecyclerView.mInterceptTouchEvent = paramBoolean;
  }
  
  protected int configHeaderVisibleHeight()
  {
    return this.mAnimManager.getPullRefreshAreaHeight();
  }
  
  protected View generateFooterView()
  {
    return null;
  }
  
  protected View generateHeaderView()
  {
    View localView = this.mAnimManager.getRefreshView(this);
    if (this.mAnimManager.isSkinAnimManager())
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839580));
    return localView;
  }
  
  public LoadingMoreHelper getLoadMoreLayoutHelper()
  {
    return this.mLoadMoreLayoutHelper;
  }
  
  public RecyclerViewWithHeaderFooter getRecyclerView()
  {
    return this.mRecyclerView;
  }
  
  public int getScrollPositionX()
  {
    return this.mScrollX;
  }
  
  public int getScrollPositionY()
  {
    return this.mScrollY;
  }
  
  @TargetApi(14)
  protected boolean isScroll2Bottom()
  {
    return this.mRecyclerView.canScrollVertically(1) ^ true;
  }
  
  @TargetApi(14)
  protected boolean isScroll2Top()
  {
    return this.mRecyclerView.canScrollVertically(-1) ^ true;
  }
  
  public void loadMoreComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMoreComplete(): hasMoreData=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("XRecyclerView", 2, localStringBuilder.toString());
    }
    this.mLoadMoreLayoutHelper.setLoadMoreComplete(paramBoolean1, paramBoolean2);
    this.mLoadMoreLayoutHelper.setLoadMoreEnabled(paramBoolean2);
  }
  
  public boolean onLoadMore(boolean paramBoolean)
  {
    XRecyclerView.RefreshCallback localRefreshCallback = this.mRefreshCallback;
    if (localRefreshCallback != null) {
      localRefreshCallback.startLoadMore(this, 0);
    }
    return true;
  }
  
  public void onLoadMoreComplete() {}
  
  public void onNotCompleteVisable(View paramView, int paramInt)
  {
    if ((this.mAnimManager != null) && (paramView == this.mAnimManager.getRefreshView(this))) {
      this.mAnimManager.onPullRefreshing(paramInt, this.isRefreshing);
    }
  }
  
  public void onRefreshCompleted(View paramView, boolean paramBoolean) {}
  
  public void onViewCompleteVisable(View paramView)
  {
    if ((this.mAnimManager != null) && (paramView == this.mAnimManager.getRefreshView(this))) {
      this.mAnimManager.onPullRefreshing(100, this.isRefreshing);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(View paramView)
  {
    boolean bool = ((Boolean)this.mIsMachineRefresh.get()).booleanValue();
    this.mIsMachineRefresh.set(Boolean.valueOf(false));
    if ((this.mAnimManager != null) && (paramView == this.mAnimManager.getRefreshView(this)))
    {
      this.mAnimManager.onPullRefreshComplete(bool);
      paramView = this.mRefreshCallback;
      if (paramView != null) {
        paramView.startTopRefresh(this, bool);
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(View paramView) {}
  
  public void pullRefreshCompleted(boolean paramBoolean)
  {
    super.pullRefreshCompleted(paramBoolean);
    if (this.mAnimManager != null) {
      this.mAnimManager.showRefreshResult(paramBoolean, "");
    }
    XRecyclerView.RefreshCallback localRefreshCallback = this.mRefreshCallback;
    if (localRefreshCallback != null) {
      localRefreshCallback.endOfRefresh();
    }
  }
  
  public void scrollToTop()
  {
    this.mRecyclerView.stopScroll();
    this.mRecyclerView.smoothScrollToPosition(0);
  }
  
  public void setRefreshCallback(XRecyclerView.RefreshCallback paramRefreshCallback)
  {
    this.mRefreshCallback = paramRefreshCallback;
  }
  
  public void startMachineRefresh()
  {
    this.mIsMachineRefresh.set(Boolean.valueOf(true));
    changeToState(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */