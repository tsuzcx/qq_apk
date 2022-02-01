package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.GcRoot;
import shark.LibraryLeakReferenceMatcher;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ReferencePathNode$RootNode$LibraryLeakRootNode;", "Lshark/internal/ReferencePathNode$RootNode;", "Lshark/internal/ReferencePathNode$LibraryLeakNode;", "objectId", "", "gcRoot", "Lshark/GcRoot;", "matcher", "Lshark/LibraryLeakReferenceMatcher;", "(JLshark/GcRoot;Lshark/LibraryLeakReferenceMatcher;)V", "getGcRoot", "()Lshark/GcRoot;", "getMatcher", "()Lshark/LibraryLeakReferenceMatcher;", "getObjectId", "()J", "shark"}, k=1, mv={1, 4, 1})
public final class ReferencePathNode$RootNode$LibraryLeakRootNode
  extends ReferencePathNode.RootNode
  implements ReferencePathNode.LibraryLeakNode
{
  private final long a;
  @NotNull
  private final GcRoot b;
  @NotNull
  private final LibraryLeakReferenceMatcher c;
  
  public ReferencePathNode$RootNode$LibraryLeakRootNode(long paramLong, @NotNull GcRoot paramGcRoot, @NotNull LibraryLeakReferenceMatcher paramLibraryLeakReferenceMatcher)
  {
    super(null);
    this.a = paramLong;
    this.b = paramGcRoot;
    this.c = paramLibraryLeakReferenceMatcher;
  }
  
  public long a()
  {
    return this.a;
  }
  
  @NotNull
  public GcRoot b()
  {
    return this.b;
  }
  
  @NotNull
  public LibraryLeakReferenceMatcher f()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ReferencePathNode.RootNode.LibraryLeakRootNode
 * JD-Core Version:    0.7.0.1
 */