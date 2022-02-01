package com.tencent.xweb.sys;

import android.webkit.HttpAuthHandler;
import com.tencent.xweb.h;

public class c$b
  implements h
{
  HttpAuthHandler a;
  
  public c$b(HttpAuthHandler paramHttpAuthHandler)
  {
    this.a = paramHttpAuthHandler;
  }
  
  public void a()
  {
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.c.b
 * JD-Core Version:    0.7.0.1
 */