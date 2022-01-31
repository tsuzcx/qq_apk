package com.tencent.open.downloadnew;

import alhq;
import alhr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DownloaderGetCodeServer
{
  private static DownloaderGetCodeServer jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer;
  private alhr jdField_a_of_type_Alhr = new alhr(this, null);
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new alhq(this, "Module_DownloaderGetCodeServer");
  private Map jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public static DownloaderGetCodeServer a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer == null) {}
    try
    {
      jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer = new DownloaderGetCodeServer();
      return jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeServer
 * JD-Core Version:    0.7.0.1
 */