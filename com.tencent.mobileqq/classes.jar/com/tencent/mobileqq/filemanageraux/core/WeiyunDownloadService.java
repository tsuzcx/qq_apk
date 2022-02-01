package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.concurrent.ConcurrentHashMap;

public class WeiyunDownloadService
{
  private static WeiyunDownloadService jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunDownloadService;
  public static String a;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new WeiyunDownloadService.WeiyunDownloadServiceQIPCModule(this, "Module_WeiyunDownloadService");
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public static WeiyunDownloadService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunDownloadService == null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunDownloadService = new WeiyunDownloadService();
      return jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunDownloadService;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiyunDownloadService
 * JD-Core Version:    0.7.0.1
 */