package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import bljy;
import blnq;
import blpb;
import bmbc;
import bmrr;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AEFilterManagerHolder;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class VideoStoryAIScenePart$14
  implements Runnable
{
  public VideoStoryAIScenePart$14(blpb paramblpb, QIMFilterCategoryItem paramQIMFilterCategoryItem, Bundle paramBundle, bmrr parambmrr) {}
  
  public void run()
  {
    if ((blpb.a(this.this$0) != null) && (!blpb.a(this.this$0).l())) {}
    while ((blpb.c(this.this$0) == null) || (blpb.a(this.this$0).getSelectedCamera() != 2)) {
      return;
    }
    blpb.b(this.this$0, true);
    bmbc.a().e(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("capture_force_enable", true);
    }
    this.jdField_a_of_type_Bmrr.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, blpb.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.14
 * JD-Core Version:    0.7.0.1
 */