package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;

class HttpDownloader$2
  implements INetEngineListener
{
  HttpDownloader$2(HttpDownloader paramHttpDownloader, IHttpEngineService paramIHttpEngineService, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void onResp(NetResp paramNetResp) {}
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (!HttpDownloader.checkDownloadFileSize(this.val$engineService, this.val$handler, paramNetReq, paramLong1, paramLong2)) {
      return;
    }
    if ((paramLong1 > 0L) && (paramLong2 > 0L))
    {
      int i = (int)((float)paramLong1 / (float)paramLong2 * 9500.0F);
      try
      {
        this.val$handler.publishProgress(i);
        return;
      }
      catch (Throwable paramNetReq)
      {
        QLog.e("HttpDownloader", 1, "onUpdateProgeress error.", paramNetReq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloader.2
 * JD-Core Version:    0.7.0.1
 */