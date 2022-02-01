package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class RuntimeTypeMapperKt
{
  private static final String getSignature(@NotNull Method paramMethod)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMethod.getName());
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "parameterTypes");
    localStringBuilder.append(ArraysKt.joinToString$default(arrayOfClass, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, (Function1)RuntimeTypeMapperKt.signature.1.INSTANCE, 24, null));
    paramMethod = paramMethod.getReturnType();
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "returnType");
    localStringBuilder.append(ReflectClassUtilKt.getDesc(paramMethod));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.RuntimeTypeMapperKt
 * JD-Core Version:    0.7.0.1
 */