package shark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "it", "Lshark/HeapGraph;", "extractMetadata"}, k=3, mv={1, 4, 1})
final class MetadataExtractor$Companion$NO_OP$1
  implements MetadataExtractor
{
  public static final 1 b = new 1();
  
  @NotNull
  public final Map<String, String> a(@NotNull HeapGraph paramHeapGraph)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "it");
    return MapsKt.emptyMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.MetadataExtractor.Companion.NO_OP.1
 * JD-Core Version:    0.7.0.1
 */