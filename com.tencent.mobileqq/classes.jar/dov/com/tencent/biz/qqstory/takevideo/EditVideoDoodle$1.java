package dov.com.tencent.biz.qqstory.takevideo;

import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.DoodleEditViewListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;

class EditVideoDoodle$1
  implements DoodleEditView.DoodleEditViewListener
{
  EditVideoDoodle$1(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a == 11) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    }
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(103, new Object[] { paramZoomItem });
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a == 0) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.1
 * JD-Core Version:    0.7.0.1
 */