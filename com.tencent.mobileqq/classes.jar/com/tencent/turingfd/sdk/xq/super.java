package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public final class super
  implements goto
{
  public super(String paramString) {}
  
  public goto.do b(int paramInt, byte[] paramArrayOfByte)
  {
    int j = -4000;
    throw localthrow = new throw();
    Object localObject4 = this.Hb;
    Object localObject1 = for.get();
    Object localObject5;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject5 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject5 == null) || ((((NetworkInfo)localObject5).getState() != NetworkInfo.State.CONNECTING) && (((NetworkInfo)localObject5).getState() != NetworkInfo.State.CONNECTED)))
        {
          localObject1 = throw.do.Cc;
          if (localObject1 != throw.do.Cc) {
            break label223;
          }
          paramInt = -1052;
          if (paramInt == 0) {
            break;
          }
          if (paramInt == 0) {
            break label826;
          }
          return goto.do.a(paramInt, new byte[0]);
        }
        if (((NetworkInfo)localObject5).getType() == 1)
        {
          localObject1 = throw.do.zc;
          continue;
        }
        if (((NetworkInfo)localObject5).getType() == 0)
        {
          localObject5 = throw.j((Context)localObject1);
          if ((localObject5 != null) && (((String)localObject5).length() > 0) && (throw.k((Context)localObject1) > 0))
          {
            localObject1 = throw.do.Ac;
            continue;
          }
          localObject1 = throw.do.Bc;
          continue;
        }
        localObject1 = throw.do.Bc;
        continue;
        if (!((String)localObject2).contains("ACCESS_NETWORK_STATE")) {
          break label1001;
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject2 = localThrowable1.getMessage();
        if (localObject2 == null) {
          break label1001;
        }
      }
      paramInt = 1;
      label203:
      if (paramInt != 0)
      {
        localObject2 = throw.do.zc;
      }
      else
      {
        localObject2 = throw.do.Cc;
        continue;
        try
        {
          label223:
          localObject4 = new URL((String)localObject4);
          if (localObject2 == throw.do.Ac) {}
          for (localthrow.Ib = ((HttpURLConnection)((URL)localObject4).openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(throw.j(for.get()), throw.k(for.get())))));; localthrow.Ib = ((HttpURLConnection)((URL)localObject4).openConnection()))
          {
            localthrow.Ib.setReadTimeout(15000);
            localthrow.Ib.setConnectTimeout(15000);
            paramInt = 0;
            break;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          paramInt = -1053;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          paramInt = -1000;
        }
        catch (IOException localIOException1)
        {
          private.getInstance().a(localIOException1);
          localIOException1.printStackTrace();
          paramInt = -1056;
        }
        catch (UnsupportedOperationException localUnsupportedOperationException)
        {
          localUnsupportedOperationException.printStackTrace();
          paramInt = -1059;
        }
        catch (SecurityException localSecurityException)
        {
          localSecurityException.printStackTrace();
          paramInt = -1058;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          paramInt = -1057;
        }
      }
    }
    localthrow.Jb = false;
    for (;;)
    {
      label639:
      int k;
      try
      {
        for (;;)
        {
          paramInt = paramArrayOfByte.length;
          localthrow.Ib.setDoOutput(true);
          localthrow.Ib.setDoInput(true);
          localthrow.Ib.setUseCaches(false);
          localObject3 = localthrow.Ib;
          ((HttpURLConnection)localObject3).setRequestMethod("POST");
          localObject3 = localthrow.Ib;
          ((HttpURLConnection)localObject3).setRequestProperty("Pragma", "no-cache");
          localObject3 = localthrow.Ib;
          ((HttpURLConnection)localObject3).setRequestProperty("Cache-Control", "no-cache");
          localthrow.Ib.setInstanceFollowRedirects(false);
          localObject3 = localthrow.Ib;
          ((HttpURLConnection)localObject3).setRequestProperty("User-Agent", "QQPimSecure");
          localObject3 = localthrow.Ib;
          ((HttpURLConnection)localObject3).setRequestProperty("Accept", "*/*");
          localObject3 = localthrow.Ib;
          ((HttpURLConnection)localObject3).setRequestProperty("Accept-Charset", "utf-8");
          localObject3 = localthrow.Ib;
          ((HttpURLConnection)localObject3).setRequestProperty("Content-Type", "application/octet-stream");
          localObject3 = localthrow.Ib;
          localObject4 = new StringBuilder();
          ((HttpURLConnection)localObject3).setRequestProperty("Content-length", "" + paramInt);
          try
          {
            if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT > 13))
            {
              localObject3 = localthrow.Ib;
              ((HttpURLConnection)localObject3).setRequestProperty("Connection", "close");
            }
          }
          catch (Exception localException2)
          {
            break label639;
          }
          localObject3 = localthrow.Ib.getOutputStream();
          ((OutputStream)localObject3).write(paramArrayOfByte);
          ((OutputStream)localObject3).flush();
          ((OutputStream)localObject3).close();
          i = localthrow.Ib.getResponseCode();
          if (i == 200)
          {
            localthrow.Jb = true;
            paramInt = 0;
            break label1006;
            i = paramInt;
            if (k != 0)
            {
              localObject3 = private.getInstance();
              paramArrayOfByte = localthrow.Ib;
            }
          }
          else
          {
            try
            {
              paramArrayOfByte = paramArrayOfByte.getHeaderField("Location");
              ((private)localObject3).b("3", paramArrayOfByte);
              break;
              if (i == -1)
              {
                paramInt = -2000;
                break label1006;
              }
              paramInt = -2000 - i;
              break label1006;
              k = 0;
            }
            catch (Exception paramArrayOfByte)
            {
              for (;;)
              {
                paramArrayOfByte = "";
              }
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = -2000;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = -2056;
      }
      catch (ProtocolException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = -2051;
      }
      catch (IllegalStateException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = -2061;
      }
      catch (IllegalAccessError paramArrayOfByte)
      {
        i = -2060;
        paramArrayOfByte.printStackTrace();
        paramInt = i;
      }
      break;
      label826:
      localObject4 = new AtomicReference();
      Object localObject3 = localthrow.Ib;
      int i = j;
      if (localObject3 != null)
      {
        if (localthrow.Jb) {
          break label873;
        }
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          return goto.do.a(i, new byte[0]);
          label873:
          paramArrayOfByte = null;
          try
          {
            localObject3 = ((HttpURLConnection)localObject3).getInputStream();
            localObject5 = new ByteArrayOutputStream();
            for (;;)
            {
              paramInt = ((InputStream)localObject3).read();
              if (paramInt == -1) {
                break;
              }
              ((ByteArrayOutputStream)localObject5).write(paramInt);
            }
          }
          catch (IOException localIOException2)
          {
            paramInt = -4056;
            localIOException2.printStackTrace();
            for (;;)
            {
              ((AtomicReference)localObject4).set(paramArrayOfByte);
              paramArrayOfByte = localthrow.Ib;
              i = paramInt;
              if (paramArrayOfByte == null) {
                break;
              }
              paramArrayOfByte.disconnect();
              localthrow.Ib = null;
              i = paramInt;
              break;
              byte[] arrayOfByte = ((ByteArrayOutputStream)localObject5).toByteArray();
              paramArrayOfByte = arrayOfByte;
              paramInt = 0;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
              paramInt = j;
            }
          }
        }
      }
      return goto.do.a(i, (byte[])((AtomicReference)localObject4).get());
      label1001:
      paramInt = 0;
      break label203;
      label1006:
      if ((i >= 301) && (i <= 305)) {
        k = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.super
 * JD-Core Version:    0.7.0.1
 */