import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.qphone.base.util.QLog;

public class oxo
  implements FFmpegExecuteResponseCallback
{
  oxo(VideoCombineHelper paramVideoCombineHelper) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onStart");
    }
  }
  
  public void a(String paramString)
  {
    b(true);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(String paramString)
  {
    b(false);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onFailure" + paramString);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onProgress" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxo
 * JD-Core Version:    0.7.0.1
 */