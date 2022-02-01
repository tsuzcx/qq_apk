package cooperation.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.RandomUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.shadow.dynamic.host.QShadowLoadInfo;
import cooperation.qzone.util.NetworkState;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class PluginReporter
{
  public static void a(IPluginManager.PluginParams paramPluginParams)
  {
    if (Float.compare(RandomUtils.a(0.0F, 1.0F), 0.001F) > 0)
    {
      QLog.e("plugin_tag", 1, "Do not need to report this plugin launch event!");
      return;
    }
    HashMap localHashMap = new HashMap();
    if (a(paramPluginParams, localHashMap)) {
      return;
    }
    paramPluginParams = new StringBuilder();
    paramPluginParams.append("report plugin launched state event: ");
    paramPluginParams.append(localHashMap);
    QLog.i("plugin_tag", 2, paramPluginParams.toString());
    paramPluginParams = (String)localHashMap.get("qq_num");
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramPluginParams, "qqPluginLaunchedDataReport", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(IPluginManager.PluginParams paramPluginParams, QShadowLoadInfo paramQShadowLoadInfo, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramQShadowLoadInfo != null)
    {
      localHashMap.put("plugin_load_runtime", Long.toString(paramQShadowLoadInfo.loadRuntimeTime));
      localHashMap.put("plugin_load_loader", Long.toString(paramQShadowLoadInfo.loadLoaderTime));
      localHashMap.put("plugin_load_plugin", Long.toString(paramQShadowLoadInfo.loadPluginTime));
      localHashMap.put("plugin_load_app", Long.toString(paramQShadowLoadInfo.appCreateTime));
      localHashMap.put("plugin_bind_service", Long.toString(paramQShadowLoadInfo.bindServiceTime));
      localHashMap.put("plugin_is_hot_launch", Boolean.toString(paramQShadowLoadInfo.isHotLaunch));
    }
    localHashMap.put("plugin_inner_launch", "true");
    a(paramPluginParams, localHashMap, paramBoolean);
  }
  
  private static void a(IPluginManager.PluginParams paramPluginParams, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (Float.compare(RandomUtils.a(0.0F, 1.0F), 0.001F) > 0)
    {
      QLog.e("plugin_tag", 1, "Do not need to report this plugin launch event!");
      return;
    }
    if (paramPluginParams == null)
    {
      QLog.e("plugin_tag", 1, "params is null, do not report this event!");
      return;
    }
    HashMap localHashMap = new HashMap();
    if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
      localHashMap.putAll(paramHashMap);
    }
    if (!a(paramPluginParams, localHashMap)) {
      return;
    }
    localHashMap.put("plugin_result", Boolean.toString(paramBoolean));
    localHashMap.put("plugin_launch_type", String.valueOf(paramPluginParams.g));
    paramPluginParams = new StringBuilder();
    paramPluginParams.append("report plugin launch event: ");
    paramPluginParams.append(localHashMap);
    QLog.i("plugin_tag", 2, paramPluginParams.toString());
    paramPluginParams = (String)localHashMap.get("qq_num");
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramPluginParams, "qqPluginLaunchDataReport", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(IPluginManager.PluginParams paramPluginParams, boolean paramBoolean)
  {
    a(paramPluginParams, null, paramBoolean);
  }
  
  private static boolean a(IPluginManager.PluginParams paramPluginParams, HashMap<String, String> paramHashMap)
  {
    try
    {
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label15:
      long l;
      break label15;
    }
    QLog.e("plugin_tag", 1, "getAccount failed ！！！");
    localObject = "";
    paramHashMap.put("qq_num", localObject);
    localObject = paramPluginParams.a;
    if (localObject == null)
    {
      QLog.e("plugin_tag", 1, "plugin info is null!");
      return false;
    }
    paramHashMap.put("plugin_id", ((PluginBaseInfo)localObject).mID);
    paramHashMap.put("plugin_type", String.valueOf(((PluginBaseInfo)localObject).mSubType));
    paramHashMap.put("plugin_version", ((PluginBaseInfo)localObject).mVersion);
    paramHashMap.put("plugin_md5", ((PluginBaseInfo)localObject).mMD5);
    paramHashMap.put("plugin_name", ((PluginBaseInfo)localObject).mName);
    paramHashMap.put("plugin_state", String.valueOf(((PluginBaseInfo)localObject).mState));
    paramHashMap.put("plugin_download_duration", String.valueOf(((PluginBaseInfo)localObject).downloadDuration));
    paramHashMap.put("plugin_start_network_type", String.valueOf(((PluginBaseInfo)localObject).startDownloadNetType));
    paramHashMap.put("plugin_network_type", String.valueOf(NetworkState.getNetworkType()));
    paramHashMap.put("plugin_low_device", Boolean.toString(DeviceInfoUtils.b()));
    paramHashMap.put("plugin_is_foreground", Boolean.toString(Foreground.isCurrentProcessForeground()));
    paramHashMap.put("plugin_process", Arrays.toString(((PluginBaseInfo)localObject).mProcesses));
    paramHashMap.put("plugin_process_running", Boolean.toString(a(((PluginBaseInfo)localObject).mProcesses)));
    paramHashMap.put("plugin_install_code", Integer.toString(((PluginBaseInfo)localObject).installCode));
    if (((PluginBaseInfo)localObject).mSubType == 1) {
      l = ((PluginBaseInfo)localObject).costDex2Oat;
    } else {
      l = ((PluginBaseInfo)localObject).costDex2Oat + ((PluginBaseInfo)localObject).costApk + ((PluginBaseInfo)localObject).costLib;
    }
    paramHashMap.put("plugin_install_duration", Long.toString(l));
    paramPluginParams.a();
    return true;
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      Object localObject = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getRunningAppProcesses();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (TextUtils.equals(paramArrayOfString[i], localRunningAppProcessInfo.processName)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginReporter
 * JD-Core Version:    0.7.0.1
 */