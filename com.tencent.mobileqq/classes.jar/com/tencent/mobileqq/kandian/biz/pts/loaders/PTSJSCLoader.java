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
  private static volatile PTSJSCLoader jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSJSCLoader;
  private static String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private final String b;
  private final String c;
  
  private PTSJSCLoader()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.a("4044"));
    localStringBuilder.append("4044");
    this.b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getParent());
    localStringBuilder.append("/txlib/");
    localStringBuilder.append("readinjoy_pts_jsc");
    this.c = localStringBuilder.toString();
  }
  
  public static PTSJSCLoader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSJSCLoader == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSJSCLoader == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSJSCLoader = new PTSJSCLoader();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSJSCLoader;
  }
  
  private void b()
  {
    ThreadManager.excute(new PTSJSCLoader.3(this), 128, null, true);
  }
  
  private boolean b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("pts_jsc_config.json");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/");
    localStringBuilder.append("libjsc.so");
    boolean bool1 = FileUtils.fileExists(localStringBuilder.toString());
    boolean bool2 = PTSOfflineUtil.a((String)localObject);
    jdField_a_of_type_JavaLangString = PTSOfflineUtil.b((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSJSCIsValid]");
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append(", ptsJSCVersion = ");
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
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
  
  private void c()
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
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
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
  
  public void a(Runnable paramRunnable)
  {
    if (a())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (paramRunnable != null) {
        ThreadManager.getFileThreadHandler().post(paramRunnable);
      }
      return;
    }
    if (b())
    {
      paramRunnable = new PTSJSCLoader.2(this, paramRunnable);
      ThreadManager.getFileThreadHandler().post(paramRunnable);
      return;
    }
    QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], pts jsc is not valid, load jsc so failed.");
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSJSCLoader
 * JD-Core Version:    0.7.0.1
 */