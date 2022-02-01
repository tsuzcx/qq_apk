package cooperation.qzone.webviewplugin;

import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import cooperation.qzone.cache.FileCacheService;

final class QzoneZipCacheHelper$1
  implements ThreadPool.Job<Object>
{
  QzoneZipCacheHelper$1(String paramString1, String paramString2) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    QzoneZipCacheHelper.access$100().updateLruFile(QzoneZipCacheHelper.access$100().getPath(QzoneZipCacheHelper.access$000(this.val$business, this.val$zipName)), true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneZipCacheHelper.1
 * JD-Core Version:    0.7.0.1
 */