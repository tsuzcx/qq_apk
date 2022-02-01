package cooperation.vip.ar.util;

import bmmb;
import bmmf;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class VipARUtils$4
  implements Runnable
{
  public VipARUtils$4(bmmb parambmmb) {}
  
  public void run()
  {
    if ((bmmb.a("VipARUtils_SO_md5", bmmb.d())) || (!bmmb.b())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("libTar.so", new bmmf(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.4
 * JD-Core Version:    0.7.0.1
 */