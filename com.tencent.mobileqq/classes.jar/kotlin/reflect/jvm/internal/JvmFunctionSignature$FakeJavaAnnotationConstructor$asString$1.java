package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1
  extends Lambda
  implements Function1<Method, String>
{
  public static final 1 INSTANCE = new 1();
  
  JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(Method paramMethod)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "it");
    paramMethod = paramMethod.getReturnType();
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "it.returnType");
    return ReflectClassUtilKt.getDesc(paramMethod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor.asString.1
 * JD-Core Version:    0.7.0.1
 */