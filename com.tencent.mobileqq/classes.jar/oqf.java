import java.io.File;
import java.io.FileFilter;

class oqf
  implements FileFilter
{
  oqf(oqe paramoqe) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqf
 * JD-Core Version:    0.7.0.1
 */