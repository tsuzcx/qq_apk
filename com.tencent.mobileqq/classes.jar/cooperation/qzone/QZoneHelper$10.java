package cooperation.qzone;

import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class QZoneHelper$10
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    if ((localAppRuntime instanceof AppRuntime)) {
      QZoneHelper.preloadQzone(localAppRuntime, "QQPublicAccount");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.10
 * JD-Core Version:    0.7.0.1
 */