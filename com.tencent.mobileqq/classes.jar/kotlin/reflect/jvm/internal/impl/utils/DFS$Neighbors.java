package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;

public abstract interface DFS$Neighbors<N>
{
  @NotNull
  public abstract Iterable<? extends N> getNeighbors(N paramN);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
 * JD-Core Version:    0.7.0.1
 */