package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

public class WeiyunTask
{
  private final IDownloadStatusListener jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIDownloadStatusListener;
  private final UploadManager.IUploadStatusListener jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadManager$IUploadStatusListener;
  private final Object jdField_a_of_type_JavaLangObject;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private String b;
  
  public WeiyunTask(String paramString, Object paramObject, boolean paramBoolean, UploadManager.IUploadStatusListener paramIUploadStatusListener, IDownloadStatusListener paramIDownloadStatusListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadManager$IUploadStatusListener = paramIUploadStatusListener;
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIDownloadStatusListener = paramIDownloadStatusListener;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WeiyunTransmissionGlobal.getInstance().getUploadManager().removeJob(this.jdField_a_of_type_JavaLangString);
      return;
    }
    ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).removeJob(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiyunTask
 * JD-Core Version:    0.7.0.1
 */