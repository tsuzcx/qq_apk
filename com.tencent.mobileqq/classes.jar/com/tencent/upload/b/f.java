package com.tencent.upload.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.a;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.Utility.TestServerCategory;
import com.tencent.upload.uinterface.V2Config;

public class f
  implements IUploadService
{
  private static volatile f b;
  private static volatile boolean e;
  boolean a = false;
  private HandlerThread c;
  private Handler d;
  private e f;
  
  public static IUploadService a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new f();
      }
      return b;
    }
    finally {}
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/upload/b/f:c	Landroid/os/HandlerThread;
    //   6: ifnull +25 -> 31
    //   9: aload_0
    //   10: getfield 36	com/tencent/upload/b/f:c	Landroid/os/HandlerThread;
    //   13: invokevirtual 42	android/os/HandlerThread:isAlive	()Z
    //   16: ifeq +15 -> 31
    //   19: aload_0
    //   20: getfield 44	com/tencent/upload/b/f:d	Landroid/os/Handler;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: ldc 46
    //   33: ldc 48
    //   35: invokestatic 53	com/tencent/upload/common/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: new 38	android/os/HandlerThread
    //   42: dup
    //   43: ldc 55
    //   45: invokespecial 58	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   48: putfield 36	com/tencent/upload/b/f:c	Landroid/os/HandlerThread;
    //   51: aload_0
    //   52: getfield 36	com/tencent/upload/b/f:c	Landroid/os/HandlerThread;
    //   55: invokevirtual 61	android/os/HandlerThread:start	()V
    //   58: aload_0
    //   59: new 8	com/tencent/upload/b/f$1
    //   62: dup
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 36	com/tencent/upload/b/f:c	Landroid/os/HandlerThread;
    //   68: invokevirtual 65	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   71: invokespecial 68	com/tencent/upload/b/f$1:<init>	(Lcom/tencent/upload/b/f;Landroid/os/Looper;)V
    //   74: putfield 44	com/tencent/upload/b/f:d	Landroid/os/Handler;
    //   77: aload_0
    //   78: getfield 29	com/tencent/upload/b/f:f	Lcom/tencent/upload/b/e;
    //   81: ifnonnull -53 -> 28
    //   84: aload_0
    //   85: invokestatic 73	com/tencent/upload/b/e:a	()Lcom/tencent/upload/b/e;
    //   88: putfield 29	com/tencent/upload/b/f:f	Lcom/tencent/upload/b/e;
    //   91: goto -63 -> 28
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	f
    //   23	2	1	localHandler	Handler
    //   94	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	94	finally
    //   31	91	94	finally
  }
  
  private boolean c()
  {
    if (!e)
    {
      com.tencent.upload.common.b.b("UploadServiceProxy", "checkStatus mInit: " + e);
      return false;
    }
    if ((this.c == null) || (!this.c.isAlive()))
    {
      com.tencent.upload.common.b.b("UploadServiceProxy", "checkStatus work thread is not ready !");
      return false;
    }
    if (this.d == null)
    {
      com.tencent.upload.common.b.b("UploadServiceProxy", "checkStatus mWorkerHandler == null");
      return false;
    }
    return true;
  }
  
  public boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> cancel");
    if (!c()) {
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      com.tencent.upload.common.b.b("UploadServiceProxy", "task == null");
      return false;
    }
    com.tencent.upload.common.b.b("UploadServiceProxy", "cancel --> flowId:" + paramAbstractUploadTask.flowId);
    this.d.obtainMessage(3, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public boolean clearCacheWhenIdle(Context paramContext)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> clearCacheWhenIdle");
    FileUtils.clearUploadDir(paramContext, 0L, 0L);
    return true;
  }
  
  public boolean commit(AbstractUploadTask paramAbstractUploadTask)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> commit");
    if (!c()) {
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      com.tencent.upload.common.b.b("UploadServiceProxy", "task == null");
      return false;
    }
    com.tencent.upload.common.b.b("UploadServiceProxy", "commit --> flowId:" + paramAbstractUploadTask.flowId);
    this.d.obtainMessage(4, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "init() --- env: " + paramIUploadEnv);
    a.a(paramContext, paramIUploadConfig, paramIUploadLog, paramIUploadReport, paramIUploadEnv);
    e = true;
  }
  
  public boolean isInitialized()
  {
    return e;
  }
  
  public void keepImageTmpFile(boolean paramBoolean)
  {
    a.a(paramBoolean);
  }
  
  public void pauseAllTask()
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> pauseAllTask");
    if (!c()) {
      return;
    }
    this.d.obtainMessage(5).sendToTarget();
  }
  
  public void prepare(TaskTypeConfig paramTaskTypeConfig)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> prepare");
    if (paramTaskTypeConfig == null) {
      return;
    }
    if (!e)
    {
      com.tencent.upload.common.b.b("UploadServiceProxy", "prepare !mInit");
      return;
    }
    b();
    this.d.obtainMessage(1, paramTaskTypeConfig).sendToTarget();
  }
  
  public void setBackgroundMode(boolean paramBoolean)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> setBackgroundMode");
    if (!c()) {
      return;
    }
    Handler localHandler = this.d;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(6, i, 0).sendToTarget();
      return;
    }
  }
  
  public void setTestServer(Utility.TestServerCategory paramTestServerCategory)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> setTestServer");
    if (!e)
    {
      com.tencent.upload.common.b.b("UploadServiceProxy", "setTestServer !mInit");
      return;
    }
    this.a = true;
    b();
    this.d.obtainMessage(7, paramTestServerCategory.getType(), 0, paramTestServerCategory).sendToTarget();
  }
  
  public boolean setUploadV2Config(V2Config paramV2Config)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> setUploadV2Config");
    b();
    this.f.setUploadV2Config(paramV2Config);
    return true;
  }
  
  public boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    com.tencent.upload.common.b.b("UploadServiceProxy", "UI operation >>> upload");
    if (!e)
    {
      com.tencent.upload.common.b.b("UploadServiceProxy", "upload !mInit");
      return false;
    }
    com.tencent.upload.report.b.a().b(paramAbstractUploadTask);
    b();
    this.d.obtainMessage(2, paramAbstractUploadTask).sendToTarget();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.b.f
 * JD-Core Version:    0.7.0.1
 */