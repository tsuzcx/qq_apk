package com.tencent.widget.pull2refresh.anim;

import android.view.View;
import android.view.ViewGroup;

public abstract interface IPullRefreshAnim
{
  public abstract int getPullRefreshAreaHeight();
  
  public abstract View getRefreshView(ViewGroup paramViewGroup);
  
  public abstract void onPullRefreshComplete(boolean paramBoolean);
  
  public abstract void onPullRefreshing(int paramInt, boolean paramBoolean);
  
  public abstract void onTouchPullDistance(int paramInt1, int paramInt2);
  
  public abstract void showPullRefresh();
  
  public abstract void showRefreshResult(boolean paramBoolean, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
 * JD-Core Version:    0.7.0.1
 */