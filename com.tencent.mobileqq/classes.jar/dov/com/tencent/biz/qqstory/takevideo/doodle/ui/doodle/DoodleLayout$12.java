package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.Map;

class DoodleLayout$12
  implements Runnable
{
  DoodleLayout$12(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    GestureHelper.ZoomItem localZoomItem;
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.a != null))
    {
      localZoomItem = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localZoomItem instanceof FaceLayer.FaceItem)) {
        break label97;
      }
      ((FaceLayer.FaceItem)localZoomItem).a = this.a;
    }
    for (;;)
    {
      localZoomItem.i = 3;
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
        this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.q();
      }
      return;
      label97:
      if ((localZoomItem instanceof TextLayer.TextItem)) {
        ((TextLayer.TextItem)localZoomItem).a = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.12
 * JD-Core Version:    0.7.0.1
 */