package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public abstract interface DeclarationDescriptorWithSource
  extends DeclarationDescriptor
{
  @NotNull
  public abstract SourceElement getSource();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
 * JD-Core Version:    0.7.0.1
 */