package com.tencent.smtt.sdk;

import android.graphics.Bitmap;

class WebIconDatabase$2
  implements android.webkit.WebIconDatabase.IconListener
{
  WebIconDatabase$2(WebIconDatabase paramWebIconDatabase, WebIconDatabase.IconListener paramIconListener) {}
  
  public void onReceivedIcon(String paramString, Bitmap paramBitmap)
  {
    this.val$listener.onReceivedIcon(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase.2
 * JD-Core Version:    0.7.0.1
 */