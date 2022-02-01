package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"RESUMED", "", "SUSPENDED", "UNDECIDED", "withContext", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "async", "Lkotlinx/coroutines/Deferred;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launch", "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/BuildersKt")
final class BuildersKt__Builders_commonKt
{
  private static final int RESUMED = 2;
  private static final int SUSPENDED = 1;
  private static final int UNDECIDED = 0;
  
  @NotNull
  public static final <T> Deferred<T> async(@NotNull CoroutineScope arg0, @NotNull CoroutineContext arg1, @NotNull CoroutineStart arg2, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> arg3) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object invoke(@NotNull CoroutineDispatcher arg0, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> arg1, @NotNull Continuation<? super T> arg2) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object invoke$$forInline(@NotNull CoroutineDispatcher arg0, @NotNull Function2 arg1, @NotNull Continuation arg2) {}
  
  @NotNull
  public static final Job launch(@NotNull CoroutineScope arg0, @NotNull CoroutineContext arg1, @NotNull CoroutineStart arg2, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> arg3) {}
  
  @Nullable
  public static final <T> Object withContext(@NotNull CoroutineContext arg0, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> arg1, @NotNull Continuation<? super T> arg2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.BuildersKt__Builders_commonKt
 * JD-Core Version:    0.7.0.1
 */