package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;

class HWEditLocalVideoPlayer$ConvertIFramesRunnable$1$1
  implements Runnable
{
  HWEditLocalVideoPlayer$ConvertIFramesRunnable$1$1(HWEditLocalVideoPlayer.ConvertIFramesRunnable.1 param1) {}
  
  public void run()
  {
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0, null);
    if (!HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0))
    {
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Convert video finished but player not displayed.");
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.b() == 3) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.c == this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.jdField_a_of_type_Int)) {
      HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$Mp4VideoFragmentInfo);
    }
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0);
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1
 * JD-Core Version:    0.7.0.1
 */