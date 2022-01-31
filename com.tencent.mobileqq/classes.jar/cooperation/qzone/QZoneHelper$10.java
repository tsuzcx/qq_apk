package cooperation.qzone;

import bfpr;
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
      bfpr.a((QQAppInterface)localAppRuntime, "QQPublicAccount");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.10
 * JD-Core Version:    0.7.0.1
 */