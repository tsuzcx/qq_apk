import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import java.io.File;

public final class otu
  extends ExecuteBinResponseCallback
{
  public otu(ExecuteBinResponseCallback paramExecuteBinResponseCallback, String paramString) {}
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.a();
  }
  
  public void a(String paramString)
  {
    StoryReportor.a("music_composite", "video_music_composite", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.b) });
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.a(paramBoolean);
  }
  
  public void b(String paramString)
  {
    StoryReportor.a("music_composite", "video_music_composite", 0, 1, new String[0]);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegExecuteBinResponseCallback.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otu
 * JD-Core Version:    0.7.0.1
 */