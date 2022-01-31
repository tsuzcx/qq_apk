import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;

public class pik
  implements ThreadPool.Job
{
  public pik(FileCacheService paramFileCacheService) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    FileCacheService.a(this.a, false);
    FileCacheService.a(this.a, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pik
 * JD-Core Version:    0.7.0.1
 */