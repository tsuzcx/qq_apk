package kotlin.reflect.jvm.internal.impl.utils;

public abstract interface DFS$NodeHandler<N, R>
{
  public abstract void afterChildren(N paramN);
  
  public abstract boolean beforeChildren(N paramN);
  
  public abstract R result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
 * JD-Core Version:    0.7.0.1
 */