package com.tencent.turingfd.sdk.xq;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class while
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  public static AtomicBoolean b = new AtomicBoolean(false);
  public static final Object c;
  public static AtomicBoolean d;
  
  static
  {
    new AtomicBoolean(false);
    c = new Object();
    d = new AtomicBoolean(false);
    Log.i("TuringFdJava", b());
  }
  
  public static int a()
  {
    if (!a.get()) {
      return -10001;
    }
    if (!b.get()) {
      return -10002;
    }
    return 0;
  }
  
  public static break a(Context paramContext)
  {
    int i = a();
    if (i != 0) {
      return Chestnut.a(i);
    }
    return Cranberry.a.a(paramContext, true, 1);
  }
  
  public static void a(final paramfinal)
  {
    Object localObject1 = Cranberry.a;
    ((Cranberry)localObject1).d = paramfinal;
    Object localObject2;
    if (!((Cranberry)localObject1).f)
    {
      ((Cranberry)localObject1).f = true;
      localObject2 = paramfinal.b;
    }
    for (;;)
    {
      try
      {
        if (const.a == null) {
          break label512;
        }
        continue;
        localObject2 = ((Context)localObject2).getApplicationContext();
        if (localObject2 == null) {
          continue;
        }
        const.a = (Context)localObject2;
        Filbert.a.f = new Coconut((Cranberry)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TuringFdCore_61_");
        ((StringBuilder)localObject2).append(native.a);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append("xqMini");
        localObject2 = new HandlerThread(((StringBuilder)localObject2).toString(), -8);
        ((HandlerThread)localObject2).start();
        ((Cranberry)localObject1).e = new Cranberry.do((Cranberry)localObject1, ((HandlerThread)localObject2).getLooper(), paramfinal.b);
        ((Cranberry)localObject1).g = new Date(((Cranberry)localObject1).e);
        localObject2 = paramfinal.b;
        if (Herbaceous.a.containsKey(Herbaceous.c)) {
          new Haw((Herbaceous.do)Herbaceous.a.get(Herbaceous.c), (Context)localObject2).start();
        }
        new Codlin((Cranberry)localObject1).start();
        localObject1 = paramfinal.b;
        Carambola.c = paramfinal;
        Bullace.f = (Context)localObject1;
        Fig.b.getClass();
      }
      finally {}
      try
      {
        i = Integer.parseInt((String)Fig.b.c((Context)localObject1).k.get("enable_risk_click"));
        if (i > 0)
        {
          i = 1;
          continue;
        }
      }
      finally {}
      int i = 0;
      if (i != 0)
      {
        localObject2 = Bullace.g;
        Object localObject4 = Bullace.h;
        try
        {
          Chamaeleon.a.add(localObject2);
          Chamaeleon.b = (Dorado)localObject4;
          localObject2 = ((Context)localObject1).getApplicationContext();
          Draco.e = Chamaeleon.e;
          if (!Draco.a) {
            Draco.a = true;
          }
          try
          {
            localObject4 = new HandlerThread("TuringDispatch");
            ((HandlerThread)localObject4).start();
            Draco.b = new Draco.new(((HandlerThread)localObject4).getLooper());
            localObject2 = (Application)localObject2;
            paramfinal = finally;
          }
          finally {}
          if (!Fig.b.b((Context)localObject1)) {
            continue;
          }
        }
        finally {}
      }
      else
      {
        localObject2 = new HandlerThread("TuringRiskThread", 0);
        ((HandlerThread)localObject2).start();
        localObject1 = new Carambola.do(((HandlerThread)localObject2).getLooper(), (Context)localObject1);
        Carambola.h = (Carambola.do)localObject1;
        ((Handler)localObject1).sendEmptyMessage(1);
      }
      Papaya.b.c = paramfinal;
      new Flat(Foxnut.a, paramfinal.b).start();
      return;
      label512:
      if (localObject3 != null) {}
    }
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.getDefault(), "TuringFD v%d", new Object[] { Integer.valueOf(61) }));
    localStringBuilder.append(" (FC074E611EA24865");
    localStringBuilder.append(", xq");
    localStringBuilder.append(", 7240bba");
    Object localObject = new StringBuilder();
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("tss");
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("rfr");
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("ite");
    localObject = ((StringBuilder)localObject).toString();
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
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("105668");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append(String.format(Locale.getDefault(), ", compiled %s)", new Object[] { "2021_06_21_16_31_15" }));
    return localStringBuilder.toString();
  }
  
  public static boolean b(final paramfinal)
  {
    if (a.get()) {
      return a.get();
    }
    boolean bool2 = paramfinal.e;
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(paramfinal.f);
      paramfinal = paramfinal.f;
      try
      {
        if (TextUtils.isEmpty(paramfinal)) {
          System.loadLibrary("turingxq");
        } else {
          System.load(paramfinal);
        }
      }
      finally
      {
        Log.w("TuringFdJava", paramfinal);
        bool1 = false;
      }
      a.set(bool1);
      if (!bool1) {
        Log.e("TuringFdJava", "load so failure");
      }
    }
    else
    {
      a.set(true);
    }
    return a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.while
 * JD-Core Version:    0.7.0.1
 */