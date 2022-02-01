package com.tencent.mobileqq.webview.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.DcReportUtil;
import java.net.URLEncoder;
import java.util.HashMap;

class WebStateReporter$2
  implements Runnable
{
  WebStateReporter$2(WebStateReporter paramWebStateReporter, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    int i;
    if (WebStateReporter.a.containsKey(this.a)) {
      i = ((Integer)WebStateReporter.a.get(this.a)).intValue();
    } else {
      i = 10;
    }
    if ((1 != i) && (this.b % i != WebStateReporter.i)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return;
    }
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
        if (!str1.endsWith("qq.com")) {
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
    if (this.this$0.d == 13) {
      str3 = "1";
    } else {
      str3 = "0";
    }
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(String.valueOf(-this.c));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.c);
    DcReportUtil.a(null, "dc00757", ((StringBuilder)localObject).toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebStateReporter.2
 * JD-Core Version:    0.7.0.1
 */