package cooperation.qqfav;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;

final class QfavHelper$4
  extends Thread
{
  QfavHelper$4(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener) {}
  
  public void run()
  {
    PluginManagerHelper.getPluginInterface(this.a, new QfavHelper.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.4
 * JD-Core Version:    0.7.0.1
 */