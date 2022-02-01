package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModuleDescriptor$DefaultImpls
{
  public static <R, D> R accept(ModuleDescriptor paramModuleDescriptor, @NotNull DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptorVisitor, "visitor");
    return paramDeclarationDescriptorVisitor.visitModuleDeclaration(paramModuleDescriptor, paramD);
  }
  
  @Nullable
  public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor paramModuleDescriptor)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */