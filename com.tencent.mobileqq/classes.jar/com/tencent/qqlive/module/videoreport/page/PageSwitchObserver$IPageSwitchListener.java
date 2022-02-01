package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;

public abstract interface PageSwitchObserver$IPageSwitchListener
{
  public abstract void onPageAppear(@NonNull PageInfo paramPageInfo);
  
  public abstract void onPageDisappear(@NonNull PageInfo paramPageInfo, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.IPageSwitchListener
 * JD-Core Version:    0.7.0.1
 */