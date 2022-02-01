package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class return
{
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return false;
    }
    int i = paramString2.indexOf('/');
    if (i == -1) {
      return false;
    }
    String str = paramString2.substring(i).trim();
    if (!str.startsWith("/data/")) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/data/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    if (str.startsWith(localStringBuilder.toString())) {
      return false;
    }
    boolean bool = str.endsWith(".so");
    if ((!bool) && (str.endsWith(".jar"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!bool) && (i == 0)) {
      return false;
    }
    return paramString2.contains(final.get(final._d));
  }
  
  public static boolean t(Context paramContext)
  {
    Object localObject = new Object();
    AtomicReference localAtomicReference = new AtomicReference();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    localAtomicReference.set(Boolean.valueOf(false));
    new Handler(paramContext.getMainLooper()).post(new public(localAtomicBoolean, localAtomicReference, System.currentTimeMillis(), localObject));
    try
    {
      try
      {
        localObject.wait(100L);
      }
      finally
      {
        break label95;
      }
    }
    catch (InterruptedException paramContext)
    {
      label77:
      break label77;
    }
    localAtomicBoolean.set(true);
    return ((Boolean)localAtomicReference.get()).booleanValue();
    label95:
    throw paramContext;
  }
  
  public static int u(Context paramContext)
  {
    System.currentTimeMillis();
    Object localObject = paramContext.getPackageManager();
    boolean bool2 = true;
    String str;
    if (localObject != null) {
      str = final.get(final.Zd);
    }
    try
    {
      ((PackageManager)localObject).getPackageInfo(str, 128);
      bool1 = true;
    }
    catch (Throwable localThrowable1)
    {
      boolean bool1;
      label46:
      int j;
      break label46;
    }
    bool1 = false;
    j = void.a(0, bool1, 0);
    System.currentTimeMillis();
    try
    {
      localObject = new String(abstract.i(final.get(final.ae)));
      bool1 = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool1)
      {
        localObject = ((String)localObject).split("\\n");
        if ((localObject != null) && (localObject.length != 0))
        {
          str = paramContext.getPackageName();
          int k = localObject.length;
          i = 0;
          while (i < k)
          {
            bool1 = a(str, localObject[i]);
            if (bool1)
            {
              bool1 = true;
              break label166;
            }
            i += 1;
          }
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      int i;
      label163:
      break label163;
    }
    bool1 = false;
    label166:
    i = void.a(j, bool1, 1);
    System.currentTimeMillis();
    i = void.a(i, t(paramContext), 2);
    System.currentTimeMillis();
    try
    {
      paramContext = final.get(final.nf);
      ClassLoader.getSystemClassLoader().loadClass(paramContext);
      bool1 = bool2;
    }
    catch (Throwable paramContext)
    {
      label214:
      break label214;
    }
    bool1 = false;
    return void.a(i, bool1, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.return
 * JD-Core Version:    0.7.0.1
 */