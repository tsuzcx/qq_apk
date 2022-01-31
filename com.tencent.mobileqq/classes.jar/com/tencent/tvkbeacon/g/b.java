package com.tencent.tvkbeacon.g;

import android.content.Context;
import com.tencent.tvkbeacon.core.a.d.a;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.c.i;

public final class b
{
  private static b b;
  private int a = 1;
  private Context c;
  private IAsyncQimeiListener d;
  private Runnable e = new b.1(this);
  private final d.a f = new b.2(this);
  
  private b(Context paramContext)
  {
    this.c = paramContext;
    QimeiSDK.getInstance().setQimeiModule(this);
    b.3 local3 = new b.3(this);
    h.a(paramContext).a(103, local3);
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new b(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public final void a()
  {
    boolean bool3 = true;
    for (;;)
    {
      try
      {
        com.tencent.tvkbeacon.core.strategy.d.a(this.c);
        if (!"n".equalsIgnoreCase(null)) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        int i;
        boolean bool2;
        c.d("[qimei] save GEN_QIMEI flag failed! ", new Object[0]);
        continue;
        boolean bool1 = bool2;
        continue;
        if (i == 0) {
          continue;
        }
        bool1 = true;
        continue;
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (d.b(this.c)) {
          bool2 = false;
        }
      }
      if (!"".equals(a.a(this.c).b())) {
        continue;
      }
      bool1 = bool3;
      c.b("[module] QIMEI query module > %S", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        com.tencent.tvkbeacon.core.strategy.d.a(this.c);
        if (h.a(this.c).a()) {
          com.tencent.tvkbeacon.core.a.b.d().a(112, this.e, 0L, 60000L);
        }
      }
      if (c() == null) {
        com.tencent.tvkbeacon.core.a.d.a().a(this.c, this.f);
      }
      return;
      "y".equalsIgnoreCase(null);
      i = 1;
      continue;
      bool1 = false;
    }
  }
  
  protected final void a(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    this.d = paramIAsyncQimeiListener;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      paramArrayOfByte = new com.tencent.tvkbeacon.core.wup.a(paramArrayOfByte);
      QimeiPackage localQimeiPackage = new QimeiPackage();
      localQimeiPackage.readFrom(paramArrayOfByte);
      if (!i.a(localQimeiPackage.qimei))
      {
        if (this.d != null)
        {
          c.a("[qimei] Async return qimei: %s", new Object[] { localQimeiPackage.qimei });
          this.d.onQimeiDispatch(localQimeiPackage.qimei);
          this.d = null;
          com.tencent.tvkbeacon.core.a.d.a();
          com.tencent.tvkbeacon.core.a.d.a(this.f);
        }
        a.a(this.c).a(localQimeiPackage.qimei);
        d.a(this.c, localQimeiPackage.qimei);
      }
      c.h("[qimei] update Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s by server.", new Object[] { localQimeiPackage.qimei, localQimeiPackage.imei, localQimeiPackage.imsi, localQimeiPackage.androidId, localQimeiPackage.mac });
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
    }
  }
  
  public final int b()
  {
    com.tencent.tvkbeacon.core.strategy.d.a(this.c);
    return this.a;
  }
  
  public final String c()
  {
    return a.a(this.c).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.g.b
 * JD-Core Version:    0.7.0.1
 */