package dov.com.qq.im.ae.play;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;

class PlayDownloadManagerWrap$DownloadProcessListener
  implements AEMaterialDownloader.MaterialDownloadListener
{
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    paramAEMaterialMetaData.f = false;
    if (paramBoolean) {
      paramAEMaterialMetaData.e = true;
    }
    for (;;)
    {
      PlayDownloadManagerWrap.getInstance().notifyDownloadFinish(paramAEMaterialMetaData, paramBoolean);
      PlayDownloadManagerWrap.access$300(PlayDownloadManagerWrap.getInstance(), paramAEMaterialMetaData.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + paramAEMaterialMetaData.a);
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    PlayDownloadManagerWrap.getInstance().notifyDownloadProgress(paramAEMaterialMetaData.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.DownloadProcessListener
 * JD-Core Version:    0.7.0.1
 */