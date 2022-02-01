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
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserScrollListener", 4, "newState = " + paramInt);
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.mTotalDistance = 0;
      this.mScreenWidthPx = ScreenUtils.getScreenWidth(paramRecyclerView.getContext());
    }
    if ((paramInt == 0) && (this.mMainBrowserPresenter != null) && (paramRecyclerView.getChildCount() > 0)) {}
    try
    {
      int i = this.mMainBrowserPresenter.getCurrentPosition();
      int j = ((RecyclerView.LayoutParams)paramRecyclerView.getChildAt(0).getLayoutParams()).getViewAdapterPosition();
      int k = this.mMainBrowserPresenter.getLastVisibleItemPosition();
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserScrollListener", 4, "currentPosition = " + i + " viewPosition = " + j + " lastVisibleItemPosition = " + k);
      if ((i != j) && (i != k))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserScrollListener", 4, "onItemSelect position = " + j);
        this.mMainBrowserPresenter.resetItemView(i);
        this.mMainBrowserPresenter.onItemSelect(j);
      }
    }
    catch (Exception paramRecyclerView)
    {
      do
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("BrowserScrollListener", 4, "onScrollStateChanged exception = " + paramRecyclerView.getMessage());
        }
      } while (paramInt != 0);
      this.mItemScrollListener.onScrollEnd();
    }
    if (this.mItemScrollListener != null)
    {
      if (paramInt == 1) {
        this.mItemScrollListener.onScrollStart();
      }
    }
    else {
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserScrollListener
 * JD-Core Version:    0.7.0.1
 */