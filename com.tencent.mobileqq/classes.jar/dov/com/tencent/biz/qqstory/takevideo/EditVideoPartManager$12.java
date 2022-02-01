package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;

class EditVideoPartManager$12
  implements Runnable
{
  EditVideoPartManager$12(EditVideoPartManager paramEditVideoPartManager) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a();
    if (localBitmap != null) {}
    try
    {
      if (EditVideoPartManager.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 64))
      {
        if (EditVideoPartManager.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUBitmapImageRender == null) {
          EditVideoPartManager.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUBitmapImageRender = new GPUBitmapImageRender();
        }
        EditVideoPartManager.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUBitmapImageRender.c(localBitmap.getWidth(), localBitmap.getHeight());
      }
      return;
    }
    catch (Exception localException)
    {
      EditVideoPartManager.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUBitmapImageRender = null;
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.12
 * JD-Core Version:    0.7.0.1
 */