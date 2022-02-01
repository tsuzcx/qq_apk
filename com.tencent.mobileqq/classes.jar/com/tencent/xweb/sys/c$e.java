package com.tencent.xweb.sys;

public class c$e
  extends com.tencent.xweb.JsResult
{
  public android.webkit.JsResult a;
  
  public c$e(android.webkit.JsResult paramJsResult)
  {
    this.a = paramJsResult;
  }
  
  public void cancel()
  {
    android.webkit.JsResult localJsResult = this.a;
    if (localJsResult != null) {
      localJsResult.cancel();
    }
  }
  
  public void confirm()
  {
    android.webkit.JsResult localJsResult = this.a;
    if (localJsResult != null) {
      localJsResult.confirm();
    }
  }
  
  public void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.c.e
 * JD-Core Version:    0.7.0.1
 */