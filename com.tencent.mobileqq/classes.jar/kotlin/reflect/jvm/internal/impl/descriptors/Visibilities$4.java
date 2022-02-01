package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Visibilities$4
  extends Visibility
{
  Visibilities$4(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public boolean isVisible(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(0);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(1);
    }
    paramReceiverValue = DescriptorUtils.getContainingModule(paramDeclarationDescriptorWithVisibility);
    if (!DescriptorUtils.getContainingModule(paramDeclarationDescriptor).shouldSeeInternalsOf(paramReceiverValue)) {
      return false;
    }
    return Visibilities.access$100().isInFriendModule(paramDeclarationDescriptorWithVisibility, paramDeclarationDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.4
 * JD-Core Version:    0.7.0.1
 */