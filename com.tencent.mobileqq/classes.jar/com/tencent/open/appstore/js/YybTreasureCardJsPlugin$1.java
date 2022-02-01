package com.tencent.open.appstore.js;

import android.os.Build.VERSION;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class YybTreasureCardJsPlugin$1
  implements Runnable
{
  YybTreasureCardJsPlugin$1(YybTreasureCardJsPlugin paramYybTreasureCardJsPlugin, String paramString) {}
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 19)
      {
        YybTreasureCardJsPlugin.a(this.this$0).loadUrl(this.a);
        return;
      }
      YybTreasureCardJsPlugin.a(this.this$0).evaluateJavascript(this.a, new YybTreasureCardJsPlugin.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a("TreasureCardJsPlugin", "[jsCallBack] e>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.js.YybTreasureCardJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */