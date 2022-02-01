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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("network type == ");
      localStringBuilder.append(this.d);
      ax.b("HttpUtil", localStringBuilder.toString());
      if (this.d == af.a.b) {}
      for (paramContext = (HttpURLConnection)paramString.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(a(paramContext), b(paramContext))));; paramContext = (HttpURLConnection)paramString.openConnection())
      {
        this.a = paramContext;
        break;
      }
      this.a.setReadTimeout(15000);
      this.a.setConnectTimeout(15000);
      return 0;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("init error: ");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -1000;
    }
    catch (IOException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("io error: ");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -1056;
    }
    catch (UnsupportedOperationException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("unsupported operation error: ");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -1059;
    }
    catch (SecurityException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("security error: ");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -1058;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("arg error: ");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -1057;
    }
    catch (MalformedURLException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("url error: ");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
    }
    return -1053;
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
    if ((localNetworkInfo != null) && ((localNetworkInfo.getState() == NetworkInfo.State.CONNECTING) || (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED)))
    {
      if (localNetworkInfo.getType() == 1) {
        return af.a.a;
      }
      if (localNetworkInfo.getType() == 0)
      {
        if ((android.net.Proxy.getDefaultHost() == null) && (android.net.Proxy.getHost(paramContext) == null)) {
          return af.a.c;
        }
        return af.a.b;
      }
      return af.a.d;
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
      paramContext = this.a;
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(i);
      paramContext.setRequestProperty("Content-length", paramString.toString());
      paramContext = this.a.getOutputStream();
      paramContext.write(paramArrayOfByte);
      paramContext.close();
      i = this.a.getResponseCode();
      paramContext = new StringBuilder();
      paramContext.append("responseCode == ");
      paramContext.append(i);
      ax.b("HttpUtil", paramContext.toString());
      if (i == 200)
      {
        this.b = true;
        return 0;
      }
      if (i == -1) {
        return -2000;
      }
      return -2000 - i;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("post error:");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -2000;
    }
    catch (IOException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("post io error:");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -2056;
    }
    catch (ProtocolException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("protocol error:");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -2051;
    }
    catch (IllegalStateException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("illegal state error:");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
      return -2061;
    }
    catch (IllegalAccessError paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("illegal access error:");
      paramString.append(paramContext.getMessage());
      ax.a("HttpUtil", paramString.toString());
      paramContext.printStackTrace();
    }
    return -2060;
  }
  
  public int a(boolean paramBoolean, AtomicReference<byte[]> paramAtomicReference)
  {
    Object localObject1 = this.a;
    int i = -4000;
    int j = i;
    if (localObject1 != null)
    {
      if (!this.b) {
        return -4000;
      }
      try
      {
        ax.b("HttpUtil", ((HttpURLConnection)localObject1).getURL());
        if (paramBoolean) {
          localObject1 = new InflaterInputStream(this.a.getInputStream());
        } else {
          localObject1 = this.a.getInputStream();
        }
        localObject1 = a((InputStream)localObject1);
        i = 0;
      }
      catch (Exception localException) {}catch (IOException localIOException)
      {
        break label109;
      }
      ax.a("HttpUtil", "response error");
      localIOException.printStackTrace();
      break label126;
      label109:
      i = -4056;
      ax.a("HttpUtil", "response io error");
      localIOException.printStackTrace();
      label126:
      Object localObject2 = null;
      paramAtomicReference.set(localObject2);
      paramAtomicReference = this.a;
      j = i;
      if (paramAtomicReference != null)
      {
        paramAtomicReference.disconnect();
        this.a = null;
        j = i;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.af
 * JD-Core Version:    0.7.0.1
 */