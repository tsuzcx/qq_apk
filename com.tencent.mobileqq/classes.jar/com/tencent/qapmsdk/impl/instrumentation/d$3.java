package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.impl.instrumentation.b.c;
import java.io.IOException;
import java.net.HttpURLConnection;

class d$3
  implements com.tencent.qapmsdk.impl.instrumentation.b.d
{
  d$3(d paramd) {}
  
  public void a(c paramc)
  {
    h localh = d.c(this.a);
    if (!localh.f()) {
      localh.b(paramc.a());
    }
    try
    {
      localh.c(d.a(this.a).getResponseCode());
      label37:
      d.a(this.a, paramc.b());
      return;
    }
    catch (IOException localIOException)
    {
      break label37;
    }
  }
  
  public void b(c paramc)
  {
    h localh = d.c(this.a);
    String str;
    long l2;
    long l1;
    if (!localh.f())
    {
      str = d.a(this.a).getRequestProperty("content-length");
      l2 = paramc.a();
      l1 = l2;
      if (str == null) {}
    }
    try
    {
      l1 = Long.parseLong(str);
      localh.c(l1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.d.3
 * JD-Core Version:    0.7.0.1
 */