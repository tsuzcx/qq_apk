package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"selectUnbiased", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class SelectUnbiasedKt
{
  @Nullable
  public static final <R> Object selectUnbiased(@NotNull Function1<? super SelectBuilder<? super R>, Unit> paramFunction1, @NotNull Continuation<? super R> paramContinuation)
  {
    UnbiasedSelectBuilderImpl localUnbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(paramContinuation);
    try
    {
      paramFunction1.invoke(localUnbiasedSelectBuilderImpl);
    }
    catch (Throwable paramFunction1)
    {
      localUnbiasedSelectBuilderImpl.handleBuilderException(paramFunction1);
    }
    paramFunction1 = localUnbiasedSelectBuilderImpl.initSelectResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramFunction1;
  }
  
  @Nullable
  private static final Object selectUnbiased$$forInline(@NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    UnbiasedSelectBuilderImpl localUnbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(paramContinuation);
    try
    {
      paramFunction1.invoke(localUnbiasedSelectBuilderImpl);
    }
    catch (Throwable paramFunction1)
    {
      localUnbiasedSelectBuilderImpl.handleBuilderException(paramFunction1);
    }
    paramFunction1 = localUnbiasedSelectBuilderImpl.initSelectResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    InlineMarker.mark(1);
    return paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectUnbiasedKt
 * JD-Core Version:    0.7.0.1
 */