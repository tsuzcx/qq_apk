package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Visibilities$1
  extends Visibility
{
  Visibilities$1(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  private boolean hasContainingSourceFile(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    boolean bool = false;
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    if (DescriptorUtils.getContainingSourceFile(paramDeclarationDescriptor) != SourceFile.NO_SOURCE_FILE) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isVisible(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(1);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(2);
    }
    if ((DescriptorUtils.isTopLevelDeclaration(paramDeclarationDescriptorWithVisibility)) && (hasContainingSourceFile(paramDeclarationDescriptor))) {
      return Visibilities.inSameFile(paramDeclarationDescriptorWithVisibility, paramDeclarationDescriptor);
    }
    paramReceiverValue = paramDeclarationDescriptorWithVisibility;
    Object localObject;
    if ((paramDeclarationDescriptorWithVisibility instanceof ConstructorDescriptor))
    {
      localObject = ((ConstructorDescriptor)paramDeclarationDescriptorWithVisibility).getContainingDeclaration();
      paramReceiverValue = paramDeclarationDescriptorWithVisibility;
      if (DescriptorUtils.isSealedClass((DeclarationDescriptor)localObject))
      {
        paramReceiverValue = paramDeclarationDescriptorWithVisibility;
        if (DescriptorUtils.isTopLevelDeclaration((DeclarationDescriptor)localObject))
        {
          paramReceiverValue = paramDeclarationDescriptorWithVisibility;
          if ((paramDeclarationDescriptor instanceof ConstructorDescriptor))
          {
            paramReceiverValue = paramDeclarationDescriptorWithVisibility;
            if (DescriptorUtils.isTopLevelDeclaration(paramDeclarationDescriptor.getContainingDeclaration()))
            {
              paramReceiverValue = paramDeclarationDescriptorWithVisibility;
              if (Visibilities.inSameFile(paramDeclarationDescriptorWithVisibility, paramDeclarationDescriptor)) {
                return true;
              }
            }
          }
        }
      }
    }
    do
    {
      paramDeclarationDescriptorWithVisibility = paramReceiverValue;
      if (paramReceiverValue == null) {
        break;
      }
      localObject = paramReceiverValue.getContainingDeclaration();
      if ((localObject instanceof ClassDescriptor))
      {
        paramDeclarationDescriptorWithVisibility = (DeclarationDescriptorWithVisibility)localObject;
        if (!DescriptorUtils.isCompanionObject((DeclarationDescriptor)localObject)) {
          break;
        }
      }
      paramReceiverValue = (ReceiverValue)localObject;
    } while (!(localObject instanceof PackageFragmentDescriptor));
    paramDeclarationDescriptorWithVisibility = (DeclarationDescriptorWithVisibility)localObject;
    if (paramDeclarationDescriptorWithVisibility == null) {
      return false;
    }
    while (paramDeclarationDescriptor != null)
    {
      if (paramDeclarationDescriptorWithVisibility == paramDeclarationDescriptor) {
        return true;
      }
      if ((paramDeclarationDescriptor instanceof PackageFragmentDescriptor)) {
        return ((paramDeclarationDescriptorWithVisibility instanceof PackageFragmentDescriptor)) && (((PackageFragmentDescriptor)paramDeclarationDescriptorWithVisibility).getFqName().equals(((PackageFragmentDescriptor)paramDeclarationDescriptor).getFqName())) && (DescriptorUtils.areInSameModule(paramDeclarationDescriptor, paramDeclarationDescriptorWithVisibility));
      }
      paramDeclarationDescriptor = paramDeclarationDescriptor.getContainingDeclaration();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.1
 * JD-Core Version:    0.7.0.1
 */