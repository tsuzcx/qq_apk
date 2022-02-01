package com.tencent.shadow.core.runtime.remoteview;

import android.view.View;

public abstract interface ShadowRemoteViewCreateCallback
{
  public abstract void onViewCreateFailed(Exception paramException);
  
  public abstract void onViewCreateSuccess(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.remoteview.ShadowRemoteViewCreateCallback
 * JD-Core Version:    0.7.0.1
 */