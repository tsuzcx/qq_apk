package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib", "kotlinx/coroutines/flow/internal/ChannelFlowKt$$special$$inlined$Continuation$1", "kotlinx/coroutines/flow/internal/ChannelFlowKt$$special$$inlined$withCoroutineContext$lambda$1"}, k=1, mv={1, 1, 16})
public final class ChannelFlowKt$withContextUndispatched$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
  implements Continuation<T>
{
  public ChannelFlowKt$withContextUndispatched$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(CoroutineContext paramCoroutineContext1, Continuation paramContinuation, CoroutineContext paramCoroutineContext2, Object paramObject1, Function2 paramFunction2, Object paramObject2) {}
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.$context;
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    this.$uCont$inlined.resumeWith(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched..inlined.suspendCoroutineUninterceptedOrReturn.lambda.1
 * JD-Core Version:    0.7.0.1
 */