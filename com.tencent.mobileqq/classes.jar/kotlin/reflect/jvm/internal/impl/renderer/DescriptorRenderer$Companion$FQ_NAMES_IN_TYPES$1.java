package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1
  extends Lambda
  implements Function1<DescriptorRendererOptions, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull DescriptorRendererOptions paramDescriptorRendererOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorRendererOptions, "$receiver");
    paramDescriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion.FQ_NAMES_IN_TYPES.1
 * JD-Core Version:    0.7.0.1
 */