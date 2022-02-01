package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "subscribers", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ConflatedBroadcastChannel$State<E>
{
  @JvmField
  @Nullable
  public final ConflatedBroadcastChannel.Subscriber<E>[] subscribers;
  @JvmField
  @Nullable
  public final Object value;
  
  public ConflatedBroadcastChannel$State(@Nullable Object paramObject, @Nullable ConflatedBroadcastChannel.Subscriber<E>[] paramArrayOfSubscriber)
  {
    this.value = paramObject;
    this.subscribers = paramArrayOfSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ConflatedBroadcastChannel.State
 * JD-Core Version:    0.7.0.1
 */