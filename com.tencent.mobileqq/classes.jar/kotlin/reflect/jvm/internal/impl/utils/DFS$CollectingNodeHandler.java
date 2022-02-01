package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;

public abstract class DFS$CollectingNodeHandler<N, R, C extends Iterable<R>>
  extends DFS.AbstractNodeHandler<N, C>
{
  @NotNull
  protected final C result;
  
  protected DFS$CollectingNodeHandler(@NotNull C paramC)
  {
    this.result = paramC;
  }
  
  @NotNull
  public C result()
  {
    Iterable localIterable = this.result;
    if (localIterable == null) {
      $$$reportNull$$$0(1);
    }
    return localIterable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.DFS.CollectingNodeHandler
 * JD-Core Version:    0.7.0.1
 */