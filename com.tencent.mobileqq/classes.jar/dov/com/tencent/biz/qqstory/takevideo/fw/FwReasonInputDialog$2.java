package dov.com.tencent.biz.qqstory.takevideo.fw;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager;

class FwReasonInputDialog$2
  implements DialogInterface.OnShowListener
{
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (FwReasonInputDialog.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFwFwReasonInputDialog) != null) {
      FwReasonInputDialog.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFwFwReasonInputDialog).onShow(paramDialogInterface);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      FwReasonInputDialog.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFwFwReasonInputDialog).b();
      return;
    }
    FwReasonInputDialog.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFwFwReasonInputDialog).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.fw.FwReasonInputDialog.2
 * JD-Core Version:    0.7.0.1
 */