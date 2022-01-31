package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import bijd;
import bill;
import bizt;
import bjcb;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class VideoStoryAIScenePart$13
  implements Runnable
{
  public VideoStoryAIScenePart$13(bill parambill, QIMFilterCategoryItem paramQIMFilterCategoryItem, bjcb parambjcb, Bundle paramBundle) {}
  
  public void run()
  {
    if ((bill.a(this.this$0) != null) && (!bill.a(this.this$0).b())) {}
    while ((bill.c(this.this$0) == null) || (bill.a(this.this$0).b() != 2)) {
      return;
    }
    bill.b(this.this$0, true);
    bizt.a().c(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    this.jdField_a_of_type_Bjcb.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, bill.d(this.this$0), this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.13
 * JD-Core Version:    0.7.0.1
 */