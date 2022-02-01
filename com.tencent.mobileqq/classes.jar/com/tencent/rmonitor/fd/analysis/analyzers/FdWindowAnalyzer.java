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

public class FdWindowAnalyzer
  extends BaseFdHeapAnalyzer
{
  private Set<Long> a(FdHeapData paramFdHeapData, Map<Long, String> paramMap, String paramString)
  {
    paramString = paramFdHeapData.a().a(paramString);
    paramFdHeapData = new HashSet();
    if (paramString == null) {
      return paramFdHeapData;
    }
    paramString = paramString.o().iterator();
    while (paramString.hasNext())
    {
      HeapObject.HeapInstance localHeapInstance = (HeapObject.HeapInstance)paramString.next();
      String str = SharkUtil.b(localHeapInstance, "mTitle");
      long l = localHeapInstance.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/title(");
      localStringBuilder.append(str);
      localStringBuilder.append(")");
      paramMap.put(Long.valueOf(l), localStringBuilder.toString());
      paramFdHeapData.add(Long.valueOf(localHeapInstance.b()));
    }
    return paramFdHeapData;
  }
  
  private void a(HeapGraph paramHeapGraph, Set<Long> paramSet, String paramString1, String paramString2, Map<Long, String> paramMap)
  {
    paramHeapGraph = paramHeapGraph.a(paramString1);
    if (paramHeapGraph == null) {
      return;
    }
    paramHeapGraph = paramHeapGraph.o().iterator();
    while (paramHeapGraph.hasNext())
    {
      Object localObject = (HeapObject.HeapInstance)paramHeapGraph.next();
      HeapObject.HeapInstance localHeapInstance = SharkUtil.c((HeapObject.HeapInstance)localObject, paramString1, paramString2);
      if ((localHeapInstance != null) && (paramSet.contains(Long.valueOf(localHeapInstance.b()))))
      {
        String str = (String)paramMap.get(Long.valueOf(localHeapInstance.b()));
        if (!TextUtils.isEmpty(str))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("/");
          localStringBuilder.append(((HeapObject.HeapInstance)localObject).j());
          localStringBuilder.append(str);
          localObject = localStringBuilder.toString();
          paramMap.put(Long.valueOf(localHeapInstance.b()), localObject);
        }
      }
    }
  }
  
  public String a()
  {
    return "windows";
  }
  
  protected void a(Set<Long> paramSet, Map<Long, String> paramMap1, Map<Long, String> paramMap2, Map<String, Integer> paramMap)
  {
    paramSet = paramMap1.values().iterator();
    while (paramSet.hasNext()) {
      a(paramMap, (String)paramSet.next());
    }
  }
  
  public void c(FdLeakDumpResult paramFdLeakDumpResult)
  {
    HashMap localHashMap = new HashMap();
    paramFdLeakDumpResult = (FdHeapData)paramFdLeakDumpResult.getData();
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(a(paramFdLeakDumpResult, localHashMap, "com.android.internal.policy.PhoneWindow"));
    localHashSet.addAll(a(paramFdLeakDumpResult, localHashMap, "com.android.internal.policy.impl.PhoneWindow"));
    localHashSet.addAll(a(paramFdLeakDumpResult, localHashMap, "com.android.internal.policy.HwPhoneWindow"));
    a(paramFdLeakDumpResult.a(), localHashSet, "android.app.Activity", "mWindow", localHashMap);
    a(paramFdLeakDumpResult.a(), localHashSet, "android.app.Dialog", "mWindow", localHashMap);
    paramFdLeakDumpResult.a(a(), localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.FdWindowAnalyzer
 * JD-Core Version:    0.7.0.1
 */