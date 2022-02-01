package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"}, k=1, mv={1, 1, 16})
final class InvokeOnCancelling
  extends JobCancellingNode<Job>
{
  private static final AtomicIntegerFieldUpdater _invoked$FU = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");
  private volatile int _invoked;
  private final Function1<Throwable, Unit> handler;
  
  public InvokeOnCancelling(@NotNull Job paramJob, @NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    super(paramJob);
    this.handler = paramFunction1;
    this._invoked = 0;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    if (_invoked$FU.compareAndSet(this, 0, 1)) {
      this.handler.invoke(paramThrowable);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InvokeOnCancelling[");
    localStringBuilder.append(DebugStringsKt.getClassSimpleName(this));
    localStringBuilder.append('@');
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.InvokeOnCancelling
 * JD-Core Version:    0.7.0.1
 */