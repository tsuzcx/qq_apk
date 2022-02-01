package dov.com.qq.im.ae;

import bmvk;
import bmvl;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.ttpic.filament.CmShowAssetsData;
import com.tencent.ttpic.filament.CmShowMaterialDisplayType;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import java.util.Map;

public class AECMShowCameraUnit$13
  implements Runnable
{
  public AECMShowCameraUnit$13(bmvk parambmvk, AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void run()
  {
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.dressResMap.putAll(this.a.namePathMap);
    localCmShowAssetsData.roleResDir = this.a.rolePath;
    localCmShowAssetsData.faceDataJsonStr = this.a.cmJsonString;
    if (bmvk.a(this.this$0).getmPTSticker() != null) {
      bmvk.a(this.this$0).getmPTSticker().setKapuMaterialDisplayType(CmShowMaterialDisplayType.CmShowMaterialDisplayTypeHead);
    }
    new BlendShapeThread(localCmShowAssetsData, new bmvl(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.13
 * JD-Core Version:    0.7.0.1
 */