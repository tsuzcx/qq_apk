package dov.com.tencent.biz.qqstory.takevideo;

import boub;
import bovc;
import java.util.List;
import ykq;

public class EditVideoPlayer$6
  implements Runnable
{
  public EditVideoPlayer$6(boub paramboub) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(true, 10000L, 6, this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b(), this.this$0.jdField_a_of_type_Float);
    ykq.a("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess getMultiVideoInfo find %d blocks", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()));
    if (this.this$0.jdField_a_of_type_JavaUtilList.size() > 0) {}
    try
    {
      ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((bovc)this.this$0.jdField_a_of_type_JavaUtilList.get(0));
      boub.a(this.this$0);
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        ykq.c("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */