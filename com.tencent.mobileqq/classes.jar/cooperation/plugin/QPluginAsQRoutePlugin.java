package cooperation.plugin;

import android.content.ServiceConnection;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.mobileqq.qroute.module.QRoutePluginOpenParams;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QPluginAsQRoutePlugin
  implements IQRoutePlugin
{
  private String a;
  
  public QPluginAsQRoutePlugin(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private PluginBaseInfo a()
  {
    PluginInfo localPluginInfo = null;
    if (MobileQQ.sProcessId == 1) {
      localPluginInfo = ((IPluginManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).a(this.jdField_a_of_type_JavaLangString);
    }
    PluginManagerClient localPluginManagerClient;
    do
    {
      return localPluginInfo;
      localPluginManagerClient = a();
    } while (!localPluginManagerClient.useful());
    return localPluginManagerClient.queryPlugin(this.jdField_a_of_type_JavaLangString);
  }
  
  private PluginManagerClient a()
  {
    return PluginManagerHelper.getPluginInterface(MobileQQ.sMobileQQ);
  }
  
  private IPluginManager.PluginParams a(QRoutePluginOpenParams paramQRoutePluginOpenParams)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    PluginBaseInfo localPluginBaseInfo = a();
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(localPluginBaseInfo.mType, localPluginBaseInfo.mSubType);
    localPluginParams.jdField_a_of_type_JavaLangString = localAppRuntime.getCurrentUin();
    localPluginParams.b = this.jdField_a_of_type_JavaLangString;
    if (localPluginBaseInfo.mSubType == 1) {
      localPluginParams.b = paramQRoutePluginOpenParams.subModule;
    }
    localPluginParams.f = paramQRoutePluginOpenParams.component;
    localPluginParams.jdField_a_of_type_JavaLangClass = paramQRoutePluginOpenParams.componentContainer;
    localPluginParams.c = paramQRoutePluginOpenParams.activityRequestCode;
    localPluginParams.f = paramQRoutePluginOpenParams.component;
    localPluginParams.e = paramQRoutePluginOpenParams.pluginName;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramQRoutePluginOpenParams.intent;
    localPluginParams.jdField_a_of_type_Boolean = paramQRoutePluginOpenParams.isPreload;
    return localPluginParams;
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return true;
    }
    String str = MobileQQ.sMobileQQ.getQQProcessName();
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label49;
        }
        if (str.endsWith(paramArrayOfString[i])) {
          break;
        }
        i += 1;
      }
    }
    label49:
    return false;
  }
  
  public void bindService(QRoutePluginOpenParams paramQRoutePluginOpenParams, ServiceConnection paramServiceConnection)
  {
    IPluginManager.PluginParams localPluginParams = a(paramQRoutePluginOpenParams);
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.c(paramQRoutePluginOpenParams.context, localPluginParams);
  }
  
  public boolean exist()
  {
    return a() != null;
  }
  
  public void install(IQRoutePluginInstallListener paramIQRoutePluginInstallListener)
  {
    install(paramIQRoutePluginInstallListener, false);
  }
  
  public void install(IQRoutePluginInstallListener paramIQRoutePluginInstallListener, boolean paramBoolean)
  {
    paramIQRoutePluginInstallListener = new QPluginAsQRoutePlugin.2(this, paramIQRoutePluginInstallListener);
    if (MobileQQ.sProcessId == 1) {
      ((IPluginManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).installPlugin(this.jdField_a_of_type_JavaLangString, paramIQRoutePluginInstallListener);
    }
    PluginManagerClient localPluginManagerClient;
    do
    {
      return;
      localPluginManagerClient = a();
    } while (!localPluginManagerClient.useful());
    localPluginManagerClient.installPlugin(this.jdField_a_of_type_JavaLangString, paramIQRoutePluginInstallListener);
  }
  
  public boolean isInstalled()
  {
    boolean bool = false;
    if (MobileQQ.sProcessId == 1) {
      bool = ((IPluginManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).isPlugininstalled(this.jdField_a_of_type_JavaLangString);
    }
    PluginManagerClient localPluginManagerClient;
    do
    {
      return bool;
      localPluginManagerClient = a();
    } while (!localPluginManagerClient.useful());
    return localPluginManagerClient.isPluginInstalled(this.jdField_a_of_type_JavaLangString);
  }
  
  public Class loadPluginClass(String paramString)
  {
    PluginBaseInfo localPluginBaseInfo = a();
    if (!a(localPluginBaseInfo.mProcesses))
    {
      QLog.e("QRoute.Module.Plugin", 1, "loadPluginClass failed" + paramString + " " + this.jdField_a_of_type_JavaLangString + " can't not run in current Process:" + MobileQQ.sMobileQQ);
      localObject1 = new StringBuilder(50);
      ((StringBuilder)localObject1).append("QRouteApi: its impl ").append(paramString).append(" in Plugin " + this.jdField_a_of_type_JavaLangString).append(" can not run on this process: ").append(MobileQQ.sMobileQQ.getQQProcessName()).append("，请联系API开发者沟通处理。\n");
      throw new RuntimeException(((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localPluginBaseInfo != null)
    {
      localObject1 = localObject2;
      if (localPluginBaseInfo.mState == 4) {
        if (localPluginBaseInfo.mSubType == 1)
        {
          localObject1 = new StringBuilder(50);
          ((StringBuilder)localObject1).append("QRouteApi:  ").append(paramString).append(" not support shadow plugin: " + this.jdField_a_of_type_JavaLangString);
          throw new RuntimeException(((StringBuilder)localObject1).toString());
        }
      }
    }
    try
    {
      localObject1 = PluginStatic.getOrCreateClassLoader(MobileQQ.sMobileQQ, this.jdField_a_of_type_JavaLangString).loadClass(paramString);
      return localObject1;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public void openActivityForResult(QRoutePluginOpenParams paramQRoutePluginOpenParams)
  {
    Object localObject = (IPluginManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN);
    if (paramQRoutePluginOpenParams.openResultListener != null) {}
    for (localObject = new QPluginAsQRoutePlugin.1(this, paramQRoutePluginOpenParams);; localObject = null)
    {
      IPluginManager.a(paramQRoutePluginOpenParams.context, a(paramQRoutePluginOpenParams), (IPluginManager.OnOpenPluginListener)localObject);
      return;
    }
  }
  
  public String pluginId()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public QRoutePluginInfo queryPluginInfo()
  {
    QRoutePluginInfo localQRoutePluginInfo = new QRoutePluginInfo();
    PluginBaseInfo localPluginBaseInfo = a();
    if (localPluginBaseInfo == null) {
      return null;
    }
    localQRoutePluginInfo.setState(localPluginBaseInfo.mState);
    localQRoutePluginInfo.setID(localPluginBaseInfo.mID);
    localQRoutePluginInfo.setName(localPluginBaseInfo.mName);
    return localQRoutePluginInfo;
  }
  
  public void startService(QRoutePluginOpenParams paramQRoutePluginOpenParams)
  {
    IPluginManager.c(paramQRoutePluginOpenParams.context, a(paramQRoutePluginOpenParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.QPluginAsQRoutePlugin
 * JD-Core Version:    0.7.0.1
 */