import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoButton;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo;
import java.util.List;

class ofl
  implements Runnable
{
  ofl(ofk paramofk) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(0);
      HWEditLocalVideoPlayer.a(this.a.a, localMp4VideoFragmentInfo);
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 8));
      HWEditLocalVideoPlayer.a(this.a.a, this.a.a.jdField_a_of_type_Int);
      this.a.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a(true);
      return;
      SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofl
 * JD-Core Version:    0.7.0.1
 */