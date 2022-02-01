package com.tencent.mobileqq.richmediabrowser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOGalleryActivity$2
  extends BroadcastReceiver
{
  AIOGalleryActivity$2(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "receive videochat in aiogallery");
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2
 * JD-Core Version:    0.7.0.1
 */