package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.h;
import java.io.IOException;

public class b
  implements Callback
{
  private g a;
  private Callback b;
  
  public b(Callback paramCallback, g paramg)
  {
    this.b = paramCallback;
    this.a = paramg;
  }
  
  private int a(Response paramResponse, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramResponse.header("X-QAPM-Qt"));
      return (int)(l - paramLong);
    }
    catch (Exception paramResponse)
    {
      Logger.INSTANCE.e(new String[] { "getQueueTime error:" + paramResponse.getMessage() });
    }
    return 0;
  }
  
  private g a()
  {
    return this.a;
  }
  
  private void a(Response paramResponse)
  {
    if ((com.tencent.qapmsdk.impl.g.b.c()) && (!a().f()))
    {
      a().a(a(paramResponse, a().a()));
      d.a(a(), paramResponse);
    }
  }
  
  private void a(Exception paramException)
  {
    g localg;
    com.tencent.qapmsdk.impl.a.a.a locala;
    if (com.tencent.qapmsdk.impl.g.b.c())
    {
      localg = a();
      h.a(localg, paramException);
      if (!localg.f())
      {
        locala = localg.j();
        if (locala != null) {
          break label33;
        }
      }
    }
    return;
    label33:
    if (localg.h())
    {
      paramException = "";
      if (localg.k() != null) {
        paramException = localg.k();
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMCallbackExtension", "error message:", paramException });
      com.tencent.qapmsdk.impl.d.a.a(locala, paramException);
      return;
    }
    com.tencent.qapmsdk.impl.d.a.a(locala);
  }
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    try
    {
      a(paramIOException);
      this.b.onFailure(paramRequest, paramIOException);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallbackExtension", "QAPMCallbackExtension onFailure : ", localException.toString() });
      }
    }
  }
  
  public void onResponse(Response paramResponse)
  {
    try
    {
      a(paramResponse);
      this.b.onResponse(paramResponse);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallbackExtension", "QAPMCallbackExtension onResponse ", localException.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.b
 * JD-Core Version:    0.7.0.1
 */