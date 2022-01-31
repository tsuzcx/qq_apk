package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TbsApkDownloader$1
  extends Handler
{
  TbsApkDownloader$1(TbsApkDownloader paramTbsApkDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 150) {
      TbsApkDownloader.access$000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsApkDownloader.1
 * JD-Core Version:    0.7.0.1
 */