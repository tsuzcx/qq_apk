package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.LeakTraceReference.ReferenceType;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ReferencePathNode$ChildNode;", "Lshark/internal/ReferencePathNode;", "()V", "owningClassId", "", "getOwningClassId", "()J", "parent", "getParent", "()Lshark/internal/ReferencePathNode;", "refFromParentName", "", "getRefFromParentName", "()Ljava/lang/String;", "refFromParentType", "Lshark/LeakTraceReference$ReferenceType;", "getRefFromParentType", "()Lshark/LeakTraceReference$ReferenceType;", "LibraryLeakChildNode", "NormalNode", "Lshark/internal/ReferencePathNode$ChildNode$LibraryLeakChildNode;", "Lshark/internal/ReferencePathNode$ChildNode$NormalNode;", "shark"}, k=1, mv={1, 4, 1})
public abstract class ReferencePathNode$ChildNode
  extends ReferencePathNode
{
  private ReferencePathNode$ChildNode()
  {
    super(null);
  }
  
  @NotNull
  public abstract ReferencePathNode b();
  
  @NotNull
  public abstract LeakTraceReference.ReferenceType c();
  
  @NotNull
  public abstract String d();
  
  public abstract long e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ReferencePathNode.ChildNode
 * JD-Core Version:    0.7.0.1
 */