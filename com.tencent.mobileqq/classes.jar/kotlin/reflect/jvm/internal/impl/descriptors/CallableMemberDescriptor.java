package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public abstract interface CallableMemberDescriptor
  extends CallableDescriptor, MemberDescriptor
{
  @NotNull
  public abstract CallableMemberDescriptor copy(DeclarationDescriptor paramDeclarationDescriptor, Modality paramModality, Visibility paramVisibility, CallableMemberDescriptor.Kind paramKind, boolean paramBoolean);
  
  @NotNull
  public abstract CallableMemberDescriptor.Kind getKind();
  
  @NotNull
  public abstract CallableMemberDescriptor getOriginal();
  
  @NotNull
  public abstract Collection<? extends CallableMemberDescriptor> getOverriddenDescriptors();
  
  public abstract void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> paramCollection);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
 * JD-Core Version:    0.7.0.1
 */