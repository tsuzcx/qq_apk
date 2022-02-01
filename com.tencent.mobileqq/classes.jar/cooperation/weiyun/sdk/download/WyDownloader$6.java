package cooperation.weiyun.sdk.download;

import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.HashMap;

class WyDownloader$6
  implements ThreadPool.Job<Void>
{
  WyDownloader$6(WyDownloader paramWyDownloader, Long paramLong, NetReq paramNetReq) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = (DownloadJobContext)WyDownloader.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader).get(this.jdField_a_of_type_JavaLangLong);
    if ((paramJobContext == null) || (paramJobContext.d())) {
      WyDownloader.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader, this.jdField_a_of_type_JavaLangLong.longValue());
    }
    for (;;)
    {
      return null;
      WyDownloader.b(this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.WyDownloader.6
 * JD-Core Version:    0.7.0.1
 */