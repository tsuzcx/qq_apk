package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

final class JvmBuiltInsSettings$isMutabilityViolation$2
  extends Lambda
  implements Function1<CallableMemberDescriptor, Boolean>
{
  JvmBuiltInsSettings$isMutabilityViolation$2(JvmBuiltInsSettings paramJvmBuiltInsSettings)
  {
    super(1);
  }
  
  public final boolean invoke(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "overridden");
    if (paramCallableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION)
    {
      JavaToKotlinClassMap localJavaToKotlinClassMap = JvmBuiltInsSettings.access$getJ2kClassMap$p(this.this$0);
      paramCallableMemberDescriptor = paramCallableMemberDescriptor.getContainingDeclaration();
      if (paramCallableMemberDescriptor != null)
      {
        if (localJavaToKotlinClassMap.isMutable((ClassDescriptor)paramCallableMemberDescriptor)) {
          return true;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.isMutabilityViolation.2
 * JD-Core Version:    0.7.0.1
 */