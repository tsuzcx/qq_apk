package shark.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lshark.HeapObject.HeapClass;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import shark.GcRoot;
import shark.GcRoot.JavaFrame;
import shark.GcRoot.JniGlobal;
import shark.GcRoot.ThreadObject;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HeapObject.HeapClass;
import shark.HeapObject.HeapInstance;
import shark.HeapObject.HeapObjectArray;
import shark.HeapObject.HeapPrimitiveArray;
import shark.HeapValue;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord;
import shark.IgnoredReferenceMatcher;
import shark.LeakTraceReference.ReferenceType;
import shark.LibraryLeakReferenceMatcher;
import shark.OnAnalysisProgressListener;
import shark.OnAnalysisProgressListener.Step;
import shark.PrimitiveType;
import shark.ReferenceMatcher;
import shark.ReferencePattern.InstanceFieldPattern;
import shark.ReferencePattern.JavaLocalPattern;
import shark.ReferencePattern.NativeGlobalVariablePattern;
import shark.ReferencePattern.StaticFieldPattern;
import shark.ValueHolder.ReferenceHolder;
import shark.internal.hppc.LongScatterSet;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/PathFinder;", "", "graph", "Lshark/HeapGraph;", "listener", "Lshark/OnAnalysisProgressListener;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "(Lshark/HeapGraph;Lshark/OnAnalysisProgressListener;Ljava/util/List;)V", "fieldNameByClassName", "", "", "jniGlobalReferenceMatchers", "staticFieldNameByClassName", "threadNameReferenceMatchers", "determineSizeOfObjectInstances", "", "objectClass", "Lshark/HeapObject$HeapClass;", "findPathsFromGcRoots", "Lshark/internal/PathFinder$PathFindingResults;", "leakingObjectIds", "", "", "computeRetainedHeapSize", "", "sortedGcRoots", "Lkotlin/Pair;", "Lshark/HeapObject;", "Lshark/GcRoot;", "classHierarchyWithoutJavaLangObject", "javaLangObjectId", "enqueue", "", "Lshark/internal/PathFinder$State;", "node", "Lshark/internal/ReferencePathNode;", "enqueueGcRoots", "getRecordSize", "field", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "poll", "readAllNonNullFieldsOfReferenceType", "", "Lshark/internal/PathFinder$InstanceRefField;", "Lshark/HeapObject$HeapInstance;", "classHierarchy", "toLongScatterSet", "Lshark/internal/hppc/LongScatterSet;", "visitClassRecord", "heapClass", "parent", "visitInstance", "instance", "visitObjectArray", "objectArray", "Lshark/HeapObject$HeapObjectArray;", "InstanceRefField", "PathFindingResults", "State", "VisitTracker", "shark"}, k=1, mv={1, 4, 1})
public final class PathFinder
{
  private final Map<String, Map<String, ReferenceMatcher>> a;
  private final Map<String, Map<String, ReferenceMatcher>> b;
  private final Map<String, ReferenceMatcher> c;
  private final Map<String, ReferenceMatcher> d;
  private final HeapGraph e;
  private final OnAnalysisProgressListener f;
  
  public PathFinder(@NotNull HeapGraph paramHeapGraph, @NotNull OnAnalysisProgressListener paramOnAnalysisProgressListener, @NotNull List<? extends ReferenceMatcher> paramList)
  {
    this.e = paramHeapGraph;
    this.f = paramOnAnalysisProgressListener;
    paramOnAnalysisProgressListener = (Map)new LinkedHashMap();
    Map localMap1 = (Map)new LinkedHashMap();
    Map localMap2 = (Map)new LinkedHashMap();
    Map localMap3 = (Map)new LinkedHashMap();
    paramList = (Iterable)paramList;
    paramHeapGraph = (Collection)new ArrayList();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = paramList.next();
      localObject2 = (ReferenceMatcher)localObject1;
      int i;
      if ((!(localObject2 instanceof IgnoredReferenceMatcher)) && ((!(localObject2 instanceof LibraryLeakReferenceMatcher)) || (!((Boolean)((LibraryLeakReferenceMatcher)localObject2).c().invoke(this.e)).booleanValue()))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        paramHeapGraph.add(localObject1);
      }
    }
    paramList = ((Iterable)paramHeapGraph).iterator();
    while (paramList.hasNext())
    {
      localObject1 = (ReferenceMatcher)paramList.next();
      paramHeapGraph = ((ReferenceMatcher)localObject1).a();
      if ((paramHeapGraph instanceof ReferencePattern.JavaLocalPattern))
      {
        localMap2.put(((ReferencePattern.JavaLocalPattern)paramHeapGraph).getThreadName(), localObject1);
      }
      else if ((paramHeapGraph instanceof ReferencePattern.StaticFieldPattern))
      {
        localObject2 = (ReferencePattern.StaticFieldPattern)paramHeapGraph;
        paramHeapGraph = (Map)localMap1.get(((ReferencePattern.StaticFieldPattern)localObject2).getClassName());
        if (paramHeapGraph == null)
        {
          paramHeapGraph = (Map)new LinkedHashMap();
          localMap1.put(((ReferencePattern.StaticFieldPattern)localObject2).getClassName(), paramHeapGraph);
        }
        paramHeapGraph.put(((ReferencePattern.StaticFieldPattern)localObject2).getFieldName(), localObject1);
      }
      else if ((paramHeapGraph instanceof ReferencePattern.InstanceFieldPattern))
      {
        localObject2 = (ReferencePattern.InstanceFieldPattern)paramHeapGraph;
        paramHeapGraph = (Map)paramOnAnalysisProgressListener.get(((ReferencePattern.InstanceFieldPattern)localObject2).getClassName());
        if (paramHeapGraph == null)
        {
          paramHeapGraph = (Map)new LinkedHashMap();
          paramOnAnalysisProgressListener.put(((ReferencePattern.InstanceFieldPattern)localObject2).getClassName(), paramHeapGraph);
        }
        paramHeapGraph.put(((ReferencePattern.InstanceFieldPattern)localObject2).getFieldName(), localObject1);
      }
      else if ((paramHeapGraph instanceof ReferencePattern.NativeGlobalVariablePattern))
      {
        localMap3.put(((ReferencePattern.NativeGlobalVariablePattern)paramHeapGraph).getClassName(), localObject1);
      }
    }
    this.a = paramOnAnalysisProgressListener;
    this.b = localMap1;
    this.c = localMap2;
    this.d = localMap3;
  }
  
  private final int a(HeapGraph paramHeapGraph, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord paramFieldRecord)
  {
    int i = paramFieldRecord.b();
    if (i == 2) {
      return paramHeapGraph.a();
    }
    if (i == PrimitiveType.BOOLEAN.getHprofType()) {
      return 1;
    }
    if (i == PrimitiveType.CHAR.getHprofType()) {
      label39:
      return 2;
    }
    if (i == PrimitiveType.FLOAT.getHprofType()) {}
    do
    {
      return 4;
      if (i == PrimitiveType.DOUBLE.getHprofType()) {
        return 8;
      }
      if (i == PrimitiveType.BYTE.getHprofType()) {
        break;
      }
      if (i == PrimitiveType.SHORT.getHprofType()) {
        break label39;
      }
    } while (i == PrimitiveType.INT.getHprofType());
    if (i == PrimitiveType.LONG.getHprofType()) {
      return 8;
    }
    paramHeapGraph = new StringBuilder();
    paramHeapGraph.append("Unknown type ");
    paramHeapGraph.append(paramFieldRecord.b());
    paramHeapGraph = (Throwable)new IllegalStateException(paramHeapGraph.toString());
    for (;;)
    {
      throw paramHeapGraph;
    }
  }
  
  private final int a(HeapObject.HeapClass paramHeapClass, HeapGraph paramHeapGraph)
  {
    int j = 0;
    int i = j;
    if (paramHeapClass != null)
    {
      int m = paramHeapClass.l();
      int k = paramHeapGraph.a() + PrimitiveType.INT.getByteSize();
      i = j;
      if (m == k) {
        i = k;
      }
    }
    return i;
  }
  
  private final List<Pair<HeapObject, GcRoot>> a()
  {
    Function1 localFunction1 = (Function1)PathFinder.sortedGcRoots.rootClassName.1.INSTANCE;
    Object localObject1 = (Iterable)this.e.d();
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      GcRoot localGcRoot = (GcRoot)localObject2;
      if (this.e.c(localGcRoot.a())) {
        localCollection.add(localObject2);
      }
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (GcRoot)((Iterator)localObject1).next();
      localCollection.add(TuplesKt.to(this.e.a(((GcRoot)localObject2).a()), localObject2));
    }
    return CollectionsKt.sortedWith((Iterable)localCollection, (Comparator)new PathFinder.sortedGcRoots.3(localFunction1));
  }
  
  private final List<HeapObject.HeapClass> a(HeapObject.HeapClass paramHeapClass, long paramLong)
  {
    List localList = (List)new ArrayList();
    while ((paramHeapClass != null) && (paramHeapClass.b() != paramLong))
    {
      ((Collection)localList).add(paramHeapClass);
      paramHeapClass = paramHeapClass.m();
    }
    return localList;
  }
  
  private final List<PathFinder.InstanceRefField> a(HeapObject.HeapInstance paramHeapInstance, List<HeapObject.HeapClass> paramList)
  {
    HeapGraph localHeapGraph = paramHeapInstance.a();
    Object localObject = (FieldIdReader)null;
    List localList = (List)new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    paramList = (List<HeapObject.HeapClass>)localObject;
    int i = 0;
    while (localIterator1.hasNext())
    {
      HeapObject.HeapClass localHeapClass = (HeapObject.HeapClass)localIterator1.next();
      Iterator localIterator2 = localHeapClass.s().iterator();
      while (localIterator2.hasNext())
      {
        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord localFieldRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord)localIterator2.next();
        if (localFieldRecord.b() != 2)
        {
          i += a(localHeapGraph, localFieldRecord);
        }
        else
        {
          localObject = paramList;
          if (paramList == null) {
            localObject = new FieldIdReader(paramHeapInstance.m(), localHeapGraph.a());
          }
          ((FieldIdReader)localObject).a(i);
          long l = ((FieldIdReader)localObject).a();
          if (l != 0L) {
            localList.add(new PathFinder.InstanceRefField(localHeapClass.b(), l, localHeapClass.a(localFieldRecord)));
          }
          i = 0;
          paramList = (List<HeapObject.HeapClass>)localObject;
        }
      }
    }
    return localList;
  }
  
  private final PathFinder.PathFindingResults a(PathFinder.State paramState)
  {
    c(paramState);
    List localList = (List)new ArrayList();
    while (paramState.e())
    {
      ReferencePathNode localReferencePathNode = b(paramState);
      if (paramState.h().b(localReferencePathNode.a()))
      {
        localList.add(localReferencePathNode);
        if (localList.size() == paramState.h().a())
        {
          if (!paramState.j()) {
            break;
          }
          this.f.a(OnAnalysisProgressListener.Step.FINDING_DOMINATORS);
        }
      }
      HeapObject localHeapObject = this.e.a(localReferencePathNode.a());
      if ((localHeapObject instanceof HeapObject.HeapClass)) {
        a(paramState, (HeapObject.HeapClass)localHeapObject, localReferencePathNode);
      } else if ((localHeapObject instanceof HeapObject.HeapInstance)) {
        a(paramState, (HeapObject.HeapInstance)localHeapObject, localReferencePathNode);
      } else if ((localHeapObject instanceof HeapObject.HeapObjectArray)) {
        a(paramState, (HeapObject.HeapObjectArray)localHeapObject, localReferencePathNode);
      }
    }
    if ((paramState.f() instanceof PathFinder.VisitTracker.Dominated)) {
      paramState = ((PathFinder.VisitTracker.Dominated)paramState.f()).a();
    } else {
      paramState = null;
    }
    return new PathFinder.PathFindingResults(localList, paramState);
  }
  
  private final LongScatterSet a(Set<Long> paramSet)
  {
    LongScatterSet localLongScatterSet = new LongScatterSet(0, 1, null);
    localLongScatterSet.a(paramSet.size());
    paramSet = ((Iterable)paramSet).iterator();
    while (paramSet.hasNext()) {
      localLongScatterSet.a(((Number)paramSet.next()).longValue());
    }
    return localLongScatterSet;
  }
  
  private final void a(PathFinder.State paramState, HeapObject.HeapClass paramHeapClass, ReferencePathNode paramReferencePathNode)
  {
    Map localMap = (Map)this.b.get(paramHeapClass.h());
    if (localMap == null) {
      localMap = MapsKt.emptyMap();
    }
    Iterator localIterator = paramHeapClass.t().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (HeapField)localIterator.next();
      if (((HeapField)localObject).c().d())
      {
        paramHeapClass = ((HeapField)localObject).b();
        if ((!Intrinsics.areEqual(paramHeapClass, "$staticOverhead")) && (!Intrinsics.areEqual(paramHeapClass, "$classOverhead")))
        {
          localObject = ((HeapField)localObject).c().g();
          if (localObject != null)
          {
            long l = ((ValueHolder.ReferenceHolder)localObject).b();
            localObject = (ReferenceMatcher)localMap.get(paramHeapClass);
            if (localObject == null)
            {
              paramHeapClass = (ReferencePathNode.ChildNode)new ReferencePathNode.ChildNode.NormalNode(l, paramReferencePathNode, LeakTraceReference.ReferenceType.STATIC_FIELD, paramHeapClass, 0L, 16, null);
            }
            else if ((localObject instanceof LibraryLeakReferenceMatcher))
            {
              paramHeapClass = (ReferencePathNode.ChildNode)new ReferencePathNode.ChildNode.LibraryLeakChildNode(l, paramReferencePathNode, LeakTraceReference.ReferenceType.STATIC_FIELD, paramHeapClass, (LibraryLeakReferenceMatcher)localObject, 0L, 32, null);
            }
            else
            {
              if (!(localObject instanceof IgnoredReferenceMatcher)) {
                break label239;
              }
              paramHeapClass = null;
            }
            if (paramHeapClass != null)
            {
              a(paramState, (ReferencePathNode)paramHeapClass);
              continue;
              label239:
              throw new NoWhenBranchMatchedException();
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type shark.ValueHolder.ReferenceHolder");
          }
        }
      }
    }
  }
  
  private final void a(PathFinder.State paramState, HeapObject.HeapInstance paramHeapInstance, ReferencePathNode paramReferencePathNode)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramHeapInstance.k().n().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (HeapObject.HeapClass)localIterator.next();
      localObject1 = (Map)this.a.get(((HeapObject.HeapClass)localObject1).h());
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (ReferenceMatcher)((Map.Entry)localObject2).getValue();
          if (!localLinkedHashMap.containsKey(str)) {
            ((Map)localLinkedHashMap).put(str, localObject2);
          }
        }
      }
    }
    paramHeapInstance = a(paramHeapInstance, a(paramHeapInstance.k(), paramState.k()));
    if (paramHeapInstance.size() > 1) {
      CollectionsKt.sortWith(paramHeapInstance, (Comparator)new PathFinder.visitInstance..inlined.sortBy.1());
    }
    localIterator = ((Iterable)paramHeapInstance).iterator();
    while (localIterator.hasNext())
    {
      paramHeapInstance = (PathFinder.InstanceRefField)localIterator.next();
      localObject1 = (ReferenceMatcher)localLinkedHashMap.get(paramHeapInstance.c());
      if (localObject1 == null)
      {
        paramHeapInstance = (ReferencePathNode.ChildNode)new ReferencePathNode.ChildNode.NormalNode(paramHeapInstance.b(), paramReferencePathNode, LeakTraceReference.ReferenceType.INSTANCE_FIELD, paramHeapInstance.c(), paramHeapInstance.a());
      }
      else if ((localObject1 instanceof LibraryLeakReferenceMatcher))
      {
        paramHeapInstance = (ReferencePathNode.ChildNode)new ReferencePathNode.ChildNode.LibraryLeakChildNode(paramHeapInstance.b(), paramReferencePathNode, LeakTraceReference.ReferenceType.INSTANCE_FIELD, paramHeapInstance.c(), (LibraryLeakReferenceMatcher)localObject1, paramHeapInstance.a());
      }
      else
      {
        if (!(localObject1 instanceof IgnoredReferenceMatcher)) {
          break label352;
        }
        paramHeapInstance = null;
      }
      if (paramHeapInstance != null)
      {
        a(paramState, (ReferencePathNode)paramHeapInstance);
      }
      else
      {
        continue;
        label352:
        throw new NoWhenBranchMatchedException();
      }
    }
  }
  
  private final void a(PathFinder.State paramState, HeapObject.HeapObjectArray paramHeapObjectArray, ReferencePathNode paramReferencePathNode)
  {
    paramHeapObjectArray = paramHeapObjectArray.j().d();
    Object localObject = (Collection)new ArrayList();
    int m = paramHeapObjectArray.length;
    int k = 0;
    int i = 0;
    while (i < m)
    {
      long l = paramHeapObjectArray[i];
      int j;
      if ((l != 0L) && (this.e.c(l))) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        ((Collection)localObject).add(Long.valueOf(l));
      }
      i += 1;
    }
    paramHeapObjectArray = ((Iterable)localObject).iterator();
    i = k;
    while (paramHeapObjectArray.hasNext())
    {
      localObject = paramHeapObjectArray.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      a(paramState, (ReferencePathNode)new ReferencePathNode.ChildNode.NormalNode(((Number)localObject).longValue(), paramReferencePathNode, LeakTraceReference.ReferenceType.ARRAY_ENTRY, String.valueOf(i), 0L, 16, null));
      i += 1;
    }
  }
  
  private final void a(PathFinder.State paramState, ReferencePathNode paramReferencePathNode)
  {
    long l2 = paramReferencePathNode.a();
    long l1 = 0L;
    if (l2 == 0L) {
      return;
    }
    boolean bool = paramState.g();
    int k = 1;
    Object localObject1;
    if ((!bool) && (!(paramReferencePathNode instanceof ReferencePathNode.LibraryLeakNode)) && ((!(paramReferencePathNode instanceof ReferencePathNode.RootNode)) || (!(((ReferencePathNode.RootNode)paramReferencePathNode).b() instanceof GcRoot.ThreadObject)))) {
      if ((paramReferencePathNode instanceof ReferencePathNode.ChildNode.NormalNode))
      {
        localObject1 = (ReferencePathNode.ChildNode.NormalNode)paramReferencePathNode;
        if (((((ReferencePathNode.ChildNode.NormalNode)localObject1).b() instanceof ReferencePathNode.RootNode)) && ((((ReferencePathNode.RootNode)((ReferencePathNode.ChildNode.NormalNode)localObject1).b()).b() instanceof GcRoot.JavaFrame))) {}
      }
      else
      {
        i = 0;
        break label109;
      }
    }
    int i = 1;
    label109:
    if (!(paramReferencePathNode instanceof ReferencePathNode.RootNode))
    {
      if (paramReferencePathNode != null) {
        l1 = ((ReferencePathNode.ChildNode)paramReferencePathNode).b().a();
      }
    }
    else
    {
      bool = paramState.f().a(paramReferencePathNode.a(), l1);
      if (bool)
      {
        if (i != 0) {
          return;
        }
        if (paramState.c().b(paramReferencePathNode.a())) {
          return;
        }
        if (!paramState.d().b(paramReferencePathNode.a())) {
          return;
        }
      }
      Object localObject2;
      if (bool)
      {
        paramState.a().add(paramReferencePathNode);
        paramState.c().a(paramReferencePathNode.a());
        localObject1 = ((Iterable)paramState.b()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ReferencePathNode)((Iterator)localObject1).next();
          if (((ReferencePathNode)localObject2).a() == paramReferencePathNode.a()) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            paramState.b().remove(localObject2);
            paramState.d().c(paramReferencePathNode.a());
            return;
          }
        }
        throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
      }
      if (!paramState.h().b(paramReferencePathNode.a()))
      {
        localObject1 = this.e.a(paramReferencePathNode.a());
        if ((localObject1 instanceof HeapObject.HeapClass)) {}
        do
        {
          do
          {
            j = 0;
            break label567;
            if (!(localObject1 instanceof HeapObject.HeapInstance)) {
              break;
            }
            localObject1 = (HeapObject.HeapInstance)localObject1;
            if (((HeapObject.HeapInstance)localObject1).h())
            {
              j = k;
              break label567;
            }
            if (Intrinsics.areEqual(((HeapObject.HeapInstance)localObject1).j(), "java.lang.String"))
            {
              j = k;
              break label567;
            }
            if (((HeapObject.HeapInstance)localObject1).k().i() <= paramState.i())
            {
              j = k;
              break label567;
            }
            localObject1 = ((HeapObject.HeapInstance)localObject1).k().n().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (HeapObject.HeapClass)((Iterator)localObject1).next();
              if ((((HeapObject.HeapClass)localObject2).b() != paramState.k()) && (((HeapObject.HeapClass)localObject2).j())) {
                j = 0;
              } else {
                j = 1;
              }
              if (j == 0)
              {
                j = 0;
                break label517;
              }
            }
            j = 1;
          } while (j == 0);
          j = k;
          break label567;
          if (!(localObject1 instanceof HeapObject.HeapObjectArray)) {
            break;
          }
        } while (!PathFinderKt.a((HeapObject.HeapObjectArray)localObject1));
        int j = k;
        if ((localObject1 instanceof HeapObject.HeapPrimitiveArray))
        {
          j = k;
          if (j == 0) {}
        }
        else
        {
          throw new NoWhenBranchMatchedException();
        }
      }
      if (i != 0)
      {
        paramState.b().add(paramReferencePathNode);
        paramState.d().a(paramReferencePathNode.a());
        return;
      }
      paramState.a().add(paramReferencePathNode);
      paramState.c().a(paramReferencePathNode.a());
      return;
    }
    label517:
    label567:
    paramState = new TypeCastException("null cannot be cast to non-null type shark.internal.ReferencePathNode.ChildNode");
    for (;;)
    {
      throw paramState;
    }
  }
  
  private final ReferencePathNode b(PathFinder.State paramState)
  {
    if ((!paramState.g()) && (!paramState.a().isEmpty()))
    {
      localReferencePathNode = (ReferencePathNode)paramState.a().poll();
      paramState.c().c(localReferencePathNode.a());
      Intrinsics.checkExpressionValueIsNotNull(localReferencePathNode, "removedNode");
      return localReferencePathNode;
    }
    paramState.a(true);
    ReferencePathNode localReferencePathNode = (ReferencePathNode)paramState.b().poll();
    paramState.d().c(localReferencePathNode.a());
    Intrinsics.checkExpressionValueIsNotNull(localReferencePathNode, "removedNode");
    return localReferencePathNode;
  }
  
  private final void c(PathFinder.State paramState)
  {
    Object localObject1 = a();
    Map localMap1 = (Map)new LinkedHashMap();
    Map localMap2 = (Map)new LinkedHashMap();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Pair)localIterator.next();
      localObject1 = (HeapObject)((Pair)localObject2).component1();
      localObject2 = (GcRoot)((Pair)localObject2).component2();
      if ((localObject2 instanceof GcRoot.ThreadObject))
      {
        int i = ((GcRoot.ThreadObject)localObject2).b();
        localObject1 = ((HeapObject)localObject1).f();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localMap2.put(Integer.valueOf(i), TuplesKt.to(localObject1, localObject2));
        a(paramState, (ReferencePathNode)new ReferencePathNode.RootNode.NormalRootNode(((GcRoot)localObject2).a(), (GcRoot)localObject2));
      }
      else if ((localObject2 instanceof GcRoot.JavaFrame))
      {
        localObject1 = (Pair)localMap2.get(Integer.valueOf(((GcRoot.JavaFrame)localObject2).b()));
        if (localObject1 == null)
        {
          a(paramState, (ReferencePathNode)new ReferencePathNode.RootNode.NormalRootNode(((GcRoot)localObject2).a(), (GcRoot)localObject2));
        }
        else
        {
          Object localObject4 = (HeapObject.HeapInstance)((Pair)localObject1).component1();
          Object localObject3 = (GcRoot.ThreadObject)((Pair)localObject1).component2();
          localObject1 = (String)localMap1.get(localObject4);
          if (localObject1 == null) {
            localObject1 = (String)((Function0)new PathFinder.enqueueGcRoots..inlined.forEach.lambda.1((HeapObject.HeapInstance)localObject4, this, paramState, localMap2, localMap1)).invoke();
          }
          localObject1 = (ReferenceMatcher)this.c.get(localObject1);
          if (!(localObject1 instanceof IgnoredReferenceMatcher))
          {
            localObject3 = new ReferencePathNode.RootNode.NormalRootNode(((GcRoot.ThreadObject)localObject3).a(), (GcRoot)localObject2);
            localObject4 = LeakTraceReference.ReferenceType.LOCAL;
            if ((localObject1 instanceof LibraryLeakReferenceMatcher)) {
              localObject1 = (ReferencePathNode.ChildNode)new ReferencePathNode.ChildNode.LibraryLeakChildNode(((GcRoot)localObject2).a(), (ReferencePathNode)localObject3, (LeakTraceReference.ReferenceType)localObject4, "", (LibraryLeakReferenceMatcher)localObject1, 0L, 32, null);
            } else {
              localObject1 = (ReferencePathNode.ChildNode)new ReferencePathNode.ChildNode.NormalNode(((GcRoot)localObject2).a(), (ReferencePathNode)localObject3, (LeakTraceReference.ReferenceType)localObject4, "", 0L, 16, null);
            }
            a(paramState, (ReferencePathNode)localObject1);
          }
        }
      }
      else if ((localObject2 instanceof GcRoot.JniGlobal))
      {
        if ((localObject1 instanceof HeapObject.HeapClass))
        {
          localObject1 = (ReferenceMatcher)this.d.get(((HeapObject.HeapClass)localObject1).h());
        }
        else if ((localObject1 instanceof HeapObject.HeapInstance))
        {
          localObject1 = (ReferenceMatcher)this.d.get(((HeapObject.HeapInstance)localObject1).j());
        }
        else if ((localObject1 instanceof HeapObject.HeapObjectArray))
        {
          localObject1 = (ReferenceMatcher)this.d.get(((HeapObject.HeapObjectArray)localObject1).h());
        }
        else
        {
          if (!(localObject1 instanceof HeapObject.HeapPrimitiveArray)) {
            break label598;
          }
          localObject1 = (ReferenceMatcher)this.d.get(((HeapObject.HeapPrimitiveArray)localObject1).j());
        }
        if (!(localObject1 instanceof IgnoredReferenceMatcher)) {
          if ((localObject1 instanceof LibraryLeakReferenceMatcher))
          {
            a(paramState, (ReferencePathNode)new ReferencePathNode.RootNode.LibraryLeakRootNode(((GcRoot)localObject2).a(), (GcRoot)localObject2, (LibraryLeakReferenceMatcher)localObject1));
          }
          else
          {
            a(paramState, (ReferencePathNode)new ReferencePathNode.RootNode.NormalRootNode(((GcRoot)localObject2).a(), (GcRoot)localObject2));
            continue;
            label598:
            throw new NoWhenBranchMatchedException();
          }
        }
      }
      else
      {
        a(paramState, (ReferencePathNode)new ReferencePathNode.RootNode.NormalRootNode(((GcRoot)localObject2).a(), (GcRoot)localObject2));
      }
    }
  }
  
  @NotNull
  public final PathFinder.PathFindingResults a(@NotNull Set<Long> paramSet, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "leakingObjectIds");
    this.f.a(OnAnalysisProgressListener.Step.FINDING_PATHS_TO_RETAINED_OBJECTS);
    HeapObject.HeapClass localHeapClass = this.e.a("java.lang.Object");
    int i = a(localHeapClass, this.e);
    long l;
    if (localHeapClass != null) {
      l = localHeapClass.b();
    } else {
      l = -1L;
    }
    int j = RangesKt.coerceAtLeast(this.e.c() / 2, 4);
    return a(new PathFinder.State(a(paramSet), i, paramBoolean, l, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinder
 * JD-Core Version:    0.7.0.1
 */