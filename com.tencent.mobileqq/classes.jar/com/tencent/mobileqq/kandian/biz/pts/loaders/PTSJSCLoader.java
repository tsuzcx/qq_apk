package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class PTSJSCLoader
{
  private static String a;
  private static volatile PTSJSCLoader b;
  private final String c;
  private final String d;
  private volatile boolean e = false;
  
  private PTSJSCLoader()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.b("4044"));
    localStringBuilder.append("4044");
    this.c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getParent());
    localStringBuilder.append("/txlib/");
    localStringBuilder.append("readinjoy_pts_jsc");
    this.d = localStringBuilder.toString();
  }
  
  public static PTSJSCLoader a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new PTSJSCLoader();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void d()
  {
    ThreadManager.excute(new PTSJSCLoader.3(this), 128, null, true);
  }
  
  private void e()
  {
    try
    {
      ThreadManager.excute(new PTSJSCLoader.4(this), 64, null, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("pts_jsc_config.json");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("/");
    localStringBuilder.append("libjsc.so");
    boolean bool1 = FileUtils.fileExists(localStringBuilder.toString());
    boolean bool2 = PTSOfflineUtil.b((String)localObject);
    a = PTSOfflineUtil.c((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSJSCIsValid]");
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append(", ptsJSCVersion = ");
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append(", isJSCSoExists = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append(", isVersionSupport = ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append("\n");
    QLog.i("PTSJSCLoader", 1, ((StringBuilder)localObject).toString());
    return (bool1) && (bool2);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (b())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (paramRunnable != null) {
        ThreadManager.getFileThreadHandler().post(paramRunnable);
      }
      return;
    }
    if (f())
    {
      paramRunnable = new PTSJSCLoader.2(this, paramRunnable);
      ThreadManager.getFileThreadHandler().post(paramRunnable);
      return;
    }
    QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], pts jsc is not valid, load jsc so failed.");
    e();
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    try
    {
      this.e = false;
      PTSJSCLoader.1 local1 = new PTSJSCLoader.1(this);
      ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSJSCLoader
 * JD-Core Version:    0.7.0.1
 */