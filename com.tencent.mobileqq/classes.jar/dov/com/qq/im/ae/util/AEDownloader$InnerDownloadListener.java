package dov.com.qq.im.ae.util;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class AEDownloader$InnerDownloadListener
  implements INetEngineListener
{
  private AEDownloader.DownloadListener jdField_a_of_type_DovComQqImAeUtilAEDownloader$DownloadListener;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  AEDownloader$InnerDownloadListener(String paramString1, String paramString2, AEDownloader.DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_DovComQqImAeUtilAEDownloader$DownloadListener = paramDownloadListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    AEQLog.b("AEDownloader", "onResp url: " + this.jdField_a_of_type_JavaLangString + " resultcode: " + paramNetResp.mResult);
    if (this.jdField_a_of_type_DovComQqImAeUtilAEDownloader$DownloadListener != null) {
      this.jdField_a_of_type_DovComQqImAeUtilAEDownloader$DownloadListener.a(paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_DovComQqImAeUtilAEDownloader$DownloadListener != null) {
      this.jdField_a_of_type_DovComQqImAeUtilAEDownloader$DownloadListener.a((int)((float)paramLong1 / (float)paramLong2 * 100.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.util.AEDownloader.InnerDownloadListener
 * JD-Core Version:    0.7.0.1
 */