package dov.com.qq.im.ae;

import bljy;
import bluy;
import blvb;
import bmas;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

public class AEPituCameraUnit$23
  implements Runnable
{
  public AEPituCameraUnit$23(bljy parambljy, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.a(131072) != null)) {
      this.this$0.a.a(131072).a(114, this.a);
    }
    if ((bluy.a().c) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      bluy.a().c = false;
      this.this$0.a.a(589825, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.23
 * JD-Core Version:    0.7.0.1
 */