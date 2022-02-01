package com.tencent.rmonitor.fd.utils;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import shark.FilteringLeakingObjectFinder;
import shark.HeapAnalysis;
import shark.HeapAnalysisFailure;
import shark.HeapAnalysisSuccess;
import shark.HeapAnalyzer;
import shark.HeapGraph;
import shark.Leak;
import shark.LeakTrace;
import shark.LeakTrace.GcRootType;
import shark.LeakTraceObject;
import shark.LeakTraceReference;
import shark.LeakingObjectFinder;
import shark.ObjectInspector;
import shark.OnAnalysisProgressListener;
import shark.OnAnalysisProgressListener.Step;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/fd/utils/SharkAnalysisUtil;", "Lshark/OnAnalysisProgressListener;", "()V", "CLASS_FINALIZER_REFERENCE", "", "OBJECT_ID_PREFIX", "TAG", "findObjectPathsFromGcRoots", "", "", "graph", "Lshark/HeapGraph;", "objectIds", "", "getObjectIdFromLeakTrace", "trace", "Lshark/LeakTrace;", "getObjectPathFeature", "onAnalysisProgress", "", "step", "Lshark/OnAnalysisProgressListener$Step;", "processAnalysisResult", "heapAnalysis", "Lshark/HeapAnalysis;", "rmonitor-memory_release"}, k=1, mv={1, 1, 15})
public final class SharkAnalysisUtil
  implements OnAnalysisProgressListener
{
  public static final SharkAnalysisUtil a = new SharkAnalysisUtil();
  
  private final String a(LeakTrace paramLeakTrace)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("/");
    localStringBuilder1.append(paramLeakTrace.getLeakingObject().getClassName());
    localStringBuilder1 = new StringBuilder(localStringBuilder1.toString());
    Object localObject1 = ((Iterable)CollectionsKt.reversed((Iterable)paramLeakTrace.getReferencePath())).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (LeakTraceReference)((Iterator)localObject1).next();
      String str = ((LeakTraceReference)localObject2).getOriginObject().getClassName();
      boolean bool = Intrinsics.areEqual(str, "java.lang.ref.FinalizerReference");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append('/');
      localStringBuilder2.append(((LeakTraceReference)localObject2).getReferenceName());
      localStringBuilder2.append(", ");
      localStringBuilder2.append(str);
      localObject2 = localStringBuilder2.toString();
      if ((bool) && (i == 0))
      {
        i = 1;
        localStringBuilder1.append((String)localObject2);
        Intrinsics.checkExpressionValueIsNotNull(localStringBuilder1, "builder.append(node)");
      }
      else if (!bool)
      {
        localStringBuilder1.append((String)localObject2);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/GcRoot: ");
    ((StringBuilder)localObject1).append(paramLeakTrace.getGcRootType().getDescription());
    localStringBuilder1.append(((StringBuilder)localObject1).toString());
    paramLeakTrace = localStringBuilder1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramLeakTrace, "builder.toString()");
    return paramLeakTrace;
  }
  
  private final Map<Long, String> a(HeapAnalysis paramHeapAnalysis)
  {
    HashMap localHashMap = new HashMap();
    Object localObject;
    if ((paramHeapAnalysis instanceof HeapAnalysisSuccess))
    {
      paramHeapAnalysis = (HeapAnalysisSuccess)paramHeapAnalysis;
      paramHeapAnalysis = CollectionsKt.plus((Collection)paramHeapAnalysis.getApplicationLeaks(), (Iterable)paramHeapAnalysis.getLibraryLeaks()).iterator();
      while (paramHeapAnalysis.hasNext())
      {
        localObject = (LeakTrace)CollectionsKt.firstOrNull(((Leak)paramHeapAnalysis.next()).getLeakTraces());
        if (localObject != null)
        {
          long l = b((LeakTrace)localObject);
          if (l != 0L) {
            ((Map)localHashMap).put(Long.valueOf(l), a((LeakTrace)localObject));
          }
        }
      }
    }
    if ((paramHeapAnalysis instanceof HeapAnalysisFailure))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findObjectPathsFromGcRoots failed: ");
      ((StringBuilder)localObject).append(paramHeapAnalysis);
      LogUtils.d("SharkAnalysisUtil", ((StringBuilder)localObject).toString());
    }
    return (Map)localHashMap;
  }
  
  @JvmStatic
  @NotNull
  public static final Map<Long, String> a(@NotNull HeapGraph paramHeapGraph, @NotNull Set<Long> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "graph");
    Intrinsics.checkParameterIsNotNull(paramSet, "objectIds");
    paramSet = new FilteringLeakingObjectFinder(CollectionsKt.listOf(new SharkAnalysisUtil.findObjectPathsFromGcRoots.objectFilter.1(paramSet)));
    Object localObject = ObjectInspector.a;
    localObject = (ObjectInspector)new SharkAnalysisUtil.findObjectPathsFromGcRoots..inlined.invoke.1();
    paramHeapGraph = HeapAnalyzer.a(new HeapAnalyzer((OnAnalysisProgressListener)a), new File(""), paramHeapGraph, (LeakingObjectFinder)paramSet, null, false, CollectionsKt.listOf(localObject), null, 88, null);
    return a.a(paramHeapGraph);
  }
  
  private final long b(LeakTrace paramLeakTrace)
  {
    Iterator localIterator = ((Iterable)paramLeakTrace.getLeakingObject().getLabels()).iterator();
    while (localIterator.hasNext())
    {
      paramLeakTrace = localIterator.next();
      if (StringsKt.startsWith$default((String)paramLeakTrace, "ObjectId=", false, 2, null)) {
        break label53;
      }
    }
    paramLeakTrace = null;
    label53:
    paramLeakTrace = (String)paramLeakTrace;
    if (paramLeakTrace != null)
    {
      paramLeakTrace = StringsKt.substringAfter$default(paramLeakTrace, "ObjectId=", null, 2, null);
      if (paramLeakTrace != null)
      {
        paramLeakTrace = StringsKt.toLongOrNull(paramLeakTrace);
        if (paramLeakTrace != null) {
          return paramLeakTrace.longValue();
        }
      }
    }
    return 0L;
  }
  
  public void a(@NotNull OnAnalysisProgressListener.Step paramStep)
  {
    Intrinsics.checkParameterIsNotNull(paramStep, "step");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.utils.SharkAnalysisUtil
 * JD-Core Version:    0.7.0.1
 */