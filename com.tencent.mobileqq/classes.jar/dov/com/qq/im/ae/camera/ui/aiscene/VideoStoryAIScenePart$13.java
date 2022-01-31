package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import bkpl;
import bkuh;
import bliu;
import blrx;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class VideoStoryAIScenePart$13
  implements Runnable
{
  public VideoStoryAIScenePart$13(bkuh parambkuh, QIMFilterCategoryItem paramQIMFilterCategoryItem, blrx paramblrx, Bundle paramBundle) {}
  
  public void run()
  {
    if ((bkuh.a(this.this$0) != null) && (!bkuh.a(this.this$0).b())) {}
    while ((bkuh.c(this.this$0) == null) || (bkuh.a(this.this$0).b() != 2)) {
      return;
    }
    bkuh.b(this.this$0, true);
    bliu.a().d(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    this.jdField_a_of_type_Blrx.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, bkuh.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.13
 * JD-Core Version:    0.7.0.1
 */