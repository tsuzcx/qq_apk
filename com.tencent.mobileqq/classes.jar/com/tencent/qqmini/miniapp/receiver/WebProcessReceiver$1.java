package com.tencent.qqmini.miniapp.receiver;

import android.content.Context;
import com.tencent.smtt.sdk.TbsDownloader;

class WebProcessReceiver$1
  implements Runnable
{
  WebProcessReceiver$1(WebProcessReceiver paramWebProcessReceiver, Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    WebProcessReceiver localWebProcessReceiver;
    Context localContext;
    boolean bool2;
    if (TbsDownloader.needDownload(this.val$context, this.val$isDownloadForeground))
    {
      localWebProcessReceiver = this.this$0;
      localContext = this.val$context;
      bool2 = this.val$isDownloadForeground;
      if (this.val$fromMiniApp) {
        break label49;
      }
    }
    label49:
    for (boolean bool1 = true;; bool1 = false)
    {
      localWebProcessReceiver.downloadTbs(localContext, false, bool2, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.1
 * JD-Core Version:    0.7.0.1
 */