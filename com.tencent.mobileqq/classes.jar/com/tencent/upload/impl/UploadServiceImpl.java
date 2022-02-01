package com.tencent.upload.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.ThreadPool;
import com.tencent.upload.utils.pool.UploadThreadManager;
import com.tencent.upload.utils.watcher.UploadFlowTracker;
import java.util.Timer;

public class UploadServiceImpl
  implements IUploadService
{
  private static final int CLOSE_TIME = 120000;
  private static final String TAG = "UploadServiceImpl";
  private static volatile boolean mInit;
  private static volatile UploadServiceImpl sInstance;
  private ImageUploadService mImageUploadService;
  private OtherUploadService mOtherUploadService;
  private Timer mTimer;
  private PowerManager.WakeLock mWakeLock;
  private WifiManager.WifiLock mWifiLock = null;
  
  private UploadServiceImpl()
  {
    ThreadPool localThreadPool = UploadThreadManager.getInstance().getWorkThreadPool();
    this.mImageUploadService = new ImageUploadService(localThreadPool);
    this.mOtherUploadService = new OtherUploadService(localThreadPool);
    mInit = true;
  }
  
  @SuppressLint({"InlinedApi"})
  private void acquireWakeLockIfNot()
  {
    if (!UploadGlobalConfig.getConfig().canHoldSystemLock()) {
      return;
    }
    Object localObject = this.mWakeLock;
    int i = 1;
    if (localObject == null)
    {
      this.mWakeLock = ((PowerManager)UploadGlobalConfig.getContext().getSystemService("power")).newWakeLock(1, "UploadServiceImpl");
      this.mWakeLock.acquire();
      UploadLog.d("UploadServiceImpl", "acquireWakeLock()");
    }
    if (this.mWifiLock == null)
    {
      localObject = (WifiManager)UploadGlobalConfig.getContext().getApplicationContext().getSystemService("wifi");
      if (Build.VERSION.SDK_INT >= 12) {
        i = 3;
      }
      this.mWifiLock = ((WifiManager)localObject).createWifiLock(i, "UploadServiceImpl");
      UploadLog.d("UploadServiceImpl", "acquireWifiLock()");
    }
  }
  
  private void check2doClose()
  {
    if (isUploadIdle()) {
      doClose();
    }
  }
  
  public static UploadServiceImpl getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new UploadServiceImpl();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void releaseWakeLockIfExist()
  {
    if (!UploadGlobalConfig.getConfig().canHoldSystemLock()) {
      return;
    }
    Object localObject = this.mWakeLock;
    if ((localObject != null) && (((PowerManager.WakeLock)localObject).isHeld()))
    {
      this.mWakeLock.release();
      this.mWakeLock = null;
      UploadLog.d("UploadServiceImpl", "releaseWakeLock()");
    }
    localObject = this.mWifiLock;
    if ((localObject != null) && (((WifiManager.WifiLock)localObject).isHeld()))
    {
      this.mWifiLock.release();
      this.mWifiLock = null;
      UploadLog.d("UploadServiceImpl", "releaseWifiLock()");
    }
  }
  
  private void setCloseTimer()
  {
    UploadLog.v("UploadServiceImpl", "setCloseTimer()");
    if (this.mTimer == null)
    {
      UploadLog.v("UploadServiceImpl", " set real timer, tick tic t ...");
      this.mTimer = new Timer(true);
      UploadServiceImpl.CloseServiceTask localCloseServiceTask = new UploadServiceImpl.CloseServiceTask(this);
      this.mTimer.schedule(localCloseServiceTask, 120000L, 120000L);
    }
  }
  
  public boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return false;
    }
    if (UploadTaskManager.getTaskType(paramAbstractUploadTask) == Const.FileType.Photo) {
      this.mImageUploadService.cancel(paramAbstractUploadTask);
    } else {
      this.mOtherUploadService.cancel(paramAbstractUploadTask);
    }
    UploadFlowTracker.trackCancel(paramAbstractUploadTask);
    return true;
  }
  
  public boolean clearCacheWhenIdle(Context paramContext)
  {
    UploadLog.d("UploadServiceImpl", "clearCacheWhenIdle");
    FileUtils.clearUploadDir(paramContext, 0L, 0L);
    return true;
  }
  
  public boolean commit(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null)
    {
      UploadLog.d("UploadServiceImpl", "commit() task==null");
      return false;
    }
    return true;
  }
  
  public void doClose()
  {
    UploadLog.v("UploadServiceImpl", "doClose called.");
    if (!mInit) {
      return;
    }
    UploadLog.v("UploadServiceImpl", "doClose --- R.I.P");
    mInit = false;
    Timer localTimer = this.mTimer;
    if (localTimer != null) {
      localTimer.cancel();
    }
    releaseWakeLockIfExist();
    this.mImageUploadService.close();
    this.mOtherUploadService.close();
    FileUtils.clearUploadDir(UploadGlobalConfig.getContext(), 31457280L, 20971520L);
  }
  
  public void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv, IUploadSoLoader paramIUploadSoLoader) {}
  
  public boolean isInitialized()
  {
    return mInit;
  }
  
  public boolean isUploadIdle()
  {
    boolean bool;
    if ((this.mImageUploadService.isUploadIdle()) && (this.mOtherUploadService.isUploadIdle())) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadServiceImpl isUploadIdle: ");
    localStringBuilder.append(bool);
    UploadLog.d("UploadServiceImpl", localStringBuilder.toString());
    return bool;
  }
  
  public void keepImageTmpFile(boolean paramBoolean) {}
  
  public void pauseAllTask()
  {
    UploadLog.v("UploadServiceImpl", "pauseAllTask");
    this.mImageUploadService.cancelAllTasks();
    this.mOtherUploadService.cancelAllTasks();
  }
  
  public void prepare(TaskTypeConfig paramTaskTypeConfig)
  {
    paramTaskTypeConfig = paramTaskTypeConfig.serverRouteTable.supportFileType;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("prepare() type=");
    localStringBuilder.append(paramTaskTypeConfig);
    UploadLog.d("UploadServiceImpl", localStringBuilder.toString());
    if (paramTaskTypeConfig == Const.FileType.Photo)
    {
      this.mImageUploadService.prepare(paramTaskTypeConfig);
      return;
    }
    this.mOtherUploadService.prepare(paramTaskTypeConfig);
  }
  
  public void setBackgroundMode(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBackgroundMode:");
    localStringBuilder.append(paramBoolean);
    UploadLog.d("UploadServiceImpl", localStringBuilder.toString());
    if (!mInit) {
      return;
    }
    if (paramBoolean) {
      setCloseTimer();
    }
  }
  
  public void setDebugServerRoute(DebugServerRoute paramDebugServerRoute)
  {
    RouteFactory.setDebugRoute(paramDebugServerRoute);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDebugServerRoute -- ");
    localStringBuilder.append(paramDebugServerRoute);
    UploadLog.d("UploadServiceImpl", localStringBuilder.toString());
    this.mImageUploadService.reset();
    this.mOtherUploadService.reset();
  }
  
  public boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    acquireWakeLockIfNot();
    if (UploadTaskManager.getTaskType(paramAbstractUploadTask) == Const.FileType.Photo) {
      this.mImageUploadService.upload(paramAbstractUploadTask);
    } else {
      this.mOtherUploadService.upload(paramAbstractUploadTask);
    }
    UploadFlowTracker.trackStart(paramAbstractUploadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.impl.UploadServiceImpl
 * JD-Core Version:    0.7.0.1
 */