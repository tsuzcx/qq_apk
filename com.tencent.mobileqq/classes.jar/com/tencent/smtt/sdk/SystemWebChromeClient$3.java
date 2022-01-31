package com.tencent.smtt.sdk;

import android.net.Uri;

class SystemWebChromeClient$3
  implements ValueCallback<Uri>
{
  SystemWebChromeClient$3(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void onReceiveValue(Uri paramUri)
  {
    this.val$uploadFile.onReceiveValue(paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.3
 * JD-Core Version:    0.7.0.1
 */