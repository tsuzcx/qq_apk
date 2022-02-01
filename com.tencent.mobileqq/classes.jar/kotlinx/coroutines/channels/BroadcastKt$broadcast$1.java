package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.BroadcastKt$broadcast$1", f="Broadcast.kt", i={0, 1, 1}, l={30, 31}, m="invokeSuspend", n={"$this$broadcast", "$this$broadcast", "e"}, s={"L$0", "L$0", "L$1"})
final class BroadcastKt$broadcast$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  BroadcastKt$broadcast$1(ReceiveChannel paramReceiveChannel, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_broadcast, paramContinuation);
    paramContinuation.p$ = ((ProducerScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject3;
    Object localObject4;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject3 = (ChannelIterator)this.L$2;
          localObject2 = this.L$1;
          localObject4 = (ProducerScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject2 = this;
          paramObject = localObject4;
        }
        else
        {
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
      }
      else
      {
        localObject4 = (ChannelIterator)this.L$1;
        localObject2 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject3 = this;
        break label185;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      localObject3 = this.$this_broadcast.iterator();
    }
    Object localObject5;
    for (Object localObject2 = this;; localObject2 = localObject5)
    {
      ((1)localObject2).L$0 = paramObject;
      ((1)localObject2).L$1 = localObject3;
      ((1)localObject2).label = 1;
      localObject4 = ((ChannelIterator)localObject3).hasNext((Continuation)localObject2);
      if (localObject4 == localObject1) {
        return localObject1;
      }
      localObject5 = localObject2;
      localObject2 = localObject4;
      localObject4 = paramObject;
      paramObject = localObject2;
      localObject2 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject5;
      label185:
      if (!((Boolean)paramObject).booleanValue()) {
        break;
      }
      paramObject = ((ChannelIterator)localObject4).next();
      ((1)localObject3).L$0 = localObject2;
      ((1)localObject3).L$1 = paramObject;
      ((1)localObject3).L$2 = localObject4;
      ((1)localObject3).label = 2;
      if (((ProducerScope)localObject2).send(paramObject, (Continuation)localObject3) == localObject1) {
        return localObject1;
      }
      localObject5 = localObject3;
      paramObject = localObject2;
      localObject3 = localObject4;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.BroadcastKt.broadcast.1
 * JD-Core Version:    0.7.0.1
 */