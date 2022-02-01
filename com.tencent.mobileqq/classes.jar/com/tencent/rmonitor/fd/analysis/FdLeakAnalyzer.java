package com.tencent.rmonitor.fd.analysis;

import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.fd.FdLeakConfigHelper;
import com.tencent.rmonitor.fd.analysis.analyzers.BaseFdHeapAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.FdCursorAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.FdEventFdAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.FdFileIoAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.FdOtherAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.FdSocketAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.FdWindowAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.IFdLeakAnalyzer;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssue;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.analysis.heap.FdHeapAnalyzeService;
import com.tencent.rmonitor.fd.analysis.heap.IFdHeapAnalyzeListener;
import com.tencent.rmonitor.fd.dump.FdLeakDumpHelper;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FdLeakAnalyzer
{
  private static final Map<Integer, IFdLeakAnalyzer[]> a = new HashMap();
  private static final BaseFdHeapAnalyzer[] b = { new FdCursorAnalyzer(), new FdWindowAnalyzer(), new FdSocketAnalyzer() };
  
  static
  {
    a.put(Integer.valueOf(1), new IFdLeakAnalyzer[] { new FdFileIoAnalyzer(), new FdOtherAnalyzer() });
    a.put(Integer.valueOf(2), new IFdLeakAnalyzer[] { new FdEventFdAnalyzer() });
  }
  
  private void a(IFdLeakAnalyzer paramIFdLeakAnalyzer, FdLeakIssueResult paramFdLeakIssueResult, FdLeakDumpResult paramFdLeakDumpResult)
  {
    a(paramFdLeakIssueResult, paramIFdLeakAnalyzer.a(paramFdLeakDumpResult));
  }
  
  private void a(FdLeakIssueResult paramFdLeakIssueResult, FdLeakIssue paramFdLeakIssue)
  {
    if (paramFdLeakIssue != null) {
      paramFdLeakIssueResult.addAnalyzeData(paramFdLeakIssue.getIssueType(), paramFdLeakIssue.getFeatures());
    }
  }
  
  private void a(List<FdLeakDumpResult> paramList, FdLeakIssueResult paramFdLeakIssueResult, IFdAnalyzeListener paramIFdAnalyzeListener)
  {
    FdLeakDumpResult localFdLeakDumpResult = FdLeakDumpHelper.a(3, paramIFdAnalyzeListener);
    paramList.add(localFdLeakDumpResult);
    if ((localFdLeakDumpResult.isSuccess()) && (!TextUtils.isEmpty(localFdLeakDumpResult.getDumpFilePath())))
    {
      paramList = new FdLeakAnalyzer.1(this, paramFdLeakIssueResult, paramIFdAnalyzeListener);
      if (!a(localFdLeakDumpResult, paramList))
      {
        LogUtils.c("FdLeakAnalyzer", "startHeapAnalysisService failed.");
        paramList.a(9, "", Collections.emptyList());
      }
      return;
    }
    if (paramIFdAnalyzeListener != null) {
      paramIFdAnalyzeListener.a(paramFdLeakIssueResult);
    }
  }
  
  private boolean a(FdLeakDumpResult paramFdLeakDumpResult, IFdHeapAnalyzeListener paramIFdHeapAnalyzeListener)
  {
    return FdHeapAnalyzeService.a(BaseInfo.app, paramFdLeakDumpResult, paramIFdHeapAnalyzeListener);
  }
  
  public static BaseFdHeapAnalyzer[] a()
  {
    return b;
  }
  
  public static IFdLeakAnalyzer[] a(int paramInt)
  {
    return (IFdLeakAnalyzer[])a.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, FdLeakDumpResult paramFdLeakDumpResult, IFdAnalyzeListener paramIFdAnalyzeListener)
  {
    if (paramIFdAnalyzeListener != null) {
      paramIFdAnalyzeListener.b();
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFdLeakDumpResult);
    FdLeakIssueResult localFdLeakIssueResult = new FdLeakIssueResult(paramInt1, paramInt2);
    localFdLeakIssueResult.setFdDumpList(localArrayList);
    boolean bool = paramFdLeakDumpResult.isSuccess();
    paramInt2 = 0;
    IFdLeakAnalyzer[] arrayOfIFdLeakAnalyzer;
    int i;
    if (bool)
    {
      arrayOfIFdLeakAnalyzer = a(1);
      i = arrayOfIFdLeakAnalyzer.length;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        a(arrayOfIFdLeakAnalyzer[paramInt1], localFdLeakIssueResult, paramFdLeakDumpResult);
        paramInt1 += 1;
      }
    }
    paramFdLeakDumpResult = FdLeakDumpHelper.a(2, paramIFdAnalyzeListener);
    localArrayList.add(paramFdLeakDumpResult);
    if (paramFdLeakDumpResult.isSuccess())
    {
      arrayOfIFdLeakAnalyzer = a(2);
      i = arrayOfIFdLeakAnalyzer.length;
      paramInt1 = paramInt2;
      while (paramInt1 < i)
      {
        a(arrayOfIFdLeakAnalyzer[paramInt1], localFdLeakIssueResult, paramFdLeakDumpResult);
        paramInt1 += 1;
      }
    }
    if (FdLeakConfigHelper.c()) {
      localArrayList.add(FdLeakDumpHelper.a(4, paramIFdAnalyzeListener));
    }
    a(localArrayList, localFdLeakIssueResult, paramIFdAnalyzeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.FdLeakAnalyzer
 * JD-Core Version:    0.7.0.1
 */