package com.tencent.qmsp.sdk.c;

import android.os.Handler;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.d.e;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  private static final byte[][] i = { { 52, 125, -93 }, { 41, 121, -79, 113, 35, 43, 57, -18, 42 } };
  private static boolean j = false;
  private static ConcurrentHashMap<Long, f.f> k = new ConcurrentHashMap();
  private static Handler l = null;
  private static volatile f m = null;
  private int a = -1;
  private boolean b = false;
  private boolean c = false;
  private Handler d = null;
  private l e = null;
  private k f = null;
  private com.tencent.qmsp.sdk.d.c g = null;
  private g h = null;
  
  private f()
  {
    if (QmspSDK.getContext() == null) {
      return;
    }
    j();
    this.e = new l();
    this.e.a(n.b());
    new a(c(0), 86400000L).a(new f.b(this));
    this.h = g.d();
    this.f = k.e();
    this.f.a(this.h);
    this.d = new f.c(this, com.tencent.qmsp.sdk.app.b.e().c());
    a(2L, new f.d(this));
  }
  
  public static int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (!j) {
      return 27;
    }
    try
    {
      int n = goingDownInternal(paramLong1, paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
      return n;
    }
    catch (UnsatisfiedLinkError paramObject1)
    {
      paramObject1.printStackTrace();
    }
    return 29;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof String)) && (paramObject1 != null))
    {
      if (!j) {
        return null;
      }
      long l1 = paramInt1;
      long l2 = paramInt2;
      long l3 = paramInt3;
      long l4 = paramInt4;
      try
      {
        paramObject1 = goingDownInternal(l1, l2, l3, l4, paramObject1, paramObject2);
        return paramObject1;
      }
      catch (Exception paramObject1)
      {
        paramObject1.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(long paramLong, f.f paramf)
  {
    if (paramf != null) {
      k.put(Long.valueOf(paramLong), paramf);
    }
  }
  
  private static String c(int paramInt)
  {
    return com.tencent.qmsp.sdk.f.k.a(i[paramInt]);
  }
  
  private static native int goingDownInternal(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2);
  
  private static native String goingDownInternal(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2);
  
  private static int goingUp(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    f.f localf = (f.f)k.get(Long.valueOf(paramLong1));
    if (localf != null) {
      return localf.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public static f i()
  {
    if (m == null) {
      try
      {
        if (m == null) {
          m = new f();
        }
      }
      finally {}
    }
    return m;
  }
  
  private void j()
  {
    new a(c(0), 86400000L).a(new f.a(this));
    l = new Handler(com.tencent.qmsp.sdk.app.b.e().c());
  }
  
  private static boolean k()
  {
    if (j) {
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(com.tencent.qmsp.sdk.a.b.b());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(c(1));
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if ((localFile.exists()) && (e.b(localFile, null))) {
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
    return this.f.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    g localg = this.h;
    if (localg != null) {
      paramInt = localg.a(paramInt);
    } else {
      paramInt = -1;
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (1 != paramInt) {
      if (!b.b) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    return Boolean.valueOf(bool1);
  }
  
  public void a()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((g)localObject).a();
    }
    localObject = this.f;
    if (localObject != null) {
      ((k)localObject).a();
    }
    if (m != null) {
      m = null;
    }
  }
  
  public void a(com.tencent.qmsp.sdk.d.c paramc)
  {
    this.g = paramc;
  }
  
  public g b()
  {
    return this.h;
  }
  
  public Handler c()
  {
    return l;
  }
  
  public com.tencent.qmsp.sdk.d.c d()
  {
    return this.g;
  }
  
  public void e()
  {
    this.f.b();
  }
  
  public void f()
  {
    if (!this.c) {
      this.c = true;
    }
    if (b.b)
    {
      com.tencent.qmsp.sdk.e.a.a();
      com.tencent.qmsp.sdk.e.c.a();
    }
    com.tencent.qmsp.sdk.e.b.a();
    if (b.b)
    {
      this.f.a(new f.e(this));
      this.f.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.f
 * JD-Core Version:    0.7.0.1
 */