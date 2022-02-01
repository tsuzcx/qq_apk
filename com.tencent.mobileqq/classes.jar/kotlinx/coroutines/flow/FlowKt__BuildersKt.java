package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"callbackFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "channelFlow", "emptyFlow", "flow", "Lkotlinx/coroutines/flow/FlowCollector;", "flowOf", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "elements", "", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "flowViaChannel", "bufferSize", "", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/ParameterName;", "name", "channel", "asFlow", "Lkotlin/Function0;", "", "", "", "", "", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "Lkotlin/sequences/Sequence;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__BuildersKt
{
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Iterable<? extends T> arg0) {}
  
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Iterator<? extends T> arg0) {}
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Function0<? extends T> arg0) {}
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Function1<? super Continuation<? super T>, ? extends Object> arg0) {}
  
  @NotNull
  public static final Flow<Integer> asFlow(@NotNull IntRange arg0) {}
  
  @NotNull
  public static final Flow<Long> asFlow(@NotNull LongRange arg0) {}
  
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Sequence<? extends T> arg0) {}
  
  @NotNull
  public static final Flow<Integer> asFlow(@NotNull int[] arg0) {}
  
  @NotNull
  public static final Flow<Long> asFlow(@NotNull long[] arg0) {}
  
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull T[] arg0) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> callbackFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> arg0) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> channelFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> arg0) {}
  
  @NotNull
  public static final <T> Flow<T> emptyFlow() {}
  
  @NotNull
  public static final <T> Flow<T> flow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> arg0) {}
  
  @NotNull
  public static final <T> Flow<T> flowOf(T arg0) {}
  
  @NotNull
  public static final <T> Flow<T> flowOf(@NotNull T... arg0) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> flowViaChannel(int arg0, @BuilderInference @NotNull Function2<? super CoroutineScope, ? super SendChannel<? super T>, Unit> arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__BuildersKt
 * JD-Core Version:    0.7.0.1
 */