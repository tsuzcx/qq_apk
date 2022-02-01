package dov.com.qq.im.ae;

import bmxa;
import bnkb;
import bnke;
import bnqc;
import bnqm;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

public class AEPituCameraUnit$28
  implements Runnable
{
  public AEPituCameraUnit$28(bmxa parambmxa, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.a(131072) != null)) {
      this.this$0.a.a(131072).a(114, this.a);
    }
    if ((this.this$0.a != null) && (this.this$0.a.a(786432) != null)) {
      this.this$0.a.a(786432).a(114, this.a);
    }
    Object localObject2 = bnkb.b();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bnkb.a();
    }
    if ((localObject1 != null) && (((bnke)localObject1).c) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      ((bnke)localObject1).c = false;
      this.this$0.a.a(589825, new Object[0]);
      localObject2 = bnqm.a();
      if (((bnke)localObject1).a != null) {
        break label172;
      }
    }
    label172:
    for (localObject1 = "none";; localObject1 = ((bnke)localObject1).a)
    {
      ((bnqm)localObject2).m((String)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.28
 * JD-Core Version:    0.7.0.1
 */