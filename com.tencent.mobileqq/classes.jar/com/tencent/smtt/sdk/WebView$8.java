package com.tencent.smtt.sdk;

class WebView$8
  extends Thread
{
  WebView$8(WebView paramWebView, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    try
    {
      this.this$0.tbsOnDetachedFromWindow();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.8
 * JD-Core Version:    0.7.0.1
 */