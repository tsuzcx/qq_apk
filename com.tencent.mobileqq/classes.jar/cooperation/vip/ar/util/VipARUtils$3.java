package cooperation.vip.ar.util;

import bgph;
import bgpk;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class VipARUtils$3
  implements Runnable
{
  public VipARUtils$3(bgph parambgph) {}
  
  public void run()
  {
    if ((bgph.a("VipARUtils_JAR_md5", bgph.b())) || (!bgph.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("vip_tar_engine.jar", new bgpk(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.3
 * JD-Core Version:    0.7.0.1
 */