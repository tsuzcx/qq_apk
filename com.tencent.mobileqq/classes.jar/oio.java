import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import java.io.File;
import java.io.FilenameFilter;

public class oio
  implements FilenameFilter
{
  public oio(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oio
 * JD-Core Version:    0.7.0.1
 */