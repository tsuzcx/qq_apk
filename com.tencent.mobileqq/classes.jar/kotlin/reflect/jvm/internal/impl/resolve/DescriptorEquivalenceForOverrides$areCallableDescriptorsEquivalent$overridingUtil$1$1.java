package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.Nullable;

final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1
  extends Lambda
  implements Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>
{
  DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1(DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent.overridingUtil.1 param1)
  {
    super(2);
  }
  
  public final boolean invoke(@Nullable DeclarationDescriptor paramDeclarationDescriptor1, @Nullable DeclarationDescriptor paramDeclarationDescriptor2)
  {
    return (Intrinsics.areEqual(paramDeclarationDescriptor1, this.this$0.$a)) && (Intrinsics.areEqual(paramDeclarationDescriptor2, this.this$0.$b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent.overridingUtil.1.1
 * JD-Core Version:    0.7.0.1
 */