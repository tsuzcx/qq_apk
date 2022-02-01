package cooperation.qqpim;

import bdla;
import blvy;
import bmdk;
import bmdr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class QQPimPluginLoadRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private blvy jdField_a_of_type_Blvy;
  private bmdr jdField_a_of_type_Bmdr;
  private boolean jdField_a_of_type_Boolean;
  
  public QQPimPluginLoadRunnable(bmdr parambmdr)
  {
    this.jdField_a_of_type_Bmdr = parambmdr;
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
    this.jdField_a_of_type_Bmdr = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    label115:
    label250:
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
                this.jdField_a_of_type_Blvy = ((blvy)localQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN));
              } while (this.jdField_a_of_type_Blvy == null);
              localPluginInfo = this.jdField_a_of_type_Blvy.a("qqpim_plugin.apk");
              if (localPluginInfo != null)
              {
                if (localPluginInfo.mState != 4) {
                  break label183;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.i(bmdk.a, 1, "onPluginManagerLoaded has installed");
                }
                bdla.b(localQQAppInterface, "CliOper", "", "", "0X8006716", "0X8006716", 0, 0, "", "", "", "");
                if (this.jdField_a_of_type_Bmdr != null) {
                  this.jdField_a_of_type_Bmdr.a();
                }
              }
              do
              {
                for (;;)
                {
                  if (this.jdField_a_of_type_Boolean) {
                    break label461;
                  }
                  if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 30000L) {
                    break label250;
                  }
                  bdla.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                  if (this.jdField_a_of_type_Bmdr == null) {
                    break;
                  }
                  this.jdField_a_of_type_Bmdr.a(-5);
                  return;
                  if (QLog.isDevelopLevel()) {
                    QLog.i(bmdk.a, 1, "onPluginManagerLoaded start down or install...");
                  }
                  bdla.b(localQQAppInterface, "CliOper", "", "", "0X8006717", "0X8006717", 0, 0, "", "", "", "");
                  this.jdField_a_of_type_Blvy.a("qqpim_plugin.apk");
                  if (this.jdField_a_of_type_Bmdr != null) {
                    this.jdField_a_of_type_Bmdr.b();
                  }
                }
                localPluginInfo = this.jdField_a_of_type_Blvy.a("qqpim_plugin.apk");
                if (localPluginInfo != null) {
                  break label334;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d(bmdk.a, 4, "null == pluginInfo");
                }
              } while (!this.jdField_a_of_type_Blvy.isReady());
              bdla.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
            } while (this.jdField_a_of_type_Bmdr == null);
            this.jdField_a_of_type_Bmdr.a(-1);
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d(bmdk.a, 4, "queryPluginInfo mState : " + localPluginInfo.mState + " progress:" + localPluginInfo.mDownloadProgress);
            }
            if (localPluginInfo.mState != 4) {
              break;
            }
            bdla.b(localQQAppInterface, "CliOper", "", "", "0X8006718", "0X8006718", 0, 0, "", "", "", "");
          } while (this.jdField_a_of_type_Bmdr == null);
          this.jdField_a_of_type_Bmdr.a();
          return;
          if (localPluginInfo.mState == 0) {
            this.jdField_a_of_type_Blvy.a("qqpim_plugin.apk");
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
            break label115;
            break;
            if (localInterruptedException.mState == 3)
            {
              if (this.jdField_a_of_type_Bmdr != null) {
                this.jdField_a_of_type_Bmdr.a(localInterruptedException.mDownloadProgress);
              }
            }
            else if (localInterruptedException.mState == 1)
            {
              if (this.jdField_a_of_type_Bmdr != null) {
                this.jdField_a_of_type_Bmdr.a(localInterruptedException.mDownloadProgress);
              }
            }
            else
            {
              if (localInterruptedException.mState != 2) {
                break label556;
              }
              if (this.jdField_a_of_type_Bmdr != null) {
                this.jdField_a_of_type_Bmdr.a(localInterruptedException.mDownloadProgress);
              }
            }
          }
          if (localInterruptedException.mState != -1) {
            break;
          }
          bdla.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
        } while (this.jdField_a_of_type_Bmdr == null);
        this.jdField_a_of_type_Bmdr.a(-6);
        return;
        if (localInterruptedException.mState != -2) {
          break;
        }
        bdla.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
      } while (this.jdField_a_of_type_Bmdr == null);
      this.jdField_a_of_type_Bmdr.a(-3);
      return;
      bdla.b(a(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
    } while (this.jdField_a_of_type_Bmdr == null);
    label183:
    label334:
    this.jdField_a_of_type_Bmdr.a(-2);
    label461:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginLoadRunnable
 * JD-Core Version:    0.7.0.1
 */