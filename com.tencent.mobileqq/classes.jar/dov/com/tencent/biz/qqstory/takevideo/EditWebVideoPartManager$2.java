package dov.com.tencent.biz.qqstory.takevideo;

import ajxt;
import ajxy;
import android.app.Activity;
import bmko;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(bmko parambmko, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    bmko.a(this.this$0, null);
    this.this$0.c = 0;
    bmko.a(this.this$0, this.this$0.a.a("extra_bless_latitude", 0.0D));
    bmko.b(this.this$0, this.this$0.a.a("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      bmko.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      ajxt localajxt = new ajxt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, bmko.a(this.this$0), true);
      localajxt.a(bmko.a(this.this$0));
      localajxt.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = bmko.a(this.this$0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          bmko.a(this.this$0).a(i);
        }
        bool = true;
      }
      else
      {
        bmko.a(this.this$0).a(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */