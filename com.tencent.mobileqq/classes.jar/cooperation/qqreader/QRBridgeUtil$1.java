package cooperation.qqreader;

import bdhb;
import biys;
import bjbl;
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
      bjbl.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    biys localbiys = new biys();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localbiys);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localbiys.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      bdhb.a((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */