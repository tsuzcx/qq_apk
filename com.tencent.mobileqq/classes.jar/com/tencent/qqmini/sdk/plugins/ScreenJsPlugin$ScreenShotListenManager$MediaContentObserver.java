package com.tencent.qqmini.sdk.plugins;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

class ScreenJsPlugin$ScreenShotListenManager$MediaContentObserver
  extends ContentObserver
{
  private Uri mContentUri;
  
  public ScreenJsPlugin$ScreenShotListenManager$MediaContentObserver(ScreenJsPlugin.ScreenShotListenManager paramScreenShotListenManager, Uri paramUri, Handler paramHandler)
  {
    super(paramHandler);
    this.mContentUri = paramUri;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    ScreenJsPlugin.ScreenShotListenManager.access$500(this.this$0, this.mContentUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ScreenJsPlugin.ScreenShotListenManager.MediaContentObserver
 * JD-Core Version:    0.7.0.1
 */