package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1
  extends Lambda
  implements Function1<CallableMemberDescriptor, KotlinType>
{
  public static final 1 INSTANCE = new 1();
  
  SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1()
  {
    super(1);
  }
  
  @NotNull
  public final KotlinType invoke(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "it");
    paramCallableMemberDescriptor = paramCallableMemberDescriptor.getReturnType();
    if (paramCallableMemberDescriptor == null) {
      Intrinsics.throwNpe();
    }
    return paramCallableMemberDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature.returnTypeEnhancement.1
 * JD-Core Version:    0.7.0.1
 */