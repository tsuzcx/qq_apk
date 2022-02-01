package com.tencent.mobileqq.fragment;

import android.net.Uri;
import android.os.Handler;
import bijv;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$4
  implements Runnable
{
  NearbyHybridFragment$4(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void run()
  {
    boolean bool = WebSoService.a().a(this.this$0.c);
    int i = this.this$0.b();
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "startWebSoRequest, hasWebSoCache=" + bool + ", initTab=" + i + ", url=" + this.this$0.c);
    }
    if (bool) {
      this.this$0.a.removeMessages(3);
    }
    if (i != -1) {}
    try
    {
      bijv.a(Uri.parse(this.this$0.c));
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "cleanWebSoData: hasCacheData=" + WebSoService.a().a(this.this$0.c));
      }
      WebSoService.a().a(this.this$0.c, null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyHybridFragment.webloading", 2, "cleanWebSoData exp:" + localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.4
 * JD-Core Version:    0.7.0.1
 */