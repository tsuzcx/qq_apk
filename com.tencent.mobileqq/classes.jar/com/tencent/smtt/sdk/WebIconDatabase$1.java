package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IconListener;

class WebIconDatabase$1
  implements IconListener
{
  WebIconDatabase$1(WebIconDatabase paramWebIconDatabase, WebIconDatabase.IconListener paramIconListener) {}
  
  public void onReceivedIcon(String paramString, Bitmap paramBitmap)
  {
    this.val$listener.onReceivedIcon(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase.1
 * JD-Core Version:    0.7.0.1
 */