package dov.com.qq.im.ae.data;

import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.util.AEQLog;

class AEMaterialManager$4
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEMaterialManager$4(AEMaterialManager paramAEMaterialManager, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager, paramAEMaterialMetaData);
    if (localAEMaterialMetaData != null) {
      localAEMaterialMetaData.e = AEMaterialManager.a(paramAEMaterialMetaData);
    }
    if (this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener != null)
    {
      this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener.onDownloadFinish(paramAEMaterialMetaData, paramBoolean, paramInt);
      if (localAEMaterialMetaData != null) {
        AEQLog.b("AEMaterialManager", "【END】onDownloadFinish :" + localAEMaterialMetaData.a);
      }
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener != null) {
      this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener.onProgressUpdate(paramAEMaterialMetaData, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialManager.4
 * JD-Core Version:    0.7.0.1
 */