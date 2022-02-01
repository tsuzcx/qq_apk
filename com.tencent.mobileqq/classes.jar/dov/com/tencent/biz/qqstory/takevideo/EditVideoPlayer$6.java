package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class EditVideoPlayer$6
  implements Runnable
{
  EditVideoPlayer$6(EditVideoPlayer paramEditVideoPlayer) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(true, 10000L, 6, this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b(), this.this$0.jdField_a_of_type_Float);
    SLog.a("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess getMultiVideoInfo find %d blocks", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()));
    if (this.this$0.jdField_a_of_type_JavaUtilList.size() > 0) {}
    try
    {
      ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((MultiBlockVideoPlayer.RecordVideoBlockInfo)this.this$0.jdField_a_of_type_JavaUtilList.get(0));
      EditVideoPlayer.a(this.this$0);
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */