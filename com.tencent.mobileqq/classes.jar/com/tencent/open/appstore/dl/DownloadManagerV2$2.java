package com.tencent.open.appstore.dl;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.open.adapter.CommonDataAdapter;

class DownloadManagerV2$2
  implements Runnable
{
  DownloadManagerV2$2(DownloadManagerV2 paramDownloadManagerV2, IntentFilter paramIntentFilter1, IntentFilter paramIntentFilter2) {}
  
  public void run()
  {
    CommonDataAdapter.a().a().registerReceiver(DownloadManagerV2.a(this.this$0), this.a);
    CommonDataAdapter.a().a().registerReceiver(DownloadManagerV2.a(this.this$0), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.2
 * JD-Core Version:    0.7.0.1
 */