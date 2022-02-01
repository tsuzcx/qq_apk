package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class WebViewWrapper$WebViewClientImpl$1
  implements ValueCallback<Bundle>
{
  WebViewWrapper$WebViewClientImpl$1(WebViewWrapper.WebViewClientImpl paramWebViewClientImpl) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("input-box-num", 0);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "onFakeLoginRecognised detect ", Integer.valueOf(i), " input box" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.1
 * JD-Core Version:    0.7.0.1
 */