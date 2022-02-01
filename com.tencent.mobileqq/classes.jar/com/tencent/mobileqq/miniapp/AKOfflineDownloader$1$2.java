package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class AKOfflineDownloader$1$2
  implements Runnable
{
  AKOfflineDownloader$1$2(AKOfflineDownloader.1 param1) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.a.a);
    localBundle.putString("path", AKOfflineDownloader.a(this.a.a, ""));
    AKOfflineDownloader.a(this.a.f.a(localBundle), this.a.b, this.a.c, 3, this.a.a, this.a.d);
    QLog.d("AKOfflineDownloader", 2, new Object[] { "checkUpByBusinessId load success. no update. cost=", Long.valueOf(System.currentTimeMillis() - this.a.e) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.2
 * JD-Core Version:    0.7.0.1
 */