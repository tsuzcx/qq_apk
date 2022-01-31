import java.io.File;
import java.io.FileFilter;

class oqd
  implements FileFilter
{
  oqd(oqb paramoqb) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".json")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqd
 * JD-Core Version:    0.7.0.1
 */