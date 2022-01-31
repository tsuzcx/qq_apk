package dov.com.tencent.biz.qqstory.takevideo;

import aigl;
import aigq;
import android.app.Activity;
import bjyn;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(bjyn parambjyn, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    bjyn.a(this.this$0, null);
    this.this$0.c = 0;
    bjyn.a(this.this$0, this.this$0.a.a("extra_bless_latitude", 0.0D));
    bjyn.b(this.this$0, this.this$0.a.a("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      bjyn.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      aigl localaigl = new aigl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, bjyn.a(this.this$0), true);
      localaigl.a(bjyn.a(this.this$0));
      localaigl.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = bjyn.a(this.this$0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          bjyn.a(this.this$0).a(i);
        }
        bool = true;
      }
      else
      {
        bjyn.a(this.this$0).a(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */