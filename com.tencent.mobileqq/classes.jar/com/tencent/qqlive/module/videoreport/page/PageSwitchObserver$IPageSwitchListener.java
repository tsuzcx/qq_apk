package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.view.View;

public abstract interface PageSwitchObserver$IPageSwitchListener
{
  public abstract void onPageAppear(@NonNull PageInfo paramPageInfo, int paramInt);
  
  public abstract boolean onPageDestroyed(@NonNull View paramView);
  
  public abstract void onPageDisappear();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.IPageSwitchListener
 * JD-Core Version:    0.7.0.1
 */