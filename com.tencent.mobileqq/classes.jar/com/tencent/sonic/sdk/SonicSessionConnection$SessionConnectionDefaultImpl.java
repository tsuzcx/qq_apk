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
    try
    {
      localURL = new URL((String)localObject3);
      localObject1 = this.intent.getStringExtra("dns-prefetch-address");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localURL.getHost();
        localURL = new URL(((String)localObject3).replace((CharSequence)localObject2, (CharSequence)localObject1));
        SonicUtils.log("SonicSdk_SonicSessionConnection", 4, "create UrlConnection with DNS-Prefetch(" + (String)localObject2 + " -> " + (String)localObject1 + ").");
        localObject1 = localURL.openConnection();
        localObject3 = localObject1;
        if (localObject1 == null) {}
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          URL localURL;
          if ((localObject1 instanceof HttpURLConnection)) {
            ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          }
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            ((URLConnection)localObject1).setRequestProperty("Host", (String)localObject2);
            ((URLConnection)localObject1).setRequestProperty("sonic-dns-prefetch", localURL.getHost());
            localObject3 = localObject1;
            if ((localObject1 instanceof HttpsURLConnection))
            {
              localObject3 = (HttpsURLConnection)localObject1;
              ((HttpsURLConnection)localObject3).setSSLSocketFactory(new SonicSniSSLSocketFactory(SonicEngine.getInstance().getRuntime().getContext(), (String)localObject2));
              ((HttpsURLConnection)localObject3).setHostnameVerifier(new SonicSessionConnection.SessionConnectionDefaultImpl.1(this, localURL, (String)localObject2));
              localObject3 = localObject1;
            }
          }
          return localObject3;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          continue;
        }
        localThrowable1 = localThrowable1;
        localObject1 = null;
        Object localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = null;
        }
        SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "create UrlConnection fail, error:" + localThrowable1.getMessage() + ".");
        localObject3 = localObject2;
        continue;
        localObject2 = null;
      }
    }
  }
  
  public void disconnect()
  {
    HttpURLConnection localHttpURLConnection;
    if ((this.connectionImpl instanceof HttpURLConnection))
    {
      localHttpURLConnection = (HttpURLConnection)this.connectionImpl;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        SonicEngine.getInstance().getRuntime().postTaskToThread(new SonicSessionConnection.SessionConnectionDefaultImpl.2(this, localHttpURLConnection), 0L);
      }
    }
    else
    {
      return;
    }
    try
    {
      localHttpURLConnection.disconnect();
      return;
    }
    catch (Exception localException)
    {
      SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "disconnect error:" + localException.getMessage());
    }
  }
  
  public int getResponseCode()
  {
    if ((this.connectionImpl instanceof HttpURLConnection)) {
      try
      {
        int i = ((HttpURLConnection)this.connectionImpl).getResponseCode();
        return i;
      }
      catch (Throwable localThrowable)
      {
        String str = localThrowable.getMessage();
        SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "getResponseCode error:" + str);
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
    if (this.connectionImpl == null) {
      return null;
    }
    try
    {
      Map localMap = this.connectionImpl.getHeaderFields();
      return localMap;
    }
    catch (Throwable localThrowable)
    {
      SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "getHeaderFields error:" + localThrowable.getMessage());
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
      if (localSonicSessionConfig.ACCEPT_DIFF_DATA) {}
      for (Object localObject1 = "true";; localObject1 = "false")
      {
        paramURLConnection.setRequestProperty("accept-diff", (String)localObject1);
        Object localObject2 = this.intent.getStringExtra("eTag");
        localObject1 = localObject2;
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
        if ((localSonicSessionConfig.customRequestHeaders == null) || (localSonicSessionConfig.customRequestHeaders.size() == 0)) {
          break;
        }
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
      }
      for (;;)
      {
        paramURLConnection.setRequestProperty("User-Agent", this.intent.getStringExtra("User-Agent"));
        return true;
        SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "create UrlConnection cookie is empty");
      }
    }
    return false;
  }
  
  protected int internalConnect()
  {
    label137:
    for (;;)
    {
      try
      {
        if ((this.connectionImpl instanceof HttpURLConnection))
        {
          HttpURLConnection localHttpURLConnection = (HttpURLConnection)this.connectionImpl;
          try
          {
            localHttpURLConnection.connect();
            i = 0;
          }
          catch (Throwable localThrowable)
          {
            String str = localThrowable.getMessage();
            SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "connect error:" + str);
            if (!(localThrowable instanceof IOException)) {
              continue;
            }
            if (!(localThrowable instanceof SocketTimeoutException)) {
              continue;
            }
            i = -902;
            continue;
            if ((TextUtils.isEmpty(str)) || (!str.contains("timeoutexception"))) {
              break label137;
            }
            i = -902;
            continue;
            boolean bool = localThrowable instanceof NullPointerException;
            if (!bool) {
              continue;
            }
            i = -903;
            continue;
          }
          return i;
        }
        else
        {
          i = -1;
          continue;
        }
        int i = -901;
      }
      finally {}
    }
  }
  
  protected BufferedInputStream internalGetResponseStream()
  {
    if ((this.responseStream == null) && (this.connectionImpl != null)) {}
    try
    {
      InputStream localInputStream = this.connectionImpl.getInputStream();
      if ("gzip".equalsIgnoreCase(this.connectionImpl.getContentEncoding())) {}
      for (this.responseStream = new BufferedInputStream(new GZIPInputStream(localInputStream));; this.responseStream = new BufferedInputStream(localInputStream)) {
        return this.responseStream;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "getResponseStream error:" + localThrowable.getMessage() + ".");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnection.SessionConnectionDefaultImpl
 * JD-Core Version:    0.7.0.1
 */