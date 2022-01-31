import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.FileUploadController.FileUploadListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.NormalVideoDeliverController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class lzn
  implements FileUploadController.FileUploadListener
{
  public lzn(NormalVideoDeliverController paramNormalVideoDeliverController) {}
  
  public void a()
  {
    NormalVideoDeliverController.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    NormalVideoDeliverController.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      NormalVideoDeliverController.a(this.a, 7);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      NormalVideoDeliverController.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      PublicAccountReportUtils.a(NormalVideoDeliverController.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(NormalVideoDeliverController.a(this.a)), String.valueOf(NormalVideoDeliverController.b(this.a)), String.valueOf(NormalVideoDeliverController.c(this.a) - NormalVideoDeliverController.d(this.a)), String.valueOf(NormalVideoDeliverController.e(this.a) - NormalVideoDeliverController.f(this.a)));
      NormalVideoDeliverController.a(this.a, 0, NormalVideoDeliverController.a(this.a), NormalVideoDeliverController.b(this.a), paramString1, paramString2, paramString3);
      return;
    case 1001: 
      NormalVideoDeliverController.b(this.a, 6);
      return;
    case 1002: 
      NormalVideoDeliverController.b(this.a, 5);
      return;
    case 1003: 
      NormalVideoDeliverController.b(this.a, 7);
      return;
    case 1004: 
      NormalVideoDeliverController.b(this.a, 7);
      NormalVideoDeliverController.c(this.a, 1004);
      PublicAccountReportUtils.a(NormalVideoDeliverController.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(NormalVideoDeliverController.a(this.a)), String.valueOf(NormalVideoDeliverController.b(this.a)), String.valueOf(NormalVideoDeliverController.c(this.a) - NormalVideoDeliverController.d(this.a)), String.valueOf(NormalVideoDeliverController.e(this.a) - NormalVideoDeliverController.f(this.a)));
      return;
    }
    NormalVideoDeliverController.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzn
 * JD-Core Version:    0.7.0.1
 */