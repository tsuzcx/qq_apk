package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class class
{
  public static AtomicBoolean ka = new AtomicBoolean(false);
  public static AtomicBoolean la = new AtomicBoolean(false);
  public static final Object ma;
  public static AtomicBoolean na;
  
  static
  {
    new AtomicBoolean(false);
    ma = new Object();
    na = new AtomicBoolean(false);
    Log.d("TuringFdJava", getVersionInfo());
  }
  
  public static int D()
  {
    if (!ka.get()) {
      return -10001;
    }
    if (!la.get()) {
      return -10002;
    }
    return 0;
  }
  
  public static void a(Context paramContext, goto paramgoto)
  {
    if (paramContext.getApplicationContext() == null)
    {
      if (paramgoto != null)
      {
        paramContext = instanceof.g(-10016);
        ((char)paramgoto).U.onResult(TuringDIDService.a(paramContext));
      }
      return;
    }
    int i = D();
    if ((i != 0) && (paramgoto != null))
    {
      instanceof localinstanceof = instanceof.g(i);
      ((char)paramgoto).U.onResult(TuringDIDService.a(localinstanceof));
    }
    new catch(paramgoto, paramContext).start();
  }
  
  public static void a(break parambreak)
  {
    if (na.get()) {
      return;
    }
    synchronized (ma)
    {
      if ((parambreak.S > 0) && (final.Rb == 0)) {
        final.Rb = parambreak.S;
      }
      if (la.get())
      {
        b(parambreak);
        return;
      }
      if (na.get()) {
        return;
      }
      na.set(true);
      System.currentTimeMillis();
      if (!c(parambreak))
      {
        la.set(false);
        return;
      }
      int i = final.Rb;
      if (i == 0)
      {
        Log.i("TuringFdJava", "pleace input channel info");
        la.set(false);
        return;
      }
      b(parambreak);
      la.set(true);
      na.set(false);
      return;
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, String paramString)
  {
    if (paramStringBuilder.toString().length() > 0) {
      paramStringBuilder.append(";");
    }
    paramStringBuilder.append(paramString);
  }
  
  public static void b(break parambreak)
  {
    Ara localAra = Ara.ad;
    localAra.ed = parambreak;
    if (localAra.hd) {
      return;
    }
    localAra.hd = true;
    void.l(parambreak.getContext());
    Object localObject = Centaurus.ad;
    parambreak.getContext();
    ((Centaurus)localObject).wd = new synchronized(localAra);
    localObject = do.b("TuringFdCore_55_");
    ((StringBuilder)localObject).append(final.Rb);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("wxaMini");
    localObject = new HandlerThread(((StringBuilder)localObject).toString(), -8);
    ((HandlerThread)localObject).start();
    localAra.gd = new Ara.do(localAra, ((HandlerThread)localObject).getLooper(), parambreak.getContext());
    localAra.jd = new Canesatici(localAra.gd);
    parambreak = parambreak.getContext();
    if (GalacticCore.Dd.containsKey(GalacticCore.Fd)) {
      new Equuleus((GalacticCore.do)GalacticCore.Dd.get(GalacticCore.Fd), parambreak).start();
    }
    if (!localAra.ed.z()) {
      return;
    }
    new Andromeda(localAra).start();
  }
  
  public static boolean c(break parambreak)
  {
    if (ka.get()) {
      return ka.get();
    }
    boolean bool2 = parambreak.B();
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(parambreak.t());
      parambreak = parambreak.t();
      try
      {
        bool2 = TextUtils.isEmpty(parambreak);
        if (bool2) {
          System.loadLibrary("108168wxa");
        } else {
          System.load(parambreak);
        }
      }
      catch (Throwable parambreak)
      {
        Log.w("TuringFdJava", parambreak);
        bool1 = false;
      }
      ka.set(bool1);
      if (!bool1) {
        Log.i("TuringFdJava", "load so failure");
      }
    }
    else
    {
      ka.set(true);
    }
    return ka.get();
  }
  
  public static String getVersionInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.getDefault(), "TuringFD v%d", new Object[] { Integer.valueOf(55) }));
    localStringBuilder.append(" (3A97F0A08AC35FBC");
    localStringBuilder.append(", wxa");
    localStringBuilder.append(", 73e4edd");
    Object localObject = new StringBuilder().toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append(", ");
    localObject = new StringBuilder();
    a((StringBuilder)localObject, "w");
    a((StringBuilder)localObject, "108168");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append(String.format(Locale.getDefault(), ", compiled %s)", new Object[] { "2020_11_05_18_07_13" }));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.class
 * JD-Core Version:    0.7.0.1
 */