package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class JavaVisibilities$2
  extends Visibility
{
  JavaVisibilities$2(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  @NotNull
  public String getInternalDisplayName()
  {
    return "protected/*protected static*/";
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
      $$$reportNull$$$0(2);
    }
    return localVisibility;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities.2
 * JD-Core Version:    0.7.0.1
 */