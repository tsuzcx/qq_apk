package com.tencent.rmonitor.common.util;

import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/StackUtil$Companion;", "", "()V", "TAG", "", "WHITE_PACKAGE", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCurrentThreadName", "getThrowableStack", "throwable", "", "stackTraceToString", "arr", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class StackUtil$Companion
{
  @JvmStatic
  @NotNull
  public final String a()
  {
    Object localObject = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
    localObject = ((Thread)localObject).getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread().name");
    return localObject;
  }
  
  @JvmStatic
  @NotNull
  public final String a(@Nullable Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    return ((Companion)this).a(paramThrowable.getStackTrace());
  }
  
  @JvmStatic
  @NotNull
  public final String a(@Nullable StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement != null)
    {
      int i;
      if (paramArrayOfStackTraceElement.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        Object localObject1 = new ArrayList(paramArrayOfStackTraceElement.length);
        int k = paramArrayOfStackTraceElement.length;
        i = 0;
        while (i < k)
        {
          String str1 = paramArrayOfStackTraceElement[i].getClassName();
          Object localObject2 = (Iterable)StackUtil.a();
          if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {}
          String str2;
          do
          {
            while (!((Iterator)localObject2).hasNext())
            {
              j = 0;
              break;
              localObject2 = ((Iterable)localObject2).iterator();
            }
            str2 = (String)((Iterator)localObject2).next();
            Intrinsics.checkExpressionValueIsNotNull(str1, "className");
          } while (!StringsKt.contains$default((CharSequence)str1, (CharSequence)str2, false, 2, null));
          int j = 1;
          if (j == 0) {
            ((ArrayList)localObject1).add(paramArrayOfStackTraceElement[i]);
          }
          i += 1;
        }
        paramArrayOfStackTraceElement = new StringBuffer(((ArrayList)localObject1).size());
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramArrayOfStackTraceElement.append((StackTraceElement)((Iterator)localObject1).next());
          paramArrayOfStackTraceElement.append('\n');
        }
        paramArrayOfStackTraceElement = paramArrayOfStackTraceElement.toString();
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfStackTraceElement, "sb.toString()");
        return paramArrayOfStackTraceElement;
      }
    }
    return "";
  }
  
  @JvmStatic
  @NotNull
  public final String b()
  {
    try
    {
      String str = ((Companion)this).a(new Throwable());
      return str;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_common_util_FakeUtil", "getThrowableStack ex ", localThrowable);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.StackUtil.Companion
 * JD-Core Version:    0.7.0.1
 */