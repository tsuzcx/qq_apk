package dov.com.qq.im.ae.data;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import java.io.File;
import java.io.IOException;
import java.util.Map;

class AEGifMaterialManager$3$1
  implements INetEngineListener
{
  AEGifMaterialManager$3$1(AEGifMaterialManager.3 param3, String paramString) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEGifMaterialManager", 2, "onResp url: " + this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.packageUrl + " resultcode: " + paramNetResp.mHttpCode);
    }
    if (AEGifMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a)) {}
    try
    {
      ZipUtils.unZipFile(new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.id), AEPath.CAMERA.FILES.i + File.separator);
      AEGifMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a);
      AEGifMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0).remove(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.id);
      return;
    }
    catch (IOException paramNetResp)
    {
      while (!QLog.isColorLevel()) {}
      paramNetResp.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    AEGifMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!AEGifMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0).containsKey(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.id)) {
      AEGifMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0).put(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.id, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEGifMaterialManager.3.1
 * JD-Core Version:    0.7.0.1
 */