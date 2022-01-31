package dov.com.qq.im.ae;

import bijd;
import birb;
import bire;
import biws;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

public class AEPituCameraUnit$20
  implements Runnable
{
  public AEPituCameraUnit$20(bijd parambijd, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((bijd.a(this.this$0) != null) && (bijd.a(this.this$0).a(131072) != null)) {
      bijd.a(this.this$0).a(131072).a(114, this.a);
    }
    if ((birb.a().c) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      birb.a().c = false;
      bijd.a(this.this$0).a(589825, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.20
 * JD-Core Version:    0.7.0.1
 */