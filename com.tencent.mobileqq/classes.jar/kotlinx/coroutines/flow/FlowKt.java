package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k=4, mv={1, 1, 16})
public final class FlowKt
{
  @NotNull
  public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";
  
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Iterable<? extends T> paramIterable)
  {
    return FlowKt__BuildersKt.asFlow(paramIterable);
  }
  
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Iterator<? extends T> paramIterator)
  {
    return FlowKt__BuildersKt.asFlow(paramIterator);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Function0<? extends T> paramFunction0)
  {
    return FlowKt__BuildersKt.asFlow(paramFunction0);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1)
  {
    return FlowKt__BuildersKt.asFlow(paramFunction1);
  }
  
  @NotNull
  public static final Flow<Integer> asFlow(@NotNull IntRange paramIntRange)
  {
    return FlowKt__BuildersKt.asFlow(paramIntRange);
  }
  
  @NotNull
  public static final Flow<Long> asFlow(@NotNull LongRange paramLongRange)
  {
    return FlowKt__BuildersKt.asFlow(paramLongRange);
  }
  
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull Sequence<? extends T> paramSequence)
  {
    return FlowKt__BuildersKt.asFlow(paramSequence);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull BroadcastChannel<T> paramBroadcastChannel)
  {
    return FlowKt__ChannelsKt.asFlow(paramBroadcastChannel);
  }
  
  @NotNull
  public static final Flow<Integer> asFlow(@NotNull int[] paramArrayOfInt)
  {
    return FlowKt__BuildersKt.asFlow(paramArrayOfInt);
  }
  
  @NotNull
  public static final Flow<Long> asFlow(@NotNull long[] paramArrayOfLong)
  {
    return FlowKt__BuildersKt.asFlow(paramArrayOfLong);
  }
  
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull T[] paramArrayOfT)
  {
    return FlowKt__BuildersKt.asFlow(paramArrayOfT);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> BroadcastChannel<T> broadcastIn(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineStart paramCoroutineStart)
  {
    return FlowKt__ChannelsKt.broadcastIn(paramFlow, paramCoroutineScope, paramCoroutineStart);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> paramFlow, int paramInt)
  {
    return FlowKt__ContextKt.buffer(paramFlow, paramInt);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> callbackFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return FlowKt__BuildersKt.callbackFlow(paramFunction2);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> jdMethod_catch(@NotNull Flow<? extends T> paramFlow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> paramFunction3)
  {
    return FlowKt__ErrorsKt.jdMethod_catch(paramFlow, paramFunction3);
  }
  
  @Nullable
  public static final <T> Object catchImpl(@NotNull Flow<? extends T> paramFlow, @NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Continuation<? super Throwable> paramContinuation)
  {
    return FlowKt__ErrorsKt.catchImpl(paramFlow, paramFlowCollector, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> channelFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return FlowKt__BuildersKt.channelFlow(paramFunction2);
  }
  
  @Nullable
  public static final Object collect(@NotNull Flow<?> paramFlow, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return FlowKt__CollectKt.collect(paramFlow, paramContinuation);
  }
  
  @Nullable
  public static final <T> Object collect(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction2, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return FlowKt__CollectKt.collect(paramFlow, paramFunction2, paramContinuation);
  }
  
  @Nullable
  private static final Object collect$$forInline(@NotNull Flow paramFlow, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return FlowKt__CollectKt.collect(paramFlow, paramFunction2, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object collectIndexed(@NotNull Flow<? extends T> paramFlow, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction3, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return FlowKt__CollectKt.collectIndexed(paramFlow, paramFunction3, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object collectIndexed$$forInline(@NotNull Flow paramFlow, @NotNull Function3 paramFunction3, @NotNull Continuation paramContinuation)
  {
    return FlowKt__CollectKt.collectIndexed(paramFlow, paramFunction3, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object collectLatest(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction2, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return FlowKt__CollectKt.collectLatest(paramFlow, paramFunction2, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> combine(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return FlowKt__ZipKt.combine(paramFlow, paramFlow1, paramFunction3);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, R> Flow<R> combine(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @BuilderInference @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> paramFunction4)
  {
    return FlowKt__ZipKt.combine(paramFlow, paramFlow1, paramFlow2, paramFunction4);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, T4, R> Flow<R> combine(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @NotNull Flow<? extends T4> paramFlow3, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> paramFunction5)
  {
    return FlowKt__ZipKt.combine(paramFlow, paramFlow1, paramFlow2, paramFlow3, paramFunction5);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @NotNull Flow<? extends T4> paramFlow3, @NotNull Flow<? extends T5> paramFlow4, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> paramFunction6)
  {
    return FlowKt__ZipKt.combine(paramFlow, paramFlow1, paramFlow2, paramFlow3, paramFlow4, paramFunction6);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="this.combine(other, transform)", imports={}))
  @NotNull
  public static final <T1, T2, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return FlowKt__MigrationKt.combineLatest(paramFlow, paramFlow1, paramFunction3);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, transform)", imports={}))
  @NotNull
  public static final <T1, T2, T3, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> paramFunction4)
  {
    return FlowKt__MigrationKt.combineLatest(paramFlow, paramFlow1, paramFlow2, paramFunction4);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, other3, transform)", imports={}))
  @NotNull
  public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @NotNull Flow<? extends T4> paramFlow3, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> paramFunction5)
  {
    return FlowKt__MigrationKt.combineLatest(paramFlow, paramFlow1, paramFlow2, paramFlow3, paramFunction5);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, other3, transform)", imports={}))
  @NotNull
  public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @NotNull Flow<? extends T4> paramFlow3, @NotNull Flow<? extends T5> paramFlow4, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> paramFunction6)
  {
    return FlowKt__MigrationKt.combineLatest(paramFlow, paramFlow1, paramFlow2, paramFlow3, paramFlow4, paramFunction6);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> paramFunction4)
  {
    return FlowKt__ZipKt.combineTransform(paramFlow, paramFlow1, paramFunction4);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @BuilderInference @NotNull Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> paramFunction5)
  {
    return FlowKt__ZipKt.combineTransform(paramFlow, paramFlow1, paramFlow2, paramFunction5);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @NotNull Flow<? extends T4> paramFlow3, @BuilderInference @NotNull Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> paramFunction6)
  {
    return FlowKt__ZipKt.combineTransform(paramFlow, paramFlow1, paramFlow2, paramFlow3, paramFunction6);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Flow<? extends T3> paramFlow2, @NotNull Flow<? extends T4> paramFlow3, @NotNull Flow<? extends T5> paramFlow4, @BuilderInference @NotNull Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> paramFunction7)
  {
    return FlowKt__ZipKt.combineTransform(paramFlow, paramFlow1, paramFlow2, paramFlow3, paramFlow4, paramFunction7);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'compose' is 'let'", replaceWith=@ReplaceWith(expression="let(transformer)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> compose(@NotNull Flow<? extends T> paramFlow, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> paramFunction1)
  {
    return FlowKt__MigrationKt.compose(paramFlow, paramFunction1);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith=@ReplaceWith(expression="flatMapConcat(mapper)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> concatMap(@NotNull Flow<? extends T> paramFlow, @NotNull Function1<? super T, ? extends Flow<? extends R>> paramFunction1)
  {
    return FlowKt__MigrationKt.concatMap(paramFlow, paramFunction1);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith=@ReplaceWith(expression="onCompletion { emit(value) }", imports={}))
  @NotNull
  public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> paramFlow, T paramT)
  {
    return FlowKt__MigrationKt.concatWith(paramFlow, paramT);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith=@ReplaceWith(expression="onCompletion { emitAll(other) }", imports={}))
  @NotNull
  public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> paramFlow1, @NotNull Flow<? extends T> paramFlow2)
  {
    return FlowKt__MigrationKt.concatWith(paramFlow1, paramFlow2);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> paramFlow)
  {
    return FlowKt__ContextKt.conflate(paramFlow);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> paramReceiveChannel)
  {
    return FlowKt__ChannelsKt.consumeAsFlow(paramReceiveChannel);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object count(@NotNull Flow<? extends T> paramFlow, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return FlowKt__CountKt.count(paramFlow, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object count(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return FlowKt__CountKt.count(paramFlow, paramFunction2, paramContinuation);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> paramFlow, long paramLong)
  {
    return FlowKt__DelayKt.debounce(paramFlow, paramLong);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Use 'onEach { delay(timeMillis) }'", replaceWith=@ReplaceWith(expression="onEach { delay(timeMillis) }", imports={}))
  @NotNull
  public static final <T> Flow<T> delayEach(@NotNull Flow<? extends T> paramFlow, long paramLong)
  {
    return FlowKt__MigrationKt.delayEach(paramFlow, paramLong);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Use 'onStart { delay(timeMillis) }'", replaceWith=@ReplaceWith(expression="onStart { delay(timeMillis) }", imports={}))
  @NotNull
  public static final <T> Flow<T> delayFlow(@NotNull Flow<? extends T> paramFlow, long paramLong)
  {
    return FlowKt__MigrationKt.delayFlow(paramFlow, paramLong);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> paramFlow)
  {
    return FlowKt__DistinctKt.distinctUntilChanged(paramFlow);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super T, Boolean> paramFunction2)
  {
    return FlowKt__DistinctKt.distinctUntilChanged(paramFlow, paramFunction2);
  }
  
  @FlowPreview
  @NotNull
  public static final <T, K> Flow<T> distinctUntilChangedBy(@NotNull Flow<? extends T> paramFlow, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    return FlowKt__DistinctKt.distinctUntilChangedBy(paramFlow, paramFunction1);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> drop(@NotNull Flow<? extends T> paramFlow, int paramInt)
  {
    return FlowKt__LimitKt.drop(paramFlow, paramInt);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> dropWhile(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return FlowKt__LimitKt.dropWhile(paramFlow, paramFunction2);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object emitAll(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull ReceiveChannel<? extends T> paramReceiveChannel, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return FlowKt__ChannelsKt.emitAll(paramFlowCollector, paramReceiveChannel, paramContinuation);
  }
  
  @BuilderInference
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object emitAll(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Flow<? extends T> paramFlow, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return FlowKt__CollectKt.emitAll(paramFlowCollector, paramFlow, paramContinuation);
  }
  
  @BuilderInference
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object emitAll$$forInline(@NotNull FlowCollector paramFlowCollector, @NotNull Flow paramFlow, @NotNull Continuation paramContinuation)
  {
    return FlowKt__CollectKt.emitAll(paramFlowCollector, paramFlow, paramContinuation);
  }
  
  @NotNull
  public static final <T> Flow<T> emptyFlow()
  {
    return FlowKt__BuildersKt.emptyFlow();
  }
  
  @NotNull
  public static final <T> Flow<T> filter(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return FlowKt__TransformKt.filter(paramFlow, paramFunction2);
  }
  
  @NotNull
  public static final <T> Flow<T> filterNot(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return FlowKt__TransformKt.filterNot(paramFlow, paramFunction2);
  }
  
  @NotNull
  public static final <T> Flow<T> filterNotNull(@NotNull Flow<? extends T> paramFlow)
  {
    return FlowKt__TransformKt.filterNotNull(paramFlow);
  }
  
  @Nullable
  public static final <T> Object first(@NotNull Flow<? extends T> paramFlow, @NotNull Continuation<? super T> paramContinuation)
  {
    return FlowKt__ReduceKt.first(paramFlow, paramContinuation);
  }
  
  @Nullable
  public static final <T> Object first(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2, @NotNull Continuation<? super T> paramContinuation)
  {
    return FlowKt__ReduceKt.first(paramFlow, paramFunction2, paramContinuation);
  }
  
  @NotNull
  public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope paramCoroutineScope, long paramLong1, long paramLong2)
  {
    return FlowKt__DelayKt.fixedPeriodTicker(paramCoroutineScope, paramLong1, paramLong2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue is named flatMapConcat", replaceWith=@ReplaceWith(expression="flatMapConcat(mapper)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> flatMap(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> paramFunction2)
  {
    return FlowKt__MigrationKt.flatMap(paramFlow, paramFunction2);
  }
  
  @FlowPreview
  @NotNull
  public static final <T, R> Flow<R> flatMapConcat(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> paramFunction2)
  {
    return FlowKt__MergeKt.flatMapConcat(paramFlow, paramFunction2);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> flatMapLatest(@NotNull Flow<? extends T> paramFlow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> paramFunction2)
  {
    return FlowKt__MergeKt.flatMapLatest(paramFlow, paramFunction2);
  }
  
  @FlowPreview
  @NotNull
  public static final <T, R> Flow<R> flatMapMerge(@NotNull Flow<? extends T> paramFlow, int paramInt, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> paramFunction2)
  {
    return FlowKt__MergeKt.flatMapMerge(paramFlow, paramInt, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'flatten' is 'flattenConcat'", replaceWith=@ReplaceWith(expression="flattenConcat()", imports={}))
  @NotNull
  public static final <T> Flow<T> flatten(@NotNull Flow<? extends Flow<? extends T>> paramFlow)
  {
    return FlowKt__MigrationKt.flatten(paramFlow);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> flattenConcat(@NotNull Flow<? extends Flow<? extends T>> paramFlow)
  {
    return FlowKt__MergeKt.flattenConcat(paramFlow);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> flattenMerge(@NotNull Flow<? extends Flow<? extends T>> paramFlow, int paramInt)
  {
    return FlowKt__MergeKt.flattenMerge(paramFlow, paramInt);
  }
  
  @NotNull
  public static final <T> Flow<T> flow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return FlowKt__BuildersKt.flow(paramFunction2);
  }
  
  @JvmName(name="flowCombine")
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> flowCombine(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return FlowKt__ZipKt.flowCombine(paramFlow, paramFlow1, paramFunction3);
  }
  
  @JvmName(name="flowCombineTransform")
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> flowCombineTransform(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> paramFunction4)
  {
    return FlowKt__ZipKt.flowCombineTransform(paramFlow, paramFlow1, paramFunction4);
  }
  
  @NotNull
  public static final <T> Flow<T> flowOf(T paramT)
  {
    return FlowKt__BuildersKt.flowOf(paramT);
  }
  
  @NotNull
  public static final <T> Flow<T> flowOf(@NotNull T... paramVarArgs)
  {
    return FlowKt__BuildersKt.flowOf(paramVarArgs);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext)
  {
    return FlowKt__ContextKt.flowOn(paramFlow, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> flowViaChannel(int paramInt, @BuilderInference @NotNull Function2<? super CoroutineScope, ? super SendChannel<? super T>, Unit> paramFunction2)
  {
    return FlowKt__BuildersKt.flowViaChannel(paramInt, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
  @FlowPreview
  @NotNull
  public static final <T, R> Flow<R> flowWith(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext, int paramInt, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> paramFunction1)
  {
    return FlowKt__ContextKt.flowWith(paramFlow, paramCoroutineContext, paramInt, paramFunction1);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T, R> Object fold(@NotNull Flow<? extends T> paramFlow, R paramR, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> paramFunction3, @NotNull Continuation<? super R> paramContinuation)
  {
    return FlowKt__ReduceKt.fold(paramFlow, paramR, paramFunction3, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object fold$$forInline(@NotNull Flow paramFlow, Object paramObject, @NotNull Function3 paramFunction3, @NotNull Continuation paramContinuation)
  {
    return FlowKt__ReduceKt.fold(paramFlow, paramObject, paramFunction3, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'forEach' is 'collect'", replaceWith=@ReplaceWith(expression="collect(block)", imports={}))
  public static final <T> void forEach(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    FlowKt__MigrationKt.forEach(paramFlow, paramFunction2);
  }
  
  public static final int getDEFAULT_CONCURRENCY()
  {
    return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Job launchIn(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineScope paramCoroutineScope)
  {
    return FlowKt__CollectKt.launchIn(paramFlow, paramCoroutineScope);
  }
  
  @NotNull
  public static final <T, R> Flow<R> map(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    return FlowKt__TransformKt.map(paramFlow, paramFunction2);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> mapLatest(@NotNull Flow<? extends T> paramFlow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    return FlowKt__MergeKt.mapLatest(paramFlow, paramFunction2);
  }
  
  @NotNull
  public static final <T, R> Flow<R> mapNotNull(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    return FlowKt__TransformKt.mapNotNull(paramFlow, paramFunction2);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> merge(@NotNull Iterable<? extends Flow<? extends T>> paramIterable)
  {
    return FlowKt__MergeKt.merge(paramIterable);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'merge' is 'flattenConcat'", replaceWith=@ReplaceWith(expression="flattenConcat()", imports={}))
  @NotNull
  public static final <T> Flow<T> merge(@NotNull Flow<? extends Flow<? extends T>> paramFlow)
  {
    return FlowKt__MigrationKt.merge(paramFlow);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> merge(@NotNull Flow<? extends T>... paramVarArgs)
  {
    return FlowKt__MergeKt.merge(paramVarArgs);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Collect flow in the desired context instead")
  @NotNull
  public static final <T> Flow<T> observeOn(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext)
  {
    return FlowKt__MigrationKt.observeOn(paramFlow, paramCoroutineContext);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> onCompletion(@NotNull Flow<? extends T> paramFlow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> paramFunction3)
  {
    return FlowKt__EmittersKt.onCompletion(paramFlow, paramFunction3);
  }
  
  @NotNull
  public static final <T> Flow<T> onEach(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return FlowKt__TransformKt.onEach(paramFlow, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith=@ReplaceWith(expression="catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorCollect(@NotNull Flow<? extends T> paramFlow1, @NotNull Flow<? extends T> paramFlow2, @NotNull Function1<? super Throwable, Boolean> paramFunction1)
  {
    return FlowKt__ErrorsKt.onErrorCollect(paramFlow1, paramFlow2, paramFunction1);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emitAll(fallback) }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorResume(@NotNull Flow<? extends T> paramFlow1, @NotNull Flow<? extends T> paramFlow2)
  {
    return FlowKt__MigrationKt.onErrorResume(paramFlow1, paramFlow2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emitAll(fallback) }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorResumeNext(@NotNull Flow<? extends T> paramFlow1, @NotNull Flow<? extends T> paramFlow2)
  {
    return FlowKt__MigrationKt.onErrorResumeNext(paramFlow1, paramFlow2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emit(fallback) }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> paramFlow, T paramT)
  {
    return FlowKt__MigrationKt.onErrorReturn(paramFlow, paramT);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith=@ReplaceWith(expression="catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> paramFlow, T paramT, @NotNull Function1<? super Throwable, Boolean> paramFunction1)
  {
    return FlowKt__MigrationKt.onErrorReturn(paramFlow, paramT, paramFunction1);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> onStart(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return FlowKt__EmittersKt.onStart(paramFlow, paramFunction2);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineScope paramCoroutineScope)
  {
    return FlowKt__ChannelsKt.produceIn(paramFlow, paramCoroutineScope);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Collect flow in the desired context instead")
  @NotNull
  public static final <T> Flow<T> publishOn(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext)
  {
    return FlowKt__MigrationKt.publishOn(paramFlow, paramCoroutineContext);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> receiveAsFlow(@NotNull ReceiveChannel<? extends T> paramReceiveChannel)
  {
    return FlowKt__ChannelsKt.receiveAsFlow(paramReceiveChannel);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <S, T extends S> Object reduce(@NotNull Flow<? extends T> paramFlow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> paramFunction3, @NotNull Continuation<? super S> paramContinuation)
  {
    return FlowKt__ReduceKt.reduce(paramFlow, paramFunction3, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> retry(@NotNull Flow<? extends T> paramFlow, long paramLong, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return FlowKt__ErrorsKt.retry(paramFlow, paramLong, paramFunction2);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> retryWhen(@NotNull Flow<? extends T> paramFlow, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> paramFunction4)
  {
    return FlowKt__ErrorsKt.retryWhen(paramFlow, paramFunction4);
  }
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> sample(@NotNull Flow<? extends T> paramFlow, long paramLong)
  {
    return FlowKt__DelayKt.sample(paramFlow, paramLong);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> scan(@NotNull Flow<? extends T> paramFlow, R paramR, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return FlowKt__TransformKt.scan(paramFlow, paramR, paramFunction3);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow has less verbose 'scan' shortcut", replaceWith=@ReplaceWith(expression="scan(initial, operation)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> scanFold(@NotNull Flow<? extends T> paramFlow, R paramR, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return FlowKt__MigrationKt.scanFold(paramFlow, paramR, paramFunction3);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> scanReduce(@NotNull Flow<? extends T> paramFlow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> paramFunction3)
  {
    return FlowKt__TransformKt.scanReduce(paramFlow, paramFunction3);
  }
  
  @Nullable
  public static final <T> Object single(@NotNull Flow<? extends T> paramFlow, @NotNull Continuation<? super T> paramContinuation)
  {
    return FlowKt__ReduceKt.single(paramFlow, paramContinuation);
  }
  
  @Nullable
  public static final <T> Object singleOrNull(@NotNull Flow<? extends T> paramFlow, @NotNull Continuation<? super T> paramContinuation)
  {
    return FlowKt__ReduceKt.singleOrNull(paramFlow, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'skip' is 'drop'", replaceWith=@ReplaceWith(expression="drop(count)", imports={}))
  @NotNull
  public static final <T> Flow<T> skip(@NotNull Flow<? extends T> paramFlow, int paramInt)
  {
    return FlowKt__MigrationKt.skip(paramFlow, paramInt);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith=@ReplaceWith(expression="onStart { emit(value) }", imports={}))
  @NotNull
  public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> paramFlow, T paramT)
  {
    return FlowKt__MigrationKt.startWith(paramFlow, paramT);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith=@ReplaceWith(expression="onStart { emitAll(other) }", imports={}))
  @NotNull
  public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> paramFlow1, @NotNull Flow<? extends T> paramFlow2)
  {
    return FlowKt__MigrationKt.startWith(paramFlow1, paramFlow2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use launchIn with onEach, onCompletion and catch operators instead")
  public static final <T> void subscribe(@NotNull Flow<? extends T> paramFlow)
  {
    FlowKt__MigrationKt.subscribe(paramFlow);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use launchIn with onEach, onCompletion and catch operators instead")
  public static final <T> void subscribe(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    FlowKt__MigrationKt.subscribe(paramFlow, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use launchIn with onEach, onCompletion and catch operators instead")
  public static final <T> void subscribe(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction2, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> paramFunction21)
  {
    FlowKt__MigrationKt.subscribe(paramFlow, paramFunction2, paramFunction21);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use flowOn instead")
  @NotNull
  public static final <T> Flow<T> subscribeOn(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext)
  {
    return FlowKt__MigrationKt.subscribeOn(paramFlow, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith=@ReplaceWith(expression="this.flatMapLatest(transform)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> switchMap(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> paramFunction2)
  {
    return FlowKt__MigrationKt.switchMap(paramFlow, paramFunction2);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> take(@NotNull Flow<? extends T> paramFlow, int paramInt)
  {
    return FlowKt__LimitKt.take(paramFlow, paramInt);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> takeWhile(@NotNull Flow<? extends T> paramFlow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return FlowKt__LimitKt.takeWhile(paramFlow, paramFunction2);
  }
  
  @Nullable
  public static final <T, C extends Collection<? super T>> Object toCollection(@NotNull Flow<? extends T> paramFlow, @NotNull C paramC, @NotNull Continuation<? super C> paramContinuation)
  {
    return FlowKt__CollectionKt.toCollection(paramFlow, paramC, paramContinuation);
  }
  
  @Nullable
  public static final <T> Object toList(@NotNull Flow<? extends T> paramFlow, @NotNull List<T> paramList, @NotNull Continuation<? super List<? extends T>> paramContinuation)
  {
    return FlowKt__CollectionKt.toList(paramFlow, paramList, paramContinuation);
  }
  
  @Nullable
  public static final <T> Object toSet(@NotNull Flow<? extends T> paramFlow, @NotNull Set<T> paramSet, @NotNull Continuation<? super Set<? extends T>> paramContinuation)
  {
    return FlowKt__CollectionKt.toSet(paramFlow, paramSet, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> transform(@NotNull Flow<? extends T> paramFlow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction3)
  {
    return FlowKt__EmittersKt.transform(paramFlow, paramFunction3);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> transformLatest(@NotNull Flow<? extends T> paramFlow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction3)
  {
    return FlowKt__MergeKt.transformLatest(paramFlow, paramFunction3);
  }
  
  @PublishedApi
  @NotNull
  public static final <T, R> Flow<R> unsafeTransform(@NotNull Flow<? extends T> paramFlow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction3)
  {
    return FlowKt__EmittersKt.unsafeTransform(paramFlow, paramFunction3);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<IndexedValue<T>> withIndex(@NotNull Flow<? extends T> paramFlow)
  {
    return FlowKt__TransformKt.withIndex(paramFlow);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> zip(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return FlowKt__ZipKt.zip(paramFlow, paramFlow1, paramFunction3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt
 * JD-Core Version:    0.7.0.1
 */