package dov.com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.os.Build.VERSION;
import aoqr;
import java.io.File;

public class VideoConverter
{
  VideoConverter.VideoConverterImpl a;
  
  public VideoConverter()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new aoqr();
    }
  }
  
  public boolean a(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, paramProcessor, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter
 * JD-Core Version:    0.7.0.1
 */