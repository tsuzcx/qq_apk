package cooperation.plugin;

import amlv;
import amlw;
import amlx;
import amly;
import amlz;
import amma;
import ammb;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public abstract class IPluginManager
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static IPluginManager a(QQAppInterface paramQQAppInterface)
  {
    return new PluginManagerV2(paramQQAppInterface);
  }
  
  public static void a(Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramActivity, paramPluginParams, null);
  }
  
  public static void a(Activity paramActivity, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnOpenPluginListener paramOnOpenPluginListener)
  {
    Object localObject;
    if (paramPluginParams.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramPluginParams.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("plugin_launch_time", System.currentTimeMillis());
    paramOnOpenPluginListener = new amlv(paramOnOpenPluginListener);
    if ((paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, paramPluginParams.jdField_a_of_type_AndroidAppDialog, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_Boolean, paramPluginParams.jdField_c_of_type_Int).show();
    }
    if (paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null) {
      if (TextUtils.equals(paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.jdField_a_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString))
      {
        paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.b();
        paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.d();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      c(paramActivity, paramPluginParams, paramOnOpenPluginListener);
      return;
      PreloadProcHitMgr.a(paramPluginParams.jdField_b_of_type_JavaLangString);
    }
    ((IPluginManager)((QQAppInterface)localObject).getManager(26)).a(paramActivity, paramPluginParams, paramOnOpenPluginListener);
  }
  
  public static void a(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    amly localamly = new amly();
    if (paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null) {
      paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramPluginParams, localamly);
      return;
    }
    ((IPluginManager)((QQAppInterface)localAppRuntime).getManager(26)).a(paramContext, paramPluginParams, localamly);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains("空间")) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), "系统可用内存不足，" + paramString2 + "启动失败!", 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + "启动失败!", 0).show();
  }
  
  static void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        RemoteCommand localRemoteCommand = (RemoteCommand)paramList.get(i);
        if ((localRemoteCommand != null) && (!localPluginCommunicationHandler.containsCmd(localRemoteCommand.getCmd()))) {
          localPluginCommunicationHandler.register((RemoteCommand)paramList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public static void b(Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      a(paramPluginParams.jdField_a_of_type_JavaUtilList);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, paramPluginParams.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      }
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
      }
      PluginProxyActivity.openActivityForResult(paramActivity, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_c_of_type_JavaLangString, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_b_of_type_Int);
      if (paramPluginParams.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false))
      {
        paramActivity.overridePendingTransition(2131034134, 2131034135);
        return;
      }
    } while ((paramPluginParams.jdField_a_of_type_AndroidAppDialog == null) || (!(paramPluginParams.jdField_a_of_type_AndroidAppDialog instanceof QzoneProgressDialog)));
    paramActivity.overridePendingTransition(2131034210, 2131034210);
  }
  
  public static void b(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    amlz localamlz = new amlz();
    if (paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null) {
      paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramPluginParams, localamlz);
      return;
    }
    ((IPluginManager)((QQAppInterface)localAppRuntime).getManager(26)).a(paramContext, paramPluginParams, localamlz);
  }
  
  public static void c(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
    {
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_c_of_type_JavaLangString, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent);
  }
  
  private static void c(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new ammb(paramContext, paramPluginParams, paramOnPluginReadyListener));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new ammb(paramContext, paramPluginParams, paramOnPluginReadyListener));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new amlw();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
    {
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    if (paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_c_of_type_JavaLangString, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new amma(paramContext, paramPluginParams), 5, null, false);
  }
  
  private static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) {
      paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(paramPluginParams.jdField_b_of_type_JavaLangString);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (paramOnPluginReadyListener == null);
    paramPluginParams.jdField_c_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(paramPluginParams.jdField_b_of_type_JavaLangString, new amlx(paramOnPluginReadyListener, paramPluginParams, paramContext));
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.IPluginManager
 * JD-Core Version:    0.7.0.1
 */