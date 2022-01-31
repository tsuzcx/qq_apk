import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;

class ohk
  implements HWEncodeListener
{
  ohk(ohj paramohj, HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$Mp4VideoFragmentInfo.a = paramString;
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "onEncodeFinish  iframe file filePath = " + paramString);
    HWEditLocalVideoPlayer.a(this.jdField_a_of_type_Ohj.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer).post(new ohl(this));
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "encode error errorCode = " + paramInt + " Exception = " + paramThrowable);
    if (this.jdField_a_of_type_Ohj.b == 0)
    {
      this.jdField_a_of_type_Ohj.b = 1;
      this.jdField_a_of_type_Ohj.jdField_a_of_type_Int = 3;
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video by mIFrameInterval = " + this.jdField_a_of_type_Ohj.b + " mFrameRate = " + this.jdField_a_of_type_Ohj.jdField_a_of_type_Int);
      HWEditLocalVideoPlayer.a(this.jdField_a_of_type_Ohj.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer).postDelayed(this.jdField_a_of_type_Ohj, 1000L);
      return;
    }
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video failed");
    try
    {
      ShortVideoExceptionReporter.a(paramThrowable);
      HWEditLocalVideoPlayer.a(this.jdField_a_of_type_Ohj.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer).post(new ohm(this));
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
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohk
 * JD-Core Version:    0.7.0.1
 */