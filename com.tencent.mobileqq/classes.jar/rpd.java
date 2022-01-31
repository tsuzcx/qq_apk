import java.io.File;
import java.io.FilenameFilter;

class rpd
  implements FilenameFilter
{
  rpd(rpc paramrpc) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rpd
 * JD-Core Version:    0.7.0.1
 */