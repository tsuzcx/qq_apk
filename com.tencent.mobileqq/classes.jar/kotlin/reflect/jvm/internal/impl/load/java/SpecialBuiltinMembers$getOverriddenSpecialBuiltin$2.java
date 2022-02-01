package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;

final class SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2
  extends Lambda
  implements Function1<CallableMemberDescriptor, Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "it");
    return (KotlinBuiltIns.isBuiltIn((DeclarationDescriptor)paramCallableMemberDescriptor)) && (BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo(paramCallableMemberDescriptor) != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenSpecialBuiltin.2
 * JD-Core Version:    0.7.0.1
 */