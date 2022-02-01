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
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1", f="Channels.common.kt", i={0, 0, 1, 1, 2, 2, 2}, l={700, 705, 706}, m="invokeSuspend", n={"$this$produce", "remaining", "$this$produce", "remaining", "$this$produce", "remaining", "e"}, s={"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$1"})
final class ChannelsKt__Channels_commonKt$drop$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>
{
  int I$0;
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel paramReceiveChannel, int paramInt, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_drop, this.$n, paramContinuation);
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
    Object localObject2;
    Object localObject3;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i == 3)
          {
            localObject2 = (ChannelIterator)this.L$2;
            localObject3 = this.L$1;
            i = this.I$0;
            localObject3 = (ProducerScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            paramObject = this;
          }
        }
      }
    }
    for (;;)
    {
      break label364;
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      Object localObject4 = (ChannelIterator)this.L$1;
      i = this.I$0;
      localObject3 = (ProducerScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this;
      Object localObject5 = paramObject;
      break label413;
      ChannelIterator localChannelIterator = (ChannelIterator)this.L$1;
      int j = this.I$0;
      localObject4 = (ProducerScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject3 = this;
      localObject2 = localObject1;
      localObject1 = localObject4;
      Object localObject6 = paramObject;
      break label266;
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      if (this.$n >= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        break label496;
      }
      i = this.$n;
      if (i > 0)
      {
        localChannelIterator = this.$this_drop.iterator();
        localObject2 = this;
        j = i;
        for (;;)
        {
          ((1)localObject2).L$0 = paramObject;
          ((1)localObject2).I$0 = j;
          ((1)localObject2).L$1 = localChannelIterator;
          ((1)localObject2).label = 1;
          localObject6 = localChannelIterator.hasNext((Continuation)localObject2);
          if (localObject6 == localObject1) {
            return localObject1;
          }
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = paramObject;
          label266:
          paramObject = localObject3;
          i = j;
          localObject4 = localObject2;
          localObject5 = localObject1;
          if (!((Boolean)localObject6).booleanValue()) {
            break;
          }
          localChannelIterator.next();
          i = j - 1;
          if (i == 0)
          {
            paramObject = localObject3;
            localObject4 = localObject2;
            localObject5 = localObject1;
            break;
          }
          paramObject = localObject1;
          localObject1 = localObject2;
          j = i;
          localObject2 = localObject3;
        }
      }
      localObject5 = paramObject;
      paramObject = this;
      localObject4 = localObject1;
      localObject2 = paramObject.$this_drop.iterator();
      localObject3 = localObject5;
      localObject1 = localObject4;
      label364:
      paramObject.L$0 = localObject3;
      paramObject.I$0 = i;
      paramObject.L$1 = localObject2;
      paramObject.label = 2;
      localObject5 = ((ChannelIterator)localObject2).hasNext(paramObject);
      if (localObject5 == localObject1) {
        return localObject1;
      }
      localObject4 = localObject2;
      localObject2 = paramObject;
      label413:
      if (!((Boolean)localObject5).booleanValue()) {
        break;
      }
      paramObject = ((ChannelIterator)localObject4).next();
      ((1)localObject2).L$0 = localObject3;
      ((1)localObject2).I$0 = i;
      ((1)localObject2).L$1 = paramObject;
      ((1)localObject2).L$2 = localObject4;
      ((1)localObject2).label = 3;
      if (((ProducerScope)localObject3).send(paramObject, (Continuation)localObject2) == localObject1) {
        return localObject1;
      }
      paramObject = localObject2;
      localObject2 = localObject4;
    }
    return Unit.INSTANCE;
    label496:
    paramObject = new StringBuilder();
    paramObject.append("Requested element count ");
    paramObject.append(this.$n);
    paramObject.append(" is less than zero.");
    paramObject = (Throwable)new IllegalArgumentException(paramObject.toString().toString());
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.drop.1
 * JD-Core Version:    0.7.0.1
 */