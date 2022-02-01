package com.tencent.mobileqq.weiyun.sdk.download;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;

class WyDownloader$5
  implements ThreadPool.Job<Void>
{
  WyDownloader$5(WyDownloader paramWyDownloader, HttpNetReq paramHttpNetReq) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    WyDownloader.a(this.b).sendReq(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader.5
 * JD-Core Version:    0.7.0.1
 */