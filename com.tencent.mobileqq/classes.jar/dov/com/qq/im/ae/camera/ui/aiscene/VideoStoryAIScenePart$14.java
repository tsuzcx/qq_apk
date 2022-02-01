package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import bndy;
import bnic;
import bnid;
import bnjl;
import bnyh;
import bolb;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class VideoStoryAIScenePart$14
  implements Runnable
{
  public VideoStoryAIScenePart$14(bnjl parambnjl, QIMFilterCategoryItem paramQIMFilterCategoryItem, Bundle paramBundle, bolb parambolb) {}
  
  public void run()
  {
    if ((bnjl.a(this.this$0) != null) && (!bnjl.a(this.this$0).d())) {}
    while ((bnjl.c(this.this$0) == null) || (bnjl.a(this.this$0).b() != 2)) {
      return;
    }
    bnjl.b(this.this$0, true);
    bnyh.a().e(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    if ((bnic.a() != null) && (!bnic.a().a)) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("capture_force_enable", true);
    }
    this.jdField_a_of_type_Bolb.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, bnjl.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.14
 * JD-Core Version:    0.7.0.1
 */