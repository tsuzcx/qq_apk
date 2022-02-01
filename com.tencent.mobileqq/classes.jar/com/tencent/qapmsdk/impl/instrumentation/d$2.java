package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.b.c;
import java.io.IOException;
import java.net.HttpURLConnection;

class d$2
  implements com.tencent.qapmsdk.impl.instrumentation.b.d
{
  d$2(d paramd) {}
  
  public void a(c paramc)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "streamError:", paramc.toString() });
    if (!d.b(this.a).f()) {
      d.b(this.a).d(paramc.a());
    }
    d.a(this.a, paramc.b());
  }
  
  public void b(c paramc)
  {
    int i;
    if (!d.b(this.a).f()) {
      i = 0;
    }
    try
    {
      int j = d.a(this.a).getResponseCode();
      i = j;
      d.b(this.a).c(j);
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
      l2 = d.a(this.a).getContentLength();
      if (l2 >= 0L) {
        l1 = l2;
      }
      for (;;)
      {
        d.b(this.a).d(l1);
        d.a(this.a, d.b(this.a));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.d.2
 * JD-Core Version:    0.7.0.1
 */