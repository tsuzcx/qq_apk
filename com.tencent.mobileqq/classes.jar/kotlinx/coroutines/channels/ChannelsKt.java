package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt"}, k=4, mv={1, 1, 16})
public final class ChannelsKt
{
  @NotNull
  public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object all(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.all(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object all$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.all(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object any(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.any(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object any(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.any(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object any$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.any(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V> Object associate(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, ? extends Pair<? extends K, ? extends V>> paramFunction1, @NotNull Continuation<? super Map<K, ? extends V>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associate(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associate$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associate(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K> Object associateBy(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, ? extends K> paramFunction1, @NotNull Continuation<? super Map<K, ? extends E>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V> Object associateBy(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, ? extends K> paramFunction1, @NotNull Function1<? super E, ? extends V> paramFunction11, @NotNull Continuation<? super Map<K, ? extends V>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateBy(paramReceiveChannel, paramFunction1, paramFunction11, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateBy$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateBy$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction11, @NotNull Function1 paramFunction12, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateBy(paramReceiveChannel, paramFunction11, paramFunction12, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, M extends Map<? super K, ? super E>> Object associateByTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull M paramM, @NotNull Function1<? super E, ? extends K> paramFunction1, @NotNull Continuation<? super M> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateByTo(paramReceiveChannel, paramM, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateByTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull M paramM, @NotNull Function1<? super E, ? extends K> paramFunction1, @NotNull Function1<? super E, ? extends V> paramFunction11, @NotNull Continuation<? super M> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateByTo(paramReceiveChannel, paramM, paramFunction1, paramFunction11, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateByTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Map paramMap, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateByTo(paramReceiveChannel, paramMap, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateByTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Map paramMap, @NotNull Function1 paramFunction11, @NotNull Function1 paramFunction12, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateByTo(paramReceiveChannel, paramMap, paramFunction11, paramFunction12, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull M paramM, @NotNull Function1<? super E, ? extends Pair<? extends K, ? extends V>> paramFunction1, @NotNull Continuation<? super M> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateTo(paramReceiveChannel, paramM, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Map paramMap, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.associateTo(paramReceiveChannel, paramMap, paramFunction1, paramContinuation);
  }
  
  @PublishedApi
  public static final void cancelConsumed(@NotNull ReceiveChannel<?> paramReceiveChannel, @Nullable Throwable paramThrowable)
  {
    ChannelsKt__Channels_commonKt.cancelConsumed(paramReceiveChannel, paramThrowable);
  }
  
  @ObsoleteCoroutinesApi
  public static final <E, R> R consume(@NotNull BroadcastChannel<E> paramBroadcastChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> paramFunction1)
  {
    return ChannelsKt__Channels_commonKt.consume(paramBroadcastChannel, paramFunction1);
  }
  
  @ExperimentalCoroutinesApi
  public static final <E, R> R consume(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> paramFunction1)
  {
    return ChannelsKt__Channels_commonKt.consume(paramReceiveChannel, paramFunction1);
  }
  
  @ObsoleteCoroutinesApi
  @Nullable
  public static final <E> Object consumeEach(@NotNull BroadcastChannel<E> paramBroadcastChannel, @NotNull Function1<? super E, Unit> paramFunction1, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.consumeEach(paramBroadcastChannel, paramFunction1, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <E> Object consumeEach(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Unit> paramFunction1, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.consumeEach(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @ObsoleteCoroutinesApi
  @Nullable
  private static final Object consumeEach$$forInline(@NotNull BroadcastChannel paramBroadcastChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.consumeEach(paramBroadcastChannel, paramFunction1, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object consumeEach$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.consumeEach(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object consumeEachIndexed(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super IndexedValue<? extends E>, Unit> paramFunction1, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.consumeEachIndexed(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object consumeEachIndexed$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.consumeEachIndexed(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final Function1<Throwable, Unit> consumes(@NotNull ReceiveChannel<?> paramReceiveChannel)
  {
    return ChannelsKt__Channels_commonKt.consumes(paramReceiveChannel);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final Function1<Throwable, Unit> consumesAll(@NotNull ReceiveChannel<?>... paramVarArgs)
  {
    return ChannelsKt__Channels_commonKt.consumesAll(paramVarArgs);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object count(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.count(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object count(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.count(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object count$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.count(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> distinct(@NotNull ReceiveChannel<? extends E> paramReceiveChannel)
  {
    return ChannelsKt__Channels_commonKt.distinct(paramReceiveChannel);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, K> ReceiveChannel<E> distinctBy(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super Continuation<? super K>, ? extends Object> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.distinctBy(paramReceiveChannel, paramCoroutineContext, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> drop(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, int paramInt, @NotNull CoroutineContext paramCoroutineContext)
  {
    return ChannelsKt__Channels_commonKt.drop(paramReceiveChannel, paramInt, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> dropWhile(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.dropWhile(paramReceiveChannel, paramCoroutineContext, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object elementAt(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, int paramInt, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.elementAt(paramReceiveChannel, paramInt, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object elementAtOrElse(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, int paramInt, @NotNull Function1<? super Integer, ? extends E> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.elementAtOrElse(paramReceiveChannel, paramInt, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object elementAtOrElse$$forInline(@NotNull ReceiveChannel paramReceiveChannel, int paramInt, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.elementAtOrElse(paramReceiveChannel, paramInt, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object elementAtOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, int paramInt, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.elementAtOrNull(paramReceiveChannel, paramInt, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> filter(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.filter(paramReceiveChannel, paramCoroutineContext, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> filterIndexed(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> paramFunction3)
  {
    return ChannelsKt__Channels_commonKt.filterIndexed(paramReceiveChannel, paramCoroutineContext, paramFunction3);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object filterIndexedTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function2<? super Integer, ? super E, Boolean> paramFunction2, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterIndexedTo(paramReceiveChannel, paramC, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object filterIndexedTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function2<? super Integer, ? super E, Boolean> paramFunction2, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterIndexedTo(paramReceiveChannel, paramC, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterIndexedTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Collection paramCollection, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterIndexedTo(paramReceiveChannel, paramCollection, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterIndexedTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull SendChannel paramSendChannel, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterIndexedTo(paramReceiveChannel, paramSendChannel, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> filterNot(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.filterNot(paramReceiveChannel, paramCoroutineContext, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> filterNotNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel)
  {
    return ChannelsKt__Channels_commonKt.filterNotNull(paramReceiveChannel);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object filterNotNullTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterNotNullTo(paramReceiveChannel, paramC, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object filterNotNullTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterNotNullTo(paramReceiveChannel, paramC, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object filterNotTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterNotTo(paramReceiveChannel, paramC, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object filterNotTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterNotTo(paramReceiveChannel, paramC, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterNotTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Collection paramCollection, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterNotTo(paramReceiveChannel, paramCollection, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterNotTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull SendChannel paramSendChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterNotTo(paramReceiveChannel, paramSendChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object filterTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterTo(paramReceiveChannel, paramC, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object filterTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterTo(paramReceiveChannel, paramC, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Collection paramCollection, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterTo(paramReceiveChannel, paramCollection, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull SendChannel paramSendChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.filterTo(paramReceiveChannel, paramSendChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object find(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.find(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object find$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.find(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object findLast(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.findLast(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object findLast$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.findLast(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object first(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.first(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object first(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.first(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object first$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.first(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object firstOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.firstOrNull(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object firstOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.firstOrNull(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object firstOrNull$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.firstOrNull(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> flatMap(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.flatMap(paramReceiveChannel, paramCoroutineContext, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R> Object fold(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, R paramR, @NotNull Function2<? super R, ? super E, ? extends R> paramFunction2, @NotNull Continuation<? super R> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.fold(paramReceiveChannel, paramR, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object fold$$forInline(@NotNull ReceiveChannel paramReceiveChannel, Object paramObject, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.fold(paramReceiveChannel, paramObject, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R> Object foldIndexed(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, R paramR, @NotNull Function3<? super Integer, ? super R, ? super E, ? extends R> paramFunction3, @NotNull Continuation<? super R> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.foldIndexed(paramReceiveChannel, paramR, paramFunction3, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object foldIndexed$$forInline(@NotNull ReceiveChannel paramReceiveChannel, Object paramObject, @NotNull Function3 paramFunction3, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.foldIndexed(paramReceiveChannel, paramObject, paramFunction3, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K> Object groupBy(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, ? extends K> paramFunction1, @NotNull Continuation<? super Map<K, ? extends List<? extends E>>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.groupBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V> Object groupBy(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, ? extends K> paramFunction1, @NotNull Function1<? super E, ? extends V> paramFunction11, @NotNull Continuation<? super Map<K, ? extends List<? extends V>>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.groupBy(paramReceiveChannel, paramFunction1, paramFunction11, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object groupBy$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.groupBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object groupBy$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction11, @NotNull Function1 paramFunction12, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.groupBy(paramReceiveChannel, paramFunction11, paramFunction12, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, M extends Map<? super K, List<E>>> Object groupByTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull M paramM, @NotNull Function1<? super E, ? extends K> paramFunction1, @NotNull Continuation<? super M> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.groupByTo(paramReceiveChannel, paramM, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V, M extends Map<? super K, List<V>>> Object groupByTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull M paramM, @NotNull Function1<? super E, ? extends K> paramFunction1, @NotNull Function1<? super E, ? extends V> paramFunction11, @NotNull Continuation<? super M> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.groupByTo(paramReceiveChannel, paramM, paramFunction1, paramFunction11, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object groupByTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Map paramMap, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.groupByTo(paramReceiveChannel, paramMap, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object groupByTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Map paramMap, @NotNull Function1 paramFunction11, @NotNull Function1 paramFunction12, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.groupByTo(paramReceiveChannel, paramMap, paramFunction11, paramFunction12, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object indexOf(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, E paramE, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.indexOf(paramReceiveChannel, paramE, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object indexOfFirst(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.indexOfFirst(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object indexOfFirst$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.indexOfFirst(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object indexOfLast(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.indexOfLast(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object indexOfLast$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.indexOfLast(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object last(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.last(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object last(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.last(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object last$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.last(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object lastIndexOf(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, E paramE, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.lastIndexOf(paramReceiveChannel, paramE, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object lastOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.lastOrNull(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object lastOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.lastOrNull(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object lastOrNull$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.lastOrNull(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> map(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.map(paramReceiveChannel, paramCoroutineContext, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> mapIndexed(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return ChannelsKt__Channels_commonKt.mapIndexed(paramReceiveChannel, paramCoroutineContext, paramFunction3);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedNotNull(paramReceiveChannel, paramCoroutineContext, paramFunction3);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends Collection<? super R>> Object mapIndexedNotNullTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function2<? super Integer, ? super E, ? extends R> paramFunction2, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo(paramReceiveChannel, paramC, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedNotNullTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function2<? super Integer, ? super E, ? extends R> paramFunction2, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo(paramReceiveChannel, paramC, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapIndexedNotNullTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Collection paramCollection, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo(paramReceiveChannel, paramCollection, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapIndexedNotNullTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull SendChannel paramSendChannel, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo(paramReceiveChannel, paramSendChannel, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends Collection<? super R>> Object mapIndexedTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function2<? super Integer, ? super E, ? extends R> paramFunction2, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedTo(paramReceiveChannel, paramC, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function2<? super Integer, ? super E, ? extends R> paramFunction2, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedTo(paramReceiveChannel, paramC, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapIndexedTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Collection paramCollection, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedTo(paramReceiveChannel, paramCollection, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapIndexedTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull SendChannel paramSendChannel, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapIndexedTo(paramReceiveChannel, paramSendChannel, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> mapNotNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.mapNotNull(paramReceiveChannel, paramCoroutineContext, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends Collection<? super R>> Object mapNotNullTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function1<? super E, ? extends R> paramFunction1, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapNotNullTo(paramReceiveChannel, paramC, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends SendChannel<? super R>> Object mapNotNullTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function1<? super E, ? extends R> paramFunction1, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapNotNullTo(paramReceiveChannel, paramC, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapNotNullTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Collection paramCollection, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapNotNullTo(paramReceiveChannel, paramCollection, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapNotNullTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull SendChannel paramSendChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapNotNullTo(paramReceiveChannel, paramSendChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends Collection<? super R>> Object mapTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function1<? super E, ? extends R> paramFunction1, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapTo(paramReceiveChannel, paramC, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends SendChannel<? super R>> Object mapTo(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Function1<? super E, ? extends R> paramFunction1, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapTo(paramReceiveChannel, paramC, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Collection paramCollection, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapTo(paramReceiveChannel, paramCollection, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapTo$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull SendChannel paramSendChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.mapTo(paramReceiveChannel, paramSendChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R extends Comparable<? super R>> Object maxBy(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, ? extends R> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.maxBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object maxBy$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.maxBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object maxWith(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Comparator<? super E> paramComparator, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.maxWith(paramReceiveChannel, paramComparator, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R extends Comparable<? super R>> Object minBy(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, ? extends R> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.minBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object minBy$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.minBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object minWith(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Comparator<? super E> paramComparator, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.minWith(paramReceiveChannel, paramComparator, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object none(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.none(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object none(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.none(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object none$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.none(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <E> SelectClause1<E> onReceiveOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel)
  {
    return ChannelsKt__Channels_commonKt.onReceiveOrNull(paramReceiveChannel);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object partition(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super Pair<? extends List<? extends E>, ? extends List<? extends E>>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.partition(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object partition$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.partition(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <E> Object receiveOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.receiveOrNull(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <S, E extends S> Object reduce(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function2<? super S, ? super E, ? extends S> paramFunction2, @NotNull Continuation<? super S> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.reduce(paramReceiveChannel, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object reduce$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.reduce(paramReceiveChannel, paramFunction2, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <S, E extends S> Object reduceIndexed(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function3<? super Integer, ? super S, ? super E, ? extends S> paramFunction3, @NotNull Continuation<? super S> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.reduceIndexed(paramReceiveChannel, paramFunction3, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object reduceIndexed$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function3 paramFunction3, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.reduceIndexed(paramReceiveChannel, paramFunction3, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> requireNoNulls(@NotNull ReceiveChannel<? extends E> paramReceiveChannel)
  {
    return ChannelsKt__Channels_commonKt.requireNoNulls(paramReceiveChannel);
  }
  
  public static final <E> void sendBlocking(@NotNull SendChannel<? super E> paramSendChannel, E paramE)
  {
    ChannelsKt__ChannelsKt.sendBlocking(paramSendChannel, paramE);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object single(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.single(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object single(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.single(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object single$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.single(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object singleOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.singleOrNull(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object singleOrNull(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Boolean> paramFunction1, @NotNull Continuation<? super E> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.singleOrNull(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object singleOrNull$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.singleOrNull(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object sumBy(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Integer> paramFunction1, @NotNull Continuation<? super Integer> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.sumBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object sumBy$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.sumBy(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object sumByDouble(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Function1<? super E, Double> paramFunction1, @NotNull Continuation<? super Double> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.sumByDouble(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object sumByDouble$$forInline(@NotNull ReceiveChannel paramReceiveChannel, @NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.sumByDouble(paramReceiveChannel, paramFunction1, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> take(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, int paramInt, @NotNull CoroutineContext paramCoroutineContext)
  {
    return ChannelsKt__Channels_commonKt.take(paramReceiveChannel, paramInt, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> takeWhile(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.takeWhile(paramReceiveChannel, paramCoroutineContext, paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object toChannel(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.toChannel(paramReceiveChannel, paramC, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object toCollection(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull C paramC, @NotNull Continuation<? super C> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.toCollection(paramReceiveChannel, paramC, paramContinuation);
  }
  
  @Nullable
  public static final <E> Object toList(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super List<? extends E>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.toList(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> paramReceiveChannel, @NotNull M paramM, @NotNull Continuation<? super M> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.toMap(paramReceiveChannel, paramM, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <K, V> Object toMap(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> paramReceiveChannel, @NotNull Continuation<? super Map<K, ? extends V>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.toMap(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object toMutableList(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super List<E>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.toMutableList(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object toMutableSet(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super Set<E>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.toMutableSet(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object toSet(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull Continuation<? super Set<? extends E>> paramContinuation)
  {
    return ChannelsKt__Channels_commonKt.toSet(paramReceiveChannel, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull CoroutineContext paramCoroutineContext)
  {
    return ChannelsKt__Channels_commonKt.withIndex(paramReceiveChannel, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<Pair<E, R>> zip(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull ReceiveChannel<? extends R> paramReceiveChannel1)
  {
    return ChannelsKt__Channels_commonKt.zip(paramReceiveChannel, paramReceiveChannel1);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R, V> ReceiveChannel<V> zip(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, @NotNull ReceiveChannel<? extends R> paramReceiveChannel1, @NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super E, ? super R, ? extends V> paramFunction2)
  {
    return ChannelsKt__Channels_commonKt.zip(paramReceiveChannel, paramReceiveChannel1, paramCoroutineContext, paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt
 * JD-Core Version:    0.7.0.1
 */