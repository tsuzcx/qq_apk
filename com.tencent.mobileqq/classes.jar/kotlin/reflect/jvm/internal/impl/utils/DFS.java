package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public class DFS
{
  public static <N, R> R dfs(@NotNull Collection<N> paramCollection, @NotNull DFS.Neighbors<N> paramNeighbors, @NotNull DFS.NodeHandler<N, R> paramNodeHandler)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(4);
    }
    if (paramNeighbors == null) {
      $$$reportNull$$$0(5);
    }
    if (paramNodeHandler == null) {
      $$$reportNull$$$0(6);
    }
    return dfs(paramCollection, paramNeighbors, new DFS.VisitedWithSet(), paramNodeHandler);
  }
  
  public static <N, R> R dfs(@NotNull Collection<N> paramCollection, @NotNull DFS.Neighbors<N> paramNeighbors, @NotNull DFS.Visited<N> paramVisited, @NotNull DFS.NodeHandler<N, R> paramNodeHandler)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(0);
    }
    if (paramNeighbors == null) {
      $$$reportNull$$$0(1);
    }
    if (paramVisited == null) {
      $$$reportNull$$$0(2);
    }
    if (paramNodeHandler == null) {
      $$$reportNull$$$0(3);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      doDfs(paramCollection.next(), paramNeighbors, paramVisited, paramNodeHandler);
    }
    return paramNodeHandler.result();
  }
  
  public static <N> void doDfs(@NotNull N paramN, @NotNull DFS.Neighbors<N> paramNeighbors, @NotNull DFS.Visited<N> paramVisited, @NotNull DFS.NodeHandler<N, ?> paramNodeHandler)
  {
    if (paramN == null) {
      $$$reportNull$$$0(22);
    }
    if (paramNeighbors == null) {
      $$$reportNull$$$0(23);
    }
    if (paramVisited == null) {
      $$$reportNull$$$0(24);
    }
    if (paramNodeHandler == null) {
      $$$reportNull$$$0(25);
    }
    if (!paramVisited.checkAndMarkVisited(paramN)) {
      return;
    }
    if (!paramNodeHandler.beforeChildren(paramN)) {
      return;
    }
    Iterator localIterator = paramNeighbors.getNeighbors(paramN).iterator();
    while (localIterator.hasNext()) {
      doDfs(localIterator.next(), paramNeighbors, paramVisited, paramNodeHandler);
    }
    paramNodeHandler.afterChildren(paramN);
  }
  
  public static <N> Boolean ifAny(@NotNull Collection<N> paramCollection, @NotNull DFS.Neighbors<N> paramNeighbors, @NotNull Function1<N, Boolean> paramFunction1)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(7);
    }
    if (paramNeighbors == null) {
      $$$reportNull$$$0(8);
    }
    if (paramFunction1 == null) {
      $$$reportNull$$$0(9);
    }
    return (Boolean)dfs(paramCollection, paramNeighbors, new DFS.1(paramFunction1, new boolean[1]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.DFS
 * JD-Core Version:    0.7.0.1
 */