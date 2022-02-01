package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class WebSoService$2
  implements WebSoService.CallBack
{
  WebSoService$2(WebSoService paramWebSoService, long paramLong, WebSoService.WebSoState paramWebSoState, Handler paramHandler) {}
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verifyHtmlData cost=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.a);
      QLog.d("WebSoService", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.b;
      if ((localObject != null) && (((WebSoService.WebSoState)localObject).f.get() != 2))
      {
        this.b.q.n = true;
        localObject = this.b;
        ((WebSoService.WebSoState)localObject).b = paramString;
        ((WebSoService.WebSoState)localObject).e = true;
        ((WebSoService.WebSoState)localObject).l = true;
        ((WebSoService.WebSoState)localObject).k = false;
        WebSoUtils.m("load from cache");
        WebSoService.a(this.d, this.c, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.2
 * JD-Core Version:    0.7.0.1
 */