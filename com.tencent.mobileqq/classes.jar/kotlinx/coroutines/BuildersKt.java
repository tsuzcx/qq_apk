package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k=4, mv={1, 1, 16})
public final class BuildersKt
{
  @NotNull
  public static final <T> Deferred<T> async(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext, @NotNull CoroutineStart paramCoroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2)
  {
    return BuildersKt__Builders_commonKt.async(paramCoroutineScope, paramCoroutineContext, paramCoroutineStart, paramFunction2);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object invoke(@NotNull CoroutineDispatcher paramCoroutineDispatcher, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2, @NotNull Continuation<? super T> paramContinuation)
  {
    return BuildersKt__Builders_commonKt.invoke(paramCoroutineDispatcher, paramFunction2, paramContinuation);
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object invoke$$forInline(@NotNull CoroutineDispatcher paramCoroutineDispatcher, @NotNull Function2 paramFunction2, @NotNull Continuation paramContinuation)
  {
    return BuildersKt__Builders_commonKt.invoke(paramCoroutineDispatcher, paramFunction2, paramContinuation);
  }
  
  @NotNull
  public static final Job launch(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext, @NotNull CoroutineStart paramCoroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return BuildersKt__Builders_commonKt.launch(paramCoroutineScope, paramCoroutineContext, paramCoroutineStart, paramFunction2);
  }
  
  public static final <T> T runBlocking(@NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2)
  {
    return BuildersKt__BuildersKt.runBlocking(paramCoroutineContext, paramFunction2);
  }
  
  @Nullable
  public static final <T> Object withContext(@NotNull CoroutineContext paramCoroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2, @NotNull Continuation<? super T> paramContinuation)
  {
    return BuildersKt__Builders_commonKt.withContext(paramCoroutineContext, paramFunction2, paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.BuildersKt
 * JD-Core Version:    0.7.0.1
 */