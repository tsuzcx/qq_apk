package com.tencent.richmediabrowser.view.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.richmediabrowser.listener.IBrowserItemScrollListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;

public class BrowserScrollListener
  extends RecyclerView.OnScrollListener
{
  private static final String TAG = "BrowserScrollListener";
  private IBrowserItemScrollListener mItemScrollListener;
  private MainBrowserPresenter mMainBrowserPresenter;
  public int mScreenWidthPx;
  private int mTotalDistance;
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newState = ");
    localStringBuilder.append(paramInt);
    ((IBrowserLog)localObject).d("BrowserScrollListener", 4, localStringBuilder.toString());
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.mTotalDistance = 0;
      this.mScreenWidthPx = ScreenUtils.getScreenWidth(paramRecyclerView.getContext());
    }
    if ((paramInt == 0) && (this.mMainBrowserPresenter != null) && (paramRecyclerView.getChildCount() > 0)) {
      try
      {
        int i = this.mMainBrowserPresenter.getCurrentPosition();
        int j = ((RecyclerView.LayoutParams)paramRecyclerView.getChildAt(0).getLayoutParams()).getViewAdapterPosition();
        int k = this.mMainBrowserPresenter.getLastVisibleItemPosition();
        paramRecyclerView = BrowserLogHelper.getInstance().getGalleryLog();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("currentPosition = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" viewPosition = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" lastVisibleItemPosition = ");
        ((StringBuilder)localObject).append(k);
        paramRecyclerView.d("BrowserScrollListener", 4, ((StringBuilder)localObject).toString());
        if ((i != j) && (i != k))
        {
          paramRecyclerView = BrowserLogHelper.getInstance().getGalleryLog();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onItemSelect position = ");
          ((StringBuilder)localObject).append(j);
          paramRecyclerView.d("BrowserScrollListener", 4, ((StringBuilder)localObject).toString());
          this.mMainBrowserPresenter.resetItemView(i);
          this.mMainBrowserPresenter.onItemSelect(j);
        }
      }
      catch (Exception paramRecyclerView)
      {
        localObject = BrowserLogHelper.getInstance().getGalleryLog();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScrollStateChanged exception = ");
        localStringBuilder.append(paramRecyclerView.getMessage());
        ((IBrowserLog)localObject).d("BrowserScrollListener", 4, localStringBuilder.toString());
      }
    }
    paramRecyclerView = this.mItemScrollListener;
    if (paramRecyclerView != null)
    {
      if (paramInt == 1)
      {
        paramRecyclerView.onScrollStart();
        return;
      }
      if (paramInt == 0) {
        paramRecyclerView.onScrollEnd();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.mTotalDistance += paramInt1;
    if ((this.mItemScrollListener != null) && (Math.abs(this.mTotalDistance) > this.mScreenWidthPx / 2)) {
      this.mItemScrollListener.onScrollHalfScreenWidth();
    }
  }
  
  public void setBrowserItemScrollListener(IBrowserItemScrollListener paramIBrowserItemScrollListener)
  {
    this.mItemScrollListener = paramIBrowserItemScrollListener;
  }
  
  public void setMainBrowserPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mMainBrowserPresenter = paramMainBrowserPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserScrollListener
 * JD-Core Version:    0.7.0.1
 */