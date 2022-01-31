package cooperation.qqreader;

import bbdj;
import bgsv;
import bgvo;
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
      bgvo.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    bgsv localbgsv = new bgsv();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localbgsv);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localbgsv.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      bbdj.a((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */