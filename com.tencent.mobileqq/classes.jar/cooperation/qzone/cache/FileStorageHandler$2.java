package cooperation.qzone.cache;

import java.io.File;
import java.io.FilenameFilter;

final class FileStorageHandler$2
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.endsWith("OldVersion.version");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.cache.FileStorageHandler.2
 * JD-Core Version:    0.7.0.1
 */