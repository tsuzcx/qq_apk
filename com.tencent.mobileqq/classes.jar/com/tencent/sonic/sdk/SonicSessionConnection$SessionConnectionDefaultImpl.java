package com.tencent.sonic.sdk;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

public class SonicSessionConnection$SessionConnectionDefaultImpl
  extends SonicSessionConnection
{
  protected final URLConnection connectionImpl = createConnection();
  
  public SonicSessionConnection$SessionConnectionDefaultImpl(SonicSession paramSonicSession, Intent paramIntent)
  {
    super(paramSonicSession, paramIntent);
    initConnection(this.connectionImpl);
  }
  
  protected URLConnection createConnection()
  {
    Object localObject3 = this.session.srcUrl;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      return null;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        URL localURL = new URL((String)localObject3);
        localObject2 = this.intent.getStringExtra("dns-prefetch-address");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label301;
        }
        localObject1 = localURL.getHost();
        localURL = new URL(((String)localObject3).replace((CharSequence)localObject1, (CharSequence)localObject2));
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("create UrlConnection with DNS-Prefetch(");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" -> ");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(").");
        SonicUtils.log("SonicSdk_SonicSessionConnection", 4, ((StringBuilder)localObject3).toString());
        localObject2 = localURL.openConnection();
        localObject3 = localObject2;
        if (localObject2 == null) {
          break label298;
        }
        try
        {
          if ((localObject2 instanceof HttpURLConnection)) {
            ((HttpURLConnection)localObject2).setInstanceFollowRedirects(false);
          }
          localObject3 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label298;
          }
          ((URLConnection)localObject2).setRequestProperty("Host", (String)localObject1);
          ((URLConnection)localObject2).setRequestProperty("sonic-dns-prefetch", localURL.getHost());
          localObject3 = localObject2;
          if (!(localObject2 instanceof HttpsURLConnection)) {
            break label298;
          }
          localObject3 = (HttpsURLConnection)localObject2;
          ((HttpsURLConnection)localObject3).setSSLSocketFactory(new SonicSniSSLSocketFactory(SonicEngine.getInstance().getRuntime().getContext(), (String)localObject1));
          ((HttpsURLConnection)localObject3).setHostnameVerifier(new SonicSessionConnection.SessionConnectionDefaultImpl.1(this, localURL, (String)localObject1));
          return localObject2;
        }
        catch (Throwable localThrowable1)
        {
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = null;
      }
      if (localObject1 != null) {
        localObject2 = null;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("create UrlConnection fail, error:");
      ((StringBuilder)localObject1).append(localThrowable2.getMessage());
      ((StringBuilder)localObject1).append(".");
      SonicUtils.log("SonicSdk_SonicSessionConnection", 6, ((StringBuilder)localObject1).toString());
      localObject3 = localObject2;
      label298:
      return localObject3;
      label301:
      localObject1 = null;
    }
  }
  
  public void disconnect()
  {
    Object localObject = this.connectionImpl;
    if ((localObject instanceof HttpURLConnection))
    {
      localObject = (HttpURLConnection)localObject;
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        SonicEngine.getInstance().getRuntime().postTaskToThread(new SonicSessionConnection.SessionConnectionDefaultImpl.2(this, (HttpURLConnection)localObject), 0L);
        return;
      }
      try
      {
        ((HttpURLConnection)localObject).disconnect();
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disconnect error:");
        localStringBuilder.append(localException.getMessage());
        SonicUtils.log("SonicSdk_SonicSessionConnection", 6, localStringBuilder.toString());
      }
    }
  }
  
  public int getResponseCode()
  {
    URLConnection localURLConnection = this.connectionImpl;
    if ((localURLConnection instanceof HttpURLConnection)) {
      try
      {
        int i = ((HttpURLConnection)localURLConnection).getResponseCode();
        return i;
      }
      catch (Throwable localThrowable)
      {
        String str = localThrowable.getMessage();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getResponseCode error:");
        localStringBuilder.append(str);
        SonicUtils.log("SonicSdk_SonicSessionConnection", 6, localStringBuilder.toString());
        if ((localThrowable instanceof IOException))
        {
          if ((localThrowable instanceof SocketTimeoutException)) {
            return -902;
          }
          if ((!TextUtils.isEmpty(str)) && (str.contains("timeoutexception"))) {
            return -902;
          }
          return -901;
        }
        if ((localThrowable instanceof NullPointerException)) {
          return -903;
        }
      }
    }
    return -1;
  }
  
  public String getResponseHeaderField(String paramString)
  {
    Object localObject = getResponseHeaderFields();
    if ((localObject != null) && (((Map)localObject).size() != 0))
    {
      paramString = (List)((Map)localObject).get(paramString.toLowerCase());
      if ((paramString != null) && (paramString.size() != 0))
      {
        localObject = new StringBuilder((String)paramString.get(0));
        int j = paramString.size();
        int i = 1;
        while (i < j)
        {
          ((StringBuilder)localObject).append(',');
          ((StringBuilder)localObject).append((String)paramString.get(i));
          i += 1;
        }
        return ((StringBuilder)localObject).toString();
      }
    }
    return null;
  }
  
  public Map<String, List<String>> getResponseHeaderFields()
  {
    Object localObject = this.connectionImpl;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((URLConnection)localObject).getHeaderFields();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHeaderFields error:");
      localStringBuilder.append(localThrowable.getMessage());
      SonicUtils.log("SonicSdk_SonicSessionConnection", 6, localStringBuilder.toString());
    }
    return new HashMap();
  }
  
  protected boolean initConnection(URLConnection paramURLConnection)
  {
    if (paramURLConnection != null)
    {
      SonicSessionConfig localSonicSessionConfig = this.session.config;
      paramURLConnection.setConnectTimeout(localSonicSessionConfig.CONNECT_TIMEOUT_MILLIS);
      paramURLConnection.setReadTimeout(localSonicSessionConfig.READ_TIMEOUT_MILLIS);
      if (localSonicSessionConfig.ACCEPT_DIFF_DATA) {
        localObject1 = "true";
      } else {
        localObject1 = "false";
      }
      paramURLConnection.setRequestProperty("accept-diff", (String)localObject1);
      Object localObject2 = this.intent.getStringExtra("eTag");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramURLConnection.setRequestProperty("If-None-Match", (String)localObject1);
      localObject2 = this.intent.getStringExtra("template-tag");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramURLConnection.setRequestProperty("template-tag", (String)localObject1);
      paramURLConnection.setRequestProperty("method", "GET");
      paramURLConnection.setRequestProperty("Accept-Encoding", "gzip");
      paramURLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;");
      paramURLConnection.setRequestProperty("sonic-sdk-version", "Sonic/3.0.2");
      if (this.intent.hasExtra("X-sonic-chunk")) {
        paramURLConnection.setRequestProperty("X-sonic-chunk", this.intent.getStringExtra("X-sonic-chunk"));
      }
      if ((localSonicSessionConfig.customRequestHeaders != null) && (localSonicSessionConfig.customRequestHeaders.size() != 0))
      {
        localObject1 = localSonicSessionConfig.customRequestHeaders.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramURLConnection.setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
        }
      }
      localObject1 = this.intent.getStringExtra("Cookie");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramURLConnection.setRequestProperty("Cookie", (String)localObject1);
      } else {
        SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "create UrlConnection cookie is empty");
      }
      paramURLConnection.setRequestProperty("User-Agent", this.intent.getStringExtra("User-Agent"));
      return true;
    }
    return false;
  }
  
  protected int internalConnect()
  {
    try
    {
      if ((this.connectionImpl instanceof HttpURLConnection))
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)this.connectionImpl;
        try
        {
          localHttpURLConnection.connect();
          return 0;
        }
        catch (Throwable localThrowable)
        {
          String str = localThrowable.getMessage();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("connect error:");
          localStringBuilder.append(str);
          SonicUtils.log("SonicSdk_SonicSessionConnection", 6, localStringBuilder.toString());
          if ((localThrowable instanceof IOException))
          {
            bool = localThrowable instanceof SocketTimeoutException;
            if (bool) {
              return -902;
            }
            if (!TextUtils.isEmpty(str))
            {
              bool = str.contains("timeoutexception");
              if (bool) {
                return -902;
              }
            }
            return -901;
          }
          boolean bool = localThrowable instanceof NullPointerException;
          if (bool) {
            return -903;
          }
        }
      }
      return -1;
    }
    finally {}
  }
  
  protected BufferedInputStream internalGetResponseStream()
  {
    if (this.responseStream == null)
    {
      Object localObject = this.connectionImpl;
      if (localObject != null) {
        try
        {
          localObject = ((URLConnection)localObject).getInputStream();
          if ("gzip".equalsIgnoreCase(this.connectionImpl.getContentEncoding())) {
            this.responseStream = new BufferedInputStream(new GZIPInputStream((InputStream)localObject));
          } else {
            this.responseStream = new BufferedInputStream((InputStream)localObject);
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getResponseStream error:");
          localStringBuilder.append(localThrowable.getMessage());
          localStringBuilder.append(".");
          SonicUtils.log("SonicSdk_SonicSessionConnection", 6, localStringBuilder.toString());
        }
      }
    }
    return this.responseStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnection.SessionConnectionDefaultImpl
 * JD-Core Version:    0.7.0.1
 */