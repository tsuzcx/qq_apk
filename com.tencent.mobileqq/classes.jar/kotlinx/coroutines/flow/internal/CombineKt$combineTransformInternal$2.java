package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2", f="Combine.kt", i={0, 0, 0, 0, 0, 0, 0}, l={143}, m="invokeSuspend", n={"$this$coroutineScope", "firstChannel", "secondChannel", "firstValue", "secondValue", "firstIsClosed", "secondIsClosed"}, s={"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
final class CombineKt$combineTransformInternal$2
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  Object L$7;
  int label;
  private CoroutineScope p$;
  
  CombineKt$combineTransformInternal$2(FlowCollector paramFlowCollector, Flow paramFlow1, Flow paramFlow2, Function4 paramFunction4, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 2(this.$this_combineTransformInternal, this.$first, this.$second, this.$transform, paramContinuation);
    paramContinuation.p$ = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((2)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject2;
    Object localObject6;
    Object localObject7;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    Object localObject8;
    Object localObject9;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject2 = (2)this.L$7;
        localObject2 = (Ref.BooleanRef)this.L$6;
        localObject6 = (Ref.BooleanRef)this.L$5;
        localObject7 = (Ref.ObjectRef)this.L$4;
        localObject5 = (Ref.ObjectRef)this.L$3;
        localObject4 = (ReceiveChannel)this.L$2;
        localObject3 = (ReceiveChannel)this.L$1;
        localObject8 = (CoroutineScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
        localObject1 = localObject2;
        localObject2 = this;
        localObject9 = localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject7 = this.p$;
      localObject2 = CombineKt.access$asFairChannel((CoroutineScope)localObject7, this.$first);
      localObject3 = CombineKt.access$asFairChannel((CoroutineScope)localObject7, this.$second);
      localObject4 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject4).element = null;
      localObject6 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject6).element = null;
      localObject5 = new Ref.BooleanRef();
      ((Ref.BooleanRef)localObject5).element = false;
      localObject8 = new Ref.BooleanRef();
      ((Ref.BooleanRef)localObject8).element = false;
      paramObject = localObject1;
      localObject1 = this;
    }
    for (;;)
    {
      if ((((Ref.BooleanRef)localObject5).element) && (((Ref.BooleanRef)localObject8).element)) {
        return Unit.INSTANCE;
      }
      ((2)localObject1).L$0 = localObject7;
      ((2)localObject1).L$1 = localObject2;
      ((2)localObject1).L$2 = localObject3;
      ((2)localObject1).L$3 = localObject4;
      ((2)localObject1).L$4 = localObject6;
      ((2)localObject1).L$5 = localObject5;
      ((2)localObject1).L$6 = localObject8;
      ((2)localObject1).L$7 = localObject1;
      ((2)localObject1).label = 1;
      Continuation localContinuation = (Continuation)localObject1;
      SelectBuilderImpl localSelectBuilderImpl = new SelectBuilderImpl(localContinuation);
      try
      {
        localObject9 = (SelectBuilder)localSelectBuilderImpl;
        boolean bool = ((Ref.BooleanRef)localObject5).element;
        try
        {
          Function2 localFunction2 = (Function2)new CombineKt.combineTransformInternal.2.invokeSuspend..inlined.select.lambda.1(null, (2)localObject1, (Ref.BooleanRef)localObject5, (ReceiveChannel)localObject2, (Ref.ObjectRef)localObject4, (Ref.ObjectRef)localObject6, (Ref.BooleanRef)localObject8, (ReceiveChannel)localObject3);
          if (!bool) {
            ((SelectBuilder)localObject9).invoke(((ReceiveChannel)localObject2).getOnReceiveOrNull(), (Function2)new CombineKt.combineTransformInternal.2.invokeSuspend..inlined.select.lambda.2(localFunction2, null, (2)localObject1, (Ref.BooleanRef)localObject5, (ReceiveChannel)localObject2, (Ref.ObjectRef)localObject4, (Ref.ObjectRef)localObject6, (Ref.BooleanRef)localObject8, (ReceiveChannel)localObject3));
          }
          bool = ((Ref.BooleanRef)localObject8).element;
          localFunction2 = (Function2)new CombineKt.combineTransformInternal.2.invokeSuspend..inlined.select.lambda.3(null, (2)localObject1, (Ref.BooleanRef)localObject5, (ReceiveChannel)localObject2, (Ref.ObjectRef)localObject4, (Ref.ObjectRef)localObject6, (Ref.BooleanRef)localObject8, (ReceiveChannel)localObject3);
          if (bool) {
            break label509;
          }
          ((SelectBuilder)localObject9).invoke(((ReceiveChannel)localObject3).getOnReceiveOrNull(), (Function2)new CombineKt.combineTransformInternal.2.invokeSuspend..inlined.select.lambda.4(localFunction2, null, (2)localObject1, (Ref.BooleanRef)localObject5, (ReceiveChannel)localObject2, (Ref.ObjectRef)localObject4, (Ref.ObjectRef)localObject6, (Ref.BooleanRef)localObject8, (ReceiveChannel)localObject3));
        }
        catch (Throwable localThrowable1) {}
        localSelectBuilderImpl.handleBuilderException(localThrowable2);
      }
      catch (Throwable localThrowable2) {}
      label509:
      Object localObject10 = localSelectBuilderImpl.getResult();
      if (localObject10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(localContinuation);
      }
      if (localObject10 == paramObject) {
        return paramObject;
      }
      localObject10 = localObject8;
      localObject8 = localObject7;
      localObject7 = localObject6;
      localObject6 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject5;
      localObject5 = localObject6;
      localObject6 = localObject7;
      localObject7 = localObject8;
      localObject8 = localObject10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.combineTransformInternal.2
 * JD-Core Version:    0.7.0.1
 */