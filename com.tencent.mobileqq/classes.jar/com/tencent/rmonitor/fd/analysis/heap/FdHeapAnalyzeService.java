package com.tencent.rmonitor.fd.analysis.heap;

import android.app.Application;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.utils.LogUtils;
import org.jetbrains.annotations.Nullable;

public class FdHeapAnalyzeService
  extends IntentService
{
  public FdHeapAnalyzeService()
  {
    super("FdAnalyzeService");
  }
  
  public static boolean a(Application paramApplication, FdLeakDumpResult paramFdLeakDumpResult, IFdHeapAnalyzeListener paramIFdHeapAnalyzeListener)
  {
    if (paramApplication == null) {
      return false;
    }
    Intent localIntent = new Intent(paramApplication, FdHeapAnalyzeService.class);
    localIntent.putExtra("key_hprof_data", paramFdLeakDumpResult);
    localIntent.putExtra("key_result_receiver", new FdHeapAnalyzeResultReceiver(paramIFdHeapAnalyzeListener));
    try
    {
      paramApplication.startService(localIntent);
      LogUtils.a("FdAnalyzeService", "start FdHeapAnalyzeService success.");
      return true;
    }
    catch (Throwable localThrowable)
    {
      if (AndroidVersion.e())
      {
        LogUtils.b("FdAnalyzeService", "start FdHeapAnalyzeService failed, start FdHeapAnalyzeJobService instead.");
        return FdHeapAnalyzeJobService.a(paramApplication, paramFdLeakDumpResult, paramIFdHeapAnalyzeListener);
      }
      paramApplication = new StringBuilder();
      paramApplication.append("start FdHeapAnalyzeService failed: ");
      paramApplication.append(localThrowable.getMessage());
      LogUtils.d("FdAnalyzeService", paramApplication.toString());
    }
    return false;
  }
  
  protected void onHandleIntent(@Nullable Intent paramIntent)
  {
    LogUtils.a("FdAnalyzeService", "onHandleIntent.");
    if (paramIntent == null) {
      return;
    }
    try
    {
      Object localObject1 = (ResultReceiver)paramIntent.getParcelableExtra("key_result_receiver");
      try
      {
        paramIntent = (FdLeakDumpResult)paramIntent.getSerializableExtra("key_hprof_data");
        new FdHeapAnalyzer().a(paramIntent, (ResultReceiver)localObject1);
        return;
      }
      catch (Throwable localThrowable2)
      {
        paramIntent = (Intent)localObject1;
        localObject1 = localThrowable2;
      }
      localObject2 = new StringBuilder();
    }
    catch (Throwable localThrowable1)
    {
      paramIntent = null;
    }
    Object localObject2;
    ((StringBuilder)localObject2).append("onHandleIntent exception: ");
    ((StringBuilder)localObject2).append(localThrowable1.getMessage());
    LogUtils.d("FdAnalyzeService", ((StringBuilder)localObject2).toString());
    if (paramIntent != null)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_analyze_error_message", localThrowable1.getMessage());
      paramIntent.send(10, (Bundle)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.heap.FdHeapAnalyzeService
 * JD-Core Version:    0.7.0.1
 */