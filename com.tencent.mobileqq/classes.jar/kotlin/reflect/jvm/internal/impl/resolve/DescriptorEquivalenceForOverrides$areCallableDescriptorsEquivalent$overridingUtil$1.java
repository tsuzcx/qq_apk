package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;
import org.jetbrains.annotations.NotNull;

final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1
  implements KotlinTypeChecker.TypeConstructorEquality
{
  DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(boolean paramBoolean, CallableDescriptor paramCallableDescriptor1, CallableDescriptor paramCallableDescriptor2) {}
  
  public final boolean invoke(@NotNull TypeConstructor paramTypeConstructor1, @NotNull TypeConstructor paramTypeConstructor2)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor1, "c1");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor2, "c2");
    if (Intrinsics.areEqual(paramTypeConstructor1, paramTypeConstructor2)) {
      return true;
    }
    paramTypeConstructor1 = paramTypeConstructor1.getDeclarationDescriptor();
    paramTypeConstructor2 = paramTypeConstructor2.getDeclarationDescriptor();
    if (((paramTypeConstructor1 instanceof TypeParameterDescriptor)) && ((paramTypeConstructor2 instanceof TypeParameterDescriptor))) {
      return DescriptorEquivalenceForOverrides.access$areTypeParametersEquivalent(DescriptorEquivalenceForOverrides.INSTANCE, (TypeParameterDescriptor)paramTypeConstructor1, (TypeParameterDescriptor)paramTypeConstructor2, this.$allowCopiesFromTheSameDeclaration, (Function2)new DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent.overridingUtil.1.1(this));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent.overridingUtil.1
 * JD-Core Version:    0.7.0.1
 */