package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import bncv;
import bnda;
import java.util.List;

public class AEBottomListPart$7
  implements Runnable
{
  public AEBottomListPart$7(bnda parambnda, List paramList) {}
  
  public void run()
  {
    if ((bnda.a(this.this$0) != null) && (!bnda.b(this.this$0).isFinishing()))
    {
      if (bnda.b(this.this$0)) {
        this.this$0.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
      }
      this.this$0.jdField_a_of_type_Bncv.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7
 * JD-Core Version:    0.7.0.1
 */