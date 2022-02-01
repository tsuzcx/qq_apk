package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KCallableImpl$_parameters$1$3
  extends Lambda
  implements Function0<ValueParameterDescriptor>
{
  KCallableImpl$_parameters$1$3(CallableMemberDescriptor paramCallableMemberDescriptor, int paramInt)
  {
    super(0);
  }
  
  public final ValueParameterDescriptor invoke()
  {
    Object localObject = this.$descriptor.getValueParameters().get(this.$i);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "descriptor.valueParameters[i]");
    return (ValueParameterDescriptor)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KCallableImpl._parameters.1.3
 * JD-Core Version:    0.7.0.1
 */