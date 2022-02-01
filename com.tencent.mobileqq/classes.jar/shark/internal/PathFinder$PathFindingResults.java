package shark.internal;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/PathFinder$PathFindingResults;", "", "pathsToLeakingObjects", "", "Lshark/internal/ReferencePathNode;", "dominatorTree", "Lshark/internal/DominatorTree;", "(Ljava/util/List;Lshark/internal/DominatorTree;)V", "getDominatorTree", "()Lshark/internal/DominatorTree;", "getPathsToLeakingObjects", "()Ljava/util/List;", "shark"}, k=1, mv={1, 4, 1})
public final class PathFinder$PathFindingResults
{
  @NotNull
  private final List<ReferencePathNode> a;
  @Nullable
  private final DominatorTree b;
  
  public PathFinder$PathFindingResults(@NotNull List<? extends ReferencePathNode> paramList, @Nullable DominatorTree paramDominatorTree)
  {
    this.a = paramList;
    this.b = paramDominatorTree;
  }
  
  @NotNull
  public final List<ReferencePathNode> a()
  {
    return this.a;
  }
  
  @Nullable
  public final DominatorTree b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinder.PathFindingResults
 * JD-Core Version:    0.7.0.1
 */