package com.tencent.mobileqq.qfix.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class a
{
  private static final String a = "AssetManagerUtil";
  private static final String b = "only_use_to_test_tinker_resource.txt";
  private static Collection<WeakReference<Resources>> c;
  private static Object d;
  private static AssetManager e;
  private static Method f;
  private static Method g;
  private static Field h;
  private static Field i;
  private static Field j;
  private static Field k;
  private static Field l;
  private static Field m;
  private static Field n;
  
  private static void a(Resources paramResources)
  {
    Log.w("AssetManagerUtil", "try to clear typedArray cache!");
    try
    {
      paramResources = c.a(Resources.class, "mTypedArrayPool").get(paramResources);
      localObject1 = c.a(paramResources, "acquire", new Class[0]);
      Object localObject2;
      do
      {
        localObject2 = ((Method)localObject1).invoke(paramResources, new Object[0]);
      } while (localObject2 != null);
      return;
    }
    catch (Throwable paramResources)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clearPreloadTypedArrayIssue failed, ignore error: ");
      ((StringBuilder)localObject1).append(paramResources);
      Log.e("AssetManagerUtil", ((StringBuilder)localObject1).toString());
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      b(paramContext);
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      b(paramContext, paramString);
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static void b(Context paramContext)
  {
    Object localObject2 = Class.forName("android.app.ActivityThread");
    d = c.a(paramContext, (Class)localObject2);
    try
    {
      localObject1 = Class.forName("android.app.LoadedApk");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        n = c.a(localObject1, "mStringBlocks");
        g = c.a(localObject1, "ensureStringBlocks", new Class[0]);
        e = (AssetManager)c.a(localObject1, new Class[0]).newInstance(new Object[0]);
        if (Build.VERSION.SDK_INT < 19) {
          break label202;
        }
        Object localObject1 = Class.forName("android.app.ResourcesManager");
        localObject2 = c.a((Class)localObject1, "getInstance", new Class[0]).invoke(null, new Object[0]);
        try
        {
          c = ((ArrayMap)c.a((Class)localObject1, "mActiveResources").get(localObject2)).values();
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          break label185;
        }
        localObject1 = (Collection)c.a((Class)localObject1, "mResourceReferences").get(localObject2);
        break label221;
        localObject1 = ((HashMap)c.a((Class)localObject2, "mActiveResources").get(d)).values();
        c = (Collection)localObject1;
        if (c == null) {
          break label276;
        }
        paramContext = paramContext.getResources();
        if (Build.VERSION.SDK_INT < 24) {
          break label256;
        }
        try
        {
          i = c.a(paramContext, "mResourcesImpl");
        }
        catch (Throwable localThrowable1)
        {
          break label256;
        }
        h = c.a(paramContext, "mAssets");
        try
        {
          m = c.a(ApplicationInfo.class, "publicSourceDir");
          return;
        }
        catch (NoSuchFieldException paramContext) {}
        throw new IllegalStateException("resource references is null");
        localClassNotFoundException = localClassNotFoundException;
      }
      catch (Throwable localThrowable2)
      {
        break label109;
      }
    }
    localObject1 = Class.forName("android.app.ActivityThread$PackageInfo");
    j = c.a((Class)localObject1, "mResDir");
    k = c.a((Class)localObject2, "mPackages");
    if (Build.VERSION.SDK_INT < 27) {
      l = c.a((Class)localObject2, "mResourcePackages");
    }
    localObject1 = paramContext.getAssets();
    f = c.a(localObject1, "addAssetPath", new Class[] { String.class });
    label109:
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return;
    }
    Object localObject2 = paramContext.getApplicationInfo();
    Object localObject1;
    if (Build.VERSION.SDK_INT < 27)
    {
      localObject1 = new Field[2];
      localObject1[0] = k;
      localObject1[1] = l;
    }
    else
    {
      localObject1 = new Field[1];
      localObject1[0] = k;
    }
    int i2 = localObject1.length;
    int i1 = 0;
    Object localObject3;
    while (i1 < i2)
    {
      localObject3 = ((Map)localObject1[i1].get(d)).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((WeakReference)((Map.Entry)((Iterator)localObject3).next()).getValue()).get();
        if (localObject4 != null)
        {
          String str = (String)j.get(localObject4);
          if (((ApplicationInfo)localObject2).sourceDir.equals(str)) {
            j.set(localObject4, paramString);
          }
        }
      }
      i1 += 1;
    }
    if (((Integer)f.invoke(e, new Object[] { paramString })).intValue() != 0)
    {
      localObject1 = n;
      if ((localObject1 != null) && (g != null))
      {
        ((Field)localObject1).set(e, null);
        g.invoke(e, new Object[0]);
      }
      localObject1 = c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Resources)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {}
        try
        {
          h.set(localObject2, e);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            if (m == null) {
              break label375;
            }
            m.set(paramContext.getApplicationInfo(), paramString);
            c(paramContext);
            return;
            paramContext = new IllegalStateException("Could not create new AssetManager");
            for (;;)
            {
              throw paramContext;
            }
            localThrowable = localThrowable;
          }
          catch (Throwable paramString)
          {
            break label375;
          }
        }
        localObject3 = i.get(localObject2);
        c.a(localObject3, "mAssets").set(localObject3, e);
        a((Resources)localObject2);
        ((Resources)localObject2).updateConfiguration(((Resources)localObject2).getConfiguration(), ((Resources)localObject2).getDisplayMetrics());
      }
      if (Build.VERSION.SDK_INT < 24) {}
    }
  }
  
  /* Error */
  private static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 146	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: ldc 11
    //   6: invokevirtual 300	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: aload_0
    //   11: invokestatic 305	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   14: ldc 8
    //   16: ldc_w 307
    //   19: invokestatic 309	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: iconst_1
    //   24: ireturn
    //   25: astore_0
    //   26: goto +45 -> 71
    //   29: astore_0
    //   30: new 76	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   37: astore_1
    //   38: aload_1
    //   39: ldc_w 311
    //   42: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: aload_0
    //   48: invokevirtual 314	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   51: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 8
    //   57: aload_1
    //   58: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: aconst_null
    //   66: invokestatic 305	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   69: iconst_0
    //   70: ireturn
    //   71: aconst_null
    //   72: invokestatic 305	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	Context
    //   37	21	1	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	10	25	finally
    //   30	65	25	finally
    //   0	10	29	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.b.a
 * JD-Core Version:    0.7.0.1
 */