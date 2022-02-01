package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;

public final class GivenFunctionsMemberScope$createFakeOverrides$4
  extends NonReportingOverrideStrategy
{
  GivenFunctionsMemberScope$createFakeOverrides$4(ArrayList paramArrayList) {}
  
  public void addFakeOverride(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "fakeOverride");
    OverridingUtil.resolveUnknownVisibilityForMember(paramCallableMemberDescriptor, null);
    this.$result.add(paramCallableMemberDescriptor);
  }
  
  protected void conflict(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor1, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor2)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor1, "fromSuper");
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor2, "fromCurrent");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Conflict in scope of ");
    localStringBuilder.append(this.this$0.getContainingClass());
    localStringBuilder.append(": ");
    localStringBuilder.append(paramCallableMemberDescriptor1);
    localStringBuilder.append(" vs ");
    localStringBuilder.append(paramCallableMemberDescriptor2);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope.createFakeOverrides.4
 * JD-Core Version:    0.7.0.1
 */