package com.tencent.viola.ui.view.refresh;

import android.view.View;

public class VRefreshContentView
{
  private VRefreshContentView.ContentViewProvider mContentViewProvider;
  
  private boolean hasChildOnBottom()
  {
    VRefreshContentView.ContentViewProvider localContentViewProvider = this.mContentViewProvider;
    if (localContentViewProvider != null) {
      return localContentViewProvider.canChildPullUp() ^ true;
    }
    return false;
  }
  
  private boolean hasChildOnTop()
  {
    VRefreshContentView.ContentViewProvider localContentViewProvider = this.mContentViewProvider;
    if (localContentViewProvider != null) {
      return localContentViewProvider.canChildPullDown() ^ true;
    }
    return false;
  }
  
  public VRefreshContentView.ContentViewProvider getContentViewProvider()
  {
    return this.mContentViewProvider;
  }
  
  public boolean isBottom()
  {
    return hasChildOnBottom();
  }
  
  public boolean isTop()
  {
    return hasChildOnTop();
  }
  
  public void offsetTopAndBottom(int paramInt)
  {
    VRefreshContentView.ContentViewProvider localContentViewProvider = this.mContentViewProvider;
    if ((localContentViewProvider != null) && (localContentViewProvider.getContentView() != null)) {
      this.mContentViewProvider.getContentView().offsetTopAndBottom(paramInt);
    }
  }
  
  public void scrollToTop(boolean paramBoolean)
  {
    VRefreshContentView.ContentViewProvider localContentViewProvider = this.mContentViewProvider;
    if (localContentViewProvider != null) {
      localContentViewProvider.scrollToTop(paramBoolean);
    }
  }
  
  public void setContentViewProvider(VRefreshContentView.ContentViewProvider paramContentViewProvider)
  {
    if (paramContentViewProvider == null) {
      return;
    }
    this.mContentViewProvider = paramContentViewProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.VRefreshContentView
 * JD-Core Version:    0.7.0.1
 */