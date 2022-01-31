package cooperation.qqpim;

import azqs;
import biqn;
import biyg;
import biyn;
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
  private biqn jdField_a_of_type_Biqn;
  private biyn jdField_a_of_type_Biyn;
  private boolean jdField_a_of_type_Boolean;
  
  public QQPimPluginLoadRunnable(biyn parambiyn)
  {
    this.jdField_a_of_type_Biyn = parambiyn;
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
    this.jdField_a_of_type_Biyn = null;
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
                this.jdField_a_of_type_Biqn = ((biqn)localQQAppInterface.getManager(27));
              } while (this.jdField_a_of_type_Biqn == null);
              localPluginInfo = this.jdField_a_of_type_Biqn.a("qqpim_plugin.apk");
              if (localPluginInfo != null)
              {
                if (localPluginInfo.mState != 4) {
                  break label182;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.i(biyg.a, 1, "onPluginManagerLoaded has installed");
                }
                azqs.b(localQQAppInterface, "CliOper", "", "", "0X8006716", "0X8006716", 0, 0, "", "", "", "");
                if (this.jdField_a_of_type_Biyn != null) {
                  this.jdField_a_of_type_Biyn.a();
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
                  azqs.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                  if (this.jdField_a_of_type_Biyn == null) {
                    break;
                  }
                  this.jdField_a_of_type_Biyn.a(-5);
                  return;
                  if (QLog.isDevelopLevel()) {
                    QLog.i(biyg.a, 1, "onPluginManagerLoaded start down or install...");
                  }
                  azqs.b(localQQAppInterface, "CliOper", "", "", "0X8006717", "0X8006717", 0, 0, "", "", "", "");
                  this.jdField_a_of_type_Biqn.a("qqpim_plugin.apk");
                  if (this.jdField_a_of_type_Biyn != null) {
                    this.jdField_a_of_type_Biyn.b();
                  }
                }
                localPluginInfo = this.jdField_a_of_type_Biqn.a("qqpim_plugin.apk");
                if (localPluginInfo != null) {
                  break label333;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d(biyg.a, 4, "null == pluginInfo");
                }
              } while (!this.jdField_a_of_type_Biqn.isReady());
              azqs.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
            } while (this.jdField_a_of_type_Biyn == null);
            this.jdField_a_of_type_Biyn.a(-1);
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d(biyg.a, 4, "queryPluginInfo mState : " + localPluginInfo.mState + " progress:" + localPluginInfo.mDownloadProgress);
            }
            if (localPluginInfo.mState != 4) {
              break;
            }
            azqs.b(localQQAppInterface, "CliOper", "", "", "0X8006718", "0X8006718", 0, 0, "", "", "", "");
          } while (this.jdField_a_of_type_Biyn == null);
          this.jdField_a_of_type_Biyn.a();
          return;
          if (localPluginInfo.mState == 0) {
            this.jdField_a_of_type_Biqn.a("qqpim_plugin.apk");
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
              if (this.jdField_a_of_type_Biyn != null) {
                this.jdField_a_of_type_Biyn.a(localInterruptedException.mDownloadProgress);
              }
            }
            else if (localInterruptedException.mState == 1)
            {
              if (this.jdField_a_of_type_Biyn != null) {
                this.jdField_a_of_type_Biyn.a(localInterruptedException.mDownloadProgress);
              }
            }
            else
            {
              if (localInterruptedException.mState != 2) {
                break label555;
              }
              if (this.jdField_a_of_type_Biyn != null) {
                this.jdField_a_of_type_Biyn.a(localInterruptedException.mDownloadProgress);
              }
            }
          }
          if (localInterruptedException.mState != -1) {
            break;
          }
          azqs.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
        } while (this.jdField_a_of_type_Biyn == null);
        this.jdField_a_of_type_Biyn.a(-6);
        return;
        if (localInterruptedException.mState != -2) {
          break;
        }
        azqs.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
      } while (this.jdField_a_of_type_Biyn == null);
      this.jdField_a_of_type_Biyn.a(-3);
      return;
      azqs.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
    } while (this.jdField_a_of_type_Biyn == null);
    label182:
    label333:
    this.jdField_a_of_type_Biyn.a(-2);
    label460:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginLoadRunnable
 * JD-Core Version:    0.7.0.1
 */