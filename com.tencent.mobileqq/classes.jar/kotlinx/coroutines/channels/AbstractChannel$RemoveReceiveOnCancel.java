package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CancelHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class AbstractChannel$RemoveReceiveOnCancel
  extends CancelHandler
{
  private final Receive<?> receive;
  
  public AbstractChannel$RemoveReceiveOnCancel(Receive<?> paramReceive)
  {
    Object localObject;
    this.receive = localObject;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    if (this.receive.remove()) {
      this.this$0.onReceiveDequeued();
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RemoveReceiveOnCancel[");
    localStringBuilder.append(this.receive);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannel.RemoveReceiveOnCancel
 * JD-Core Version:    0.7.0.1
 */