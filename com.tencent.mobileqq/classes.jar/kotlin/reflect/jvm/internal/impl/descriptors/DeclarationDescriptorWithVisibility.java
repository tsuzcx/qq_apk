package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public abstract interface DeclarationDescriptorWithVisibility
  extends DeclarationDescriptor
{
  @NotNull
  public abstract Visibility getVisibility();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
 * JD-Core Version:    0.7.0.1
 */