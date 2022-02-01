package com.tencent.mobileqq.mutualmark;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class MutualMarkManger
  implements Manager
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "data.json", "icon_close.png" };
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ZipResourcesDownloader jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader;
  
  public MutualMarkManger(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader = new ZipResourcesDownloader();
  }
  
  public static MutualMarkManger a(QQAppInterface paramQQAppInterface)
  {
    return (MutualMarkManger)paramQQAppInterface.getManager(QQManagerFactory.MUTUAL_MARK_MANAGER);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return ZipResourcesDownloader.a(paramString1, paramString2) + "/";
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (a(paramString1, paramString2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "checkDownloadCartoonResource download url:" + paramString1 + " md5:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10089, "prd", paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString, null);
  }
  
  public void a(String paramString1, String paramString2, ZipResourcesDownloader.OnZipResourcesDownloadCallback paramOnZipResourcesDownloadCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "prepareCartoonResources url:" + paramString1 + " md5:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10089, "prd", paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString, paramOnZipResourcesDownloadCallback);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = ZipResourcesDownloader.a(paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "isCartoonResourceReady url:" + paramString1 + " md5:" + paramString2 + " res:" + bool);
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkManger
 * JD-Core Version:    0.7.0.1
 */