package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class ClassifierNamePolicy$SOURCE_CODE_QUALIFIED
  implements ClassifierNamePolicy
{
  public static final SOURCE_CODE_QUALIFIED INSTANCE = new SOURCE_CODE_QUALIFIED();
  
  private final String qualifiedNameForSourceCode(ClassifierDescriptor paramClassifierDescriptor)
  {
    Object localObject = paramClassifierDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "descriptor.name");
    localObject = RenderingUtilsKt.render((Name)localObject);
    if ((paramClassifierDescriptor instanceof TypeParameterDescriptor)) {
      return localObject;
    }
    paramClassifierDescriptor = paramClassifierDescriptor.getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(paramClassifierDescriptor, "descriptor.containingDeclaration");
    String str = qualifierName(paramClassifierDescriptor);
    paramClassifierDescriptor = (ClassifierDescriptor)localObject;
    if (str != null)
    {
      paramClassifierDescriptor = (ClassifierDescriptor)localObject;
      if ((Intrinsics.areEqual(str, "") ^ true))
      {
        paramClassifierDescriptor = new StringBuilder();
        paramClassifierDescriptor.append(str);
        paramClassifierDescriptor.append(".");
        paramClassifierDescriptor.append((String)localObject);
        paramClassifierDescriptor = paramClassifierDescriptor.toString();
      }
    }
    return paramClassifierDescriptor;
  }
  
  private final String qualifierName(DeclarationDescriptor paramDeclarationDescriptor)
  {
    if ((paramDeclarationDescriptor instanceof ClassDescriptor)) {
      return qualifiedNameForSourceCode((ClassifierDescriptor)paramDeclarationDescriptor);
    }
    if ((paramDeclarationDescriptor instanceof PackageFragmentDescriptor))
    {
      paramDeclarationDescriptor = ((PackageFragmentDescriptor)paramDeclarationDescriptor).getFqName().toUnsafe();
      Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "descriptor.fqName.toUnsafe()");
      return RenderingUtilsKt.render(paramDeclarationDescriptor);
    }
    return null;
  }
  
  @NotNull
  public String renderClassifier(@NotNull ClassifierDescriptor paramClassifierDescriptor, @NotNull DescriptorRenderer paramDescriptorRenderer)
  {
    Intrinsics.checkParameterIsNotNull(paramClassifierDescriptor, "classifier");
    Intrinsics.checkParameterIsNotNull(paramDescriptorRenderer, "renderer");
    return qualifiedNameForSourceCode(paramClassifierDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SOURCE_CODE_QUALIFIED
 * JD-Core Version:    0.7.0.1
 */