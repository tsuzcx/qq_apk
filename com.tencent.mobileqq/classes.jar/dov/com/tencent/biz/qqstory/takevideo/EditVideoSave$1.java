package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class EditVideoSave$1
  implements Runnable
{
  EditVideoSave$1(EditVideoSave paramEditVideoSave, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.d();
    if (this.jdField_a_of_type_Int == 222)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(str);
    }
    while (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() == 102)
    {
      String str;
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 2, HardCodeUtil.a(2131703794), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */