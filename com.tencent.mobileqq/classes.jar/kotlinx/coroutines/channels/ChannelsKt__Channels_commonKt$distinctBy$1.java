package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.HashSet;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinctBy$1", f="Channels.common.kt", i={0, 0, 1, 1, 1, 2, 2, 2, 2}, l={1700, 1701, 1703}, m="invokeSuspend", n={"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "e", "k"}, s={"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4"})
final class ChannelsKt__Channels_commonKt$distinctBy$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$distinctBy$1(ReceiveChannel paramReceiveChannel, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_distinctBy, this.$selector, paramContinuation);
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
    Object localObject6;
    Object localObject4;
    Object localObject2;
    Object localObject3;
    Object localObject8;
    Object localObject5;
    Object localObject7;
    Object localObject11;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localObject6 = this.L$4;
            localObject4 = (ChannelIterator)this.L$3;
            localObject2 = this.L$2;
            localObject3 = (HashSet)this.L$1;
            localObject8 = (ProducerScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject5 = this;
            localObject7 = localObject1;
            break label448;
          }
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        localObject4 = (ChannelIterator)this.L$3;
        localObject11 = this.L$2;
        localObject3 = (HashSet)this.L$1;
        localObject2 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject6 = paramObject;
        paramObject = this;
        break label359;
      }
      localObject2 = (ChannelIterator)this.L$2;
      localObject3 = (HashSet)this.L$1;
      localObject4 = (ProducerScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject5 = this;
      localObject6 = paramObject;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject3 = this.p$;
      localObject2 = new HashSet();
      paramObject = this.$this_distinctBy.iterator();
      localObject4 = this;
    }
    for (;;)
    {
      ((1)localObject4).L$0 = localObject3;
      ((1)localObject4).L$1 = localObject2;
      ((1)localObject4).L$2 = paramObject;
      ((1)localObject4).label = 1;
      localObject6 = paramObject.hasNext((Continuation)localObject4);
      if (localObject6 == localObject1) {
        return localObject1;
      }
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = paramObject;
      if (!((Boolean)localObject6).booleanValue()) {
        break;
      }
      localObject11 = ((ChannelIterator)localObject2).next();
      paramObject = ((1)localObject5).$selector;
      ((1)localObject5).L$0 = localObject4;
      ((1)localObject5).L$1 = localObject3;
      ((1)localObject5).L$2 = localObject11;
      ((1)localObject5).L$3 = localObject2;
      ((1)localObject5).label = 2;
      localObject6 = paramObject.invoke(localObject11, localObject5);
      if (localObject6 == localObject1) {
        return localObject1;
      }
      paramObject = localObject4;
      localObject4 = localObject2;
      localObject2 = paramObject;
      paramObject = localObject5;
      label359:
      localObject5 = paramObject;
      Object localObject10 = localObject4;
      Object localObject9 = localObject3;
      localObject7 = localObject1;
      localObject8 = localObject2;
      if (!((HashSet)localObject3).contains(localObject6))
      {
        paramObject.L$0 = localObject2;
        paramObject.L$1 = localObject3;
        paramObject.L$2 = localObject11;
        paramObject.L$3 = localObject4;
        paramObject.L$4 = localObject6;
        paramObject.label = 3;
        localObject5 = paramObject;
        localObject7 = localObject1;
        localObject8 = localObject2;
        if (((ProducerScope)localObject2).send(localObject11, paramObject) == localObject1) {
          return localObject1;
        }
        label448:
        ((Collection)localObject3).add(localObject6);
        localObject9 = localObject3;
        localObject10 = localObject4;
      }
      paramObject = localObject10;
      localObject2 = localObject9;
      localObject3 = localObject8;
      localObject4 = localObject5;
      localObject1 = localObject7;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.distinctBy.1
 * JD-Core Version:    0.7.0.1
 */