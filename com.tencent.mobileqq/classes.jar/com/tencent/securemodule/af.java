package com.tencent.securemodule;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.InflaterInputStream;

public class af
{
  protected HttpURLConnection a = null;
  protected boolean b = false;
  int c = -1;
  private af.a d = af.a.d;
  
  public af(Context paramContext)
  {
    this.d = c(paramContext);
  }
  
  private int a(Context paramContext, String paramString)
  {
    if (this.d == af.a.d) {
      return -1052;
    }
    try
    {
      paramString = new URL(paramString);
      ax.b("HttpUtil", "network type == " + this.d);
      if (this.d == af.a.b) {}
      for (this.a = ((HttpURLConnection)paramString.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(a(paramContext), b(paramContext)))));; this.a = ((HttpURLConnection)paramString.openConnection()))
      {
        this.a.setReadTimeout(15000);
        this.a.setConnectTimeout(15000);
        return 0;
      }
      return -1000;
    }
    catch (MalformedURLException paramContext)
    {
      ax.a("HttpUtil", "url error: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return -1053;
    }
    catch (IllegalArgumentException paramContext)
    {
      ax.a("HttpUtil", "arg error: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return -1057;
    }
    catch (SecurityException paramContext)
    {
      ax.a("HttpUtil", "security error: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return -1058;
    }
    catch (UnsupportedOperationException paramContext)
    {
      ax.a("HttpUtil", "unsupported operation error: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return -1059;
    }
    catch (IOException paramContext)
    {
      ax.a("HttpUtil", "io error: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return -1056;
    }
    catch (Exception paramContext)
    {
      ax.a("HttpUtil", "init error: " + paramContext.getMessage());
      paramContext.printStackTrace();
    }
  }
  
  public static String a(Context paramContext)
  {
    String str = android.net.Proxy.getHost(paramContext);
    if (str != null)
    {
      paramContext = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramContext = android.net.Proxy.getDefaultHost();
    }
    return paramContext;
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static int b(Context paramContext)
  {
    int j = android.net.Proxy.getPort(paramContext);
    int i = j;
    if (j <= 0) {
      i = android.net.Proxy.getDefaultPort();
    }
    return i;
  }
  
  public static af.a c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED))) {
      return af.a.d;
    }
    if (localNetworkInfo.getType() == 1) {
      return af.a.a;
    }
    if (localNetworkInfo.getType() == 0)
    {
      if ((android.net.Proxy.getDefaultHost() != null) || (android.net.Proxy.getHost(paramContext) != null)) {
        return af.a.b;
      }
      return af.a.c;
    }
    return af.a.d;
  }
  
  public int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    int i = a(paramContext, paramString);
    if (i != 0) {
      return i;
    }
    this.b = false;
    try
    {
      i = paramArrayOfByte.length;
      this.a.setDoOutput(true);
      this.a.setDoInput(true);
      this.a.setUseCaches(false);
      this.a.setRequestMethod("POST");
      this.a.setRequestProperty("User-Agent", "QQPimSecure");
      this.a.setRequestProperty("Accept", "*/*");
      this.a.setRequestProperty("Accept-Charset", "utf-8");
      this.a.setRequestProperty("Content-Type", "application/octet-stream");
      this.a.setRequestProperty("Content-length", "" + i);
      paramContext = this.a.getOutputStream();
      paramContext.write(paramArrayOfByte);
      paramContext.close();
      i = this.a.getResponseCode();
      ax.b("HttpUtil", "responseCode == " + i);
      if (i == 200)
      {
        this.b = true;
        return 0;
      }
    }
    catch (IllegalAccessError paramContext)
    {
      ax.a("HttpUtil", "illegal access error:" + paramContext.getMessage());
      paramContext.printStackTrace();
      return -2060;
      if (i == -1) {
        return -2000;
      }
      return -2000 - i;
    }
    catch (IllegalStateException paramContext)
    {
      ax.a("HttpUtil", "illegal state error:" + paramContext.getMessage());
      paramContext.printStackTrace();
      return -2061;
    }
    catch (ProtocolException paramContext)
    {
      ax.a("HttpUtil", "protocol error:" + paramContext.getMessage());
      paramContext.printStackTrace();
      return -2051;
    }
    catch (IOException paramContext)
    {
      ax.a("HttpUtil", "post io error:" + paramContext.getMessage());
      paramContext.printStackTrace();
      return -2056;
    }
    catch (Exception paramContext)
    {
      ax.a("HttpUtil", "post error:" + paramContext.getMessage());
      paramContext.printStackTrace();
    }
    return -2000;
  }
  
  public int a(boolean paramBoolean, AtomicReference<byte[]> paramAtomicReference)
  {
    int j;
    if ((this.a == null) || (!this.b))
    {
      j = -4000;
      return j;
    }
    for (;;)
    {
      try
      {
        ax.b("HttpUtil", this.a.getURL());
        if (!paramBoolean) {
          continue;
        }
        localObject1 = new InflaterInputStream(this.a.getInputStream());
        localObject1 = a((InputStream)localObject1);
        i = 0;
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        ax.a("HttpUtil", "response io error");
        localIOException.printStackTrace();
        i = -4056;
        Object localObject2 = null;
        continue;
      }
      catch (Exception localException)
      {
        ax.a("HttpUtil", "response error");
        localException.printStackTrace();
        int i = -4000;
        Object localObject3 = null;
        continue;
      }
      paramAtomicReference.set(localObject1);
      j = i;
      if (this.a == null) {
        break;
      }
      this.a.disconnect();
      this.a = null;
      return i;
      localObject1 = this.a.getInputStream();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.af
 * JD-Core Version:    0.7.0.1
 */