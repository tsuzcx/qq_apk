package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

final class OverridingUtil$4
  implements Function1<CallableMemberDescriptor, Boolean>
{
  OverridingUtil$4(DeclarationDescriptor paramDeclarationDescriptor) {}
  
  public Boolean invoke(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    boolean bool;
    if (paramCallableMemberDescriptor.getContainingDeclaration() == this.val$containingDeclaration) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.4
 * JD-Core Version:    0.7.0.1
 */