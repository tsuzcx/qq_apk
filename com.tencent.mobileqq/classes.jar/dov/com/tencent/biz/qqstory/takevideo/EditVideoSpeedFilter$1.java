package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewStub;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

class EditVideoSpeedFilter$1
  implements Runnable
{
  EditVideoSpeedFilter$1(EditVideoSpeedFilter paramEditVideoSpeedFilter) {}
  
  public void run()
  {
    if (!EditVideoSpeedFilter.a(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a() == null);
        localObject = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().getActivity();
      } while ((localObject == null) || (((Activity)localObject).isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (((Activity)localObject).isDestroyed())));
      EditVideoSpeedFilter.a(this.this$0, (ViewStub)this.this$0.a(2131373164));
    } while (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null);
    Object localObject = EditVideoSpeedFilter.a(this.this$0).getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {}
    for (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = ((PickerContainer)EditVideoSpeedFilter.a(this.this$0).inflate());; this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = ((PickerContainer)this.this$0.a(2131377285)))
    {
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a, this.this$0);
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(2, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.1
 * JD-Core Version:    0.7.0.1
 */