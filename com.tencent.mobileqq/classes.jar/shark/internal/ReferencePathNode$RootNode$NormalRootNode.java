package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.GcRoot;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ReferencePathNode$RootNode$NormalRootNode;", "Lshark/internal/ReferencePathNode$RootNode;", "objectId", "", "gcRoot", "Lshark/GcRoot;", "(JLshark/GcRoot;)V", "getGcRoot", "()Lshark/GcRoot;", "getObjectId", "()J", "shark"}, k=1, mv={1, 4, 1})
public final class ReferencePathNode$RootNode$NormalRootNode
  extends ReferencePathNode.RootNode
{
  private final long a;
  @NotNull
  private final GcRoot b;
  
  public ReferencePathNode$RootNode$NormalRootNode(long paramLong, @NotNull GcRoot paramGcRoot)
  {
    super(null);
    this.a = paramLong;
    this.b = paramGcRoot;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ReferencePathNode.RootNode.NormalRootNode
 * JD-Core Version:    0.7.0.1
 */