package cooperation.qqpim;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import mqq.app.AppRuntime;

public class QQPimPluginLoadRunnable
  implements Runnable
{
  private QQPimPluginLoadRunnable.IPluginLoadListener a;
  private IPluginManager b;
  private long c;
  private boolean d;
  
  public QQPimPluginLoadRunnable(QQPimPluginLoadRunnable.IPluginLoadListener paramIPluginLoadListener)
  {
    this.a = paramIPluginLoadListener;
  }
  
  private QQAppInterface b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a()
  {
    this.a = null;
    this.d = true;
  }
  
  public void run()
  {
    this.c = System.currentTimeMillis();
    Object localObject1 = b();
    if (localObject1 == null) {
      return;
    }
    this.b = ((IPluginManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_PLUGIN));
    Object localObject2 = this.b;
    if (localObject2 == null) {
      return;
    }
    localObject2 = ((IPluginManager)localObject2).d("qqpim_plugin.apk");
    if (localObject2 != null) {
      if (((PluginBaseInfo)localObject2).mState == 4)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i(QQPimDefineList.a, 1, "onPluginManagerLoaded has installed");
        }
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006716", "0X8006716", 0, 0, "", "", "", "");
        localObject2 = this.a;
        if (localObject2 != null) {
          ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject2).a();
        }
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.i(QQPimDefineList.a, 1, "onPluginManagerLoaded start down or install...");
        }
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006717", "0X8006717", 0, 0, "", "", "", "");
        this.b.e("qqpim_plugin.apk");
        localObject2 = this.a;
        if (localObject2 != null) {
          ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject2).b();
        }
      }
    }
    while (!this.d) {
      if (System.currentTimeMillis() - this.c > 30000L)
      {
        ReportController.b(b(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
        localObject1 = this.a;
        if (localObject1 != null) {
          ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject1).a(-5);
        }
      }
      else
      {
        localObject2 = this.b.d("qqpim_plugin.apk");
        if (localObject2 == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(QQPimDefineList.a, 4, "null == pluginInfo");
          }
          if (this.b.isReady())
          {
            ReportController.b(b(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
            localObject1 = this.a;
            if (localObject1 != null) {
              ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject1).a(-1);
            }
          }
        }
        else
        {
          Object localObject3;
          if (QLog.isDevelopLevel())
          {
            localObject3 = QQPimDefineList.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("queryPluginInfo mState : ");
            localStringBuilder.append(((PluginBaseInfo)localObject2).mState);
            localStringBuilder.append(" progress:");
            localStringBuilder.append(((PluginBaseInfo)localObject2).mDownloadProgress);
            QLog.d((String)localObject3, 4, localStringBuilder.toString());
          }
          if (((PluginBaseInfo)localObject2).mState == 4)
          {
            ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006718", "0X8006718", 0, 0, "", "", "", "");
            localObject1 = this.a;
            if (localObject1 != null) {
              ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject1).a();
            }
          }
          else
          {
            if (((PluginBaseInfo)localObject2).mState == 0)
            {
              this.b.e("qqpim_plugin.apk");
            }
            else if (((PluginBaseInfo)localObject2).mState == 3)
            {
              localObject3 = this.a;
              if (localObject3 != null) {
                ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject3).a(((PluginBaseInfo)localObject2).mDownloadProgress);
              }
            }
            else if (((PluginBaseInfo)localObject2).mState == 1)
            {
              localObject3 = this.a;
              if (localObject3 != null) {
                ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject3).a(((PluginBaseInfo)localObject2).mDownloadProgress);
              }
            }
            else
            {
              if (((PluginBaseInfo)localObject2).mState != 2) {
                break label572;
              }
              localObject3 = this.a;
              if (localObject3 != null) {
                ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject3).a(((PluginBaseInfo)localObject2).mDownloadProgress);
              }
            }
            try
            {
              Thread.sleep(500L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
            continue;
            label572:
            if (localInterruptedException.mState == -1)
            {
              ReportController.b(b(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
              localObject1 = this.a;
              if (localObject1 != null) {
                ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject1).a(-6);
              }
            }
            else if (localInterruptedException.mState == -2)
            {
              ReportController.b(b(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
              localObject1 = this.a;
              if (localObject1 != null) {
                ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject1).a(-3);
              }
            }
            else
            {
              ReportController.b(b(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
              localObject1 = this.a;
              if (localObject1 != null) {
                ((QQPimPluginLoadRunnable.IPluginLoadListener)localObject1).a(-2);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginLoadRunnable
 * JD-Core Version:    0.7.0.1
 */