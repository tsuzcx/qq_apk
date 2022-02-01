package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.h;
import com.tencent.qapmsdk.impl.instrumentation.i;
import java.io.IOException;

public class b
  implements Callback
{
  private h a;
  private Callback b;
  
  public b(Callback paramCallback, h paramh)
  {
    this.b = paramCallback;
    this.a = paramh;
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
  
  private h a()
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
    h localh;
    com.tencent.qapmsdk.impl.a.a.a locala;
    if (com.tencent.qapmsdk.impl.g.b.c())
    {
      localh = a();
      i.a(localh, paramException);
      if (!localh.f())
      {
        locala = localh.j();
        if (locala != null) {
          break label33;
        }
      }
    }
    return;
    label33:
    if (localh.h())
    {
      paramException = "";
      if (localh.k() != null) {
        paramException = localh.k();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.b
 * JD-Core Version:    0.7.0.1
 */