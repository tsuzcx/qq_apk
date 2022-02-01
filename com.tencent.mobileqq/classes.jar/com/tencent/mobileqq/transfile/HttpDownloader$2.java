package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;

class HttpDownloader$2
  implements INetEngine.INetEngineListener
{
  HttpDownloader$2(HttpDownloader paramHttpDownloader, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void onResp(NetResp paramNetResp) {}
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if ((paramLong1 > 0L) && (paramLong2 > 0L)) {
      i = (int)((float)paramLong1 / (float)paramLong2 * 9500.0F);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloader.2
 * JD-Core Version:    0.7.0.1
 */