package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "receiveAsFlow", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ChannelsKt
{
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull BroadcastChannel<T> arg0) {}
  
  @FlowPreview
  @NotNull
  public static final <T> BroadcastChannel<T> broadcastIn(@NotNull Flow<? extends T> arg0, @NotNull CoroutineScope arg1, @NotNull CoroutineStart arg2) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> arg0) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object emitAll(@NotNull FlowCollector<? super T> arg0, @NotNull ReceiveChannel<? extends T> arg1, @NotNull Continuation<? super Unit> arg2) {}
  
  @FlowPreview
  @NotNull
  public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> arg0, @NotNull CoroutineScope arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> receiveAsFlow(@NotNull ReceiveChannel<? extends T> arg0) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ChannelsKt
 * JD-Core Version:    0.7.0.1
 */