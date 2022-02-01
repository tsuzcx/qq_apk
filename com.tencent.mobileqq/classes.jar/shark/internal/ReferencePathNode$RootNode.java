package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.GcRoot;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ReferencePathNode$RootNode;", "Lshark/internal/ReferencePathNode;", "()V", "gcRoot", "Lshark/GcRoot;", "getGcRoot", "()Lshark/GcRoot;", "LibraryLeakRootNode", "NormalRootNode", "Lshark/internal/ReferencePathNode$RootNode$LibraryLeakRootNode;", "Lshark/internal/ReferencePathNode$RootNode$NormalRootNode;", "shark"}, k=1, mv={1, 4, 1})
public abstract class ReferencePathNode$RootNode
  extends ReferencePathNode
{
  private ReferencePathNode$RootNode()
  {
    super(null);
  }
  
  @NotNull
  public abstract GcRoot b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ReferencePathNode.RootNode
 * JD-Core Version:    0.7.0.1
 */