package com.tencent.qqlive.module.videoreport.traversal;

import android.view.View;

public abstract interface IViewTraverseCallback
{
  public abstract boolean onEnter(View paramView, int paramInt);
  
  public abstract void onLeave(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.traversal.IViewTraverseCallback
 * JD-Core Version:    0.7.0.1
 */