package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
final class AnnotationConstructorCallerKt$createAnnotationInstance$result$1
  implements InvocationHandler
{
  AnnotationConstructorCallerKt$createAnnotationInstance$result$1(Class paramClass, Lazy paramLazy1, KProperty paramKProperty1, Lazy paramLazy2, KProperty paramKProperty2, AnnotationConstructorCallerKt.createAnnotationInstance.2 param2, Map paramMap) {}
  
  @Nullable
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "method");
    paramObject = paramMethod.getName();
    if (paramObject != null)
    {
      int i = paramObject.hashCode();
      if (i != -1776922004)
      {
        if (i != 147696667)
        {
          if ((i == 1444986633) && (paramObject.equals("annotationType"))) {
            return this.$annotationClass;
          }
        }
        else if (paramObject.equals("hashCode"))
        {
          paramObject = this.$hashCode;
          paramMethod = this.$hashCode$metadata;
          return paramObject.getValue();
        }
      }
      else if (paramObject.equals("toString"))
      {
        paramObject = this.$toString;
        paramMethod = this.$toString$metadata;
        return paramObject.getValue();
      }
    }
    if ((Intrinsics.areEqual(paramObject, "equals")) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1)) {
      return Boolean.valueOf(this.$equals$2.invoke(ArraysKt.single(paramArrayOfObject)));
    }
    if (this.$values.containsKey(paramObject)) {
      return this.$values.get(paramObject);
    }
    paramObject = new StringBuilder();
    paramObject.append("Method is not supported: ");
    paramObject.append(paramMethod);
    paramObject.append(" (args: ");
    if (paramArrayOfObject == null) {
      paramArrayOfObject = new Object[0];
    }
    paramObject.append(ArraysKt.toList(paramArrayOfObject));
    paramObject.append(')');
    throw ((Throwable)new KotlinReflectionInternalError(paramObject.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance.result.1
 * JD-Core Version:    0.7.0.1
 */