package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import org.jetbrains.annotations.NotNull;

final class BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1
  extends Lambda
  implements Function1<CallableMemberDescriptor, Boolean>
{
  BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "it");
    paramCallableMemberDescriptor = BuiltinMethodsWithDifferentJvmName.access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$p(BuiltinMethodsWithDifferentJvmName.INSTANCE);
    String str = MethodSignatureMappingKt.computeJvmSignature((CallableDescriptor)this.$functionDescriptor);
    if (paramCallableMemberDescriptor != null) {
      return paramCallableMemberDescriptor.containsKey(str);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.isBuiltinFunctionWithDifferentNameInJvm.1
 * JD-Core Version:    0.7.0.1
 */