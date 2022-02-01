package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class CombineKt$asChannel$1$invokeSuspend$$inlined$collect$1
  implements FlowCollector<Object>
{
  public CombineKt$asChannel$1$invokeSuspend$$inlined$collect$1(ProducerScope paramProducerScope) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    SendChannel localSendChannel = this.$this_produce$inlined.getChannel();
    if (paramObject == null) {
      paramObject = NullSurrogateKt.NULL;
    }
    paramObject = localSendChannel.send(paramObject, paramContinuation);
    if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramObject;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.asChannel.1.invokeSuspend..inlined.collect.1
 * JD-Core Version:    0.7.0.1
 */