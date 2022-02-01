package cooperation.qzone.cache;

import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class FileStorageHandler$4
  implements ThreadPool.Job<Object>
{
  FileStorageHandler$4(FileStorageHandler paramFileStorageHandler, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = FileStorageHandler.access$000(this.this$0).collect();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (FileCacheService)paramJobContext.next();
        int i = ((FileCacheService)localObject).getCapacity(this.val$externalStorage);
        localObject = ((FileCacheService)localObject).getDir();
        this.this$0.checkFileAndClean((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.cache.FileStorageHandler.4
 * JD-Core Version:    0.7.0.1
 */