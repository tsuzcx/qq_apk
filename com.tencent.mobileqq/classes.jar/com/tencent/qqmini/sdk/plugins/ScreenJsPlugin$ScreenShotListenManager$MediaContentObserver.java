package com.tencent.qqmini.sdk.plugins;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

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
    ThreadManager.getSubThreadHandler().post(new ScreenJsPlugin.ScreenShotListenManager.MediaContentObserver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ScreenJsPlugin.ScreenShotListenManager.MediaContentObserver
 * JD-Core Version:    0.7.0.1
 */