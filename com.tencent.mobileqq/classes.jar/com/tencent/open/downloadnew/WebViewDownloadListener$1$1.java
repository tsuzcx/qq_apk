package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.ValueCallback;

class WebViewDownloadListener$1$1
  implements ValueCallback<String>
{
  WebViewDownloadListener$1$1(WebViewDownloadListener.1 param1) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceiveValue]:");
    localStringBuilder.append(paramString);
    LogUtility.a("WebViewDownloadListener", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.WebViewDownloadListener.1.1
 * JD-Core Version:    0.7.0.1
 */