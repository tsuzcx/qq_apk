package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1
  extends NonReportingOverrideStrategy
{
  DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(Collection paramCollection) {}
  
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.generateFakeOverrides.1
 * JD-Core Version:    0.7.0.1
 */