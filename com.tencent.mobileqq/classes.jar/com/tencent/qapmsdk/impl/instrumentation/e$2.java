package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.impl.instrumentation.b.c;
import com.tencent.qapmsdk.impl.instrumentation.b.d;
import javax.net.ssl.HttpsURLConnection;

class e$2
  implements d
{
  e$2(e parame, h paramh) {}
  
  public void a(c paramc)
  {
    if (!this.a.f()) {
      this.a.b(paramc.a());
    }
    e.a(this.b, paramc.b());
  }
  
  public void b(c paramc)
  {
    String str;
    long l2;
    long l1;
    if (!this.a.f())
    {
      str = e.a(this.b).getRequestProperty("content-length");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.e.2
 * JD-Core Version:    0.7.0.1
 */