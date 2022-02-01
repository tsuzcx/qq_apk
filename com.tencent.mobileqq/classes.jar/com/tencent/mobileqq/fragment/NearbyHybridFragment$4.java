package com.tencent.mobileqq.fragment;

import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$4
  implements Runnable
{
  NearbyHybridFragment$4(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void run()
  {
    boolean bool = WebSoService.a().a(this.this$0.c);
    int i = this.this$0.b();
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("startWebSoRequest, hasWebSoCache=");
      localStringBuilder1.append(bool);
      localStringBuilder1.append(", initTab=");
      localStringBuilder1.append(i);
      localStringBuilder1.append(", url=");
      localStringBuilder1.append(this.this$0.c);
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, localStringBuilder1.toString());
    }
    if (bool) {
      this.this$0.a.removeMessages(3);
    }
    if (i != -1) {
      try
      {
        WebSoUtils.a(Uri.parse(this.this$0.c));
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("cleanWebSoData: hasCacheData=");
          localStringBuilder1.append(WebSoService.a().a(this.this$0.c));
          QLog.d("nearby.NearbyHybridFragment.webloading", 2, localStringBuilder1.toString());
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("cleanWebSoData exp:");
          localStringBuilder2.append(localException.toString());
          QLog.d("nearby.NearbyHybridFragment.webloading", 2, localStringBuilder2.toString());
        }
      }
    }
    WebSoService.a().a(this.this$0.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.4
 * JD-Core Version:    0.7.0.1
 */