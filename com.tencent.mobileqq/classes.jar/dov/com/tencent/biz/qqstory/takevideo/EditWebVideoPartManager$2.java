package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

class EditWebVideoPartManager$2
  implements Runnable
{
  EditWebVideoPartManager$2(EditWebVideoPartManager paramEditWebVideoPartManager, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    EditWebVideoPartManager.a(this.this$0, null);
    this.this$0.c = 0;
    EditWebVideoPartManager.a(this.this$0, this.this$0.a.a("extra_bless_latitude", 0.0D));
    EditWebVideoPartManager.b(this.this$0, this.this$0.a.a("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      EditWebVideoPartManager.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      EncodeVideoTask localEncodeVideoTask = new EncodeVideoTask(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, EditWebVideoPartManager.a(this.this$0), true);
      localEncodeVideoTask.a(EditWebVideoPartManager.a(this.this$0));
      localEncodeVideoTask.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = EditWebVideoPartManager.a(this.this$0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          EditWebVideoPartManager.a(this.this$0).a(i);
        }
        bool = true;
      }
      else
      {
        EditWebVideoPartManager.a(this.this$0).a(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */