package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.b.d;
import java.io.IOException;
import java.net.HttpURLConnection;

class c$1
  implements d
{
  c$1(c paramc, g paramg) {}
  
  public void a(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "streamError:", paramc.toString() });
    if (!this.a.f()) {
      this.a.d(paramc.a());
    }
    try
    {
      int i = c.a(this.b).getResponseCode();
      this.a.c(i);
      label67:
      c.a(this.b, paramc.b());
      return;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public void b(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    long l1;
    long l2;
    if (!this.a.f())
    {
      l1 = c.a(this.b).getContentLength();
      l2 = paramc.a();
      if (l1 < 0L) {
        break label77;
      }
    }
    for (;;)
    {
      this.a.d(l1);
      try
      {
        int i = c.a(this.b).getResponseCode();
        this.a.c(i);
        label61:
        c.a(this.b, this.a);
        return;
      }
      catch (IOException paramc)
      {
        break label61;
      }
      label77:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.c.1
 * JD-Core Version:    0.7.0.1
 */