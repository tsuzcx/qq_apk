package com.tencent.smtt.sdk;

import android.net.Uri;

class SmttWebChromeClient$3
  implements ValueCallback<Uri[]>
{
  SmttWebChromeClient$3(SmttWebChromeClient paramSmttWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void onReceiveValue(Uri[] paramArrayOfUri)
  {
    this.val$myFilePathCallback.onReceiveValue(paramArrayOfUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebChromeClient.3
 * JD-Core Version:    0.7.0.1
 */