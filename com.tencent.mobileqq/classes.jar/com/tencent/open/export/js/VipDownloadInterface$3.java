package com.tencent.open.export.js;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class VipDownloadInterface$3
  implements Runnable
{
  VipDownloadInterface$3(VipDownloadInterface paramVipDownloadInterface, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.d != null) && (!TextUtils.isEmpty(this.a)))
      {
        this.this$0.d.loadUrl(this.a);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.a(this.this$0.a, "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface.3
 * JD-Core Version:    0.7.0.1
 */