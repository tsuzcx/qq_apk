package kotlin.script.dependencies;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/dependencies/PseudoFuture;", "T", "Ljava/util/concurrent/Future;", "value", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "cancel", "", "p0", "get", "()Ljava/lang/Object;", "", "p1", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "isDone", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class PseudoFuture<T>
  implements Future<T>
{
  private final T value;
  
  public PseudoFuture(T paramT)
  {
    this.value = paramT;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public T get()
  {
    return this.value;
  }
  
  public T get(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "p1");
    return this.value;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.PseudoFuture
 * JD-Core Version:    0.7.0.1
 */