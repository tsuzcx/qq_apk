package com.tencent.mobileqq.msf.core.quic;

import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.util.QLog;

public class a
{
  public static final String a = "QuicContext";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = -3;
  public static final int h = -3;
  public static final int i = -3;
  public static final int j = -2;
  public static final int k = -1;
  public static final int l = 0;
  public static final int m = -1;
  public static final int n = -2;
  public static final int o = -3;
  public static final int p = -100;
  public static final int q = -101;
  public static final int r = -102;
  public static final int s = -103;
  public static final int t = -104;
  public static final int u = -105;
  private static boolean x;
  private long v;
  private b w;
  
  public a()
  {
    this(new b());
  }
  
  public a(b paramb)
  {
    this.w = paramb;
    this.v = QuicWrapper.createQuicContext(paramb);
    if (QLog.isColorLevel()) {
      QLog.d("QuicContext", 2, "create quicContext " + Integer.toHexString(hashCode()) + " contextHanlde=" + Long.toHexString(this.v));
    }
    c();
  }
  
  private boolean c()
  {
    boolean bool = QuicWrapper.initialize(this.v);
    if (bool) {
      x = bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuicContext", 2, "initialized ret=" + bool);
    }
    return x;
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1;
    if (paramLong < 0L)
    {
      QLog.i("QuicContext", 1, "clientHandle=" + paramLong + " error");
      i1 = -1;
    }
    int i2;
    do
    {
      return i1;
      i2 = QuicWrapper.send(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      i1 = i2;
    } while (!QLog.isDevelopLevel());
    QLog.d("QuicContext", 4, "clientHandle=" + paramLong + " send len=" + paramInt1 + " timeout=" + paramInt2 + " n=" + i2);
    return i2;
  }
  
  public long a()
  {
    long l1 = QuicWrapper.createSyncClient(this.v, false, false);
    if (l1 < 0L) {
      QLog.i("QuicContext", 1, "create syncNetClient failed, quicContext=" + Integer.toHexString(hashCode()) + " clientHandle=" + l1);
    }
    while (!QLog.isColorLevel()) {
      return l1;
    }
    QLog.d("QuicContext", 2, "create syncNetClient from quicContext=" + Integer.toHexString(hashCode()) + " clientHandle=" + l1);
    return l1;
  }
  
  public QuicWrapper.QuicBundle a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramLong < 0L) || (paramInt1 <= 0))
    {
      QLog.i("QuicContext", 1, "clientHandle=" + paramLong + " recvLen=" + paramInt1 + " error");
      localObject = null;
    }
    QuicWrapper.QuicBundle localQuicBundle;
    do
    {
      return localObject;
      localQuicBundle = QuicWrapper.recv(paramLong, paramInt1, paramInt2);
      localObject = localQuicBundle;
    } while (!QLog.isDevelopLevel());
    QLog.d("QuicContext", 4, "clientHandle=" + paramLong + " retcode=" + localQuicBundle.retcode + " recv data_len=" + localQuicBundle.data_len);
    return localQuicBundle;
  }
  
  public void a(long paramLong)
  {
    if (paramLong < 0L) {
      QLog.i("QuicContext", 1, "clientHandle=" + Long.toHexString(paramLong) + " error");
    }
    do
    {
      return;
      QuicWrapper.closeConn(paramLong);
    } while (!QLog.isColorLevel());
    QLog.d("QuicContext", 2, "closeConn clientHandle=" + Long.toHexString(paramLong));
  }
  
  public boolean a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramLong < 0L)
    {
      QLog.i("QuicContext", 1, "clientHandle=" + paramLong + " error");
      return false;
    }
    long l1 = System.currentTimeMillis();
    if ((MsfCore.sCore != null) && (MsfCore.sCore.mMsfMonitorCallback != null)) {
      MsfCore.sCore.mMsfMonitorCallback.handleEnd(3);
    }
    paramInt2 = QuicWrapper.connect(paramLong, paramString, paramInt1, paramInt2);
    if ((MsfCore.sCore != null) && (MsfCore.sCore.mMsfMonitorCallback != null)) {
      MsfCore.sCore.mMsfMonitorCallback.handleStart(3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuicContext", 2, "connect " + paramString + ":" + paramInt1 + " ret=" + paramInt2 + " cost=" + (System.currentTimeMillis() - l1));
    }
    if (paramInt2 == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void b()
  {
    QuicWrapper.releaseQuicContext(this.v);
    this.v = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("QuicContext", 2, "releaseQuicContext");
    }
  }
  
  public void b(long paramLong)
  {
    if (paramLong < 0L) {
      QLog.i("QuicContext", 1, "clientHandle=" + paramLong + " error");
    }
    do
    {
      return;
      QuicWrapper.releaseSyncClient(this.v, paramLong);
    } while (!QLog.isColorLevel());
    QLog.d("QuicContext", 2, "releaseSyncClient contextHandle=" + Long.toHexString(this.v) + " clientHandle=" + Long.toHexString(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quic.a
 * JD-Core Version:    0.7.0.1
 */