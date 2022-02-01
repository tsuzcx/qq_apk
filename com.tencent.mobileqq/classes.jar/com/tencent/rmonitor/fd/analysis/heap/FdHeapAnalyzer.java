package com.tencent.rmonitor.fd.analysis.heap;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.rmonitor.fd.analysis.FdLeakAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.BaseFdAnalyzer;
import com.tencent.rmonitor.fd.analysis.analyzers.BaseFdHeapAnalyzer;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssue;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.dump.data.FdHeapData;
import com.tencent.rmonitor.fd.utils.LogUtils;
import com.tencent.rmonitor.fd.utils.SharkAnalysisUtil;
import com.tencent.rmonitor.fd.utils.SharkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class FdHeapAnalyzer
{
  private FdLeakIssue a(BaseFdHeapAnalyzer paramBaseFdHeapAnalyzer, FdLeakDumpResult paramFdLeakDumpResult, Map<Long, String> paramMap)
  {
    try
    {
      paramFdLeakDumpResult = paramBaseFdHeapAnalyzer.a(paramFdLeakDumpResult, paramMap);
      return paramFdLeakDumpResult;
    }
    catch (Throwable paramFdLeakDumpResult)
    {
      paramMap = new StringBuilder();
      paramMap.append("analyze failed, type=");
      paramMap.append(paramBaseFdHeapAnalyzer.a());
      paramMap.append(": ");
      paramMap.append(paramFdLeakDumpResult.getMessage());
      LogUtils.d("FdHeapAnalyzeHelper", paramMap.toString());
    }
    return null;
  }
  
  private void a(BaseFdHeapAnalyzer paramBaseFdHeapAnalyzer, FdLeakDumpResult paramFdLeakDumpResult)
  {
    try
    {
      paramBaseFdHeapAnalyzer.c(paramFdLeakDumpResult);
      return;
    }
    catch (Throwable paramFdLeakDumpResult)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pre analyze failed, type=");
      localStringBuilder.append(paramBaseFdHeapAnalyzer.a());
      localStringBuilder.append(": ");
      localStringBuilder.append(paramFdLeakDumpResult.getMessage());
      LogUtils.d("FdHeapAnalyzeHelper", localStringBuilder.toString());
    }
  }
  
  private ArrayList<FdLeakIssue> b(FdLeakDumpResult paramFdLeakDumpResult)
  {
    ArrayList localArrayList = new ArrayList();
    if (!BaseFdAnalyzer.b(paramFdLeakDumpResult)) {
      return localArrayList;
    }
    BaseFdHeapAnalyzer[] arrayOfBaseFdHeapAnalyzer = FdLeakAnalyzer.a();
    int k = arrayOfBaseFdHeapAnalyzer.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      a(arrayOfBaseFdHeapAnalyzer[i], paramFdLeakDumpResult);
      i += 1;
    }
    Object localObject = (FdHeapData)paramFdLeakDumpResult.getData();
    localObject = SharkAnalysisUtil.a(((FdHeapData)localObject).a(), ((FdHeapData)localObject).b());
    k = arrayOfBaseFdHeapAnalyzer.length;
    i = j;
    while (i < k)
    {
      FdLeakIssue localFdLeakIssue = a(arrayOfBaseFdHeapAnalyzer[i], paramFdLeakDumpResult, (Map)localObject);
      if (localFdLeakIssue != null) {
        localArrayList.add(localFdLeakIssue);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnalyzeFinished: ");
      localStringBuilder.append(localFdLeakIssue);
      LogUtils.a("FdHeapAnalyzeHelper", localStringBuilder.toString());
      i += 1;
    }
    return localArrayList;
  }
  
  public FdHeapData a(FdLeakDumpResult paramFdLeakDumpResult)
  {
    try
    {
      FdHeapData localFdHeapData = SharkUtil.a(new File(paramFdLeakDumpResult.getDumpFilePath()));
      return localFdHeapData;
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse hprof failed due to exception: ");
      localStringBuilder.append(localThrowable.getMessage());
      LogUtils.d("FdHeapAnalyzeHelper", localStringBuilder.toString());
      paramFdLeakDumpResult.setErrorCode(6);
      paramFdLeakDumpResult.setErrorMessage(localThrowable.getMessage());
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse hprof failed due to OOM: ");
      localStringBuilder.append(localOutOfMemoryError.getMessage());
      LogUtils.d("FdHeapAnalyzeHelper", localStringBuilder.toString());
      paramFdLeakDumpResult.setErrorCode(7);
      paramFdLeakDumpResult.setErrorMessage(localOutOfMemoryError.getMessage());
    }
    return null;
  }
  
  public void a(FdLeakDumpResult paramFdLeakDumpResult, ResultReceiver paramResultReceiver)
  {
    if (paramResultReceiver == null)
    {
      LogUtils.d("FdHeapAnalyzeHelper", "onHandleIntent, result receiver is null.");
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramFdLeakDumpResult == null)
    {
      LogUtils.d("FdHeapAnalyzeHelper", "onHandleIntent, result is null.");
      paramResultReceiver.send(8, localBundle);
      return;
    }
    LogUtils.a("FdHeapAnalyzeHelper", "runAnalysis.");
    FdHeapData localFdHeapData = a(paramFdLeakDumpResult);
    paramFdLeakDumpResult.setData(localFdHeapData);
    localBundle.putString("key_analyze_error_message", paramFdLeakDumpResult.getErrorMessage());
    if (localFdHeapData == null)
    {
      paramResultReceiver.send(paramFdLeakDumpResult.getErrorCode(), localBundle);
      return;
    }
    localBundle.putSerializable("key_analyze_result", b(paramFdLeakDumpResult));
    paramResultReceiver.send(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.heap.FdHeapAnalyzer
 * JD-Core Version:    0.7.0.1
 */