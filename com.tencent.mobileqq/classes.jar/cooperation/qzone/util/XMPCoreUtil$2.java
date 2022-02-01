package cooperation.qzone.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;

class XMPCoreUtil$2
  implements Runnable
{
  XMPCoreUtil$2(XMPCoreUtil paramXMPCoreUtil) {}
  
  public void run()
  {
    int i;
    if ((!XMPCoreUtil.access$400(this.this$0)) && (XMPCoreUtil.access$500(this.this$0))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("xmpcore.jar", new XMPCoreUtil.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil.2
 * JD-Core Version:    0.7.0.1
 */