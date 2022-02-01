package shark;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalysisSuccess;", "Lshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "createdAtTimeMillis", "", "dumpDurationMillis", "analysisDurationMillis", "metadata", "", "", "applicationLeaks", "", "Lshark/ApplicationLeak;", "libraryLeaks", "Lshark/LibraryLeak;", "unreachableObjects", "Lshark/LeakTraceObject;", "(Ljava/io/File;JJJLjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "allLeaks", "Lkotlin/sequences/Sequence;", "Lshark/Leak;", "getAllLeaks", "()Lkotlin/sequences/Sequence;", "getAnalysisDurationMillis", "()J", "getApplicationLeaks", "()Ljava/util/List;", "getCreatedAtTimeMillis", "getDumpDurationMillis", "getHeapDumpFile", "()Ljava/io/File;", "getLibraryLeaks", "getMetadata", "()Ljava/util/Map;", "getUnreachableObjects", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class HeapAnalysisSuccess
  extends HeapAnalysis
{
  @NotNull
  public static final HeapAnalysisSuccess.Companion Companion = new HeapAnalysisSuccess.Companion(null);
  private static final long serialVersionUID = 130453013437459642L;
  private final long analysisDurationMillis;
  @NotNull
  private final List<ApplicationLeak> applicationLeaks;
  private final long createdAtTimeMillis;
  private final long dumpDurationMillis;
  @NotNull
  private final File heapDumpFile;
  @NotNull
  private final List<LibraryLeak> libraryLeaks;
  @NotNull
  private final Map<String, String> metadata;
  @NotNull
  private final List<LeakTraceObject> unreachableObjects;
  
  public HeapAnalysisSuccess(@NotNull File paramFile, long paramLong1, long paramLong2, long paramLong3, @NotNull Map<String, String> paramMap, @NotNull List<ApplicationLeak> paramList, @NotNull List<LibraryLeak> paramList1, @NotNull List<LeakTraceObject> paramList2)
  {
    super(null);
    this.heapDumpFile = paramFile;
    this.createdAtTimeMillis = paramLong1;
    this.dumpDurationMillis = paramLong2;
    this.analysisDurationMillis = paramLong3;
    this.metadata = paramMap;
    this.applicationLeaks = paramList;
    this.libraryLeaks = paramList1;
    this.unreachableObjects = paramList2;
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
  public final Map<String, String> component5()
  {
    return this.metadata;
  }
  
  @NotNull
  public final List<ApplicationLeak> component6()
  {
    return this.applicationLeaks;
  }
  
  @NotNull
  public final List<LibraryLeak> component7()
  {
    return this.libraryLeaks;
  }
  
  @NotNull
  public final List<LeakTraceObject> component8()
  {
    return this.unreachableObjects;
  }
  
  @NotNull
  public final HeapAnalysisSuccess copy(@NotNull File paramFile, long paramLong1, long paramLong2, long paramLong3, @NotNull Map<String, String> paramMap, @NotNull List<ApplicationLeak> paramList, @NotNull List<LibraryLeak> paramList1, @NotNull List<LeakTraceObject> paramList2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "heapDumpFile");
    Intrinsics.checkParameterIsNotNull(paramMap, "metadata");
    Intrinsics.checkParameterIsNotNull(paramList, "applicationLeaks");
    Intrinsics.checkParameterIsNotNull(paramList1, "libraryLeaks");
    Intrinsics.checkParameterIsNotNull(paramList2, "unreachableObjects");
    return new HeapAnalysisSuccess(paramFile, paramLong1, paramLong2, paramLong3, paramMap, paramList, paramList1, paramList2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HeapAnalysisSuccess))
      {
        paramObject = (HeapAnalysisSuccess)paramObject;
        if ((Intrinsics.areEqual(getHeapDumpFile(), paramObject.getHeapDumpFile())) && (getCreatedAtTimeMillis() == paramObject.getCreatedAtTimeMillis()) && (getDumpDurationMillis() == paramObject.getDumpDurationMillis()) && (getAnalysisDurationMillis() == paramObject.getAnalysisDurationMillis()) && (Intrinsics.areEqual(this.metadata, paramObject.metadata)) && (Intrinsics.areEqual(this.applicationLeaks, paramObject.applicationLeaks)) && (Intrinsics.areEqual(this.libraryLeaks, paramObject.libraryLeaks)) && (Intrinsics.areEqual(this.unreachableObjects, paramObject.unreachableObjects))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final Sequence<Leak> getAllLeaks()
  {
    return SequencesKt.plus(CollectionsKt.asSequence((Iterable)this.applicationLeaks), CollectionsKt.asSequence((Iterable)this.libraryLeaks));
  }
  
  public long getAnalysisDurationMillis()
  {
    return this.analysisDurationMillis;
  }
  
  @NotNull
  public final List<ApplicationLeak> getApplicationLeaks()
  {
    return this.applicationLeaks;
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
  public File getHeapDumpFile()
  {
    return this.heapDumpFile;
  }
  
  @NotNull
  public final List<LibraryLeak> getLibraryLeaks()
  {
    return this.libraryLeaks;
  }
  
  @NotNull
  public final Map<String, String> getMetadata()
  {
    return this.metadata;
  }
  
  @NotNull
  public final List<LeakTraceObject> getUnreachableObjects()
  {
    return this.unreachableObjects;
  }
  
  public int hashCode()
  {
    Object localObject = getHeapDumpFile();
    int n = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    long l = getCreatedAtTimeMillis();
    int i1 = (int)(l ^ l >>> 32);
    l = getDumpDurationMillis();
    int i2 = (int)(l ^ l >>> 32);
    l = getAnalysisDurationMillis();
    int i3 = (int)(l ^ l >>> 32);
    localObject = this.metadata;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.applicationLeaks;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.libraryLeaks;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.unreachableObjects;
    if (localObject != null) {
      n = localObject.hashCode();
    }
    return ((((((i * 31 + i1) * 31 + i2) * 31 + i3) * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("====================================\nHEAP ANALYSIS RESULT\n====================================\n");
    localStringBuilder1.append(this.applicationLeaks.size());
    localStringBuilder1.append(" APPLICATION LEAKS\n\nReferences underlined with \"~~~\" are likely causes.\nLearn more at https://squ.re/leaks.\n");
    boolean bool = ((Collection)this.applicationLeaks).isEmpty();
    Object localObject2 = "";
    if ((bool ^ true))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append(CollectionsKt.joinToString$default((Iterable)this.applicationLeaks, (CharSequence)"\n\n", null, null, 0, null, null, 62, null));
      ((StringBuilder)localObject1).append("\n");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("====================================\n");
    localStringBuilder1.append(this.libraryLeaks.size());
    localStringBuilder1.append(" LIBRARY LEAKS\n\nA Library Leak is a leak caused by a known bug in 3rd party code that you do not have control over.\nSee https://square.github.io/leakcanary/fundamentals-how-leakcanary-works/#4-categorizing-leaks\n");
    if ((((Collection)this.libraryLeaks).isEmpty() ^ true))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append(CollectionsKt.joinToString$default((Iterable)this.libraryLeaks, (CharSequence)"\n\n", null, null, 0, null, null, 62, null));
      ((StringBuilder)localObject1).append("\n");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("====================================\n");
    localStringBuilder1.append(this.unreachableObjects.size());
    localStringBuilder1.append(" UNREACHABLE OBJECTS\n\nAn unreachable object is still in memory but LeakCanary could not find a strong reference path\nfrom GC roots.\n");
    if ((((Collection)this.unreachableObjects).isEmpty() ^ true))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append(CollectionsKt.joinToString$default((Iterable)this.unreachableObjects, (CharSequence)"\n\n", null, null, 0, null, null, 62, null));
      ((StringBuilder)localObject1).append("\n");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("====================================\nMETADATA\n\nPlease include this in bug reports and Stack Overflow questions.\n");
    Object localObject1 = localObject2;
    if ((this.metadata.isEmpty() ^ true))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("\n");
      Object localObject3 = this.metadata;
      localObject2 = (Collection)new ArrayList(((Map)localObject3).size());
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append((String)localEntry.getKey());
        localStringBuilder2.append(": ");
        localStringBuilder2.append((String)localEntry.getValue());
        ((Collection)localObject2).add(localStringBuilder2.toString());
      }
      ((StringBuilder)localObject1).append(CollectionsKt.joinToString$default((Iterable)localObject2, (CharSequence)"\n", null, null, 0, null, null, 62, null));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("\nAnalysis duration: ");
    localStringBuilder1.append(getAnalysisDurationMillis());
    localStringBuilder1.append(" ms\nHeap dump file path: ");
    localStringBuilder1.append(getHeapDumpFile().getAbsolutePath());
    localStringBuilder1.append("\nHeap dump timestamp: ");
    localStringBuilder1.append(getCreatedAtTimeMillis());
    localStringBuilder1.append("\nHeap dump duration: ");
    if (getDumpDurationMillis() != -1L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getDumpDurationMillis());
      ((StringBuilder)localObject1).append(" ms");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "Unknown";
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("\n====================================");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalysisSuccess
 * JD-Core Version:    0.7.0.1
 */