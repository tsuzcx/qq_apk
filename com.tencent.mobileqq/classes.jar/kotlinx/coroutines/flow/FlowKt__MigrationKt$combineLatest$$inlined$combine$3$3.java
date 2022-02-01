package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$unsafeFlow$3$lambda$2", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$combine$3$3"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__MigrationKt$combineLatest$$inlined$combine$3$3", f="Migration.kt", i={0, 0, 0, 0, 1, 1}, l={324, 325}, m="invokeSuspend", n={"$receiver", "it", "continuation", "args", "$receiver", "it"}, s={"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
public final class FlowKt__MigrationKt$combineLatest$$inlined$combine$3$3
  extends SuspendLambda
  implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  private FlowCollector p$;
  private Object[] p$0;
  
  public FlowKt__MigrationKt$combineLatest$$inlined$combine$3$3(Continuation paramContinuation, FlowKt__MigrationKt.combineLatest..inlined.combine.3 param3)
  {
    super(3, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super R> paramFlowCollector, @NotNull Object[] paramArrayOfObject, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 3(paramContinuation, this.this$0);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramArrayOfObject;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((3)create((FlowCollector)paramObject1, (Object[])paramObject2, (Continuation)paramObject3)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject1 = (Object[])this.L$1;
          localObject1 = (FlowCollector)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          break label273;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject1 = (FlowCollector)this.L$4;
      localObject2 = (Object[])this.L$3;
      localObject2 = (Continuation)this.L$2;
      localObject2 = (Object[])this.L$1;
      localObject3 = (FlowCollector)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject4 = paramObject;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      localObject2 = this.p$0;
      localObject1 = (Continuation)this;
      localObject3 = this.this$0.$transform$inlined$1;
      localObject4 = localObject2[0];
      Object localObject6 = localObject2[1];
      Object localObject7 = localObject2[2];
      Object localObject8 = localObject2[3];
      Object localObject9 = localObject2[4];
      this.L$0 = paramObject;
      this.L$1 = localObject2;
      this.L$2 = localObject1;
      this.L$3 = localObject2;
      this.L$4 = paramObject;
      this.label = 1;
      localObject4 = ((Function6)localObject3).invoke(localObject4, localObject6, localObject7, localObject8, localObject9, this);
      if (localObject4 == localObject5) {
        return localObject5;
      }
      localObject1 = paramObject;
      localObject3 = localObject1;
      localObject1 = paramObject;
    }
    this.L$0 = localObject3;
    this.L$1 = localObject2;
    this.label = 2;
    if (((FlowCollector)localObject1).emit(localObject4, this) == localObject5) {
      return localObject5;
    }
    label273:
    return Unit.INSTANCE;
  }
  
  @Nullable
  public final Object invokeSuspend$$forInline(@NotNull Object paramObject)
  {
    paramObject = this.p$;
    Object localObject1 = this.p$0;
    Object localObject2 = (Continuation)this;
    localObject2 = this.this$0.$transform$inlined$1;
    Object localObject3 = localObject1[0];
    Object localObject4 = localObject1[1];
    Object localObject5 = localObject1[2];
    Object localObject6 = localObject1[3];
    localObject1 = localObject1[4];
    InlineMarker.mark(0);
    localObject1 = ((Function6)localObject2).invoke(localObject3, localObject4, localObject5, localObject6, localObject1, this);
    InlineMarker.mark(1);
    InlineMarker.mark(0);
    paramObject.emit(localObject1, this);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__MigrationKt.combineLatest..inlined.combine.3.3
 * JD-Core Version:    0.7.0.1
 */