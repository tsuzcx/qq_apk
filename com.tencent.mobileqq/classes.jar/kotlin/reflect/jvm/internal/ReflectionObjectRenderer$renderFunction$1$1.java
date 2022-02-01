package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class ReflectionObjectRenderer$renderFunction$1$1
  extends Lambda
  implements Function1<ValueParameterDescriptor, String>
{
  public static final 1 INSTANCE = new 1();
  
  ReflectionObjectRenderer$renderFunction$1$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(ValueParameterDescriptor paramValueParameterDescriptor)
  {
    ReflectionObjectRenderer localReflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(paramValueParameterDescriptor, "it");
    paramValueParameterDescriptor = paramValueParameterDescriptor.getType();
    Intrinsics.checkExpressionValueIsNotNull(paramValueParameterDescriptor, "it.type");
    return localReflectionObjectRenderer.renderType(paramValueParameterDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.ReflectionObjectRenderer.renderFunction.1.1
 * JD-Core Version:    0.7.0.1
 */