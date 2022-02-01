package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;

class EnumEntrySyntheticClassDescriptor$EnumEntryScope$4
  extends NonReportingOverrideStrategy
{
  EnumEntrySyntheticClassDescriptor$EnumEntryScope$4(EnumEntrySyntheticClassDescriptor.EnumEntryScope paramEnumEntryScope, Set paramSet) {}
  
  public void addFakeOverride(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    OverridingUtil.resolveUnknownVisibilityForMember(paramCallableMemberDescriptor, null);
    this.val$result.add(paramCallableMemberDescriptor);
  }
  
  protected void conflict(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor1, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor2)
  {
    if (paramCallableMemberDescriptor1 == null) {
      $$$reportNull$$$0(1);
    }
    if (paramCallableMemberDescriptor2 == null) {
      $$$reportNull$$$0(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.4
 * JD-Core Version:    0.7.0.1
 */