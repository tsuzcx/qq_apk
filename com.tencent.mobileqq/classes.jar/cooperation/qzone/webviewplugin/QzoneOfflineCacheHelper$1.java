package cooperation.qzone.webviewplugin;

import cooperation.qzone.cache.FileCacheService;

final class QzoneOfflineCacheHelper$1
  implements Runnable
{
  QzoneOfflineCacheHelper$1(String paramString) {}
  
  public void run()
  {
    QzoneOfflineCacheHelper.access$000().updateLruFile(this.val$path, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper.1
 * JD-Core Version:    0.7.0.1
 */