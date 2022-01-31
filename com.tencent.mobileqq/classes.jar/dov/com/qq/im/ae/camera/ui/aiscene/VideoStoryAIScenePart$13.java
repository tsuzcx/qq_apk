package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import bkle;
import bkqa;
import blen;
import blnl;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class VideoStoryAIScenePart$13
  implements Runnable
{
  public VideoStoryAIScenePart$13(bkqa parambkqa, QIMFilterCategoryItem paramQIMFilterCategoryItem, blnl paramblnl, Bundle paramBundle) {}
  
  public void run()
  {
    if ((bkqa.a(this.this$0) != null) && (!bkqa.a(this.this$0).b())) {}
    while ((bkqa.c(this.this$0) == null) || (bkqa.a(this.this$0).b() != 2)) {
      return;
    }
    bkqa.b(this.this$0, true);
    blen.a().d(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    this.jdField_a_of_type_Blnl.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, bkqa.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.13
 * JD-Core Version:    0.7.0.1
 */