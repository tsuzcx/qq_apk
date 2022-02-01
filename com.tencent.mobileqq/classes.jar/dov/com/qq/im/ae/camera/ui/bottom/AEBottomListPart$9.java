package dov.com.qq.im.ae.camera.ui.bottom;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

class AEBottomListPart$9
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEBottomListPart$9(AEBottomListPart paramAEBottomListPart) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    AEQLog.b("AEBottomListPart", "loadAndHandleData---download finish, isSuccess=" + paramBoolean);
    if (!paramBoolean)
    {
      AEBottomListPart.a(this.a, true);
      ThreadManager.getUIHandler().post(new AEBottomListPart.9.1(this));
    }
    AEBottomListPart.a(this.a).countDown();
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if ((paramInt > 1) && (paramInt <= 100)) {
      ThreadManager.getUIHandler().post(new AEBottomListPart.9.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.9
 * JD-Core Version:    0.7.0.1
 */