import com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.io.File;
import java.io.FileFilter;

public class okg
  implements FileFilter
{
  public okg(NormalFacePackage paramNormalFacePackage) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okg
 * JD-Core Version:    0.7.0.1
 */