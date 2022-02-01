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
      label35:
      long l2;
      long l1;
      long l3;
      break label35;
    }
    l2 = paramc.a();
    l1 = l2;
    if (i != 206)
    {
      l3 = e.a(this.b).getContentLength();
      l1 = l2;
      if (l3 >= 0L) {
        l1 = l3;
      }
    }
    this.a.d(l1);
    e.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.e.1
 * JD-Core Version:    0.7.0.1
 */