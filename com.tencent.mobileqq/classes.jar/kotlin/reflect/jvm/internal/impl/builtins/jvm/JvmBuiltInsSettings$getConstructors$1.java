package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInsSettings$getConstructors$1
  extends Lambda
  implements Function2<ConstructorDescriptor, ConstructorDescriptor, Boolean>
{
  JvmBuiltInsSettings$getConstructors$1(TypeSubstitutor paramTypeSubstitutor)
  {
    super(2);
  }
  
  public final boolean invoke(@NotNull ConstructorDescriptor paramConstructorDescriptor1, @NotNull ConstructorDescriptor paramConstructorDescriptor2)
  {
    Intrinsics.checkParameterIsNotNull(paramConstructorDescriptor1, "$this$isEffectivelyTheSameAs");
    Intrinsics.checkParameterIsNotNull(paramConstructorDescriptor2, "javaConstructor");
    return OverridingUtil.getBothWaysOverridability((CallableDescriptor)paramConstructorDescriptor1, (CallableDescriptor)paramConstructorDescriptor2.substitute(this.$substitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.getConstructors.1
 * JD-Core Version:    0.7.0.1
 */