package cooperation.qqreader;

import bbdx;
import bgtm;
import bgwf;
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
      bgwf.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    bgtm localbgtm = new bgtm();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localbgtm);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localbgtm.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      bbdx.a((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */