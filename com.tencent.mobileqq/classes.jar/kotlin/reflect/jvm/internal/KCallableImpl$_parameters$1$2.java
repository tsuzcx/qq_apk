package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KCallableImpl$_parameters$1$2
  extends Lambda
  implements Function0<ReceiverParameterDescriptor>
{
  KCallableImpl$_parameters$1$2(ReceiverParameterDescriptor paramReceiverParameterDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final ReceiverParameterDescriptor invoke()
  {
    return this.$extensionReceiver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KCallableImpl._parameters.1.2
 * JD-Core Version:    0.7.0.1
 */