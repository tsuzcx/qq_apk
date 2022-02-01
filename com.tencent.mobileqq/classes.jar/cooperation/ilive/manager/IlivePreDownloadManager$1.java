package cooperation.ilive.manager;

import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IlivePluginDownloadManager;

class IlivePreDownloadManager$1
  implements Runnable
{
  IlivePreDownloadManager$1(IlivePreDownloadManager paramIlivePreDownloadManager) {}
  
  public void run()
  {
    IlivePluginDownloadManager.a().b();
    IlivePluginDownloadManager.a().a(this.this$0);
    if (IlivePluginDownloadManager.a().b())
    {
      QLog.e("IlivePreDownloadManager", 1, "preloadPluginConfig plugin exist stop preload");
      return;
    }
    IlivePreDownloadManager.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.manager.IlivePreDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */