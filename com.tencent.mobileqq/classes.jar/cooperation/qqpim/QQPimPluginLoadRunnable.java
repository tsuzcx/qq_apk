package cooperation.qqpim;

import bcst;
import blfh;
import blmr;
import blmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class QQPimPluginLoadRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private blfh jdField_a_of_type_Blfh;
  private blmy jdField_a_of_type_Blmy;
  private boolean jdField_a_of_type_Boolean;
  
  public QQPimPluginLoadRunnable(blmy paramblmy)
  {
    this.jdField_a_of_type_Blmy = paramblmy;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blmy = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    label114:
    label249:
    do
    {
      do
      {
        do
        {
          PluginInfo localPluginInfo;
          do
          {
            do
            {
              do
              {
                return;
                this.jdField_a_of_type_Blfh = ((blfh)localQQAppInterface.getManager(27));
              } while (this.jdField_a_of_type_Blfh == null);
              localPluginInfo = this.jdField_a_of_type_Blfh.a("qqpim_plugin.apk");
              if (localPluginInfo != null)
              {
                if (localPluginInfo.mState != 4) {
                  break label182;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.i(blmr.a, 1, "onPluginManagerLoaded has installed");
                }
                bcst.b(localQQAppInterface, "CliOper", "", "", "0X8006716", "0X8006716", 0, 0, "", "", "", "");
                if (this.jdField_a_of_type_Blmy != null) {
                  this.jdField_a_of_type_Blmy.a();
                }
              }
              do
              {
                for (;;)
                {
                  if (this.jdField_a_of_type_Boolean) {
                    break label460;
                  }
                  if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 30000L) {
                    break label249;
                  }
                  bcst.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                  if (this.jdField_a_of_type_Blmy == null) {
                    break;
                  }
                  this.jdField_a_of_type_Blmy.a(-5);
                  return;
                  if (QLog.isDevelopLevel()) {
                    QLog.i(blmr.a, 1, "onPluginManagerLoaded start down or install...");
                  }
                  bcst.b(localQQAppInterface, "CliOper", "", "", "0X8006717", "0X8006717", 0, 0, "", "", "", "");
                  this.jdField_a_of_type_Blfh.a("qqpim_plugin.apk");
                  if (this.jdField_a_of_type_Blmy != null) {
                    this.jdField_a_of_type_Blmy.b();
                  }
                }
                localPluginInfo = this.jdField_a_of_type_Blfh.a("qqpim_plugin.apk");
                if (localPluginInfo != null) {
                  break label333;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d(blmr.a, 4, "null == pluginInfo");
                }
              } while (!this.jdField_a_of_type_Blfh.isReady());
              bcst.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
            } while (this.jdField_a_of_type_Blmy == null);
            this.jdField_a_of_type_Blmy.a(-1);
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d(blmr.a, 4, "queryPluginInfo mState : " + localPluginInfo.mState + " progress:" + localPluginInfo.mDownloadProgress);
            }
            if (localPluginInfo.mState != 4) {
              break;
            }
            bcst.b(localQQAppInterface, "CliOper", "", "", "0X8006718", "0X8006718", 0, 0, "", "", "", "");
          } while (this.jdField_a_of_type_Blmy == null);
          this.jdField_a_of_type_Blmy.a();
          return;
          if (localPluginInfo.mState == 0) {
            this.jdField_a_of_type_Blfh.a("qqpim_plugin.apk");
          }
          for (;;)
          {
            try
            {
              Thread.sleep(500L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
            break label114;
            break;
            if (localInterruptedException.mState == 3)
            {
              if (this.jdField_a_of_type_Blmy != null) {
                this.jdField_a_of_type_Blmy.a(localInterruptedException.mDownloadProgress);
              }
            }
            else if (localInterruptedException.mState == 1)
            {
              if (this.jdField_a_of_type_Blmy != null) {
                this.jdField_a_of_type_Blmy.a(localInterruptedException.mDownloadProgress);
              }
            }
            else
            {
              if (localInterruptedException.mState != 2) {
                break label555;
              }
              if (this.jdField_a_of_type_Blmy != null) {
                this.jdField_a_of_type_Blmy.a(localInterruptedException.mDownloadProgress);
              }
            }
          }
          if (localInterruptedException.mState != -1) {
            break;
          }
          bcst.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
        } while (this.jdField_a_of_type_Blmy == null);
        this.jdField_a_of_type_Blmy.a(-6);
        return;
        if (localInterruptedException.mState != -2) {
          break;
        }
        bcst.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
      } while (this.jdField_a_of_type_Blmy == null);
      this.jdField_a_of_type_Blmy.a(-3);
      return;
      bcst.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
    } while (this.jdField_a_of_type_Blmy == null);
    label182:
    label333:
    this.jdField_a_of_type_Blmy.a(-2);
    label460:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginLoadRunnable
 * JD-Core Version:    0.7.0.1
 */