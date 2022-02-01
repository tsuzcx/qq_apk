package com.tencent.rmonitor.fd.analysis.analyzers;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssue;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.utils.FdLeakUtil;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.util.Collections;
import java.util.Map;

public abstract class BaseFdAnalyzer<T>
  implements IFdLeakAnalyzer
{
  public static boolean b(FdLeakDumpResult paramFdLeakDumpResult)
  {
    if ((paramFdLeakDumpResult != null) && (paramFdLeakDumpResult.isSuccess()) && (paramFdLeakDumpResult.getData() != null)) {
      return true;
    }
    LogUtils.a("BaseFdAnalyzer", "analyze failed due to invalid dump data");
    return false;
  }
  
  public FdLeakIssue a(FdLeakDumpResult paramFdLeakDumpResult)
  {
    if (!b(paramFdLeakDumpResult)) {
      return null;
    }
    FdLeakIssue localFdLeakIssue = new FdLeakIssue(a());
    localFdLeakIssue.setFeatures(FdLeakUtil.a(a(paramFdLeakDumpResult.getData())));
    return localFdLeakIssue;
  }
  
  protected Map<String, Integer> a(T paramT)
  {
    return Collections.emptyMap();
  }
  
  protected void a(Map<String, Integer> paramMap, String paramString)
  {
    Integer localInteger2 = (Integer)paramMap.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf(0);
      paramMap.put(paramString, localInteger1);
    }
    paramMap.put(paramString, Integer.valueOf(localInteger1.intValue() + 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.BaseFdAnalyzer
 * JD-Core Version:    0.7.0.1
 */