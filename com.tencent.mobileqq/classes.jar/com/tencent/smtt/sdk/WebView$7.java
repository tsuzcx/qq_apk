package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.b;
import com.tencent.smtt.utils.TbsLog;

class WebView$7
  implements Runnable
{
  WebView$7(WebView paramWebView) {}
  
  public void run()
  {
    if ((!WebView.b(this.a)) && (this.a.a != 0)) {
      try
      {
        if ((!WebView.b(this.a)) && (this.a.a != 0))
        {
          WebView.a(this.a, true);
          Object localObject4 = "";
          Object localObject5 = "";
          String str2 = "";
          Object localObject3 = localObject4;
          Object localObject2 = localObject5;
          String str1 = str2;
          if (WebView.c(this.a))
          {
            Bundle localBundle = WebView.d(this.a).getX5WebViewExtension().getSdkQBStatisticsInfo();
            localObject3 = localObject4;
            localObject2 = localObject5;
            str1 = str2;
            if (localBundle != null)
            {
              localObject3 = localBundle.getString("guid");
              localObject2 = localBundle.getString("qua2");
              str1 = localBundle.getString("lc");
            }
          }
          if ("com.qzone".equals(WebView.a(this.a).getApplicationInfo().packageName))
          {
            int j = WebView.a(this.a, WebView.a(this.a));
            localObject4 = this.a;
            int i = j;
            if (j == -1) {
              i = this.a.a;
            }
            ((WebView)localObject4).a = i;
            WebView.b(this.a, WebView.a(this.a));
          }
          boolean bool;
          try
          {
            bool = WebView.d(this.a).getX5WebViewExtension().isX5CoreSandboxMode();
          }
          catch (Throwable localThrowable)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("exception: ");
            ((StringBuilder)localObject5).append(localThrowable);
            TbsLog.w("onVisibilityChanged", ((StringBuilder)localObject5).toString());
            bool = false;
          }
          b.a(WebView.a(this.a), (String)localObject3, (String)localObject2, str1, this.a.a, WebView.c(this.a), WebView.e(this.a), bool);
          this.a.a = 0;
          WebView.a(this.a, false);
          return;
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.7
 * JD-Core Version:    0.7.0.1
 */