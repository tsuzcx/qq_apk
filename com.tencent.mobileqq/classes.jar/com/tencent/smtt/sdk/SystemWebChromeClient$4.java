package com.tencent.smtt.sdk;

import android.net.Uri;

class SystemWebChromeClient$4
  implements ValueCallback<Uri[]>
{
  SystemWebChromeClient$4(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void onReceiveValue(Uri[] paramArrayOfUri)
  {
    this.val$myFilePathCallback.onReceiveValue(paramArrayOfUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.4
 * JD-Core Version:    0.7.0.1
 */