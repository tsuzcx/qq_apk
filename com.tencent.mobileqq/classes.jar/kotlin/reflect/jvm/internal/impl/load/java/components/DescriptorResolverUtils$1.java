package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;

final class DescriptorResolverUtils$1
  extends NonReportingOverrideStrategy
{
  DescriptorResolverUtils$1(ErrorReporter paramErrorReporter, Set paramSet, boolean paramBoolean) {}
  
  public void addFakeOverride(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    OverridingUtil.resolveUnknownVisibilityForMember(paramCallableMemberDescriptor, new DescriptorResolverUtils.1.1(this));
    this.val$result.add(paramCallableMemberDescriptor);
  }
  
  public void conflict(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor1, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor2)
  {
    if (paramCallableMemberDescriptor1 == null) {
      $$$reportNull$$$0(1);
    }
    if (paramCallableMemberDescriptor2 == null) {
      $$$reportNull$$$0(2);
    }
  }
  
  public void setOverriddenDescriptors(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(3);
    }
    if (paramCollection == null) {
      $$$reportNull$$$0(4);
    }
    if ((this.val$isStaticContext) && (paramCallableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE)) {
      return;
    }
    super.setOverriddenDescriptors(paramCallableMemberDescriptor, paramCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.1
 * JD-Core Version:    0.7.0.1
 */