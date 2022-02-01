package com.tencent.mobileqq.flashshow.view.refresh;

import android.view.View;

public abstract interface IRefreshView
{
  public abstract void a(PullRefreshLayout paramPullRefreshLayout);
  
  public abstract void a(PullRefreshLayout paramPullRefreshLayout, float paramFloat);
  
  public abstract void a(PullRefreshLayout paramPullRefreshLayout, boolean paramBoolean);
  
  public abstract void b(PullRefreshLayout paramPullRefreshLayout);
  
  public abstract View getRefreshView();
  
  public abstract int getStartRefreshDistance();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.refresh.IRefreshView
 * JD-Core Version:    0.7.0.1
 */