package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.instrumentation.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.HttpEntityWrapper;

public class b
{
  public static Map<String, Object> a(HttpResponse paramHttpResponse)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramHttpResponse != null)
    {
      paramHttpResponse = paramHttpResponse.getAllHeaders();
      if (paramHttpResponse != null)
      {
        int i = 0;
        while (i < paramHttpResponse.length)
        {
          Object localObject = paramHttpResponse[i];
          localTreeMap.put(localObject.getName(), localObject.getValue());
          i += 1;
        }
      }
    }
    return localTreeMap;
  }
  
  public static HttpRequest a(g paramg, HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    Object localObject = null;
    if (paramHttpRequest == null) {
      return paramHttpRequest;
    }
    paramHttpHost = paramHttpRequest.getRequestLine();
    if (paramHttpHost != null)
    {
      paramHttpHost = paramHttpHost.getUri();
      if (paramHttpHost.contains("?"))
      {
        int i = paramHttpHost.indexOf("?");
        localObject = paramHttpHost.substring(0, i);
        String str = paramHttpHost.substring(i + 1);
        paramHttpHost = (HttpHost)localObject;
        localObject = str;
      }
    }
    for (;;)
    {
      paramg.f(paramHttpHost);
      paramg.b((String)localObject);
      paramg.a((String)localObject);
      paramg.a(com.tencent.qapmsdk.impl.b.b.c);
      a(paramg, paramHttpRequest, (String)localObject);
      paramg.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      b(paramg, paramHttpRequest);
      return paramHttpRequest;
      continue;
      paramHttpHost = null;
    }
  }
  
  public static HttpRequest a(HttpRequest paramHttpRequest)
  {
    return paramHttpRequest;
  }
  
  public static HttpResponse a(g paramg, HttpResponse paramHttpResponse)
  {
    try
    {
      paramg.c(paramHttpResponse.getStatusLine().getStatusCode());
      Object localObject = paramHttpResponse.getHeaders("Content-Type");
      if ((localObject != null) && (localObject.length > 0)) {
        paramg.g(com.tencent.qapmsdk.impl.g.a.a(localObject[0].getValue()));
      }
      localObject = paramHttpResponse.getHeaders("Content-Length");
      if (localObject == null) {
        break label222;
      }
      int i = localObject.length;
      if (i <= 0) {
        break label222;
      }
      long l;
      try
      {
        l = Long.parseLong(localObject[0].getValue());
        paramg.d(l);
        localObject = paramHttpResponse.getEntity();
        if (localObject == null)
        {
          paramHttpResponse.setEntity((HttpEntity)null);
          return paramHttpResponse;
        }
        if ((localObject instanceof HttpEntityWrapper))
        {
          paramHttpResponse.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.d(paramHttpResponse, paramg, l));
          return paramHttpResponse;
        }
      }
      catch (NumberFormatException paramg)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "Failed to parse content length: ", paramg.toString() });
        return paramHttpResponse;
      }
      paramHttpResponse.setEntity(new c(paramHttpResponse, paramg, l));
    }
    catch (Exception paramg)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpClientUtil", " java.lang.NoSuchMethodError: org.apache.http.HttpResponse.getHeaders", paramg.toString() });
      return paramHttpResponse;
    }
    return paramHttpResponse;
    label222:
    if (paramHttpResponse.getEntity() != null)
    {
      if ((paramHttpResponse.getEntity() instanceof HttpEntityWrapper))
      {
        paramHttpResponse.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.d(paramHttpResponse, paramg, -1L));
        return paramHttpResponse;
      }
      paramHttpResponse.setEntity(new c(paramHttpResponse, paramg, -1L));
      return paramHttpResponse;
    }
    paramg.d(0L);
    b(paramg, (HttpResponse)null);
    return paramHttpResponse;
  }
  
  public static HttpUriRequest a(g paramg, HttpUriRequest paramHttpUriRequest)
  {
    if (paramHttpUriRequest == null) {
      return paramHttpUriRequest;
    }
    Object localObject1 = paramHttpUriRequest.getRequestLine();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((RequestLine)localObject1).getUri();
      if (!((String)localObject1).contains("?")) {
        break label138;
      }
      int i = ((String)localObject1).indexOf("?");
      localObject2 = ((String)localObject1).substring(0, i);
      String str = ((String)localObject1).substring(i + 1);
      localObject1 = localObject2;
      localObject2 = str;
    }
    label138:
    for (;;)
    {
      paramg.f((String)localObject1);
      paramg.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      paramg.e(paramHttpUriRequest.getMethod());
      paramg.b((String)localObject2);
      paramg.a((String)localObject2);
      paramg.a(com.tencent.qapmsdk.impl.b.b.c);
      a(paramg, paramHttpUriRequest, (String)localObject2);
      b(paramg, paramHttpUriRequest);
      return paramHttpUriRequest;
      localObject1 = paramHttpUriRequest.getURI().toString();
    }
  }
  
  public static void a(g paramg, Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      if (h.a(paramException))
      {
        paramg.a(911, paramException.toString());
        paramg.c(911);
        return;
      }
      String str = paramException.getMessage();
      if ((str != null) && (str.contains("ftruncate failed: ENOENT (No such file or directory)")))
      {
        paramg.a(917, paramException.toString());
        paramg.c(917);
        return;
      }
    }
    if ((paramException instanceof UnknownHostException))
    {
      paramg.a(901, paramException.toString());
      paramg.c(901);
      return;
    }
    if ((!(paramException instanceof SocketTimeoutException)) && (!(paramException instanceof ConnectTimeoutException)))
    {
      if ((paramException instanceof ConnectException))
      {
        paramg.a(902, paramException.toString());
        paramg.c(902);
        return;
      }
      if ((paramException instanceof MalformedURLException))
      {
        paramg.a(900, paramException.toString());
        paramg.c(900);
        return;
      }
      if ((paramException instanceof SSLException))
      {
        paramg.a(908, paramException.toString());
        paramg.c(908);
        return;
      }
      if ((paramException instanceof HttpResponseException))
      {
        paramg.c(((HttpResponseException)paramException).getStatusCode());
        return;
      }
      if ((paramException instanceof ClientProtocolException))
      {
        paramg.a(904, paramException.toString());
        paramg.c(904);
        return;
      }
      if ((paramException instanceof AuthenticationException))
      {
        paramg.a(907, paramException.toString());
        paramg.c(907);
        return;
      }
      paramg.a(-1, paramException.toString());
      paramg.c(-1);
      return;
    }
    paramg.a(903, paramException.toString());
    paramg.c(903);
  }
  
  public static void a(g paramg, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof HttpOptions))
    {
      paramg.a(com.tencent.qapmsdk.impl.b.d.g);
      return;
    }
    if ((paramHttpRequest instanceof HttpGet))
    {
      paramg.a(com.tencent.qapmsdk.impl.b.d.a);
      return;
    }
    if ((paramHttpRequest instanceof HttpHead))
    {
      paramg.a(com.tencent.qapmsdk.impl.b.d.e);
      return;
    }
    if ((paramHttpRequest instanceof HttpPost))
    {
      paramg.a(com.tencent.qapmsdk.impl.b.d.b);
      return;
    }
    if ((paramHttpRequest instanceof HttpPut))
    {
      paramg.a(com.tencent.qapmsdk.impl.b.d.c);
      return;
    }
    if ((paramHttpRequest instanceof HttpDelete))
    {
      paramg.a(com.tencent.qapmsdk.impl.b.d.d);
      return;
    }
    if ((paramHttpRequest instanceof HttpTrace))
    {
      paramg.a(com.tencent.qapmsdk.impl.b.d.f);
      return;
    }
    paramg.a(com.tencent.qapmsdk.impl.b.d.a);
  }
  
  private static void a(g paramg, HttpRequest paramHttpRequest, String paramString)
  {
    a(paramg, paramHttpRequest);
    h.b(paramg, paramg.b());
    paramHttpRequest = new b.1(paramHttpRequest);
    h.a(paramg.d(), paramHttpRequest, paramg);
  }
  
  private static void b(g paramg, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest))
    {
      paramHttpRequest = (HttpEntityEnclosingRequest)paramHttpRequest;
      if (paramHttpRequest.getEntity() != null) {
        paramHttpRequest.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.b(paramHttpRequest.getEntity(), paramg));
      }
    }
  }
  
  private static void b(g paramg, HttpResponse paramHttpResponse)
  {
    if (com.tencent.qapmsdk.impl.g.b.c())
    {
      com.tencent.qapmsdk.impl.a.a.a locala;
      InputStream localInputStream1;
      Object localObject1;
      for (;;)
      {
        InputStream localInputStream2;
        try
        {
          locala = paramg.j();
          if (locala == null)
          {
            Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "HttpResponseEntityWrapperImpl transactionData is null!" });
            return;
          }
          if (!paramg.h()) {
            break label426;
          }
          localStringBuilder = new StringBuilder();
          if (paramHttpResponse != null)
          {
            localObject3 = null;
            localObject4 = null;
            localInputStream2 = null;
            localInputStream1 = localInputStream2;
            localObject2 = localObject3;
            localObject1 = localObject4;
          }
        }
        catch (Exception paramg)
        {
          StringBuilder localStringBuilder;
          Object localObject3;
          Object localObject4;
          Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpClientUtil", "addTransactionAndErrorData", paramg);
          return;
        }
        try
        {
          if (!(paramHttpResponse.getEntity() instanceof com.tencent.qapmsdk.impl.instrumentation.a.b))
          {
            localInputStream1 = localInputStream2;
            localObject2 = localObject3;
            localObject1 = localObject4;
            paramHttpResponse.setEntity(new com.tencent.qapmsdk.impl.instrumentation.a.a(paramHttpResponse.getEntity()));
          }
          localInputStream1 = localInputStream2;
          localObject2 = localObject3;
          localObject1 = localObject4;
          localInputStream2 = paramHttpResponse.getEntity().getContent();
          localInputStream1 = localInputStream2;
          localObject2 = localInputStream2;
          localObject1 = localInputStream2;
          if (!(localInputStream2 instanceof com.tencent.qapmsdk.impl.instrumentation.b.a)) {
            break label304;
          }
          localInputStream1 = localInputStream2;
          localObject2 = localInputStream2;
          localObject1 = localInputStream2;
          localStringBuilder.append(((com.tencent.qapmsdk.impl.instrumentation.b.a)localInputStream2).b());
          if (localInputStream2 != null) {
            localInputStream2.close();
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localObject1 = localInputStream1;
          Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpClientUtil", localIllegalStateException.toString() });
          if (localInputStream1 == null) {
            continue;
          }
          localInputStream1.close();
          continue;
        }
        catch (IOException localIOException)
        {
          localObject1 = localIllegalStateException;
          Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpClientUtil", localIOException.toString() });
          if (localIllegalStateException == null) {
            continue;
          }
          localIllegalStateException.close();
          continue;
        }
        finally
        {
          if (localObject1 == null) {
            break;
          }
          ((InputStream)localObject1).close();
        }
        a(paramHttpResponse).put("Content-Length", Long.valueOf(paramg.i()));
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "response body content:", localStringBuilder.toString() });
        paramHttpResponse = "";
        if (paramg.k() != null) {
          paramHttpResponse = paramg.k();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "error message:", paramHttpResponse });
        com.tencent.qapmsdk.impl.d.a.a(locala, paramHttpResponse);
        return;
        label304:
        localInputStream1 = localInputStream2;
        Object localObject2 = localInputStream2;
        localObject1 = localInputStream2;
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "Unable to wrap content stream for entity" });
      }
      label426:
      com.tencent.qapmsdk.impl.d.a.a(locala);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.b
 * JD-Core Version:    0.7.0.1
 */