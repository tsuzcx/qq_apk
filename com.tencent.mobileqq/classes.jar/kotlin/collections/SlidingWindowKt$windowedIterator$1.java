package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlin.collections.SlidingWindowKt$windowedIterator$1", f="SlidingWindow.kt", i={0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l={34, 40, 49, 55, 58}, m="invokeSuspend", n={"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, s={"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
final class SlidingWindowKt$windowedIterator$1
  extends RestrictedSuspendLambda
  implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object>
{
  int I$0;
  int I$1;
  int I$2;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  private SequenceScope p$;
  
  SlidingWindowKt$windowedIterator$1(int paramInt1, int paramInt2, Iterator paramIterator, boolean paramBoolean1, boolean paramBoolean2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, paramContinuation);
    paramContinuation.p$ = ((SequenceScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    Object localObject2;
    int j;
    Object localObject4;
    Object localObject6;
    Object localObject7;
    Object localObject5;
    Object localObject8;
    int m;
    int k;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5) {
                localObject1 = (RingBuffer)this.L$1;
              } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              }
            }
            else
            {
              localObject2 = (RingBuffer)this.L$1;
              j = this.I$1;
              i = this.I$0;
              localObject4 = (SequenceScope)this.L$0;
              ResultKt.throwOnFailure(paramObject);
              localObject6 = this;
              break label943;
            }
          }
          else
          {
            localObject4 = (Iterator)this.L$3;
            localObject1 = this.L$2;
            localObject1 = (RingBuffer)this.L$1;
            j = this.I$1;
            i = this.I$0;
            localObject6 = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject7 = this;
            paramObject = localObject1;
            break label803;
          }
        }
        else
        {
          i = this.I$2;
          localObject1 = (ArrayList)this.L$1;
        }
        i = this.I$1;
        i = this.I$0;
        localObject1 = (SequenceScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        break label1025;
      }
      localObject1 = (Iterator)this.L$3;
      localObject2 = this.L$2;
      i = this.I$2;
      localObject2 = (ArrayList)this.L$1;
      i = this.I$1;
      j = this.I$0;
      localObject5 = (SequenceScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject8 = this;
      localObject7 = localObject3;
      localObject3 = localObject1;
      localObject1 = localObject2;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject6 = this.p$;
      i = RangesKt.coerceAtMost(this.$size, 1024);
      j = this.$step - this.$size;
      if (j < 0) {
        break label616;
      }
      paramObject = new ArrayList(i);
      m = 0;
      localObject1 = this.$iterator;
      localObject4 = localObject3;
      k = j;
      localObject2 = this;
      localObject3 = localObject1;
      j = i;
      i = m;
    }
    while (localObject3.hasNext())
    {
      localObject1 = localObject3.next();
      if (i > 0)
      {
        i -= 1;
      }
      else
      {
        paramObject.add(localObject1);
        if (paramObject.size() == ((1)localObject2).$size)
        {
          ((1)localObject2).L$0 = localObject6;
          ((1)localObject2).I$0 = j;
          ((1)localObject2).I$1 = k;
          ((1)localObject2).L$1 = paramObject;
          ((1)localObject2).I$2 = i;
          ((1)localObject2).L$2 = localObject1;
          ((1)localObject2).L$3 = localObject3;
          ((1)localObject2).label = 1;
          i = k;
          localObject1 = paramObject;
          localObject5 = localObject6;
          localObject7 = localObject4;
          localObject8 = localObject2;
          if (((SequenceScope)localObject6).yield(paramObject, (Continuation)localObject2) == localObject4) {
            return localObject4;
          }
          if (((1)localObject8).$reuseBuffer)
          {
            ((ArrayList)localObject1).clear();
            paramObject = localObject1;
          }
          else
          {
            paramObject = new ArrayList(((1)localObject8).$size);
          }
          m = i;
          k = i;
          i = m;
          localObject6 = localObject5;
          localObject4 = localObject7;
          localObject2 = localObject8;
        }
      }
    }
    if (((((Collection)paramObject).isEmpty() ^ true)) && ((((1)localObject2).$partialWindows) || (paramObject.size() == ((1)localObject2).$size)))
    {
      ((1)localObject2).L$0 = localObject6;
      ((1)localObject2).I$0 = j;
      ((1)localObject2).I$1 = k;
      ((1)localObject2).L$1 = paramObject;
      ((1)localObject2).I$2 = i;
      ((1)localObject2).label = 2;
      if (((SequenceScope)localObject6).yield(paramObject, (Continuation)localObject2) == localObject4)
      {
        return localObject4;
        label616:
        paramObject = new RingBuffer(i);
        localObject4 = this.$iterator;
        localObject2 = localObject6;
        localObject1 = this;
        while (((Iterator)localObject4).hasNext())
        {
          localObject6 = ((Iterator)localObject4).next();
          paramObject.add(localObject6);
          if (paramObject.isFull())
          {
            k = paramObject.size();
            m = ((1)localObject1).$size;
            if (k < m)
            {
              paramObject = paramObject.expanded(m);
            }
            else
            {
              if (((1)localObject1).$reuseBuffer) {
                localObject5 = (List)paramObject;
              } else {
                localObject5 = (List)new ArrayList((Collection)paramObject);
              }
              ((1)localObject1).L$0 = localObject2;
              ((1)localObject1).I$0 = i;
              ((1)localObject1).I$1 = j;
              ((1)localObject1).L$1 = paramObject;
              ((1)localObject1).L$2 = localObject6;
              ((1)localObject1).L$3 = localObject4;
              ((1)localObject1).label = 3;
              localObject6 = localObject2;
              localObject7 = localObject1;
              if (((SequenceScope)localObject2).yield(localObject5, (Continuation)localObject1) == localObject3) {
                return localObject3;
              }
              label803:
              paramObject.removeFirst(((1)localObject7).$step);
              localObject2 = localObject6;
              localObject1 = localObject7;
            }
          }
        }
        if (((1)localObject1).$partialWindows)
        {
          localObject4 = paramObject;
          paramObject = localObject2;
          localObject2 = localObject4;
          while (((RingBuffer)localObject2).size() > ((1)localObject1).$step)
          {
            if (((1)localObject1).$reuseBuffer) {
              localObject5 = (List)localObject2;
            } else {
              localObject5 = (List)new ArrayList((Collection)localObject2);
            }
            ((1)localObject1).L$0 = paramObject;
            ((1)localObject1).I$0 = i;
            ((1)localObject1).I$1 = j;
            ((1)localObject1).L$1 = localObject2;
            ((1)localObject1).label = 4;
            localObject4 = paramObject;
            localObject6 = localObject1;
            if (paramObject.yield(localObject5, (Continuation)localObject1) == localObject3) {
              return localObject3;
            }
            label943:
            ((RingBuffer)localObject2).removeFirst(((1)localObject6).$step);
            paramObject = localObject4;
            localObject1 = localObject6;
          }
          if ((((Collection)localObject2).isEmpty() ^ true))
          {
            ((1)localObject1).L$0 = paramObject;
            ((1)localObject1).I$0 = i;
            ((1)localObject1).I$1 = j;
            ((1)localObject1).L$1 = localObject2;
            ((1)localObject1).label = 5;
            if (paramObject.yield(localObject2, (Continuation)localObject1) == localObject3) {
              return localObject3;
            }
          }
        }
      }
    }
    label1025:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.SlidingWindowKt.windowedIterator.1
 * JD-Core Version:    0.7.0.1
 */