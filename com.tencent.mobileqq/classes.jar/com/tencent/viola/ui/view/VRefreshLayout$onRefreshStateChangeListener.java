package com.tencent.viola.ui.view;

public abstract interface VRefreshLayout$onRefreshStateChangeListener
{
  public abstract void onRefreshMove(int paramInt);
  
  public abstract void onStateEnd();
  
  public abstract void onStateFinish(boolean paramBoolean, String paramString);
  
  public abstract void onStateIdel();
  
  public abstract void onStatePulling();
  
  public abstract void onStateRefreshing();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener
 * JD-Core Version:    0.7.0.1
 */