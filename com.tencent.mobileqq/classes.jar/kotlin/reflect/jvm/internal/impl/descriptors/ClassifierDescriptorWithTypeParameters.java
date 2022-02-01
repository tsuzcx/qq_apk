package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract interface ClassifierDescriptorWithTypeParameters
  extends ClassifierDescriptor, DeclarationDescriptorWithVisibility, MemberDescriptor, Substitutable<ClassifierDescriptorWithTypeParameters>
{
  @NotNull
  public abstract List<TypeParameterDescriptor> getDeclaredTypeParameters();
  
  public abstract boolean isInner();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
 * JD-Core Version:    0.7.0.1
 */