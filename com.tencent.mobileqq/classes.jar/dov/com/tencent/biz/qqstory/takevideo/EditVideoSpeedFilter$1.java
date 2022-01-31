package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewStub;
import bigb;
import bigy;
import bihj;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class EditVideoSpeedFilter$1
  implements Runnable
{
  public EditVideoSpeedFilter$1(bigy parambigy) {}
  
  public void run()
  {
    if (!bigy.a(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.this$0.jdField_a_of_type_Bigb.a() == null);
        localObject = this.this$0.jdField_a_of_type_Bigb.a().getActivity();
      } while ((localObject == null) || (((Activity)localObject).isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (((Activity)localObject).isDestroyed())));
      bigy.a(this.this$0, (ViewStub)this.this$0.a(2131305960));
    } while (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null);
    Object localObject = bigy.a(this.this$0).getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {}
    for (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = ((PickerContainer)bigy.a(this.this$0).inflate());; this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = ((PickerContainer)this.this$0.a(2131309679)))
    {
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(this.this$0.jdField_a_of_type_Bigb.a, this.this$0);
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(2, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.1
 * JD-Core Version:    0.7.0.1
 */