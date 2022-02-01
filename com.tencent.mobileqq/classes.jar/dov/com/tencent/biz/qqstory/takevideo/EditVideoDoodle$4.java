package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

class EditVideoDoodle$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  EditVideoDoodle$4(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void onGlobalLayout()
  {
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getViewTreeObserver().removeGlobalOnLayoutListener(EditVideoDoodle.a(this.a));
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 16));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.4
 * JD-Core Version:    0.7.0.1
 */