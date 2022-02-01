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
      Logger localLogger = Logger.INSTANCE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQueueTime error:");
      localStringBuilder.append(paramResponse.getMessage());
      localLogger.e(new String[] { localStringBuilder.toString() });
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
    if (com.tencent.qapmsdk.impl.g.b.c())
    {
      h localh = a();
      i.a(localh, paramException);
      if (!localh.f())
      {
        com.tencent.qapmsdk.impl.a.a.a locala = localh.j();
        if (locala == null) {
          return;
        }
        if (localh.h())
        {
          if (localh.k() != null) {
            paramException = localh.k();
          } else {
            paramException = "";
          }
          Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMCallbackExtension", "error message:", paramException });
          com.tencent.qapmsdk.impl.d.a.a(locala, paramException);
          return;
        }
        com.tencent.qapmsdk.impl.d.a.a(locala);
      }
    }
  }
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    try
    {
      a(paramIOException);
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallbackExtension", "QAPMCallbackExtension onFailure : ", localException.toString() });
    }
    this.b.onFailure(paramRequest, paramIOException);
  }
  
  public void onResponse(Response paramResponse)
  {
    try
    {
      a(paramResponse);
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallbackExtension", "QAPMCallbackExtension onResponse ", localException.toString() });
    }
    this.b.onResponse(paramResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.b
 * JD-Core Version:    0.7.0.1
 */