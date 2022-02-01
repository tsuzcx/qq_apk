package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaVisibilities
{
  @NotNull
  public static final Visibility PACKAGE_VISIBILITY = new JavaVisibilities.1("package", false);
  @NotNull
  public static final Visibility PROTECTED_AND_PACKAGE = new JavaVisibilities.3("protected_and_package", true);
  @NotNull
  public static final Visibility PROTECTED_STATIC_VISIBILITY = new JavaVisibilities.2("protected_static", true);
  
  private static boolean areInSamePackage(@NotNull DeclarationDescriptor paramDeclarationDescriptor1, @NotNull DeclarationDescriptor paramDeclarationDescriptor2)
  {
    if (paramDeclarationDescriptor1 == null) {
      $$$reportNull$$$0(2);
    }
    if (paramDeclarationDescriptor2 == null) {
      $$$reportNull$$$0(3);
    }
    boolean bool2 = false;
    paramDeclarationDescriptor1 = (PackageFragmentDescriptor)DescriptorUtils.getParentOfType(paramDeclarationDescriptor1, PackageFragmentDescriptor.class, false);
    paramDeclarationDescriptor2 = (PackageFragmentDescriptor)DescriptorUtils.getParentOfType(paramDeclarationDescriptor2, PackageFragmentDescriptor.class, false);
    boolean bool1 = bool2;
    if (paramDeclarationDescriptor2 != null)
    {
      bool1 = bool2;
      if (paramDeclarationDescriptor1 != null)
      {
        bool1 = bool2;
        if (paramDeclarationDescriptor1.getFqName().equals(paramDeclarationDescriptor2.getFqName())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean isVisibleForProtectedAndPackage(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(0);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(1);
    }
    if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(paramDeclarationDescriptorWithVisibility), paramDeclarationDescriptor)) {
      return true;
    }
    return Visibilities.PROTECTED.isVisible(paramReceiverValue, paramDeclarationDescriptorWithVisibility, paramDeclarationDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities
 * JD-Core Version:    0.7.0.1
 */