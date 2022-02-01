package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class void
{
  public static AtomicBoolean la = new AtomicBoolean(false);
  public static AtomicBoolean ma = new AtomicBoolean(false);
  public static final Object na;
  public static AtomicBoolean oa;
  
  static
  {
    new AtomicBoolean(false);
    na = new Object();
    oa = new AtomicBoolean(false);
    Log.i("TuringFdJava", getVersionInfo());
  }
  
  public static int F()
  {
    if (!la.get()) {
      return -10001;
    }
    if (!ma.get()) {
      return -10002;
    }
    return 0;
  }
  
  public static void a(Context paramContext, case paramcase)
  {
    if (paramContext.getApplicationContext() == null)
    {
      if (paramcase != null)
      {
        paramContext = implements.g(-10016);
        ((catch)paramcase).pa.onResult(TuringDIDService.a(paramContext));
      }
      return;
    }
    int i = F();
    if ((i != 0) && (paramcase != null))
    {
      implements localimplements = implements.g(i);
      ((catch)paramcase).pa.onResult(TuringDIDService.a(localimplements));
    }
    new this(paramcase, paramContext).start();
  }
  
  public static void a(long paramlong)
  {
    if (oa.get()) {
      return;
    }
    synchronized (na)
    {
      int i = paramlong.K;
      if (i > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("c : ");
        localStringBuilder.append(paramlong.K);
        Log.i("TuringFdJava", localStringBuilder.toString());
        final.gc = paramlong.K;
      }
      if (ma.get())
      {
        b(paramlong);
        return;
      }
      if (oa.get()) {
        return;
      }
      oa.set(true);
      System.currentTimeMillis();
      if (!c(paramlong))
      {
        ma.set(false);
        return;
      }
      i = final.gc;
      if (i == 0)
      {
        Log.e("TuringFdJava", "pleace input channel info");
        ma.set(false);
        return;
      }
      b(paramlong);
      ma.set(true);
      oa.set(false);
      return;
    }
  }
  
  public static void b(long paramlong)
  {
    Ara localAra = Ara.rd;
    localAra.ud = paramlong;
    if (!localAra.wd)
    {
      localAra.wd = true;
      goto.l(paramlong.getContext());
      Object localObject = Centaurus.rd;
      paramlong.getContext();
      ((Centaurus)localObject).Kd = new instanceof(localAra);
      localObject = do.b("TuringFdCore_57_");
      ((StringBuilder)localObject).append(final.gc);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("gaMini");
      localObject = new HandlerThread(((StringBuilder)localObject).toString(), -8);
      ((HandlerThread)localObject).start();
      localAra.vd = new Ara.do(localAra, ((HandlerThread)localObject).getLooper(), paramlong.getContext());
      localAra.xd = new Canesatici(localAra.vd);
      localObject = paramlong.getContext();
      if (GalacticCore.Rd.containsKey(GalacticCore.Td)) {
        new Equuleus((GalacticCore.do)GalacticCore.Rd.get(GalacticCore.Td), (Context)localObject).start();
      }
      new synchronized(localAra).start();
    }
    Cepheus.rd.V(paramlong.getContext());
  }
  
  public static boolean c(long paramlong)
  {
    if (la.get()) {
      return la.get();
    }
    boolean bool2 = paramlong.D();
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(paramlong.v());
      paramlong = paramlong.v();
      try
      {
        bool2 = TextUtils.isEmpty(paramlong);
        if (bool2) {
          System.loadLibrary("turingga");
        } else {
          System.load(paramlong);
        }
      }
      catch (Throwable paramlong)
      {
        Log.w("TuringFdJava", paramlong);
        bool1 = false;
      }
      la.set(bool1);
      if (!bool1) {
        Log.e("TuringFdJava", "load so failure");
      }
    }
    else
    {
      la.set(true);
    }
    return la.get();
  }
  
  public static String getVersionInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.getDefault(), "TuringFD v%d", new Object[] { Integer.valueOf(57) }));
    localStringBuilder.append(" (E8A88861EE4A238B");
    localStringBuilder.append(", ga");
    localStringBuilder.append(", a57dcea");
    Object localObject = new StringBuilder().toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append(", ");
    localObject = new StringBuilder();
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("w");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append(String.format(Locale.getDefault(), ", compiled %s)", new Object[] { "2021_03_03_11_01_21" }));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.void
 * JD-Core Version:    0.7.0.1
 */