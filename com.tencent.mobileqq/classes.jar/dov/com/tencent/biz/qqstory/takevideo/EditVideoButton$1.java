package dov.com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditVideoButton$1
  implements View.OnClickListener
{
  EditVideoButton$1(EditVideoButton paramEditVideoButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoButton.1
 * JD-Core Version:    0.7.0.1
 */