package com.tencent.widget.pull2refresh.anim;

import android.view.MotionEvent;

public abstract interface IAnimManager
  extends IPullRefreshAnim
{
  public abstract void endOfRefresh();
  
  public abstract boolean isSkinAnimManager();
  
  public abstract void onDestroy();
  
  public abstract void onPullRefreshCancel();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void registerRefreshCompleteListener(IAnimManager.PullRefreshComplete paramPullRefreshComplete);
  
  public abstract void setRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener paramOnRefreshPullDistanceListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.anim.IAnimManager
 * JD-Core Version:    0.7.0.1
 */