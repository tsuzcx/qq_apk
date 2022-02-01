package com.tencent.open.appstore.dl;

import android.content.Context;
import android.content.IntentFilter;
import bizw;
import bjjq;

public class DownloadManagerV2$2
  implements Runnable
{
  public DownloadManagerV2$2(bjjq parambjjq, IntentFilter paramIntentFilter1, IntentFilter paramIntentFilter2) {}
  
  public void run()
  {
    bizw.a().a().registerReceiver(bjjq.a(this.this$0), this.a);
    bizw.a().a().registerReceiver(bjjq.a(this.this$0), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.2
 * JD-Core Version:    0.7.0.1
 */