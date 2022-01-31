package cooperation.qzone.util;

import bhqa;
import bhqc;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class XMPCoreUtil$2
  implements Runnable
{
  public void run()
  {
    if ((bhqa.b(this.this$0)) || (!bhqa.c(this.this$0))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("xmpcore.jar", new bhqc(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil.2
 * JD-Core Version:    0.7.0.1
 */