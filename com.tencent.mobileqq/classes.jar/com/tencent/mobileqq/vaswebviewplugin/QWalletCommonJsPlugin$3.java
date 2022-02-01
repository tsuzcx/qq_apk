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
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject = this.val$item;
        if ((localObject != null) && (QWalletCommonJsPlugin.access$100(this.this$0) == this.val$item.appid))
        {
          boolean bool = TextUtils.isEmpty(this.val$item.urlDomain);
          int j = 0;
          if (bool) {
            break label289;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.val$item.urlDomain);
          ((StringBuilder)localObject).append("|#");
          localObject = ((StringBuilder)localObject).toString().split("\\|");
          String str = Uri.parse(this.val$webView.getUrl()).getHost();
          if (TextUtils.isEmpty(str)) {
            break label289;
          }
          str = str.toLowerCase();
          i = 0;
          if (i < localObject.length - 1) {
            if (!str.contains(localObject[i])) {
              break label282;
            }
          }
          if (i < localObject.length - 1) {
            break label289;
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
      label282:
      i += 1;
      continue;
      label289:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */