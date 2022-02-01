package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public abstract class DeclarationDescriptorNonRootImpl
  extends DeclarationDescriptorImpl
  implements DeclarationDescriptorNonRoot
{
  @NotNull
  private final DeclarationDescriptor containingDeclaration;
  @NotNull
  private final SourceElement source;
  
  protected DeclarationDescriptorNonRootImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull SourceElement paramSourceElement)
  {
    super(paramAnnotations, paramName);
    this.containingDeclaration = paramDeclarationDescriptor;
    this.source = paramSourceElement;
  }
  
  @NotNull
  public DeclarationDescriptor getContainingDeclaration()
  {
    DeclarationDescriptor localDeclarationDescriptor = this.containingDeclaration;
    if (localDeclarationDescriptor == null) {
      $$$reportNull$$$0(5);
    }
    return localDeclarationDescriptor;
  }
  
  @NotNull
  public DeclarationDescriptorWithSource getOriginal()
  {
    DeclarationDescriptorWithSource localDeclarationDescriptorWithSource = (DeclarationDescriptorWithSource)super.getOriginal();
    if (localDeclarationDescriptorWithSource == null) {
      $$$reportNull$$$0(4);
    }
    return localDeclarationDescriptorWithSource;
  }
  
  @NotNull
  public SourceElement getSource()
  {
    SourceElement localSourceElement = this.source;
    if (localSourceElement == null) {
      $$$reportNull$$$0(6);
    }
    return localSourceElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl
 * JD-Core Version:    0.7.0.1
 */