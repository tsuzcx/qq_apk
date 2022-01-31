package com.tencent.smtt.sdk;

import android.net.Uri;

class SmttWebChromeClient$2
  implements ValueCallback<Uri>
{
  SmttWebChromeClient$2(SmttWebChromeClient paramSmttWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void onReceiveValue(Uri paramUri)
  {
    this.val$uploadFile.onReceiveValue(new Uri[] { paramUri });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebChromeClient.2
 * JD-Core Version:    0.7.0.1
 */