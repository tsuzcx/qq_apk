package cooperation.qqreader;

import bdcs;
import biul;
import bixe;
import com.tencent.common.app.BaseApplicationImpl;
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
      bixe.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    biul localbiul = new biul();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localbiul);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localbiul.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      bdcs.a((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */