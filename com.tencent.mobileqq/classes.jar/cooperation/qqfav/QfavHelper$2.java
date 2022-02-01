package cooperation.qqfav;

import bmkq;
import com.tencent.qphone.base.util.QLog;

public final class QfavHelper$2
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "notify(IS_PLUGININSTALLED) qqfav.apk");
      }
      bmkq.a().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.2
 * JD-Core Version:    0.7.0.1
 */