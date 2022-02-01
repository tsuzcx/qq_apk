package com.tencent.mobileqq.shortvideo;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class PtvTemplateManager$14$1
  implements INetEngineListener
{
  PtvTemplateManager$14$1(PtvTemplateManager.14 param14) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.a.doodleUrl + " resultcode: " + paramNetResp.mHttpCode);
    }
    this.a.a.doodleUsable = this.a.this$0.a(this.a.a, false);
    if (this.a.a.doodleUsable) {}
    try
    {
      ZipUtils.unZipFile(new File(PtvTemplateManager.b, this.a.a.doodleName), PtvTemplateManager.c);
      if (paramNetResp.mResult == 0)
      {
        Object localObject = this.a.this$0.a();
        if (localObject != null)
        {
          localObject = (PreDownloadController)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
          if (((PreDownloadController)localObject).isEnable()) {
            ((PreDownloadController)localObject).preDownloadSuccess(this.a.a.doodleUrl, paramNetResp.mTotalFileLen);
          }
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.14.1
 * JD-Core Version:    0.7.0.1
 */