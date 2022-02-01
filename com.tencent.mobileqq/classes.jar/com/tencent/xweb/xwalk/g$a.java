package com.tencent.xweb.xwalk;

import android.webkit.WebChromeClient.CustomViewCallback;
import org.xwalk.core.CustomViewCallback;

public class g$a
  implements WebChromeClient.CustomViewCallback
{
  CustomViewCallback a;
  
  g$a(CustomViewCallback paramCustomViewCallback)
  {
    this.a = paramCustomViewCallback;
  }
  
  public CustomViewCallback a()
  {
    return this.a;
  }
  
  public void onCustomViewHidden()
  {
    this.a.onCustomViewHidden();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.a
 * JD-Core Version:    0.7.0.1
 */