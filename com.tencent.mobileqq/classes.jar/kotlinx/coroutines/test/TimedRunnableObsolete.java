package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/test/TimedRunnableObsolete;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "run", "count", "", "time", "(Ljava/lang/Runnable;JJ)V", "heap", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class TimedRunnableObsolete
  implements Comparable<TimedRunnableObsolete>, Runnable, ThreadSafeHeapNode
{
  private final long count;
  @Nullable
  private ThreadSafeHeap<?> heap;
  private int index;
  private final Runnable run;
  @JvmField
  public final long time;
  
  public TimedRunnableObsolete(@NotNull Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    this.run = paramRunnable;
    this.count = paramLong1;
    this.time = paramLong2;
  }
  
  public int compareTo(@NotNull TimedRunnableObsolete paramTimedRunnableObsolete)
  {
    long l3 = this.time;
    long l4 = paramTimedRunnableObsolete.time;
    long l2 = l3;
    long l1 = l4;
    if (l3 == l4)
    {
      l2 = this.count;
      l1 = paramTimedRunnableObsolete.count;
    }
    return l2 < l1;
  }
  
  @Nullable
  public ThreadSafeHeap<?> getHeap()
  {
    return this.heap;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public void run()
  {
    this.run.run();
  }
  
  public void setHeap(@Nullable ThreadSafeHeap<?> paramThreadSafeHeap)
  {
    this.heap = paramThreadSafeHeap;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimedRunnable(time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", run=");
    localStringBuilder.append(this.run);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.test.TimedRunnableObsolete
 * JD-Core Version:    0.7.0.1
 */