import java.io.File;
import java.io.FilenameFilter;

public final class plj
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return !"imagelru.usetime".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plj
 * JD-Core Version:    0.7.0.1
 */