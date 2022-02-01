package kotlin.reflect.jvm.internal.impl.utils;

import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class DFS$VisitedWithSet<N>
  implements DFS.Visited<N>
{
  private final Set<N> visited;
  
  public DFS$VisitedWithSet()
  {
    this(new HashSet());
  }
  
  public DFS$VisitedWithSet(@NotNull Set<N> paramSet)
  {
    this.visited = paramSet;
  }
  
  public boolean checkAndMarkVisited(N paramN)
  {
    return this.visited.add(paramN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.DFS.VisitedWithSet
 * JD-Core Version:    0.7.0.1
 */