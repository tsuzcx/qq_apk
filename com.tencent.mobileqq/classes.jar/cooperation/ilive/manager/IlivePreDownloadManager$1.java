package cooperation.ilive.manager;

import bldz;
import bleo;
import com.tencent.qphone.base.util.QLog;

public class IlivePreDownloadManager$1
  implements Runnable
{
  public IlivePreDownloadManager$1(bleo parambleo) {}
  
  public void run()
  {
    bldz.a().b();
    bldz.a().a(this.this$0);
    if (bldz.a().b())
    {
      QLog.e("IlivePreDownloadManager", 1, "preloadPluginConfig plugin exist stop preload");
      return;
    }
    bleo.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.manager.IlivePreDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */