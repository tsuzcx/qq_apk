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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"DEFAULT_CLOSE_MESSAGE", "", "consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "all", "", "E", "predicate", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "any", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateByTo", "M", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateTo", "cancelConsumed", "consume", "R", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeEachIndexed", "Lkotlin/collections/IndexedValue;", "consumes", "count", "", "distinct", "distinctBy", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "elementAt", "index", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterIndexedTo", "C", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterNot", "filterNotNull", "filterNotNullTo", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterNotTo", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterTo", "find", "findLast", "first", "firstOrNull", "flatMap", "fold", "initial", "operation", "acc", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foldIndexed", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "groupBy", "", "groupByTo", "", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "indexOfFirst", "indexOfLast", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minBy", "minWith", "none", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "partition", "receiveOrNull", "reduce", "S", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reduceIndexed", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireNoNulls", "single", "singleOrNull", "sumBy", "sumByDouble", "", "take", "takeWhile", "toChannel", "toCollection", "toList", "toMap", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "toMutableSet", "", "toSet", "", "withIndex", "zip", "other", "a", "b", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/channels/ChannelsKt")
final class ChannelsKt__Channels_commonKt
{
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object all(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super Boolean> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object all$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object any(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super Boolean> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object any(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super Boolean> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object any$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V> Object associate(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, ? extends Pair<? extends K, ? extends V>> arg1, @NotNull Continuation<? super Map<K, ? extends V>> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associate$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K> Object associateBy(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, ? extends K> arg1, @NotNull Continuation<? super Map<K, ? extends E>> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V> Object associateBy(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, ? extends K> arg1, @NotNull Function1<? super E, ? extends V> arg2, @NotNull Continuation<? super Map<K, ? extends V>> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateBy$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateBy$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, M extends Map<? super K, ? super E>> Object associateByTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull M arg1, @NotNull Function1<? super E, ? extends K> arg2, @NotNull Continuation<? super M> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateByTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull M arg1, @NotNull Function1<? super E, ? extends K> arg2, @NotNull Function1<? super E, ? extends V> arg3, @NotNull Continuation<? super M> arg4) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateByTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Map arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateByTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Map arg1, @NotNull Function1 arg2, @NotNull Function1 arg3, @NotNull Continuation arg4) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull M arg1, @NotNull Function1<? super E, ? extends Pair<? extends K, ? extends V>> arg2, @NotNull Continuation<? super M> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object associateTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Map arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @PublishedApi
  public static final void cancelConsumed(@NotNull ReceiveChannel<?> arg0, @Nullable Throwable arg1) {}
  
  @ObsoleteCoroutinesApi
  public static final <E, R> R consume(@NotNull BroadcastChannel<E> arg0, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> arg1) {}
  
  @ExperimentalCoroutinesApi
  public static final <E, R> R consume(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> arg1) {}
  
  @ObsoleteCoroutinesApi
  @Nullable
  public static final <E> Object consumeEach(@NotNull BroadcastChannel<E> arg0, @NotNull Function1<? super E, Unit> arg1, @NotNull Continuation<? super Unit> arg2) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <E> Object consumeEach(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Unit> arg1, @NotNull Continuation<? super Unit> arg2) {}
  
  @ObsoleteCoroutinesApi
  @Nullable
  private static final Object consumeEach$$forInline(@NotNull BroadcastChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object consumeEach$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object consumeEachIndexed(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super IndexedValue<? extends E>, Unit> arg1, @NotNull Continuation<? super Unit> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object consumeEachIndexed$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final Function1<Throwable, Unit> consumes(@NotNull ReceiveChannel<?> arg0) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final Function1<Throwable, Unit> consumesAll(@NotNull ReceiveChannel<?>... arg0) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object count(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super Integer> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object count(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super Integer> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object count$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> distinct(@NotNull ReceiveChannel<? extends E> arg0) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, K> ReceiveChannel<E> distinctBy(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function2<? super E, ? super Continuation<? super K>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> drop(@NotNull ReceiveChannel<? extends E> arg0, int arg1, @NotNull CoroutineContext arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> dropWhile(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object elementAt(@NotNull ReceiveChannel<? extends E> arg0, int arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object elementAtOrElse(@NotNull ReceiveChannel<? extends E> arg0, int arg1, @NotNull Function1<? super Integer, ? extends E> arg2, @NotNull Continuation<? super E> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object elementAtOrElse$$forInline(@NotNull ReceiveChannel arg0, int arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object elementAtOrNull(@NotNull ReceiveChannel<? extends E> arg0, int arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> filter(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> filterIndexed(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object filterIndexedTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function2<? super Integer, ? super E, Boolean> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object filterIndexedTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function2<? super Integer, ? super E, Boolean> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterIndexedTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Collection arg1, @NotNull Function2 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterIndexedTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull SendChannel arg1, @NotNull Function2 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> filterNot(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> filterNotNull(@NotNull ReceiveChannel<? extends E> arg0) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object filterNotNullTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Continuation<? super C> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object filterNotNullTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Continuation<? super C> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object filterNotTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function1<? super E, Boolean> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object filterNotTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function1<? super E, Boolean> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterNotTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Collection arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterNotTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull SendChannel arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object filterTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function1<? super E, Boolean> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object filterTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function1<? super E, Boolean> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Collection arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object filterTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull SendChannel arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object find(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object find$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object findLast(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object findLast$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object first(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super E> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object first(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object first$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object firstOrNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super E> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object firstOrNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object firstOrNull$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> flatMap(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R> Object fold(@NotNull ReceiveChannel<? extends E> arg0, R arg1, @NotNull Function2<? super R, ? super E, ? extends R> arg2, @NotNull Continuation<? super R> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object fold$$forInline(@NotNull ReceiveChannel arg0, Object arg1, @NotNull Function2 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R> Object foldIndexed(@NotNull ReceiveChannel<? extends E> arg0, R arg1, @NotNull Function3<? super Integer, ? super R, ? super E, ? extends R> arg2, @NotNull Continuation<? super R> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object foldIndexed$$forInline(@NotNull ReceiveChannel arg0, Object arg1, @NotNull Function3 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K> Object groupBy(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, ? extends K> arg1, @NotNull Continuation<? super Map<K, ? extends List<? extends E>>> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V> Object groupBy(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, ? extends K> arg1, @NotNull Function1<? super E, ? extends V> arg2, @NotNull Continuation<? super Map<K, ? extends List<? extends V>>> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object groupBy$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object groupBy$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, M extends Map<? super K, List<E>>> Object groupByTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull M arg1, @NotNull Function1<? super E, ? extends K> arg2, @NotNull Continuation<? super M> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, K, V, M extends Map<? super K, List<V>>> Object groupByTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull M arg1, @NotNull Function1<? super E, ? extends K> arg2, @NotNull Function1<? super E, ? extends V> arg3, @NotNull Continuation<? super M> arg4) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object groupByTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Map arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object groupByTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Map arg1, @NotNull Function1 arg2, @NotNull Function1 arg3, @NotNull Continuation arg4) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object indexOf(@NotNull ReceiveChannel<? extends E> arg0, E arg1, @NotNull Continuation<? super Integer> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object indexOfFirst(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super Integer> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object indexOfFirst$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object indexOfLast(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super Integer> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object indexOfLast$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object last(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super E> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object last(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object last$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object lastIndexOf(@NotNull ReceiveChannel<? extends E> arg0, E arg1, @NotNull Continuation<? super Integer> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object lastOrNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super E> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object lastOrNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object lastOrNull$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> map(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> mapIndexed(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends Collection<? super R>> Object mapIndexedNotNullTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function2<? super Integer, ? super E, ? extends R> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedNotNullTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function2<? super Integer, ? super E, ? extends R> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapIndexedNotNullTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Collection arg1, @NotNull Function2 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapIndexedNotNullTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull SendChannel arg1, @NotNull Function2 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends Collection<? super R>> Object mapIndexedTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function2<? super Integer, ? super E, ? extends R> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function2<? super Integer, ? super E, ? extends R> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapIndexedTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Collection arg1, @NotNull Function2 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapIndexedTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull SendChannel arg1, @NotNull Function2 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<R> mapNotNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends Collection<? super R>> Object mapNotNullTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function1<? super E, ? extends R> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends SendChannel<? super R>> Object mapNotNullTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function1<? super E, ? extends R> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapNotNullTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Collection arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapNotNullTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull SendChannel arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends Collection<? super R>> Object mapTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function1<? super E, ? extends R> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R, C extends SendChannel<? super R>> Object mapTo(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Function1<? super E, ? extends R> arg2, @NotNull Continuation<? super C> arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull Collection arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object mapTo$$forInline(@NotNull ReceiveChannel arg0, @NotNull SendChannel arg1, @NotNull Function1 arg2, @NotNull Continuation arg3) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R extends Comparable<? super R>> Object maxBy(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, ? extends R> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object maxBy$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object maxWith(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Comparator<? super E> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, R extends Comparable<? super R>> Object minBy(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, ? extends R> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object minBy$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object minWith(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Comparator<? super E> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object none(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super Boolean> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object none(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super Boolean> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object none$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <E> SelectClause1<E> onReceiveOrNull(@NotNull ReceiveChannel<? extends E> arg0) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object partition(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super Pair<? extends List<? extends E>, ? extends List<? extends E>>> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object partition$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <E> Object receiveOrNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super E> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <S, E extends S> Object reduce(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function2<? super S, ? super E, ? extends S> arg1, @NotNull Continuation<? super S> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object reduce$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function2 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <S, E extends S> Object reduceIndexed(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function3<? super Integer, ? super S, ? super E, ? extends S> arg1, @NotNull Continuation<? super S> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object reduceIndexed$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function3 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> requireNoNulls(@NotNull ReceiveChannel<? extends E> arg0) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object single(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super E> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object single(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object single$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object singleOrNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super E> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object singleOrNull(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Boolean> arg1, @NotNull Continuation<? super E> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object singleOrNull$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object sumBy(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Integer> arg1, @NotNull Continuation<? super Integer> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object sumBy$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object sumByDouble(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Function1<? super E, Double> arg1, @NotNull Continuation<? super Double> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  private static final Object sumByDouble$$forInline(@NotNull ReceiveChannel arg0, @NotNull Function1 arg1, @NotNull Continuation arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> take(@NotNull ReceiveChannel<? extends E> arg0, int arg1, @NotNull CoroutineContext arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<E> takeWhile(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends SendChannel<? super E>> Object toChannel(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Continuation<? super C> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E, C extends Collection<? super E>> Object toCollection(@NotNull ReceiveChannel<? extends E> arg0, @NotNull C arg1, @NotNull Continuation<? super C> arg2) {}
  
  @Nullable
  public static final <E> Object toList(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super List<? extends E>> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> arg0, @NotNull M arg1, @NotNull Continuation<? super M> arg2) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <K, V> Object toMap(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> arg0, @NotNull Continuation<? super Map<K, ? extends V>> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object toMutableList(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super List<E>> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object toMutableSet(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super Set<E>> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @Nullable
  public static final <E> Object toSet(@NotNull ReceiveChannel<? extends E> arg0, @NotNull Continuation<? super Set<? extends E>> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(@NotNull ReceiveChannel<? extends E> arg0, @NotNull CoroutineContext arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R> ReceiveChannel<Pair<E, R>> zip(@NotNull ReceiveChannel<? extends E> arg0, @NotNull ReceiveChannel<? extends R> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Channel operators are deprecated in favour of Flow and will be removed in 1.4")
  @NotNull
  public static final <E, R, V> ReceiveChannel<V> zip(@NotNull ReceiveChannel<? extends E> arg0, @NotNull ReceiveChannel<? extends R> arg1, @NotNull CoroutineContext arg2, @NotNull Function2<? super E, ? super R, ? extends V> arg3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt
 * JD-Core Version:    0.7.0.1
 */