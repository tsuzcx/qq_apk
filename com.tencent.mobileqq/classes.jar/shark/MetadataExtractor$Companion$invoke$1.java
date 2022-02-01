package shark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/MetadataExtractor$Companion$invoke$1", "Lshark/MetadataExtractor;", "extractMetadata", "", "", "graph", "Lshark/HeapGraph;", "shark"}, k=1, mv={1, 4, 1})
public final class MetadataExtractor$Companion$invoke$1
  implements MetadataExtractor
{
  @NotNull
  public Map<String, String> a(@NotNull HeapGraph paramHeapGraph)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "graph");
    return (Map)this.b.invoke(paramHeapGraph);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.MetadataExtractor.Companion.invoke.1
 * JD-Core Version:    0.7.0.1
 */