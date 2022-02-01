package shark;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import shark.internal.ReferencePathNode;
import shark.internal.ReferencePathNode.ChildNode;
import shark.internal.ReferencePathNode.RootNode;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalyzer$ShortestPath;", "", "root", "Lshark/internal/ReferencePathNode$RootNode;", "childPath", "", "Lshark/internal/ReferencePathNode$ChildNode;", "(Lshark/internal/ReferencePathNode$RootNode;Ljava/util/List;)V", "getChildPath", "()Ljava/util/List;", "getRoot", "()Lshark/internal/ReferencePathNode$RootNode;", "asList", "Lshark/internal/ReferencePathNode;", "shark"}, k=1, mv={1, 4, 1})
public final class HeapAnalyzer$ShortestPath
{
  @NotNull
  private final ReferencePathNode.RootNode a;
  @NotNull
  private final List<ReferencePathNode.ChildNode> b;
  
  public HeapAnalyzer$ShortestPath(@NotNull ReferencePathNode.RootNode paramRootNode, @NotNull List<? extends ReferencePathNode.ChildNode> paramList)
  {
    this.a = paramRootNode;
    this.b = paramList;
  }
  
  @NotNull
  public final List<ReferencePathNode> a()
  {
    return CollectionsKt.plus((Collection)CollectionsKt.listOf(this.a), (Iterable)this.b);
  }
  
  @NotNull
  public final ReferencePathNode.RootNode b()
  {
    return this.a;
  }
  
  @NotNull
  public final List<ReferencePathNode.ChildNode> c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer.ShortestPath
 * JD-Core Version:    0.7.0.1
 */