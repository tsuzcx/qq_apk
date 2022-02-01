package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/internal/PlatformImplementations$ReflectAddSuppressedMethod;", "", "()V", "method", "Ljava/lang/reflect/Method;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class PlatformImplementations$ReflectAddSuppressedMethod
{
  public static final ReflectAddSuppressedMethod INSTANCE = new ReflectAddSuppressedMethod();
  @JvmField
  @Nullable
  public static final Method method;
  
  static
  {
    Method[] arrayOfMethod = Throwable.class.getMethods();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfMethod, "throwableClass.methods");
    int k = arrayOfMethod.length;
    int i = 0;
    while (i < k)
    {
      localMethod = arrayOfMethod[i];
      Intrinsics.checkExpressionValueIsNotNull(localMethod, "it");
      if (Intrinsics.areEqual(localMethod.getName(), "addSuppressed"))
      {
        Class[] arrayOfClass = localMethod.getParameterTypes();
        Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "it.parameterTypes");
        if (Intrinsics.areEqual((Class)ArraysKt.singleOrNull(arrayOfClass), Throwable.class))
        {
          j = 1;
          break label94;
        }
      }
      int j = 0;
      label94:
      if (j != 0) {
        break label110;
      }
      i += 1;
    }
    Method localMethod = null;
    label110:
    method = localMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.internal.PlatformImplementations.ReflectAddSuppressedMethod
 * JD-Core Version:    0.7.0.1
 */