package com.tencent.widget.pull2refresh;

import android.content.Context;

public class LoadingMoreHelper
{
  Context mContext;
  protected boolean mLoadEnabled = false;
  protected ILoadMoreLayout mLoadMoreLayout;
  protected LoadingMoreHelper.OnLoadMoreListener mLoadMoreListener;
  protected int mProLoaderCount = 5;
  
  public LoadingMoreHelper(ILoadMoreLayout paramILoadMoreLayout, Context paramContext)
  {
    this.mLoadMoreLayout = paramILoadMoreLayout;
    this.mContext = paramContext;
  }
  
  public int getProLoaderCount()
  {
    return this.mProLoaderCount;
  }
  
  public void setLoadMore(boolean paramBoolean)
  {
    if (!this.mLoadEnabled) {
      return;
    }
    if (this.mLoadMoreLayout.getState() == 0) {
      return;
    }
    if (!this.mLoadMoreLayout.checkState(2)) {
      return;
    }
    boolean bool = true;
    LoadingMoreHelper.OnLoadMoreListener localOnLoadMoreListener = this.mLoadMoreListener;
    if (localOnLoadMoreListener != null) {
      bool = localOnLoadMoreListener.onLoadMore(paramBoolean);
    }
    if (bool) {
      this.mLoadMoreLayout.setState(2);
    }
  }
  
  public void setLoadMoreComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.mLoadEnabled) {
      return;
    }
    if (!paramBoolean1)
    {
      this.mLoadMoreLayout.setState(5);
      return;
    }
    int i;
    if (paramBoolean2) {
      i = 3;
    } else {
      i = 4;
    }
    this.mLoadMoreLayout.setState(i);
    if (!this.mLoadMoreLayout.checkState(i)) {
      return;
    }
    LoadingMoreHelper.OnLoadMoreListener localOnLoadMoreListener = this.mLoadMoreListener;
    if (localOnLoadMoreListener != null) {
      localOnLoadMoreListener.onLoadMoreComplete();
    }
  }
  
  public void setLoadMoreEnabled(boolean paramBoolean)
  {
    if (this.mLoadEnabled == paramBoolean) {
      return;
    }
    this.mLoadEnabled = paramBoolean;
    if (paramBoolean)
    {
      this.mLoadMoreLayout.setState(3);
      return;
    }
    this.mLoadMoreLayout.setState(0);
  }
  
  public void setOnLoadMoreListener(LoadingMoreHelper.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.mLoadMoreListener = paramOnLoadMoreListener;
    if (paramOnLoadMoreListener != null)
    {
      setLoadMoreEnabled(true);
      setLoadMoreComplete(true, false);
    }
    this.mLoadMoreLayout.setOnClickListener(new LoadingMoreHelper.1(this));
  }
  
  public void setPreLoaderCount(int paramInt)
  {
    this.mProLoaderCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.LoadingMoreHelper
 * JD-Core Version:    0.7.0.1
 */