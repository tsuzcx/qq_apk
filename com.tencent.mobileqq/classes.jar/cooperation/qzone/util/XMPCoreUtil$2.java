package cooperation.qzone.util;

import bjvs;
import bjvu;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class XMPCoreUtil$2
  implements Runnable
{
  public void run()
  {
    if ((bjvs.b(this.this$0)) || (!bjvs.c(this.this$0))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("xmpcore.jar", new bjvu(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil.2
 * JD-Core Version:    0.7.0.1
 */