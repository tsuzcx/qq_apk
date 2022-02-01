package com.tencent.mobileqq.mutualmark;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class ZipResourcesDownloader$2
  implements HttpEngineTask.IHttpEngineTask
{
  ZipResourcesDownloader$2(ZipResourcesDownloader paramZipResourcesDownloader, String paramString, String[] paramArrayOfString, ZipResourcesDownloader.OnZipResourcesDownloadCallback paramOnZipResourcesDownloadCallback) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramHttpEngineTask.httpReq.mReqUrl }));
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    String str = ((HttpNetReq)paramNetResp.mReq).mReqUrl;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(paramNetResp.mResult) }));
    }
    int i = paramNetResp.mResult;
    Object localObject2 = null;
    Object localObject1 = null;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramNetResp = (NetResp)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a != null) {
        paramNetResp = (IPreDownloadController)this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a.get();
      }
      if (paramNetResp != null) {
        paramNetResp.preDownloadSuccess(str, -1L);
      }
      ZipResourcesDownloader.a(this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader$OnZipResourcesDownloadCallback);
      return;
    }
    localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a != null) {
      localObject1 = (IPreDownloadController)this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a.get();
    }
    if (localObject1 != null) {
      ((IPreDownloadController)localObject1).preDownloadSuccess(str, paramNetResp.mTotalFileLen);
    }
    paramNetResp = (HttpNetReq)paramNetResp.mReq;
    if (ZipResourcesDownloader.a(paramNetResp.mOutPath, this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = new File(ZipResourcesDownloader.a(this.jdField_a_of_type_JavaLangString));
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      boolean bool1 = ZipResourcesDownloader.b(paramNetResp.mOutPath, ZipResourcesDownloader.a(this.jdField_a_of_type_JavaLangString));
      boolean bool2 = ZipResourcesDownloader.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      ZipResourcesDownloader.a(this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader$OnZipResourcesDownloadCallback);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
    }
    ZipResourcesDownloader.a(paramNetResp.mOutPath);
    ZipResourcesDownloader.a(this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader$OnZipResourcesDownloadCallback);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).mReqUrl, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.ZipResourcesDownloader.2
 * JD-Core Version:    0.7.0.1
 */