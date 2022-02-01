import java.io.File;
import java.io.FileFilter;

class pkc
  implements FileFilter
{
  pkc(pka parampka) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".json")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pkc
 * JD-Core Version:    0.7.0.1
 */