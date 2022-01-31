import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer;
import com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer;
import com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.MultiOperateException;
import com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.RecordVideoBlockInfo;
import java.util.List;

public class ofu
  implements Runnable
{
  public ofu(EditVideoPlayer paramEditVideoPlayer, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPlayer.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (this.jdField_a_of_type_Int < localList.size())) {}
    try
    {
      ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPlayer.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((MultiBlockVideoPlayer.RecordVideoBlockInfo)localList.get(this.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_Int > this.b) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPlayer.b.post(new ofv(this));
      }
      if ((localList != null) && (this.b < localList.size())) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPlayer.a((MultiBlockVideoPlayer.RecordVideoBlockInfo)localList.get(this.b));
      }
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.record.EditVideoPlayer", "setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofu
 * JD-Core Version:    0.7.0.1
 */