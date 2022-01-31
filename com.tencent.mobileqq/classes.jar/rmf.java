import java.io.File;
import java.io.FilenameFilter;

class rmf
  implements FilenameFilter
{
  rmf(rme paramrme) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmf
 * JD-Core Version:    0.7.0.1
 */