package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Build.VERSION;
import android.webkit.WebSettings;

class RequestPlugin$4
  implements Runnable
{
  RequestPlugin$4(RequestPlugin paramRequestPlugin) {}
  
  public void run()
  {
    String str2;
    if (Build.VERSION.SDK_INT >= 17) {
      try
      {
        String str1 = WebSettings.getDefaultUserAgent(this.this$0.jsPluginEngine.getActivityContext());
        RequestPlugin.access$402(this.this$0, RequestPlugin.access$500(this.this$0, str1, false));
        return;
      }
      catch (Exception localException)
      {
        str2 = System.getProperty("http.agent");
      }
    }
    for (;;)
    {
      RequestPlugin.access$402(this.this$0, RequestPlugin.access$500(this.this$0, str2, true));
      return;
      str2 = System.getProperty("http.agent");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin.4
 * JD-Core Version:    0.7.0.1
 */