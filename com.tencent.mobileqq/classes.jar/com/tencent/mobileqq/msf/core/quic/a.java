package com.tencent.mobileqq.msf.core.quic;

import android.text.TextUtils;
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
  private static boolean x = false;
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
    if (QLog.isColorLevel())
    {
      paramb = new StringBuilder();
      paramb.append("create quicContext ");
      paramb.append(Integer.toHexString(hashCode()));
      paramb.append(" contextHanlde=");
      paramb.append(Long.toHexString(this.v));
      QLog.d("QuicContext", 2, paramb.toString());
    }
    c();
  }
  
  private boolean c()
  {
    boolean bool = QuicWrapper.initialize(this.v);
    if (bool) {
      x = bool;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initialized ret=");
      localStringBuilder.append(bool);
      QLog.d("QuicContext", 2, localStringBuilder.toString());
    }
    return x;
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramLong < 0L)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("clientHandle=");
      paramArrayOfByte.append(paramLong);
      paramArrayOfByte.append(" error");
      QLog.i("QuicContext", 1, paramArrayOfByte.toString());
      return -1;
    }
    int i1 = QuicWrapper.send(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    if (QLog.isDevelopLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("clientHandle=");
      paramArrayOfByte.append(paramLong);
      paramArrayOfByte.append(" send len=");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(" timeout=");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(" n=");
      paramArrayOfByte.append(i1);
      QLog.d("QuicContext", 4, paramArrayOfByte.toString());
    }
    return i1;
  }
  
  public long a()
  {
    long l1 = QuicWrapper.createSyncClient(this.v, false, false);
    StringBuilder localStringBuilder;
    if (l1 < 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("create syncNetClient failed, quicContext=");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      localStringBuilder.append(" clientHandle=");
      localStringBuilder.append(l1);
      QLog.i("QuicContext", 1, localStringBuilder.toString());
      return l1;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("create syncNetClient from quicContext=");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      localStringBuilder.append(" clientHandle=");
      localStringBuilder.append(l1);
      QLog.d("QuicContext", 2, localStringBuilder.toString());
    }
    return l1;
  }
  
  public QuicWrapper.QuicBundle a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramLong >= 0L) && (paramInt1 > 0))
    {
      localObject = QuicWrapper.recv(paramLong, paramInt1, paramInt2);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clientHandle=");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" retcode=");
        localStringBuilder.append(((QuicWrapper.QuicBundle)localObject).retcode);
        localStringBuilder.append(" recv data_len=");
        localStringBuilder.append(((QuicWrapper.QuicBundle)localObject).data_len);
        QLog.d("QuicContext", 4, localStringBuilder.toString());
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clientHandle=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" recvLen=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" error");
    QLog.i("QuicContext", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder;
    if (paramLong < 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clientHandle=");
      localStringBuilder.append(Long.toHexString(paramLong));
      localStringBuilder.append(" error");
      QLog.i("QuicContext", 1, localStringBuilder.toString());
      return;
    }
    QuicWrapper.closeConn(paramLong);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeConn clientHandle=");
      localStringBuilder.append(Long.toHexString(paramLong));
      QLog.d("QuicContext", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramLong < 0L)
    {
      paramString = new StringBuilder();
      paramString.append("clientHandle=");
      paramString.append(paramLong);
      paramString.append(" error");
      QLog.i("QuicContext", 1, paramString.toString());
      return false;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = Thread.currentThread().getName();
    if ((MsfCore.sCore != null) && (MsfCore.sCore.mMsfMonitorCallback != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("LightSender"))) {
      MsfCore.sCore.mMsfMonitorCallback.handleEnd(3);
    }
    paramInt2 = QuicWrapper.connect(paramLong, paramString, paramInt1, paramInt2);
    if ((MsfCore.sCore != null) && (MsfCore.sCore.mMsfMonitorCallback != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("LightSender"))) {
      MsfCore.sCore.mMsfMonitorCallback.handleStart(3);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("connect ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ret=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" cost=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.d("QuicContext", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 == 0) {
      bool = true;
    }
    return bool;
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
    StringBuilder localStringBuilder;
    if (paramLong < 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clientHandle=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" error");
      QLog.i("QuicContext", 1, localStringBuilder.toString());
      return;
    }
    QuicWrapper.releaseSyncClient(this.v, paramLong);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("releaseSyncClient contextHandle=");
      localStringBuilder.append(Long.toHexString(this.v));
      localStringBuilder.append(" clientHandle=");
      localStringBuilder.append(Long.toHexString(paramLong));
      QLog.d("QuicContext", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quic.a
 * JD-Core Version:    0.7.0.1
 */