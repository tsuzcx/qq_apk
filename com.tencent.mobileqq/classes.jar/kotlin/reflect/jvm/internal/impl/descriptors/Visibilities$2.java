package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Visibilities$2
  extends Visibility
{
  Visibilities$2(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  @NotNull
  public String getInternalDisplayName()
  {
    return "private/*private to this*/";
  }
  
  public boolean isVisible(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(0);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(1);
    }
    if (Visibilities.PRIVATE.isVisible(paramReceiverValue, paramDeclarationDescriptorWithVisibility, paramDeclarationDescriptor))
    {
      if (paramReceiverValue == Visibilities.ALWAYS_SUITABLE_RECEIVER) {
        return true;
      }
      if (paramReceiverValue == Visibilities.access$000()) {
        return false;
      }
      paramDeclarationDescriptorWithVisibility = DescriptorUtils.getParentOfType(paramDeclarationDescriptorWithVisibility, ClassDescriptor.class);
      if ((paramDeclarationDescriptorWithVisibility != null) && ((paramReceiverValue instanceof ThisClassReceiver))) {
        return ((ThisClassReceiver)paramReceiverValue).getClassDescriptor().getOriginal().equals(paramDeclarationDescriptorWithVisibility.getOriginal());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.2
 * JD-Core Version:    0.7.0.1
 */