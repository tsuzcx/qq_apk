package com.tencent.mobileqq.msf.core.net;

import android.net.Network;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;
import org.apache.http.util.ByteArrayBuffer;

public class g
  implements b
{
  public static final String a = "LightTcpEngine";
  String b;
  int c;
  OutputStream d;
  InputStream e;
  BufferedReader f;
  boolean g = false;
  private Object h;
  private Socket i;
  private InetSocketAddress j;
  private String k;
  private int l = 10000;
  private int m = 30000;
  
  private String a(String paramString, int paramInt)
  {
    Object localObject = new Random(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("r=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(((Random)localObject).nextInt(100000)));
    localObject = localStringBuilder.toString();
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        return localStringBuilder.toString();
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&");
      paramString.append((String)localObject);
      return paramString.toString();
    }
    paramString = new StringBuilder();
    paramString.append("?");
    paramString.append((String)localObject);
    return paramString.toString();
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, com.tencent.mobileqq.msf.core.quicksend.g paramg)
  {
    this.b = paramString1;
    this.c = paramInt;
    try
    {
      this.m = a.ab();
      this.j = new InetSocketAddress(this.b, paramInt);
      paramString1 = new Socket();
      paramString1.setSoTimeout(this.m);
      paramString1.setTcpNoDelay(true);
      paramString1.setKeepAlive(true);
      paramString1.setReuseAddress(true);
      if ((this.h != null) && (Build.VERSION.SDK_INT >= 21))
      {
        paramString2 = (Network)this.h;
        paramString2.bindSocket(paramString1);
        this.g = l.a(BaseApplication.getContext(), paramString2, 0);
      }
      paramString2 = Thread.currentThread().getName();
      MsfCore localMsfCore = MsfCore.sCore;
      if ((localMsfCore != null) && (MsfCore.sCore.mMsfMonitorCallback != null) && (!TextUtils.isEmpty(paramString2)) && (paramString2.contains("LightSender"))) {
        MsfCore.sCore.mMsfMonitorCallback.handleEnd(3);
      }
      paramString1.connect(this.j, this.l);
      if ((MsfCore.sCore != null) && (MsfCore.sCore.mMsfMonitorCallback != null) && (paramString2.contains("LightSender"))) {
        MsfCore.sCore.mMsfMonitorCallback.handleStart(3);
      }
      this.d = paramString1.getOutputStream();
      this.e = paramString1.getInputStream();
      this.f = new BufferedReader(new InputStreamReader(this.e));
      this.i = paramString1;
      return true;
    }
    catch (Throwable paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightTcpEngine", 2, paramString1.getMessage(), paramString1);
      }
      paramString1.printStackTrace();
      paramString1 = e.a(paramString1.toString().toLowerCase());
      paramString2 = new StringBuilder(paramg.m);
      paramString2.append("|");
      paramString2.append(paramString1);
      paramg.m = paramString2.toString();
      paramString2 = new StringBuilder();
      paramString2.append("connect fail costtime:");
      paramString2.append(SystemClock.elapsedRealtime() - 0L);
      paramString2.append(" reason:");
      paramString2.append(paramString1);
      QLog.d("LightTcpEngine", 1, paramString2.toString());
    }
    return false;
  }
  
  public byte[] a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, String paramString, com.tencent.mobileqq.msf.core.quicksend.g paramg)
  {
    int i2 = paramToServiceMsg.getRequestSsoSeq();
    long l1 = SystemClock.elapsedRealtime();
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("http://");
    paramToServiceMsg.append(this.b);
    paramToServiceMsg.append(":");
    paramToServiceMsg.append(this.c);
    paramToServiceMsg = paramToServiceMsg.toString();
    paramg = new StringBuilder();
    paramg.append(paramToServiceMsg);
    paramg.append(a(paramToServiceMsg, i2));
    this.k = paramg.toString();
    this.k = MsfSdkUtils.insertMtype(paramString, this.k);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("try connect ");
    paramToServiceMsg.append(this.k);
    paramToServiceMsg.append(" timeout:");
    paramToServiceMsg.append(this.l);
    paramToServiceMsg.append(" ssoseq:");
    paramToServiceMsg.append(i2);
    paramToServiceMsg.append(" sendByXG:");
    paramToServiceMsg.append(this.g);
    QLog.d("LightTcpEngine", 1, paramToServiceMsg.toString());
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("/");
    paramString = this.k;
    paramToServiceMsg.append(paramString.substring(paramString.indexOf("?")));
    paramToServiceMsg = paramToServiceMsg.toString();
    paramString = new StringBuffer();
    paramString.append("POST ");
    paramString.append(paramToServiceMsg);
    paramString.append(" HTTP/1.1\r\n");
    paramString.append("User-Agent: aqq\r\n");
    paramString.append("content-type: oct\r\n");
    paramString.append("Connection: Keep-Alive\r\n");
    paramString.append("Accept-Encoding: \r\n");
    paramString.append("Host: ");
    paramString.append(this.b);
    paramString.append("\r\n");
    paramString.append("Content-Length: ");
    paramString.append(paramArrayOfByte.length);
    paramString.append("\r\n\r\n");
    paramToServiceMsg = paramString.toString().getBytes();
    try
    {
      this.d.write(paramToServiceMsg, 0, paramToServiceMsg.length);
      this.d.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      this.d.flush();
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("httpSend sendByXG:");
      paramToServiceMsg.append(this.g);
      paramToServiceMsg.append(" ssoseq:");
      paramToServiceMsg.append(i2);
      paramToServiceMsg.append(" len:");
      paramToServiceMsg.append(paramArrayOfByte.length);
      QLog.d("LightTcpEngine", 1, paramToServiceMsg.toString());
      int n = 0;
      int i1;
      for (;;)
      {
        paramToServiceMsg = this.f.readLine();
        if (paramToServiceMsg == null) {
          break;
        }
        if (paramToServiceMsg.startsWith("Content-Length"))
        {
          paramArrayOfByte = paramToServiceMsg.split(":");
          i1 = n;
          if (paramArrayOfByte != null)
          {
            i1 = n;
            if (paramArrayOfByte.length == 2) {
              i1 = Integer.parseInt(paramArrayOfByte[1].trim());
            }
          }
        }
        else
        {
          i1 = n;
          if (TextUtils.isEmpty(paramToServiceMsg)) {
            break;
          }
        }
        n = i1;
        if (QLog.isDevelopLevel())
        {
          QLog.d("LightTcpEngine", 2, paramToServiceMsg);
          n = i1;
        }
      }
      if (n > 0)
      {
        paramArrayOfByte = new byte[Math.min(n, 512)];
        paramToServiceMsg = new ByteArrayBuffer(n);
        paramString = Thread.currentThread().getName();
        i1 = n;
        while (i1 > 0)
        {
          paramg = MsfCore.sCore;
          if ((paramg != null) && (MsfCore.sCore.mMsfMonitorCallback != null) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("LightSender"))) {
            MsfCore.sCore.mMsfMonitorCallback.handleEnd(3);
          }
          int i3 = this.e.read(paramArrayOfByte, 0, Math.min(i1, paramArrayOfByte.length));
          if ((MsfCore.sCore != null) && (MsfCore.sCore.mMsfMonitorCallback != null) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("LightSender"))) {
            MsfCore.sCore.mMsfMonitorCallback.handleStart(3);
          }
          if (i3 <= 0) {
            break;
          }
          i1 -= i3;
          paramToServiceMsg.append(paramArrayOfByte, 0, i3);
        }
        long l2 = SystemClock.elapsedRealtime();
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("httpRecv ssoseq:");
        paramArrayOfByte.append(i2);
        paramArrayOfByte.append(" len:");
        paramArrayOfByte.append(n);
        paramArrayOfByte.append(" costtime:");
        paramArrayOfByte.append(l2 - l1);
        QLog.d("LightTcpEngine", 1, paramArrayOfByte.toString());
        return paramToServiceMsg.toByteArray();
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("Content-Length: ");
      paramToServiceMsg.append(n);
      paramToServiceMsg.append(" exception");
      throw new IOException(paramToServiceMsg.toString());
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    catch (IOException paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightTcpEngine", 2, paramToServiceMsg.getMessage(), paramToServiceMsg);
      }
      c();
      d();
      paramToServiceMsg.printStackTrace();
    }
    return null;
  }
  
  public boolean b()
  {
    Socket localSocket = this.i;
    return (localSocket != null) && (localSocket.isConnected()) && (!this.i.isClosed());
  }
  
  public void c()
  {
    try
    {
      if (this.i != null)
      {
        this.i.close();
        this.i = null;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      if (this.d != null)
      {
        this.d.close();
        this.d = null;
      }
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          if (this.f != null)
          {
            this.f.close();
            this.f = null;
          }
          try
          {
            label65:
            if (this.e != null)
            {
              this.e.close();
              this.e = null;
            }
            return;
          }
          catch (Exception localException4) {}
          localException2 = localException2;
        }
      }
      catch (Exception localException3)
      {
        break label65;
      }
    }
  }
  
  public void d()
  {
    this.i = null;
    this.h = null;
    this.j = null;
  }
  
  public Object e()
  {
    return this.h;
  }
  
  public Socket f()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.g
 * JD-Core Version:    0.7.0.1
 */