package dov.com.tencent.biz.qqstory.takevideo;

import akci;
import akcn;
import android.app.Activity;
import bmpa;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(bmpa parambmpa, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    bmpa.a(this.this$0, null);
    this.this$0.c = 0;
    bmpa.a(this.this$0, this.this$0.a.a("extra_bless_latitude", 0.0D));
    bmpa.b(this.this$0, this.this$0.a.a("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      bmpa.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      akci localakci = new akci(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, bmpa.a(this.this$0), true);
      localakci.a(bmpa.a(this.this$0));
      localakci.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = bmpa.a(this.this$0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          bmpa.a(this.this$0).a(i);
        }
        bool = true;
      }
      else
      {
        bmpa.a(this.this$0).a(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */