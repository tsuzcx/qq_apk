package com.tencent.qqprotect.qsec;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqprotect.common.QPDirUtils;
import com.tencent.qqprotect.singleupdate.VerifyFileUtil;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static boolean a = false;
  private static ConcurrentHashMap<Long, QSecFramework.IGoingUpHandler> b = new ConcurrentHashMap();
  private static Handler c = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework l = null;
  private int d = -1;
  private boolean e = false;
  private boolean f = false;
  private Handler g = null;
  private QSecRuntimeImpl h = null;
  private QSecLibMgr i = null;
  private QSecPushServiceMgr j = null;
  private QSecCbMgr k = null;
  
  static
  {
    new CrashProtector("QSec", 86400000L).a(new QSecFramework.1());
  }
  
  private QSecFramework()
  {
    this.h.a(CloudAVEngineImpl.a());
    this.h.a(RptImpl.a());
    this.h.a(CSProcessorImpl.a());
    new CrashProtector("QSec", 86400000L).a(new QSecFramework.2(this));
    this.k = new QSecCbMgr();
    this.i = new QSecLibMgr(this.k);
    this.j = new QSecPushServiceMgr(this.i, this.k);
    this.g = new QSecFramework.3(this, ThreadManager.getFileThreadLooper());
    a(2L, new QSecFramework.4(this));
  }
  
  public static int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (!a) {
      return 27;
    }
    try
    {
      int m = goingDownInternal(paramLong1, paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
      return m;
    }
    catch (UnsatisfiedLinkError paramObject1)
    {
      paramObject1.printStackTrace();
    }
    return 29;
  }
  
  public static Handler a()
  {
    return c;
  }
  
  public static void a(long paramLong, QSecFramework.IGoingUpHandler paramIGoingUpHandler)
  {
    if (paramIGoingUpHandler != null) {
      b.put(Long.valueOf(paramLong), paramIGoingUpHandler);
    }
  }
  
  public static QSecFramework c()
  {
    if (l == null) {
      try
      {
        if (l == null) {
          l = new QSecFramework();
        }
      }
      finally {}
    }
    return l;
  }
  
  private static native int goingDownInternal(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2);
  
  private static int goingUp(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    QSecFramework.IGoingUpHandler localIGoingUpHandler = (QSecFramework.IGoingUpHandler)b.get(Long.valueOf(paramLong1));
    if (localIGoingUpHandler != null) {
      return localIGoingUpHandler.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  private static boolean h()
  {
    if (a) {
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QPDirUtils.b());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("libQSec.so");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if ((localFile.exists()) && (VerifyFileUtil.a(localFile, null))) {
      try
      {
        System.load((String)localObject);
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return false;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.i.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    QSecCbMgr localQSecCbMgr = this.k;
    if (localQSecCbMgr != null) {
      localByte = Byte.valueOf(localQSecCbMgr.a(paramInt));
    }
    paramInt = localByte.byteValue();
    boolean bool = true;
    if (1 != paramInt) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.j.a(paramArrayOfByte);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void d()
  {
    if (!this.f) {
      this.f = true;
    }
    this.k.a(false);
    this.i.a(new QSecFramework.5(this));
    this.i.b();
    c.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void e()
  {
    this.i.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */