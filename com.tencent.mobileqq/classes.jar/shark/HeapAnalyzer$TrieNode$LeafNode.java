package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.internal.ReferencePathNode;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalyzer$TrieNode$LeafNode;", "Lshark/HeapAnalyzer$TrieNode;", "objectId", "", "pathNode", "Lshark/internal/ReferencePathNode;", "(JLshark/internal/ReferencePathNode;)V", "getObjectId", "()J", "getPathNode", "()Lshark/internal/ReferencePathNode;", "shark"}, k=1, mv={1, 4, 1})
public final class HeapAnalyzer$TrieNode$LeafNode
  extends HeapAnalyzer.TrieNode
{
  private final long a;
  @NotNull
  private final ReferencePathNode b;
  
  public HeapAnalyzer$TrieNode$LeafNode(long paramLong, @NotNull ReferencePathNode paramReferencePathNode)
  {
    super(null);
    this.a = paramLong;
    this.b = paramReferencePathNode;
  }
  
  @NotNull
  public final ReferencePathNode a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer.TrieNode.LeafNode
 * JD-Core Version:    0.7.0.1
 */