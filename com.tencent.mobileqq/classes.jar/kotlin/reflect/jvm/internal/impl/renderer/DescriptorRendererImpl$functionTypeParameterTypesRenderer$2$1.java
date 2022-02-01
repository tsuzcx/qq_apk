package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import org.jetbrains.annotations.NotNull;

final class DescriptorRendererImpl$functionTypeParameterTypesRenderer$2$1
  extends Lambda
  implements Function1<DescriptorRendererOptions, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  DescriptorRendererImpl$functionTypeParameterTypesRenderer$2$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull DescriptorRendererOptions paramDescriptorRendererOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorRendererOptions, "$receiver");
    paramDescriptorRendererOptions.setExcludedTypeAnnotationClasses(SetsKt.plus(paramDescriptorRendererOptions.getExcludedTypeAnnotationClasses(), (Iterable)CollectionsKt.listOf(KotlinBuiltIns.FQ_NAMES.parameterName)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.functionTypeParameterTypesRenderer.2.1
 * JD-Core Version:    0.7.0.1
 */