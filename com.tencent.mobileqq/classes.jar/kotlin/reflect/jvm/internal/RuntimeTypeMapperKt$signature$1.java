package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class RuntimeTypeMapperKt$signature$1
  extends Lambda
  implements Function1<Class<?>, String>
{
  public static final 1 INSTANCE = new 1();
  
  RuntimeTypeMapperKt$signature$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(Class<?> paramClass)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "it");
    return ReflectClassUtilKt.getDesc(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.RuntimeTypeMapperKt.signature.1
 * JD-Core Version:    0.7.0.1
 */