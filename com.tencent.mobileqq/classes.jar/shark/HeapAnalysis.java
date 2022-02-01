package shark;

import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalysis;", "Ljava/io/Serializable;", "()V", "analysisDurationMillis", "", "getAnalysisDurationMillis", "()J", "createdAtTimeMillis", "getCreatedAtTimeMillis", "dumpDurationMillis", "getDumpDurationMillis", "heapDumpFile", "Ljava/io/File;", "getHeapDumpFile", "()Ljava/io/File;", "Companion", "Lshark/HeapAnalysisFailure;", "Lshark/HeapAnalysisSuccess;", "shark"}, k=1, mv={1, 4, 1})
public abstract class HeapAnalysis
  implements Serializable
{
  @NotNull
  public static final HeapAnalysis.Companion Companion = new HeapAnalysis.Companion(null);
  public static final long DUMP_DURATION_UNKNOWN = -1L;
  private static final long serialVersionUID = -8657286725869987172L;
  
  public abstract long getAnalysisDurationMillis();
  
  public abstract long getCreatedAtTimeMillis();
  
  public abstract long getDumpDurationMillis();
  
  @NotNull
  public abstract File getHeapDumpFile();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalysis
 * JD-Core Version:    0.7.0.1
 */