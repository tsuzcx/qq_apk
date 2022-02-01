package shark.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/DominatorTree$MutableDominatorNode;", "", "()V", "dominated", "", "", "getDominated", "()Ljava/util/List;", "retainedCount", "", "getRetainedCount", "()I", "setRetainedCount", "(I)V", "retainedSize", "getRetainedSize", "setRetainedSize", "shallowSize", "getShallowSize", "setShallowSize", "shark"}, k=1, mv={1, 4, 1})
final class DominatorTree$MutableDominatorNode
{
  private int a;
  private int b;
  @NotNull
  private final List<Long> c = (List)new ArrayList();
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  @NotNull
  public final List<Long> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.DominatorTree.MutableDominatorNode
 * JD-Core Version:    0.7.0.1
 */