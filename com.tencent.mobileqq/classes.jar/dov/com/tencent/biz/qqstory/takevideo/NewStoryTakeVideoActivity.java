package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

@TargetApi(14)
public class NewStoryTakeVideoActivity
{
  static
  {
    try
    {
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.a());
      int i = VideoEnvironment.a("AVCodec", null, true);
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "LoadExtractedShortVideoSo :code=" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity
 * JD-Core Version:    0.7.0.1
 */