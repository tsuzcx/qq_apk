package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;

class DescriptorResolverUtils$1$1
  implements Function1<CallableMemberDescriptor, Unit>
{
  DescriptorResolverUtils$1$1(DescriptorResolverUtils.1 param1) {}
  
  public Unit invoke(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    this.this$0.val$errorReporter.reportCannotInferVisibility(paramCallableMemberDescriptor);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.1.1
 * JD-Core Version:    0.7.0.1
 */