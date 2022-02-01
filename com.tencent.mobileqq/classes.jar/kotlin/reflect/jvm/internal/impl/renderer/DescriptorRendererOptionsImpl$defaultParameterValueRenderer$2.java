package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;

final class DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2
  extends Lambda
  implements Function1<ValueParameterDescriptor, String>
{
  public static final 2 INSTANCE = new 2();
  
  DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull ValueParameterDescriptor paramValueParameterDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramValueParameterDescriptor, "it");
    return "...";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.defaultParameterValueRenderer.2
 * JD-Core Version:    0.7.0.1
 */