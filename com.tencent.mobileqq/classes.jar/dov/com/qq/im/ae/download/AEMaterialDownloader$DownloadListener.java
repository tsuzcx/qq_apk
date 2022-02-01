package dov.com.qq.im.ae.download;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.aiscene.TTAutoAISceneAni;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.data.AEPreDownloadResMetaData;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import java.io.File;

class AEMaterialDownloader$DownloadListener
  implements INetEngineListener
{
  private AEMaterialMetaData jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
  private AEMaterialDownloader.MaterialDownloadListener jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener;
  private String jdField_a_of_type_JavaLangString;
  
  public AEMaterialDownloader$DownloadListener(AEMaterialMetaData paramAEMaterialMetaData, String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener = paramMaterialDownloadListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(AEMaterialDownloader.a(), 2, "onResp url: " + this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.d + " resultcode: " + paramNetResp.mHttpCode);
    }
    if ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData instanceof AEPreDownloadResMetaData)) {
      TTAutoAISceneAni.a((AEPreDownloadResMetaData)this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData);
    }
    for (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_Boolean = true;; this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_Boolean = AEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData))
    {
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener != null) {
        this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener.onDownloadFinish(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_Boolean, paramNetResp.mHttpCode);
      }
      if (paramNetResp.mErrCode == 0) {
        break;
      }
      AEBaseDataReporter.a().a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString, paramNetResp.mErrCode, paramNetResp.reqCost, 0L, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((paramNetResp.mErrCode == 0) && (!this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_Boolean))
    {
      AEBaseDataReporter.a().a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString, 1111, paramNetResp.reqCost, 0L, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_f_of_type_JavaLangString);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    AEBaseDataReporter.a().a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString, paramNetResp.mErrCode, paramNetResp.reqCost, l1, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b = paramLong2;
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener != null) {
      this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener.onProgressUpdate(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEMaterialDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */