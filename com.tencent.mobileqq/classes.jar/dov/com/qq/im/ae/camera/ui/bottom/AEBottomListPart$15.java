package dov.com.qq.im.ae.camera.ui.bottom;

import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import java.util.List;

class AEBottomListPart$15
  implements Runnable
{
  AEBottomListPart$15(AEBottomListPart paramAEBottomListPart) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.b(this.this$0.a());
    this.this$0.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a((List)localObject);
    localObject = AEMaterialManager.a();
    if ((localObject == null) || (((AEMaterialMetaData)localObject).equals(AEMaterialMetaData.a)))
    {
      this.this$0.c(0);
      return;
    }
    AEBottomListPart.a(this.this$0, (AEMaterialMetaData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.15
 * JD-Core Version:    0.7.0.1
 */