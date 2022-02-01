package com.tribe.async.async;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class BossImp
  implements Boss, MonitorThreadPoolExecutor.ThreadPoolMonitorListener
{
  private static final String CPU_EXECUTOR_NAME = "cpu";
  private static final String DISK_READ_EXECUTOR_NAME = "disk_read";
  private static final String DISK_WRITE_EXECUTOR_NAME = "disk_write";
  private static final int EXECUTOR_SIZE = 4;
  private static final String NETWORK_EXECUTOR_NAME = "network";
  private static final String TAG = "async.boss.BossImp";
  private final Context mContext;
  private final ExecutorConfig mCpuConfig = new ExecutorConfig.CpuExecutorConfig();
  private final MonitorThreadPoolExecutor mCpuExecutor;
  private final MonitorThreadPoolExecutor mDiskReadExecutor;
  private final MonitorThreadPoolExecutor mDiskWriteExecutor;
  private final MonitorThreadPoolExecutor[] mExecutors = new MonitorThreadPoolExecutor[4];
  private Handler mHandler;
  private final JobController mJobController;
  private final LightWeightExecutor mLightWeightExecutor;
  private Looper mLooper;
  private final ExecutorConfig mNetworkConfig;
  private final MonitorThreadPoolExecutor mNetworkExecutor;
  private final BossImp.NetworkBroadcastReceiver mNetworkReceiver;
  private long mReportExceedSize = 0L;
  private long mReportExceedTime = 0L;
  
  public BossImp(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mLooper = paramLooper;
    paramLooper = new LinkedBlockingQueue();
    this.mCpuExecutor = new MonitorThreadPoolExecutor(this.mCpuConfig.getCore(), this.mCpuConfig.getMaximum(), this.mCpuConfig.getAliveTime(), this.mCpuConfig.getTimeUnit(), paramLooper, new BossImp.AsyncThreadFactory("cpu"));
    this.mCpuExecutor.setName("cpu");
    this.mCpuExecutor.setMonitorListener(this);
    this.mExecutors[0] = this.mCpuExecutor;
    paramLooper = new LinkedBlockingQueue();
    this.mDiskReadExecutor = new MonitorThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, paramLooper, new BossImp.AsyncThreadFactory("disk_read"));
    this.mCpuExecutor.setName("disk_read");
    this.mCpuExecutor.setMonitorListener(this);
    this.mExecutors[1] = this.mDiskReadExecutor;
    paramLooper = new LinkedBlockingQueue();
    this.mDiskWriteExecutor = new MonitorThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, paramLooper, new BossImp.AsyncThreadFactory("disk_write"));
    this.mCpuExecutor.setName("disk_write");
    this.mCpuExecutor.setMonitorListener(this);
    this.mExecutors[2] = this.mDiskWriteExecutor;
    this.mNetworkConfig = new ExecutorConfig.NetworkExecutorConfig(paramContext);
    paramLooper = new LinkedBlockingQueue();
    this.mNetworkExecutor = new MonitorThreadPoolExecutor(this.mNetworkConfig.getCore(), this.mNetworkConfig.getMaximum(), this.mNetworkConfig.getAliveTime(), this.mNetworkConfig.getTimeUnit(), paramLooper, new BossImp.AsyncThreadFactory("network"));
    this.mCpuExecutor.setName("network");
    this.mCpuExecutor.setMonitorListener(this);
    this.mExecutors[3] = this.mNetworkExecutor;
    this.mNetworkReceiver = new BossImp.NetworkBroadcastReceiver(this, null);
    this.mNetworkReceiver.register(paramContext);
    this.mLightWeightExecutor = new LightWeightExecutor(this.mLooper, 100);
    this.mLightWeightExecutor.setMonitorListener(this);
    this.mHandler = new Handler(Dispatchers.get(this.mLooper).getDefaultLooper());
    this.mJobController = new JobController(this);
    Dispatchers.get(this.mLooper).registerSubscriber("root_group", this.mJobController);
  }
  
  @NonNull
  private <Params, Progress, Result> Future<Result> scheduleJobDelayedInternal(Job<Params, Progress, Result> paramJob, int paramInt1, int paramInt2, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramInt2, paramFutureListener, paramParams);
    paramJob.addFutureListener(new BossImp.1(this, paramJob));
    if (paramInt1 == 0)
    {
      Dispatchers.get(this.mLooper).dispatch(paramJob);
      return paramJob;
    }
    Dispatchers.get(this.mLooper).dispatchDelayed(paramJob, paramInt1);
    return paramJob;
  }
  
  public <Result> void cancelJob(Future<Result> paramFuture, boolean paramBoolean)
  {
    if ((paramFuture instanceof Worker)) {
      Dispatchers.get(this.mLooper).cancelDispatch("", (Worker)paramFuture);
    }
    Dispatchers.get(this.mLooper).dispatch(new JobController.CancelCommand(paramFuture, paramBoolean));
  }
  
  public <Params, Progress, Result> Future<Result> executeJobInternal(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramJob.getJobType(), paramFutureListener, paramParams);
    this.mJobController.getDefaultHandler().handleExecute(this.mExecutors, paramJob);
    return paramJob;
  }
  
  @NonNull
  public Executor getExecutor(int paramInt)
  {
    MonitorThreadPoolExecutor localMonitorThreadPoolExecutor2 = this.mCpuExecutor;
    MonitorThreadPoolExecutor localMonitorThreadPoolExecutor1 = localMonitorThreadPoolExecutor2;
    if (paramInt != 2)
    {
      if (paramInt != 4)
      {
        if (paramInt != 8)
        {
          if (paramInt != 16) {
            return localMonitorThreadPoolExecutor2;
          }
          return this.mNetworkExecutor;
        }
        return this.mDiskWriteExecutor;
      }
      localMonitorThreadPoolExecutor1 = this.mDiskReadExecutor;
    }
    return localMonitorThreadPoolExecutor1;
  }
  
  @NonNull
  public Executor[] getExecutors()
  {
    return this.mExecutors;
  }
  
  @NonNull
  public JobController getJobController()
  {
    return this.mJobController;
  }
  
  @NonNull
  public Executor getLightWeightExecutor()
  {
    return this.mLightWeightExecutor;
  }
  
  public void onQueueExceedLimit(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" onQueueExceedLimit, size = ");
    localStringBuilder.append(paramInt);
    SLog.e("async.boss.BossImp", localStringBuilder.toString());
    if (SystemClock.uptimeMillis() - this.mReportExceedSize > 7200000L) {
      this.mReportExceedSize = SystemClock.uptimeMillis();
    }
  }
  
  public void onWorkerExceedTime(String paramString, List<Runnable> paramList, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Runnable)localIterator.next();
      paramList = localObject.getClass().getSimpleName();
      if ((localObject instanceof Worker)) {
        paramList = ((Worker)localObject).getJob().getClass().getSimpleName();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" onWorkerExceedTime, runnable = ");
      ((StringBuilder)localObject).append(paramList);
      SLog.e("async.boss.BossImp", ((StringBuilder)localObject).toString());
      if (SystemClock.uptimeMillis() - this.mReportExceedTime > 7200000L) {
        this.mReportExceedTime = SystemClock.uptimeMillis();
      }
    }
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob)
  {
    return executeJobInternal(paramJob, null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return executeJobInternal(paramJob, paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams)
  {
    return executeJobInternal(paramJob, null, paramParams);
  }
  
  public void postLightWeightJob(Runnable paramRunnable, int paramInt)
  {
    if (paramInt == 0)
    {
      this.mLightWeightExecutor.execute(paramRunnable);
      return;
    }
    this.mHandler.postDelayed(paramRunnable, paramInt);
  }
  
  @NonNull
  public <Params, Progress, Result> Worker<Progress, Result> prepareWorker(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    AssertUtils.checkNotNull(paramJob);
    paramJob.setJobType(paramInt);
    paramJob.setParams(paramParams);
    paramParams = new Worker(paramJob);
    if (paramFutureListener != null) {
      paramParams.addFutureListener(paramFutureListener);
    }
    paramJob.onPost();
    return paramParams;
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob)
  {
    return scheduleJobDelayedInternal(paramJob, 0, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return scheduleJobDelayedInternal(paramJob, 0, paramJob.getJobType(), paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams)
  {
    return scheduleJobDelayedInternal(paramJob, 0, paramJob.getJobType(), null, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt)
  {
    return scheduleJobDelayedInternal(paramJob, paramInt, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return scheduleJobDelayedInternal(paramJob, paramInt, paramJob.getJobType(), paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable Params paramParams)
  {
    return scheduleJobDelayedInternal(paramJob, paramInt, paramJob.getJobType(), null, paramParams);
  }
  
  public void shutdown()
  {
    this.mNetworkReceiver.unregister(this.mContext);
    MonitorThreadPoolExecutor[] arrayOfMonitorThreadPoolExecutor = this.mExecutors;
    int j = arrayOfMonitorThreadPoolExecutor.length;
    int i = 0;
    while (i < j)
    {
      arrayOfMonitorThreadPoolExecutor[i].shutdown();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.BossImp
 * JD-Core Version:    0.7.0.1
 */