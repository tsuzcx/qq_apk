package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import bmxa;
import bnaz;
import bncm;
import bnqm;
import bohj;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AEFilterManagerHolder;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class VideoStoryAIScenePart$13
  implements Runnable
{
  public VideoStoryAIScenePart$13(bncm parambncm, QIMFilterCategoryItem paramQIMFilterCategoryItem, Bundle paramBundle, bohj parambohj) {}
  
  public void run()
  {
    if ((bncm.a(this.this$0) != null) && (!bncm.a(this.this$0).l())) {}
    while ((bncm.c(this.this$0) == null) || (bncm.a(this.this$0).getSelectedCamera() != 2)) {
      return;
    }
    bncm.b(this.this$0, true);
    bnqm.a().e(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("capture_force_enable", true);
    }
    this.jdField_a_of_type_Bohj.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, bncm.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.13
 * JD-Core Version:    0.7.0.1
 */