package cooperation.qqreader;

import bksn;
import bkvd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.app.AppRuntime;

final class QRBridgeUtil$1
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      bkvd.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    bksn localbksn = new bksn();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localbksn);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localbksn.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      FileUtils.delete((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */