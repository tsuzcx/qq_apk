package com.tencent.mobileqq.weiyun.sdk.download;

import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.HashMap;

class WyDownloader$6
  implements ThreadPool.Job<Void>
{
  WyDownloader$6(WyDownloader paramWyDownloader, Long paramLong, NetReq paramNetReq) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = (DownloadJobContext)WyDownloader.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadWyDownloader).get(this.jdField_a_of_type_JavaLangLong);
    if ((paramJobContext != null) && (!paramJobContext.d())) {
      WyDownloader.b(this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadWyDownloader).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
    } else {
      WyDownloader.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadWyDownloader, this.jdField_a_of_type_JavaLangLong.longValue());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader.6
 * JD-Core Version:    0.7.0.1
 */