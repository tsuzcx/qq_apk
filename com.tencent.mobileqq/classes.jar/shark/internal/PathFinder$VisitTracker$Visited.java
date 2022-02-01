package shark.internal;

import kotlin.Metadata;
import shark.internal.hppc.LongScatterSet;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/PathFinder$VisitTracker$Visited;", "Lshark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "visitedSet", "Lshark/internal/hppc/LongScatterSet;", "visited", "", "objectId", "", "parentObjectId", "shark"}, k=1, mv={1, 4, 1})
public final class PathFinder$VisitTracker$Visited
  extends PathFinder.VisitTracker
{
  private final LongScatterSet a;
  
  public PathFinder$VisitTracker$Visited(int paramInt)
  {
    super(null);
    this.a = new LongScatterSet(paramInt);
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return this.a.a(paramLong1) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinder.VisitTracker.Visited
 * JD-Core Version:    0.7.0.1
 */