package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.LeakTraceReference.ReferenceType;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ReferencePathNode$ChildNode$NormalNode;", "Lshark/internal/ReferencePathNode$ChildNode;", "objectId", "", "parent", "Lshark/internal/ReferencePathNode;", "refFromParentType", "Lshark/LeakTraceReference$ReferenceType;", "refFromParentName", "", "owningClassId", "(JLshark/internal/ReferencePathNode;Lshark/LeakTraceReference$ReferenceType;Ljava/lang/String;J)V", "getObjectId", "()J", "getOwningClassId", "getParent", "()Lshark/internal/ReferencePathNode;", "getRefFromParentName", "()Ljava/lang/String;", "getRefFromParentType", "()Lshark/LeakTraceReference$ReferenceType;", "shark"}, k=1, mv={1, 4, 1})
public final class ReferencePathNode$ChildNode$NormalNode
  extends ReferencePathNode.ChildNode
{
  private final long a;
  @NotNull
  private final ReferencePathNode b;
  @NotNull
  private final LeakTraceReference.ReferenceType c;
  @NotNull
  private final String d;
  private final long e;
  
  public ReferencePathNode$ChildNode$NormalNode(long paramLong1, @NotNull ReferencePathNode paramReferencePathNode, @NotNull LeakTraceReference.ReferenceType paramReferenceType, @NotNull String paramString, long paramLong2)
  {
    super(null);
    this.a = paramLong1;
    this.b = paramReferencePathNode;
    this.c = paramReferenceType;
    this.d = paramString;
    this.e = paramLong2;
  }
  
  public long a()
  {
    return this.a;
  }
  
  @NotNull
  public ReferencePathNode b()
  {
    return this.b;
  }
  
  @NotNull
  public LeakTraceReference.ReferenceType c()
  {
    return this.c;
  }
  
  @NotNull
  public String d()
  {
    return this.d;
  }
  
  public long e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ReferencePathNode.ChildNode.NormalNode
 * JD-Core Version:    0.7.0.1
 */