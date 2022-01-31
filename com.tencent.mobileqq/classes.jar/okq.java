import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer;
import com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer;
import com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.MultiOperateException;
import com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.RecordVideoBlockInfo;
import java.util.List;

public class okq
  implements Runnable
{
  public okq(EditVideoPlayer paramEditVideoPlayer) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilList = ((MultiBlockVideoPlayer)this.a.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(true, 10000L, 6, this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.b(), this.a.jdField_a_of_type_Float);
    SLog.a("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess getMultiVideoInfo find %d blocks", Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()));
    if (this.a.jdField_a_of_type_JavaUtilList.size() > 0) {}
    try
    {
      ((MultiBlockVideoPlayer)this.a.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((MultiBlockVideoPlayer.RecordVideoBlockInfo)this.a.jdField_a_of_type_JavaUtilList.get(0));
      EditVideoPlayer.a(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okq
 * JD-Core Version:    0.7.0.1
 */