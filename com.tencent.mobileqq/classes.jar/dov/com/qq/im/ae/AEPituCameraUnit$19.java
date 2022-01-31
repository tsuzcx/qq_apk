package dov.com.qq.im.ae;

import bkpl;
import bkzy;
import blab;
import blft;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

public class AEPituCameraUnit$19
  implements Runnable
{
  public AEPituCameraUnit$19(bkpl parambkpl, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((bkpl.a(this.this$0) != null) && (bkpl.a(this.this$0).a(131072) != null)) {
      bkpl.a(this.this$0).a(131072).a(114, this.a);
    }
    if ((bkzy.a().c) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      bkzy.a().c = false;
      bkpl.a(this.this$0).a(589825, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.19
 * JD-Core Version:    0.7.0.1
 */