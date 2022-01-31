import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.cache.file.FileStorageHandler;
import com.tencent.component.network.module.cache.file.FileStorageHandler.Collector;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

public class pkh
  implements ThreadPool.Job
{
  public pkh(FileStorageHandler paramFileStorageHandler, boolean paramBoolean, Context paramContext) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = FileStorageHandler.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileStorageHandler).a();
    int i;
    int j;
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      i = 0;
      j = 0;
      while (paramJobContext.hasNext())
      {
        FileCacheService localFileCacheService = (FileCacheService)paramJobContext.next();
        int k = localFileCacheService.b(this.jdField_a_of_type_Boolean);
        int m = localFileCacheService.a(this.jdField_a_of_type_Boolean);
        int n = FileStorageHandler.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileStorageHandler, k, m);
        localFileCacheService.a(this.jdField_a_of_type_Boolean, n);
        if (QDLog.b()) {
          QDLog.b("downloader", "clear cache service:" + localFileCacheService + ": remain=" + n);
        }
        j += m;
        i += k;
      }
      if (i > 0) {
        break label186;
      }
    }
    label186:
    for (float f = 3.4028235E+38F;; f = j / i)
    {
      if (f < 0.1F) {
        FileStorageHandler.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileStorageHandler, this.jdField_a_of_type_AndroidContentContext);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pkh
 * JD-Core Version:    0.7.0.1
 */