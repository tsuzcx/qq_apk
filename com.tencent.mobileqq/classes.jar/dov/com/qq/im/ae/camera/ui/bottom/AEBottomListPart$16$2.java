package dov.com.qq.im.ae.camera.ui.bottom;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.os.MqqHandler;

class AEBottomListPart$16$2
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEBottomListPart$16$2(AEBottomListPart.16 param16, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" download finish: ").append(paramBoolean).append(" id: ");
    if (paramAEMaterialMetaData == null) {}
    for (paramAEMaterialMetaData = "null";; paramAEMaterialMetaData = paramAEMaterialMetaData.a)
    {
      AEQLog.b("AEBottomListPart", paramAEMaterialMetaData);
      if (paramBoolean)
      {
        this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.e = true;
        ThreadManager.getUIHandler().post(new AEBottomListPart.16.2.1(this));
      }
      return;
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.16.2
 * JD-Core Version:    0.7.0.1
 */