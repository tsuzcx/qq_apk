package com.tencent.upload.impl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.report.ReportManager;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;

public class UploadServiceProxy
  implements IUploadService
{
  private static final int MSG_INNER_TIMEOUT_CLOSE = 8;
  private static final int MSG_UI_CANCEL_TASK = 3;
  private static final int MSG_UI_COMMIT_TASK = 4;
  private static final int MSG_UI_PAUSE_ALL_TASK = 5;
  private static final int MSG_UI_PREPARE = 1;
  private static final int MSG_UI_SET_BACKGROUND_MODE = 6;
  private static final int MSG_UI_SET_TEST_SERVER = 7;
  private static final int MSG_UI_UPLOAD_TASK = 2;
  private static volatile boolean mInit = false;
  private static volatile UploadServiceProxy sInstance;
  public static final String tag = "UploadServiceProxy";
  boolean mIsDebug = false;
  private UploadServiceImpl mServiceImpl;
  private Handler mWorkerHandler;
  private HandlerThread mWorkerThread;
  
  private boolean checkStatus()
  {
    if (!mInit)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkStatus mInit: ");
      ((StringBuilder)localObject).append(mInit);
      UploadLog.d("UploadServiceProxy", ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = this.mWorkerThread;
    if ((localObject != null) && (((HandlerThread)localObject).isAlive()))
    {
      if (this.mWorkerHandler == null)
      {
        UploadLog.d("UploadServiceProxy", "checkStatus mWorkerHandler == null");
        return false;
      }
      return true;
    }
    UploadLog.d("UploadServiceProxy", "checkStatus work thread is not ready !");
    return false;
  }
  
  public static IUploadService getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new UploadServiceProxy();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void initWorkerThread()
  {
    try
    {
      if ((this.mWorkerThread != null) && (this.mWorkerThread.isAlive()))
      {
        Handler localHandler = this.mWorkerHandler;
        if (localHandler != null) {
          return;
        }
      }
      UploadLog.v("UploadServiceProxy", "initWorkerThread()");
      this.mWorkerThread = new HandlerThread("uploadHandle");
      this.mWorkerThread.start();
      this.mWorkerHandler = new UploadServiceProxy.1(this, this.mWorkerThread.getLooper());
      if (this.mServiceImpl == null) {
        this.mServiceImpl = UploadServiceImpl.getInstance();
      }
      return;
    }
    finally {}
  }
  
  public boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> cancel");
    if (!checkStatus()) {
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      UploadLog.d("UploadServiceProxy", "task == null");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel --> flowId:");
    localStringBuilder.append(paramAbstractUploadTask.flowId);
    UploadLog.d("UploadServiceProxy", localStringBuilder.toString());
    this.mWorkerHandler.obtainMessage(3, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public boolean clearCacheWhenIdle(Context paramContext)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> clearCacheWhenIdle");
    FileUtils.clearUploadDir(paramContext, 0L, 0L);
    return true;
  }
  
  public boolean commit(AbstractUploadTask paramAbstractUploadTask)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> commit");
    if (!checkStatus()) {
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      UploadLog.d("UploadServiceProxy", "task == null");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commit --> flowId:");
    localStringBuilder.append(paramAbstractUploadTask.flowId);
    UploadLog.d("UploadServiceProxy", localStringBuilder.toString());
    this.mWorkerHandler.obtainMessage(4, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv, IUploadSoLoader paramIUploadSoLoader)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init() --- env: ");
    localStringBuilder.append(paramIUploadEnv);
    UploadLog.d("UploadServiceProxy", localStringBuilder.toString());
    UploadGlobalConfig.init(paramContext, paramIUploadConfig, paramIUploadLog, paramIUploadReport, paramIUploadEnv, paramIUploadSoLoader);
    mInit = true;
  }
  
  public boolean isInitialized()
  {
    return mInit;
  }
  
  public void keepImageTmpFile(boolean paramBoolean)
  {
    UploadGlobalConfig.keepImageTmpFile(paramBoolean);
  }
  
  public void pauseAllTask()
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> pauseAllTask");
    if (!checkStatus()) {
      return;
    }
    this.mWorkerHandler.obtainMessage(5).sendToTarget();
  }
  
  public void prepare(TaskTypeConfig paramTaskTypeConfig)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> prepare");
    if (paramTaskTypeConfig == null) {
      return;
    }
    if (!mInit)
    {
      UploadLog.d("UploadServiceProxy", "prepare !mInit");
      return;
    }
    initWorkerThread();
    this.mWorkerHandler.obtainMessage(1, paramTaskTypeConfig).sendToTarget();
  }
  
  public void setBackgroundMode(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setDebugServerRoute(DebugServerRoute paramDebugServerRoute)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UI operation >>> setDebugServerRoute : mInit:");
    localStringBuilder.append(mInit);
    UploadLog.d("UploadServiceProxy", localStringBuilder.toString());
    if (!mInit) {
      return;
    }
    this.mIsDebug = true;
    initWorkerThread();
    this.mWorkerHandler.obtainMessage(7, 0, 0, paramDebugServerRoute).sendToTarget();
  }
  
  public boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> upload");
    if (!mInit)
    {
      UploadLog.d("UploadServiceProxy", "upload !mInit");
      return false;
    }
    ReportManager.getInstance().reportTaskStart(paramAbstractUploadTask);
    initWorkerThread();
    this.mWorkerHandler.obtainMessage(2, paramAbstractUploadTask).sendToTarget();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.UploadServiceProxy
 * JD-Core Version:    0.7.0.1
 */