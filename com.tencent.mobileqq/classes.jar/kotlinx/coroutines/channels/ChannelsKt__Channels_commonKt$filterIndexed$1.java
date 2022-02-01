package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterIndexed$1", f="Channels.common.kt", i={0, 0, 1, 1, 1, 2, 2, 2}, l={774, 775, 775}, m="invokeSuspend", n={"$this$produce", "index", "$this$produce", "index", "e", "$this$produce", "index", "e"}, s={"L$0", "I$0", "L$0", "I$0", "L$1", "L$0", "I$0", "L$1"})
final class ChannelsKt__Channels_commonKt$filterIndexed$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>
{
  int I$0;
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$filterIndexed$1(ReceiveChannel paramReceiveChannel, Function3 paramFunction3, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_filterIndexed, this.$predicate, paramContinuation);
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
    ChannelIterator localChannelIterator;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localChannelIterator = (ChannelIterator)this.L$2;
            localObject2 = this.L$1;
            i = this.I$0;
            localObject2 = (ProducerScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          localChannelIterator = (ChannelIterator)this.L$2;
          localObject4 = this.L$1;
          i = this.I$0;
          localObject2 = (ProducerScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject3 = localObject1;
          localObject1 = this;
          break label307;
        }
      }
      else
      {
        localChannelIterator = (ChannelIterator)this.L$1;
        i = this.I$0;
        localObject2 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject3 = localObject1;
        localObject1 = this;
        localObject4 = paramObject;
        break label223;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.p$;
      localChannelIterator = this.$this_filterIndexed.iterator();
      i = 0;
    }
    paramObject = this;
    for (;;)
    {
      paramObject.L$0 = localObject2;
      paramObject.I$0 = i;
      paramObject.L$1 = localChannelIterator;
      paramObject.label = 1;
      localObject4 = localChannelIterator.hasNext(paramObject);
      if (localObject4 == localObject1) {
        return localObject1;
      }
      localObject3 = localObject1;
      localObject1 = paramObject;
      label223:
      if (!((Boolean)localObject4).booleanValue()) {
        break;
      }
      localObject4 = localChannelIterator.next();
      paramObject = ((1)localObject1).$predicate;
      Integer localInteger = Boxing.boxInt(i);
      i += 1;
      ((1)localObject1).L$0 = localObject2;
      ((1)localObject1).I$0 = i;
      ((1)localObject1).L$1 = localObject4;
      ((1)localObject1).L$2 = localChannelIterator;
      ((1)localObject1).label = 2;
      paramObject = paramObject.invoke(localInteger, localObject4, localObject1);
      if (paramObject == localObject3) {
        return localObject3;
      }
      label307:
      if (((Boolean)paramObject).booleanValue())
      {
        ((1)localObject1).L$0 = localObject2;
        ((1)localObject1).I$0 = i;
        ((1)localObject1).L$1 = localObject4;
        ((1)localObject1).L$2 = localChannelIterator;
        ((1)localObject1).label = 3;
        if (((ProducerScope)localObject2).send(localObject4, (Continuation)localObject1) == localObject3) {
          return localObject3;
        }
      }
      paramObject = localObject1;
      localObject1 = localObject3;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.filterIndexed.1
 * JD-Core Version:    0.7.0.1
 */