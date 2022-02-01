package com.tencent.mobileqq.mediabrowser.impl;

import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class MediaBrowserActivity$2$1
  implements Runnable
{
  MediaBrowserActivity$2$1(MediaBrowserActivity.2 param2, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (MediaBrowserActivity.a(this.g.a) != null)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IAIOImageProviderCallBack.notifyImageResult():isPart ");
      localStringBuilder.append(this.a);
      localIBrowserLog.d("MediaBrowserActivity", 4, localStringBuilder.toString());
      MediaBrowserActivity.a(this.g.a).notifyImageResult(this.b, this.c, this.d, this.e, this.f, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserActivity.2.1
 * JD-Core Version:    0.7.0.1
 */