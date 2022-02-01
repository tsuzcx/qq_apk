package shark;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalysisFailure;", "Lshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "createdAtTimeMillis", "", "dumpDurationMillis", "analysisDurationMillis", "exception", "Lshark/HeapAnalysisException;", "(Ljava/io/File;JJJLshark/HeapAnalysisException;)V", "getAnalysisDurationMillis", "()J", "getCreatedAtTimeMillis", "getDumpDurationMillis", "getException", "()Lshark/HeapAnalysisException;", "getHeapDumpFile", "()Ljava/io/File;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class HeapAnalysisFailure
  extends HeapAnalysis
{
  @NotNull
  public static final HeapAnalysisFailure.Companion Companion = new HeapAnalysisFailure.Companion(null);
  private static final long serialVersionUID = 8483254400637792414L;
  private final long analysisDurationMillis;
  private final long createdAtTimeMillis;
  private final long dumpDurationMillis;
  @NotNull
  private final HeapAnalysisException exception;
  @NotNull
  private final File heapDumpFile;
  
  public HeapAnalysisFailure(@NotNull File paramFile, long paramLong1, long paramLong2, long paramLong3, @NotNull HeapAnalysisException paramHeapAnalysisException)
  {
    super(null);
    this.heapDumpFile = paramFile;
    this.createdAtTimeMillis = paramLong1;
    this.dumpDurationMillis = paramLong2;
    this.analysisDurationMillis = paramLong3;
    this.exception = paramHeapAnalysisException;
  }
  
  @NotNull
  public final File component1()
  {
    return getHeapDumpFile();
  }
  
  public final long component2()
  {
    return getCreatedAtTimeMillis();
  }
  
  public final long component3()
  {
    return getDumpDurationMillis();
  }
  
  public final long component4()
  {
    return getAnalysisDurationMillis();
  }
  
  @NotNull
  public final HeapAnalysisException component5()
  {
    return this.exception;
  }
  
  @NotNull
  public final HeapAnalysisFailure copy(@NotNull File paramFile, long paramLong1, long paramLong2, long paramLong3, @NotNull HeapAnalysisException paramHeapAnalysisException)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "heapDumpFile");
    Intrinsics.checkParameterIsNotNull(paramHeapAnalysisException, "exception");
    return new HeapAnalysisFailure(paramFile, paramLong1, paramLong2, paramLong3, paramHeapAnalysisException);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HeapAnalysisFailure))
      {
        paramObject = (HeapAnalysisFailure)paramObject;
        if ((Intrinsics.areEqual(getHeapDumpFile(), paramObject.getHeapDumpFile())) && (getCreatedAtTimeMillis() == paramObject.getCreatedAtTimeMillis()) && (getDumpDurationMillis() == paramObject.getDumpDurationMillis()) && (getAnalysisDurationMillis() == paramObject.getAnalysisDurationMillis()) && (Intrinsics.areEqual(this.exception, paramObject.exception))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public long getAnalysisDurationMillis()
  {
    return this.analysisDurationMillis;
  }
  
  public long getCreatedAtTimeMillis()
  {
    return this.createdAtTimeMillis;
  }
  
  public long getDumpDurationMillis()
  {
    return this.dumpDurationMillis;
  }
  
  @NotNull
  public final HeapAnalysisException getException()
  {
    return this.exception;
  }
  
  @NotNull
  public File getHeapDumpFile()
  {
    return this.heapDumpFile;
  }
  
  public int hashCode()
  {
    Object localObject = getHeapDumpFile();
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    long l = getCreatedAtTimeMillis();
    int k = (int)(l ^ l >>> 32);
    l = getDumpDurationMillis();
    int m = (int)(l ^ l >>> 32);
    l = getAnalysisDurationMillis();
    int n = (int)(l ^ l >>> 32);
    localObject = this.exception;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (((i * 31 + k) * 31 + m) * 31 + n) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("====================================\nHEAP ANALYSIS FAILED\n\nYou can report this failure at https://github.com/square/leakcanary/issues\nPlease provide the stacktrace, metadata and the heap dump file.\n====================================\nSTACKTRACE\n\n");
    localStringBuilder.append(this.exception);
    localStringBuilder.append("====================================\nMETADATA\n\nBuild.VERSION.SDK_INT: ");
    localStringBuilder.append(HeapAnalysisKt.a());
    localStringBuilder.append("\nBuild.MANUFACTURER: ");
    localStringBuilder.append(HeapAnalysisKt.b());
    localStringBuilder.append("\nLeakCanary version: ");
    localStringBuilder.append(HeapAnalysisKt.c());
    localStringBuilder.append("\nAnalysis duration: ");
    localStringBuilder.append(getAnalysisDurationMillis());
    localStringBuilder.append(" ms\nHeap dump file path: ");
    localStringBuilder.append(getHeapDumpFile().getAbsolutePath());
    localStringBuilder.append("\nHeap dump timestamp: ");
    localStringBuilder.append(getCreatedAtTimeMillis());
    localStringBuilder.append("\n====================================");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalysisFailure
 * JD-Core Version:    0.7.0.1
 */