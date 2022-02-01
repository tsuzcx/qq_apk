package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class AwaitAll$DisposeHandlersOnCancel
  extends CancelHandler
{
  private final AwaitAll<T>[].AwaitAllNode nodes;
  
  public AwaitAll$DisposeHandlersOnCancel(AwaitAll<T>[].AwaitAllNode paramArrayOfAwaitAll)
  {
    Object localObject;
    this.nodes = localObject;
  }
  
  public final void disposeAll()
  {
    AwaitAll.AwaitAllNode[] arrayOfAwaitAllNode = this.nodes;
    int j = arrayOfAwaitAllNode.length;
    int i = 0;
    while (i < j)
    {
      arrayOfAwaitAllNode[i].getHandle().dispose();
      i += 1;
    }
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    disposeAll();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DisposeHandlersOnCancel[");
    localStringBuilder.append(this.nodes);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.AwaitAll.DisposeHandlersOnCancel
 * JD-Core Version:    0.7.0.1
 */