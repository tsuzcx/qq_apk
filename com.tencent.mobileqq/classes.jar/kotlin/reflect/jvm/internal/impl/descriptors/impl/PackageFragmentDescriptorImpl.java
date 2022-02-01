package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public abstract class PackageFragmentDescriptorImpl
  extends DeclarationDescriptorNonRootImpl
  implements PackageFragmentDescriptor
{
  @NotNull
  private final FqName fqName;
  
  public PackageFragmentDescriptorImpl(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull FqName paramFqName)
  {
    super((DeclarationDescriptor)paramModuleDescriptor, Annotations.Companion.getEMPTY(), paramFqName.shortNameOrSpecial(), SourceElement.NO_SOURCE);
    this.fqName = paramFqName;
  }
  
  public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptorVisitor, "visitor");
    return paramDeclarationDescriptorVisitor.visitPackageFragmentDescriptor((PackageFragmentDescriptor)this, paramD);
  }
  
  @NotNull
  public ModuleDescriptor getContainingDeclaration()
  {
    DeclarationDescriptor localDeclarationDescriptor = super.getContainingDeclaration();
    if (localDeclarationDescriptor != null) {
      return (ModuleDescriptor)localDeclarationDescriptor;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
  }
  
  @NotNull
  public final FqName getFqName()
  {
    return this.fqName;
  }
  
  @NotNull
  public SourceElement getSource()
  {
    SourceElement localSourceElement = SourceElement.NO_SOURCE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "SourceElement.NO_SOURCE");
    return localSourceElement;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("package ");
    localStringBuilder.append(this.fqName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */