package cooperation.qzone.util;

import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

class XMPCoreUtil$2$1
  implements ModuleDownloadListener
{
  XMPCoreUtil$2$1(XMPCoreUtil.2 param2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "moduleId = ", paramString, " progress = ", Float.valueOf(paramFloat) });
  }
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("xmpcore.jar")) {
      return;
    }
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", XMPCoreUtil.access$000(), " onDownloadSucceed = ", XMPCoreUtil.access$100() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", XMPCoreUtil.access$100());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil.2.1
 * JD-Core Version:    0.7.0.1
 */