package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class JavaVisibilities$3
  extends Visibility
{
  JavaVisibilities$3(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  protected Integer compareTo(@NotNull Visibility paramVisibility)
  {
    if (paramVisibility == null) {
      $$$reportNull$$$0(2);
    }
    if (this == paramVisibility) {
      return Integer.valueOf(0);
    }
    if (paramVisibility == Visibilities.INTERNAL) {
      return null;
    }
    if (Visibilities.isPrivate(paramVisibility)) {
      return Integer.valueOf(1);
    }
    return Integer.valueOf(-1);
  }
  
  @NotNull
  public String getInternalDisplayName()
  {
    return "protected/*protected and package*/";
  }
  
  public boolean isVisible(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(0);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(1);
    }
    return JavaVisibilities.access$100(paramReceiverValue, paramDeclarationDescriptorWithVisibility, paramDeclarationDescriptor);
  }
  
  @NotNull
  public Visibility normalize()
  {
    Visibility localVisibility = Visibilities.PROTECTED;
    if (localVisibility == null) {
      $$$reportNull$$$0(3);
    }
    return localVisibility;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities.3
 * JD-Core Version:    0.7.0.1
 */