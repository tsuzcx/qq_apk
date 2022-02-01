package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.qroute.QRoute;

public class WeiYunPreviewController
  extends FilePreViewControllerBase
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public WeiYunPreviewController(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    b();
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public boolean a()
  {
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQFileEngine.class, "")).getWeiYunPreview(this.jdField_a_of_type_JavaLangString, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new WeiYunPreviewController.1(this);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunPreviewController
 * JD-Core Version:    0.7.0.1
 */