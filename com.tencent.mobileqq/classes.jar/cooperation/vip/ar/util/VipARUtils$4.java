package cooperation.vip.ar.util;

import bgph;
import bgpl;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class VipARUtils$4
  implements Runnable
{
  public VipARUtils$4(bgph parambgph) {}
  
  public void run()
  {
    if ((bgph.a("VipARUtils_SO_md5", bgph.d())) || (!bgph.b())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("libTar.so", new bgpl(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.4
 * JD-Core Version:    0.7.0.1
 */