package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class PTSEngineLoader
{
  private static String b;
  private static volatile PTSEngineLoader c;
  public final boolean a = false;
  private final String d;
  private final String e;
  private volatile boolean f = false;
  
  private PTSEngineLoader()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.b("3980"));
    localStringBuilder.append("3980");
    this.d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getParent());
    localStringBuilder.append("/txlib/");
    localStringBuilder.append("readinjoy_pts_engine");
    this.e = localStringBuilder.toString();
  }
  
  public static PTSEngineLoader a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new PTSEngineLoader();
        }
      }
      finally {}
    }
    return c;
  }
  
  private void f()
  {
    ThreadManager.excute(new PTSEngineLoader.3(this), 128, null, true);
  }
  
  private void g()
  {
    ThreadManager.excute(new PTSEngineLoader.4(this), 64, null, false);
  }
  
  private boolean h()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append("libpts.so");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.e);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append("pts_config.json");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool1 = FileUtils.fileExists((String)localObject1);
    boolean bool2 = PTSOfflineUtil.b((String)localObject2);
    b = PTSOfflineUtil.c((String)localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[checkInnerPTSEngineIsValid]");
    ((StringBuilder)localObject1).append("\n");
    ((StringBuilder)localObject1).append(", ptsEngineVersion = ");
    ((StringBuilder)localObject1).append(b);
    ((StringBuilder)localObject1).append("\n");
    ((StringBuilder)localObject1).append(", isSoExists = ");
    ((StringBuilder)localObject1).append(bool1);
    ((StringBuilder)localObject1).append("\n");
    ((StringBuilder)localObject1).append(", isVersionSupport = ");
    ((StringBuilder)localObject1).append(bool2);
    ((StringBuilder)localObject1).append("\n");
    QLog.i("PTSEngineLoader", 1, ((StringBuilder)localObject1).toString());
    return (bool1) && (bool2);
  }
  
  private void i()
  {
    if (j()) {
      return;
    }
    if (d())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts engine is ready, do not load again.");
      return;
    }
    if (h())
    {
      PTSEngineLoader.5 local5 = new PTSEngineLoader.5(this);
      PTSJSCLoader.a().a(local5);
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], inner dir is not valid, load pts engine failed.");
    g();
  }
  
  private boolean j()
  {
    return false;
  }
  
  public void b()
  {
    PTSEngineLoader.1 local1 = new PTSEngineLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public void c()
  {
    try
    {
      this.f = false;
      PTSEngineLoader.2 local2 = new PTSEngineLoader.2(this);
      ThreadManager.getFileThreadHandler().post(local2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public String e()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader
 * JD-Core Version:    0.7.0.1
 */