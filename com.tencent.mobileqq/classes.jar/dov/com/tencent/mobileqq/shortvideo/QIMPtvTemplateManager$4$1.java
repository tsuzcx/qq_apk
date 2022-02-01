package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import java.io.File;
import java.io.IOException;

class QIMPtvTemplateManager$4$1
  implements INetEngineListener
{
  QIMPtvTemplateManager$4$1(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + paramNetResp.mHttpCode);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      ZipUtils.unZipFile(new File(QIMPtvTemplateManager.a(), this.a.a.name), QIMPtvTemplateManager.a);
      if (this.a.this$0.getApp() != null) {
        this.a.this$0.getApp().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
      }
      return;
    }
    catch (IOException paramNetResp)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramNetResp.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4.1
 * JD-Core Version:    0.7.0.1
 */