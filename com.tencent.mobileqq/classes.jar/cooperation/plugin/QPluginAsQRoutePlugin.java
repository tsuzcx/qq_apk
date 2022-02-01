package cooperation.plugin;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.mobileqq.qroute.module.QRoutePluginActivityParams;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.mobileqq.qroute.module.QRoutePluginReceiverParams;
import com.tencent.mobileqq.qroute.module.QRoutePluginServiceParams;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QPluginAsQRoutePlugin
  implements IQRoutePlugin
{
  private String a;
  
  public QPluginAsQRoutePlugin(String paramString)
  {
    this.a = paramString;
  }
  
  private PluginBaseInfo a()
  {
    int i = MobileQQ.sProcessId;
    PluginBaseInfo localPluginBaseInfo = null;
    if (i == 1) {
      return ((IPluginManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).d(this.a);
    }
    PluginManagerClient localPluginManagerClient = b();
    if (localPluginManagerClient.useful()) {
      localPluginBaseInfo = localPluginManagerClient.queryPlugin(this.a);
    }
    return localPluginBaseInfo;
  }
  
  private IPluginManager.PluginParams a(QRoutePluginActivityParams paramQRoutePluginActivityParams)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    PluginBaseInfo localPluginBaseInfo = a();
    if (localPluginBaseInfo == null) {
      return null;
    }
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(localPluginBaseInfo.mType, localPluginBaseInfo.mSubType);
    localPluginParams.c = ((AppRuntime)localObject).getCurrentUin();
    localObject = this.a;
    localPluginParams.d = ((String)localObject);
    localPluginParams.g = ((String)localObject);
    if (localPluginBaseInfo.mSubType == 1) {
      localPluginParams.d = paramQRoutePluginActivityParams.subModule;
    }
    localPluginParams.h = paramQRoutePluginActivityParams.activityName;
    localPluginParams.i = paramQRoutePluginActivityParams.activityProxy;
    localPluginParams.k = paramQRoutePluginActivityParams.activityRequestCode;
    localPluginParams.h = paramQRoutePluginActivityParams.activityName;
    if (paramQRoutePluginActivityParams.intent == null) {
      paramQRoutePluginActivityParams.intent = new Intent(paramQRoutePluginActivityParams.context, paramQRoutePluginActivityParams.activityProxy);
    }
    localPluginParams.j = paramQRoutePluginActivityParams.intent;
    localPluginParams.m = ((PreloadProcHitPluginSession)paramQRoutePluginActivityParams.session);
    localPluginParams.r = paramQRoutePluginActivityParams.timeoutMills;
    localPluginParams.l = paramQRoutePluginActivityParams.dialog;
    return localPluginParams;
  }
  
  private IPluginManager.PluginParams a(QRoutePluginReceiverParams paramQRoutePluginReceiverParams)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    PluginBaseInfo localPluginBaseInfo = a();
    if (localPluginBaseInfo == null) {
      return null;
    }
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(localPluginBaseInfo.mType, localPluginBaseInfo.mSubType);
    localPluginParams.c = ((AppRuntime)localObject).getCurrentUin();
    localObject = this.a;
    localPluginParams.d = ((String)localObject);
    localPluginParams.g = ((String)localObject);
    if (localPluginBaseInfo.mSubType == 1) {
      localPluginParams.d = paramQRoutePluginReceiverParams.subModule;
    }
    localPluginParams.h = paramQRoutePluginReceiverParams.receiverName;
    if (paramQRoutePluginReceiverParams.intent == null) {
      paramQRoutePluginReceiverParams.intent = new Intent(paramQRoutePluginReceiverParams.context, paramQRoutePluginReceiverParams.receiverProxy);
    }
    localPluginParams.j = paramQRoutePluginReceiverParams.intent;
    localPluginParams.n = paramQRoutePluginReceiverParams.isPreload;
    return localPluginParams;
  }
  
  private IPluginManager.PluginParams a(QRoutePluginServiceParams paramQRoutePluginServiceParams)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    PluginBaseInfo localPluginBaseInfo = a();
    if (localPluginBaseInfo == null) {
      return null;
    }
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(localPluginBaseInfo.mType, localPluginBaseInfo.mSubType);
    localPluginParams.c = ((AppRuntime)localObject).getCurrentUin();
    localObject = this.a;
    localPluginParams.d = ((String)localObject);
    localPluginParams.g = ((String)localObject);
    if (localPluginBaseInfo.mSubType == 1) {
      localPluginParams.d = paramQRoutePluginServiceParams.subModule;
    }
    localPluginParams.h = paramQRoutePluginServiceParams.serviceName;
    if (paramQRoutePluginServiceParams.intent == null) {
      paramQRoutePluginServiceParams.intent = new Intent(paramQRoutePluginServiceParams.context, paramQRoutePluginServiceParams.serviceProxy);
    }
    localPluginParams.j = paramQRoutePluginServiceParams.intent;
    localPluginParams.n = paramQRoutePluginServiceParams.isPreload;
    return localPluginParams;
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return true;
      }
      String str = MobileQQ.sMobileQQ.getQQProcessName();
      if (paramArrayOfString != null)
      {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (str.endsWith(paramArrayOfString[i])) {
            return true;
          }
          i += 1;
        }
      }
      bool = false;
    }
    return bool;
  }
  
  private PluginManagerClient b()
  {
    return PluginManagerHelper.getPluginInterface(MobileQQ.sMobileQQ);
  }
  
  public void bindService(QRoutePluginServiceParams paramQRoutePluginServiceParams, ServiceConnection paramServiceConnection)
  {
    IPluginManager.PluginParams localPluginParams = a(paramQRoutePluginServiceParams);
    if (localPluginParams != null) {
      localPluginParams.o = paramServiceConnection;
    }
    IPluginManager.c(paramQRoutePluginServiceParams.context, localPluginParams);
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
    if (MobileQQ.sProcessId == 1)
    {
      ((IPluginManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).installPlugin(this.a, paramIQRoutePluginInstallListener);
      return;
    }
    PluginManagerClient localPluginManagerClient = b();
    if (localPluginManagerClient.useful()) {
      localPluginManagerClient.installPlugin(this.a, paramIQRoutePluginInstallListener);
    }
  }
  
  public boolean isInstalled()
  {
    if (MobileQQ.sProcessId == 1) {
      return ((IPluginManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).isPlugininstalled(this.a);
    }
    PluginManagerClient localPluginManagerClient = b();
    if (localPluginManagerClient.useful()) {
      return localPluginManagerClient.isPluginInstalled(this.a);
    }
    return false;
  }
  
  public void loadPlugin()
  {
    Object localObject = a();
    if ((localObject != null) && (((PluginBaseInfo)localObject).mSubType == 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadPlugin for DYNAMIC_FEATURE_PLUGIN ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("QRoute.Module.Plugin", 1, ((StringBuilder)localObject).toString());
      LoadCompactDynamicFeature.a().b(this.a, BaseApplicationImpl.sApplication);
    }
  }
  
  public Class loadPluginClass(String paramString)
  {
    Object localObject = a();
    if (a(((PluginBaseInfo)localObject).mProcesses))
    {
      if ((localObject != null) && (((PluginBaseInfo)localObject).mState == 4))
      {
        if (((PluginBaseInfo)localObject).mSubType != 1) {
          try
          {
            paramString = PluginStatic.getOrCreateClassLoader(MobileQQ.sMobileQQ, this.a).loadClass(paramString);
            return paramString;
          }
          catch (Exception paramString)
          {
            throw new RuntimeException(paramString);
          }
        }
        localObject = new StringBuilder(50);
        ((StringBuilder)localObject).append("QRouteApi:  ");
        ((StringBuilder)localObject).append(paramString);
        paramString = new StringBuilder();
        paramString.append(" not support shadow plugin: ");
        paramString.append(this.a);
        ((StringBuilder)localObject).append(paramString.toString());
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadPluginClass failed");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" can't not run in current Process:");
    ((StringBuilder)localObject).append(MobileQQ.sMobileQQ);
    QLog.e("QRoute.Module.Plugin", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("QRouteApi: its impl ");
    ((StringBuilder)localObject).append(paramString);
    paramString = new StringBuilder();
    paramString.append(" in Plugin ");
    paramString.append(this.a);
    ((StringBuilder)localObject).append(paramString.toString());
    ((StringBuilder)localObject).append(" can not run on this process: ");
    ((StringBuilder)localObject).append(MobileQQ.sMobileQQ.getQQProcessName());
    ((StringBuilder)localObject).append("，请联系API开发者沟通处理。\n");
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public String pluginId()
  {
    return this.a;
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
    localQRoutePluginInfo.setLength(localPluginBaseInfo.mLength);
    localQRoutePluginInfo.setMD5(localPluginBaseInfo.mMD5);
    localQRoutePluginInfo.setURL(localPluginBaseInfo.mURL);
    localQRoutePluginInfo.setVersion(localPluginBaseInfo.mVersion);
    localQRoutePluginInfo.setProcesses(localPluginBaseInfo.mProcesses);
    localQRoutePluginInfo.setSubType(localPluginBaseInfo.mSubType);
    localQRoutePluginInfo.setInstallCode(localPluginBaseInfo.installCode);
    localQRoutePluginInfo.setDownloadDuration(localPluginBaseInfo.downloadDuration);
    localQRoutePluginInfo.setStartDownloadNetType(localPluginBaseInfo.startDownloadNetType);
    localQRoutePluginInfo.setCostDex2Oat(localPluginBaseInfo.costDex2Oat);
    localQRoutePluginInfo.setCostApk(localPluginBaseInfo.costApk);
    localQRoutePluginInfo.setCostLib(localPluginBaseInfo.costLib);
    return localQRoutePluginInfo;
  }
  
  public void sendBroadcast(QRoutePluginReceiverParams paramQRoutePluginReceiverParams)
  {
    IPluginManager.b(paramQRoutePluginReceiverParams.context, a(paramQRoutePluginReceiverParams));
  }
  
  public void startActivityForResult(QRoutePluginActivityParams paramQRoutePluginActivityParams)
  {
    QPluginAsQRoutePlugin.1 local1;
    if (paramQRoutePluginActivityParams.openResultListener != null) {
      local1 = new QPluginAsQRoutePlugin.1(this, paramQRoutePluginActivityParams);
    } else {
      local1 = null;
    }
    IPluginManager.a(paramQRoutePluginActivityParams.context, a(paramQRoutePluginActivityParams), local1);
  }
  
  public void startService(QRoutePluginServiceParams paramQRoutePluginServiceParams)
  {
    IPluginManager.c(paramQRoutePluginServiceParams.context, a(paramQRoutePluginServiceParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.QPluginAsQRoutePlugin
 * JD-Core Version:    0.7.0.1
 */