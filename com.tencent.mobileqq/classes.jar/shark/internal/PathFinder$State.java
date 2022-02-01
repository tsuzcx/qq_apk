package shark.internal;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.internal.hppc.LongScatterSet;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/PathFinder$State;", "", "leakingObjectIds", "Lshark/internal/hppc/LongScatterSet;", "sizeOfObjectInstances", "", "computeRetainedHeapSize", "", "javaLangObjectId", "", "estimatedVisitedObjects", "(Lshark/internal/hppc/LongScatterSet;IZJI)V", "getComputeRetainedHeapSize", "()Z", "getJavaLangObjectId", "()J", "getLeakingObjectIds", "()Lshark/internal/hppc/LongScatterSet;", "queuesNotEmpty", "getQueuesNotEmpty", "getSizeOfObjectInstances", "()I", "toVisitLastQueue", "Ljava/util/Deque;", "Lshark/internal/ReferencePathNode;", "getToVisitLastQueue", "()Ljava/util/Deque;", "toVisitLastSet", "getToVisitLastSet", "toVisitQueue", "getToVisitQueue", "toVisitSet", "getToVisitSet", "visitTracker", "Lshark/internal/PathFinder$VisitTracker;", "getVisitTracker", "()Lshark/internal/PathFinder$VisitTracker;", "visitingLast", "getVisitingLast", "setVisitingLast", "(Z)V", "shark"}, k=1, mv={1, 4, 1})
final class PathFinder$State
{
  @NotNull
  private final Deque<ReferencePathNode> a;
  @NotNull
  private final Deque<ReferencePathNode> b;
  @NotNull
  private final LongScatterSet c;
  @NotNull
  private final LongScatterSet d;
  @NotNull
  private final PathFinder.VisitTracker e;
  private boolean f;
  @NotNull
  private final LongScatterSet g;
  private final int h;
  private final boolean i;
  private final long j;
  
  public PathFinder$State(@NotNull LongScatterSet paramLongScatterSet, int paramInt1, boolean paramBoolean, long paramLong, int paramInt2)
  {
    this.g = paramLongScatterSet;
    this.h = paramInt1;
    this.i = paramBoolean;
    this.j = paramLong;
    this.a = ((Deque)new ArrayDeque());
    this.b = ((Deque)new ArrayDeque());
    this.c = new LongScatterSet(0, 1, null);
    this.d = new LongScatterSet(0, 1, null);
    if (this.i) {
      paramLongScatterSet = (PathFinder.VisitTracker)new PathFinder.VisitTracker.Dominated(paramInt2);
    } else {
      paramLongScatterSet = (PathFinder.VisitTracker)new PathFinder.VisitTracker.Visited(paramInt2);
    }
    this.e = paramLongScatterSet;
  }
  
  @NotNull
  public final Deque<ReferencePathNode> a()
  {
    return this.a;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  @NotNull
  public final Deque<ReferencePathNode> b()
  {
    return this.b;
  }
  
  @NotNull
  public final LongScatterSet c()
  {
    return this.c;
  }
  
  @NotNull
  public final LongScatterSet d()
  {
    return this.d;
  }
  
  public final boolean e()
  {
    boolean bool2 = ((Collection)this.a).isEmpty();
    boolean bool1 = true;
    if (!(bool2 ^ true))
    {
      if ((((Collection)this.b).isEmpty() ^ true)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  @NotNull
  public final PathFinder.VisitTracker f()
  {
    return this.e;
  }
  
  public final boolean g()
  {
    return this.f;
  }
  
  @NotNull
  public final LongScatterSet h()
  {
    return this.g;
  }
  
  public final int i()
  {
    return this.h;
  }
  
  public final boolean j()
  {
    return this.i;
  }
  
  public final long k()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinder.State
 * JD-Core Version:    0.7.0.1
 */