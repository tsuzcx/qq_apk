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
  public static long a = 0L;
  private static PluginManagerHelper.OnPluginManagerLoadedListener b;
  private static volatile PluginManagerClient c;
  private static ConcurrentLinkedQueue<IPluginManager.WaitingCommand> d = new ConcurrentLinkedQueue();
  
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
    if (paramPluginParams.b == 1)
    {
      paramPluginParams.e = paramPluginParams.d;
      paramPluginParams.d = PluginIdUtil.convertQShadowId2QPluginId(paramPluginParams.d);
    }
    if (paramPluginParams.q != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramPluginParams.q, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    paramPluginParams.v = 0;
    paramPluginParams.j.putExtra("launchTimeStart", System.currentTimeMillis());
    paramOnOpenPluginListener = new IPluginManager.1(paramOnOpenPluginListener);
    if (((paramContext instanceof Activity)) && (paramPluginParams.l != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, paramPluginParams.l, paramPluginParams.g, paramPluginParams.d, paramPluginParams.p, paramPluginParams.r).show();
    }
    if (paramPluginParams.m != null)
    {
      if (TextUtils.equals(paramPluginParams.m.a, paramPluginParams.d))
      {
        paramPluginParams.m.b();
        paramPluginParams.m.e();
      }
    }
    else {
      PreloadProcHitMgr.a(paramPluginParams.d);
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
      if ((!paramString1.contains(HardCodeUtil.a(2131903790))) && (!paramString1.contains("space")))
      {
        paramString1 = BaseApplicationImpl.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(HardCodeUtil.a(2131903793));
        Toast.makeText(paramString1, localStringBuilder.toString(), 0).show();
        return;
      }
      paramString1 = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131903792));
      localStringBuilder.append(paramString2);
      localStringBuilder.append(HardCodeUtil.a(2131903791));
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
    if (paramPluginParams.b == 1)
    {
      paramPluginParams.e = paramPluginParams.d;
      paramPluginParams.d = PluginIdUtil.convertQShadowId2QPluginId(paramPluginParams.d);
    }
    paramPluginParams.v = 2;
    IPluginManager.5 local5 = new IPluginManager.5();
    paramPluginParams.j.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramPluginParams.m != null) {
      paramPluginParams.m.a();
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
    if (paramPluginParams.b == 1)
    {
      paramPluginParams.e = paramPluginParams.d;
      paramPluginParams.d = PluginIdUtil.convertQShadowId2QPluginId(paramPluginParams.d);
    }
    paramPluginParams.v = 1;
    IPluginManager.6 local6 = new IPluginManager.6();
    paramPluginParams.j.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramPluginParams.m != null) {
      paramPluginParams.m.a();
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
    if ((b != null) && (System.currentTimeMillis() - a < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      a = System.currentTimeMillis();
      d.add(new IPluginManager.WaitingCommand(paramContext, paramPluginParams, paramOnPluginReadyListener));
      return;
    }
    a = 0L;
    if ((c != null) && (c.useful()))
    {
      d(paramContext, paramPluginParams, paramOnPluginReadyListener);
      return;
    }
    d.add(new IPluginManager.WaitingCommand(paramContext, paramPluginParams, paramOnPluginReadyListener));
    if (b == null) {
      b = new IPluginManager.3();
    }
    PluginManagerHelper.getPluginInterface(paramContext, b);
  }
  
  static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (paramContext == null) {
      return;
    }
    a(paramPluginParams.u);
    paramPluginParams.j.setClass(paramContext, paramPluginParams.i);
    if (TextUtils.isEmpty(paramPluginParams.j.getStringExtra("uin")))
    {
      paramPluginParams.j.putExtra("uin", paramPluginParams.c);
      paramPluginParams.j.putExtra("qzone_uin", paramPluginParams.c);
    }
    paramPluginParams.j.putExtra("pluginsdk_selfuin", paramPluginParams.c);
    paramPluginParams.j.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
    }
    paramPluginParams.a();
    boolean bool = paramContext instanceof Activity;
    if (bool) {
      PluginProxyActivity.openActivityForResult((Activity)paramContext, paramPluginParams.g, paramPluginParams.d, paramPluginParams.f, paramPluginParams.h, paramPluginParams.j, paramPluginParams.k);
    } else {
      PluginProxyActivity.openActivity(paramContext, paramPluginParams.g, paramPluginParams.d, paramPluginParams.f, paramPluginParams.h, paramPluginParams.j);
    }
    if (bool)
    {
      if (paramPluginParams.j.getBooleanExtra("extra_is_from_p2v_edit", false))
      {
        ((Activity)paramContext).overridePendingTransition(2130772014, 2130772018);
        return;
      }
      if ((paramPluginParams.l != null) && ((paramPluginParams.l instanceof QzoneProgressDialog)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772196, 2130772196);
        return;
      }
      if ((paramPluginParams.s > 0) && (paramPluginParams.t > 0)) {
        ((Activity)paramContext).overridePendingTransition(paramPluginParams.s, paramPluginParams.t);
      }
    }
  }
  
  private static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (c == null)
    {
      paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      return;
    }
    Object localObject = c.queryPlugin(paramPluginParams.d);
    if ((localObject != null) && (((PluginBaseInfo)localObject).mState == 4))
    {
      if (paramOnPluginReadyListener != null)
      {
        paramPluginParams.f = ((PluginBaseInfo)localObject).mInstalledPath;
        paramPluginParams.a((PluginBaseInfo)localObject);
        paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
      }
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doHandleOtherProcess: ");
      ((StringBuilder)localObject).append(c.useful());
      QLog.i("plugin_tag", 4, ((StringBuilder)localObject).toString());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    c.installPlugin(paramPluginParams.d, new IPluginManager.4(paramOnPluginReadyListener, paramPluginParams, paramContext));
  }
  
  static void e(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    ThreadManager.getSubThreadHandler().post(new IPluginManager.7(paramPluginParams, paramContext));
  }
  
  static void f(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.u);
    PluginReporter.a(paramPluginParams, true);
    paramPluginParams.a();
    if ((TextUtils.isEmpty(paramPluginParams.j.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.c)))
    {
      paramPluginParams.j.putExtra("uin", paramPluginParams.c);
      paramPluginParams.j.putExtra("qzone_uin", paramPluginParams.c);
    }
    paramPluginParams.j.putExtra("pluginsdk_selfuin", paramPluginParams.c);
    paramPluginParams.j.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramPluginParams.g, paramPluginParams.d, paramPluginParams.f, paramPluginParams.h, paramPluginParams.j);
  }
  
  static void g(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    ThreadManager.getSubThreadHandler().post(new IPluginManager.8(paramPluginParams, paramContext));
  }
  
  static void h(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.u);
    PluginReporter.a(paramPluginParams, true);
    paramPluginParams.a();
    if ((TextUtils.isEmpty(paramPluginParams.j.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.c)))
    {
      paramPluginParams.j.putExtra("uin", paramPluginParams.c);
      paramPluginParams.j.putExtra("qzone_uin", paramPluginParams.c);
    }
    paramPluginParams.j.putExtra("pluginsdk_selfuin", paramPluginParams.c);
    paramPluginParams.j.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    if (paramPluginParams.o != null)
    {
      PluginProxyService.bindService(paramContext, paramPluginParams.g, paramPluginParams.d, paramPluginParams.f, paramPluginParams.h, paramPluginParams.j, paramPluginParams.o);
      return;
    }
    ThreadManager.post(new IPluginManager.9(paramContext, paramPluginParams), 5, null, false);
  }
  
  public abstract void a();
  
  public abstract void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void a(PluginInfo paramPluginInfo, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract void a(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener);
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString1, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, String paramString2);
  
  public abstract void b();
  
  public abstract void b(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract PluginInfo d(String paramString);
  
  public abstract void e(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager
 * JD-Core Version:    0.7.0.1
 */