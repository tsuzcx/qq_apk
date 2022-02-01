package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.smtt.utils.Apn;

class WebView$2
  extends Thread
{
  WebView$2(WebView paramWebView, Context paramContext) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (Apn.getApnType(this.a) == 3)
        {
          bool = true;
          QbSdk.e = bool;
          QbSdk.f = System.currentTimeMillis();
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          this.a.getApplicationContext().registerReceiver(WebView.d(), localIntentFilter);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.2
 * JD-Core Version:    0.7.0.1
 */