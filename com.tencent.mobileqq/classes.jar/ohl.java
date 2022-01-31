import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

class ohl
  implements Runnable
{
  ohl(ohk paramohk) {}
  
  public void run()
  {
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Ohj.a, null);
    if (!HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Ohj.a))
    {
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Convert video finished but player not displayed.");
      return;
    }
    if ((this.a.jdField_a_of_type_Ohj.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a != null) && (this.a.jdField_a_of_type_Ohj.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.b() == 3) && (this.a.jdField_a_of_type_Ohj.c == this.a.jdField_a_of_type_Ohj.a.jdField_a_of_type_Int)) {
      HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Ohj.a, this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$Mp4VideoFragmentInfo);
    }
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Ohj.a);
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Ohj.a, this.a.jdField_a_of_type_Ohj.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohl
 * JD-Core Version:    0.7.0.1
 */