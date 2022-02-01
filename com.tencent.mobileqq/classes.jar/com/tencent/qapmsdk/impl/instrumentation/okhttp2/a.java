package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.h;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class a
  extends Call
{
  private g a;
  private Request b = a(paramRequest, paramOkHttpClient);
  private Call c;
  private boolean d = true;
  
  a(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    super(paramOkHttpClient, paramRequest);
    this.c = paramOkHttpClient.newCall(this.b);
  }
  
  private Request a(Request paramRequest, OkHttpClient paramOkHttpClient)
  {
    Request localRequest = paramRequest;
    if (paramRequest != null) {
      localRequest = paramRequest;
    }
    try
    {
      if (com.tencent.qapmsdk.impl.g.b.c())
      {
        if (this.a == null) {
          this.a = new g(this.d);
        }
        a(paramOkHttpClient);
        this.a.b(0);
        localRequest = paramRequest.newBuilder().build();
        d.a(this.a, localRequest);
      }
      return localRequest;
    }
    catch (Exception paramOkHttpClient) {}
    return paramRequest;
  }
  
  private g a()
  {
    if (this.a == null) {
      this.a = new g(this.d);
    }
    return this.a;
  }
  
  private void a(OkHttpClient paramOkHttpClient)
  {
    try
    {
      Iterator localIterator = paramOkHttpClient.interceptors().iterator();
      while (localIterator.hasNext()) {
        if (((Interceptor)localIterator.next() instanceof c)) {
          return;
        }
      }
      paramOkHttpClient.interceptors().add(new c());
      return;
    }
    catch (Exception paramOkHttpClient)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallExtension", "error add interceptor in ok2 ", paramOkHttpClient.getMessage() });
    }
  }
  
  private void a(Response paramResponse)
  {
    try
    {
      if (!com.tencent.qapmsdk.impl.g.b.c()) {
        return;
      }
      if (!a().f())
      {
        d.a(a(), paramResponse);
        return;
      }
    }
    catch (Exception paramResponse)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallExtension", "QAPMCallExtension checkResponse() : ", paramResponse.toString() });
    }
  }
  
  private void a(Exception paramException, Response paramResponse)
  {
    com.tencent.qapmsdk.impl.a.a.a locala;
    try
    {
      if (!com.tencent.qapmsdk.impl.g.b.c()) {
        return;
      }
      g localg = a();
      h.a(localg, paramException);
      if (localg.f()) {
        return;
      }
      locala = localg.j();
      if (locala == null) {
        return;
      }
      if (paramResponse != null) {
        localg.g(com.tencent.qapmsdk.impl.g.a.a(paramResponse.header("Content-Type")));
      }
      if (localg.h())
      {
        paramException = "";
        if (localg.k() != null) {
          paramException = localg.k();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMCallExtension", "error message:", paramException });
        if (!localg.h()) {
          return;
        }
        com.tencent.qapmsdk.impl.d.a.a(locala, paramException);
        return;
      }
    }
    catch (Exception paramException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallExtension", "QAPMCallExtension error() har an error :", paramException.toString() });
      return;
    }
    com.tencent.qapmsdk.impl.d.a.a(locala);
  }
  
  public void cancel()
  {
    this.c.cancel();
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      a().a(System.currentTimeMillis());
      this.c.enqueue(new b(paramCallback, a()));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallExtension", "add enqueue time in ok3 enqueue error:", localException.getMessage() });
      }
    }
  }
  
  public Response execute()
  {
    try
    {
      Response localResponse = this.c.execute();
      a(localResponse);
      return localResponse;
    }
    catch (IOException localIOException)
    {
      a(localIOException, null);
      throw localIOException;
    }
  }
  
  public boolean isCanceled()
  {
    return this.c.isCanceled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.a
 * JD-Core Version:    0.7.0.1
 */