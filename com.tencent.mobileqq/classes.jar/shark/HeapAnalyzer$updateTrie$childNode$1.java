package shark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HeapAnalyzer$TrieNode$ParentNode;", "invoke"}, k=3, mv={1, 4, 1})
final class HeapAnalyzer$updateTrie$childNode$1
  extends Lambda
  implements Function0<HeapAnalyzer.TrieNode.ParentNode>
{
  HeapAnalyzer$updateTrie$childNode$1(long paramLong, HeapAnalyzer.TrieNode.ParentNode paramParentNode)
  {
    super(0);
  }
  
  @NotNull
  public final HeapAnalyzer.TrieNode.ParentNode invoke()
  {
    HeapAnalyzer.TrieNode.ParentNode localParentNode = new HeapAnalyzer.TrieNode.ParentNode(this.$objectId);
    this.$parentNode.a().put(Long.valueOf(this.$objectId), localParentNode);
    return localParentNode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer.updateTrie.childNode.1
 * JD-Core Version:    0.7.0.1
 */