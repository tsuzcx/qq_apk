package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSAppLoader;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader;
import com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSAllInOneJumpModule;
import com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSHandleJSException;
import com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSLoadFeedsModule;
import com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSMarkArticleReadModule;
import com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSNavigateToModule;
import com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSReportTo1160Module;
import com.tencent.mobileqq.kandian.repo.pts.PTSEventDispatcher;
import com.tencent.mobileqq.kandian.repo.pts.PTSRequestFeedsModule;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import mqq.os.MqqHandler;

public class PTSSwitchManager
{
  public static PTSSwitchManager a;
  private boolean a;
  private boolean b = false;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilPTSSwitchManager = new PTSSwitchManager();
  }
  
  private PTSSwitchManager()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    d();
  }
  
  private void c()
  {
    d();
    PTSHelper.b();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new PTSRequestFeedsModule());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new PTSNavigateToModule());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new PTSAllInOneJumpModule());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new PTSLoadFeedsModule());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new PTSHandleJSException());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new PTSReportTo1160Module());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new PTSMarkArticleReadModule());
    PTSEngineLoader.a().a();
    PTSAppLoader.a().a();
  }
  
  private void d()
  {
    PTSHelper.c();
    PTSNativeModuleRegistry.clearNativeModule();
    PTSEventDispatcher.a().a();
  }
  
  void a()
  {
    b();
    PTSSwitchManager.1 local1 = new PTSSwitchManager.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) || (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSSwitchManager
 * JD-Core Version:    0.7.0.1
 */