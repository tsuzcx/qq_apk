package com.tencent.mobileqq.mini.appbrand.page;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings.System;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class WebviewContainer$RotationObserver
  extends ContentObserver
{
  private ContentResolver mResolver;
  private WeakReference<WebviewContainer> mWebViewContainerReference;
  
  public WebviewContainer$RotationObserver(WebviewContainer paramWebviewContainer)
  {
    super(null);
    this.mWebViewContainerReference = new WeakReference(paramWebviewContainer);
    this.mResolver = paramWebviewContainer.getContext().getContentResolver();
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    try
    {
      int i = Settings.System.getInt(((WebviewContainer)this.mWebViewContainerReference.get()).getContext().getContentResolver(), "accelerometer_rotation", 0);
      ((WebviewContainer)this.mWebViewContainerReference.get()).setRequestedOrientation(i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebViewContainer", 1, Log.getStackTraceString(localException));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.RotationObserver
 * JD-Core Version:    0.7.0.1
 */