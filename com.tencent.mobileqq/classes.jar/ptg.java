import java.io.File;
import java.io.FileFilter;

final class ptg
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptg
 * JD-Core Version:    0.7.0.1
 */