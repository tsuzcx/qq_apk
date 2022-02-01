package com.tencent.mobileqq.mediabrowser.impl;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class MediaBrowserActivity$2$3
  implements Runnable
{
  MediaBrowserActivity$2$3(MediaBrowserActivity.2 param2, long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void run()
  {
    if (MediaBrowserActivity.a(this.j.a) != null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("MediaBrowserActivity", 4, "IAIOImageProviderCallBack.notifyVideoUrl");
      MediaBrowserActivity.a(this.j.a).notifyVideoUrl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserActivity.2.3
 * JD-Core Version:    0.7.0.1
 */