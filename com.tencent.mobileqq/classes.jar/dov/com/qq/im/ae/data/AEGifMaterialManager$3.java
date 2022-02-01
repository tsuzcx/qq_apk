package dov.com.qq.im.ae.data;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import java.io.File;
import java.util.Map;

class AEGifMaterialManager$3
  implements Runnable
{
  AEGifMaterialManager$3(AEGifMaterialManager paramAEGifMaterialManager, MetaMaterial paramMetaMaterial, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (AEGifMaterialManager.a(this.this$0, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial))
    {
      AEGifMaterialManager.a(this.this$0, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      AEGifMaterialManager.a(this.this$0).remove(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
    }
    do
    {
      return;
      if (this.this$0.a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))
      {
        AEGifMaterialManager.a(this.this$0, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, 0);
        return;
      }
      String str = AEPath.CAMERA.FILES.h;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new AEGifMaterialManager.3.1(this, str);
      localHttpNetReq.mReqUrl = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.packageUrl;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(str, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("AEGifMaterialManager", 2, "startDownloadTemplate, url: " + this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.packageUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEGifMaterialManager.3
 * JD-Core Version:    0.7.0.1
 */