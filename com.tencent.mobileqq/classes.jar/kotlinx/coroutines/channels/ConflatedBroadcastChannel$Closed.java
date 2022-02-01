package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ConflatedBroadcastChannel$Closed
{
  @JvmField
  @Nullable
  public final Throwable closeCause;
  
  public ConflatedBroadcastChannel$Closed(@Nullable Throwable paramThrowable)
  {
    this.closeCause = paramThrowable;
  }
  
  @NotNull
  public final Throwable getSendException()
  {
    Throwable localThrowable = this.closeCause;
    if (localThrowable != null) {
      return localThrowable;
    }
    return (Throwable)new ClosedSendChannelException("Channel was closed");
  }
  
  @NotNull
  public final Throwable getValueException()
  {
    Throwable localThrowable = this.closeCause;
    if (localThrowable != null) {
      return localThrowable;
    }
    return (Throwable)new IllegalStateException("Channel was closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed
 * JD-Core Version:    0.7.0.1
 */