package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public final class ClassifierNamePolicy$FULLY_QUALIFIED
  implements ClassifierNamePolicy
{
  public static final FULLY_QUALIFIED INSTANCE = new FULLY_QUALIFIED();
  
  @NotNull
  public String renderClassifier(@NotNull ClassifierDescriptor paramClassifierDescriptor, @NotNull DescriptorRenderer paramDescriptorRenderer)
  {
    Intrinsics.checkParameterIsNotNull(paramClassifierDescriptor, "classifier");
    Intrinsics.checkParameterIsNotNull(paramDescriptorRenderer, "renderer");
    if ((paramClassifierDescriptor instanceof TypeParameterDescriptor))
    {
      paramClassifierDescriptor = ((TypeParameterDescriptor)paramClassifierDescriptor).getName();
      Intrinsics.checkExpressionValueIsNotNull(paramClassifierDescriptor, "classifier.name");
      return paramDescriptorRenderer.renderName(paramClassifierDescriptor, false);
    }
    paramClassifierDescriptor = DescriptorUtils.getFqName((DeclarationDescriptor)paramClassifierDescriptor);
    Intrinsics.checkExpressionValueIsNotNull(paramClassifierDescriptor, "DescriptorUtils.getFqName(classifier)");
    return paramDescriptorRenderer.renderFqName(paramClassifierDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.FULLY_QUALIFIED
 * JD-Core Version:    0.7.0.1
 */