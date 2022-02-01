import java.io.File;
import java.io.FileFilter;

class pct
  implements FileFilter
{
  pct(pcs parampcs) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pct
 * JD-Core Version:    0.7.0.1
 */