import java.io.File;
import java.io.FilenameFilter;

class rtv
  implements FilenameFilter
{
  rtv(rtu paramrtu) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rtv
 * JD-Core Version:    0.7.0.1
 */