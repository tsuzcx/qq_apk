package cooperation.qqreader;

import bgmg;
import blnd;
import blpu;
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
      blpu.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    blnd localblnd = new blnd();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localblnd);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localblnd.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      bgmg.a((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */