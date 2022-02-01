package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Visibilities$6
  extends Visibility
{
  Visibilities$6(String paramString, boolean paramBoolean)
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
    throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.6
 * JD-Core Version:    0.7.0.1
 */