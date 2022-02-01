package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.g.b;
import com.tencent.qapmsdk.impl.instrumentation.a.e;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class QAPMInstrumentationHttpClient
{
  private static final String TAG = "QAPM_Impl_QAPMInstrumentationHttpClient";
  
  private static HttpRequest dispatchHttpClientRequest(HttpRequest paramHttpRequest, h paramh)
  {
    return paramHttpRequest;
  }
  
  private static HttpRequest doExec(HttpHost paramHttpHost, HttpRequest paramHttpRequest, h paramh)
  {
    return c.a(paramh, paramHttpHost, paramHttpRequest);
  }
  
  private static HttpResponse doExec(HttpResponse paramHttpResponse, h paramh)
  {
    return c.a(paramh, paramHttpResponse);
  }
  
  private static <T> ResponseHandler<? extends T> doExec(ResponseHandler<? extends T> paramResponseHandler, h paramh)
  {
    return e.a(paramResponseHandler, paramh);
  }
  
  private static HttpUriRequest doExec(HttpUriRequest paramHttpUriRequest, h paramh)
  {
    return c.a(paramh, paramHttpUriRequest);
  }
  
  @QAPMReplaceCallSite
  public static <T> T execute(HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    if (!b.c()) {
      return paramHttpClient.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "httpClient execute gather  begin !!" });
    h localh = new h();
    try
    {
      localh.b(0);
      HttpRequest localHttpRequest = dispatchHttpClientRequest(paramHttpRequest, localh);
      paramHttpRequest = localHttpRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error set transaction e:", localException.getMessage() });
    }
    try
    {
      paramHttpClient = paramHttpClient.execute(paramHttpHost, doExec(paramHttpHost, c.a(paramHttpRequest), localh), doExec(paramResponseHandler, localh));
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
    catch (ClientProtocolException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
  }
  
  @QAPMReplaceCallSite
  public static <T> T execute(HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    if (!b.c()) {
      return paramHttpClient.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "httpClient execute gather  begin !!" });
    h localh = new h();
    try
    {
      localh.b(0);
      HttpRequest localHttpRequest = dispatchHttpClientRequest(paramHttpRequest, localh);
      paramHttpRequest = localHttpRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error set transaction e:", localException.getMessage() });
    }
    try
    {
      paramHttpClient = paramHttpClient.execute(paramHttpHost, doExec(paramHttpHost, c.a(paramHttpRequest), localh), doExec(paramResponseHandler, localh), paramHttpContext);
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
    catch (ClientProtocolException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
  }
  
  @QAPMReplaceCallSite
  public static <T> T execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    if (!b.c()) {
      return paramHttpClient.execute(paramHttpUriRequest, paramResponseHandler);
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "httpClient execute gather  begin !!" });
    h localh = new h();
    try
    {
      localh.b(0);
      HttpUriRequest localHttpUriRequest = (HttpUriRequest)dispatchHttpClientRequest(paramHttpUriRequest, localh);
      paramHttpUriRequest = localHttpUriRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error set transaction e:", localException.getMessage() });
    }
    try
    {
      paramHttpClient = paramHttpClient.execute(doExec((HttpUriRequest)c.a(paramHttpUriRequest), localh), doExec(paramResponseHandler, localh));
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
    catch (ClientProtocolException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
  }
  
  @QAPMReplaceCallSite
  public static <T> T execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    if (!b.c()) {
      return paramHttpClient.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "httpClient execute gather  begin !!" });
    h localh = new h();
    try
    {
      localh.b(0);
      HttpUriRequest localHttpUriRequest = (HttpUriRequest)dispatchHttpClientRequest(paramHttpUriRequest, localh);
      paramHttpUriRequest = localHttpUriRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error set transaction e:", localException.getMessage() });
    }
    try
    {
      paramHttpClient = paramHttpClient.execute(doExec((HttpUriRequest)c.a(paramHttpUriRequest), localh), doExec(paramResponseHandler, localh), paramHttpContext);
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
    catch (ClientProtocolException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
  }
  
  @QAPMReplaceCallSite
  public static HttpResponse execute(HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    if (!b.c()) {
      return paramHttpClient.execute(paramHttpHost, paramHttpRequest);
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "httpClient execute gather  begin !!" });
    h localh = new h();
    try
    {
      localh.b(0);
      HttpRequest localHttpRequest = dispatchHttpClientRequest(paramHttpRequest, localh);
      paramHttpRequest = localHttpRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error set transaction e:", localException.getMessage() });
    }
    try
    {
      paramHttpClient = doExec(paramHttpClient.execute(paramHttpHost, doExec(paramHttpHost, c.a(paramHttpRequest), localh)), localh);
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
  }
  
  @QAPMReplaceCallSite
  public static HttpResponse execute(HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (!b.c()) {
      return paramHttpClient.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "httpClient execute gather  begin !!" });
    h localh = new h();
    try
    {
      localh.b(0);
      HttpRequest localHttpRequest = dispatchHttpClientRequest(paramHttpRequest, localh);
      paramHttpRequest = localHttpRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error set transaction e:", localException.getMessage() });
    }
    try
    {
      paramHttpClient = doExec(paramHttpClient.execute(paramHttpHost, doExec(paramHttpHost, c.a(paramHttpRequest), localh), paramHttpContext), localh);
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
  }
  
  @QAPMReplaceCallSite
  public static HttpResponse execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest)
  {
    if (!b.c()) {
      return paramHttpClient.execute(paramHttpUriRequest);
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "httpClient execute gather  begin !!" });
    h localh = new h();
    try
    {
      localh.b(0);
      HttpUriRequest localHttpUriRequest = (HttpUriRequest)dispatchHttpClientRequest(paramHttpUriRequest, localh);
      paramHttpUriRequest = localHttpUriRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error set transaction e:", localException.getMessage() });
    }
    try
    {
      paramHttpClient = doExec(paramHttpClient.execute(doExec((HttpUriRequest)c.a(paramHttpUriRequest), localh)), localh);
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
  }
  
  @QAPMReplaceCallSite
  public static HttpResponse execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    if (!b.c()) {
      return paramHttpClient.execute(paramHttpUriRequest, paramHttpContext);
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "httpClient execute gather  begin !!" });
    h localh = new h();
    try
    {
      localh.b(0);
      HttpUriRequest localHttpUriRequest = (HttpUriRequest)dispatchHttpClientRequest(paramHttpUriRequest, localh);
      paramHttpUriRequest = localHttpUriRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error set transaction e:", localException.getMessage() });
    }
    try
    {
      paramHttpClient = doExec(paramHttpClient.execute(doExec((HttpUriRequest)c.a(paramHttpUriRequest), localh), paramHttpContext), localh);
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      httpClientError(localh, paramHttpClient);
      throw paramHttpClient;
    }
  }
  
  private static void httpClientError(h paramh, Exception paramException)
  {
    try
    {
      if (!b.c()) {
        return;
      }
      if (!paramh.f())
      {
        c.a(paramh, paramException);
        com.tencent.qapmsdk.impl.a.a.a locala = paramh.j();
        if (locala == null)
        {
          Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "transactionData is null" });
          return;
        }
        if (paramh.h())
        {
          paramException = "";
          if (paramh.k() != null) {
            paramException = paramh.k();
          }
          Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error message:", paramException });
          com.tencent.qapmsdk.impl.d.a.a(locala, paramException);
          return;
        }
        com.tencent.qapmsdk.impl.d.a.a(locala);
        return;
      }
    }
    catch (Exception paramh)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMInstrumentationHttpClient", "error httpClientError e:", paramh.getMessage() });
    }
  }
  
  @QAPMReplaceCallSite
  public static DefaultHttpClient initDefaultHttpClient()
  {
    return new DefaultHttpClient();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMInstrumentationHttpClient
 * JD-Core Version:    0.7.0.1
 */