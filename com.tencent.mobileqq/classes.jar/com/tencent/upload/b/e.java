package com.tencent.upload.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.upload.common.Const.b;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.b;
import com.tencent.upload.network.route.RouteFactory.ServerCategory;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.Utility.TestServerCategory;
import com.tencent.upload.uinterface.V2Config;
import java.util.Timer;
import java.util.TimerTask;

public class e
  implements IUploadService
{
  private static volatile e a;
  private static volatile boolean b;
  private c c;
  private d d;
  private Timer e;
  private PowerManager.WakeLock f;
  private WifiManager.WifiLock g = null;
  
  private e()
  {
    com.tencent.upload.e.a.c localc = com.tencent.upload.e.a.e.a().b();
    this.c = new c(localc);
    this.d = new d(localc);
    b = true;
  }
  
  public static e a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new e();
      }
      return a;
    }
    finally {}
  }
  
  private void d()
  {
    b.a("UploadServiceImpl", "setCloseTimer()");
    if (this.e == null)
    {
      b.a("UploadServiceImpl", " set real timer, tick tic t ...");
      this.e = new Timer(true);
      a locala = new a();
      this.e.schedule(locala, 120000L, 120000L);
    }
  }
  
  @SuppressLint({"InlinedApi"})
  private void e()
  {
    int i = 1;
    if (!com.tencent.upload.common.a.b().canHoldSystemLock()) {}
    do
    {
      return;
      if (this.f == null)
      {
        this.f = ((PowerManager)com.tencent.upload.common.a.a().getSystemService("power")).newWakeLock(1, "UploadServiceImpl");
        this.f.acquire();
        b.b("UploadServiceImpl", "acquireWakeLock()");
      }
    } while (this.g != null);
    WifiManager localWifiManager = (WifiManager)com.tencent.upload.common.a.a().getApplicationContext().getSystemService("wifi");
    if (Build.VERSION.SDK_INT >= 12) {
      i = 3;
    }
    this.g = localWifiManager.createWifiLock(i, "UploadServiceImpl");
    b.b("UploadServiceImpl", "acquireWifiLock()");
  }
  
  private void f()
  {
    if (!com.tencent.upload.common.a.b().canHoldSystemLock()) {}
    do
    {
      return;
      if ((this.f != null) && (this.f.isHeld()))
      {
        this.f.release();
        this.f = null;
        b.b("UploadServiceImpl", "releaseWakeLock()");
      }
    } while ((this.g == null) || (!this.g.isHeld()));
    this.g.release();
    this.g = null;
    b.b("UploadServiceImpl", "releaseWifiLock()");
  }
  
  private void g()
  {
    if (c()) {
      b();
    }
  }
  
  public void b()
  {
    b.a("UploadServiceImpl", "doClose called.");
    if (!b) {
      return;
    }
    b.a("UploadServiceImpl", "doClose --- R.I.P");
    b = false;
    if (this.e != null) {
      this.e.cancel();
    }
    f();
    this.c.c();
    this.d.c();
    FileUtils.clearUploadDir(com.tencent.upload.common.a.a(), 31457280L, 20971520L);
  }
  
  public boolean c()
  {
    if ((this.c.a()) && (this.d.a())) {}
    for (boolean bool = true;; bool = false)
    {
      b.b("UploadServiceImpl", "UploadServiceImpl isUploadIdle: " + bool);
      return bool;
    }
  }
  
  public boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return false;
    }
    if (g.b(paramAbstractUploadTask) == Const.b.b) {
      this.c.a(paramAbstractUploadTask);
    }
    for (;;)
    {
      com.tencent.upload.e.c.a.b(paramAbstractUploadTask);
      return true;
      this.d.a(paramAbstractUploadTask);
    }
  }
  
  public boolean clearCacheWhenIdle(Context paramContext)
  {
    b.b("UploadServiceImpl", "clearCacheWhenIdle");
    FileUtils.clearUploadDir(paramContext, 0L, 0L);
    return true;
  }
  
  public boolean commit(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null)
    {
      b.b("UploadServiceImpl", "commit() task==null");
      return false;
    }
    return true;
  }
  
  public void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv) {}
  
  public boolean isInitialized()
  {
    return b;
  }
  
  public void keepImageTmpFile(boolean paramBoolean) {}
  
  public void pauseAllTask()
  {
    b.a("UploadServiceImpl", "pauseAllTask");
    this.c.b();
    this.d.b();
  }
  
  public void prepare(TaskTypeConfig paramTaskTypeConfig)
  {
    paramTaskTypeConfig = paramTaskTypeConfig.serverCategory.supportFileType;
    b.b("UploadServiceImpl", "prepare() type=" + paramTaskTypeConfig);
    b.b("UploadServiceImpl", "prepare() type=" + paramTaskTypeConfig);
    if (paramTaskTypeConfig == Const.b.b)
    {
      this.c.a(paramTaskTypeConfig);
      return;
    }
    this.d.a(paramTaskTypeConfig);
  }
  
  public void setBackgroundMode(boolean paramBoolean)
  {
    b.b("UploadServiceImpl", "setBackgroundMode:" + paramBoolean);
    if (!b) {}
    while (!paramBoolean) {
      return;
    }
    d();
  }
  
  public void setTestServer(Utility.TestServerCategory paramTestServerCategory)
  {
    com.tencent.upload.network.a.d.a(paramTestServerCategory);
    b.b("UploadServiceImpl", "setTestServer -- " + paramTestServerCategory);
    this.c.d();
    this.d.d();
  }
  
  public boolean setUploadV2Config(V2Config paramV2Config)
  {
    b.d("UploadServiceImpl", "reset sConfig: " + paramV2Config);
    com.tencent.upload.common.a.a(paramV2Config);
    return true;
  }
  
  public boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    e();
    if (g.b(paramAbstractUploadTask) == Const.b.b) {
      this.c.b(paramAbstractUploadTask);
    }
    for (;;)
    {
      com.tencent.upload.e.c.a.a(paramAbstractUploadTask);
      return true;
      this.d.b(paramAbstractUploadTask);
    }
  }
  
  class a
    extends TimerTask
  {
    a() {}
    
    public void run()
    {
      e.a(e.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.b.e
 * JD-Core Version:    0.7.0.1
 */