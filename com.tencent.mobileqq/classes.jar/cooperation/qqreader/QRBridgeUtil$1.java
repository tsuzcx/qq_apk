package cooperation.qqreader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qqreader.utils.Log;
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
      Log.a("QRBridgeUtil", "App runtime is null, unable to clear reader cache");
      return;
    }
    QQReaderSecurityFileHelper localQQReaderSecurityFileHelper = new QQReaderSecurityFileHelper();
    File localFile = ((AppRuntime)localObject).getSecurityBusinessRootFile(localQQReaderSecurityFileHelper);
    if (localFile != null) {}
    for (localObject = localFile.getAbsolutePath();; localObject = localQQReaderSecurityFileHelper.oldBusinessDir(((AppRuntime)localObject).getAccount()).getAbsolutePath())
    {
      FileUtils.a((String)localObject + File.separator + "Online", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */