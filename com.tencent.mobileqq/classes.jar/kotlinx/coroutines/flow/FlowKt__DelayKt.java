package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", "", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "sample", "periodMillis", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__DelayKt
{
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> arg0, long arg1) {}
  
  @NotNull
  public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope arg0, long arg1, long arg3) {}
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> sample(@NotNull Flow<? extends T> arg0, long arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt
 * JD-Core Version:    0.7.0.1
 */