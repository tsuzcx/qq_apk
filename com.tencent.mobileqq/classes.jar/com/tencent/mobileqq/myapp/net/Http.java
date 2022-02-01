package com.tencent.mobileqq.myapp.net;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.InetSocketAddress;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class Http
{
  public static ThreadSafeClientConnManager a;
  private static final Uri b = Uri.parse("content://telephony/carriers/preferapn");
  
  public static InetSocketAddress a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject2 = null;
    String str;
    int i;
    if (localBaseApplication == null)
    {
      str = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    else
    {
      localObject1 = localObject2;
      if (!AppNetConnInfo.isMobileConn()) {
        return localObject1;
      }
      str = Proxy.getHost(localBaseApplication);
      int j = Proxy.getPort(localBaseApplication);
      if ((str != null) && (str.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        str = Proxy.getDefaultHost();
        j = Proxy.getDefaultPort();
        if ((str != null) && (str.trim().length() != 0))
        {
          i = j;
          if (j > 0) {}
        }
        else
        {
          localObject1 = b();
          str = ((QzoneProxy)localObject1).a;
          i = ((QzoneProxy)localObject1).b;
        }
      }
    }
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (str.trim().length() > 0) {
        localObject1 = new InetSocketAddress(str, i);
      }
    }
    return localObject1;
  }
  
  public static byte[] a(String paramString1, byte[] paramArrayOfByte, String paramString2, BasicHeader[] paramArrayOfBasicHeader)
  {
    paramString1 = b(paramString1, paramArrayOfByte, paramString2, paramArrayOfBasicHeader);
    paramArrayOfByte = EntityUtils.toByteArray(paramString1);
    paramString1.consumeContent();
    return paramArrayOfByte;
  }
  
  private static QzoneProxy b()
  {
    Object localObject1 = BaseApplication.getContext();
    QzoneProxy localQzoneProxy = new QzoneProxy();
    try
    {
      localObject1 = ((Context)localObject1).getContentResolver().query(b, null, null, null, null);
      ((Cursor)localObject1).moveToFirst();
      String str1 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("proxy"));
      if (str1 != null) {
        str1.toLowerCase();
      }
      String str2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("port"));
      String str3 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("apn"));
      if (str3 != null) {
        str3.toLowerCase();
      }
      ((Cursor)localObject1).close();
      if ((str3 != null) && (str3.startsWith("ctwap")))
      {
        if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
        {
          localQzoneProxy.a = str1;
          localQzoneProxy.b = Integer.valueOf(str2).intValue();
          return localQzoneProxy;
        }
        localQzoneProxy.a = "10.0.0.200";
        localQzoneProxy.b = 80;
        return localQzoneProxy;
      }
      if ((str3 != null) && (str3.startsWith("cmwap")))
      {
        if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
        {
          localQzoneProxy.a = str1;
          localQzoneProxy.b = Integer.valueOf(str2).intValue();
          return localQzoneProxy;
        }
        localQzoneProxy.a = "10.0.0.172";
        localQzoneProxy.b = 80;
        return localQzoneProxy;
      }
      if ((str3 != null) && (str3.startsWith("uniwap")))
      {
        if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
        {
          localQzoneProxy.a = str1;
          localQzoneProxy.b = Integer.valueOf(str2).intValue();
          return localQzoneProxy;
        }
        localQzoneProxy.a = "10.0.0.172";
        localQzoneProxy.b = 80;
      }
      return localQzoneProxy;
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      return localQzoneProxy;
    }
    finally {}
    return localQzoneProxy;
  }
  
  public static HttpEntity b(String paramString1, byte[] paramArrayOfByte, String paramString2, BasicHeader[] paramArrayOfBasicHeader)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 15000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    if (paramString2.equals("POST"))
    {
      paramString1 = new HttpPost(paramString1);
      paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
      ((HttpPost)paramString1).setEntity(paramArrayOfByte);
      paramArrayOfByte = paramString1;
    }
    else if (paramArrayOfByte != null)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("?");
      paramString2.append(new String(paramArrayOfByte));
      paramArrayOfByte = new HttpGet(paramString2.toString());
    }
    else
    {
      paramArrayOfByte = new HttpGet(paramString1);
    }
    int j;
    if (paramArrayOfBasicHeader != null)
    {
      j = paramArrayOfBasicHeader.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfByte.addHeader(paramArrayOfBasicHeader[i]);
        i += 1;
      }
    }
    if (a == null)
    {
      paramString1 = new SchemeRegistry();
      paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      paramString1.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      a = new ThreadSafeClientConnManager(localBasicHttpParams, paramString1);
    }
    paramString2 = new DefaultHttpClient(a, localBasicHttpParams);
    if (a() != null)
    {
      Proxy.getDefaultHost();
      Proxy.getDefaultPort();
      paramArrayOfBasicHeader = BaseApplication.getContext();
      if (paramArrayOfBasicHeader == null)
      {
        paramString1 = Proxy.getDefaultHost();
        i = Proxy.getDefaultPort();
      }
      else
      {
        paramString1 = Proxy.getHost(paramArrayOfBasicHeader);
        i = Proxy.getPort(paramArrayOfBasicHeader);
        if ((paramString1 != null) && (paramString1.trim().length() != 0) && (i > 0)) {
          break label320;
        }
        paramString1 = Proxy.getDefaultHost();
        i = Proxy.getDefaultPort();
      }
      label320:
      if ((paramString1 != null) && (paramString1.trim().length() != 0))
      {
        j = i;
        if (i > 0) {}
      }
      else
      {
        paramArrayOfBasicHeader = b();
        paramString1 = paramArrayOfBasicHeader.a;
        j = paramArrayOfBasicHeader.b;
      }
      paramString1 = new HttpHost(paramString1, j);
      paramString2.getParams().setParameter("http.route.default-proxy", paramString1);
    }
    paramString1 = paramString2.execute(paramArrayOfByte);
    int i = paramString1.getStatusLine().getStatusCode();
    if (i == 200) {
      return paramString1.getEntity();
    }
    paramString1 = new HttpResponseException(i);
    for (;;)
    {
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.myapp.net.Http
 * JD-Core Version:    0.7.0.1
 */