package dov.com.qq.im.ae.play;

import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;

class PlayDownloadManagerWrap$1
  implements Runnable
{
  PlayDownloadManagerWrap$1(PlayDownloadManagerWrap paramPlayDownloadManagerWrap, AEMaterialManager paramAEMaterialManager, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener) {}
  
  public void run()
  {
    this.val$materialManager.a(this.val$materialManager.getApp(), this.val$templateInfo, this.val$downloadListener);
    this.val$templateInfo.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.1
 * JD-Core Version:    0.7.0.1
 */