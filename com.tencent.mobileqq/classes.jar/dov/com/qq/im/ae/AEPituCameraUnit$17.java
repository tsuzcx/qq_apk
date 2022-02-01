package dov.com.qq.im.ae;

import bndy;
import bnpc;
import bnpf;
import bnvb;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

public class AEPituCameraUnit$17
  implements Runnable
{
  public AEPituCameraUnit$17(bndy parambndy, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((bndy.a(this.this$0) != null) && (bndy.a(this.this$0).a(131072) != null)) {
      bndy.a(this.this$0).a(131072).a(114, this.a);
    }
    if ((bnpc.a().c) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      bnpc.a().c = false;
      bndy.a(this.this$0).a(589825, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.17
 * JD-Core Version:    0.7.0.1
 */