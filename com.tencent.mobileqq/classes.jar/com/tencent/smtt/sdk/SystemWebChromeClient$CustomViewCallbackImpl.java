package com.tencent.smtt.sdk;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

class SystemWebChromeClient$CustomViewCallbackImpl
  implements IX5WebChromeClient.CustomViewCallback
{
  WebChromeClient.CustomViewCallback mCustomViewCallback;
  
  SystemWebChromeClient$CustomViewCallbackImpl(SystemWebChromeClient paramSystemWebChromeClient, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.mCustomViewCallback = paramCustomViewCallback;
  }
  
  public void onCustomViewHidden()
  {
    this.mCustomViewCallback.onCustomViewHidden();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.CustomViewCallbackImpl
 * JD-Core Version:    0.7.0.1
 */