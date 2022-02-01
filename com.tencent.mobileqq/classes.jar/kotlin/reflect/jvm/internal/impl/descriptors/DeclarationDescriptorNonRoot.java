package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public abstract interface DeclarationDescriptorNonRoot
  extends DeclarationDescriptorWithSource
{
  @NotNull
  public abstract DeclarationDescriptor getContainingDeclaration();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot
 * JD-Core Version:    0.7.0.1
 */