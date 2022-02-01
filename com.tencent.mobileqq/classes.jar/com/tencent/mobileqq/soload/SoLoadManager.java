package com.tencent.mobileqq.soload;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoloadService;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;

public class SoLoadManager
{
  private static volatile SoLoadManager jdField_a_of_type_ComTencentMobileqqSoloadSoLoadManager;
  private ISoloadService jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService = (ISoloadService)QRoute.api(ISoloadService.class);
  
  public static SoLoadManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSoloadSoLoadManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqSoloadSoLoadManager == null) {
        jdField_a_of_type_ComTencentMobileqqSoloadSoLoadManager = new SoLoadManager();
      }
      return jdField_a_of_type_ComTencentMobileqqSoloadSoLoadManager;
    }
    finally {}
  }
  
  public LoadExtResult a(String paramString)
  {
    LoadExtResult localLoadExtResult = null;
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService != null) {
      localLoadExtResult = this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService.loadSync(paramString, null);
    }
    return localLoadExtResult;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService.getSoVer(paramString);
  }
  
  public void a(String paramString, OnLoadListener paramOnLoadListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService != null) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService.load(paramString, paramOnLoadListener);
    }
  }
  
  public void a(String[] paramArrayOfString, OnLoadListener paramOnLoadListener)
  {
    a(paramArrayOfString, paramOnLoadListener, null);
  }
  
  public void a(String[] paramArrayOfString, OnLoadListener paramOnLoadListener, LoadOptions[] paramArrayOfLoadOptions)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService != null) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService.loadSequentially(paramArrayOfString, paramOnLoadListener, paramArrayOfLoadOptions);
    }
  }
  
  public void b(String paramString, OnLoadListener paramOnLoadListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService != null) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService.download(paramString, paramOnLoadListener);
    }
  }
  
  public void b(String[] paramArrayOfString, OnLoadListener paramOnLoadListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService != null) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadApiISoloadService.download(paramArrayOfString, paramOnLoadListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.SoLoadManager
 * JD-Core Version:    0.7.0.1
 */