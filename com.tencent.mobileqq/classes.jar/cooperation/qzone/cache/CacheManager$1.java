package cooperation.qzone.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

final class CacheManager$1
  implements FileStorageHandler.Collector
{
  public Collection<FileCacheService> collect()
  {
    synchronized ()
    {
      ArrayList localArrayList;
      if (CacheManager.access$000().size() <= 0) {
        localArrayList = null;
      } else {
        localArrayList = new ArrayList(CacheManager.access$000().values());
      }
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.cache.CacheManager.1
 * JD-Core Version:    0.7.0.1
 */