package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import axpy;
import com.tencent.biz.pubaccount.CustomWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class QWalletCommonJsPlugin$4
  implements Runnable
{
  QWalletCommonJsPlugin$4(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, long paramLong1, CustomWebView paramCustomWebView, String paramString, long paramLong2) {}
  
  public void run()
  {
    long l = this.val$totalTime;
    String str1 = "";
    if (this.val$webView != null) {
      str1 = this.val$webView.getUrl();
    }
    if (!TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      try
      {
        str1 = URLEncoder.encode(str1, "utf-8");
        int i = 3;
        String str3 = this.val$authCode;
        if (TextUtils.isEmpty(this.val$authCode))
        {
          i = 4;
          str3 = "";
          l = 0L;
        }
        axpy.a(null, "dc01021", "" + i + '|' + str3 + '|' + str1 + '|' + "2|" + this.val$appid + "|||" + l, false);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      String str2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */