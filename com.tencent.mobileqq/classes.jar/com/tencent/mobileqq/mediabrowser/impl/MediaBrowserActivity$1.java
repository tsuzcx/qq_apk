package com.tencent.mobileqq.mediabrowser.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class MediaBrowserActivity$1
  extends BroadcastReceiver
{
  MediaBrowserActivity$1(MediaBrowserActivity paramMediaBrowserActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("MediaBrowserActivity", 4, "receive videochat in aiogallery");
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */