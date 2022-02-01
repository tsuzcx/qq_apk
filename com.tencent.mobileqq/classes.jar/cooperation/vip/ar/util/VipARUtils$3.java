package cooperation.vip.ar.util;

import bmmb;
import bmme;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class VipARUtils$3
  implements Runnable
{
  public VipARUtils$3(bmmb parambmmb) {}
  
  public void run()
  {
    if ((bmmb.a("VipARUtils_JAR_md5", bmmb.b())) || (!bmmb.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("vip_tar_engine.jar", new bmme(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.3
 * JD-Core Version:    0.7.0.1
 */