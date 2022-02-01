package dov.com.tencent.biz.qqstory.takevideo;

import bqgs;
import bqin;
import java.util.List;
import yuk;

public class EditVideoPlayer$7
  implements Runnable
{
  public EditVideoPlayer$7(bqgs parambqgs) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(true, 10000L, 6, this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b(), this.this$0.jdField_a_of_type_Float);
    yuk.a("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess getMultiVideoInfo find %d blocks", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()));
    if (this.this$0.jdField_a_of_type_JavaUtilList.size() > 0) {}
    try
    {
      ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((bqin)this.this$0.jdField_a_of_type_JavaUtilList.get(0));
      bqgs.a(this.this$0);
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        yuk.c("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.7
 * JD-Core Version:    0.7.0.1
 */