package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public abstract interface MemberDescriptor
  extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility
{
  @NotNull
  public abstract Modality getModality();
  
  @NotNull
  public abstract Visibility getVisibility();
  
  public abstract boolean isActual();
  
  public abstract boolean isExpect();
  
  public abstract boolean isExternal();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
 * JD-Core Version:    0.7.0.1
 */