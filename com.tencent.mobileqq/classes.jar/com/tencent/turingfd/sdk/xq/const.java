package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class const
{
  public static AtomicBoolean Kd = new AtomicBoolean(false);
  public static AtomicBoolean Ld = new AtomicBoolean(false);
  public static final Object Md;
  public static AtomicBoolean Nd;
  
  static
  {
    new AtomicBoolean(false);
    Md = new Object();
    Nd = new AtomicBoolean(false);
    Log.i("TuringFdJava", getVersionInfo());
  }
  
  public static int F()
  {
    if (!Kd.get()) {
      return -10001;
    }
    if (!Ld.get()) {
      return -10002;
    }
    return 0;
  }
  
  public static void a(Context paramContext, else paramelse)
  {
    if (paramContext.getApplicationContext() == null)
    {
      if (paramelse != null)
      {
        paramContext = Bilberry.g(-10016);
        ((Loquat)paramelse).a.onResult(TuringFdService.a(paramContext));
      }
      return;
    }
    int i = F();
    if ((i != 0) && (paramelse != null))
    {
      Bilberry localBilberry = Bilberry.g(i);
      ((Loquat)paramelse).a.onResult(TuringFdService.a(localBilberry));
    }
    new catch(paramelse, paramContext).start();
  }
  
  public static void a(break parambreak)
  {
    if (Nd.get()) {
      return;
    }
    synchronized (Md)
    {
      int i = parambreak.ya;
      if (i > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("c : ");
        localStringBuilder.append(parambreak.ya);
        Log.i("TuringFdJava", localStringBuilder.toString());
        float.rf = parambreak.ya;
      }
      if (Ld.get())
      {
        b(parambreak);
        return;
      }
      if (Nd.get()) {
        return;
      }
      Nd.set(true);
      System.currentTimeMillis();
      if (!c(parambreak))
      {
        Ld.set(false);
        return;
      }
      i = float.rf;
      if (i == 0)
      {
        Log.e("TuringFdJava", "pleace input channel info");
        Ld.set(false);
        return;
      }
      b(parambreak);
      Ld.set(true);
      Nd.set(false);
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
    Bullace localBullace = Bullace.Tg;
    localBullace.Rh = parambreak;
    if (!localBullace.Th)
    {
      localBullace.Th = true;
      void.n(parambreak.getContext());
      Object localObject = Codlin.Tg;
      parambreak.getContext();
      ((Codlin)localObject).di = new Blackberry(localBullace);
      localObject = do.b("TuringFdCore_57_");
      ((StringBuilder)localObject).append(float.rf);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("xqFull");
      localObject = new HandlerThread(((StringBuilder)localObject).toString(), -8);
      ((HandlerThread)localObject).start();
      localBullace.Sh = new Bullace.do(localBullace, ((HandlerThread)localObject).getLooper(), parambreak.getContext());
      localBullace.Uh = new Cascara(localBullace.Sh);
      localObject = parambreak.getContext();
      if (Flat.jdField_a_of_type_JavaUtilMap.containsKey(Flat.jdField_a_of_type_JavaLangString)) {
        new Filbert((Flat.do)Flat.jdField_a_of_type_JavaUtilMap.get(Flat.jdField_a_of_type_JavaLangString), (Context)localObject).start();
      }
      if (localBullace.Rh.B()) {
        new Blueberry(localBullace).start();
      }
    }
    Lemon.jdField_a_of_type_ComTencentTuringfdSdkXqLemon.jdField_a_of_type_ComTencentTuringfdSdkXqBreak = parambreak;
    Core.Tg.ea(parambreak.getContext());
  }
  
  public static boolean c(break parambreak)
  {
    if (Kd.get()) {
      return Kd.get();
    }
    boolean bool2 = parambreak.D();
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(parambreak.v());
      parambreak = parambreak.v();
      try
      {
        bool2 = TextUtils.isEmpty(parambreak);
        if (bool2) {
          System.loadLibrary("turingxq");
        } else {
          System.load(parambreak);
        }
      }
      catch (Throwable parambreak)
      {
        Log.w("TuringFdJava", parambreak);
        bool1 = false;
      }
      Kd.set(bool1);
      if (!bool1) {
        Log.e("TuringFdJava", "load so failure");
      }
    }
    else
    {
      Kd.set(true);
    }
    return Kd.get();
  }
  
  public static String getVersionInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.getDefault(), "TuringFD v%d", new Object[] { Integer.valueOf(57) }));
    localStringBuilder.append(" (FB4A28A2C9603382");
    localStringBuilder.append(", xq");
    localStringBuilder.append(", b7f6022");
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject, "tss");
    a((StringBuilder)localObject, "rfr");
    a((StringBuilder)localObject, "ite");
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append(", ");
    localObject = new StringBuilder();
    a((StringBuilder)localObject, "w");
    a((StringBuilder)localObject, "105668");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append(String.format(Locale.getDefault(), ", compiled %s)", new Object[] { "2021_02_01_11_35_53" }));
    return localStringBuilder.toString();
  }
  
  public static goto o(Context paramContext)
  {
    int i = F();
    if (i != 0) {
      return Bilberry.g(i);
    }
    return Bullace.Tg.b(paramContext, true, 1);
  }
  
  public static boolean removeScene(Activity paramActivity)
  {
    try
    {
      int i = F();
      if (i != 0) {
        return false;
      }
      CanisMinor.ih.remove(paramActivity.getClass().getName());
      Crux.ph.remove(paramActivity.getClass().getName());
      return true;
    }
    finally {}
  }
  
  public static boolean setScene(Activity paramActivity)
  {
    try
    {
      int i = F();
      if (i != 0) {
        return false;
      }
      CanisMinor.ih.add(paramActivity.getClass().getName());
      Crux.ph.add(paramActivity.getClass().getName());
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.const
 * JD-Core Version:    0.7.0.1
 */