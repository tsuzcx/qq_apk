package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "getOwner", "()Lkotlinx/coroutines/flow/FlowCollector;", "fillInStackTrace", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class AbortFlowException
  extends CancellationException
{
  @NotNull
  private final FlowCollector<?> owner;
  
  public AbortFlowException(@NotNull FlowCollector<?> paramFlowCollector)
  {
    super("Flow was aborted, no more elements needed");
    this.owner = paramFlowCollector;
  }
  
  @NotNull
  public Throwable fillInStackTrace()
  {
    if (DebugKt.getDEBUG()) {
      super.fillInStackTrace();
    }
    return (Throwable)this;
  }
  
  @NotNull
  public final FlowCollector<?> getOwner()
  {
    return this.owner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.AbortFlowException
 * JD-Core Version:    0.7.0.1
 */