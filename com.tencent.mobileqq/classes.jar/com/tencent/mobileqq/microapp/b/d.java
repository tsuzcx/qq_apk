package com.tencent.mobileqq.microapp.b;

import bdje;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
  implements Runnable
{
  public AtomicBoolean a = new AtomicBoolean(false);
  private c b;
  private d.a c;
  
  public d(d.a parama)
  {
    this.c = parama;
    this.b = new c();
    this.b.a = this.c.i;
  }
  
  public void run()
  {
    String[] arrayOfString;
    e locale;
    if ((this.c != null) && (this.c.a()))
    {
      if (!bdje.a(this.c.f))
      {
        if (this.c.d == null) {
          this.c.d = new HashMap();
        }
        if ("json".equals(this.c.f)) {
          this.c.d.put("content-type", "application/json");
        }
      }
      arrayOfString = a.a(this.c.d);
      locale = new e(this);
      localObject = this.c.e.toUpperCase();
      if (((String)localObject).equals("GET")) {
        a.a(this.c.b, arrayOfString, locale, this.b);
      }
    }
    else
    {
      return;
    }
    if (((String)localObject).equals("POST"))
    {
      a.a(this.c.b, this.c.c, arrayOfString, locale, this.b);
      return;
    }
    String str1 = this.c.e;
    String str2 = this.c.b;
    if (this.c.c == null) {}
    for (Object localObject = new byte[1];; localObject = this.c.c.getBytes())
    {
      a.a(str1, str2, (byte[])localObject, arrayOfString, locale, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b.d
 * JD-Core Version:    0.7.0.1
 */