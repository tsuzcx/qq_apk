package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1
  extends Lambda
  implements Function1<CallableMemberDescriptor, KotlinType>
{
  SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1(ValueParameterDescriptor paramValueParameterDescriptor)
  {
    super(1);
  }
  
  @NotNull
  public final KotlinType invoke(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "it");
    paramCallableMemberDescriptor = paramCallableMemberDescriptor.getValueParameters().get(this.$p.getIndex());
    Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "it.valueParameters[p.index]");
    paramCallableMemberDescriptor = ((ValueParameterDescriptor)paramCallableMemberDescriptor).getType();
    Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "it.valueParameters[p.index].type");
    return paramCallableMemberDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature.valueParameterEnhancements.1.enhancementResult.1
 * JD-Core Version:    0.7.0.1
 */