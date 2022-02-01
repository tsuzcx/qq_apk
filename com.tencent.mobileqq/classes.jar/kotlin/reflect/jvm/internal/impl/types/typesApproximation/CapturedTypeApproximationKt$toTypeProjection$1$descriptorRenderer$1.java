package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.FULLY_QUALIFIED;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import org.jetbrains.annotations.NotNull;

final class CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1
  extends Lambda
  implements Function1<DescriptorRendererOptions, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull DescriptorRendererOptions paramDescriptorRendererOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorRendererOptions, "$receiver");
    paramDescriptorRendererOptions.setClassifierNamePolicy((ClassifierNamePolicy)ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.toTypeProjection.1.descriptorRenderer.1
 * JD-Core Version:    0.7.0.1
 */