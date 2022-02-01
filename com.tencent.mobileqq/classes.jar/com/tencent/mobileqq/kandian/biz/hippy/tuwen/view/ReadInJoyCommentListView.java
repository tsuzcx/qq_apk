package com.tencent.mobileqq.kandian.biz.hippy.tuwen.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;

public class ReadInJoyCommentListView
  extends XListView
{
  public static final int STATUS_IDLE = 0;
  public static final int STATUS_LOADING = 1;
  public static final String TAG = "ReadInJoyCommentListView";
  boolean isScrollingDown;
  int lastFirstVisibleItem;
  protected int mCurrentStatus = 0;
  private ReadInJoyCommentListView.MultiScrollListener mDefaultScrollListener = new ReadInJoyCommentListView.1(this);
  protected ProgressBar mFooterProgressBar;
  protected TextView mFooterTextView;
  protected RelativeLayout mFooterView;
  public boolean mHasMoreData = false;
  public ReadInJoyCommentListView.RefreshCallback mRefreshCallback;
  private ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener mScrollYListener;
  int preloadCount = 3;
  
  public ReadInJoyCommentListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private BaseAdapter getBaseAdapter()
  {
    if ((getAdapter() instanceof HeaderViewListAdapter))
    {
      HeaderViewListAdapter localHeaderViewListAdapter = (HeaderViewListAdapter)getAdapter();
      if (localHeaderViewListAdapter != null) {
        return (BaseAdapter)localHeaderViewListAdapter.getWrappedAdapter();
      }
    }
    else if ((getAdapter() instanceof BaseAdapter))
    {
      return (BaseAdapter)getAdapter();
    }
    return null;
  }
  
  private void init()
  {
    setOnScrollListener(this.mDefaultScrollListener);
  }
  
  private boolean isShowFooterView()
  {
    ListAdapter localListAdapter = getAdapter();
    boolean bool = false;
    if (localListAdapter == null) {
      return false;
    }
    if (getFooterViewsCount() <= 0) {
      return false;
    }
    if (getLastVisiblePosition() == getAdapter().getCount() - 1) {
      bool = true;
    }
    return bool;
  }
  
  private void loadingMore()
  {
    if ((isShowFooterView()) && (this.mRefreshCallback != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadingMore| hasMore ");
      localStringBuilder.append(this.mHasMoreData);
      QLog.d("ReadInJoyCommentListView", 2, localStringBuilder.toString());
      showLoadingFooter();
      this.mCurrentStatus = 1;
      this.mRefreshCallback.startLoadMore(this);
    }
  }
  
  private void notifyDataChanged()
  {
    Object localObject = getAdapter();
    if ((localObject instanceof HeaderViewListAdapter))
    {
      localObject = (HeaderViewListAdapter)localObject;
      if ((((HeaderViewListAdapter)localObject).getWrappedAdapter() instanceof BaseAdapter)) {
        ((BaseAdapter)((HeaderViewListAdapter)localObject).getWrappedAdapter()).notifyDataSetChanged();
      }
    }
    else if ((localObject instanceof BaseAdapter))
    {
      ((BaseAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  private void preLoadingMore()
  {
    if (this.mRefreshCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preLoadingMore | hasMore ");
      localStringBuilder.append(this.mHasMoreData);
      QLog.d("ReadInJoyCommentListView", 2, localStringBuilder.toString());
      showLoadingFooter();
      this.mCurrentStatus = 1;
      this.mRefreshCallback.startLoadMore(this);
    }
  }
  
  private void showLoadingFooter()
  {
    this.mFooterView.setVisibility(0);
    this.mFooterProgressBar.setVisibility(0);
    this.mFooterTextView.setText(2131689532);
    this.mFooterTextView.setOnClickListener(null);
    this.mFooterTextView.setVisibility(0);
  }
  
  private void showRestCommentCntFooter(long paramLong)
  {
    Object localObject = this.mFooterView;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setVisibility(0);
      localObject = this.mFooterTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append(HardCodeUtil.a(2131712864));
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.mFooterTextView.setVisibility(0);
      this.mFooterProgressBar.setVisibility(8);
      this.mCurrentStatus = 0;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    BaseAdapter localBaseAdapter = getBaseAdapter();
    if (localBaseAdapter == null) {
      return -1;
    }
    return localBaseAdapter.getItemViewType(paramInt);
  }
  
  public void hideFooterView()
  {
    if ((this.mFooterView != null) && (getFooterViewsCount() > 0)) {
      this.mFooterView.setVisibility(8);
    }
    QLog.d("ReadInJoyCommentListView", 2, "hideFooterView hasMoreData false");
    this.mHasMoreData = false;
  }
  
  public void hideLoadingFooter()
  {
    if ((this.mFooterView != null) && (getFooterViewsCount() > 0))
    {
      QLog.d("ReadInJoyCommentListView", 2, "hideLoadingFooter");
      this.mFooterView.setVisibility(8);
    }
  }
  
  public void initFooterView()
  {
    this.mFooterView = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559979, this, false));
    this.mFooterProgressBar = ((ProgressBar)this.mFooterView.findViewById(2131373273));
    this.mFooterTextView = ((TextView)this.mFooterView.findViewById(2131373274));
    this.mFooterTextView.setTextColor(Color.parseColor("#A6A6A6"));
    this.mFooterTextView.setTextSize(2, 14.0F);
    this.mFooterProgressBar.setVisibility(8);
    addFooterView(this.mFooterView, null, false);
    setFooterDividersEnabled(false);
  }
  
  public void loadMoreFail()
  {
    if (this.mFooterView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "loadMoreFail");
      }
      this.mFooterView.setVisibility(0);
      this.mFooterTextView.setText(HardCodeUtil.a(2131712716));
      this.mFooterTextView.setVisibility(0);
      this.mFooterTextView.setOnClickListener(new ReadInJoyCommentListView.2(this));
      this.mFooterProgressBar.setVisibility(8);
      this.mCurrentStatus = 0;
    }
  }
  
  public void loadingMoreComplete(boolean paramBoolean)
  {
    if (this.mFooterView == null) {
      initFooterView();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadingMoreComplete | hasNextPage ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ReadInJoyCommentListView", 2, localStringBuilder.toString());
    this.mHasMoreData = paramBoolean;
    if (!paramBoolean) {
      removeFooter();
    }
    this.mCurrentStatus = 0;
    notifyDataChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = this.lastFirstVisibleItem;
    if (paramInt1 > paramInt2) {
      this.isScrollingDown = true;
    } else if (paramInt1 < paramInt2) {
      this.isScrollingDown = false;
    }
    this.lastFirstVisibleItem = paramInt1;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      RIJPerformanceReporter.a().a(0);
      VideoReport.traverseExposure();
      DropFrameMonitor.a().a("list_comment_kandian", false);
      if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.mHasMoreData))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentListView", 2, "on the bottom ");
        }
        if (this.mCurrentStatus == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyCommentListView", 2, "network request ing");
          }
          return;
        }
        QLog.d("ReadInJoyCommentListView", 2, "loadmore comment by scroll");
        loadingMore();
        return;
      }
      if ((paramAbsListView.getCount() - paramAbsListView.getLastVisiblePosition() < this.preloadCount) && (this.mHasMoreData) && (this.isScrollingDown))
      {
        if (this.mCurrentStatus == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyCommentListView", 2, "network request ing");
          }
          return;
        }
        QLog.d("ReadInJoyCommentListView", 2, "preLoadingmore comment");
        preLoadingMore();
      }
    }
    else
    {
      RIJPerformanceReporter.a().a();
      DropFrameMonitor.a().a("list_comment_kandian");
    }
  }
  
  public void removeFooter()
  {
    this.mFooterProgressBar.setVisibility(8);
    this.mFooterView.setVisibility(8);
    this.mFooterTextView.setVisibility(8);
    removeFooterView(this.mFooterView);
  }
  
  public void removeScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    ReadInJoyCommentListView.MultiScrollListener localMultiScrollListener = this.mDefaultScrollListener;
    if (localMultiScrollListener != null) {
      localMultiScrollListener.removeScrollListener(paramOnScrollListener);
    }
  }
  
  public void resetFooterView()
  {
    QLog.d("ReadInJoyCommentListView", 2, "resetFooterView");
    if (getFooterViewsCount() <= 0)
    {
      RelativeLayout localRelativeLayout = this.mFooterView;
      if (localRelativeLayout != null)
      {
        addFooterView(localRelativeLayout, null, false);
        return;
      }
      initFooterView();
    }
  }
  
  public void resetState()
  {
    QLog.d("ReadInJoyCommentListView", 2, "resetState hasMoreData false");
    resetFooterView();
    this.mHasMoreData = false;
    this.mCurrentStatus = 0;
    setEmptyView(null);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if ((paramOnScrollListener instanceof ReadInJoyCommentListView.MultiScrollListener))
    {
      super.setOnScrollListener(this.mDefaultScrollListener);
      return;
    }
    ReadInJoyCommentListView.MultiScrollListener localMultiScrollListener = this.mDefaultScrollListener;
    if (localMultiScrollListener != null) {
      localMultiScrollListener.addScrollListener(paramOnScrollListener);
    }
  }
  
  public void setOnScrollOffsetYListener(ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    this.mScrollYListener = paramOnScrollYOffsetListener;
  }
  
  public void setRefreshCallback(ReadInJoyCommentListView.RefreshCallback paramRefreshCallback)
  {
    this.mRefreshCallback = paramRefreshCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView
 * JD-Core Version:    0.7.0.1
 */