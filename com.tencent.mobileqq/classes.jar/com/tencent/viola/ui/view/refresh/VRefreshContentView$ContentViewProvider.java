package com.tencent.viola.ui.view.refresh;

import android.view.View;

public abstract interface VRefreshContentView$ContentViewProvider<T extends View>
{
  public abstract boolean canChildPullDown();
  
  public abstract boolean canChildPullUp();
  
  public abstract T getContentView();
  
  public abstract void onHeaderRebounded();
  
  public abstract void scrollToTop(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.VRefreshContentView.ContentViewProvider
 * JD-Core Version:    0.7.0.1
 */