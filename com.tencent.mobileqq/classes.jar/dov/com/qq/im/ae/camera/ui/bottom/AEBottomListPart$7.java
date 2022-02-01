package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import java.util.List;

class AEBottomListPart$7
  implements Runnable
{
  AEBottomListPart$7(AEBottomListPart paramAEBottomListPart, List paramList) {}
  
  public void run()
  {
    if ((AEBottomListPart.a(this.this$0) != null) && (!AEBottomListPart.b(this.this$0).isFinishing()))
    {
      if (AEBottomListPart.b(this.this$0)) {
        this.this$0.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
      }
      this.this$0.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7
 * JD-Core Version:    0.7.0.1
 */