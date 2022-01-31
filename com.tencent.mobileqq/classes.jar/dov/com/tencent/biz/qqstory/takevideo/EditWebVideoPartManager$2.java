package dov.com.tencent.biz.qqstory.takevideo;

import ahtt;
import ahty;
import android.app.Activity;
import bihs;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(bihs parambihs, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    bihs.a(this.this$0, null);
    this.this$0.c = 0;
    bihs.a(this.this$0, this.this$0.a.a("extra_bless_latitude", 0.0D));
    bihs.b(this.this$0, this.this$0.a.a("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      bihs.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      ahtt localahtt = new ahtt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, bihs.a(this.this$0), true);
      localahtt.a(bihs.a(this.this$0));
      localahtt.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = bihs.a(this.this$0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          bihs.a(this.this$0).a(i);
        }
        bool = true;
      }
      else
      {
        bihs.a(this.this$0).a(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */