package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChildCancelledException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()V", "fillInStackTrace", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ChildCancelledException
  extends CancellationException
{
  public ChildCancelledException()
  {
    super("Child of the scoped flow was cancelled");
  }
  
  @NotNull
  public Throwable fillInStackTrace()
  {
    if (DebugKt.getDEBUG()) {
      super.fillInStackTrace();
    }
    return (Throwable)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChildCancelledException
 * JD-Core Version:    0.7.0.1
 */