package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-Lkotlin.Unit;>;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class WhileSelectKt
{
  @ExperimentalCoroutinesApi
  @Nullable
  public static final Object whileSelect(@NotNull Function1<? super SelectBuilder<? super Boolean>, Unit> paramFunction1, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if ((paramContinuation instanceof WhileSelectKt.whileSelect.1))
    {
      localObject1 = (WhileSelectKt.whileSelect.1)paramContinuation;
      if ((((WhileSelectKt.whileSelect.1)localObject1).label & 0x80000000) != 0)
      {
        ((WhileSelectKt.whileSelect.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super Unit>)localObject1;
        break label47;
      }
    }
    paramContinuation = new WhileSelectKt.whileSelect.1(paramContinuation);
    label47:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramFunction1 = (Function1)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        break label171;
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
    label171:
    while (((Boolean)localObject1).booleanValue())
    {
      paramContinuation.L$0 = paramFunction1;
      paramContinuation.label = 1;
      Continuation localContinuation = (Continuation)paramContinuation;
      localObject1 = new SelectBuilderImpl(localContinuation);
      try
      {
        paramFunction1.invoke(localObject1);
      }
      catch (Throwable localThrowable)
      {
        ((SelectBuilderImpl)localObject1).handleBuilderException(localThrowable);
      }
      localObject1 = ((SelectBuilderImpl)localObject1).getResult();
      if (localObject1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(localContinuation);
      }
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    return Unit.INSTANCE;
  }
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object whileSelect$$forInline(@NotNull Function1 paramFunction1, @NotNull Continuation paramContinuation)
  {
    Object localObject;
    do
    {
      InlineMarker.mark(0);
      localObject = new SelectBuilderImpl(paramContinuation);
      try
      {
        paramFunction1.invoke(localObject);
      }
      catch (Throwable localThrowable)
      {
        ((SelectBuilderImpl)localObject).handleBuilderException(localThrowable);
      }
      localObject = ((SelectBuilderImpl)localObject).getResult();
      if (localObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(paramContinuation);
      }
      InlineMarker.mark(1);
    } while (((Boolean)localObject).booleanValue());
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.WhileSelectKt
 * JD-Core Version:    0.7.0.1
 */