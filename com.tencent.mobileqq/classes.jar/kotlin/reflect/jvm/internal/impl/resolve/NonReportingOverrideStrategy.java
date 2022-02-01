package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract class NonReportingOverrideStrategy
  extends OverridingStrategy
{
  protected abstract void conflict(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor1, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor2);
  
  public void inheritanceConflict(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor1, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor2)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor1, "first");
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor2, "second");
    conflict(paramCallableMemberDescriptor1, paramCallableMemberDescriptor2);
  }
  
  public void overrideConflict(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor1, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor2)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor1, "fromSuper");
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor2, "fromCurrent");
    conflict(paramCallableMemberDescriptor1, paramCallableMemberDescriptor2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
 * JD-Core Version:    0.7.0.1
 */