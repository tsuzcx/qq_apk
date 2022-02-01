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
  private static volatile PTSEngineLoader jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSEngineLoader;
  private static String jdField_a_of_type_JavaLangString;
  public final boolean a;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private final String c;
  
  private PTSEngineLoader()
  {
    this.jdField_a_of_type_Boolean = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.a("3980"));
    localStringBuilder.append("3980");
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getParent());
    localStringBuilder.append("/txlib/");
    localStringBuilder.append("readinjoy_pts_engine");
    this.c = localStringBuilder.toString();
  }
  
  public static PTSEngineLoader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSEngineLoader == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSEngineLoader == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSEngineLoader = new PTSEngineLoader();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSEngineLoader;
  }
  
  private boolean b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append("libpts.so");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append("pts_config.json");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool1 = FileUtils.fileExists((String)localObject1);
    boolean bool2 = PTSOfflineUtil.a((String)localObject2);
    jdField_a_of_type_JavaLangString = PTSOfflineUtil.b((String)localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[checkInnerPTSEngineIsValid]");
    ((StringBuilder)localObject1).append("\n");
    ((StringBuilder)localObject1).append(", ptsEngineVersion = ");
    ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
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
  
  private void c()
  {
    ThreadManager.excute(new PTSEngineLoader.3(this), 128, null, true);
  }
  
  private boolean c()
  {
    return false;
  }
  
  private void d()
  {
    ThreadManager.excute(new PTSEngineLoader.4(this), 64, null, false);
  }
  
  private void e()
  {
    if (c()) {
      return;
    }
    if (a())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts engine is ready, do not load again.");
      return;
    }
    if (b())
    {
      PTSEngineLoader.5 local5 = new PTSEngineLoader.5(this);
      PTSJSCLoader.a().a(local5);
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], inner dir is not valid, load pts engine failed.");
    d();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    PTSEngineLoader.1 local1 = new PTSEngineLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader
 * JD-Core Version:    0.7.0.1
 */