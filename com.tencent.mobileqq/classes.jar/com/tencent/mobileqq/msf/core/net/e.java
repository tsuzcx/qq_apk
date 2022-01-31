package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import org.apache.http.util.ByteArrayBuffer;

public class e
  implements b
{
  private static final String b = "LightHttpEngine";
  boolean a = false;
  private String c;
  private URL d;
  private int e = 10000;
  private int f = 30000;
  private int g = 0;
  private Object h;
  private HttpURLConnection i;
  private int j;
  private String k;
  
  public e(int paramInt)
  {
    this.g = paramInt;
  }
  
  public static String a(String paramString)
  {
    if (NetConnInfoCenter.getSystemNetworkType() == 0) {
      return x.m.toString();
    }
    if (paramString.indexOf("illegal") > -1) {
      return x.g.toString();
    }
    if (paramString.indexOf("route to host") > -1) {
      return x.q.toString();
    }
    if (paramString.indexOf("unreachable") > -1) {
      return x.m.toString();
    }
    if (paramString.indexOf("permission") > -1) {
      return x.i.toString();
    }
    if (paramString.indexOf("refused") > -1) {
      return x.s.toString();
    }
    if (paramString.indexOf("reset") > -1) {
      return x.r.toString();
    }
    if ((paramString.indexOf("timeoutexception") > -1) || (paramString.indexOf(") after") > -1)) {
      return x.t.toString();
    }
    if (paramString.indexOf("unknownhost") > -1) {
      return x.p.toString();
    }
    if (paramString.indexOf("unresolved") > -1) {
      return x.o.toString();
    }
    if (paramString.indexOf("enotsock") > -1) {
      return x.h.toString();
    }
    if (paramString.indexOf("enobufs") > -1) {
      return x.l.toString();
    }
    if (paramString.indexOf("ebadf") > -1) {
      return x.j.toString();
    }
    if (paramString.indexOf("operation") > -1) {
      return x.t.toString();
    }
    if (paramString.indexOf("invalid") > -1) {
      return x.n.toString();
    }
    return x.u.toString();
  }
  
  private String a(String paramString, int paramInt)
  {
    Object localObject = new Random(System.currentTimeMillis());
    localObject = "r=" + paramInt + "_" + String.valueOf(((Random)localObject).nextInt(100000));
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?")) {
        return paramString + (String)localObject;
      }
      return (String)localObject + "&" + (String)localObject;
    }
    return "?" + (String)localObject;
  }
  
  private URLConnection a(URL paramURL)
  {
    try
    {
      paramURL = paramURL.openConnection();
      if (!QLog.isColorLevel()) {
        break label85;
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightHttpEngine", 2, "openConnection by default wifi=" + NetConnInfoCenter.isWifiConn() + " " + paramURL);
        }
        return paramURL;
      }
      catch (Throwable localThrowable2)
      {
        break label52;
      }
      localThrowable1 = localThrowable1;
      paramURL = null;
    }
    label52:
    QLog.w("LightHttpEngine", 1, "openConnection error: wifi=" + NetConnInfoCenter.isWifiConn());
    label85:
    localThrowable1.printStackTrace();
    return paramURL;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, f paramf)
  {
    long l2 = 0L;
    this.a = false;
    long l1 = l2;
    for (;;)
    {
      try
      {
        this.f = a.ab();
        l1 = l2;
        paramString1 = "http://" + paramString1 + ":" + paramInt;
        l1 = l2;
        this.c = (paramString1 + a(paramString1, this.g));
        l1 = l2;
        this.c = MsfSdkUtils.insertMtype(paramString2, this.c);
        l1 = l2;
        QLog.d("LightHttpEngine", 1, "LightHttpEngine try connect " + this.c + " timeout:" + this.e + " ssoseq:" + this.g);
        l1 = l2;
        l2 = SystemClock.elapsedRealtime();
        l1 = l2;
        System.setProperty("http.keepAlive", "false");
        l1 = l2;
        this.d = new URL(this.c);
        l1 = l2;
        this.i = ((HttpURLConnection)a(this.d));
        l1 = l2;
        this.i.setDoOutput(true);
        l1 = l2;
        this.i.setDoInput(true);
        l1 = l2;
        this.i.setUseCaches(false);
        l1 = l2;
        this.i.setReadTimeout(this.f);
        l1 = l2;
        this.i.setRequestMethod("POST");
        l1 = l2;
        this.i.setRequestProperty("User-Agent", "aqq");
        l1 = l2;
        this.i.setRequestProperty("content-type", "oct");
        l1 = l2;
        this.i.setConnectTimeout(this.e);
        l1 = l2;
        this.i.setRequestProperty("Connection", "close");
        l1 = l2;
        this.i.setRequestProperty("Accept-Encoding", "");
        l1 = l2;
        this.i.connect();
        l1 = l2;
        long l3 = SystemClock.elapsedRealtime();
        l1 = l2;
        this.a = true;
        l1 = l2;
        QLog.d("LightHttpEngine", 1, "LightHttpEngine connect " + this.c + " succ costtime:" + (l3 - l2) + " ssoseq:" + this.g + " readTimeout:" + this.f);
        return this.a;
      }
      catch (Throwable paramString1)
      {
        l2 = SystemClock.elapsedRealtime();
        this.a = false;
      }
      try
      {
        if (this.i != null) {
          this.i.disconnect();
        }
        paramString1.printStackTrace();
        paramString1 = a(paramString1.toString().toLowerCase());
        paramString2 = new StringBuilder(paramf.m);
        paramString2.append("|").append(paramString1);
        paramf.m = paramString2.toString();
        QLog.d("LightHttpEngine", 1, "LightHttpEngine connect " + this.c + " fail costtime:" + (l2 - l1) + " ssoseq:" + this.g + " reason:" + paramString1);
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
  }
  
  public byte[] a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, String paramString, f paramf)
  {
    byte[] arrayOfByte = null;
    OutputStream localOutputStream2 = null;
    ByteArrayBuffer localByteArrayBuffer = null;
    Object localObject2 = null;
    long l1 = 0L;
    Object localObject1 = localObject2;
    OutputStream localOutputStream1 = localOutputStream2;
    paramToServiceMsg = localByteArrayBuffer;
    paramString = arrayOfByte;
    for (;;)
    {
      try
      {
        l2 = SystemClock.elapsedRealtime();
        localObject1 = localObject2;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = localByteArrayBuffer;
        paramString = arrayOfByte;
        localOutputStream2 = this.i.getOutputStream();
        localObject1 = localObject2;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = localByteArrayBuffer;
        paramString = localOutputStream2;
        localOutputStream2.write(paramArrayOfByte);
        localObject1 = localObject2;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = localByteArrayBuffer;
        paramString = localOutputStream2;
        localOutputStream2.flush();
        localObject1 = localObject2;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = localByteArrayBuffer;
        paramString = localOutputStream2;
        QLog.d("LightHttpEngine", 1, "LightHttpEngine httpSend ssoseq:" + this.g + " len:" + paramArrayOfByte.length);
        localObject1 = localObject2;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = localByteArrayBuffer;
        paramString = localOutputStream2;
        this.j = this.i.getResponseCode();
        localObject1 = localObject2;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = localByteArrayBuffer;
        paramString = localOutputStream2;
        this.k = this.i.getURL().getHost();
        localObject1 = localObject2;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = localByteArrayBuffer;
        paramString = localOutputStream2;
        paramArrayOfByte = this.i.getInputStream();
        localObject1 = paramArrayOfByte;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = paramArrayOfByte;
        paramString = localOutputStream2;
        localObject2 = new BufferedInputStream(paramArrayOfByte);
        localObject1 = paramArrayOfByte;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = paramArrayOfByte;
        paramString = localOutputStream2;
        localByteArrayBuffer = new ByteArrayBuffer(1024);
        localObject1 = paramArrayOfByte;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = paramArrayOfByte;
        paramString = localOutputStream2;
        arrayOfByte = new byte[50];
        localObject1 = paramArrayOfByte;
        l1 = l2;
        localOutputStream1 = localOutputStream2;
        paramToServiceMsg = paramArrayOfByte;
        paramString = localOutputStream2;
        m = ((BufferedInputStream)localObject2).read(arrayOfByte);
        if (m == -1)
        {
          localObject1 = paramArrayOfByte;
          l1 = l2;
          localOutputStream1 = localOutputStream2;
          paramToServiceMsg = paramArrayOfByte;
          paramString = localOutputStream2;
          long l3 = SystemClock.elapsedRealtime();
          localObject1 = paramArrayOfByte;
          l1 = l2;
          localOutputStream1 = localOutputStream2;
          paramToServiceMsg = paramArrayOfByte;
          paramString = localOutputStream2;
          QLog.d("LightHttpEngine", 1, "LightHttpEngine httpRecv ssoseq:" + this.g + " len:" + localByteArrayBuffer.length() + " costtime:" + (l3 - l2));
          localObject1 = paramArrayOfByte;
          l1 = l2;
          localOutputStream1 = localOutputStream2;
          paramToServiceMsg = paramArrayOfByte;
          paramString = localOutputStream2;
          localObject2 = localByteArrayBuffer.toByteArray();
          if (localOutputStream2 == null) {}
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        int m;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramString = localOutputStream1;
        long l2 = SystemClock.elapsedRealtime();
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramString = localOutputStream1;
        paramArrayOfByte.printStackTrace();
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramString = localOutputStream1;
        paramf.h = paramArrayOfByte.toString();
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramString = localOutputStream1;
        QLog.d("LightHttpEngine", 1, "LightHttpEngine httpSend fail ssoseq:" + this.g + " costtime:" + (l2 - l1) + " reason:" + paramArrayOfByte.toString());
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramString = localOutputStream1;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = (ToServiceMsg)localObject1;
          paramString = localOutputStream1;
          QLog.d("LightHttpEngine", 2, paramArrayOfByte, new Object[0]);
        }
        if (localOutputStream1 != null) {}
        try
        {
          localOutputStream1.close();
          if (localObject1 != null) {
            ((InputStream)localObject1).close();
          }
        }
        catch (Throwable paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          continue;
        }
        return null;
      }
      finally
      {
        if (paramString != null) {}
        try
        {
          paramString.close();
          if (paramToServiceMsg != null) {
            paramToServiceMsg.close();
          }
        }
        catch (Throwable paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          continue;
        }
      }
      try
      {
        localOutputStream2.close();
        if (paramArrayOfByte != null) {
          paramArrayOfByte.close();
        }
        return localObject2;
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      localObject1 = paramArrayOfByte;
      l1 = l2;
      localOutputStream1 = localOutputStream2;
      paramToServiceMsg = paramArrayOfByte;
      paramString = localOutputStream2;
      localByteArrayBuffer.append(arrayOfByte, 0, m);
    }
    return localObject2;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public void c()
  {
    QLog.d("LightHttpEngine", 1, "LightHttpEngine disconn " + this.c + " ssoseq:" + this.g);
    this.a = false;
    if (this.i != null)
    {
      this.i.disconnect();
      this.i = null;
    }
  }
  
  public void d()
  {
    this.c = null;
    this.d = null;
    this.e = 10000;
    this.i = null;
    this.j = 0;
    this.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.e
 * JD-Core Version:    0.7.0.1
 */