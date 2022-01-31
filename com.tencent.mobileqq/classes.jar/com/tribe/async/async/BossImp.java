package com.tribe.async.async;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
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
import java.util.concurrent.ThreadFactory;
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
  private final ExecutorConfig mNetworkConfig;
  private final MonitorThreadPoolExecutor mNetworkExecutor;
  private final NetworkBroadcastReceiver mNetworkReceiver;
  private long mReportExceedSize = 0L;
  private long mReportExceedTime = 0L;
  
  public BossImp(Context paramContext)
  {
    this.mContext = paramContext;
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    this.mCpuExecutor = new MonitorThreadPoolExecutor(this.mCpuConfig.getCore(), this.mCpuConfig.getMaximum(), this.mCpuConfig.getAliveTime(), this.mCpuConfig.getTimeUnit(), localLinkedBlockingQueue, new AsyncThreadFactory("cpu"));
    this.mCpuExecutor.setName("cpu");
    this.mCpuExecutor.setMonitorListener(this);
    this.mExecutors[0] = this.mCpuExecutor;
    localLinkedBlockingQueue = new LinkedBlockingQueue();
    this.mDiskReadExecutor = new MonitorThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, localLinkedBlockingQueue, new AsyncThreadFactory("disk_read"));
    this.mCpuExecutor.setName("disk_read");
    this.mCpuExecutor.setMonitorListener(this);
    this.mExecutors[1] = this.mDiskReadExecutor;
    localLinkedBlockingQueue = new LinkedBlockingQueue();
    this.mDiskWriteExecutor = new MonitorThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, localLinkedBlockingQueue, new AsyncThreadFactory("disk_write"));
    this.mCpuExecutor.setName("disk_write");
    this.mCpuExecutor.setMonitorListener(this);
    this.mExecutors[2] = this.mDiskWriteExecutor;
    this.mNetworkConfig = new ExecutorConfig.NetworkExecutorConfig(paramContext);
    localLinkedBlockingQueue = new LinkedBlockingQueue();
    this.mNetworkExecutor = new MonitorThreadPoolExecutor(this.mNetworkConfig.getCore(), this.mNetworkConfig.getMaximum(), this.mNetworkConfig.getAliveTime(), this.mNetworkConfig.getTimeUnit(), localLinkedBlockingQueue, new AsyncThreadFactory("network"));
    this.mCpuExecutor.setName("network");
    this.mCpuExecutor.setMonitorListener(this);
    this.mExecutors[3] = this.mNetworkExecutor;
    this.mNetworkReceiver = new NetworkBroadcastReceiver(null);
    this.mNetworkReceiver.register(paramContext);
    this.mLightWeightExecutor = new LightWeightExecutor(100);
    this.mLightWeightExecutor.setMonitorListener(this);
    this.mHandler = new Handler(Dispatchers.get().getDefaultLooper());
    this.mJobController = new JobController(this);
    Dispatchers.get().registerSubscriber("root_group", this.mJobController);
  }
  
  @NonNull
  private <Params, Progress, Result> Future<Result> scheduleJobDelayedInternal(final Job<Params, Progress, Result> paramJob, int paramInt1, int paramInt2, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramInt2, paramFutureListener, paramParams);
    paramJob.addFutureListener(new FutureListener.SimpleFutureListener()
    {
      public void onFutureDone(@Nullable Result paramAnonymousResult)
      {
        Dispatchers.get().dispatch(new JobController.DoneEvent(paramJob));
      }
    });
    if (paramInt1 == 0)
    {
      Dispatchers.get().dispatch(paramJob);
      return paramJob;
    }
    Dispatchers.get().dispatchDelayed(paramJob, paramInt1);
    return paramJob;
  }
  
  public <Result> void cancelJob(Future<Result> paramFuture, boolean paramBoolean)
  {
    if ((paramFuture instanceof Worker)) {
      Dispatchers.get().cancelDispatch("", (Worker)paramFuture);
    }
    Dispatchers.get().dispatch(new JobController.CancelCommand(paramFuture, paramBoolean));
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
    MonitorThreadPoolExecutor localMonitorThreadPoolExecutor = this.mCpuExecutor;
    switch (paramInt)
    {
    default: 
      return localMonitorThreadPoolExecutor;
    case 2: 
      return this.mCpuExecutor;
    case 4: 
      return this.mDiskReadExecutor;
    case 8: 
      return this.mDiskWriteExecutor;
    }
    return this.mNetworkExecutor;
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
    SLog.e("async.boss.BossImp", paramString + " onQueueExceedLimit, size = " + paramInt);
    if (SystemClock.uptimeMillis() - this.mReportExceedSize > 7200000L) {
      this.mReportExceedSize = SystemClock.uptimeMillis();
    }
  }
  
  public void onWorkerExceedTime(String paramString, List<Runnable> paramList, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      paramList = localRunnable.getClass().getSimpleName();
      if ((localRunnable instanceof Worker)) {
        paramList = ((Worker)localRunnable).getJob().getClass().getSimpleName();
      }
      SLog.e("async.boss.BossImp", paramString + " onWorkerExceedTime, runnable = " + paramList);
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
  
  private static class AsyncThreadFactory
    implements ThreadFactory
  {
    private int index;
    private String type;
    
    public AsyncThreadFactory(String paramString)
    {
      this.type = paramString;
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      if (paramRunnable == null) {
        return new Thread("no_name");
      }
      StringBuilder localStringBuilder = new StringBuilder().append("type_").append(this.type).append("_index");
      int i = this.index;
      this.index = (i + 1);
      return new Thread(paramRunnable, i);
    }
  }
  
  private class NetworkBroadcastReceiver
    extends BroadcastReceiver
  {
    private NetworkBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      BossImp.this.mNetworkExecutor.setCorePoolSize(BossImp.this.mNetworkConfig.getCore());
      BossImp.this.mNetworkExecutor.setMaximumPoolSize(BossImp.this.mNetworkConfig.getMaximum());
      BossImp.this.mNetworkExecutor.setKeepAliveTime(BossImp.this.mNetworkConfig.getAliveTime(), BossImp.this.mNetworkConfig.getTimeUnit());
    }
    
    public void register(Context paramContext)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.AIRPLANE_MODE");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      paramContext.registerReceiver(this, localIntentFilter);
    }
    
    void unregister(Context paramContext)
    {
      paramContext.unregisterReceiver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.BossImp
 * JD-Core Version:    0.7.0.1
 */