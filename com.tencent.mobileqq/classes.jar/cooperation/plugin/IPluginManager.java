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
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

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
    if (paramPluginParams == null)
    {
      QLog.e("plugin_tag", 1, "openActivityForResult, pp is null");
      return;
    }
    if (paramPluginParams.jdField_b_of_type_Int == 1)
    {
      paramPluginParams.jdField_c_of_type_JavaLangString = paramPluginParams.jdField_b_of_type_JavaLangString;
      paramPluginParams.jdField_b_of_type_JavaLangString = PluginIdUtil.convertQShadowId2QPluginId(paramPluginParams.jdField_b_of_type_JavaLangString);
    }
    if (paramPluginParams.jdField_g_of_type_JavaLangString != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramPluginParams.jdField_g_of_type_JavaLangString, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    paramPluginParams.jdField_g_of_type_Int = 0;
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    paramOnOpenPluginListener = new IPluginManager.1(paramOnOpenPluginListener);
    if (((paramContext instanceof Activity)) && (paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, paramPluginParams.jdField_a_of_type_AndroidAppDialog, paramPluginParams.jdField_e_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_Boolean, paramPluginParams.jdField_d_of_type_Int).show();
    }
    if (paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null)
    {
      if (TextUtils.equals(paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.jdField_a_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString))
      {
        paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.b();
        paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.d();
      }
    }
    else {
      PreloadProcHitMgr.a(paramPluginParams.jdField_b_of_type_JavaLangString);
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      c(paramContext, paramPluginParams, paramOnOpenPluginListener);
      return;
    }
    ((IPluginManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN)).a(paramContext, paramPluginParams, paramOnOpenPluginListener);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((!paramString1.contains(HardCodeUtil.a(2131705909))) && (!paramString1.contains("space")))
      {
        paramString1 = BaseApplicationImpl.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(HardCodeUtil.a(2131705912));
        Toast.makeText(paramString1, localStringBuilder.toString(), 0).show();
        return;
      }
      paramString1 = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131705911));
      localStringBuilder.append(paramString2);
      localStringBuilder.append(HardCodeUtil.a(2131705910));
      Toast.makeText(paramString1, localStringBuilder.toString(), 0).show();
    }
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
    if (paramPluginParams == null)
    {
      QLog.e("plugin_tag", 1, "launchPluginBroadcast, pp is null");
      return;
    }
    if (paramPluginParams.jdField_b_of_type_Int == 1)
    {
      paramPluginParams.jdField_c_of_type_JavaLangString = paramPluginParams.jdField_b_of_type_JavaLangString;
      paramPluginParams.jdField_b_of_type_JavaLangString = PluginIdUtil.convertQShadowId2QPluginId(paramPluginParams.jdField_b_of_type_JavaLangString);
    }
    paramPluginParams.jdField_g_of_type_Int = 2;
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
  
  static void b(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnOpenPluginListener paramOnOpenPluginListener)
  {
    ThreadManager.getSubThreadHandler().post(new IPluginManager.2(paramPluginParams, paramContext, paramOnOpenPluginListener));
  }
  
  public static void c(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (paramPluginParams == null)
    {
      QLog.e("plugin_tag", 1, "launchPluginService, pp is null");
      return;
    }
    if (paramPluginParams.jdField_b_of_type_Int == 1)
    {
      paramPluginParams.jdField_c_of_type_JavaLangString = paramPluginParams.jdField_b_of_type_JavaLangString;
      paramPluginParams.jdField_b_of_type_JavaLangString = PluginIdUtil.convertQShadowId2QPluginId(paramPluginParams.jdField_b_of_type_JavaLangString);
    }
    paramPluginParams.jdField_g_of_type_Int = 1;
    IPluginManager.6 local6 = new IPluginManager.6();
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null) {
      paramPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.a();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramContext, paramPluginParams, local6);
      return;
    }
    ((IPluginManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MGR_PLUGIN)).a(paramContext, paramPluginParams, local6);
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
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient != null) && (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      d(paramContext, paramPluginParams, paramOnPluginReadyListener);
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new IPluginManager.WaitingCommand(paramContext, paramPluginParams, paramOnPluginReadyListener));
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener == null) {
      jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new IPluginManager.3();
    }
    PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
  }
  
  static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (paramContext == null) {
      return;
    }
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
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
    boolean bool = paramContext instanceof Activity;
    if (bool) {
      PluginProxyActivity.openActivityForResult((Activity)paramContext, paramPluginParams.jdField_e_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_d_of_type_JavaLangString, paramPluginParams.jdField_f_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_c_of_type_Int);
    } else {
      PluginProxyActivity.openActivity(paramContext, paramPluginParams.jdField_e_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_d_of_type_JavaLangString, paramPluginParams.jdField_f_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_AndroidContentIntent);
    }
    if (bool)
    {
      if (paramPluginParams.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_from_p2v_edit", false))
      {
        ((Activity)paramContext).overridePendingTransition(2130772011, 2130772015);
        return;
      }
      if ((paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && ((paramPluginParams.jdField_a_of_type_AndroidAppDialog instanceof QzoneProgressDialog)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772147, 2130772147);
        return;
      }
      if ((paramPluginParams.jdField_e_of_type_Int > 0) && (paramPluginParams.jdField_f_of_type_Int > 0)) {
        ((Activity)paramContext).overridePendingTransition(paramPluginParams.jdField_e_of_type_Int, paramPluginParams.jdField_f_of_type_Int);
      }
    }
  }
  
  private static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null)
    {
      paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      return;
    }
    Object localObject = jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(paramPluginParams.jdField_b_of_type_JavaLangString);
    if ((localObject != null) && (((PluginBaseInfo)localObject).mState == 4))
    {
      if (paramOnPluginReadyListener != null)
      {
        paramPluginParams.jdField_d_of_type_JavaLangString = ((PluginBaseInfo)localObject).mInstalledPath;
        paramPluginParams.a((PluginBaseInfo)localObject);
        paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
      }
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doHandleOtherProcess: ");
      ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful());
      QLog.i("plugin_tag", 4, ((StringBuilder)localObject).toString());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(paramPluginParams.jdField_b_of_type_JavaLangString, new IPluginManager.4(paramOnPluginReadyListener, paramPluginParams, paramContext));
  }
  
  static void e(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    ThreadManager.getSubThreadHandler().post(new IPluginManager.7(paramPluginParams, paramContext));
  }
  
  static void f(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    PluginReporter.a(paramPluginParams, true);
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
  
  static void g(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    ThreadManager.getSubThreadHandler().post(new IPluginManager.8(paramPluginParams, paramContext));
  }
  
  static void h(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    PluginReporter.a(paramPluginParams, true);
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
    ThreadManager.post(new IPluginManager.9(paramContext, paramPluginParams), 5, null, false);
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void a(PluginInfo paramPluginInfo, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void a(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString1, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, String paramString2);
  
  public abstract void b();
  
  public abstract void b(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void d(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.IPluginManager
 * JD-Core Version:    0.7.0.1
 */