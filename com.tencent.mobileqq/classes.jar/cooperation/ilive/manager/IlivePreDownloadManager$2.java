package cooperation.ilive.manager;

import blul;
import blvj;
import blvk;
import com.tencent.qphone.base.util.QLog;

class IlivePreDownloadManager$2
  implements Runnable
{
  IlivePreDownloadManager$2(IlivePreDownloadManager paramIlivePreDownloadManager) {}
  
  public void run()
  {
    blvk.a().a("PLUGIN_PRE_DOWNLOAD").a("start_pre_download");
    if (blul.a().b())
    {
      QLog.e("IlivePreDownloadManager", 1, "preloadPluginConfig preloadDownload plugin exist stop preload");
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "preload dispatch start");
    IlivePreDownloadManager.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.manager.IlivePreDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */