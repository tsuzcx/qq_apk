import java.io.File;
import java.io.FileFilter;

class ouv
  implements FileFilter
{
  ouv(out paramout) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".json")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ouv
 * JD-Core Version:    0.7.0.1
 */