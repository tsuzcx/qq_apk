package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.impl.instrumentation.b.c;
import com.tencent.qapmsdk.impl.instrumentation.b.d;
import java.io.IOException;
import javax.net.ssl.HttpsURLConnection;

class e$1
  implements d
{
  e$1(e parame, h paramh) {}
  
  public void a(c paramc)
  {
    try
    {
      int i = e.a(this.b).getResponseCode();
      this.a.c(i);
      label19:
      if (!this.a.f()) {
        this.a.d(paramc.a());
      }
      e.a(this.b, paramc.b());
      return;
    }
    catch (IOException localIOException)
    {
      break label19;
    }
  }
  
  public void b(c paramc)
  {
    int i;
    if (!this.a.f()) {
      i = 0;
    }
    try
    {
      int j = e.a(this.b).getResponseCode();
      i = j;
      this.a.c(j);
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
      l2 = e.a(this.b).getContentLength();
      if (l2 >= 0L) {
        l1 = l2;
      }
      for (;;)
      {
        this.a.d(l1);
        e.a(this.b, this.a);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.e.1
 * JD-Core Version:    0.7.0.1
 */