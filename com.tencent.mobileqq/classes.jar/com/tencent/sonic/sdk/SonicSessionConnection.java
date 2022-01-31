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
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public abstract class SonicSessionConnection
{
  public static final String CUSTOM_HEAD_FILED_ACCEPT_DIFF = "accept-diff";
  public static final String CUSTOM_HEAD_FILED_CACHE_OFFLINE = "cache-offline";
  public static final String CUSTOM_HEAD_FILED_DNS_PREFETCH = "sonic-dns-prefetch";
  public static final String CUSTOM_HEAD_FILED_ETAG = "eTag";
  public static final String CUSTOM_HEAD_FILED_HTML_SHA1 = "sonic-html-sha1";
  public static final String CUSTOM_HEAD_FILED_LINK = "sonic-link";
  public static final String CUSTOM_HEAD_FILED_SDK_VERSION = "sonic-sdk-version";
  public static final String CUSTOM_HEAD_FILED_TEMPLATE_CHANGE = "template-change";
  public static final String CUSTOM_HEAD_FILED_TEMPLATE_TAG = "template-tag";
  public static final String DNS_PREFETCH_ADDRESS = "dns-prefetch-address";
  public static final String HTTP_HEAD_CSP = "Content-Security-Policy";
  public static final String HTTP_HEAD_CSP_REPORT_ONLY = "Content-Security-Policy-Report-Only";
  public static final String HTTP_HEAD_FIELD_CACHE_CONTROL = "Cache-Control";
  public static final String HTTP_HEAD_FIELD_CONTENT_LENGTH = "Content-Length";
  public static final String HTTP_HEAD_FIELD_CONTENT_TYPE = "Content-Type";
  public static final String HTTP_HEAD_FIELD_COOKIE = "Cookie";
  public static final String HTTP_HEAD_FIELD_EXPIRES = "Expires";
  public static final String HTTP_HEAD_FIELD_PRAGMA = "Pragma";
  public static final String HTTP_HEAD_FILED_IF_NOT_MATCH = "If-None-Match";
  public static final String HTTP_HEAD_FILED_SET_COOKIE = "Set-Cookie";
  public static final String HTTP_HEAD_FILED_USER_AGENT = "User-Agent";
  private static final String TAG = "SonicSdk_SonicSessionConnection";
  protected final Intent intent;
  protected BufferedInputStream responseStream;
  protected final SonicSession session;
  
  public SonicSessionConnection(SonicSession paramSonicSession, Intent paramIntent)
  {
    this.session = paramSonicSession;
    if (paramIntent != null) {}
    for (;;)
    {
      this.intent = paramIntent;
      return;
      paramIntent = new Intent();
    }
  }
  
  public int connect()
  {
    try
    {
      int i = internalConnect();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract void disconnect();
  
  public abstract int getResponseCode();
  
  public abstract String getResponseHeaderField(String paramString);
  
  public abstract Map<String, List<String>> getResponseHeaderFields();
  
  public BufferedInputStream getResponseStream()
  {
    try
    {
      if (this.responseStream == null) {
        this.responseStream = internalGetResponseStream();
      }
      BufferedInputStream localBufferedInputStream = this.responseStream;
      return localBufferedInputStream;
    }
    finally {}
  }
  
  protected abstract int internalConnect();
  
  protected abstract BufferedInputStream internalGetResponseStream();
  
  public static class SessionConnectionDefaultImpl
    extends SonicSessionConnection
  {
    protected final URLConnection connectionImpl = createConnection();
    
    public SessionConnectionDefaultImpl(SonicSession paramSonicSession, Intent paramIntent)
    {
      super(paramIntent);
      initConnection(this.connectionImpl);
    }
    
    protected URLConnection createConnection()
    {
      String str3 = this.session.srcUrl;
      Object localObject2;
      if (TextUtils.isEmpty(str3)) {
        localObject2 = null;
      }
      Object localObject1;
      for (;;)
      {
        return localObject2;
        URLConnection localURLConnection2 = null;
        URLConnection localURLConnection1 = localURLConnection2;
        try
        {
          localObject2 = new URL(str3);
          localURLConnection1 = localURLConnection2;
          String str2 = this.intent.getStringExtra("dns-prefetch-address");
          final String str1 = null;
          localObject1 = localObject2;
          localURLConnection1 = localURLConnection2;
          if (!TextUtils.isEmpty(str2))
          {
            localURLConnection1 = localURLConnection2;
            str1 = ((URL)localObject2).getHost();
            localURLConnection1 = localURLConnection2;
            localObject1 = new URL(str3.replace(str1, str2));
            localURLConnection1 = localURLConnection2;
            SonicUtils.log("SonicSdk_SonicSessionConnection", 4, "create UrlConnection with DNS-Prefetch(" + str1 + " -> " + str2 + ").");
          }
          localURLConnection1 = localURLConnection2;
          localURLConnection2 = ((URL)localObject1).openConnection();
          localObject2 = localURLConnection2;
          if (localURLConnection2 != null)
          {
            localURLConnection1 = localURLConnection2;
            if ((localURLConnection2 instanceof HttpURLConnection))
            {
              localURLConnection1 = localURLConnection2;
              ((HttpURLConnection)localURLConnection2).setInstanceFollowRedirects(false);
            }
            localObject2 = localURLConnection2;
            localURLConnection1 = localURLConnection2;
            if (!TextUtils.isEmpty(str1))
            {
              localURLConnection1 = localURLConnection2;
              localURLConnection2.setRequestProperty("Host", str1);
              localURLConnection1 = localURLConnection2;
              localURLConnection2.setRequestProperty("sonic-dns-prefetch", ((URL)localObject1).getHost());
              localObject2 = localURLConnection2;
              localURLConnection1 = localURLConnection2;
              if ((localURLConnection2 instanceof HttpsURLConnection))
              {
                localURLConnection1 = localURLConnection2;
                localObject2 = (HttpsURLConnection)localURLConnection2;
                localURLConnection1 = localURLConnection2;
                ((HttpsURLConnection)localObject2).setSSLSocketFactory(new SonicSniSSLSocketFactory(SonicEngine.getInstance().getRuntime().getContext(), str1));
                localURLConnection1 = localURLConnection2;
                ((HttpsURLConnection)localObject2).setHostnameVerifier(new HostnameVerifier()
                {
                  public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
                  {
                    boolean bool = false;
                    long l = System.currentTimeMillis();
                    if (this.val$finalUrl.getHost().equals(paramAnonymousString))
                    {
                      bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(str1, paramAnonymousSSLSession);
                      SonicUtils.log("SonicSdk_SonicSessionConnection", 3, "verify hostname cost " + (System.currentTimeMillis() - l) + " ms.");
                    }
                    return bool;
                  }
                });
                return localURLConnection2;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localObject1 = localURLConnection1;
          if (localURLConnection1 != null) {
            localObject1 = null;
          }
          SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "create UrlConnection fail, error:" + localThrowable.getMessage() + ".");
        }
      }
      return localObject1;
    }
    
    public void disconnect()
    {
      final HttpURLConnection localHttpURLConnection;
      if ((this.connectionImpl instanceof HttpURLConnection))
      {
        localHttpURLConnection = (HttpURLConnection)this.connectionImpl;
        if (Looper.myLooper() == Looper.getMainLooper()) {
          SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable()
          {
            public void run()
            {
              try
              {
                localHttpURLConnection.disconnect();
                return;
              }
              catch (Throwable localThrowable)
              {
                SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "disconnect error:" + localThrowable.getMessage());
              }
            }
          }, 0L);
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
          int i = 1;
          int j = paramString.size();
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
          paramURLConnection.setRequestProperty("sonic-sdk-version", "Sonic/2.0.0");
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
      int j = -902;
      label143:
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
              i = j;
              if ((localThrowable instanceof SocketTimeoutException)) {
                continue;
              }
              if (TextUtils.isEmpty(str)) {
                break label143;
              }
              i = j;
              if (str.contains("timeoutexception")) {
                continue;
              }
              break label143;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnection
 * JD-Core Version:    0.7.0.1
 */