package cooperation.qzone.cache;

import java.io.File;
import java.util.Comparator;

final class FileStorageHandler$3
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    long l1 = paramFile1.lastModified();
    long l2 = paramFile2.lastModified();
    if (l1 > l2) {
      return -1;
    }
    if (l1 < l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.cache.FileStorageHandler.3
 * JD-Core Version:    0.7.0.1
 */