package com.tencent.open.appcommon.js;

import android.text.TextUtils;
import bjhz;
import bjko;
import com.tencent.smtt.sdk.WebView;

public class AppInterface$1$1
  implements Runnable
{
  public AppInterface$1$1(bjhz parambjhz, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Bjhz.a.webView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bjhz.a.webView.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      bjko.a("AppInterface", "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.1.1
 * JD-Core Version:    0.7.0.1
 */