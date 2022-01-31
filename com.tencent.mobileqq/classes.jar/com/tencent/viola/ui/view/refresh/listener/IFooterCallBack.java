package com.tencent.viola.ui.view.refresh.listener;

public abstract interface IFooterCallBack
{
  public abstract int getFooterHeight();
  
  public abstract boolean getRefreshStick();
  
  public abstract boolean isShowing();
  
  public abstract void onReleaseToLoadMore();
  
  public abstract void onStateFinish(boolean paramBoolean);
  
  public abstract void onStateReady();
  
  public abstract void onStateRefreshing();
  
  public abstract void show(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.listener.IFooterCallBack
 * JD-Core Version:    0.7.0.1
 */