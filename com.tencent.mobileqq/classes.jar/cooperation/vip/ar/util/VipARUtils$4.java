package cooperation.vip.ar.util;

import bhyv;
import bhyz;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class VipARUtils$4
  implements Runnable
{
  public VipARUtils$4(bhyv parambhyv) {}
  
  public void run()
  {
    if ((bhyv.a("VipARUtils_SO_md5", bhyv.d())) || (!bhyv.b())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("libTar.so", new bhyz(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.4
 * JD-Core Version:    0.7.0.1
 */