package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;

public final class ClassifierNamePolicy$SHORT
  implements ClassifierNamePolicy
{
  public static final SHORT INSTANCE = new SHORT();
  
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
    ArrayList localArrayList = new ArrayList();
    paramClassifierDescriptor = (DeclarationDescriptor)paramClassifierDescriptor;
    do
    {
      localArrayList.add(paramClassifierDescriptor.getName());
      paramDescriptorRenderer = paramClassifierDescriptor.getContainingDeclaration();
      paramClassifierDescriptor = paramDescriptorRenderer;
    } while ((paramDescriptorRenderer instanceof ClassDescriptor));
    return RenderingUtilsKt.renderFqName(CollectionsKt.asReversedMutable((List)localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SHORT
 * JD-Core Version:    0.7.0.1
 */