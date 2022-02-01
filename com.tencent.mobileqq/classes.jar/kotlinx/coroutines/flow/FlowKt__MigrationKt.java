package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"noImpl", "", "noImpl$FlowKt__MigrationKt", "combineLatest", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "T3", "T4", "T5", "other", "other2", "other3", "other4", "transform", "Lkotlin/Function6;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "compose", "T", "transformer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "concatMap", "mapper", "concatWith", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "delayEach", "timeMillis", "", "delayFlow", "flatMap", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatten", "forEach", "", "action", "Lkotlin/ParameterName;", "name", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "merge", "observeOn", "context", "Lkotlin/coroutines/CoroutineContext;", "onErrorResume", "fallback", "onErrorResumeNext", "onErrorReturn", "predicate", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "publishOn", "scanFold", "initial", "operation", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "skip", "count", "", "startWith", "subscribe", "onEach", "onError", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "subscribeOn", "switchMap", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__MigrationKt
{
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="this.combine(other, transform)", imports={}))
  @NotNull
  public static final <T1, T2, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, transform)", imports={}))
  @NotNull
  public static final <T1, T2, T3, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> arg3) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, other3, transform)", imports={}))
  @NotNull
  public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @NotNull Flow<? extends T4> arg3, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> arg4) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, other3, transform)", imports={}))
  @NotNull
  public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @NotNull Flow<? extends T4> arg3, @NotNull Flow<? extends T5> arg4, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> arg5) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'compose' is 'let'", replaceWith=@ReplaceWith(expression="let(transformer)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> compose(@NotNull Flow<? extends T> arg0, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith=@ReplaceWith(expression="flatMapConcat(mapper)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> concatMap(@NotNull Flow<? extends T> arg0, @NotNull Function1<? super T, ? extends Flow<? extends R>> arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith=@ReplaceWith(expression="onCompletion { emit(value) }", imports={}))
  @NotNull
  public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> arg0, T arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith=@ReplaceWith(expression="onCompletion { emitAll(other) }", imports={}))
  @NotNull
  public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> arg0, @NotNull Flow<? extends T> arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Use 'onEach { delay(timeMillis) }'", replaceWith=@ReplaceWith(expression="onEach { delay(timeMillis) }", imports={}))
  @NotNull
  public static final <T> Flow<T> delayEach(@NotNull Flow<? extends T> arg0, long arg1) {}
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Use 'onStart { delay(timeMillis) }'", replaceWith=@ReplaceWith(expression="onStart { delay(timeMillis) }", imports={}))
  @NotNull
  public static final <T> Flow<T> delayFlow(@NotNull Flow<? extends T> arg0, long arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue is named flatMapConcat", replaceWith=@ReplaceWith(expression="flatMapConcat(mapper)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> flatMap(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'flatten' is 'flattenConcat'", replaceWith=@ReplaceWith(expression="flattenConcat()", imports={}))
  @NotNull
  public static final <T> Flow<T> flatten(@NotNull Flow<? extends Flow<? extends T>> arg0) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'forEach' is 'collect'", replaceWith=@ReplaceWith(expression="collect(block)", imports={}))
  public static final <T> void forEach(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'merge' is 'flattenConcat'", replaceWith=@ReplaceWith(expression="flattenConcat()", imports={}))
  @NotNull
  public static final <T> Flow<T> merge(@NotNull Flow<? extends Flow<? extends T>> arg0) {}
  
  private static final Void noImpl$FlowKt__MigrationKt() {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Collect flow in the desired context instead")
  @NotNull
  public static final <T> Flow<T> observeOn(@NotNull Flow<? extends T> arg0, @NotNull CoroutineContext arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emitAll(fallback) }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorResume(@NotNull Flow<? extends T> arg0, @NotNull Flow<? extends T> arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emitAll(fallback) }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorResumeNext(@NotNull Flow<? extends T> arg0, @NotNull Flow<? extends T> arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emit(fallback) }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> arg0, T arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith=@ReplaceWith(expression="catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> arg0, T arg1, @NotNull Function1<? super Throwable, Boolean> arg2) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Collect flow in the desired context instead")
  @NotNull
  public static final <T> Flow<T> publishOn(@NotNull Flow<? extends T> arg0, @NotNull CoroutineContext arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow has less verbose 'scan' shortcut", replaceWith=@ReplaceWith(expression="scan(initial, operation)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> scanFold(@NotNull Flow<? extends T> arg0, R arg1, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'skip' is 'drop'", replaceWith=@ReplaceWith(expression="drop(count)", imports={}))
  @NotNull
  public static final <T> Flow<T> skip(@NotNull Flow<? extends T> arg0, int arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith=@ReplaceWith(expression="onStart { emit(value) }", imports={}))
  @NotNull
  public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> arg0, T arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith=@ReplaceWith(expression="onStart { emitAll(other) }", imports={}))
  @NotNull
  public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> arg0, @NotNull Flow<? extends T> arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use launchIn with onEach, onCompletion and catch operators instead")
  public static final <T> void subscribe(@NotNull Flow<? extends T> arg0) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use launchIn with onEach, onCompletion and catch operators instead")
  public static final <T> void subscribe(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use launchIn with onEach, onCompletion and catch operators instead")
  public static final <T> void subscribe(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> arg1, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> arg2) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use flowOn instead")
  @NotNull
  public static final <T> Flow<T> subscribeOn(@NotNull Flow<? extends T> arg0, @NotNull CoroutineContext arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith=@ReplaceWith(expression="this.flatMapLatest(transform)", imports={}))
  @NotNull
  public static final <T, R> Flow<R> switchMap(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__MigrationKt
 * JD-Core Version:    0.7.0.1
 */