package com.tencent.mobileqq.webview.webso;

import android.support.v4.util.LruCache;

class WebSoService$1
  extends LruCache<String, WebSoService.WebSoState>
{
  WebSoService$1(WebSoService paramWebSoService, int paramInt)
  {
    super(paramInt);
  }
  
  protected WebSoService.WebSoState a(String paramString)
  {
    return new WebSoService.WebSoState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.1
 * JD-Core Version:    0.7.0.1
 */