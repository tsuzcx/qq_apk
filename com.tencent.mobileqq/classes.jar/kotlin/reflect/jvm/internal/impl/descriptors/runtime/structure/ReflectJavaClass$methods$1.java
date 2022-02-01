package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class ReflectJavaClass$methods$1
  extends Lambda
  implements Function1<Method, Boolean>
{
  ReflectJavaClass$methods$1(ReflectJavaClass paramReflectJavaClass)
  {
    super(1);
  }
  
  public final boolean invoke(Method paramMethod)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "method");
    if (paramMethod.isSynthetic()) {}
    while ((this.this$0.isEnum()) && (ReflectJavaClass.access$isEnumValuesOrValueOf(this.this$0, paramMethod))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass.methods.1
 * JD-Core Version:    0.7.0.1
 */