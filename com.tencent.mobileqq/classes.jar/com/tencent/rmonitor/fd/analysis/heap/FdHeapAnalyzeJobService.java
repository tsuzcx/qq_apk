package com.tencent.rmonitor.fd.analysis.heap;

import android.app.Application;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.utils.LogUtils;

@RequiresApi(api=21)
public class FdHeapAnalyzeJobService
  extends JobService
{
  private final Handler a = new Handler(ThreadManager.e());
  
  private void a(FdLeakDumpResult paramFdLeakDumpResult, ResultReceiver paramResultReceiver)
  {
    try
    {
      new FdHeapAnalyzer().a(paramFdLeakDumpResult, paramResultReceiver);
      return;
    }
    catch (Throwable paramFdLeakDumpResult)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doHeapAnalyze exception: ");
      ((StringBuilder)localObject).append(paramFdLeakDumpResult.getMessage());
      LogUtils.d("FdHeapAnalyzeJobService", ((StringBuilder)localObject).toString());
      if (paramResultReceiver != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_analyze_error_message", paramFdLeakDumpResult.getMessage());
        paramResultReceiver.send(10, (Bundle)localObject);
      }
    }
  }
  
  @RequiresApi(api=26)
  public static boolean a(Application paramApplication, FdLeakDumpResult paramFdLeakDumpResult, IFdHeapAnalyzeListener paramIFdHeapAnalyzeListener)
  {
    if (paramApplication == null) {
      return false;
    }
    JobInfo.Builder localBuilder = new JobInfo.Builder(1, new ComponentName(paramApplication, FdHeapAnalyzeJobService.class));
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_hprof_data", paramFdLeakDumpResult);
    localBundle.putParcelable("key_result_receiver", new FdHeapAnalyzeResultReceiver(paramIFdHeapAnalyzeListener));
    localBuilder.setMinimumLatency(0L).setOverrideDeadline(5000L).setTransientExtras(localBundle);
    int i = ((JobScheduler)paramApplication.getSystemService("jobscheduler")).schedule(localBuilder.build());
    if (i <= 0)
    {
      paramApplication = new StringBuilder();
      paramApplication.append("Schedule heap analyze failed, result is ");
      paramApplication.append(i);
      paramApplication.append(" ");
      paramApplication.append(paramFdLeakDumpResult);
      LogUtils.d("FdHeapAnalyzeJobService", paramApplication.toString());
      return false;
    }
    return true;
  }
  
  @RequiresApi(api=26)
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    Log.i("FdHeapAnalyzeJobService", "onStartJob");
    Object localObject = paramJobParameters.getTransientExtras();
    if (localObject == null) {
      return true;
    }
    try
    {
      ((Bundle)localObject).setClassLoader(FdHeapAnalyzeResultReceiver.class.getClassLoader());
      paramJobParameters = (ResultReceiver)((Bundle)localObject).getParcelable("key_result_receiver");
      try
      {
        localObject = (FdLeakDumpResult)((Bundle)localObject).getSerializable("key_hprof_data");
        this.a.post(new FdHeapAnalyzeJobService.1(this, (FdLeakDumpResult)localObject, paramJobParameters));
        return true;
      }
      catch (Throwable localThrowable1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      paramJobParameters = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("onStartJob exception: ");
    localStringBuilder.append(localThrowable2.getMessage());
    LogUtils.d("FdHeapAnalyzeJobService", localStringBuilder.toString());
    if (paramJobParameters != null) {
      paramJobParameters.send(10, new Bundle());
    }
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    LogUtils.a("FdHeapAnalyzeJobService", "onStopJob.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.heap.FdHeapAnalyzeJobService
 * JD-Core Version:    0.7.0.1
 */