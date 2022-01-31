package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.api.data.TransactionData;
import com.tencent.qapmsdk.impl.harvest.HttpLibType;
import com.tencent.qapmsdk.impl.harvest.RequestMethodType;
import com.tencent.qapmsdk.impl.instrumentation.httpclient.QAPMContentBufferingResponseEntityImpl;
import com.tencent.qapmsdk.impl.instrumentation.httpclient.QAPMHttpRequestEntityImpl;
import com.tencent.qapmsdk.impl.instrumentation.httpclient.QAPMHttpResponseEntityImpl;
import com.tencent.qapmsdk.impl.instrumentation.httpclient.QAPMHttpResponseEntityWrapperImpl;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMCountingInputStream;
import com.tencent.qapmsdk.impl.model.HttpDataModel;
import com.tencent.qapmsdk.impl.util.StringUtil;
import com.tencent.qapmsdk.impl.util.TraceUtil;
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

public class QAPMHttpClientUtil
{
  private static final String TAG = "QAPM_Impl_QAPMHttpClientUtil";
  
  private static void addTransactionAndErrorData(QAPMTransactionState paramQAPMTransactionState, HttpResponse paramHttpResponse)
  {
    if (TraceUtil.getCanMonitorHttp())
    {
      TransactionData localTransactionData;
      InputStream localInputStream1;
      Object localObject1;
      for (;;)
      {
        InputStream localInputStream2;
        try
        {
          localTransactionData = paramQAPMTransactionState.end();
          if (localTransactionData == null)
          {
            Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "HttpResponseEntityWrapperImpl transactionData is null!" });
            return;
          }
          if (!paramQAPMTransactionState.isError()) {
            break label420;
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
        catch (Exception paramQAPMTransactionState)
        {
          StringBuilder localStringBuilder;
          Object localObject3;
          Object localObject4;
          Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpClientUtil", "addTransactionAndErrorData", paramQAPMTransactionState);
          return;
        }
        try
        {
          if (!(paramHttpResponse.getEntity() instanceof QAPMHttpRequestEntityImpl))
          {
            localInputStream1 = localInputStream2;
            localObject2 = localObject3;
            localObject1 = localObject4;
            paramHttpResponse.setEntity(new QAPMContentBufferingResponseEntityImpl(paramHttpResponse.getEntity()));
          }
          localInputStream1 = localInputStream2;
          localObject2 = localObject3;
          localObject1 = localObject4;
          localInputStream2 = paramHttpResponse.getEntity().getContent();
          localInputStream1 = localInputStream2;
          localObject2 = localInputStream2;
          localObject1 = localInputStream2;
          if (!(localInputStream2 instanceof QAPMCountingInputStream)) {
            break label299;
          }
          localInputStream1 = localInputStream2;
          localObject2 = localInputStream2;
          localObject1 = localInputStream2;
          localStringBuilder.append(((QAPMCountingInputStream)localInputStream2).getBufferAsString());
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
        resolvingResponseHeader(paramHttpResponse).put("Content-Length", Long.valueOf(paramQAPMTransactionState.getBytesReceived()));
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "response body content:", localStringBuilder.toString() });
        paramHttpResponse = "";
        if (paramQAPMTransactionState.getException() != null) {
          paramHttpResponse = paramQAPMTransactionState.getException();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "error message:", paramHttpResponse });
        HttpDataModel.collectData(localTransactionData, paramHttpResponse);
        return;
        label299:
        localInputStream1 = localInputStream2;
        Object localObject2 = localInputStream2;
        localObject1 = localInputStream2;
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "Unable to wrap content stream for entity" });
      }
      label420:
      HttpDataModel.collectData(localTransactionData);
    }
  }
  
  public static void getHttpClientRequest(QAPMTransactionState paramQAPMTransactionState, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof HttpOptions))
    {
      paramQAPMTransactionState.setRequestMethod(RequestMethodType.OPTIONS);
      return;
    }
    if ((paramHttpRequest instanceof HttpGet))
    {
      paramQAPMTransactionState.setRequestMethod(RequestMethodType.GET);
      return;
    }
    if ((paramHttpRequest instanceof HttpHead))
    {
      paramQAPMTransactionState.setRequestMethod(RequestMethodType.HEAD);
      return;
    }
    if ((paramHttpRequest instanceof HttpPost))
    {
      paramQAPMTransactionState.setRequestMethod(RequestMethodType.POST);
      return;
    }
    if ((paramHttpRequest instanceof HttpPut))
    {
      paramQAPMTransactionState.setRequestMethod(RequestMethodType.PUT);
      return;
    }
    if ((paramHttpRequest instanceof HttpDelete))
    {
      paramQAPMTransactionState.setRequestMethod(RequestMethodType.DELETE);
      return;
    }
    if ((paramHttpRequest instanceof HttpTrace))
    {
      paramQAPMTransactionState.setRequestMethod(RequestMethodType.TRACE);
      return;
    }
    paramQAPMTransactionState.setRequestMethod(RequestMethodType.GET);
  }
  
  public static HttpRequest inspectAndInstrument(QAPMTransactionState paramQAPMTransactionState, HttpHost paramHttpHost, HttpRequest paramHttpRequest)
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
      paramQAPMTransactionState.setUrl(paramHttpHost);
      paramQAPMTransactionState.setUrlParams((String)localObject);
      paramQAPMTransactionState.setAllGetRequestParams((String)localObject);
      paramQAPMTransactionState.setHttpLibType(HttpLibType.HttpClient);
      processParamsAndHeader(paramQAPMTransactionState, paramHttpRequest, (String)localObject);
      paramQAPMTransactionState.setCarrier(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      wrapRequestEntity(paramQAPMTransactionState, paramHttpRequest);
      return paramHttpRequest;
      continue;
      paramHttpHost = null;
    }
  }
  
  public static HttpResponse inspectAndInstrument(QAPMTransactionState paramQAPMTransactionState, HttpResponse paramHttpResponse)
  {
    try
    {
      paramQAPMTransactionState.setStatusCode(paramHttpResponse.getStatusLine().getStatusCode());
      Object localObject = paramHttpResponse.getHeaders("Content-Type");
      if ((localObject != null) && (localObject.length > 0)) {
        paramQAPMTransactionState.setContentType(StringUtil.contentType(localObject[0].getValue()));
      }
      localObject = paramHttpResponse.getHeaders("Content-Length");
      if (localObject == null) {
        break label225;
      }
      int i = localObject.length;
      if (i <= 0) {
        break label225;
      }
      long l;
      try
      {
        l = Long.parseLong(localObject[0].getValue());
        paramQAPMTransactionState.setBytesReceived(l);
        localObject = paramHttpResponse.getEntity();
        if (localObject == null)
        {
          paramHttpResponse.setEntity((HttpEntity)null);
          return paramHttpResponse;
        }
        if ((localObject instanceof HttpEntityWrapper))
        {
          paramHttpResponse.setEntity(new QAPMHttpResponseEntityWrapperImpl(paramHttpResponse, paramQAPMTransactionState, l));
          return paramHttpResponse;
        }
      }
      catch (NumberFormatException paramQAPMTransactionState)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpClientUtil", "Failed to parse content length: ", paramQAPMTransactionState.toString() });
        return paramHttpResponse;
      }
      paramHttpResponse.setEntity(new QAPMHttpResponseEntityImpl(paramHttpResponse, paramQAPMTransactionState, l));
    }
    catch (Exception paramQAPMTransactionState)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpClientUtil", " java.lang.NoSuchMethodError: org.apache.http.HttpResponse.getHeaders", paramQAPMTransactionState.toString() });
      return paramHttpResponse;
    }
    return paramHttpResponse;
    label225:
    if (paramHttpResponse.getEntity() != null)
    {
      if ((paramHttpResponse.getEntity() instanceof HttpEntityWrapper))
      {
        paramHttpResponse.setEntity(new QAPMHttpResponseEntityWrapperImpl(paramHttpResponse, paramQAPMTransactionState, -1L));
        return paramHttpResponse;
      }
      paramHttpResponse.setEntity(new QAPMHttpResponseEntityImpl(paramHttpResponse, paramQAPMTransactionState, -1L));
      return paramHttpResponse;
    }
    paramQAPMTransactionState.setBytesReceived(0L);
    addTransactionAndErrorData(paramQAPMTransactionState, (HttpResponse)null);
    return paramHttpResponse;
  }
  
  public static HttpUriRequest inspectAndInstrument(QAPMTransactionState paramQAPMTransactionState, HttpUriRequest paramHttpUriRequest)
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
      paramQAPMTransactionState.setUrl((String)localObject1);
      paramQAPMTransactionState.setCarrier(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      paramQAPMTransactionState.setMethodType(paramHttpUriRequest.getMethod());
      paramQAPMTransactionState.setUrlParams((String)localObject2);
      paramQAPMTransactionState.setAllGetRequestParams((String)localObject2);
      paramQAPMTransactionState.setHttpLibType(HttpLibType.HttpClient);
      processParamsAndHeader(paramQAPMTransactionState, paramHttpUriRequest, (String)localObject2);
      wrapRequestEntity(paramQAPMTransactionState, paramHttpUriRequest);
      return paramHttpUriRequest;
      localObject1 = paramHttpUriRequest.getURI().toString();
    }
  }
  
  private static void processParamsAndHeader(QAPMTransactionState paramQAPMTransactionState, HttpRequest paramHttpRequest, String paramString)
  {
    getHttpClientRequest(paramQAPMTransactionState, paramHttpRequest);
    QAPMTransactionStateUtil.processParamsFilter(paramQAPMTransactionState, paramQAPMTransactionState.getUrlParams());
    paramHttpRequest = new QAPMHttpClientUtil.1(paramHttpRequest);
    QAPMTransactionStateUtil.processHeaderParam(paramQAPMTransactionState.getUrl(), paramHttpRequest, paramQAPMTransactionState);
  }
  
  public static Map<String, Object> resolvingResponseHeader(HttpResponse paramHttpResponse)
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
  
  public static void setErrorCodeFromException(QAPMTransactionState paramQAPMTransactionState, Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      if (QAPMTransactionStateUtil.isSocketECONNRESET(paramException))
      {
        paramQAPMTransactionState.setErrorCode(911, paramException.toString());
        paramQAPMTransactionState.setStatusCode(911);
        return;
      }
      String str = paramException.getMessage();
      if ((str != null) && (str.contains("ftruncate failed: ENOENT (No such file or directory)")))
      {
        paramQAPMTransactionState.setErrorCode(917, paramException.toString());
        paramQAPMTransactionState.setStatusCode(917);
        return;
      }
    }
    if ((paramException instanceof UnknownHostException))
    {
      paramQAPMTransactionState.setErrorCode(901, paramException.toString());
      paramQAPMTransactionState.setStatusCode(901);
      return;
    }
    if ((!(paramException instanceof SocketTimeoutException)) && (!(paramException instanceof ConnectTimeoutException)))
    {
      if ((paramException instanceof ConnectException))
      {
        paramQAPMTransactionState.setErrorCode(902, paramException.toString());
        paramQAPMTransactionState.setStatusCode(902);
        return;
      }
      if ((paramException instanceof MalformedURLException))
      {
        paramQAPMTransactionState.setErrorCode(900, paramException.toString());
        paramQAPMTransactionState.setStatusCode(900);
        return;
      }
      if ((paramException instanceof SSLException))
      {
        paramQAPMTransactionState.setErrorCode(908, paramException.toString());
        paramQAPMTransactionState.setStatusCode(908);
        return;
      }
      if ((paramException instanceof HttpResponseException))
      {
        paramQAPMTransactionState.setStatusCode(((HttpResponseException)paramException).getStatusCode());
        return;
      }
      if ((paramException instanceof ClientProtocolException))
      {
        paramQAPMTransactionState.setErrorCode(904, paramException.toString());
        paramQAPMTransactionState.setStatusCode(904);
        return;
      }
      if ((paramException instanceof AuthenticationException))
      {
        paramQAPMTransactionState.setErrorCode(907, paramException.toString());
        paramQAPMTransactionState.setStatusCode(907);
        return;
      }
      paramQAPMTransactionState.setErrorCode(-1, paramException.toString());
      paramQAPMTransactionState.setStatusCode(-1);
      return;
    }
    paramQAPMTransactionState.setErrorCode(903, paramException.toString());
    paramQAPMTransactionState.setStatusCode(903);
  }
  
  public static HttpRequest setHttpClientCrossProcessHeader(HttpRequest paramHttpRequest)
  {
    return paramHttpRequest;
  }
  
  private static void wrapRequestEntity(QAPMTransactionState paramQAPMTransactionState, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest))
    {
      paramHttpRequest = (HttpEntityEnclosingRequest)paramHttpRequest;
      if (paramHttpRequest.getEntity() != null) {
        paramHttpRequest.setEntity(new QAPMHttpRequestEntityImpl(paramHttpRequest.getEntity(), paramQAPMTransactionState));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpClientUtil
 * JD-Core Version:    0.7.0.1
 */