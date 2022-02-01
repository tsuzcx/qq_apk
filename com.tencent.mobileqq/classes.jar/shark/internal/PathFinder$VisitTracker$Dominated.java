package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/PathFinder$VisitTracker$Dominated;", "Lshark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "dominatorTree", "Lshark/internal/DominatorTree;", "getDominatorTree", "()Lshark/internal/DominatorTree;", "visited", "", "objectId", "", "parentObjectId", "shark"}, k=1, mv={1, 4, 1})
public final class PathFinder$VisitTracker$Dominated
  extends PathFinder.VisitTracker
{
  @NotNull
  private final DominatorTree a;
  
  public PathFinder$VisitTracker$Dominated(int paramInt)
  {
    super(null);
    this.a = new DominatorTree(paramInt);
  }
  
  @NotNull
  public final DominatorTree a()
  {
    return this.a;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return this.a.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinder.VisitTracker.Dominated
 * JD-Core Version:    0.7.0.1
 */