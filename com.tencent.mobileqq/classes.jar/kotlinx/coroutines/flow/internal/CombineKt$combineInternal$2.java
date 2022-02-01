package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.IntRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f="Combine.kt", i={0, 0, 0, 0, 0, 0, 0}, l={143}, m="invokeSuspend", n={"$this$coroutineScope", "size", "channels", "latestValues", "isClosed", "nonClosed", "remainingNulls"}, s={"L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class CombineKt$combineInternal$2
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  int I$0;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  int label;
  private CoroutineScope p$;
  
  CombineKt$combineInternal$2(FlowCollector paramFlowCollector, Flow[] paramArrayOfFlow, Function0 paramFunction0, Function3 paramFunction3, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, paramContinuation);
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
    Ref.IntRef localIntRef;
    Boolean[] arrayOfBoolean;
    Object[] arrayOfObject;
    ReceiveChannel[] arrayOfReceiveChannel;
    CoroutineScope localCoroutineScope;
    2 local2;
    int j;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject2 = (2)this.L$6;
        localObject2 = (Ref.IntRef)this.L$5;
        localIntRef = (Ref.IntRef)this.L$4;
        arrayOfBoolean = (Boolean[])this.L$3;
        arrayOfObject = (Object[])this.L$2;
        arrayOfReceiveChannel = (ReceiveChannel[])this.L$1;
        i = this.I$0;
        localCoroutineScope = (CoroutineScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
        local2 = this;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localCoroutineScope = this.p$;
      j = this.$flows.length;
      arrayOfReceiveChannel = new ReceiveChannel[j];
      i = 0;
      while (i < j)
      {
        int k = ((Number)Boxing.boxInt(i)).intValue();
        arrayOfReceiveChannel[i] = CombineKt.access$asFairChannel(localCoroutineScope, this.$flows[k]);
        i += 1;
      }
      arrayOfObject = new Object[j];
      arrayOfBoolean = new Boolean[j];
      i = 0;
      while (i < j)
      {
        ((Number)Boxing.boxInt(i)).intValue();
        arrayOfBoolean[i] = Boxing.boxBoolean(false);
        i += 1;
      }
      localIntRef = new Ref.IntRef();
      localIntRef.element = j;
      paramObject = new Ref.IntRef();
      paramObject.element = j;
      local2 = this;
      i = j;
    }
    while (localIntRef.element != 0)
    {
      local2.L$0 = localCoroutineScope;
      local2.I$0 = i;
      local2.L$1 = arrayOfReceiveChannel;
      local2.L$2 = arrayOfObject;
      local2.L$3 = arrayOfBoolean;
      local2.L$4 = localIntRef;
      local2.L$5 = paramObject;
      local2.L$6 = local2;
      local2.label = 1;
      localObject2 = (Continuation)local2;
      Object localObject3 = new SelectBuilderImpl((Continuation)localObject2);
      Object localObject8 = localObject3;
      Object localObject7 = localObject2;
      Object localObject6 = localObject1;
      Object localObject4 = paramObject;
      try
      {
        SelectBuilder localSelectBuilder = (SelectBuilder)localObject3;
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject8 = localObject3;
            localObject7 = localObject2;
            localObject6 = localObject1;
            localObject4 = paramObject;
            boolean bool = arrayOfBoolean[j].booleanValue();
            localObject4 = arrayOfReceiveChannel[j];
            try
            {
              localObject6 = (Function2)new CombineKt.combineInternal.2.invokeSuspend..inlined.select.lambda.1(j, null, local2, i, arrayOfBoolean, arrayOfReceiveChannel, arrayOfObject, paramObject, localIntRef);
              if (!bool) {
                localSelectBuilder.invoke(((ReceiveChannel)localObject4).getOnReceiveOrNull(), (Function2)new CombineKt.combineInternal.2.invokeSuspend..inlined.select.lambda.2((Function2)localObject6, null, j, local2, i, arrayOfBoolean, arrayOfReceiveChannel, arrayOfObject, paramObject, localIntRef));
              }
              j += 1;
            }
            catch (Throwable localThrowable1) {}
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject3 = localObject8;
        localObject2 = localObject7;
        localObject1 = localObject6;
        paramObject = localThrowable1;
        Object localObject5 = localThrowable2;
        ((SelectBuilderImpl)localObject3).handleBuilderException(localObject5);
      }
      localObject3 = ((SelectBuilderImpl)localObject3).getResult();
      if (localObject3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended((Continuation)localObject2);
      }
      if (localObject3 == localObject1) {
        return localObject1;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2
 * JD-Core Version:    0.7.0.1
 */