import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;

public class oha
  implements Runnable
{
  public oha(EditWebVideoPartManager paramEditWebVideoPartManager, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager, null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_Int = 0;
    EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_latitude", 0.0D));
    EditWebVideoPartManager.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_longitude", 0.0D));
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager);
      bool1 = false;
    }
    for (;;)
    {
      EncodeVideoTask localEncodeVideoTask = new EncodeVideoTask(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.b, bool1, EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager));
      localEncodeVideoTask.a(EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager));
      localEncodeVideoTask.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        boolean bool2 = true;
        int i = EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
        bool1 = bool2;
        if (i != 0)
        {
          EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager).a(i);
          bool1 = bool2;
        }
      }
      else
      {
        EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager).a(-13);
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oha
 * JD-Core Version:    0.7.0.1
 */