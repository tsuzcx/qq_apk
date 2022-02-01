package cooperation.qzone;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

final class QZoneHelper$12
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      QZoneHelper.preloadQzone((QQAppInterface)localAppRuntime, "QQPublicAccount");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.12
 * JD-Core Version:    0.7.0.1
 */