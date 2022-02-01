package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1", f="Channels.common.kt", i={0, 0, 1, 1, 1}, l={1658, 1659}, m="invokeSuspend", n={"$this$produce", "index", "$this$produce", "index", "e"}, s={"L$0", "I$0", "L$0", "I$0", "L$1"})
final class ChannelsKt__Channels_commonKt$withIndex$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object>
{
  int I$0;
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$withIndex$1(ReceiveChannel paramReceiveChannel, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_withIndex, paramContinuation);
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
    Object localObject4;
    Object localObject2;
    Object localObject5;
    Object localObject3;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject4 = (ChannelIterator)this.L$2;
          localObject2 = this.L$1;
          i = this.I$0;
          localObject5 = (ProducerScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject3 = this;
          localObject2 = localObject1;
          paramObject = localObject5;
          localObject1 = localObject4;
        }
        else
        {
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
      }
      else
      {
        localObject3 = (ChannelIterator)this.L$1;
        i = this.I$0;
        localObject2 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject4 = this;
        break label226;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      i = 0;
      localObject4 = this.$this_withIndex.iterator();
      localObject3 = this;
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    for (;;)
    {
      ((1)localObject3).L$0 = paramObject;
      ((1)localObject3).I$0 = i;
      ((1)localObject3).L$1 = localObject1;
      ((1)localObject3).label = 1;
      localObject5 = localObject1.hasNext((Continuation)localObject3);
      if (localObject5 == localObject2) {
        return localObject2;
      }
      localObject4 = localObject3;
      localObject3 = localObject5;
      localObject5 = paramObject;
      Object localObject6 = localObject1;
      paramObject = localObject3;
      localObject1 = localObject2;
      localObject2 = localObject5;
      localObject3 = localObject6;
      label226:
      if (!((Boolean)paramObject).booleanValue()) {
        break;
      }
      paramObject = ((ChannelIterator)localObject3).next();
      int j = i + 1;
      localObject5 = new IndexedValue(i, paramObject);
      ((1)localObject4).L$0 = localObject2;
      ((1)localObject4).I$0 = j;
      ((1)localObject4).L$1 = paramObject;
      ((1)localObject4).L$2 = localObject3;
      ((1)localObject4).label = 2;
      if (((ProducerScope)localObject2).send(localObject5, (Continuation)localObject4) == localObject1) {
        return localObject1;
      }
      paramObject = localObject2;
      localObject2 = localObject1;
      i = j;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.withIndex.1
 * JD-Core Version:    0.7.0.1
 */