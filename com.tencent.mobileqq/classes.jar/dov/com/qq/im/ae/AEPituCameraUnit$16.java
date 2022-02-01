package dov.com.qq.im.ae;

import bofh;
import boqr;
import boqu;
import bown;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

public class AEPituCameraUnit$16
  implements Runnable
{
  public AEPituCameraUnit$16(bofh parambofh, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((bofh.a(this.this$0) != null) && (bofh.a(this.this$0).a(131072) != null)) {
      bofh.a(this.this$0).a(131072).a(114, this.a);
    }
    if ((boqr.a().c) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      boqr.a().c = false;
      bofh.a(this.this$0).a(589825, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.16
 * JD-Core Version:    0.7.0.1
 */