package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.CaptureContext;
import java.io.File;

class QIMPtvTemplateManager$4
  implements Runnable
{
  QIMPtvTemplateManager$4(QIMPtvTemplateManager paramQIMPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a)) {
      this.a.usable = true;
    }
    for (;;)
    {
      return;
      this.a.usable = false;
      int i = (int)(FileUtils.a() / 1024.0F / 1024.0F);
      int j = (int)(this.a.sizeFree * 1024.0D);
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "preDownloadTemplates getAvailableInnernalMemorySize: " + i + " mSizeFree: " + j);
      }
      if (i < j)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "preDownloadTemplates return getAvailableInnernalMemorySize: " + i + " mSizeFree: " + j);
        }
      }
      else
      {
        HttpNetReq localHttpNetReq = new HttpNetReq();
        localHttpNetReq.mCallback = new QIMPtvTemplateManager.4.1(this);
        localHttpNetReq.mReqUrl = this.a.resurl;
        localHttpNetReq.mHttpMethod = 0;
        localHttpNetReq.mOutPath = new File(QIMPtvTemplateManager.a(), this.a.name).getPath();
        localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
        try
        {
          AppInterface localAppInterface = CaptureContext.a();
          if (localAppInterface != null)
          {
            ((IHttpEngineService)((PeakAppInterface)localAppInterface).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
            if (QLog.isColorLevel())
            {
              QLog.i("QIMPtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + this.a.resurl);
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */