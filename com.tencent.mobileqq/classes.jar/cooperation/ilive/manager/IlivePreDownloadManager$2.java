package cooperation.ilive.manager;

import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IlivePluginDownloadManager;
import cooperation.ilive.time.TimeMonitorData;
import cooperation.ilive.time.TimeMonitorManager;

class IlivePreDownloadManager$2
  implements Runnable
{
  IlivePreDownloadManager$2(IlivePreDownloadManager paramIlivePreDownloadManager) {}
  
  public void run()
  {
    TimeMonitorManager.a().a("PLUGIN_PRE_DOWNLOAD").b("start_pre_download");
    if (IlivePluginDownloadManager.a().b())
    {
      QLog.e("IlivePreDownloadManager", 1, "preloadPluginConfig preloadDownload plugin exist stop preload");
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "preload dispatch start");
    IlivePreDownloadManager.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.manager.IlivePreDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */