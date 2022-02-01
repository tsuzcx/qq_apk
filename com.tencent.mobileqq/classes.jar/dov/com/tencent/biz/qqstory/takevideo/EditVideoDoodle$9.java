package dov.com.tencent.biz.qqstory.takevideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

class EditVideoDoodle$9
  implements DialogInterface.OnDismissListener
{
  EditVideoDoodle$9(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(true, 0.0F, 0.0F, 0.0F, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.9
 * JD-Core Version:    0.7.0.1
 */