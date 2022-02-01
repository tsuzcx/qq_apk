package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.impl.instrumentation.b.d;
import java.io.IOException;
import java.net.HttpURLConnection;

class c$3
  implements d
{
  c$3(c paramc) {}
  
  public void a(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    g localg = c.c(this.a);
    if (!localg.f()) {
      localg.b(paramc.a());
    }
    try
    {
      localg.c(c.a(this.a).getResponseCode());
      label37:
      c.a(this.a, paramc.b());
      return;
    }
    catch (IOException localIOException)
    {
      break label37;
    }
  }
  
  public void b(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    g localg = c.c(this.a);
    String str;
    long l2;
    long l1;
    if (!localg.f())
    {
      str = c.a(this.a).getRequestProperty("content-length");
      l2 = paramc.a();
      l1 = l2;
      if (str == null) {}
    }
    try
    {
      l1 = Long.parseLong(str);
      localg.c(l1);
      return;
    }
    catch (NumberFormatException paramc)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.c.3
 * JD-Core Version:    0.7.0.1
 */