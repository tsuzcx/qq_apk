package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"}, k=1, mv={1, 1, 16})
public final class CancelledContinuation
  extends CompletedExceptionally
{
  private static final AtomicIntegerFieldUpdater _resumed$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed");
  private volatile int _resumed = 0;
  
  public CancelledContinuation(@NotNull Continuation<?> paramContinuation, @Nullable Throwable paramThrowable, boolean paramBoolean)
  {
    super(paramThrowable, paramBoolean);
  }
  
  public final boolean makeResumed()
  {
    return _resumed$FU.compareAndSet(this, 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CancelledContinuation
 * JD-Core Version:    0.7.0.1
 */