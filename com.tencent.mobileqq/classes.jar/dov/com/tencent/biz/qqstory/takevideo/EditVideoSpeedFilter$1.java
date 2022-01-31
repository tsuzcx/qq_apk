package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewStub;
import bmix;
import bmju;
import bmkf;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class EditVideoSpeedFilter$1
  implements Runnable
{
  public EditVideoSpeedFilter$1(bmju parambmju) {}
  
  public void run()
  {
    if (!bmju.a(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.this$0.jdField_a_of_type_Bmix.a() == null);
        localObject = this.this$0.jdField_a_of_type_Bmix.a().getActivity();
      } while ((localObject == null) || (((Activity)localObject).isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (((Activity)localObject).isDestroyed())));
      bmju.a(this.this$0, (ViewStub)this.this$0.a(2131371973));
    } while (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null);
    Object localObject = bmju.a(this.this$0).getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {}
    for (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = ((PickerContainer)bmju.a(this.this$0).inflate());; this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = ((PickerContainer)this.this$0.a(2131375922)))
    {
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(this.this$0.jdField_a_of_type_Bmix.a, this.this$0);
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(2, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.1
 * JD-Core Version:    0.7.0.1
 */