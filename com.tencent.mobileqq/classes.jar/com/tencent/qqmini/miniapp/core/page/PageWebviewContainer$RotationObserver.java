package com.tencent.qqmini.miniapp.core.page;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings.System;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

class PageWebviewContainer$RotationObserver
  extends ContentObserver
{
  private WeakReference<PageWebviewContainer> mPageWebViewContainerReference;
  private ContentResolver mResolver;
  
  public PageWebviewContainer$RotationObserver(PageWebviewContainer paramPageWebviewContainer)
  {
    super(null);
    this.mPageWebViewContainerReference = new WeakReference(paramPageWebviewContainer);
    this.mResolver = paramPageWebviewContainer.getContext().getContentResolver();
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    try
    {
      PageWebviewContainer.access$600((PageWebviewContainer)this.mPageWebViewContainerReference.get());
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PageWebviewContainer", Log.getStackTraceString(localException));
    }
  }
  
  public void registerObserver()
  {
    if (this.mResolver != null) {
      this.mResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
    }
  }
  
  public void unregisterObserver()
  {
    if (this.mResolver != null) {
      this.mResolver.unregisterContentObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.RotationObserver
 * JD-Core Version:    0.7.0.1
 */