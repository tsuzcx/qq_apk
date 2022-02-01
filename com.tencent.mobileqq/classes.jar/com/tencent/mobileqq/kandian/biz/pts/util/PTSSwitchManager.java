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
  public static PTSSwitchManager a = new PTSSwitchManager();
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  private void e()
  {
    this.d = false;
    this.b = false;
    this.c = false;
    g();
  }
  
  private void f()
  {
    g();
    PTSHelper.b();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new PTSRequestFeedsModule());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new PTSNavigateToModule());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new PTSAllInOneJumpModule());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new PTSLoadFeedsModule());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new PTSHandleJSException());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new PTSReportTo1160Module());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new PTSMarkArticleReadModule());
    PTSEngineLoader.a().b();
    PTSAppLoader.a().b();
  }
  
  private void g()
  {
    PTSHelper.c();
    PTSNativeModuleRegistry.clearNativeModule();
    PTSEventDispatcher.a().b();
  }
  
  void a()
  {
    e();
    PTSSwitchManager.1 local1 = new PTSSwitchManager.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return (this.b) || (this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSSwitchManager
 * JD-Core Version:    0.7.0.1
 */