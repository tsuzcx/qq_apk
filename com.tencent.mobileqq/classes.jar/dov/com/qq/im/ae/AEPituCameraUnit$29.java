package dov.com.qq.im.ae;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class AEPituCameraUnit$29
  implements Runnable
{
  AEPituCameraUnit$29(AEPituCameraUnit paramAEPituCameraUnit, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.a(131072) != null)) {
      this.this$0.a.a(131072).a(114, this.a);
    }
    if ((this.this$0.a != null) && (this.this$0.a.a(786432) != null)) {
      this.this$0.a.a(786432).a(114, this.a);
    }
    Object localObject2 = AEMaterialManager.b();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = AEMaterialManager.a();
    }
    if (AEPituCameraUnit.a(this.this$0, (AEMaterialMetaData)localObject1))
    {
      ((AEMaterialMetaData)localObject1).c = false;
      this.this$0.a.a(589825, new Object[0]);
      localObject2 = AEBaseDataReporter.a();
      if (((AEMaterialMetaData)localObject1).a != null) {
        break label158;
      }
    }
    label158:
    for (localObject1 = "none";; localObject1 = ((AEMaterialMetaData)localObject1).a)
    {
      ((AEBaseDataReporter)localObject2).p((String)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.29
 * JD-Core Version:    0.7.0.1
 */