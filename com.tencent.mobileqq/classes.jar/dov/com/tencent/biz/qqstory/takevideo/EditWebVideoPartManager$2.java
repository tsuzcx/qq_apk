package dov.com.tencent.biz.qqstory.takevideo;

import amgx;
import amhc;
import android.app.Activity;
import bqib;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(bqib parambqib, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    bqib.a(this.this$0, null);
    this.this$0.c = 0;
    bqib.a(this.this$0, this.this$0.a.a("extra_bless_latitude", 0.0D));
    bqib.b(this.this$0, this.this$0.a.a("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      bqib.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      amgx localamgx = new amgx(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, bqib.a(this.this$0), true);
      localamgx.a(bqib.a(this.this$0));
      localamgx.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = bqib.a(this.this$0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          bqib.a(this.this$0).a(i);
        }
        bool = true;
      }
      else
      {
        bqib.a(this.this$0).a(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */