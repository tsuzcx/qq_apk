package shark;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofHeapGraph$Companion;", "", "()V", "INTERNAL_LRU_CACHE_SIZE", "", "getINTERNAL_LRU_CACHE_SIZE", "()I", "setINTERNAL_LRU_CACHE_SIZE", "(I)V", "deprecatedDefaultIndexedGcRootTypes", "", "Lkotlin/reflect/KClass;", "Lshark/GcRoot;", "indexHprof", "Lshark/HeapGraph;", "hprof", "Lshark/Hprof;", "proguardMapping", "Lshark/ProguardMapping;", "indexedGcRootTypes", "openHeapGraph", "Lshark/CloseableHeapGraph;", "Ljava/io/File;", "Lshark/HprofRecordTag;", "Lshark/DualSourceProvider;", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HprofHeapGraph$Companion
{
  private final Set<KClass<? extends GcRoot>> a()
  {
    return SetsKt.setOf(new KClass[] { Reflection.getOrCreateKotlinClass(GcRoot.JniGlobal.class), Reflection.getOrCreateKotlinClass(GcRoot.JavaFrame.class), Reflection.getOrCreateKotlinClass(GcRoot.JniLocal.class), Reflection.getOrCreateKotlinClass(GcRoot.MonitorUsed.class), Reflection.getOrCreateKotlinClass(GcRoot.NativeStack.class), Reflection.getOrCreateKotlinClass(GcRoot.StickyClass.class), Reflection.getOrCreateKotlinClass(GcRoot.ThreadBlock.class), Reflection.getOrCreateKotlinClass(GcRoot.ThreadObject.class), Reflection.getOrCreateKotlinClass(GcRoot.JniMonitor.class) });
  }
  
  @Deprecated(message="Replaced by HprofIndex.indexRecordsOf().openHeapGraph() or File.openHeapGraph()", replaceWith=@ReplaceWith(expression="HprofIndex.indexRecordsOf(hprof, proguardMapping, indexedGcRootTypes).openHeapGraph()", imports={}))
  @NotNull
  public final HeapGraph a(@NotNull Hprof paramHprof, @Nullable ProguardMapping paramProguardMapping, @NotNull Set<? extends KClass<? extends GcRoot>> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramHprof, "hprof");
    Intrinsics.checkParameterIsNotNull(paramSet, "indexedGcRootTypes");
    paramSet = (Iterable)paramSet;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramSet, 10));
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      paramSet = (KClass)localIterator.next();
      if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.Unknown.class)))
      {
        paramSet = HprofRecordTag.ROOT_UNKNOWN;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.JniGlobal.class)))
      {
        paramSet = HprofRecordTag.ROOT_JNI_GLOBAL;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.JniLocal.class)))
      {
        paramSet = HprofRecordTag.ROOT_JNI_LOCAL;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.JavaFrame.class)))
      {
        paramSet = HprofRecordTag.ROOT_JAVA_FRAME;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.NativeStack.class)))
      {
        paramSet = HprofRecordTag.ROOT_NATIVE_STACK;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.StickyClass.class)))
      {
        paramSet = HprofRecordTag.ROOT_STICKY_CLASS;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.ThreadBlock.class)))
      {
        paramSet = HprofRecordTag.ROOT_THREAD_BLOCK;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.MonitorUsed.class)))
      {
        paramSet = HprofRecordTag.ROOT_MONITOR_USED;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.ThreadObject.class)))
      {
        paramSet = HprofRecordTag.ROOT_THREAD_OBJECT;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.InternedString.class)))
      {
        paramSet = HprofRecordTag.ROOT_INTERNED_STRING;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.Finalizing.class)))
      {
        paramSet = HprofRecordTag.ROOT_FINALIZING;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.Debugger.class)))
      {
        paramSet = HprofRecordTag.ROOT_DEBUGGER;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.ReferenceCleanup.class)))
      {
        paramSet = HprofRecordTag.ROOT_REFERENCE_CLEANUP;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.VmInternal.class)))
      {
        paramSet = HprofRecordTag.ROOT_VM_INTERNAL;
      }
      else if (Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.JniMonitor.class)))
      {
        paramSet = HprofRecordTag.ROOT_JNI_MONITOR;
      }
      else
      {
        if (!Intrinsics.areEqual(paramSet, Reflection.getOrCreateKotlinClass(GcRoot.Unreachable.class))) {
          break label377;
        }
        paramSet = HprofRecordTag.ROOT_UNREACHABLE;
      }
      localCollection.add(paramSet);
      continue;
      label377:
      paramHprof = new StringBuilder();
      paramHprof.append("Unknown root ");
      paramHprof.append(paramSet);
      throw ((Throwable)new IllegalStateException(paramHprof.toString().toString()));
    }
    paramSet = CollectionsKt.toSet((Iterable)localCollection);
    paramProguardMapping = HprofIndex.a.a((DualSourceProvider)new FileSourceProvider(paramHprof.a()), paramHprof.b(), paramProguardMapping, paramSet).a();
    paramHprof.a((Closeable)paramProguardMapping);
    return (HeapGraph)paramProguardMapping;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeapGraph.Companion
 * JD-Core Version:    0.7.0.1
 */