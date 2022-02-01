package com.tencent.smtt.sdk;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

class SystemWebChromeClient$b
  implements IX5WebChromeClient.CustomViewCallback
{
  WebChromeClient.CustomViewCallback a;
  
  SystemWebChromeClient$b(SystemWebChromeClient paramSystemWebChromeClient, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.a = paramCustomViewCallback;
  }
  
  public void onCustomViewHidden()
  {
    this.a.onCustomViewHidden();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.b
 * JD-Core Version:    0.7.0.1
 */