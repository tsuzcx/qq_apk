package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.b.c;
import java.io.IOException;
import java.net.HttpURLConnection;

class d$1
  implements com.tencent.qapmsdk.impl.instrumentation.b.d
{
  d$1(d paramd, h paramh) {}
  
  public void a(c paramc)
  {
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "streamError:", paramc.toString() });
    if (!this.a.f()) {
      this.a.d(paramc.a());
    }
    try
    {
      int i = d.a(this.b).getResponseCode();
      this.a.c(i);
      label67:
      d.a(this.b, paramc.b());
      return;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public void b(c paramc)
  {
    if (!this.a.f())
    {
      long l1 = d.a(this.b).getContentLength();
      long l2 = paramc.a();
      if (l1 < 0L) {
        l1 = l2;
      }
      this.a.d(l1);
    }
    try
    {
      int i = d.a(this.b).getResponseCode();
      this.a.c(i);
      label67:
      d.a(this.b, this.a);
      return;
    }
    catch (IOException paramc)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.d.1
 * JD-Core Version:    0.7.0.1
 */