package cooperation.qzone.cache;

import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class FileStorageHandler$1
  implements ThreadPool.Job<Object>
{
  FileStorageHandler$1(FileStorageHandler paramFileStorageHandler, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = FileStorageHandler.access$000(this.this$0).collect();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        FileCacheService localFileCacheService = (FileCacheService)paramJobContext.next();
        int j = localFileCacheService.getCapacity(this.val$externalStorage);
        Object localObject = localFileCacheService.getDir();
        int i = FileStorageHandler.access$100(this.this$0, (String)localObject);
        j = FileStorageHandler.access$200(this.this$0, j, i);
        this.this$0.cleanOldFile(i, j, (String)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onLowStorage clear cache service:");
        ((StringBuilder)localObject).append(localFileCacheService);
        ((StringBuilder)localObject).append(": remain=");
        ((StringBuilder)localObject).append(j);
        QLog.w("CacheManager", 1, ((StringBuilder)localObject).toString());
      }
      if (FileStorageHandler.isStorageSizeLow(CacheManager.getStoreRootPath()))
      {
        CacheManager.resetStorePath(false);
        if (FileStorageHandler.isStorageSizeLow(CacheManager.getStoreRootPath()))
        {
          CacheManager.resetStorePath(true);
          FileStorageHandler.access$300(this.this$0);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.cache.FileStorageHandler.1
 * JD-Core Version:    0.7.0.1
 */