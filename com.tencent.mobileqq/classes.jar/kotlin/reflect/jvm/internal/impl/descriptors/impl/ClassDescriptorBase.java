package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public abstract class ClassDescriptorBase
  extends AbstractClassDescriptor
{
  private final DeclarationDescriptor containingDeclaration;
  private final boolean isExternal;
  private final SourceElement source;
  
  protected ClassDescriptorBase(@NotNull StorageManager paramStorageManager, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Name paramName, @NotNull SourceElement paramSourceElement, boolean paramBoolean)
  {
    super(paramStorageManager, paramName);
    this.containingDeclaration = paramDeclarationDescriptor;
    this.source = paramSourceElement;
    this.isExternal = paramBoolean;
  }
  
  @NotNull
  public DeclarationDescriptor getContainingDeclaration()
  {
    DeclarationDescriptor localDeclarationDescriptor = this.containingDeclaration;
    if (localDeclarationDescriptor == null) {
      $$$reportNull$$$0(4);
    }
    return localDeclarationDescriptor;
  }
  
  @NotNull
  public SourceElement getSource()
  {
    SourceElement localSourceElement = this.source;
    if (localSourceElement == null) {
      $$$reportNull$$$0(5);
    }
    return localSourceElement;
  }
  
  public boolean isExternal()
  {
    return this.isExternal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase
 * JD-Core Version:    0.7.0.1
 */