package com.tencent.rmonitor.fd.analysis.analyzers;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssue;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.dump.data.FdHeapData;
import com.tencent.rmonitor.fd.utils.FdLeakUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class BaseFdHeapAnalyzer
  extends BaseFdAnalyzer<FdHeapData>
{
  public FdLeakIssue a(FdLeakDumpResult paramFdLeakDumpResult, Map<Long, String> paramMap)
  {
    paramFdLeakDumpResult = (FdHeapData)paramFdLeakDumpResult.getData();
    Map localMap = paramFdLeakDumpResult.b(a());
    FdLeakIssue localFdLeakIssue = new FdLeakIssue(a());
    if (localMap != null)
    {
      HashMap localHashMap = new HashMap();
      a(paramFdLeakDumpResult.a(a()), localMap, paramMap, localHashMap);
      localFdLeakIssue.setFeatures(FdLeakUtil.a(localHashMap));
    }
    return localFdLeakIssue;
  }
  
  protected abstract void a(Set<Long> paramSet, Map<Long, String> paramMap1, Map<Long, String> paramMap2, Map<String, Integer> paramMap);
  
  public abstract void c(FdLeakDumpResult paramFdLeakDumpResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.BaseFdHeapAnalyzer
 * JD-Core Version:    0.7.0.1
 */