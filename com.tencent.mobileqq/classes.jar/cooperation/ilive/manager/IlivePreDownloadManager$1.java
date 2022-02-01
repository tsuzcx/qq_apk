package cooperation.ilive.manager;

import bmfc;
import bmfr;
import com.tencent.qphone.base.util.QLog;

public class IlivePreDownloadManager$1
  implements Runnable
{
  public IlivePreDownloadManager$1(bmfr parambmfr) {}
  
  public void run()
  {
    bmfc.a().b();
    bmfc.a().a(this.this$0);
    if (bmfc.a().b())
    {
      QLog.e("IlivePreDownloadManager", 1, "preloadPluginConfig plugin exist stop preload");
      return;
    }
    bmfr.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.manager.IlivePreDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */