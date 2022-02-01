package cooperation.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ResInjector
{
  private static Class<AssetManager> a;
  private static Method b;
  private static Class c = Class.forName("android.content.res.Resources");
  private static Class d;
  private static Class e;
  private static Field f;
  private static Field g;
  private static Collection<WeakReference<Resources>> h;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: putstatic 34	cooperation/plugin/ResInjector:c	Ljava/lang/Class;
    //   8: ldc 36
    //   10: putstatic 38	cooperation/plugin/ResInjector:a	Ljava/lang/Class;
    //   13: getstatic 38	cooperation/plugin/ResInjector:a	Ljava/lang/Class;
    //   16: ldc 40
    //   18: iconst_1
    //   19: anewarray 28	java/lang/Class
    //   22: dup
    //   23: iconst_0
    //   24: ldc 42
    //   26: aastore
    //   27: invokevirtual 46	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   30: putstatic 48	cooperation/plugin/ResInjector:b	Ljava/lang/reflect/Method;
    //   33: getstatic 48	cooperation/plugin/ResInjector:b	Ljava/lang/reflect/Method;
    //   36: iconst_1
    //   37: invokevirtual 54	java/lang/reflect/Method:setAccessible	(Z)V
    //   40: invokestatic 57	cooperation/plugin/ResInjector:b	()Z
    //   43: istore_0
    //   44: iload_0
    //   45: ifeq +43 -> 88
    //   48: ldc 59
    //   50: invokestatic 32	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   53: putstatic 61	cooperation/plugin/ResInjector:d	Ljava/lang/Class;
    //   56: getstatic 34	cooperation/plugin/ResInjector:c	Ljava/lang/Class;
    //   59: ldc 63
    //   61: invokevirtual 67	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   64: putstatic 69	cooperation/plugin/ResInjector:g	Ljava/lang/reflect/Field;
    //   67: getstatic 69	cooperation/plugin/ResInjector:g	Ljava/lang/reflect/Field;
    //   70: iconst_1
    //   71: invokevirtual 72	java/lang/reflect/Field:setAccessible	(Z)V
    //   74: getstatic 61	cooperation/plugin/ResInjector:d	Ljava/lang/Class;
    //   77: ldc 74
    //   79: invokevirtual 67	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   82: putstatic 76	cooperation/plugin/ResInjector:f	Ljava/lang/reflect/Field;
    //   85: goto +14 -> 99
    //   88: getstatic 34	cooperation/plugin/ResInjector:c	Ljava/lang/Class;
    //   91: ldc 74
    //   93: invokevirtual 67	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   96: putstatic 76	cooperation/plugin/ResInjector:f	Ljava/lang/reflect/Field;
    //   99: getstatic 76	cooperation/plugin/ResInjector:f	Ljava/lang/reflect/Field;
    //   102: iconst_1
    //   103: invokevirtual 72	java/lang/reflect/Field:setAccessible	(Z)V
    //   106: goto +13 -> 119
    //   109: astore_1
    //   110: ldc 78
    //   112: iconst_1
    //   113: ldc 80
    //   115: aload_1
    //   116: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: invokestatic 87	cooperation/plugin/ResInjector:a	()Z
    //   122: ifeq +97 -> 219
    //   125: ldc 89
    //   127: invokestatic 32	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   130: putstatic 91	cooperation/plugin/ResInjector:e	Ljava/lang/Class;
    //   133: getstatic 91	cooperation/plugin/ResInjector:e	Ljava/lang/Class;
    //   136: ldc 93
    //   138: iconst_0
    //   139: anewarray 28	java/lang/Class
    //   142: invokevirtual 96	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   145: aconst_null
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokevirtual 100	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore_1
    //   154: getstatic 91	cooperation/plugin/ResInjector:e	Ljava/lang/Class;
    //   157: ldc 102
    //   159: invokevirtual 67	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   162: astore_2
    //   163: aload_2
    //   164: iconst_1
    //   165: invokevirtual 72	java/lang/reflect/Field:setAccessible	(Z)V
    //   168: aload_2
    //   169: aload_1
    //   170: invokevirtual 106	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast 108	android/util/ArrayMap
    //   176: invokevirtual 112	android/util/ArrayMap:values	()Ljava/util/Collection;
    //   179: putstatic 114	cooperation/plugin/ResInjector:h	Ljava/util/Collection;
    //   182: return
    //   183: getstatic 91	cooperation/plugin/ResInjector:e	Ljava/lang/Class;
    //   186: ldc 116
    //   188: invokevirtual 67	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   191: astore_2
    //   192: aload_2
    //   193: iconst_1
    //   194: invokevirtual 72	java/lang/reflect/Field:setAccessible	(Z)V
    //   197: aload_2
    //   198: aload_1
    //   199: invokevirtual 106	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   202: checkcast 118	java/util/Collection
    //   205: putstatic 114	cooperation/plugin/ResInjector:h	Ljava/util/Collection;
    //   208: return
    //   209: astore_1
    //   210: ldc 78
    //   212: iconst_1
    //   213: ldc 80
    //   215: aload_1
    //   216: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: return
    //   220: astore_2
    //   221: goto -38 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   43	2	0	bool	boolean
    //   109	7	1	localException1	Exception
    //   153	46	1	localObject	Object
    //   209	7	1	localException2	Exception
    //   162	36	2	localField	Field
    //   220	1	2	localNoSuchFieldException	java.lang.NoSuchFieldException
    // Exception table:
    //   from	to	target	type
    //   0	44	109	java/lang/Exception
    //   48	85	109	java/lang/Exception
    //   88	99	109	java/lang/Exception
    //   99	106	109	java/lang/Exception
    //   119	154	209	java/lang/Exception
    //   154	182	209	java/lang/Exception
    //   183	208	209	java/lang/Exception
    //   154	182	220	java/lang/NoSuchFieldException
  }
  
  public static Resources a(Context paramContext, Resources paramResources, List<String> paramList)
  {
    if (paramResources == null) {
      return null;
    }
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      if (b != null) {
        for (;;)
        {
          try
          {
            paramContext = paramContext.getAssets();
            paramList = paramList.iterator();
            if (paramList.hasNext())
            {
              localObject1 = (String)paramList.next();
              b.invoke(paramContext, new Object[] { localObject1 });
              continue;
            }
            new Resources(paramContext, paramResources.getDisplayMetrics(), paramResources.getConfiguration());
            if (b())
            {
              paramList = g.get(paramResources);
              f.set(paramList, paramContext);
            }
            else
            {
              f.set(paramResources, paramContext);
            }
            paramList = h.iterator();
            if (paramList.hasNext())
            {
              localObject1 = (Resources)((WeakReference)paramList.next()).get();
              if (localObject1 == null) {
                continue;
              }
            }
          }
          catch (Exception paramContext)
          {
            Object localObject1;
            Object localObject2;
            Field localField;
            throw new InjectFailException(1, paramContext);
          }
          try
          {
            f.set(localObject1, paramContext);
          }
          catch (Throwable localThrowable)
          {
            continue;
          }
          localObject2 = g.get(localObject1);
          localField = d.getDeclaredField("mAssets");
          localField.setAccessible(true);
          localField.set(localObject2, paramContext);
          ((Resources)localObject1).updateConfiguration(((Resources)localObject1).getConfiguration(), ((Resources)localObject1).getDisplayMetrics());
          continue;
          return paramResources;
        }
      }
      throw new InjectFailException(1, new Throwable("Can't get addAssetPath function."));
    }
    return null;
  }
  
  public static Resources a(Context paramContext, List<String> paramList)
  {
    return a(paramContext, paramContext.getResources(), paramList);
  }
  
  private static boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private static boolean b()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.ResInjector
 * JD-Core Version:    0.7.0.1
 */