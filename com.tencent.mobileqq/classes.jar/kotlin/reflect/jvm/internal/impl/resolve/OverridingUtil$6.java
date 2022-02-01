package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;

final class OverridingUtil$6
  implements Function1<CallableMemberDescriptor, Boolean>
{
  OverridingUtil$6(ClassDescriptor paramClassDescriptor) {}
  
  public Boolean invoke(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    boolean bool;
    if ((!Visibilities.isPrivate(paramCallableMemberDescriptor.getVisibility())) && (Visibilities.isVisibleIgnoringReceiver(paramCallableMemberDescriptor, this.val$current))) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.6
 * JD-Core Version:    0.7.0.1
 */