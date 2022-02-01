package shark;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/MetadataExtractor;", "", "extractMetadata", "", "", "graph", "Lshark/HeapGraph;", "Companion", "shark"}, k=1, mv={1, 4, 1})
public abstract interface MetadataExtractor
{
  @NotNull
  public static final MetadataExtractor.Companion a = MetadataExtractor.Companion.a;
  
  @NotNull
  public abstract Map<String, String> a(@NotNull HeapGraph paramHeapGraph);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.MetadataExtractor
 * JD-Core Version:    0.7.0.1
 */