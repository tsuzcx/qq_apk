package cooperation.qqreader;

import bace;
import bfld;
import bfne;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import mqq.app.AppRuntime;

final class QRBridgeUtil$2
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      bfne.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    bfld localbfld = new bfld();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localbfld);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localbfld.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      bace.a((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.2
 * JD-Core Version:    0.7.0.1
 */