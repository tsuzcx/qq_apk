package dov.com.qq.im;

import bgxx;
import bgya;
import bhcw;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;
import wus;

public class AEPituCameraUnit$16
  implements Runnable
{
  public AEPituCameraUnit$16(bhcw parambhcw, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((bhcw.a(this.this$0) != null) && (bhcw.a(this.this$0).a(131072) != null)) {
      bhcw.a(this.this$0).a(131072).a(114, this.a);
    }
    if ((bgxx.a().c) && (LogicDataManager.getInstance().getEditableWMElement().size() > 0))
    {
      bgxx.a().c = false;
      bhcw.a(this.this$0).a(589825, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AEPituCameraUnit.16
 * JD-Core Version:    0.7.0.1
 */