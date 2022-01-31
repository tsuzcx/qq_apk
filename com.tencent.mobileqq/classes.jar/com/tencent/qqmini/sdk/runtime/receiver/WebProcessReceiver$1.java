package com.tencent.qqmini.sdk.runtime.receiver;

import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.smtt.sdk.TbsDownloader;

class WebProcessReceiver$1
  implements Runnable
{
  WebProcessReceiver$1(WebProcessReceiver paramWebProcessReceiver, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    WebProcessReceiver localWebProcessReceiver;
    boolean bool2;
    if (TbsDownloader.needDownload(AppLoaderFactory.g().getContext(), this.a))
    {
      localWebProcessReceiver = this.this$0;
      bool2 = this.a;
      if (this.b) {
        break label43;
      }
    }
    label43:
    for (boolean bool1 = true;; bool1 = false)
    {
      localWebProcessReceiver.a(false, bool2, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.receiver.WebProcessReceiver.1
 * JD-Core Version:    0.7.0.1
 */