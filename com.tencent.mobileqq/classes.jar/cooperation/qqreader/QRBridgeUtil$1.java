package cooperation.qqreader;

import bhmi;
import bmog;
import bmqw;
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
      bmqw.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    bmog localbmog = new bmog();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localbmog);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localbmog.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      bhmi.a((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */