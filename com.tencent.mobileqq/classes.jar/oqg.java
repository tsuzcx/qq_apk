import java.io.File;
import java.io.FileFilter;

class oqg
  implements FileFilter
{
  oqg(oqe paramoqe) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".json")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqg
 * JD-Core Version:    0.7.0.1
 */