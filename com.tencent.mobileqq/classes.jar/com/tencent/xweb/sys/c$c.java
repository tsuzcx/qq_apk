package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.content.Intent;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.xweb.u.a;

public class c$c
  extends u.a
{
  public WebChromeClient.FileChooserParams a;
  
  public c$c(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.a = paramFileChooserParams;
  }
  
  @TargetApi(21)
  public Intent a()
  {
    WebChromeClient.FileChooserParams localFileChooserParams = this.a;
    if (localFileChooserParams != null) {
      return localFileChooserParams.createIntent();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.c.c
 * JD-Core Version:    0.7.0.1
 */