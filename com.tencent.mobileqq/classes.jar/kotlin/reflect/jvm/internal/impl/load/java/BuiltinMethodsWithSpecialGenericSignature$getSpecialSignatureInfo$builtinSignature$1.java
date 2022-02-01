package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

final class BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1
  extends Lambda
  implements Function1<CallableMemberDescriptor, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "it");
    return ((paramCallableMemberDescriptor instanceof FunctionDescriptor)) && (BuiltinMethodsWithSpecialGenericSignature.access$getHasErasedValueParametersInJava$p(BuiltinMethodsWithSpecialGenericSignature.INSTANCE, paramCallableMemberDescriptor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo.builtinSignature.1
 * JD-Core Version:    0.7.0.1
 */