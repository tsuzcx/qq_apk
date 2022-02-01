package dov.com.tencent.biz.qqstory.takevideo;

import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

class EditPicSave$1
  implements ThreadExcutor.IThreadListener
{
  EditPicSave$1(EditPicSave paramEditPicSave) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() == null)) {
      return;
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditPicSave.1.1(this), 500L);
  }
  
  public void onPreRun()
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() == 14) {
      EditPicSave.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1
 * JD-Core Version:    0.7.0.1
 */