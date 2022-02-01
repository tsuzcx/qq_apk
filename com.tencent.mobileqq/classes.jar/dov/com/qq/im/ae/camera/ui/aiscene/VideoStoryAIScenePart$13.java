package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AEFilterManagerHolder;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

class VideoStoryAIScenePart$13
  implements Runnable
{
  VideoStoryAIScenePart$13(VideoStoryAIScenePart paramVideoStoryAIScenePart, QIMFilterCategoryItem paramQIMFilterCategoryItem, Bundle paramBundle, CaptureComboManager paramCaptureComboManager) {}
  
  public void run()
  {
    if ((VideoStoryAIScenePart.a(this.this$0) != null) && (!VideoStoryAIScenePart.a(this.this$0).m())) {}
    while ((VideoStoryAIScenePart.c(this.this$0) == null) || (VideoStoryAIScenePart.a(this.this$0).getSelectedCamera() != 2)) {
      return;
    }
    VideoStoryAIScenePart.b(this.this$0, true);
    AEBaseDataReporter.a().e(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("capture_force_enable", true);
    }
    this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, VideoStoryAIScenePart.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.13
 * JD-Core Version:    0.7.0.1
 */