package cooperation.plugin;

import java.io.File;
import java.util.Comparator;

final class Dex2Oat$2
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile1.length() - paramFile2.length();
    if (l > 0L) {
      return 1;
    }
    if (l == 0L) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.Dex2Oat.2
 * JD-Core Version:    0.7.0.1
 */