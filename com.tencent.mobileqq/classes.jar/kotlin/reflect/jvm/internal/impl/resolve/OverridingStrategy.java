package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract class OverridingStrategy
{
  public abstract void addFakeOverride(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor);
  
  public abstract void inheritanceConflict(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor1, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor2);
  
  public abstract void overrideConflict(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor1, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor2);
  
  public void setOverriddenDescriptors(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "member");
    Intrinsics.checkParameterIsNotNull(paramCollection, "overridden");
    paramCallableMemberDescriptor.setOverriddenDescriptors(paramCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
 * JD-Core Version:    0.7.0.1
 */