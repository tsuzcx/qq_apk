package kotlin.reflect.jvm.internal.impl.utils;

import java.util.LinkedList;

public abstract class DFS$NodeHandlerWithListResult<N, R>
  extends DFS.CollectingNodeHandler<N, R, LinkedList<R>>
{
  protected DFS$NodeHandlerWithListResult()
  {
    super(new LinkedList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandlerWithListResult
 * JD-Core Version:    0.7.0.1
 */