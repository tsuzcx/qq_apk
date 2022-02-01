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

public final class throws
  implements long
{
  public throws(String paramString) {}
  
  public long.do a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt3 = -4000;
    boolean localboolean = new boolean();
    Object localObject4 = this.Rf;
    Object localObject1 = this.get();
    Object localObject5;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject5 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject5 == null) || ((((NetworkInfo)localObject5).getState() != NetworkInfo.State.CONNECTING) && (((NetworkInfo)localObject5).getState() != NetworkInfo.State.CONNECTED)))
        {
          localObject1 = boolean.do.Rh;
          if (localObject1 != boolean.do.Rh) {
            break label223;
          }
          paramInt1 = -1052;
          if (paramInt1 == 0) {
            break;
          }
          if (paramInt1 == 0) {
            break label826;
          }
          return long.do.a(paramInt1, new byte[0]);
        }
        if (((NetworkInfo)localObject5).getType() == 1)
        {
          localObject1 = boolean.do.Oh;
          continue;
        }
        if (((NetworkInfo)localObject5).getType() == 0)
        {
          localObject5 = boolean.j((Context)localObject1);
          if ((localObject5 != null) && (((String)localObject5).length() > 0) && (boolean.k((Context)localObject1) > 0))
          {
            localObject1 = boolean.do.Ph;
            continue;
          }
          localObject1 = boolean.do.Qh;
          continue;
        }
        localObject1 = boolean.do.Qh;
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
      paramInt1 = 1;
      label203:
      if (paramInt1 != 0)
      {
        localObject2 = boolean.do.Oh;
      }
      else
      {
        localObject2 = boolean.do.Rh;
        continue;
        try
        {
          label223:
          localObject4 = new URL((String)localObject4);
          if (localObject2 == boolean.do.Ph) {}
          for (localboolean.Sf = ((HttpURLConnection)((URL)localObject4).openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(boolean.j(this.get()), boolean.k(this.get())))));; localboolean.Sf = ((HttpURLConnection)((URL)localObject4).openConnection()))
          {
            localboolean.Sf.setReadTimeout(15000);
            localboolean.Sf.setConnectTimeout(15000);
            paramInt1 = 0;
            break;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          paramInt1 = -1053;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          paramInt1 = -1000;
        }
        catch (IOException localIOException1)
        {
          Bergamot.getInstance().a(localIOException1);
          localIOException1.printStackTrace();
          paramInt1 = -1056;
        }
        catch (UnsupportedOperationException localUnsupportedOperationException)
        {
          localUnsupportedOperationException.printStackTrace();
          paramInt1 = -1059;
        }
        catch (SecurityException localSecurityException)
        {
          localSecurityException.printStackTrace();
          paramInt1 = -1058;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          paramInt1 = -1057;
        }
      }
    }
    localboolean.Tf = false;
    for (;;)
    {
      label639:
      int i;
      try
      {
        for (;;)
        {
          paramInt1 = paramArrayOfByte.length;
          localboolean.Sf.setDoOutput(true);
          localboolean.Sf.setDoInput(true);
          localboolean.Sf.setUseCaches(false);
          localObject3 = localboolean.Sf;
          ((HttpURLConnection)localObject3).setRequestMethod("POST");
          localObject3 = localboolean.Sf;
          ((HttpURLConnection)localObject3).setRequestProperty("Pragma", "no-cache");
          localObject3 = localboolean.Sf;
          ((HttpURLConnection)localObject3).setRequestProperty("Cache-Control", "no-cache");
          localboolean.Sf.setInstanceFollowRedirects(false);
          localObject3 = localboolean.Sf;
          ((HttpURLConnection)localObject3).setRequestProperty("User-Agent", "QQPimSecure");
          localObject3 = localboolean.Sf;
          ((HttpURLConnection)localObject3).setRequestProperty("Accept", "*/*");
          localObject3 = localboolean.Sf;
          ((HttpURLConnection)localObject3).setRequestProperty("Accept-Charset", "utf-8");
          localObject3 = localboolean.Sf;
          ((HttpURLConnection)localObject3).setRequestProperty("Content-Type", "application/octet-stream");
          localObject3 = localboolean.Sf;
          localObject4 = new StringBuilder();
          ((HttpURLConnection)localObject3).setRequestProperty("Content-length", "" + paramInt1);
          try
          {
            if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT > 13))
            {
              localObject3 = localboolean.Sf;
              ((HttpURLConnection)localObject3).setRequestProperty("Connection", "close");
            }
          }
          catch (Exception localException2)
          {
            break label639;
          }
          localObject3 = localboolean.Sf.getOutputStream();
          ((OutputStream)localObject3).write(paramArrayOfByte);
          ((OutputStream)localObject3).flush();
          ((OutputStream)localObject3).close();
          paramInt2 = localboolean.Sf.getResponseCode();
          if (paramInt2 == 200)
          {
            localboolean.Tf = true;
            paramInt1 = 0;
            break label1006;
            paramInt2 = paramInt1;
            if (i != 0)
            {
              localObject3 = Bergamot.getInstance();
              paramArrayOfByte = localboolean.Sf;
            }
          }
          else
          {
            try
            {
              paramArrayOfByte = paramArrayOfByte.getHeaderField("Location");
              ((Bergamot)localObject3).f("3", paramArrayOfByte);
              break;
              if (paramInt2 == -1)
              {
                paramInt1 = -2000;
                break label1006;
              }
              paramInt1 = -2000 - paramInt2;
              break label1006;
              i = 0;
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
        paramInt1 = -2000;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt1 = -2056;
      }
      catch (ProtocolException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt1 = -2051;
      }
      catch (IllegalStateException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt1 = -2061;
      }
      catch (IllegalAccessError paramArrayOfByte)
      {
        paramInt2 = -2060;
        paramArrayOfByte.printStackTrace();
        paramInt1 = paramInt2;
      }
      break;
      label826:
      localObject4 = new AtomicReference();
      Object localObject3 = localboolean.Sf;
      paramInt2 = paramInt3;
      if (localObject3 != null)
      {
        if (localboolean.Tf) {
          break label873;
        }
        paramInt2 = paramInt3;
      }
      for (;;)
      {
        if (paramInt2 != 0)
        {
          return long.do.a(paramInt2, new byte[0]);
          label873:
          paramArrayOfByte = null;
          try
          {
            localObject3 = ((HttpURLConnection)localObject3).getInputStream();
            localObject5 = new ByteArrayOutputStream();
            for (;;)
            {
              paramInt1 = ((InputStream)localObject3).read();
              if (paramInt1 == -1) {
                break;
              }
              ((ByteArrayOutputStream)localObject5).write(paramInt1);
            }
          }
          catch (IOException localIOException2)
          {
            paramInt1 = -4056;
            localIOException2.printStackTrace();
            for (;;)
            {
              ((AtomicReference)localObject4).set(paramArrayOfByte);
              paramArrayOfByte = localboolean.Sf;
              paramInt2 = paramInt1;
              if (paramArrayOfByte == null) {
                break;
              }
              paramArrayOfByte.disconnect();
              localboolean.Sf = null;
              paramInt2 = paramInt1;
              break;
              byte[] arrayOfByte = ((ByteArrayOutputStream)localObject5).toByteArray();
              paramArrayOfByte = arrayOfByte;
              paramInt1 = 0;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
              paramInt1 = paramInt3;
            }
          }
        }
      }
      return long.do.a(paramInt2, (byte[])((AtomicReference)localObject4).get());
      label1001:
      paramInt1 = 0;
      break label203;
      label1006:
      if ((paramInt2 >= 301) && (paramInt2 <= 305)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.throws
 * JD-Core Version:    0.7.0.1
 */