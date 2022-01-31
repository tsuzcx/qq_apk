package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.c.g;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MonitorSocketInputStream
  extends InputStream
{
  private Context context;
  private InputStream mInputStream;
  private c monitorSocketImpl;
  
  public MonitorSocketInputStream(InputStream paramInputStream, c paramc, Context paramContext)
  {
    this.mInputStream = paramInputStream;
    this.monitorSocketImpl = paramc;
    this.context = paramContext;
  }
  
  public void close()
    throws IOException
  {
    this.mInputStream.close();
  }
  
  public int hashCode()
  {
    return this.mInputStream.hashCode();
  }
  
  public int read()
    throws IOException
  {
    return this.mInputStream.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 2;
    try
    {
      paramInt2 = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 == -1) {
        return paramInt2;
      }
    }
    catch (SocketException paramArrayOfByte)
    {
      QLog.e("MSF.D.MonitorSocket", 1, "SocketException!", paramArrayOfByte);
      throw paramArrayOfByte;
    }
    catch (SocketTimeoutException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    if (MonitorSocketImplFactory.isServerSocket(toString())) {
      return paramInt2;
    }
    try
    {
      if ((this.monitorSocketImpl.d == null) || (!this.monitorSocketImpl.d.contains(":MSF"))) {
        break label178;
      }
      paramInt1 = NetConnInfoCenter.getSystemNetworkType();
      if (paramInt1 != 0) {
        break label924;
      }
      paramArrayOfByte = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramArrayOfByte == null) {
        break label924;
      }
      paramInt1 = paramArrayOfByte.getType();
      if (paramInt1 != 1) {
        break label185;
      }
      paramInt1 = i;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
        break;
        paramArrayOfByte = this.monitorSocketImpl;
        c.m.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb.a(paramInt2));
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        label113:
        QLog.d("MSF.D.MonitorSocket", 1, "read OOM.");
        label178:
        label185:
        break;
        paramArrayOfByte = this.monitorSocketImpl;
        b localb = (b)c.m.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
        if (localb == null)
        {
          localb = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.l, paramInt2, paramInt1);
          localb.i = BaseApplication.monitor.getSTATUS();
          localb.h = this.monitorSocketImpl.i;
          localb.j = this.monitorSocketImpl.e.hashCode();
          paramArrayOfByte = this.monitorSocketImpl;
          c.m.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb);
        }
        for (;;)
        {
          paramArrayOfByte = localb;
          if (localb.l != null) {
            break;
          }
          this.monitorSocketImpl.a(localb.j, c.l);
          paramArrayOfByte = localb;
          break;
          paramArrayOfByte = this.monitorSocketImpl;
          c.m.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb.a(paramInt2));
        }
        if (this.monitorSocketImpl.i != null)
        {
          paramArrayOfByte = this.monitorSocketImpl;
          paramArrayOfByte = (b)c.m.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
          if (paramArrayOfByte == null)
          {
            localb = new b(this.monitorSocketImpl.b, this.monitorSocketImpl.a, this.monitorSocketImpl.c, c.l, paramInt2, paramInt1);
            localb.h = this.monitorSocketImpl.i;
            localb.j = this.monitorSocketImpl.e.hashCode();
            paramArrayOfByte = this.monitorSocketImpl;
            c.m.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb);
          }
          for (;;)
          {
            localb.i = BaseApplication.monitor.getSTATUS();
            paramArrayOfByte = localb;
            if (localb.l != null) {
              break;
            }
            this.monitorSocketImpl.a(localb.j, c.l);
            paramArrayOfByte = localb;
            break;
            localb = paramArrayOfByte.a(paramInt2);
            localb.h = this.monitorSocketImpl.i;
          }
        }
        paramArrayOfByte = null;
        continue;
      }
    }
    if ((this.monitorSocketImpl.d != null) && (this.monitorSocketImpl.d.contains(":MSF")))
    {
      if (l.n.contains(toString())) {
        paramArrayOfByte = null;
      }
      for (;;)
      {
        if (paramArrayOfByte == null) {
          return paramInt2;
        }
        paramArrayOfByte.a = this.monitorSocketImpl.d;
        paramArrayOfByte.k = System.currentTimeMillis();
        return paramInt2;
        paramInt1 = AppNetConnInfo.getSystemNetworkType();
        break;
        if (MonitorSocketImplFactory.isNetworkTypeMobile(paramInt1) != true) {
          break label921;
        }
        paramInt1 = 1;
        break label113;
        if (!g.f.contains(toString())) {
          break label520;
        }
        paramArrayOfByte = this.monitorSocketImpl;
        localb = (b)c.m.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
        if (localb != null) {
          break label473;
        }
        localb = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.l, paramInt2, paramInt1);
        localb.h = "QualityTest";
        localb.i = BaseApplication.monitor.getSTATUS();
        localb.j = this.monitorSocketImpl.e.hashCode();
        paramArrayOfByte = this.monitorSocketImpl;
        c.m.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb);
        if (localb.l == null) {
          this.monitorSocketImpl.a(localb.j, c.l);
        }
        paramArrayOfByte = localb;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.MonitorSocket", 2, "qualityTest|" + this.monitorSocketImpl.e + "|read|" + paramInt2 + "|" + paramInt1 + "|" + "QualityTest.PushList" + "|" + BaseApplication.monitor.getSTATUS() + "|" + localb.toString());
          paramArrayOfByte = localb;
        }
      }
    }
    label473:
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketInputStream
 * JD-Core Version:    0.7.0.1
 */