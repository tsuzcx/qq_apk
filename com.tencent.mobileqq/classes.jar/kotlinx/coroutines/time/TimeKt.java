package kotlinx.coroutines.time;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"delay", "", "duration", "Ljava/time/Duration;", "(Ljava/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/time/Duration;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "onTimeout", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/Function1;", "(Lkotlinx/coroutines/selects/SelectBuilder;Ljava/time/Duration;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-jdk8"}, k=2, mv={1, 1, 13})
public final class TimeKt
{
  @Nullable
  public static final Object delay(@NotNull Duration paramDuration, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return DelayKt.delay(paramDuration.toMillis(), paramContinuation);
  }
  
  public static final <R> void onTimeout(@NotNull SelectBuilder<? super R> paramSelectBuilder, @NotNull Duration paramDuration, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSelectBuilder, "receiver$0");
    Intrinsics.checkParameterIsNotNull(paramDuration, "duration");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    paramSelectBuilder.onTimeout(paramDuration.toMillis(), paramFunction1);
  }
  
  @Nullable
  public static final <T> Object withTimeout(@NotNull Duration paramDuration, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2, @NotNull Continuation<? super T> paramContinuation)
  {
    return TimeoutKt.withTimeout(paramDuration.toMillis(), paramFunction2, paramContinuation);
  }
  
  @Nullable
  public static final <T> Object withTimeoutOrNull(@NotNull Duration paramDuration, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> paramFunction2, @NotNull Continuation<? super T> paramContinuation)
  {
    return TimeoutKt.withTimeoutOrNull(paramDuration.toMillis(), paramFunction2, paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.time.TimeKt
 * JD-Core Version:    0.7.0.1
 */