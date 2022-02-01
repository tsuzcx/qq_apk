package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DownloaderGetCodeServer
{
  private static DownloaderGetCodeServer jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new DownloaderGetCodeServer.1(this, "Module_DownloaderGetCodeServer");
  private DownloaderGetCodeServer.GetAuthCodeObserver jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer$GetAuthCodeObserver = new DownloaderGetCodeServer.GetAuthCodeObserver(this, null);
  private Map<String, Bundle> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public static DownloaderGetCodeServer a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer == null) {
      try
      {
        jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer = new DownloaderGetCodeServer();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer;
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeServer
 * JD-Core Version:    0.7.0.1
 */