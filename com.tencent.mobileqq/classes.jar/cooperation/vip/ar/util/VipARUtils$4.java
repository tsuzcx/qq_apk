package cooperation.vip.ar.util;

import bkar;
import bkav;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class VipARUtils$4
  implements Runnable
{
  public VipARUtils$4(bkar parambkar) {}
  
  public void run()
  {
    if ((bkar.a("VipARUtils_SO_md5", bkar.d())) || (!bkar.b())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("libTar.so", new bkav(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.4
 * JD-Core Version:    0.7.0.1
 */