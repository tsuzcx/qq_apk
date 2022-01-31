import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import java.io.File;
import java.util.ArrayList;

public class ond
  extends ExecuteBinResponseCallback
{
  public ond(FFmpeg paramFFmpeg, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback, File paramFile) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.b.size())
    {
      File localFile = new File((String)this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.b.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.b = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(paramBoolean);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.b(paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ond
 * JD-Core Version:    0.7.0.1
 */