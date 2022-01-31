package com.tencent.open.appstore.dl;

import android.content.Context;
import android.content.IntentFilter;
import bcxm;
import bdgv;

public class DownloadManagerV2$2
  implements Runnable
{
  public DownloadManagerV2$2(bdgv parambdgv, IntentFilter paramIntentFilter1, IntentFilter paramIntentFilter2) {}
  
  public void run()
  {
    bcxm.a().a().registerReceiver(bdgv.a(this.this$0), this.a);
    bcxm.a().a().registerReceiver(bdgv.a(this.this$0), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.2
 * JD-Core Version:    0.7.0.1
 */