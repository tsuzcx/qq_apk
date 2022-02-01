package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.internal.HprofInMemoryIndex;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofIndex;", "", "sourceProvider", "Lshark/RandomAccessSourceProvider;", "header", "Lshark/HprofHeader;", "index", "Lshark/internal/HprofInMemoryIndex;", "(Lshark/RandomAccessSourceProvider;Lshark/HprofHeader;Lshark/internal/HprofInMemoryIndex;)V", "openHeapGraph", "Lshark/CloseableHeapGraph;", "Companion", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HprofIndex
{
  @NotNull
  public static final HprofIndex.Companion a = new HprofIndex.Companion(null);
  private final RandomAccessSourceProvider b;
  private final HprofHeader c;
  private final HprofInMemoryIndex d;
  
  private HprofIndex(RandomAccessSourceProvider paramRandomAccessSourceProvider, HprofHeader paramHprofHeader, HprofInMemoryIndex paramHprofInMemoryIndex)
  {
    this.b = paramRandomAccessSourceProvider;
    this.c = paramHprofHeader;
    this.d = paramHprofInMemoryIndex;
  }
  
  @NotNull
  public final CloseableHeapGraph a()
  {
    RandomAccessHprofReader localRandomAccessHprofReader = RandomAccessHprofReader.a.a(this.b, this.c);
    return (CloseableHeapGraph)new HprofHeapGraph(this.c, localRandomAccessHprofReader, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofIndex
 * JD-Core Version:    0.7.0.1
 */