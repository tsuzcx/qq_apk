package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;

class WebSoService$4
  implements Runnable
{
  WebSoService$4(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, String paramString, Handler paramHandler) {}
  
  public void run()
  {
    this.a.b = WebSoUtils.h(this.b);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("读取缓存:");
    ((StringBuilder)localObject).append(this.a.b);
    WebSoUtils.m(((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(this.a.b)) {
      return;
    }
    localObject = this.a;
    ((WebSoService.WebSoState)localObject).l = true;
    ((WebSoService.WebSoState)localObject).e = true;
    WebSoService.a(this.this$0, this.c, (WebSoService.WebSoState)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.4
 * JD-Core Version:    0.7.0.1
 */