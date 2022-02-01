package cooperation.ilive.manager;

import bmfc;
import bmfr;
import bmfu;
import bmfv;
import com.tencent.qphone.base.util.QLog;

public class IlivePreDownloadManager$2
  implements Runnable
{
  public IlivePreDownloadManager$2(bmfr parambmfr) {}
  
  public void run()
  {
    bmfv.a().a("PLUGIN_PRE_DOWNLOAD").a("start_pre_download");
    if (bmfc.a().b())
    {
      QLog.e("IlivePreDownloadManager", 1, "preloadPluginConfig preloadDownload plugin exist stop preload");
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "preload dispatch start");
    bmfr.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.manager.IlivePreDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */