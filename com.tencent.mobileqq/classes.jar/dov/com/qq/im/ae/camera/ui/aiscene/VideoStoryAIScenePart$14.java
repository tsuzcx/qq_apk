package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import bofh;
import bojk;
import bojl;
import bokv;
import bozr;
import bpmw;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class VideoStoryAIScenePart$14
  implements Runnable
{
  public VideoStoryAIScenePart$14(bokv parambokv, QIMFilterCategoryItem paramQIMFilterCategoryItem, Bundle paramBundle, bpmw parambpmw) {}
  
  public void run()
  {
    if ((bokv.a(this.this$0) != null) && (!bokv.a(this.this$0).c())) {}
    while ((bokv.c(this.this$0) == null) || (bokv.a(this.this$0).b() != 2)) {
      return;
    }
    bokv.b(this.this$0, true);
    bozr.a().e(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    if ((bojk.a() != null) && (!bojk.a().a)) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("capture_force_enable", true);
    }
    this.jdField_a_of_type_Bpmw.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, bokv.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.14
 * JD-Core Version:    0.7.0.1
 */