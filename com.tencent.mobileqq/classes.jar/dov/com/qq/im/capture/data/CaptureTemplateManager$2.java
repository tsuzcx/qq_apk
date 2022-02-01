package dov.com.qq.im.capture.data;

import bmsa;
import bmsb;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class CaptureTemplateManager$2
  implements Runnable
{
  public CaptureTemplateManager$2(bmsa parambmsa, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (bmsa.a(this.this$0, this.a, this.b)) {}
    do
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new bmsb(this);
      localHttpNetReq.mReqUrl = this.c;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = this.a;
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      this.this$0.getApp().getNetEngine(0).sendReq(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("CaptureTemplateManager", 2, "startDownloadTemplate, url: " + this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */