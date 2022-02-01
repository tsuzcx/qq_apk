package com.tencent.mobileqq.webview.swift.component;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserStatisticInjector;
import java.net.URLEncoder;

class SwiftBrowserStatistics$2
  implements Runnable
{
  SwiftBrowserStatistics$2(SwiftBrowserStatistics paramSwiftBrowserStatistics, String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    String str3 = "";
    String str2;
    try
    {
      localObject = Uri.parse(this.a);
      String str1 = str3;
      if (localObject != null)
      {
        str1 = ((Uri)localObject).getHost();
        if (TextUtils.isEmpty(str1)) {
          return;
        }
        if ((!this.this$0.aB) && (!AuthorizeConfig.a().f("white_list_authorize_config", str1))) {
          return;
        }
        str1 = URLEncoder.encode(this.a);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str2 = str3;
    }
    if (TextUtils.isEmpty(str2)) {
      return;
    }
    Object localObject = new StringBuilder();
    if (this.this$0.aW.b == 13) {
      str3 = "1";
    } else {
      str3 = "0";
    }
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(String.valueOf(-this.b));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.b);
    DcReportUtil.a(null, "dc00757", ((StringBuilder)localObject).toString(), true);
    if (SwiftBrowserStatistics.a(this.this$0) != null) {
      SwiftBrowserStatistics.a(this.this$0).a(this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.2
 * JD-Core Version:    0.7.0.1
 */