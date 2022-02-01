package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class HttpDownloader$1
  implements INetEngineListener
{
  long fileSize = 0L;
  
  HttpDownloader$1(IHttpEngineService paramIHttpEngineService, URLDrawableHandler paramURLDrawableHandler, String paramString, HttpDownloaderParams paramHttpDownloaderParams) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" structMsgCover download onResp result fileSize = ");
      ((StringBuilder)localObject).append(this.fileSize);
      ((StringBuilder)localObject).append(" file.path = ");
      ((StringBuilder)localObject).append(paramNetResp.mReq.mOutPath);
      ((StringBuilder)localObject).append(" resp.result = ");
      ((StringBuilder)localObject).append(paramNetResp.mResult);
      QLog.d("HttpDownloader", 2, ((StringBuilder)localObject).toString());
    }
    if (paramNetResp.mResult == 3) {
      return;
    }
    boolean bool;
    if (paramNetResp.mResult == 0)
    {
      localObject = this.val$handler;
      if (localObject != null) {
        ((URLDrawableHandler)localObject).onFileDownloadSucceed(this.fileSize);
      }
      bool = true;
    }
    else
    {
      localObject = this.val$handler;
      if (localObject != null) {
        ((URLDrawableHandler)localObject).onFileDownloadFailed(paramNetResp.mResult);
      }
      bool = false;
    }
    try
    {
      HttpDownloader.reportForStructPicDown(bool, new URL(this.val$url), true, paramNetResp.mHttpCode, paramNetResp.mRedirectCount, null, this.val$param);
      return;
    }
    catch (Exception paramNetResp) {}
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" StructPicLimit onUpdateProgeress totalLen = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" ,curOffset = ");
      localStringBuilder.append(paramLong1);
      QLog.i("HttpDownloader", 2, localStringBuilder.toString());
    }
    this.fileSize = paramLong2;
    if (!HttpDownloader.checkDownloadFileSize(this.val$netEngine, this.val$handler, paramNetReq, paramLong1, paramLong2)) {
      QLog.i("HttpDownloader", 2, " StructPicLimit file too big to download, cancel the download req");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloader.1
 * JD-Core Version:    0.7.0.1
 */