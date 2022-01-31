package cooperation.qqfav;

import bfhn;
import com.tencent.qphone.base.util.QLog;

public final class QfavHelper$2
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "notify(sPluginInstalled) qqfav.apk");
      }
      bfhn.a().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.2
 * JD-Core Version:    0.7.0.1
 */