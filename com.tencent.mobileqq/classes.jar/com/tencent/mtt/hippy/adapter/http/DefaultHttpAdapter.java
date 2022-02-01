package com.tencent.mtt.hippy.adapter.http;

import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultHttpAdapter
  implements HippyHttpAdapter
{
  private ExecutorService mExecutorService;
  
  private void execute(Runnable paramRunnable)
  {
    if (this.mExecutorService == null) {
      this.mExecutorService = Executors.newFixedThreadPool(3);
    }
    this.mExecutorService.execute(paramRunnable);
  }
  
  private static URL toURL(String paramString)
  {
    URL localURL = new URL(paramString);
    Object localObject2;
    if (localURL.getPath() != null)
    {
      localObject2 = localURL;
      if (!"".equals(localURL.getPath())) {}
    }
    else
    {
      Object localObject1 = localURL;
      if (localURL.getFile() != null)
      {
        localObject1 = localURL;
        if (localURL.getFile().startsWith("?"))
        {
          int i = paramString.indexOf('?');
          localObject1 = localURL;
          if (i != -1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString.substring(0, i));
            ((StringBuilder)localObject1).append('/');
            ((StringBuilder)localObject1).append(paramString.substring(i));
            localObject1 = new URL(((StringBuilder)localObject1).toString());
          }
        }
      }
      if (((URL)localObject1).getFile() != null)
      {
        localObject2 = localObject1;
        if (!"".equals(((URL)localObject1).getFile())) {}
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("/");
        localObject2 = new URL(((StringBuilder)localObject1).toString());
      }
    }
    return localObject2;
  }
  
  HttpURLConnection createConnection(HippyHttpRequest paramHippyHttpRequest)
  {
    if (TextUtils.isEmpty(paramHippyHttpRequest.getUrl())) {
      throw new RuntimeException("url is null");
    }
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)toURL(paramHippyHttpRequest.getUrl()).openConnection();
    if (TextUtils.isEmpty(paramHippyHttpRequest.getMethod())) {
      paramHippyHttpRequest.setMethod("GET");
    }
    localHttpURLConnection.setRequestMethod(paramHippyHttpRequest.getMethod());
    localHttpURLConnection.setUseCaches(paramHippyHttpRequest.isUseCaches());
    localHttpURLConnection.setInstanceFollowRedirects(paramHippyHttpRequest.isInstanceFollowRedirects());
    localHttpURLConnection.setConnectTimeout(paramHippyHttpRequest.getConnectTimeout());
    localHttpURLConnection.setReadTimeout(paramHippyHttpRequest.getReadTimeout());
    if ((paramHippyHttpRequest.getMethod().equalsIgnoreCase("POST")) || (paramHippyHttpRequest.getMethod().equalsIgnoreCase("PUT")) || (paramHippyHttpRequest.getMethod().equalsIgnoreCase("PATCH"))) {
      localHttpURLConnection.setDoOutput(true);
    }
    return localHttpURLConnection;
  }
  
  HippyHttpResponse createResponse(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject5 = null;
    HippyHttpResponse localHippyHttpResponse = new HippyHttpResponse();
    parseResponseHeaders(paramHttpURLConnection, localHippyHttpResponse);
    int i = 0;
    try
    {
      localObject1 = paramHttpURLConnection.getInputStream();
      if (i == 0)
      {
        localObject3 = localObject5;
        if (paramHttpURLConnection.getResponseCode() < 400) {
          break label50;
        }
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        Object localObject1;
        Object localObject3 = paramHttpURLConnection.getErrorStream();
        label50:
        if (i != 0) {
          localObject1 = localObject3;
        }
        localHippyHttpResponse.setInputStream((InputStream)localObject1);
        localHippyHttpResponse.setErrorStream((InputStream)localObject3);
        localHippyHttpResponse.setResponseMessage(paramHttpURLConnection.getResponseMessage());
        return localHippyHttpResponse;
        localIOException = localIOException;
        localIOException.printStackTrace();
        i = 1;
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject4 = localObject5;
        }
      }
    }
  }
  
  public void destroyIfNeed()
  {
    if ((this.mExecutorService != null) && (!this.mExecutorService.isShutdown()))
    {
      this.mExecutorService.shutdown();
      this.mExecutorService = null;
    }
  }
  
  void fillHeader(URLConnection paramURLConnection, HippyHttpRequest paramHippyHttpRequest)
  {
    paramHippyHttpRequest = paramHippyHttpRequest.getHeaders();
    if ((paramHippyHttpRequest != null) && (!paramHippyHttpRequest.isEmpty()))
    {
      Iterator localIterator = paramHippyHttpRequest.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Object localObject = paramHippyHttpRequest.get(str1);
        if ((localObject instanceof String))
        {
          paramURLConnection.setRequestProperty(str1, (String)localObject);
        }
        else if ((localObject instanceof List))
        {
          localObject = (List)localObject;
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str2 = (String)((Iterator)localObject).next();
              if (!TextUtils.isEmpty(str2)) {
                paramURLConnection.addRequestProperty(str1, str2);
              }
            }
          }
        }
      }
    }
  }
  
  void fillPostBody(HttpURLConnection paramHttpURLConnection, HippyHttpRequest paramHippyHttpRequest)
  {
    if (TextUtils.isEmpty(paramHippyHttpRequest.getBody())) {
      return;
    }
    paramHttpURLConnection.setRequestProperty("Content-Length", paramHippyHttpRequest.getBody().getBytes().length + "");
    paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
    paramHttpURLConnection.write(paramHippyHttpRequest.getBody().getBytes());
    paramHttpURLConnection.flush();
    paramHttpURLConnection.close();
  }
  
  void parseResponseHeaders(HttpURLConnection paramHttpURLConnection, HippyHttpResponse paramHippyHttpResponse)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    paramHippyHttpResponse.setStatusCode(Integer.valueOf(paramHttpURLConnection.getResponseCode()));
    paramHippyHttpResponse.setRspHeaderMap(paramHttpURLConnection.getHeaderFields());
  }
  
  public void sendRequest(HippyHttpRequest paramHippyHttpRequest, HippyHttpAdapter.HttpTaskCallback paramHttpTaskCallback)
  {
    execute(new DefaultHttpAdapter.1(this, paramHttpTaskCallback, paramHippyHttpRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter
 * JD-Core Version:    0.7.0.1
 */