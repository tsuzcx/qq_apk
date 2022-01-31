package dov.com.tencent.biz.qqstory.takevideo;

import aigj;
import aigo;
import android.app.Activity;
import bjze;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(bjze parambjze, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    bjze.a(this.this$0, null);
    this.this$0.c = 0;
    bjze.a(this.this$0, this.this$0.a.a("extra_bless_latitude", 0.0D));
    bjze.b(this.this$0, this.this$0.a.a("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      bjze.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      aigj localaigj = new aigj(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, bjze.a(this.this$0), true);
      localaigj.a(bjze.a(this.this$0));
      localaigj.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = bjze.a(this.this$0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          bjze.a(this.this$0).a(i);
        }
        bool = true;
      }
      else
      {
        bjze.a(this.this$0).a(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */