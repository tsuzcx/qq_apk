package cooperation.qzone.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import bcdy;
import bhik;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public abstract class IQZonePluginManager
  extends QZoneRemotePluginManager.Stub
{
  static void doLaunchPluginBroadcast(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((TextUtils.isEmpty(paramPluginParams.mIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.mUin)))
    {
      paramPluginParams.mIntent.putExtra("uin", paramPluginParams.mUin);
      paramPluginParams.mIntent.putExtra("qzone_uin", paramPluginParams.mUin);
    }
    paramPluginParams.mIntent.putExtra("pluginsdk_selfuin", paramPluginParams.mUin);
    paramPluginParams.mIntent.putExtra("clsUploader", bcdy.class.getName());
    Object localObject = paramPluginParams.mPluginID;
    localObject = new File(QZonePluginUtils.getPluginInstallDir(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramPluginParams.mPluginName, paramPluginParams.mPluginID, ((File)localObject).getCanonicalPath(), paramPluginParams.mConponentName, paramPluginParams.mIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void doLaunchPluginService(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((TextUtils.isEmpty(paramPluginParams.mIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.mUin)))
    {
      paramPluginParams.mIntent.putExtra("uin", paramPluginParams.mUin);
      paramPluginParams.mIntent.putExtra("qzone_uin", paramPluginParams.mUin);
    }
    paramPluginParams.mIntent.putExtra("pluginsdk_selfuin", paramPluginParams.mUin);
    paramPluginParams.mIntent.putExtra("clsUploader", bcdy.class.getName());
    Object localObject = paramPluginParams.mPluginID;
    localObject = new File(QZonePluginUtils.getPluginInstallDir(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (paramPluginParams.mServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, paramPluginParams.mPluginName, paramPluginParams.mPluginID, (String)localObject, paramPluginParams.mConponentName, paramPluginParams.mIntent, paramPluginParams.mServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, paramPluginParams, (String)localObject), 5, null, false);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PluginDebug", 2, "doLaunchPluginService", paramContext);
      }
    }
  }
  
  static void doOpenActivityForResult(Activity paramActivity, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((paramPluginParams == null) || (paramActivity == null) || (paramPluginParams.mIntent == null)) {}
    for (;;)
    {
      return;
      paramPluginParams.mIntent.setClass(paramActivity, paramPluginParams.mProxyActivityClass);
      if (TextUtils.isEmpty(paramPluginParams.mIntent.getStringExtra("uin")))
      {
        paramPluginParams.mIntent.putExtra("uin", paramPluginParams.mUin);
        paramPluginParams.mIntent.putExtra("qzone_uin", paramPluginParams.mUin);
      }
      paramPluginParams.mIntent.putExtra("pluginsdk_selfuin", paramPluginParams.mUin);
      paramPluginParams.mIntent.putExtra("clsUploader", bcdy.class.getName());
      try
      {
        File localFile = new File(QZonePluginUtils.getPluginInstallDir(paramActivity), paramPluginParams.mPluginID);
        PluginProxyActivity.openActivityForResult(paramActivity, paramPluginParams.mPluginName, paramPluginParams.mPluginID, localFile.getCanonicalPath(), paramPluginParams.mConponentName, paramPluginParams.mIntent, paramPluginParams.mRequestCode);
        if ((paramPluginParams.mDialog != null) && ((paramPluginParams.mDialog instanceof bhik)) && (paramActivity != null))
        {
          paramActivity.overridePendingTransition(2130772106, 2130772106);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("feilongzou", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  private static void handleOtherProcess(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    QZonePluginMangerHelper.getQzonePluginClient(paramContext, new IQZonePluginManager.5(paramContext, paramPluginParams, paramOnPluginReadyListener));
  }
  
  public static void launchPluginBroadcast(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    IQZonePluginManager.3 local3 = new IQZonePluginManager.3();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      handleOtherProcess(paramContext, paramPluginParams, local3);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(175)).readyForLaunch(paramContext, paramPluginParams, local3);
  }
  
  public static void launchPluginService(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    IQZonePluginManager.2 local2 = new IQZonePluginManager.2();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      handleOtherProcess(paramContext, paramPluginParams, local2);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(175)).readyForLaunch(paramContext, paramPluginParams, local2);
  }
  
  public static void openActivityForResult(Activity paramActivity, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if (paramPluginParams.mProgressTips != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramPluginParams.mProgressTips, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new IQZonePluginManager.1();
    if ((paramPluginParams.mDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, paramPluginParams.mDialog, paramPluginParams.mPluginName, paramPluginParams.mPluginID, paramPluginParams.mDialogDismissBySDK, paramPluginParams.mTimeOut).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      handleOtherProcess(paramActivity, paramPluginParams, (IQZonePluginManager.OnPluginReadyListener)localObject);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(175)).readyForLaunch(paramActivity, paramPluginParams, (IQZonePluginManager.OnPluginReadyListener)localObject);
  }
  
  public abstract boolean cancelInstall(String paramString);
  
  public abstract void installPituSo(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt);
  
  public abstract boolean installPlugin(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt);
  
  public abstract boolean isPluginInstalled(String paramString);
  
  public abstract boolean isReady();
  
  public abstract PluginRecord queryPlugin(String paramString);
  
  public abstract void readyForLaunch(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void setReadyToNetworking();
  
  public abstract void triggerQQDownloadPtuFilter();
  
  public abstract boolean uninstallPlugin(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.IQZonePluginManager
 * JD-Core Version:    0.7.0.1
 */