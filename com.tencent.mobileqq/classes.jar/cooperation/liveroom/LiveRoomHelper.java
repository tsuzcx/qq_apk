package cooperation.liveroom;

import android.support.annotation.Nullable;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class LiveRoomHelper
{
  private static final String CLS_LIVEROOMAPPINTERFACE = "cooperation.liveroom.LiveRoomInterface";
  private static final String REPORT_HOST = "https://lme.gamefeeds.qq.com/LmeProxyCgi?data=";
  private static final String REPORT_HOST_TEST = "https://gcd.sparta.html5.qq.com/LmeProxyCgi?data=";
  private static final String REPORT_JSON_END = "}}}";
  private static final String REPORT_JSON_START = "{\"module\":\"LME.ReportChannelSvr.ReportChannelObj\",\"method\":\"SdkPluginReport\",\"param\":{\"req\":{\"report\":";
  private static final String TAG = "LiveRoomHelper";
  private static boolean isPluginInstalled;
  public static boolean isSDKLoaded;
  private static LiveRoomInterfaceProxy liveRoomInterfaceProxy = null;
  private static long opGroutId;
  private static String pluginVersion;
  private static JSONArray reportJson = new JSONArray();
  public static long startTime;
  
  static
  {
    opGroutId = NetConnInfoCenter.getServerTimeMillis();
    startTime = 0L;
    isSDKLoaded = false;
    isPluginInstalled = false;
    pluginVersion = "";
  }
  
  public static void cleanStaticParam()
  {
    liveRoomInterfaceProxy = null;
  }
  
  public static AppRuntime createLiveRoomRuntime(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (paramBaseApplicationImpl != null)
    {
      if (paramString == null) {
        return null;
      }
      for (;;)
      {
        try
        {
          try
          {
            paramString = Class.forName("cooperation.liveroom.LiveRoomInterface");
            paramBaseApplicationImpl = paramString;
          }
          catch (Exception paramBaseApplicationImpl) {}catch (NoSuchMethodException paramBaseApplicationImpl) {}catch (InvocationTargetException paramBaseApplicationImpl) {}catch (InstantiationException paramBaseApplicationImpl) {}catch (IllegalAccessException paramBaseApplicationImpl) {}catch (IllegalArgumentException paramBaseApplicationImpl) {}
        }
        catch (ClassNotFoundException paramString)
        {
          continue;
        }
        try
        {
          paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "直播SDK");
          paramBaseApplicationImpl = paramString.loadClass("cooperation.liveroom.LiveRoomInterface");
          BasicClassTypeUtil.setClassLoader(true, paramString);
          if (paramBaseApplicationImpl == null)
          {
            QLog.e("LiveRoom", 1, "createLiveRoomRuntime load class fail");
            return null;
          }
          paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
          if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime))) {
            continue;
          }
          paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
          return paramBaseApplicationImpl;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
      }
      paramBaseApplicationImpl.printStackTrace();
      return null;
      paramBaseApplicationImpl.printStackTrace();
      return null;
      paramBaseApplicationImpl.printStackTrace();
      return null;
      paramBaseApplicationImpl.printStackTrace();
      return null;
      paramBaseApplicationImpl.printStackTrace();
      return null;
      paramBaseApplicationImpl.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static void doReport()
  {
    String str = reportJson.toString();
    if (str.isEmpty()) {
      return;
    }
    opGroutId = NetConnInfoCenter.getServerTimeMillis();
    reportJson = new JSONArray();
    ThreadManager.executeOnNetWorkThread(new LiveRoomHelper.1(str));
  }
  
  public static LiveRoomInterfaceProxy getLiveRoomInterface()
  {
    try
    {
      if (liveRoomInterfaceProxy == null) {
        liveRoomInterfaceProxy = LiveRoomInterfaceProxy.create();
      }
      LiveRoomInterfaceProxy localLiveRoomInterfaceProxy = liveRoomInterfaceProxy;
      return localLiveRoomInterfaceProxy;
    }
    finally {}
  }
  
  @Nullable
  public static PluginInfo getPluginInfoInQQ()
  {
    IPluginManager localIPluginManager = getPluginManagerInQQ();
    if (localIPluginManager == null) {
      return null;
    }
    return localIPluginManager.d("LiveRoomPlugin.apk");
  }
  
  public static boolean getPluginInstalledInTool()
  {
    return isPluginInstalled;
  }
  
  @Nullable
  public static IPluginManager getPluginManagerInQQ()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.e("LiveRoomHelper", 1, "get AppRuntime fail");
      return null;
    }
    return (IPluginManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN);
  }
  
  public static String getPluginVersionInTool()
  {
    return pluginVersion;
  }
  
  public static boolean isPluginInstalledInQQ()
  {
    boolean bool2 = isPluginInstalled;
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    PluginInfo localPluginInfo = getPluginInfoInQQ();
    if ((localPluginInfo == null) || (localPluginInfo.mState != 4)) {
      bool1 = false;
    }
    isPluginInstalled = bool1;
    return isPluginInstalled;
  }
  
  public static void release() {}
  
  public static void report(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opGroupId", opGroutId);
      localJSONObject.put("time", NetConnInfoCenter.getServerTimeMillis());
      localJSONObject.put("cost", paramLong);
      localJSONObject.put("platform", "androidqq");
      localJSONObject.put("platVersion", AppSetting.h());
      boolean bool = "com.tencent.mobileqq:tool".equals(Common.x());
      Object localObject = "";
      if (bool)
      {
        localObject = getPluginVersionInTool();
      }
      else
      {
        PluginInfo localPluginInfo = getPluginInfoInQQ();
        if (localPluginInfo != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(localPluginInfo.mCurVersion);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      localJSONObject.put("sdkVersion", localObject);
      localJSONObject.put("from", paramString1);
      localJSONObject.put("action", paramString2);
      localJSONObject.put("result", paramString3);
      localJSONObject.put("imei", DeviceInfoUtil.b());
      localJSONObject.put("device", DeviceInfoUtil.u());
      localJSONObject.put("uin", BaseApplicationImpl.sApplication.getRuntime().getAccount());
      localJSONObject.put("network", NetworkUtil.getNetworkType(BaseApplicationImpl.getContext()));
      localJSONObject.put("os", DeviceInfoUtil.g());
      reportJson.put(localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.e("LiveRoomHelper", 1, "LiveRoomPlugin report fail");
    }
  }
  
  public static void setPluginInstalledInTool()
  {
    isPluginInstalled = true;
  }
  
  public static void setPluginVersionInTool(String paramString)
  {
    pluginVersion = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomHelper
 * JD-Core Version:    0.7.0.1
 */