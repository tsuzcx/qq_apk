package com.tencent.mobileqq.msf.core.net;

import android.net.Network;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.quicksend.f;
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
  
  public boolean a(String paramString1, int paramInt, String paramString2, f paramf)
  {
    this.b = paramString1;
    this.c = paramInt;
    try
    {
      this.m = a.aa();
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
        this.g = k.a(BaseApplication.getContext(), paramString2, 0);
      }
      paramString2 = Thread.currentThread().getName();
      if ((MsfCore.sCore != null) && (MsfCore.sCore.mMsfMonitorCallback != null) && (!TextUtils.isEmpty(paramString2)) && (paramString2.contains("LightSender"))) {
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
      paramString2 = new StringBuilder(paramf.m);
      paramString2.append("|").append(paramString1);
      paramf.m = paramString2.toString();
      QLog.d("LightTcpEngine", 1, "connect fail costtime:" + (SystemClock.elapsedRealtime() - 0L) + " reason:" + paramString1);
    }
    return false;
  }
  
  public byte[] a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, String paramString, f paramf)
  {
    int i2 = paramToServiceMsg.getRequestSsoSeq();
    long l1 = SystemClock.elapsedRealtime();
    paramToServiceMsg = "http://" + this.b + ":" + this.c;
    this.k = (paramToServiceMsg + a(paramToServiceMsg, i2));
    this.k = MsfSdkUtils.insertMtype(paramString, this.k);
    QLog.d("LightTcpEngine", 1, "try connect " + this.k + " timeout:" + this.l + " ssoseq:" + i2 + " sendByXG:" + this.g);
    paramToServiceMsg = "/" + this.k.substring(this.k.indexOf("?"));
    paramString = new StringBuffer();
    paramString.append("POST ").append(paramToServiceMsg).append(" HTTP/1.1\r\n");
    paramString.append("User-Agent: aqq\r\n");
    paramString.append("content-type: oct\r\n");
    paramString.append("Connection: Keep-Alive\r\n");
    paramString.append("Accept-Encoding: \r\n");
    paramString.append("Host: ").append(this.b).append("\r\n");
    paramString.append("Content-Length: ").append(paramArrayOfByte.length).append("\r\n\r\n");
    int n = 0;
    paramToServiceMsg = paramString.toString().getBytes();
    for (;;)
    {
      try
      {
        this.d.write(paramToServiceMsg, 0, paramToServiceMsg.length);
        this.d.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        this.d.flush();
        QLog.d("LightTcpEngine", 1, "httpSend sendByXG:" + this.g + " ssoseq:" + i2 + " len:" + paramArrayOfByte.length);
        paramToServiceMsg = this.f.readLine();
        if (paramToServiceMsg == null) {
          continue;
        }
        if (!paramToServiceMsg.startsWith("Content-Length")) {
          continue;
        }
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
      catch (IOException paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LightTcpEngine", 2, paramToServiceMsg.getMessage(), paramToServiceMsg);
        c();
        d();
        paramToServiceMsg.printStackTrace();
        return null;
        i1 = n;
        if (!TextUtils.isEmpty(paramToServiceMsg)) {
          continue;
        }
        if (n > 0) {
          continue;
        }
        throw new IOException("Content-Length: " + n + " exception");
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        continue;
        paramToServiceMsg = new byte[Math.min(n, 512)];
        paramArrayOfByte = new ByteArrayBuffer(n);
        paramString = Thread.currentThread().getName();
        int i1 = n;
        if (i1 <= 0) {
          continue;
        }
        if ((MsfCore.sCore == null) || (MsfCore.sCore.mMsfMonitorCallback == null) || (TextUtils.isEmpty(paramString)) || (!paramString.contains("LightSender"))) {
          continue;
        }
        MsfCore.sCore.mMsfMonitorCallback.handleEnd(3);
        int i3 = this.e.read(paramToServiceMsg, 0, Math.min(i1, paramToServiceMsg.length));
        if ((MsfCore.sCore == null) || (MsfCore.sCore.mMsfMonitorCallback == null) || (TextUtils.isEmpty(paramString)) || (!paramString.contains("LightSender"))) {
          continue;
        }
        MsfCore.sCore.mMsfMonitorCallback.handleStart(3);
        if (i3 <= 0) {
          continue;
        }
        i1 -= i3;
        paramArrayOfByte.append(paramToServiceMsg, 0, i3);
        continue;
        long l2 = SystemClock.elapsedRealtime();
        QLog.d("LightTcpEngine", 1, "httpRecv ssoseq:" + i2 + " len:" + n + " costtime:" + (l2 - l1));
        paramToServiceMsg = paramArrayOfByte.toByteArray();
      }
      n = i1;
      if (QLog.isDevelopLevel())
      {
        QLog.d("LightTcpEngine", 2, paramToServiceMsg);
        n = i1;
      }
    }
    return paramToServiceMsg;
  }
  
  public boolean b()
  {
    return (this.i != null) && (this.i.isConnected()) && (!this.i.isClosed());
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 222	com/tencent/mobileqq/msf/core/net/g:i	Ljava/net/Socket;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 222	com/tencent/mobileqq/msf/core/net/g:i	Ljava/net/Socket;
    //   11: invokevirtual 427	java/net/Socket:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 222	com/tencent/mobileqq/msf/core/net/g:i	Ljava/net/Socket;
    //   19: aload_0
    //   20: getfield 202	com/tencent/mobileqq/msf/core/net/g:d	Ljava/io/OutputStream;
    //   23: ifnull +15 -> 38
    //   26: aload_0
    //   27: getfield 202	com/tencent/mobileqq/msf/core/net/g:d	Ljava/io/OutputStream;
    //   30: invokevirtual 428	java/io/OutputStream:close	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 202	com/tencent/mobileqq/msf/core/net/g:d	Ljava/io/OutputStream;
    //   38: aload_0
    //   39: getfield 220	com/tencent/mobileqq/msf/core/net/g:f	Ljava/io/BufferedReader;
    //   42: ifnull +15 -> 57
    //   45: aload_0
    //   46: getfield 220	com/tencent/mobileqq/msf/core/net/g:f	Ljava/io/BufferedReader;
    //   49: invokevirtual 429	java/io/BufferedReader:close	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 220	com/tencent/mobileqq/msf/core/net/g:f	Ljava/io/BufferedReader;
    //   57: aload_0
    //   58: getfield 208	com/tencent/mobileqq/msf/core/net/g:e	Ljava/io/InputStream;
    //   61: ifnull +15 -> 76
    //   64: aload_0
    //   65: getfield 208	com/tencent/mobileqq/msf/core/net/g:e	Ljava/io/InputStream;
    //   68: invokevirtual 430	java/io/InputStream:close	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 208	com/tencent/mobileqq/msf/core/net/g:e	Ljava/io/InputStream;
    //   76: return
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 393	java/lang/Exception:printStackTrace	()V
    //   82: goto -63 -> 19
    //   85: astore_1
    //   86: return
    //   87: astore_1
    //   88: goto -31 -> 57
    //   91: astore_1
    //   92: goto -54 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	g
    //   77	2	1	localException1	Exception
    //   85	1	1	localException2	Exception
    //   87	1	1	localException3	Exception
    //   91	1	1	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   0	19	77	java/lang/Exception
    //   57	76	85	java/lang/Exception
    //   38	57	87	java/lang/Exception
    //   19	38	91	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.g
 * JD-Core Version:    0.7.0.1
 */