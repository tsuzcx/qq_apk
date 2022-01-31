package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AuthCodeItem;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import org.json.JSONException;
import org.json.JSONObject;

class QWalletCommonJsPlugin$3
  implements Runnable
{
  QWalletCommonJsPlugin$3(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, AuthCodeItem paramAuthCodeItem, CustomWebView paramCustomWebView, String paramString, long paramLong) {}
  
  public void run()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((this.val$item != null) && (QWalletCommonJsPlugin.access$100(this.this$0) == this.val$item.appid))
        {
          if (TextUtils.isEmpty(this.val$item.urlDomain)) {
            break label253;
          }
          String[] arrayOfString = (this.val$item.urlDomain + "|#").split("\\|");
          String str = Uri.parse(this.val$webView.getUrl()).getHost();
          if (TextUtils.isEmpty(str)) {
            break label253;
          }
          str = str.toLowerCase();
          i = 0;
          if ((i < arrayOfString.length - 1) && (!str.contains(arrayOfString[i]))) {
            break label258;
          }
          if (i < arrayOfString.length - 1) {
            break label253;
          }
          i = j;
          if (i != 0)
          {
            localJSONObject.put("code", this.val$item.authCode);
            QWalletCommonJsPlugin.access$600(this.this$0, this.val$callbackId, localJSONObject.toString());
            QWalletCommonJsPlugin.access$700(this.this$0, this.val$item.authCode, QWalletCommonJsPlugin.access$100(this.this$0), this.val$getAuthCodeTotalTime);
            return;
          }
        }
        localJSONObject.put("code", "");
        QWalletCommonJsPlugin.access$600(this.this$0, this.val$callbackId, localJSONObject.toString());
        QWalletCommonJsPlugin.access$700(this.this$0, null, QWalletCommonJsPlugin.access$100(this.this$0), this.val$getAuthCodeTotalTime);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      label253:
      int i = 1;
      continue;
      label258:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */