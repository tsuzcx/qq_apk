package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Visibilities$3
  extends Visibility
{
  Visibilities$3(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  private boolean doesReceiverFitForProtectedVisibility(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(2);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(3);
    }
    ReceiverValue localReceiverValue = Visibilities.FALSE_IF_PROTECTED;
    boolean bool2 = false;
    if (paramReceiverValue == localReceiverValue) {
      return false;
    }
    if (!(paramDeclarationDescriptorWithVisibility instanceof CallableMemberDescriptor)) {
      return true;
    }
    if ((paramDeclarationDescriptorWithVisibility instanceof ConstructorDescriptor)) {
      return true;
    }
    if (paramReceiverValue == Visibilities.ALWAYS_SUITABLE_RECEIVER) {
      return true;
    }
    boolean bool1 = bool2;
    if (paramReceiverValue != Visibilities.access$000())
    {
      if (paramReceiverValue == null) {
        return false;
      }
      if ((paramReceiverValue instanceof SuperCallReceiverValue)) {
        paramReceiverValue = ((SuperCallReceiverValue)paramReceiverValue).getThisType();
      } else {
        paramReceiverValue = paramReceiverValue.getType();
      }
      if (!DescriptorUtils.isSubtypeOfClass(paramReceiverValue, paramClassDescriptor))
      {
        bool1 = bool2;
        if (!DynamicTypesKt.isDynamic(paramReceiverValue)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isVisible(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(0);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(1);
    }
    Object localObject = (ClassDescriptor)DescriptorUtils.getParentOfType(paramDeclarationDescriptorWithVisibility, ClassDescriptor.class);
    paramDeclarationDescriptor = (ClassDescriptor)DescriptorUtils.getParentOfType(paramDeclarationDescriptor, ClassDescriptor.class, false);
    if (paramDeclarationDescriptor == null) {
      return false;
    }
    if ((localObject != null) && (DescriptorUtils.isCompanionObject((DeclarationDescriptor)localObject)))
    {
      localObject = (ClassDescriptor)DescriptorUtils.getParentOfType((DeclarationDescriptor)localObject, ClassDescriptor.class);
      if ((localObject != null) && (DescriptorUtils.isSubclass(paramDeclarationDescriptor, (ClassDescriptor)localObject))) {
        return true;
      }
    }
    localObject = DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(paramDeclarationDescriptorWithVisibility);
    ClassDescriptor localClassDescriptor = (ClassDescriptor)DescriptorUtils.getParentOfType((DeclarationDescriptor)localObject, ClassDescriptor.class);
    if (localClassDescriptor == null) {
      return false;
    }
    if ((DescriptorUtils.isSubclass(paramDeclarationDescriptor, localClassDescriptor)) && (doesReceiverFitForProtectedVisibility(paramReceiverValue, (DeclarationDescriptorWithVisibility)localObject, paramDeclarationDescriptor))) {
      return true;
    }
    return isVisible(paramReceiverValue, paramDeclarationDescriptorWithVisibility, paramDeclarationDescriptor.getContainingDeclaration());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.3
 * JD-Core Version:    0.7.0.1
 */