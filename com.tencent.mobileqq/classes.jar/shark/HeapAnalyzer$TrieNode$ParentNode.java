package shark;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalyzer$TrieNode$ParentNode;", "Lshark/HeapAnalyzer$TrieNode;", "objectId", "", "(J)V", "children", "", "getChildren", "()Ljava/util/Map;", "getObjectId", "()J", "toString", "", "shark"}, k=1, mv={1, 4, 1})
public final class HeapAnalyzer$TrieNode$ParentNode
  extends HeapAnalyzer.TrieNode
{
  @NotNull
  private final Map<Long, HeapAnalyzer.TrieNode> a;
  private final long b;
  
  public HeapAnalyzer$TrieNode$ParentNode(long paramLong)
  {
    super(null);
    this.b = paramLong;
    this.a = ((Map)new LinkedHashMap());
  }
  
  @NotNull
  public final Map<Long, HeapAnalyzer.TrieNode> a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.b;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ParentNode(objectId=");
    localStringBuilder.append(b());
    localStringBuilder.append(", children=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer.TrieNode.ParentNode
 * JD-Core Version:    0.7.0.1
 */