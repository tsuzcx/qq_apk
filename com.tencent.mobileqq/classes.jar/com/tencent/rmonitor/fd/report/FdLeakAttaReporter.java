package com.tencent.rmonitor.fd.report;

import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.common.lifecycle.ActivityInfo;
import com.tencent.rmonitor.fd.FdLeakConfigHelper;
import com.tencent.rmonitor.fd.IFdLeakListener;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.dump.dumpers.FdProcFdDumper;
import com.tencent.rmonitor.memory.MemoryUtils;
import com.tencent.rmonitor.sla.AttaParam;
import com.tencent.rmonitor.sla.AttaReporter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class FdLeakAttaReporter
  implements IReporter.ReportCallback, IFdLeakListener
{
  private final String a;
  
  public FdLeakAttaReporter()
  {
    this("");
  }
  
  public FdLeakAttaReporter(String paramString)
  {
    this.a = paramString;
  }
  
  public static void a(int paramInt, boolean paramBoolean, String paramString)
  {
    a(new String[] { "fd_heap_dump_fail", String.valueOf(paramInt), String.valueOf(paramBoolean), paramString });
  }
  
  public static void a(String paramString)
  {
    a(new String[] { "fd_upload_start", paramString });
  }
  
  public static void a(String... paramVarArgs)
  {
    if (!FdLeakConfigHelper.d()) {
      return;
    }
    AttaParam localAttaParam = new AttaParam("RMFdLeakEvent");
    int j = Math.min(paramVarArgs.length, 10);
    int i = 0;
    while (i < j)
    {
      localAttaParam.a(i, paramVarArgs[i]);
      i += 1;
    }
    AttaReporter.a().a(localAttaParam);
  }
  
  public static void b(int paramInt)
  {
    a(new String[] { "fd_monitor_start", String.valueOf(paramInt) });
  }
  
  public void a()
  {
    a(new String[] { "fd_upload_result", this.a, String.valueOf(810), "" });
  }
  
  public void a(int paramInt)
  {
    a(new String[] { "fd_dump_start", String.valueOf(paramInt) });
  }
  
  public void a(int paramInt, FdLeakDumpResult paramFdLeakDumpResult)
  {
    if (paramInt == 3)
    {
      a(new String[] { "fd_dump_finish", String.valueOf(paramFdLeakDumpResult.getDumpType()), String.valueOf(paramFdLeakDumpResult.getErrorCode()), paramFdLeakDumpResult.getErrorMessage(), String.valueOf(paramFdLeakDumpResult.getDumpDurationMillis()), String.valueOf(MemoryUtils.b()) });
      return;
    }
    a(new String[] { "fd_dump_finish", String.valueOf(paramFdLeakDumpResult.getDumpType()), String.valueOf(paramFdLeakDumpResult.getErrorCode()), paramFdLeakDumpResult.getErrorMessage() });
  }
  
  public void a(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    a(new String[] { "fd_upload_result", this.a, String.valueOf(paramInt1), paramString });
  }
  
  public void a(FdLeakIssueResult paramFdLeakIssueResult)
  {
    a(new String[] { "fd_analyze_finish", String.valueOf(paramFdLeakIssueResult.getFdType()), String.valueOf(paramFdLeakIssueResult.getErrorCode()), paramFdLeakIssueResult.getErrorMessage() });
    if (paramFdLeakIssueResult.isSuccess())
    {
      Map localMap = paramFdLeakIssueResult.getFdAnalyzeResult();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        List localList = (List)localMap.get(str);
        if (localList != null)
        {
          int i = 10;
          if (localList.size() < 10) {
            i = localList.size();
          }
          localMap.put(str, localList.subList(0, i));
        }
      }
      a(new String[] { "fd_analyze_result", FdProcFdDumper.b(paramFdLeakIssueResult.getFdType()), String.valueOf(paramFdLeakIssueResult.getFdCount()), ActivityInfo.a(), "", "", "", paramFdLeakIssueResult.toJsonObject().toString() });
    }
  }
  
  public void b()
  {
    a(new String[] { "fd_analyze_start" });
  }
  
  public void dI_() {}
  
  public void t_(int paramInt)
  {
    a(new String[] { "fd_upload_result", this.a, String.valueOf(0), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.report.FdLeakAttaReporter
 * JD-Core Version:    0.7.0.1
 */