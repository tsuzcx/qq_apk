package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class ReflectJavaClass$innerClassNames$1
  extends Lambda
  implements Function1<Class<?>, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  ReflectJavaClass$innerClassNames$1()
  {
    super(1);
  }
  
  public final boolean invoke(Class<?> paramClass)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "it");
    paramClass = paramClass.getSimpleName();
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "it.simpleName");
    return ((CharSequence)paramClass).length() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass.innerClassNames.1
 * JD-Core Version:    0.7.0.1
 */