package cooperation.qzone.util;

import bnlf;
import bnlh;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class XMPCoreUtil$2
  implements Runnable
{
  public void run()
  {
    if ((bnlf.b(this.this$0)) || (!bnlf.c(this.this$0))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("xmpcore.jar", new bnlh(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil.2
 * JD-Core Version:    0.7.0.1
 */