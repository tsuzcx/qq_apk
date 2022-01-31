import java.io.File;
import java.io.FileFilter;

final class ouz
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ouz
 * JD-Core Version:    0.7.0.1
 */