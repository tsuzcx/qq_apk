package shark;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lshark.HeapAnalyzer.ShortestPath;>;
import java.util.List<Lshark.ObjectReporter;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import shark.internal.AndroidNativeSizeMapper;
import shark.internal.DominatorTree;
import shark.internal.KeyedWeakReferenceMirror;
import shark.internal.PathFinder;
import shark.internal.PathFinder.PathFindingResults;
import shark.internal.ReferencePathNode;
import shark.internal.ReferencePathNode.ChildNode;
import shark.internal.ReferencePathNode.LibraryLeakNode;
import shark.internal.ReferencePathNode.RootNode;
import shark.internal.ShallowSizeCalculator;
import shark.internal.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalyzer;", "", "listener", "Lshark/OnAnalysisProgressListener;", "(Lshark/OnAnalysisProgressListener;)V", "analyze", "Lshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "graph", "Lshark/HeapGraph;", "leakingObjectFinder", "Lshark/LeakingObjectFinder;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lshark/ObjectInspector;", "metadataExtractor", "Lshark/MetadataExtractor;", "proguardMapping", "Lshark/ProguardMapping;", "buildLeakTraceObjects", "Lshark/LeakTraceObject;", "inspectedObjects", "Lshark/HeapAnalyzer$InspectedObject;", "retainedSizes", "", "", "Lkotlin/Pair;", "", "computeLeakStatuses", "leakReporters", "Lshark/ObjectReporter;", "deduplicateShortestPaths", "Lshark/HeapAnalyzer$ShortestPath;", "inputPathResults", "Lshark/internal/ReferencePathNode;", "findResultsInTrie", "", "parentNode", "Lshark/HeapAnalyzer$TrieNode$ParentNode;", "outputPathResults", "", "recordClassName", "", "heap", "Lshark/HeapObject;", "resolveStatus", "Lshark/LeakTraceObject$LeakingStatus;", "reporter", "leakingWins", "since", "analysisStartNanoTime", "updateTrie", "pathNode", "path", "pathIndex", "analyzeGraph", "Lshark/HeapAnalysisSuccess;", "Lshark/HeapAnalyzer$FindLeakInput;", "buildLeakTraces", "Lshark/ApplicationLeak;", "Lshark/LibraryLeak;", "shortestPaths", "inspectedObjectsByPath", "buildReferencePath", "Lshark/LeakTraceReference;", "shortestChildPath", "Lshark/internal/ReferencePathNode$ChildNode;", "leakTraceObjects", "computeRetainedSizes", "dominatorTree", "Lshark/internal/DominatorTree;", "findLeaks", "Lshark/HeapAnalyzer$LeaksAndUnreachableObjects;", "leakingObjectIds", "", "findUnreachableObjects", "pathFindingResults", "Lshark/internal/PathFinder$PathFindingResults;", "inspectObjects", "FindLeakInput", "InspectedObject", "LeaksAndUnreachableObjects", "ShortestPath", "TrieNode", "shark"}, k=1, mv={1, 4, 1})
public final class HeapAnalyzer
{
  private final OnAnalysisProgressListener a;
  
  public HeapAnalyzer(@NotNull OnAnalysisProgressListener paramOnAnalysisProgressListener)
  {
    this.a = paramOnAnalysisProgressListener;
  }
  
  private final long a(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - paramLong);
  }
  
  private final String a(HeapObject paramHeapObject)
  {
    if ((paramHeapObject instanceof HeapObject.HeapClass)) {
      return ((HeapObject.HeapClass)paramHeapObject).h();
    }
    if ((paramHeapObject instanceof HeapObject.HeapInstance)) {
      return ((HeapObject.HeapInstance)paramHeapObject).j();
    }
    if ((paramHeapObject instanceof HeapObject.HeapObjectArray)) {
      return ((HeapObject.HeapObjectArray)paramHeapObject).h();
    }
    if ((paramHeapObject instanceof HeapObject.HeapPrimitiveArray)) {
      return ((HeapObject.HeapPrimitiveArray)paramHeapObject).j();
    }
    throw new NoWhenBranchMatchedException();
  }
  
  private final List<HeapAnalyzer.ShortestPath> a(List<? extends ReferencePathNode> paramList)
  {
    Object localObject3 = new HeapAnalyzer.TrieNode.ParentNode(0L);
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (ReferencePathNode)localIterator.next();
      List localList = (List)new ArrayList();
      for (localObject1 = localObject2; (localObject1 instanceof ReferencePathNode.ChildNode); localObject1 = ((ReferencePathNode.ChildNode)localObject1).b()) {
        localList.add(0, Long.valueOf(((ReferencePathNode)localObject1).a()));
      }
      localList.add(0, Long.valueOf(((ReferencePathNode)localObject1).a()));
      a((ReferencePathNode)localObject2, localList, 0, (HeapAnalyzer.TrieNode.ParentNode)localObject3);
    }
    Object localObject1 = (List)new ArrayList();
    a((HeapAnalyzer.TrieNode.ParentNode)localObject3, (List)localObject1);
    if (((List)localObject1).size() != paramList.size())
    {
      localObject2 = SharkLog.a.a();
      if (localObject2 != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Found ");
        ((StringBuilder)localObject3).append(paramList.size());
        ((StringBuilder)localObject3).append(" paths to retained objects,");
        ((StringBuilder)localObject3).append(" down to ");
        ((StringBuilder)localObject3).append(((List)localObject1).size());
        ((StringBuilder)localObject3).append(" after removing duplicated paths");
        ((SharkLog.Logger)localObject2).a(((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      paramList = SharkLog.a.a();
      if (paramList != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Found ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        ((StringBuilder)localObject2).append(" paths to retained objects");
        paramList.a(((StringBuilder)localObject2).toString());
      }
    }
    paramList = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramList = (ReferencePathNode)((Iterator)localObject2).next();
      localObject3 = (List)new ArrayList();
      while ((paramList instanceof ReferencePathNode.ChildNode))
      {
        ((List)localObject3).add(0, paramList);
        paramList = ((ReferencePathNode.ChildNode)paramList).b();
      }
      if (paramList != null) {
        ((Collection)localObject1).add(new HeapAnalyzer.ShortestPath((ReferencePathNode.RootNode)paramList, (List)localObject3));
      } else {
        throw new TypeCastException("null cannot be cast to non-null type shark.internal.ReferencePathNode.RootNode");
      }
    }
    return (List)localObject1;
  }
  
  private final List<LeakTraceObject> a(List<HeapAnalyzer.InspectedObject> paramList, Map<Long, Pair<Integer, Integer>> paramMap)
  {
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (HeapAnalyzer.InspectedObject)localIterator.next();
      paramList = ((HeapAnalyzer.InspectedObject)localObject2).a();
      String str1 = a(paramList);
      if ((paramList instanceof HeapObject.HeapClass)) {
        paramList = LeakTraceObject.ObjectType.CLASS;
      }
      for (;;)
      {
        break;
        if ((!(paramList instanceof HeapObject.HeapObjectArray)) && (!(paramList instanceof HeapObject.HeapPrimitiveArray))) {
          paramList = LeakTraceObject.ObjectType.INSTANCE;
        } else {
          paramList = LeakTraceObject.ObjectType.ARRAY;
        }
      }
      Object localObject1;
      if (paramMap != null) {
        localObject1 = (Pair)paramMap.get(Long.valueOf(((HeapAnalyzer.InspectedObject)localObject2).a().b()));
      } else {
        localObject1 = null;
      }
      Set localSet = ((HeapAnalyzer.InspectedObject)localObject2).d();
      LeakTraceObject.LeakingStatus localLeakingStatus = ((HeapAnalyzer.InspectedObject)localObject2).b();
      String str2 = ((HeapAnalyzer.InspectedObject)localObject2).c();
      if (localObject1 != null) {
        localObject2 = (Integer)((Pair)localObject1).getFirst();
      } else {
        localObject2 = null;
      }
      if (localObject1 != null) {
        localObject1 = (Integer)((Pair)localObject1).getSecond();
      } else {
        localObject1 = null;
      }
      localCollection.add(new LeakTraceObject(paramList, str1, localSet, localLeakingStatus, str2, (Integer)localObject2, (Integer)localObject1));
    }
    return (List)localCollection;
  }
  
  private final List<List<HeapAnalyzer.InspectedObject>> a(HeapAnalyzer.FindLeakInput paramFindLeakInput, List<HeapAnalyzer.ShortestPath> paramList)
  {
    this.a.a(OnAnalysisProgressListener.Step.INSPECTING_OBJECTS);
    paramList = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    Iterator localIterator1 = paramList.iterator();
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localObject2 = ((HeapAnalyzer.ShortestPath)localIterator1.next()).a();
      paramList = (Iterable)localObject2;
      Collection localCollection1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
      int i = 0;
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        paramList = localIterator2.next();
        int j = i + 1;
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        paramList = (ReferencePathNode)paramList;
        ObjectReporter localObjectReporter = new ObjectReporter(paramFindLeakInput.a().a(paramList.a()));
        if (j < ((List)localObject2).size()) {
          paramList = (ReferencePathNode)((List)localObject2).get(j);
        } else {
          paramList = null;
        }
        if ((paramList instanceof ReferencePathNode.LibraryLeakNode))
        {
          Collection localCollection2 = (Collection)localObjectReporter.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Library leak match: ");
          localStringBuilder.append(((ReferencePathNode.LibraryLeakNode)paramList).f().a());
          localCollection2.add(localStringBuilder.toString());
        }
        localCollection1.add(localObjectReporter);
        i = j;
      }
      ((Collection)localObject1).add((List)localCollection1);
    }
    paramList = (List)localObject1;
    paramFindLeakInput = ((Iterable)paramFindLeakInput.d()).iterator();
    if (paramFindLeakInput.hasNext())
    {
      localObject1 = (ObjectInspector)paramFindLeakInput.next();
      localIterator1 = ((Iterable)paramList).iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = ((Iterable)localIterator1.next()).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ObjectInspector)localObject1).inspect((ObjectReporter)((Iterator)localObject2).next());
        }
      }
    }
    paramList = (Iterable)paramList;
    paramFindLeakInput = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramFindLeakInput.add(b((List)paramList.next()));
    }
    return (List)paramFindLeakInput;
  }
  
  private final List<LeakTraceReference> a(HeapAnalyzer.FindLeakInput paramFindLeakInput, List<? extends ReferencePathNode.ChildNode> paramList, List<LeakTraceObject> paramList1)
  {
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      ReferencePathNode.ChildNode localChildNode = (ReferencePathNode.ChildNode)paramList;
      LeakTraceObject localLeakTraceObject = (LeakTraceObject)paramList1.get(i);
      LeakTraceReference.ReferenceType localReferenceType = localChildNode.c();
      if (localChildNode.e() != 0L)
      {
        paramList = paramFindLeakInput.a().a(localChildNode.e()).e();
        if (paramList == null) {
          Intrinsics.throwNpe();
        }
        paramList = paramList.h();
      }
      else
      {
        paramList = ((LeakTraceObject)paramList1.get(i)).getClassName();
      }
      localCollection.add(new LeakTraceReference(localLeakTraceObject, localReferenceType, paramList, localChildNode.d()));
      i += 1;
    }
    return (List)localCollection;
  }
  
  private final List<LeakTraceObject> a(HeapAnalyzer.FindLeakInput paramFindLeakInput, PathFinder.PathFindingResults paramPathFindingResults, Set<Long> paramSet)
  {
    Object localObject = (Iterable)paramPathFindingResults.a();
    paramPathFindingResults = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramPathFindingResults.add(Long.valueOf(((ReferencePathNode)((Iterator)localObject).next()).a()));
    }
    paramSet = (Iterable)SetsKt.minus(paramSet, (Iterable)CollectionsKt.toSet((Iterable)paramPathFindingResults));
    paramPathFindingResults = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramSet, 10));
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      long l = ((Number)paramSet.next()).longValue();
      paramPathFindingResults.add(new ObjectReporter(paramFindLeakInput.a().a(l)));
    }
    paramPathFindingResults = (List)paramPathFindingResults;
    paramFindLeakInput = ((Iterable)paramFindLeakInput.d()).iterator();
    while (paramFindLeakInput.hasNext())
    {
      paramSet = (ObjectInspector)paramFindLeakInput.next();
      localObject = ((Iterable)paramPathFindingResults).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramSet.inspect((ObjectReporter)((Iterator)localObject).next());
      }
    }
    paramFindLeakInput = (Iterable)paramPathFindingResults;
    paramSet = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramFindLeakInput, 10));
    localObject = paramFindLeakInput.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ObjectReporter localObjectReporter = (ObjectReporter)((Iterator)localObject).next();
      paramPathFindingResults = a(localObjectReporter, true);
      paramFindLeakInput = (LeakTraceObject.LeakingStatus)paramPathFindingResults.component1();
      paramPathFindingResults = (String)paramPathFindingResults.component2();
      int i = HeapAnalyzer.WhenMappings.$EnumSwitchMapping$0[paramFindLeakInput.ordinal()];
      paramFindLeakInput = paramPathFindingResults;
      if (i != 1) {
        if (i != 2)
        {
          if (i == 3)
          {
            paramFindLeakInput = new StringBuilder();
            paramFindLeakInput.append("This is a leaking object. Conflicts with ");
            paramFindLeakInput.append(paramPathFindingResults);
            paramFindLeakInput = paramFindLeakInput.toString();
          }
          else
          {
            throw new NoWhenBranchMatchedException();
          }
        }
        else {
          paramFindLeakInput = "This is a leaking object";
        }
      }
      paramSet.add(new HeapAnalyzer.InspectedObject(localObjectReporter.d(), LeakTraceObject.LeakingStatus.LEAKING, paramFindLeakInput, (Set)localObjectReporter.a()));
    }
    return a((List)paramSet, null);
  }
  
  private final Map<Long, Pair<Integer, Integer>> a(HeapAnalyzer.FindLeakInput paramFindLeakInput, List<? extends List<HeapAnalyzer.InspectedObject>> paramList, DominatorTree paramDominatorTree)
  {
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Iterable)((Iterator)localObject1).next();
      Collection localCollection = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        HeapAnalyzer.InspectedObject localInspectedObject = (HeapAnalyzer.InspectedObject)localObject3;
        int i;
        if ((localInspectedObject.b() != LeakTraceObject.LeakingStatus.UNKNOWN) && (localInspectedObject.b() != LeakTraceObject.LeakingStatus.LEAKING)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          localCollection.add(localObject3);
        }
      }
      localObject2 = (Iterable)localCollection;
      localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection.add(Long.valueOf(((HeapAnalyzer.InspectedObject)((Iterator)localObject2).next()).a().b()));
      }
      CollectionsKt.addAll(paramList, (Iterable)localCollection);
    }
    paramList = CollectionsKt.toSet((Iterable)paramList);
    this.a.a(OnAnalysisProgressListener.Step.COMPUTING_NATIVE_RETAINED_SIZE);
    localObject1 = new AndroidNativeSizeMapper(paramFindLeakInput.a()).a();
    this.a.a(OnAnalysisProgressListener.Step.COMPUTING_RETAINED_SIZE);
    return paramDominatorTree.a(paramList, (Function1)new HeapAnalyzer.computeRetainedSizes.1((Map)localObject1, new ShallowSizeCalculator(paramFindLeakInput.a())));
  }
  
  private final Pair<List<ApplicationLeak>, List<LibraryLeak>> a(HeapAnalyzer.FindLeakInput paramFindLeakInput, List<HeapAnalyzer.ShortestPath> paramList, List<? extends List<HeapAnalyzer.InspectedObject>> paramList1, Map<Long, Pair<Integer, Integer>> paramMap)
  {
    this.a.a(OnAnalysisProgressListener.Step.BUILDING_LEAK_TRACES);
    Map localMap2 = (Map)new LinkedHashMap();
    Map localMap1 = (Map)new LinkedHashMap();
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    Object localObject1;
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramList = (HeapAnalyzer.ShortestPath)paramList;
      localObject1 = a((List)paramList1.get(i), paramMap);
      Object localObject2 = a(paramFindLeakInput, paramList.c(), (List)localObject1);
      localObject2 = new LeakTrace(LeakTrace.GcRootType.Companion.a(paramList.b().b()), (List)localObject2, (LeakTraceObject)CollectionsKt.last((List)localObject1));
      if ((paramList.b() instanceof ReferencePathNode.LibraryLeakNode))
      {
        paramList = (ReferencePathNode.LibraryLeakNode)paramList.b();
      }
      else
      {
        localObject1 = ((Iterable)paramList.c()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramList = ((Iterator)localObject1).next();
          if (((ReferencePathNode.ChildNode)paramList instanceof ReferencePathNode.LibraryLeakNode)) {
            break label213;
          }
        }
        paramList = null;
        label213:
        paramList = (ReferencePathNode.LibraryLeakNode)paramList;
      }
      String str;
      if (paramList != null)
      {
        LibraryLeakReferenceMatcher localLibraryLeakReferenceMatcher = paramList.f();
        str = StringsKt.a(localLibraryLeakReferenceMatcher.a().toString());
        localObject1 = localMap1.get(str);
        paramList = (List<HeapAnalyzer.ShortestPath>)localObject1;
        if (localObject1 == null)
        {
          paramList = TuplesKt.to(localLibraryLeakReferenceMatcher, (List)new ArrayList());
          localMap1.put(str, paramList);
        }
        ((Collection)((Pair)paramList).getSecond()).add(localObject2);
      }
      else
      {
        str = ((LeakTrace)localObject2).getSignature();
        localObject1 = localMap2.get(str);
        paramList = (List<HeapAnalyzer.ShortestPath>)localObject1;
        if (localObject1 == null)
        {
          paramList = (List)new ArrayList();
          localMap2.put(str, paramList);
        }
        ((Collection)paramList).add(localObject2);
      }
      i += 1;
    }
    paramFindLeakInput = (Collection)new ArrayList(localMap2.size());
    paramList = localMap2.entrySet().iterator();
    while (paramList.hasNext()) {
      paramFindLeakInput.add(new ApplicationLeak((List)((Map.Entry)paramList.next()).getValue()));
    }
    paramFindLeakInput = (List)paramFindLeakInput;
    paramList = (Collection)new ArrayList(localMap1.size());
    paramList1 = localMap1.entrySet().iterator();
    while (paramList1.hasNext())
    {
      paramMap = (Pair)((Map.Entry)paramList1.next()).getValue();
      localObject1 = (LibraryLeakReferenceMatcher)paramMap.component1();
      paramList.add(new LibraryLeak((List)paramMap.component2(), ((LibraryLeakReferenceMatcher)localObject1).a(), ((LibraryLeakReferenceMatcher)localObject1).b()));
    }
    return TuplesKt.to(paramFindLeakInput, (List)paramList);
  }
  
  private final Pair<LeakTraceObject.LeakingStatus, String> a(ObjectReporter paramObjectReporter, boolean paramBoolean)
  {
    Object localObject1 = LeakTraceObject.LeakingStatus.UNKNOWN;
    String str;
    if ((((Collection)paramObjectReporter.c()).isEmpty() ^ true))
    {
      localObject1 = LeakTraceObject.LeakingStatus.NOT_LEAKING;
      str = CollectionsKt.joinToString$default((Iterable)paramObjectReporter.c(), (CharSequence)" and ", null, null, 0, null, null, 62, null);
    }
    else
    {
      str = "";
    }
    Set localSet = paramObjectReporter.b();
    Object localObject2 = localObject1;
    paramObjectReporter = str;
    if ((((Collection)localSet).isEmpty() ^ true))
    {
      paramObjectReporter = CollectionsKt.joinToString$default((Iterable)localSet, (CharSequence)" and ", null, null, 0, null, null, 62, null);
      if (localObject1 == LeakTraceObject.LeakingStatus.NOT_LEAKING)
      {
        if (paramBoolean)
        {
          localObject2 = LeakTraceObject.LeakingStatus.LEAKING;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramObjectReporter);
          ((StringBuilder)localObject1).append(". Conflicts with ");
          ((StringBuilder)localObject1).append(str);
          paramObjectReporter = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(". Conflicts with ");
          ((StringBuilder)localObject2).append(paramObjectReporter);
          paramObjectReporter = ((StringBuilder)localObject2).toString();
          localObject2 = localObject1;
        }
      }
      else {
        localObject2 = LeakTraceObject.LeakingStatus.LEAKING;
      }
    }
    return TuplesKt.to(localObject2, paramObjectReporter);
  }
  
  private final HeapAnalysisSuccess a(HeapAnalyzer.FindLeakInput paramFindLeakInput, MetadataExtractor paramMetadataExtractor, LeakingObjectFinder paramLeakingObjectFinder, File paramFile, long paramLong)
  {
    this.a.a(OnAnalysisProgressListener.Step.EXTRACTING_METADATA);
    Object localObject1 = paramMetadataExtractor.a(paramFindLeakInput.a());
    Object localObject2 = (Iterable)KeyedWeakReferenceFinder.a.c(paramFindLeakInput.a());
    paramMetadataExtractor = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      KeyedWeakReferenceMirror localKeyedWeakReferenceMirror = (KeyedWeakReferenceMirror)localObject3;
      if ((localKeyedWeakReferenceMirror.b()) && (!localKeyedWeakReferenceMirror.a())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramMetadataExtractor.add(localObject3);
      }
    }
    int i = ((Collection)paramMetadataExtractor).size();
    paramMetadataExtractor = (MetadataExtractor)localObject1;
    if (i > 0)
    {
      paramMetadataExtractor = new StringBuilder();
      paramMetadataExtractor.append(i);
      paramMetadataExtractor.append(" KeyedWeakReference instances");
      paramMetadataExtractor = MapsKt.plus((Map)localObject1, TuplesKt.to("Count of retained yet cleared", paramMetadataExtractor.toString()));
    }
    this.a.a(OnAnalysisProgressListener.Step.FINDING_RETAINED_OBJECTS);
    localObject1 = a(paramFindLeakInput, paramLeakingObjectFinder.a(paramFindLeakInput.a()));
    paramFindLeakInput = ((HeapAnalyzer.LeaksAndUnreachableObjects)localObject1).a();
    paramLeakingObjectFinder = ((HeapAnalyzer.LeaksAndUnreachableObjects)localObject1).b();
    localObject1 = ((HeapAnalyzer.LeaksAndUnreachableObjects)localObject1).c();
    return new HeapAnalysisSuccess(paramFile, System.currentTimeMillis(), 0L, a(paramLong), paramMetadataExtractor, paramFindLeakInput, paramLeakingObjectFinder, (List)localObject1, 4, null);
  }
  
  private final HeapAnalyzer.LeaksAndUnreachableObjects a(HeapAnalyzer.FindLeakInput paramFindLeakInput, Set<Long> paramSet)
  {
    PathFinder.PathFindingResults localPathFindingResults = new PathFinder(paramFindLeakInput.a(), this.a, paramFindLeakInput.b()).a(paramSet, paramFindLeakInput.c());
    List localList1 = a(paramFindLeakInput, localPathFindingResults, paramSet);
    List localList2 = a(localPathFindingResults.a());
    List localList3 = a(paramFindLeakInput, localList2);
    if (localPathFindingResults.b() != null) {
      paramSet = a(paramFindLeakInput, localList3, localPathFindingResults.b());
    } else {
      paramSet = null;
    }
    paramFindLeakInput = a(paramFindLeakInput, localList2, localList3, paramSet);
    return new HeapAnalyzer.LeaksAndUnreachableObjects((List)paramFindLeakInput.component1(), (List)paramFindLeakInput.component2(), localList1);
  }
  
  private final void a(HeapAnalyzer.TrieNode.ParentNode paramParentNode, List<ReferencePathNode> paramList)
  {
    paramParentNode = ((Iterable)paramParentNode.a().values()).iterator();
    while (paramParentNode.hasNext())
    {
      HeapAnalyzer.TrieNode localTrieNode = (HeapAnalyzer.TrieNode)paramParentNode.next();
      if ((localTrieNode instanceof HeapAnalyzer.TrieNode.ParentNode)) {
        a((HeapAnalyzer.TrieNode.ParentNode)localTrieNode, paramList);
      } else if ((localTrieNode instanceof HeapAnalyzer.TrieNode.LeafNode)) {
        ((Collection)paramList).add(((HeapAnalyzer.TrieNode.LeafNode)localTrieNode).a());
      }
    }
  }
  
  private final void a(ReferencePathNode paramReferencePathNode, List<Long> paramList, int paramInt, HeapAnalyzer.TrieNode.ParentNode paramParentNode)
  {
    long l = ((Number)paramList.get(paramInt)).longValue();
    if (paramInt == CollectionsKt.getLastIndex(paramList))
    {
      paramParentNode.a().put(Long.valueOf(l), new HeapAnalyzer.TrieNode.LeafNode(l, paramReferencePathNode));
      return;
    }
    HeapAnalyzer.TrieNode localTrieNode = (HeapAnalyzer.TrieNode)paramParentNode.a().get(Long.valueOf(l));
    if (localTrieNode != null) {
      paramParentNode = localTrieNode;
    } else {
      paramParentNode = (HeapAnalyzer.TrieNode)((Function0)new HeapAnalyzer.updateTrie.childNode.1(l, paramParentNode)).invoke();
    }
    if ((paramParentNode instanceof HeapAnalyzer.TrieNode.ParentNode)) {
      a(paramReferencePathNode, paramList, paramInt + 1, (HeapAnalyzer.TrieNode.ParentNode)paramParentNode);
    }
  }
  
  private final List<HeapAnalyzer.InspectedObject> b(List<ObjectReporter> paramList)
  {
    int m = paramList.size() - 1;
    Object localObject4 = new Ref.IntRef();
    ((Ref.IntRef)localObject4).element = -1;
    Object localObject2 = new Ref.IntRef();
    ((Ref.IntRef)localObject2).element = m;
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = (Iterable)paramList;
    Object localObject5 = ((Iterable)localObject3).iterator();
    int i = 0;
    Object localObject6;
    while (((Iterator)localObject5).hasNext())
    {
      paramList = (ObjectReporter)((Iterator)localObject5).next();
      boolean bool;
      if (i == m) {
        bool = true;
      } else {
        bool = false;
      }
      localObject1 = a(paramList, bool);
      paramList = (List<ObjectReporter>)localObject1;
      if (i == m)
      {
        paramList = (LeakTraceObject.LeakingStatus)((Pair)localObject1).getFirst();
        j = HeapAnalyzer.WhenMappings.$EnumSwitchMapping$1[paramList.ordinal()];
        paramList = (List<ObjectReporter>)localObject1;
        if (j != 1) {
          if (j != 2)
          {
            if (j == 3)
            {
              paramList = LeakTraceObject.LeakingStatus.LEAKING;
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("This is the leaking object. Conflicts with ");
              ((StringBuilder)localObject6).append((String)((Pair)localObject1).getSecond());
              paramList = TuplesKt.to(paramList, ((StringBuilder)localObject6).toString());
            }
            else
            {
              throw new NoWhenBranchMatchedException();
            }
          }
          else {
            paramList = TuplesKt.to(LeakTraceObject.LeakingStatus.LEAKING, "This is the leaking object");
          }
        }
      }
      localArrayList.add(paramList);
      paramList = (LeakTraceObject.LeakingStatus)paramList.component1();
      if (paramList == LeakTraceObject.LeakingStatus.NOT_LEAKING)
      {
        ((Ref.IntRef)localObject4).element = i;
        ((Ref.IntRef)localObject2).element = m;
      }
      else if ((paramList == LeakTraceObject.LeakingStatus.LEAKING) && (((Ref.IntRef)localObject2).element == m))
      {
        ((Ref.IntRef)localObject2).element = i;
      }
      i += 1;
    }
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    Object localObject1 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(StringsKt.a(a(((ObjectReporter)((Iterator)localObject1).next()).d()), '.'));
    }
    localObject1 = (List)paramList;
    int n = ((Ref.IntRef)localObject4).element;
    i = 0;
    int k;
    if (i < n)
    {
      paramList = (Pair)localArrayList.get(i);
      localObject6 = (LeakTraceObject.LeakingStatus)paramList.component1();
      paramList = (String)paramList.component2();
      k = i + 1;
      localObject5 = SequencesKt.generateSequence(Integer.valueOf(k), (Function1)new HeapAnalyzer.computeLeakStatuses.nextNotLeakingIndex.1((Ref.IntRef)localObject4)).iterator();
      for (;;)
      {
        if (!((Iterator)localObject5).hasNext()) {
          break label710;
        }
        Object localObject7 = (Number)((Iterator)localObject5).next();
        if ((LeakTraceObject.LeakingStatus)((Pair)localArrayList.get(((Number)localObject7).intValue())).getFirst() == LeakTraceObject.LeakingStatus.NOT_LEAKING) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          localObject5 = (String)((List)localObject1).get(((Number)localObject7).intValue());
          j = HeapAnalyzer.WhenMappings.$EnumSwitchMapping$2[localObject6.ordinal()];
          if (j != 1)
          {
            if (j != 2)
            {
              if (j == 3)
              {
                localObject6 = LeakTraceObject.LeakingStatus.NOT_LEAKING;
                localObject7 = new StringBuilder();
                ((StringBuilder)localObject7).append((String)localObject5);
                ((StringBuilder)localObject7).append("↓ is not leaking. Conflicts with ");
                ((StringBuilder)localObject7).append(paramList);
                paramList = TuplesKt.to(localObject6, ((StringBuilder)localObject7).toString());
              }
              else
              {
                throw new NoWhenBranchMatchedException();
              }
            }
            else
            {
              localObject6 = LeakTraceObject.LeakingStatus.NOT_LEAKING;
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append((String)localObject5);
              ((StringBuilder)localObject7).append("↓ is not leaking and ");
              ((StringBuilder)localObject7).append(paramList);
              paramList = TuplesKt.to(localObject6, ((StringBuilder)localObject7).toString());
            }
          }
          else
          {
            paramList = LeakTraceObject.LeakingStatus.NOT_LEAKING;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append((String)localObject5);
            ((StringBuilder)localObject6).append("↓ is not leaking");
            paramList = TuplesKt.to(paramList, ((StringBuilder)localObject6).toString());
          }
          localArrayList.set(i, paramList);
          i = k;
          break;
        }
      }
      label710:
      throw ((Throwable)new NoSuchElementException("Sequence contains no element matching the predicate."));
    }
    int j = ((Ref.IntRef)localObject2).element;
    i = m - 1;
    if (j < i)
    {
      k = ((Ref.IntRef)localObject2).element + 1;
      if (i >= k)
      {
        for (;;)
        {
          paramList = (Pair)localArrayList.get(i);
          localObject5 = (LeakTraceObject.LeakingStatus)paramList.component1();
          paramList = (String)paramList.component2();
          localObject4 = SequencesKt.generateSequence(Integer.valueOf(i - 1), (Function1)new HeapAnalyzer.computeLeakStatuses.previousLeakingIndex.1((Ref.IntRef)localObject2)).iterator();
          do
          {
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject6 = (Number)((Iterator)localObject4).next();
            if ((LeakTraceObject.LeakingStatus)((Pair)localArrayList.get(((Number)localObject6).intValue())).getFirst() == LeakTraceObject.LeakingStatus.LEAKING) {
              j = 1;
            } else {
              j = 0;
            }
          } while (j == 0);
          localObject4 = (String)((List)localObject1).get(((Number)localObject6).intValue());
          j = HeapAnalyzer.WhenMappings.$EnumSwitchMapping$3[localObject5.ordinal()];
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3) {
                throw new NoWhenBranchMatchedException();
              }
              throw ((Throwable)new IllegalStateException("Should never happen"));
            }
            localObject5 = LeakTraceObject.LeakingStatus.LEAKING;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append((String)localObject4);
            ((StringBuilder)localObject6).append("↑ is leaking and ");
            ((StringBuilder)localObject6).append(paramList);
            paramList = TuplesKt.to(localObject5, ((StringBuilder)localObject6).toString());
          }
          else
          {
            paramList = LeakTraceObject.LeakingStatus.LEAKING;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append((String)localObject4);
            ((StringBuilder)localObject5).append("↑ is leaking");
            paramList = TuplesKt.to(paramList, ((StringBuilder)localObject5).toString());
          }
          localArrayList.set(i, paramList);
          if (i == k) {
            break label1059;
          }
          i -= 1;
        }
        throw ((Throwable)new NoSuchElementException("Sequence contains no element matching the predicate."));
      }
    }
    label1059:
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject1 = ((Iterable)localObject3).iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = (ObjectReporter)localObject2;
      localObject4 = (Pair)localArrayList.get(i);
      localObject3 = (LeakTraceObject.LeakingStatus)((Pair)localObject4).component1();
      localObject4 = (String)((Pair)localObject4).component2();
      paramList.add(new HeapAnalyzer.InspectedObject(((ObjectReporter)localObject2).d(), (LeakTraceObject.LeakingStatus)localObject3, (String)localObject4, (Set)((ObjectReporter)localObject2).a()));
      i += 1;
    }
    return (List)paramList;
  }
  
  @NotNull
  public final HeapAnalysis a(@NotNull File paramFile, @NotNull HeapGraph paramHeapGraph, @NotNull LeakingObjectFinder paramLeakingObjectFinder, @NotNull List<? extends ReferenceMatcher> paramList, boolean paramBoolean, @NotNull List<? extends ObjectInspector> paramList1, @NotNull MetadataExtractor paramMetadataExtractor)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "heapDumpFile");
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "graph");
    Intrinsics.checkParameterIsNotNull(paramLeakingObjectFinder, "leakingObjectFinder");
    Intrinsics.checkParameterIsNotNull(paramList, "referenceMatchers");
    Intrinsics.checkParameterIsNotNull(paramList1, "objectInspectors");
    Intrinsics.checkParameterIsNotNull(paramMetadataExtractor, "metadataExtractor");
    long l = System.nanoTime();
    try
    {
      paramHeapGraph = (HeapAnalysis)a(new HeapAnalyzer.FindLeakInput(paramHeapGraph, paramList, paramBoolean, paramList1), paramMetadataExtractor, paramLeakingObjectFinder, paramFile, l);
      return paramHeapGraph;
    }
    catch (Throwable paramHeapGraph) {}
    return (HeapAnalysis)new HeapAnalysisFailure(paramFile, System.currentTimeMillis(), 0L, a(l), new HeapAnalysisException(paramHeapGraph), 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer
 * JD-Core Version:    0.7.0.1
 */