package dov.com.tencent.biz.qqstory.takevideo;

import alvf;
import alvk;
import android.app.Activity;
import bpgg;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(bpgg parambpgg, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    bpgg.a(this.this$0, null);
    this.this$0.c = 0;
    bpgg.a(this.this$0, this.this$0.a.a("extra_bless_latitude", 0.0D));
    bpgg.b(this.this$0, this.this$0.a.a("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      bpgg.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      alvf localalvf = new alvf(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, bpgg.a(this.this$0), true);
      localalvf.a(bpgg.a(this.this$0));
      localalvf.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = bpgg.a(this.this$0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          bpgg.a(this.this$0).a(i);
        }
        bool = true;
      }
      else
      {
        bpgg.a(this.this$0).a(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */