package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RequestProxyDefault$RequestTask
  implements Runnable
{
  public volatile boolean mAbort;
  public byte[] mBodyData;
  public Map<String, String> mHeader;
  public RequestProxy.RequestListener mListener;
  public String mMethod;
  public int mTimeout;
  public String mUrl;
  
  public RequestProxyDefault$RequestTask(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestProxy.RequestListener paramRequestListener)
  {
    if (paramMap != null)
    {
      this.mBodyData = new byte[paramMap.length];
      System.arraycopy(paramMap, 0, this.mBodyData, 0, paramMap.length);
    }
    this.mUrl = paramArrayOfByte;
    this.mHeader = paramString2;
    this.mMethod = paramInt;
    this.mTimeout = paramRequestListener;
    Object localObject;
    this.mListener = localObject;
  }
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.mUrl).openConnection();
      localHttpURLConnection.setConnectTimeout(this.mTimeout * 1000);
      localHttpURLConnection.setRequestMethod(this.mMethod);
      Object localObject1;
      Object localObject2;
      if (this.mHeader != null)
      {
        localObject1 = this.mHeader.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localHttpURLConnection.setRequestProperty((String)localObject2, (String)this.mHeader.get(localObject2));
        }
      }
      if ((this.mBodyData != null) && (this.mMethod.equalsIgnoreCase("POST")))
      {
        localHttpURLConnection.setDoOutput(true);
        localObject1 = localHttpURLConnection.getOutputStream();
        ((OutputStream)localObject1).write(this.mBodyData);
        ((OutputStream)localObject1).close();
      }
      int i = localHttpURLConnection.getResponseCode();
      if (this.mAbort) {
        return;
      }
      this.mListener.onRequestHeadersReceived(i, localHttpURLConnection.getHeaderFields());
      if (i == 200)
      {
        localObject1 = localHttpURLConnection.getInputStream();
        localObject2 = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[4096];
        for (;;)
        {
          int j = ((InputStream)localObject1).read(arrayOfByte);
          if (j == -1) {
            break;
          }
          if (this.mAbort)
          {
            ((InputStream)localObject1).close();
            ((ByteArrayOutputStream)localObject2).close();
            return;
          }
          ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, j);
        }
        ((InputStream)localObject1).close();
        ((ByteArrayOutputStream)localObject2).close();
        localHttpURLConnection.disconnect();
        this.this$0.taskMap.remove(this.mUrl);
        this.mListener.onRequestSucceed(i, ((ByteArrayOutputStream)localObject2).toByteArray(), localHttpURLConnection.getHeaderFields());
        return;
      }
      this.this$0.taskMap.remove(this.mUrl);
      this.mListener.onRequestFailed(localHttpURLConnection.getResponseCode(), "http error code");
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      this.this$0.taskMap.remove(this.mUrl);
      this.mListener.onRequestFailed(-2, localIOException.getMessage());
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      this.this$0.taskMap.remove(this.mUrl);
      this.mListener.onRequestFailed(-1, localMalformedURLException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.RequestProxyDefault.RequestTask
 * JD-Core Version:    0.7.0.1
 */