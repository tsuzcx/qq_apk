package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.LeakTraceReference.ReferenceType;
import shark.LibraryLeakReferenceMatcher;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ReferencePathNode$ChildNode$LibraryLeakChildNode;", "Lshark/internal/ReferencePathNode$ChildNode;", "Lshark/internal/ReferencePathNode$LibraryLeakNode;", "objectId", "", "parent", "Lshark/internal/ReferencePathNode;", "refFromParentType", "Lshark/LeakTraceReference$ReferenceType;", "refFromParentName", "", "matcher", "Lshark/LibraryLeakReferenceMatcher;", "owningClassId", "(JLshark/internal/ReferencePathNode;Lshark/LeakTraceReference$ReferenceType;Ljava/lang/String;Lshark/LibraryLeakReferenceMatcher;J)V", "getMatcher", "()Lshark/LibraryLeakReferenceMatcher;", "getObjectId", "()J", "getOwningClassId", "getParent", "()Lshark/internal/ReferencePathNode;", "getRefFromParentName", "()Ljava/lang/String;", "getRefFromParentType", "()Lshark/LeakTraceReference$ReferenceType;", "shark"}, k=1, mv={1, 4, 1})
public final class ReferencePathNode$ChildNode$LibraryLeakChildNode
  extends ReferencePathNode.ChildNode
  implements ReferencePathNode.LibraryLeakNode
{
  private final long a;
  @NotNull
  private final ReferencePathNode b;
  @NotNull
  private final LeakTraceReference.ReferenceType c;
  @NotNull
  private final String d;
  @NotNull
  private final LibraryLeakReferenceMatcher e;
  private final long f;
  
  public ReferencePathNode$ChildNode$LibraryLeakChildNode(long paramLong1, @NotNull ReferencePathNode paramReferencePathNode, @NotNull LeakTraceReference.ReferenceType paramReferenceType, @NotNull String paramString, @NotNull LibraryLeakReferenceMatcher paramLibraryLeakReferenceMatcher, long paramLong2)
  {
    super(null);
    this.a = paramLong1;
    this.b = paramReferencePathNode;
    this.c = paramReferenceType;
    this.d = paramString;
    this.e = paramLibraryLeakReferenceMatcher;
    this.f = paramLong2;
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
    return this.f;
  }
  
  @NotNull
  public LibraryLeakReferenceMatcher f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ReferencePathNode.ChildNode.LibraryLeakChildNode
 * JD-Core Version:    0.7.0.1
 */