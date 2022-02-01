package com.tencent.tmassistantsdk.internal.openSDK.QQDownloader;

import android.content.Context;

class c
  extends Thread
{
  c(QQDownloaderInstalled paramQQDownloaderInstalled, Context paramContext) {}
  
  public void run()
  {
    if (this.b.d != null) {
      this.b.d.onQQDownloaderInstalled(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.c
 * JD-Core Version:    0.7.0.1
 */