package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.statistics.DcReportUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class QWalletCommonJsPlugin$4
  implements Runnable
{
  QWalletCommonJsPlugin$4(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, long paramLong1, CustomWebView paramCustomWebView, String paramString, long paramLong2) {}
  
  public void run()
  {
    long l = this.val$totalTime;
    Object localObject1 = this.val$webView;
    if (localObject1 != null) {
      localObject1 = ((CustomWebView)localObject1).getUrl();
    } else {
      localObject1 = "";
    }
    String str;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = URLEncoder.encode((String)localObject1, "utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    } else {
      str = "";
    }
    int i = 3;
    Object localObject3 = this.val$authCode;
    Object localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      i = 4;
      l = 0L;
      localObject2 = "";
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append('|');
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append('|');
    ((StringBuilder)localObject3).append(str);
    ((StringBuilder)localObject3).append('|');
    ((StringBuilder)localObject3).append("2|");
    ((StringBuilder)localObject3).append(this.val$appid);
    ((StringBuilder)localObject3).append("|||");
    ((StringBuilder)localObject3).append(l);
    DcReportUtil.a(null, "dc01021", ((StringBuilder)localObject3).toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */