package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;

class HWEditLocalVideoPlayer$ConvertIFramesRunnable$1
  implements HWEncodeListener
{
  HWEditLocalVideoPlayer$ConvertIFramesRunnable$1(HWEditLocalVideoPlayer.ConvertIFramesRunnable paramConvertIFramesRunnable, HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo) {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "encode error errorCode = " + paramInt + " Exception = " + paramThrowable);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b == 0)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b = 1;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.a = 3;
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video by mIFrameInterval = " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.b + " mFrameRate = " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.a);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 1000L);
      return;
    }
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video failed");
    try
    {
      ShortVideoExceptionReporter.a(paramThrowable);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.a(new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.2(this), 0L);
      return;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        paramThrowable.printStackTrace();
      }
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$Mp4VideoFragmentInfo.a = paramString;
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "onEncodeFinish  iframe file filePath = " + paramString);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.this$0.a(new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1(this), 0L);
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1
 * JD-Core Version:    0.7.0.1
 */