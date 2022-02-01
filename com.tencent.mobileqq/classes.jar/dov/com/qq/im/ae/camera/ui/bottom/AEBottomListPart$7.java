package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import blpm;
import blpr;
import java.util.List;

public class AEBottomListPart$7
  implements Runnable
{
  public AEBottomListPart$7(blpr paramblpr, List paramList) {}
  
  public void run()
  {
    if ((blpr.a(this.this$0) != null) && (!blpr.b(this.this$0).isFinishing()))
    {
      if (blpr.b(this.this$0)) {
        this.this$0.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
      }
      this.this$0.jdField_a_of_type_Blpm.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7
 * JD-Core Version:    0.7.0.1
 */