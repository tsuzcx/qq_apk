package com.tencent.mobileqq.mutualmark;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
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
    switch (paramNetResp.mResult)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a == null) {
        break;
      }
    }
    for (Object localObject = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((PreDownloadController)localObject).preDownloadSuccess(str, paramNetResp.mTotalFileLen);
      }
      paramNetResp = (HttpNetReq)paramNetResp.mReq;
      if (ZipResourcesDownloader.a(paramNetResp.mOutPath, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(ZipResourcesDownloader.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
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
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a != null) {}
      for (paramNetResp = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader.a.get();; paramNetResp = null)
      {
        if (paramNetResp != null) {
          paramNetResp.preDownloadSuccess(str, -1L);
        }
        ZipResourcesDownloader.a(this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentMobileqqMutualmarkZipResourcesDownloader$OnZipResourcesDownloadCallback);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).mReqUrl, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.ZipResourcesDownloader.2
 * JD-Core Version:    0.7.0.1
 */