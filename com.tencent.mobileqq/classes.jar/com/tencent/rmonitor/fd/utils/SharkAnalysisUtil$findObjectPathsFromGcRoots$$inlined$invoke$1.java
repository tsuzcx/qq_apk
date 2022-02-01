package com.tencent.rmonitor.fd.utils;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.HeapObject;
import shark.ObjectInspector;
import shark.ObjectReporter;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/ObjectInspector$Companion$invoke$1", "Lshark/ObjectInspector;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark"}, k=1, mv={1, 1, 15})
public final class SharkAnalysisUtil$findObjectPathsFromGcRoots$$inlined$invoke$1
  implements ObjectInspector
{
  public void inspect(@NotNull ObjectReporter paramObjectReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectReporter, "reporter");
    Collection localCollection = (Collection)paramObjectReporter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ObjectId=");
    localStringBuilder.append(paramObjectReporter.d().b());
    localCollection.add(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.utils.SharkAnalysisUtil.findObjectPathsFromGcRoots..inlined.invoke.1
 * JD-Core Version:    0.7.0.1
 */