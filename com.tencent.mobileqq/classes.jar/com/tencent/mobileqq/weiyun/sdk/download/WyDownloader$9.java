package com.tencent.mobileqq.weiyun.sdk.download;

import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.Iterator;
import java.util.List;

class WyDownloader$9
  implements ThreadPool.Job<Void>
{
  WyDownloader$9(WyDownloader paramWyDownloader, List paramList) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadWyDownloader.b(l);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader.9
 * JD-Core Version:    0.7.0.1
 */