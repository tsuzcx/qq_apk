package com.tencent.rmonitor.common.util;

import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class SystemProduct$Companion$isYunOS$2
  extends Lambda
  implements Function0<Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  SystemProduct$Companion$isYunOS$2()
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    Object localObject1 = (String)null;
    boolean bool2 = false;
    Object localObject2;
    try
    {
      Object localObject4 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "Class.forName(\"android.o…get\", String::class.java)");
      Object localObject3 = ((Method)localObject4).invoke(null, new Object[] { "ro.yunos.version" });
      localObject2 = localObject3;
      if (!(localObject3 instanceof String)) {
        localObject2 = null;
      }
      localObject2 = (String)localObject2;
      try
      {
        localObject4 = ((Method)localObject4).invoke(null, new Object[] { "java.vm.name" });
        localObject3 = localObject4;
        if (!(localObject4 instanceof String)) {
          localObject3 = null;
        }
        localObject3 = (String)localObject3;
        localObject1 = localObject3;
      }
      catch (InvocationTargetException localInvocationTargetException1) {}catch (IllegalAccessException localIllegalAccessException1) {}catch (ClassNotFoundException localClassNotFoundException1) {}catch (NoSuchMethodException localNoSuchMethodException1) {}
      Logger.b.a("RMonitor_common_SystemProduct", (Throwable)localNoSuchMethodException2);
    }
    catch (InvocationTargetException localInvocationTargetException2)
    {
      localObject2 = localObject1;
      Logger.b.a("RMonitor_common_SystemProduct", (Throwable)localInvocationTargetException2);
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      localObject2 = localObject1;
      Logger.b.a("RMonitor_common_SystemProduct", (Throwable)localIllegalAccessException2);
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      localObject2 = localObject1;
      Logger.b.a("RMonitor_common_SystemProduct", (Throwable)localClassNotFoundException2);
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      localObject2 = localObject1;
    }
    if (localObject1 != null)
    {
      Locale localLocale = Locale.US;
      Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.US");
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).toLowerCase(localLocale);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).toLowerCase(locale)");
        if (localObject1 != null)
        {
          bool1 = StringsKt.contains$default((CharSequence)localObject1, (CharSequence)"lemur", false, 2, null);
          break label304;
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    boolean bool1 = false;
    label304:
    if (!bool1)
    {
      if (localObject2 != null)
      {
        localObject1 = (CharSequence)localObject2;
        i = ((CharSequence)localObject1).length() - 1;
        int j = 0;
        int k = 0;
        while (j <= i)
        {
          int m;
          if (k == 0) {
            m = j;
          } else {
            m = i;
          }
          if (((CharSequence)localObject1).charAt(m) <= ' ') {
            m = 1;
          } else {
            m = 0;
          }
          if (k == 0)
          {
            if (m == 0) {
              k = 1;
            } else {
              j += 1;
            }
          }
          else
          {
            if (m == 0) {
              break;
            }
            i -= 1;
          }
        }
        localObject1 = ((CharSequence)localObject1).subSequence(j, i + 1).toString();
        if (localObject1 != null)
        {
          i = ((String)localObject1).length();
          break label444;
        }
      }
      int i = 0;
      label444:
      bool1 = bool2;
      if (i <= 0) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.SystemProduct.Companion.isYunOS.2
 * JD-Core Version:    0.7.0.1
 */