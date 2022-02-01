package com.tencent.rmonitor.fd.analysis.analyzers;

import android.text.TextUtils;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.dump.data.FdHeapData;
import com.tencent.rmonitor.fd.utils.SharkUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.sequences.Sequence;
import shark.HeapGraph;
import shark.HeapObject.HeapClass;
import shark.HeapObject.HeapInstance;

public class FdCursorAnalyzer
  extends BaseFdHeapAnalyzer
{
  private Set<Long> a(HeapGraph paramHeapGraph, Map<Long, String> paramMap)
  {
    paramHeapGraph = paramHeapGraph.a("android.database.sqlite.SQLiteCursor");
    HashSet localHashSet = new HashSet();
    if (paramHeapGraph == null) {
      return localHashSet;
    }
    Iterator localIterator = paramHeapGraph.o().iterator();
    while (localIterator.hasNext())
    {
      HeapObject.HeapInstance localHeapInstance = (HeapObject.HeapInstance)localIterator.next();
      Object localObject = SharkUtil.b(localHeapInstance, "android.database.sqlite.SQLiteCursor", "mEditTable");
      paramHeapGraph = (HeapGraph)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramHeapGraph = "default_table";
      }
      localObject = SharkUtil.c(localHeapInstance, "android.database.AbstractWindowedCursor", "mWindow");
      if (localObject != null)
      {
        paramHeapGraph = String.format("/DbPaths%s/table:%s", new Object[] { SharkUtil.b((HeapObject.HeapInstance)localObject, "android.database.CursorWindow", "mName"), paramHeapGraph });
        paramMap.put(Long.valueOf(localHeapInstance.b()), paramHeapGraph);
        localHashSet.add(Long.valueOf(localHeapInstance.b()));
      }
    }
    return localHashSet;
  }
  
  public String a()
  {
    return "cursors";
  }
  
  protected void a(Set<Long> paramSet, Map<Long, String> paramMap1, Map<Long, String> paramMap2, Map<String, Integer> paramMap)
  {
    paramMap1 = paramMap1.values().iterator();
    while (paramMap1.hasNext()) {
      a(paramMap, (String)paramMap1.next());
    }
    paramMap1 = paramMap2.keySet().iterator();
    while (paramMap1.hasNext())
    {
      Long localLong = (Long)paramMap1.next();
      if (paramSet.contains(localLong))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/ObjectPaths");
        localStringBuilder.append((String)paramMap2.get(localLong));
        a(paramMap, localStringBuilder.toString());
      }
    }
  }
  
  public void c(FdLeakDumpResult paramFdLeakDumpResult)
  {
    HashMap localHashMap = new HashMap();
    paramFdLeakDumpResult = (FdHeapData)paramFdLeakDumpResult.getData();
    Set localSet = a(paramFdLeakDumpResult.a(), localHashMap);
    paramFdLeakDumpResult.a(a(), localSet);
    paramFdLeakDumpResult.a(a(), localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.FdCursorAnalyzer
 * JD-Core Version:    0.7.0.1
 */