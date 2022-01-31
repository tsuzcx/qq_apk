package cooperation.liveroom;

import android.support.annotation.Nullable;
import bdgk;
import bdin;
import bfiu;
import biqn;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class LiveRoomHelper
{
  private static final String CLS_LIVEROOMAPPINTERFACE = "cooperation.liveroom.LiveRoomInterface";
  private static final String REPORT_HOST = "http://lme.gamefeeds.qq.com/LmeProxyCgi?data=";
  private static final String REPORT_HOST_TEST = "http://gcd.sparta.html5.qq.com/LmeProxyCgi?data=";
  private static final String REPORT_JSON_END = "}}}";
  private static final String REPORT_JSON_START = "{\"module\":\"LME.ReportChannelSvr.ReportChannelObj\",\"method\":\"SdkPluginReport\",\"param\":{\"req\":{\"report\":";
  private static final String TAG = "LiveRoomHelper";
  private static boolean isPluginInstalled;
  public static boolean isSDKLoaded;
  private static LiveRoomInterfaceProxy liveRoomInterfaceProxy;
  private static long opGroutId = NetConnInfoCenter.getServerTimeMillis();
  private static String pluginVersion = "";
  private static JSONArray reportJson = new JSONArray();
  public static long startTime;
  
  public static void cleanStaticParam()
  {
    liveRoomInterfaceProxy = null;
  }
  
  public static AppRuntime createLiveRoomRuntime(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("cooperation.liveroom.LiveRoomInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("LiveRoom", 1, "createLiveRoomRuntime load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "直播SDK");
        paramBaseApplicationImpl = paramString.loadClass("cooperation.liveroom.LiveRoomInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
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
    biqn localbiqn = getPluginManagerInQQ();
    if (localbiqn == null) {
      return null;
    }
    return localbiqn.a("LiveRoomPlugin.apk");
  }
  
  public static boolean getPluginInstalledInTool()
  {
    return isPluginInstalled;
  }
  
  @Nullable
  public static biqn getPluginManagerInQQ()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null)
      {
        QLog.e("LiveRoomHelper", 1, "get AppRuntime fail");
        return null;
      }
      return (biqn)((QQAppInterface)localObject).getManager(27);
    }
  }
  
  public static String getPluginVersionInTool()
  {
    return pluginVersion;
  }
  
  public static boolean isPluginInstalledInQQ()
  {
    boolean bool = true;
    if (isPluginInstalled) {
      return true;
    }
    PluginInfo localPluginInfo = getPluginInfoInQQ();
    if ((localPluginInfo != null) && (localPluginInfo.mState == 4)) {}
    for (;;)
    {
      isPluginInstalled = bool;
      return isPluginInstalled;
      bool = false;
    }
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
      localJSONObject.put("platVersion", AppSetting.f());
      String str = "";
      if ("com.tencent.mobileqq:tool".equals(bfiu.r())) {
        str = getPluginVersionInTool();
      }
      for (;;)
      {
        localJSONObject.put("sdkVersion", str);
        localJSONObject.put("from", paramString1);
        localJSONObject.put("action", paramString2);
        localJSONObject.put("result", paramString3);
        localJSONObject.put("imei", bdgk.a());
        localJSONObject.put("device", bdgk.i());
        localJSONObject.put("uin", BaseApplicationImpl.sApplication.getRuntime().getAccount());
        localJSONObject.put("network", bdin.b(BaseApplicationImpl.getContext()));
        localJSONObject.put("os", bdgk.e());
        reportJson.put(localJSONObject);
        return;
        PluginInfo localPluginInfo = getPluginInfoInQQ();
        if (localPluginInfo != null) {
          str = "" + localPluginInfo.mCurVersion;
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomHelper
 * JD-Core Version:    0.7.0.1
 */