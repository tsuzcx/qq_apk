package com.tencent.mobileqq.precover;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class PrecoverResDownloader$DownloadTask
  extends AbsPreDownloadTask
{
  PrecoverResource jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  
  public PrecoverResDownloader$DownloadTask(QQAppInterface paramQQAppInterface, PrecoverResource paramPrecoverResource, HttpNetReq paramHttpNetReq)
  {
    super(paramQQAppInterface, paramPrecoverResource.md5);
    this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource = paramPrecoverResource;
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
  }
  
  public void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realCancel");
    }
    PrecoverManager localPrecoverManager = (PrecoverManager)this.app.getManager(QQManagerFactory.PRECOVER_MANAGER);
    if ((localPrecoverManager != null) && (localPrecoverManager.a() != null)) {
      localPrecoverManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource.md5);
    }
  }
  
  public void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realStart");
    }
    PrecoverManager localPrecoverManager = (PrecoverManager)this.app.getManager(QQManagerFactory.PRECOVER_MANAGER);
    if ((localPrecoverManager != null) && (localPrecoverManager.a() != null)) {
      localPrecoverManager.a().a(this);
    }
  }
  
  public String toString()
  {
    return "[DownloadTask] req=" + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq + ", res=" + this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.precover.PrecoverResDownloader.DownloadTask
 * JD-Core Version:    0.7.0.1
 */