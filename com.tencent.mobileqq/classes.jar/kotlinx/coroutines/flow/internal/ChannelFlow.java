package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity", "()I", "additionalToStringProps", "", "broadcastImpl", "Lkotlinx/coroutines/channels/BroadcastChannel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "toString", "update", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public abstract class ChannelFlow<T>
  implements Flow<T>
{
  @JvmField
  public final int capacity;
  @JvmField
  @NotNull
  public final CoroutineContext context;
  
  public ChannelFlow(@NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    this.context = paramCoroutineContext;
    this.capacity = paramInt;
  }
  
  private final int getProduceCapacity()
  {
    int j = this.capacity;
    int i = j;
    if (j == -3) {
      i = -2;
    }
    return i;
  }
  
  @NotNull
  public String additionalToStringProps()
  {
    return "";
  }
  
  @NotNull
  public BroadcastChannel<T> broadcastImpl(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineStart paramCoroutineStart)
  {
    return BroadcastKt.broadcast$default(paramCoroutineScope, this.context, getProduceCapacity(), paramCoroutineStart, null, getCollectToFun$kotlinx_coroutines_core(), 8, null);
  }
  
  @Nullable
  public Object collect(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return collect$suspendImpl(this, paramFlowCollector, paramContinuation);
  }
  
  @Nullable
  protected abstract Object collectTo(@NotNull ProducerScope<? super T> paramProducerScope, @NotNull Continuation<? super Unit> paramContinuation);
  
  @NotNull
  protected abstract ChannelFlow<T> create(@NotNull CoroutineContext paramCoroutineContext, int paramInt);
  
  @NotNull
  public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> getCollectToFun$kotlinx_coroutines_core()
  {
    return (Function2)new ChannelFlow.collectToFun.1(this, null);
  }
  
  @NotNull
  public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope paramCoroutineScope)
  {
    return ProduceKt.produce$default(paramCoroutineScope, this.context, getProduceCapacity(), CoroutineStart.ATOMIC, null, getCollectToFun$kotlinx_coroutines_core(), 8, null);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DebugStringsKt.getClassSimpleName(this));
    localStringBuilder.append('[');
    localStringBuilder.append(additionalToStringProps());
    localStringBuilder.append("context=");
    localStringBuilder.append(this.context);
    localStringBuilder.append(", capacity=");
    localStringBuilder.append(this.capacity);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final ChannelFlow<T> update(@NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    paramCoroutineContext = paramCoroutineContext.plus(this.context);
    int i = this.capacity;
    if (i != -3)
    {
      if (paramInt == -3) {}
      do
      {
        paramInt = i;
        break;
        if (i == -2) {
          break;
        }
      } while (paramInt == -2);
      if (i == -1) {}
      while (paramInt == -1)
      {
        paramInt = -1;
        break;
      }
      boolean bool = DebugKt.getASSERTIONS_ENABLED();
      int j = 1;
      if (bool)
      {
        if (this.capacity >= 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        if (paramInt >= 0) {
          i = j;
        } else {
          i = 0;
        }
        if (i == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      paramInt += this.capacity;
      if (paramInt < 0) {
        paramInt = 2147483647;
      }
    }
    if ((Intrinsics.areEqual(paramCoroutineContext, this.context)) && (paramInt == this.capacity)) {
      return this;
    }
    return create(paramCoroutineContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlow
 * JD-Core Version:    0.7.0.1
 */