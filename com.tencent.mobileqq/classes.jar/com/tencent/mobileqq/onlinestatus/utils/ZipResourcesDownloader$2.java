package com.tencent.mobileqq.onlinestatus.utils;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.qphone.base.util.QLog;

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
    ZipResourcesDownloader.a(this.d, paramNetResp, this.a, this.b, this.c);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).mReqUrl, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.ZipResourcesDownloader.2
 * JD-Core Version:    0.7.0.1
 */