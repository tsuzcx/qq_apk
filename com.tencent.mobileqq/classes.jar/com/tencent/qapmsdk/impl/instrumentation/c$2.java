package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.b.d;
import java.io.IOException;
import java.net.HttpURLConnection;

class c$2
  implements d
{
  c$2(c paramc) {}
  
  public void a(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "streamError:", paramc.toString() });
    if (!c.b(this.a).f()) {
      c.b(this.a).d(paramc.a());
    }
    c.a(this.a, paramc.b());
  }
  
  public void b(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    int i;
    if (!c.b(this.a).f()) {
      i = 0;
    }
    try
    {
      int j = c.a(this.a).getResponseCode();
      i = j;
      c.b(this.a).c(j);
      i = j;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        long l1;
        long l2;
      }
    }
    l1 = paramc.a();
    if (i != 206)
    {
      l2 = c.a(this.a).getContentLength();
      if (l2 >= 0L) {
        l1 = l2;
      }
      for (;;)
      {
        c.b(this.a).d(l1);
        c.a(this.a, c.b(this.a));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.c.2
 * JD-Core Version:    0.7.0.1
 */