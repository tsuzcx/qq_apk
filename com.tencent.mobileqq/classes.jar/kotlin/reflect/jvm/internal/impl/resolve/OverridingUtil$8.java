package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

final class OverridingUtil$8
  implements Function1<CallableMemberDescriptor, Unit>
{
  OverridingUtil$8(OverridingStrategy paramOverridingStrategy, CallableMemberDescriptor paramCallableMemberDescriptor) {}
  
  public Unit invoke(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    this.val$strategy.inheritanceConflict(this.val$overrider, paramCallableMemberDescriptor);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.8
 * JD-Core Version:    0.7.0.1
 */