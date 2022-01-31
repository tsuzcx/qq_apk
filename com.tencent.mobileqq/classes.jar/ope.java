import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.qphone.base.util.QLog;

public final class ope
  extends ExecuteBinResponseCallback
{
  public ope(ExecuteBinResponseCallback paramExecuteBinResponseCallback) {}
  
  public void a()
  {
    super.a();
  }
  
  public void a(String paramString)
  {
    String str = String.valueOf(System.currentTimeMillis() - this.b);
    StoryReportor.a("music_composite", "music_clip", 0, 0, new String[] { str });
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 2, "音乐截取成功耗时：" + str + '\n' + paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, paramString);
    }
    this.a.b(paramString);
    StoryReportor.a("music_composite", "music_clip", 0, 1, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ope
 * JD-Core Version:    0.7.0.1
 */