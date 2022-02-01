package com.tencent.xweb.sys;

import android.webkit.SslErrorHandler;
import com.tencent.xweb.o;

public class c$a
  implements o
{
  SslErrorHandler a;
  
  public c$a(SslErrorHandler paramSslErrorHandler)
  {
    this.a = paramSslErrorHandler;
  }
  
  public void a()
  {
    this.a.proceed();
  }
  
  public void b()
  {
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.c.a
 * JD-Core Version:    0.7.0.1
 */