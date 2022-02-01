package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.impl.instrumentation.b.c;
import javax.net.ssl.HttpsURLConnection;

class d$2
  implements com.tencent.qapmsdk.impl.instrumentation.b.d
{
  d$2(d paramd, g paramg) {}
  
  public void a(c paramc)
  {
    if (!this.a.f()) {
      this.a.b(paramc.a());
    }
    d.a(this.b, paramc.b());
  }
  
  public void b(c paramc)
  {
    String str;
    long l2;
    long l1;
    if (!this.a.f())
    {
      str = d.a(this.b).getRequestProperty("content-length");
      l2 = paramc.a();
      l1 = l2;
      if (str == null) {}
    }
    try
    {
      l1 = Long.parseLong(str);
      this.a.b(l1);
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
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.d.2
 * JD-Core Version:    0.7.0.1
 */