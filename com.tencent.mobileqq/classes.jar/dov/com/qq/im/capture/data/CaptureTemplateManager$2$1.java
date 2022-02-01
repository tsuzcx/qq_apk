package dov.com.qq.im.capture.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;

class CaptureTemplateManager$2$1
  implements INetEngineListener
{
  CaptureTemplateManager$2$1(CaptureTemplateManager.2 param2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " resultcode: " + paramNetResp.mHttpCode);
    }
    boolean bool = false;
    if (paramNetResp.mResult == 0)
    {
      bool = CaptureTemplateManager.a(this.a.this$0, this.a.a, this.a.b);
      if (bool)
      {
        PreDownloadController localPreDownloadController = (PreDownloadController)this.a.this$0.getApp().getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
        if (localPreDownloadController.isEnable()) {
          localPreDownloadController.preDownloadSuccess(this.a.c, paramNetResp.mTotalFileLen);
        }
      }
    }
    if (!bool) {
      CaptureTemplateManager.a(this.a.this$0, this.a.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.c + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureTemplateManager.2.1
 * JD-Core Version:    0.7.0.1
 */