package dov.com.qq.im.ae;

import biim;
import biqk;
import biqn;
import biwb;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

public class AEPituCameraUnit$20
  implements Runnable
{
  public AEPituCameraUnit$20(biim parambiim, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((biim.a(this.this$0) != null) && (biim.a(this.this$0).a(131072) != null)) {
      biim.a(this.this$0).a(131072).a(114, this.a);
    }
    if ((biqk.a().c) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      biqk.a().c = false;
      biim.a(this.this$0).a(589825, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.20
 * JD-Core Version:    0.7.0.1
 */