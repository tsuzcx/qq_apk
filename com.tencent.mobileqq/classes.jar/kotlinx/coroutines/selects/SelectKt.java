package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ALREADY_SELECTED", "", "ALREADY_SELECTED$annotations", "()V", "getALREADY_SELECTED", "()Ljava/lang/Object;", "RESUMED", "RESUMED$annotations", "UNDECIDED", "UNDECIDED$annotations", "selectOpSequenceNumber", "Lkotlinx/coroutines/selects/SeqNumber;", "selectOpSequenceNumber$annotations", "select", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class SelectKt
{
  @NotNull
  private static final Object ALREADY_SELECTED = new Symbol("ALREADY_SELECTED");
  private static final Object RESUMED = new Symbol("RESUMED");
  private static final Object UNDECIDED = new Symbol("UNDECIDED");
  private static final SeqNumber selectOpSequenceNumber = new SeqNumber();
  
  @NotNull
  public static final Object getALREADY_SELECTED()
  {
    return ALREADY_SELECTED;
  }
  
  @Nullable
  public static final <R> Object select(@NotNull Function1<? super SelectBuilder<? super R>, Unit> paramFunction1, @NotNull Continuation<? super R> paramContinuation)
  {
    SelectBuilderImpl localSelectBuilderImpl = new SelectBuilderImpl(paramContinuation);
    try
    {
      paramFunction1.invoke(localSelectBuilderImpl);
    }
    catch (Throwable paramFunction1)
    {
      localSelectBuilderImpl.handleBuilderException(paramFunction1);
    }
    paramFunction1 = localSelectBuilderImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramFunction1;
  }
  
  @Nullable
  private static final Object select$$forInline(@NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    SelectBuilderImpl localSelectBuilderImpl = new SelectBuilderImpl(paramContinuation);
    try
    {
      paramFunction1.invoke(localSelectBuilderImpl);
    }
    catch (Throwable paramFunction1)
    {
      localSelectBuilderImpl.handleBuilderException(paramFunction1);
    }
    paramFunction1 = localSelectBuilderImpl.getResult();
    if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    InlineMarker.mark(1);
    return paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectKt
 * JD-Core Version:    0.7.0.1
 */