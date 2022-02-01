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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$mapIndexed$1", f="Channels.common.kt", i={0, 0, 1, 1, 1, 2, 2, 2}, l={1423, 1424, 1424}, m="invokeSuspend", n={"$this$produce", "index", "$this$produce", "index", "e", "$this$produce", "index", "e"}, s={"L$0", "I$0", "L$0", "I$0", "L$1", "L$0", "I$0", "L$1"})
final class ChannelsKt__Channels_commonKt$mapIndexed$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>
{
  int I$0;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$mapIndexed$1(ReceiveChannel paramReceiveChannel, Function3 paramFunction3, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_mapIndexed, this.$transform, paramContinuation);
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
    Object localObject6;
    Object localObject7;
    Object localObject8;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localObject4 = (ChannelIterator)this.L$2;
            localObject2 = this.L$1;
            i = this.I$0;
            localObject5 = (ProducerScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject3 = this;
            localObject2 = localObject1;
            localObject1 = localObject5;
            paramObject = localObject4;
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          localObject6 = (ProducerScope)this.L$3;
          localObject4 = (ChannelIterator)this.L$2;
          localObject7 = this.L$1;
          i = this.I$0;
          localObject5 = (ProducerScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject2 = this;
          localObject3 = localObject1;
          localObject8 = paramObject;
          break label386;
        }
      }
      else
      {
        localObject3 = (ChannelIterator)this.L$1;
        i = this.I$0;
        localObject2 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = this;
        localObject5 = paramObject;
        break label268;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject4 = this.p$;
      paramObject = this.$this_mapIndexed.iterator();
      i = 0;
      localObject3 = this;
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    for (;;)
    {
      ((1)localObject3).L$0 = localObject1;
      ((1)localObject3).I$0 = i;
      ((1)localObject3).L$1 = paramObject;
      ((1)localObject3).label = 1;
      localObject5 = paramObject.hasNext((Continuation)localObject3);
      if (localObject5 == localObject2) {
        return localObject2;
      }
      localObject4 = localObject2;
      localObject2 = localObject3;
      localObject3 = paramObject;
      label268:
      if (!((Boolean)localObject5).booleanValue()) {
        break;
      }
      paramObject = ((ChannelIterator)localObject3).next();
      localObject5 = ((1)localObject2).$transform;
      localObject6 = Boxing.boxInt(i);
      i += 1;
      ((1)localObject2).L$0 = localObject1;
      ((1)localObject2).I$0 = i;
      ((1)localObject2).L$1 = paramObject;
      ((1)localObject2).L$2 = localObject3;
      ((1)localObject2).L$3 = localObject1;
      ((1)localObject2).label = 2;
      localObject8 = ((Function3)localObject5).invoke(localObject6, paramObject, localObject2);
      if (localObject8 == localObject4) {
        return localObject4;
      }
      localObject5 = localObject1;
      localObject6 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject6;
      localObject7 = paramObject;
      localObject6 = localObject1;
      label386:
      ((1)localObject2).L$0 = localObject5;
      ((1)localObject2).I$0 = i;
      ((1)localObject2).L$1 = localObject7;
      ((1)localObject2).L$2 = localObject4;
      ((1)localObject2).label = 3;
      if (((ProducerScope)localObject6).send(localObject8, (Continuation)localObject2) == localObject3) {
        return localObject3;
      }
      localObject6 = localObject2;
      localObject1 = localObject5;
      paramObject = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject6;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.mapIndexed.1
 * JD-Core Version:    0.7.0.1
 */