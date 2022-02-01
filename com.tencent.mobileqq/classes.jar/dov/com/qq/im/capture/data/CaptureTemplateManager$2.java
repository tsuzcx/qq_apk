package dov.com.qq.im.capture.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class CaptureTemplateManager$2
  implements Runnable
{
  CaptureTemplateManager$2(CaptureTemplateManager paramCaptureTemplateManager, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (CaptureTemplateManager.a(this.this$0, this.a, this.b)) {}
    do
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new CaptureTemplateManager.2.1(this);
      localHttpNetReq.mReqUrl = this.c;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = this.a;
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)this.this$0.getApp().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("CaptureTemplateManager", 2, "startDownloadTemplate, url: " + this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */