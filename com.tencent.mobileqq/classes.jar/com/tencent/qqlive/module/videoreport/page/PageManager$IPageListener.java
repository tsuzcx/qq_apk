package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import java.util.Set;

public abstract interface PageManager$IPageListener
{
  public static final int PG_IN_FROM_IDLE = 0;
  public static final int PG_IN_FROM_POST = 1;
  
  public abstract void onPageIn(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, int paramInt);
  
  public abstract void onPageOut(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, boolean paramBoolean);
  
  public abstract void onPageUpdate(PageInfo paramPageInfo, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
 * JD-Core Version:    0.7.0.1
 */