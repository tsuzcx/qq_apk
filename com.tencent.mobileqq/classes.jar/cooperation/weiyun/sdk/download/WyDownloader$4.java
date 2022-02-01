package cooperation.weiyun.sdk.download;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class WyDownloader$4
  implements INetEngineListener
{
  WyDownloader$4(WyDownloader paramWyDownloader, WyDownloader.IDownloadListener paramIDownloadListener, String paramString1, String paramString2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      return;
    }
    if (paramNetResp.mResult == 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = paramNetResp.mErrCode;
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadListener.a(this.jdField_a_of_type_JavaLangString, this.b, bool, paramNetResp.mErrDesc, i);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadListener.a(this.jdField_a_of_type_JavaLangString, paramLong2, (float)paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.WyDownloader.4
 * JD-Core Version:    0.7.0.1
 */