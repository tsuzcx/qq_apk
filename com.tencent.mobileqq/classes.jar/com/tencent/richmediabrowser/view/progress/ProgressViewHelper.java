package com.tencent.richmediabrowser.view.progress;

import android.view.View;

public class ProgressViewHelper
{
  private AbstractProgressView progressView;
  
  private AbstractProgressView getProgressView(int paramInt)
  {
    return this.progressView;
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.stop();
    }
  }
  
  public void onLoadProgressUpdate(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt1);
    if ((localAbstractProgressView != null) && (localAbstractProgressView.isShow())) {
      localAbstractProgressView.start(paramInt2);
    }
  }
  
  public void onLoadProgressUpdate(View paramView, int paramInt) {}
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt1);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.start(paramInt2);
    }
  }
  
  public void setProgressView(AbstractProgressView paramAbstractProgressView)
  {
    this.progressView = paramAbstractProgressView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.progress.ProgressViewHelper
 * JD-Core Version:    0.7.0.1
 */