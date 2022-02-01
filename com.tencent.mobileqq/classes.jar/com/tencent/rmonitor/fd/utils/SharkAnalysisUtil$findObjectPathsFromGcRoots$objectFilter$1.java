package com.tencent.rmonitor.fd.utils;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.FilteringLeakingObjectFinder.LeakingObjectFilter;
import shark.HeapObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/rmonitor/fd/utils/SharkAnalysisUtil$findObjectPathsFromGcRoots$objectFilter$1", "Lshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "isLeakingObject", "", "heapObject", "Lshark/HeapObject;", "rmonitor-memory_release"}, k=1, mv={1, 1, 15})
public final class SharkAnalysisUtil$findObjectPathsFromGcRoots$objectFilter$1
  implements FilteringLeakingObjectFinder.LeakingObjectFilter
{
  SharkAnalysisUtil$findObjectPathsFromGcRoots$objectFilter$1(Set paramSet) {}
  
  public boolean a(@NotNull HeapObject paramHeapObject)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapObject, "heapObject");
    return this.a.contains(Long.valueOf(paramHeapObject.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.utils.SharkAnalysisUtil.findObjectPathsFromGcRoots.objectFilter.1
 * JD-Core Version:    0.7.0.1
 */