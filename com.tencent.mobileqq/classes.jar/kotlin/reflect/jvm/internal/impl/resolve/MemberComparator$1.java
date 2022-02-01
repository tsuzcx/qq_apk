package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;

final class MemberComparator$1
  implements Function1<DescriptorRendererOptions, Unit>
{
  public Unit invoke(DescriptorRendererOptions paramDescriptorRendererOptions)
  {
    paramDescriptorRendererOptions.setWithDefinedIn(false);
    paramDescriptorRendererOptions.setVerbose(true);
    paramDescriptorRendererOptions.setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY);
    paramDescriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.1
 * JD-Core Version:    0.7.0.1
 */