package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class class
{
  public static AtomicBoolean Cd = new AtomicBoolean(false);
  public static AtomicBoolean Dd = new AtomicBoolean(false);
  public static final Object Ed;
  public static AtomicBoolean Fd;
  
  static
  {
    new AtomicBoolean(false);
    Ed = new Object();
    Fd = new AtomicBoolean(false);
    Log.d("TuringFdJava", getVersionInfo());
  }
  
  public static void a(Context paramContext, else paramelse)
  {
    if (paramContext.getApplicationContext() == null)
    {
      if (paramelse != null)
      {
        paramContext = Serpens.f(-10016);
        ((Date)paramelse).Mh.onResult(TuringFdService.a(paramContext));
      }
      return;
    }
    int i = u();
    if ((i != 0) && (paramelse != null))
    {
      Serpens localSerpens = Serpens.f(i);
      ((Date)paramelse).Mh.onResult(TuringFdService.a(localSerpens));
    }
    new break(paramelse, paramContext).start();
  }
  
  public static void a(void paramvoid)
  {
    if (Fd.get()) {
      return;
    }
    synchronized (Ed)
    {
      if ((paramvoid.ta > 0) && (final.jf == 0)) {
        final.jf = paramvoid.ta;
      }
      if (Dd.get())
      {
        b(paramvoid);
        return;
      }
    }
    if (Fd.get()) {
      return;
    }
    Fd.set(true);
    System.currentTimeMillis();
    if (!c(paramvoid))
    {
      Dd.set(false);
      return;
    }
    int i = final.jf;
    if (i == 0)
    {
      Log.i("TuringFdJava", "pleace input channel info");
      Dd.set(false);
      return;
    }
    b(paramvoid);
    Dd.set(true);
    Fd.set(false);
  }
  
  public static void b(void paramvoid)
  {
    UrsaMajor localUrsaMajor = UrsaMajor.zg;
    localUrsaMajor.Yg = paramvoid;
    if (localUrsaMajor._g) {}
    label200:
    for (;;)
    {
      Cranberry.zg.Yg = paramvoid;
      return;
      localUrsaMajor._g = true;
      this.f(paramvoid.getContext());
      Object localObject = Avocado.zg;
      paramvoid.getContext();
      ((Avocado)localObject).kh = new Solar(localUrsaMajor);
      localObject = new HandlerThread(final.jf + "_" + "xqFull", -8);
      ((HandlerThread)localObject).start();
      localUrsaMajor.Zg = new UrsaMajor.do(localUrsaMajor, ((HandlerThread)localObject).getLooper(), paramvoid.getContext());
      localUrsaMajor.ah = new Almond(localUrsaMajor.Zg);
      localObject = paramvoid.getContext();
      if (!Bryony.rh.containsKey(Bryony.th)) {}
      for (;;)
      {
        if (!localUrsaMajor.Yg.q()) {
          break label200;
        }
        new Taurus(localUrsaMajor).start();
        break;
        new Blueberry((Bryony.do)Bryony.rh.get(Bryony.th), (Context)localObject).start();
      }
    }
  }
  
  public static boolean c(void paramvoid)
  {
    boolean bool1 = true;
    if (Cd.get()) {
      return Cd.get();
    }
    if (paramvoid.s())
    {
      TextUtils.isEmpty(paramvoid.l());
      paramvoid = paramvoid.l();
      try
      {
        boolean bool2 = TextUtils.isEmpty(paramvoid);
        if (!bool2) {
          break label80;
        }
        System.loadLibrary("turingxq");
      }
      catch (Throwable paramvoid)
      {
        for (;;)
        {
          Log.w("TuringFdJava", paramvoid);
          bool1 = false;
        }
      }
      Cd.set(bool1);
      if (!bool1) {
        Log.i("TuringFdJava", "load so failure");
      }
    }
    for (;;)
    {
      return Cd.get();
      label80:
      System.load(paramvoid);
      break;
      Cd.set(true);
    }
  }
  
  public static goto g(Context paramContext)
  {
    int i = u();
    if (i != 0) {
      return Serpens.f(i);
    }
    return UrsaMajor.zg.b(paramContext, true);
  }
  
  public static String getVersionInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.getDefault(), "TuringFD v%d", new Object[] { Integer.valueOf(50) }));
    localStringBuilder.append(" (lC70462E1A7E7D017");
    localStringBuilder.append(", xqFull");
    localStringBuilder.append(", tss");
    localStringBuilder.append(String.format(Locale.getDefault(), ", compiled %s)", new Object[] { "2020_10_13_18_43_48" }));
    return localStringBuilder.toString();
  }
  
  public static int u()
  {
    if (!Cd.get()) {
      return -10001;
    }
    if (!Dd.get()) {
      return -10002;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.class
 * JD-Core Version:    0.7.0.1
 */