package cooperation.vip.ar.util;

import bkar;
import bkau;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class VipARUtils$3
  implements Runnable
{
  public VipARUtils$3(bkar parambkar) {}
  
  public void run()
  {
    if ((bkar.a("VipARUtils_JAR_md5", bkar.b())) || (!bkar.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("vip_tar_engine.jar", new bkau(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.3
 * JD-Core Version:    0.7.0.1
 */