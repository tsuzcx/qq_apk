package shark;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalyzer$FindLeakInput;", "", "graph", "Lshark/HeapGraph;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lshark/ObjectInspector;", "(Lshark/HeapGraph;Ljava/util/List;ZLjava/util/List;)V", "getComputeRetainedHeapSize", "()Z", "getGraph", "()Lshark/HeapGraph;", "getObjectInspectors", "()Ljava/util/List;", "getReferenceMatchers", "shark"}, k=1, mv={1, 4, 1})
final class HeapAnalyzer$FindLeakInput
{
  @NotNull
  private final HeapGraph a;
  @NotNull
  private final List<ReferenceMatcher> b;
  private final boolean c;
  @NotNull
  private final List<ObjectInspector> d;
  
  public HeapAnalyzer$FindLeakInput(@NotNull HeapGraph paramHeapGraph, @NotNull List<? extends ReferenceMatcher> paramList, boolean paramBoolean, @NotNull List<? extends ObjectInspector> paramList1)
  {
    this.a = paramHeapGraph;
    this.b = paramList;
    this.c = paramBoolean;
    this.d = paramList1;
  }
  
  @NotNull
  public final HeapGraph a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<ReferenceMatcher> b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  @NotNull
  public final List<ObjectInspector> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer.FindLeakInput
 * JD-Core Version:    0.7.0.1
 */