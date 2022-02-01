package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSSoLoader;
import mqq.os.MqqHandler;

public class PTSLiteSwitchManager
{
  private static volatile PTSLiteSwitchManager jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilPTSLiteSwitchManager;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  
  public static PTSLiteSwitchManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilPTSLiteSwitchManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilPTSLiteSwitchManager == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilPTSLiteSwitchManager = new PTSLiteSwitchManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilPTSLiteSwitchManager;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
    PTSHelper.c();
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  private boolean d()
  {
    return this.b;
  }
  
  void a()
  {
    b();
    PTSLiteSwitchManager.1 local1 = new PTSLiteSwitchManager.1(this);
    ThreadManager.getFileThreadHandler().post(local1);
  }
  
  public boolean a()
  {
    return (d()) && (PTSSoLoader.a().a());
  }
  
  @Deprecated
  public boolean b()
  {
    return (c()) && (PTSSoLoader.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager
 * JD-Core Version:    0.7.0.1
 */