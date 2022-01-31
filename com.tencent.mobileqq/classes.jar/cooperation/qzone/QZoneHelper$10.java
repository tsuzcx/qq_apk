package cooperation.qzone;

import bizm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public final class QZoneHelper$10
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      bizm.a((QQAppInterface)localAppRuntime, "QQPublicAccount");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.10
 * JD-Core Version:    0.7.0.1
 */