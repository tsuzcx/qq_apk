package cooperation.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.RandomUtils;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public abstract class IPluginManager
  extends RemotePluginManager.Stub
  implements Manager
{
  public static long a;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static ConcurrentLinkedQueue<IPluginManager.WaitingCommand> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  public static IPluginManager a(QQAppInterface paramQQAppInterface)
  {
    return new PluginManagerV2(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramContext, paramPluginParams, null);
  }
  
  public static void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnOpenPluginListener paramOnOpenPluginListener)
  {
    if (paramPluginParams.jdField_b_of_type_Int == 1)
    {
      paramPluginParams.jdField_c_of_type_JavaLangString = paramPluginParams.jdField_b_of_type_JavaLangString;
      paramPluginParams.jdField_b_of_type_JavaLangString = PluginIdUtil.convertQShadowId2QPluginId(paramPluginParams.jdField_b_of_type_JavaLangString);
    }
    Object localObject;
    if (paramPluginParams.g != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramPluginParams.g, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    paramOnOpenPluginListener = new IPluginManager.1(paramOnOpenPluginListener);
    if (((paramContext instanceof Activity)) && (paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, paramPluginParams.jdField_a_of_type_AndroidAppDialog, paramPluginParams.jdField_e_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_Boolean, paramPluginParams.jdField_d_of_type_Int).show();
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
      c(paramContext, paramPluginParams, paramOnOpenPluginListener);
      return;
      PreloadProcHitMgr.a(paramPluginParams.jdField_b_of_type_JavaLangString);
    }
    ((IPluginManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN)).a(paramContext, paramPluginParams, paramOnOpenPluginListener);
  }
  
  static void a(IPluginManager.PluginParams paramPluginParams)
  {
    if (Float.compare(RandomUtils.a(0.0F, 1.0F), 0.001F) > 0)
    {
      QLog.e("IPluginManager", 1, "Do not need to report this plugin launch event!");
      return;
    }
    HashMap localHashMap = new HashMap(6);
    localHashMap.put("plugin_id", paramPluginParams.jdField_b_of_type_JavaLangString);
    localHashMap.put("plugin_type", String.valueOf(paramPluginParams.jdField_b_of_type_Int));
    paramPluginParams = paramPluginParams.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo;
    if (paramPluginParams != null)
    {
      localHashMap.put("plugin_version", paramPluginParams.mVersion);
      localHashMap.put("plugin_md5", paramPluginParams.mMD5);
      localHashMap.put("plugin_name", paramPluginParams.mName);
    }
    paramPluginParams = "";
    try
    {
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      paramPluginParams = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("IPluginManager", 1, "getAccount faild ！！！");
      }
    }
    localHashMap.put("qq_num", paramPluginParams);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramPluginParams, "qqPluginLaunchDataReport", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(HardCodeUtil.a(2131705857))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131705859) + paramString2 + HardCodeUtil.a(2131705858), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + HardCodeUtil.a(2131705860), 0).show();
  }
  
  static void a(List<RemoteCommand> paramList)
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
  
  public static void b(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    IPluginManager.4 local4 = new IPluginManager.4();
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null) {
      paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramPluginParams, local4);
      return;
    }
    ((IPluginManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MGR_PLUGIN)).a(paramContext, paramPluginParams, local4);
  }
  
  public static void c(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    IPluginManager.5 local5 = new IPluginManager.5();
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null) {
      paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramPluginParams, local5);
      return;
    }
    ((IPluginManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MGR_PLUGIN)).a(paramContext, paramPluginParams, local5);
  }
  
  private static void c(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) && (System.currentTimeMillis() - jdField_a_of_type_Long < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new IPluginManager.WaitingCommand(paramContext, paramPluginParams, paramOnPluginReadyListener));
      return;
    }
    jdField_a_of_type_Long = 0L;
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new IPluginManager.WaitingCommand(paramContext, paramPluginParams, paramOnPluginReadyListener));
      if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
        jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new IPluginManager.2();
      }
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (paramContext == null) {}
    label258:
    do
    {
      for (;;)
      {
        return;
        a(paramPluginParams.jdField_a_of_type_JavaUtilList);
        a(paramPluginParams);
        if (paramPluginParams.jdField_b_of_type_Int == 1)
        {
          QShadow.getInstance().startActivity(paramPluginParams.jdField_c_of_type_JavaLangString, paramPluginParams.jdField_f_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_AndroidContentIntent.getExtras(), null);
          return;
        }
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.setClass(paramContext, paramPluginParams.jdField_a_of_type_JavaLangClass);
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
        paramPluginParams.a();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, paramPluginParams.jdField_e_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_d_of_type_JavaLangString, paramPluginParams.jdField_f_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_c_of_type_Int);
        }
        while ((paramContext instanceof Activity))
        {
          if (!paramPluginParams.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label258;
          }
          ((Activity)paramContext).overridePendingTransition(2130771999, 2130772003);
          return;
          PluginProxyActivity.openActivity(paramContext, paramPluginParams.jdField_e_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_d_of_type_JavaLangString, paramPluginParams.jdField_f_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_AndroidContentIntent);
        }
      }
      if ((paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && ((paramPluginParams.jdField_a_of_type_AndroidAppDialog instanceof QzoneProgressDialog)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772121, 2130772121);
        return;
      }
    } while ((paramPluginParams.jdField_e_of_type_Int <= 0) || (paramPluginParams.jdField_f_of_type_Int <= 0));
    ((Activity)paramContext).overridePendingTransition(paramPluginParams.jdField_e_of_type_Int, paramPluginParams.jdField_f_of_type_Int);
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
    paramPluginParams.jdField_d_of_type_JavaLangString = localPluginBaseInfo.mInstalledPath;
    paramPluginParams.a(localPluginBaseInfo);
    paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(paramPluginParams.jdField_b_of_type_JavaLangString, new IPluginManager.3(paramOnPluginReadyListener, paramPluginParams, paramContext));
  }
  
  static void e(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    a(paramPluginParams);
    paramPluginParams.a();
    if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
    {
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramPluginParams.jdField_e_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_d_of_type_JavaLangString, paramPluginParams.jdField_f_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_AndroidContentIntent);
  }
  
  static void f(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    a(paramPluginParams);
    paramPluginParams.a();
    if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
    {
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    if (paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, paramPluginParams.jdField_e_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_d_of_type_JavaLangString, paramPluginParams.jdField_f_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, paramPluginParams), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString1, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, String paramString2);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void d(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.IPluginManager
 * JD-Core Version:    0.7.0.1
 */