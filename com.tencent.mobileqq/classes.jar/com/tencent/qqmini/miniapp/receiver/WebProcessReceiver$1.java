package com.tencent.qqmini.miniapp.receiver;

import android.content.Context;
import com.tencent.smtt.sdk.TbsDownloader;

class WebProcessReceiver$1
  implements Runnable
{
  WebProcessReceiver$1(WebProcessReceiver paramWebProcessReceiver, Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (TbsDownloader.needDownload(this.val$context, this.val$isDownloadForeground)) {
      this.this$0.downloadTbs(this.val$context, false, this.val$isDownloadForeground, this.val$fromMiniApp ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.1
 * JD-Core Version:    0.7.0.1
 */