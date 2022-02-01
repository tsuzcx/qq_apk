package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class HttpDownloader$1
  implements INetEngineListener
{
  long fileSize = 0L;
  
  HttpDownloader$1(long paramLong, boolean paramBoolean, IHttpEngineService paramIHttpEngineService, URLDrawableHandler paramURLDrawableHandler, String paramString, HttpDownloaderParams paramHttpDownloaderParams) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.fileSize + " file.path = " + paramNetResp.mReq.mOutPath + " resp.result = " + paramNetResp.mResult);
    }
    if (paramNetResp.mResult == 3) {
      return;
    }
    boolean bool1;
    if (paramNetResp.mResult == 0)
    {
      bool1 = bool2;
      if (this.val$handler != null)
      {
        this.val$handler.onFileDownloadSucceed(this.fileSize);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        HttpDownloader.reportForStructPicDown(bool1, new URL(this.val$url), true, paramNetResp.mHttpCode, paramNetResp.mRedirectCount, null, this.val$param);
        return;
      }
      catch (Exception paramNetResp)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.val$handler != null)
      {
        this.val$handler.onFileDownloadFailed(paramNetResp.mResult);
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " StructPicLimit onUpdateProgeress totalLen = " + paramLong2 + " ,curOffset = " + paramLong1 + ",picMaxLen = " + this.val$picMaxLen);
    }
    this.fileSize = paramLong2;
    if ((this.val$openSwitch) && ((this.fileSize > this.val$picMaxLen) || (paramLong1 > this.val$picMaxLen)))
    {
      this.val$netEngine.cancelReq(paramNetReq);
      if (this.val$handler != null) {
        this.val$handler.onFileDownloadFailed(17174);
      }
      QLog.i("HttpDownloader", 2, " StructPicLimit file too big to download, cancel the download req");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloader.1
 * JD-Core Version:    0.7.0.1
 */