package cooperation.qzone.util;

import cooperation.qzone.networkedmodule.QzoneModuleManager;

class XMPCoreUtil$2
  implements Runnable
{
  XMPCoreUtil$2(XMPCoreUtil paramXMPCoreUtil) {}
  
  public void run()
  {
    if ((XMPCoreUtil.access$400(this.this$0)) || (!XMPCoreUtil.access$500(this.this$0))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("xmpcore.jar", new XMPCoreUtil.2.1(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil.2
 * JD-Core Version:    0.7.0.1
 */