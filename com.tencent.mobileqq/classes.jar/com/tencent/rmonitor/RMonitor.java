package com.tencent.rmonitor;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.rmonitor.base.plugin.monitor.QAPMScenePlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.RMonitorUtil;
import com.tencent.rmonitor.property.IPropertySetter;
import com.tencent.rmonitor.property.IPropertyUpdater;
import com.tencent.rmonitor.property.IStringPropertySetter;
import com.tencent.rmonitor.property.PropertyMng;
import com.tencent.rmonitor.sla.SLAHelper;

public class RMonitor
  implements RMonitorConstants
{
  private static final String TAG = "RMonitor";
  private static int userMode;
  
  public static void abolish()
  {
    if (!isInitOk())
    {
      Logger.b.e(new String[] { "RMonitor", "abolish fail for ", RMonitorUtil.b() });
      return;
    }
    Logger.b.i(new String[] { "RMonitor", "abolish" });
    Magnifier.a();
  }
  
  public static boolean addProperty(int paramInt, Object paramObject)
  {
    IPropertyUpdater localIPropertyUpdater = PropertyMng.a().c(paramInt);
    boolean bool;
    if (localIPropertyUpdater != null)
    {
      bool = localIPropertyUpdater.a(paramObject);
    }
    else
    {
      logIllegalProperty("addProperty", paramInt, paramObject);
      bool = false;
    }
    logUpdateProperty("addProperty", paramInt, paramObject, bool);
    SLAHelper.a().b();
    return bool;
  }
  
  public static boolean beginScene(String paramString, int paramInt)
  {
    return beginScene(paramString, "", paramInt);
  }
  
  public static boolean beginScene(String paramString1, @Nullable String paramString2, int paramInt)
  {
    if (!isInitOk())
    {
      paramString2 = Logger.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("beginScene sceneName[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("] fail for ");
      paramString2.e(new String[] { "RMonitor", ((StringBuilder)localObject).toString(), RMonitorUtil.b() });
      return false;
    }
    Logger.b.i(new String[] { "RMonitor", String.format("beginScene, sceneName: %s, extraInfo: %s, mode: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }) });
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    if (isSceneMonitorPlugin(paramInt))
    {
      paramString2 = Magnifier.b(paramInt);
      if ((paramString2 instanceof QAPMScenePlugin))
      {
        ((QAPMScenePlugin)paramString2).beginScene(paramString1, (String)localObject);
        return true;
      }
      paramString1 = Logger.b;
      paramString2 = new StringBuilder();
      paramString2.append("beginScene, can not find plugin mode[");
      paramString2.append(paramInt);
      paramString2.append("]");
      paramString1.e(new String[] { "RMonitor", paramString2.toString() });
      return true;
    }
    startMonitors(paramInt);
    return true;
  }
  
  public static boolean endScene(String paramString, int paramInt)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("RMONITOR_APP_LAUNCH"))) {
      str = "RMONITOR_APP_LAUNCH_END";
    } else {
      str = "";
    }
    return endScene(paramString, str, paramInt);
  }
  
  public static boolean endScene(String paramString1, @Nullable String paramString2, int paramInt)
  {
    if (!isInitOk())
    {
      paramString2 = Logger.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endScene sceneName[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("] fail for ");
      paramString2.e(new String[] { "RMonitor", ((StringBuilder)localObject).toString(), RMonitorUtil.b() });
      return false;
    }
    Logger.b.i(new String[] { "RMonitor", String.format("endScene, sceneName: %s, extraInfo: %s, mode: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }) });
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    if (isSceneMonitorPlugin(paramInt))
    {
      paramString2 = Magnifier.b(paramInt);
      if ((paramString2 instanceof QAPMScenePlugin))
      {
        ((QAPMScenePlugin)paramString2).endScene(paramString1, (String)localObject);
        return true;
      }
      paramString1 = Logger.b;
      paramString2 = new StringBuilder();
      paramString2.append("endScene, can not find plugin mode[");
      paramString2.append(paramInt);
      paramString2.append("]");
      paramString1.e(new String[] { "RMonitor", paramString2.toString() });
      return true;
    }
    stopMonitors(paramInt);
    return true;
  }
  
  public static boolean isInitOk()
  {
    return RMonitorUtil.a();
  }
  
  private static boolean isSceneMonitorPlugin(int paramInt)
  {
    return (paramInt == 512) || (paramInt == 8);
  }
  
  private static void logIllegalProperty(String paramString, int paramInt, Object paramObject)
  {
    Logger localLogger = Logger.b;
    if (paramObject == null) {
      paramObject = "null";
    } else {
      paramObject = paramObject.toString();
    }
    localLogger.w(new String[] { "RMonitor", paramString, ", invalid property, key = ", String.valueOf(paramInt), ", value = ", paramObject });
  }
  
  private static void logUpdateProperty(String paramString, int paramInt, Object paramObject, boolean paramBoolean)
  {
    Logger localLogger = Logger.b;
    if (paramObject == null) {
      paramObject = "null";
    } else {
      paramObject = paramObject.toString();
    }
    localLogger.i(new String[] { "RMonitor", paramString, ", key = ", String.valueOf(paramInt), ", value = ", paramObject, ", ret = ", String.valueOf(paramBoolean) });
  }
  
  public static boolean removeProperty(int paramInt, Object paramObject)
  {
    IPropertyUpdater localIPropertyUpdater = PropertyMng.a().c(paramInt);
    boolean bool;
    if (localIPropertyUpdater != null)
    {
      bool = localIPropertyUpdater.b(paramObject);
    }
    else
    {
      logIllegalProperty("removeProperty", paramInt, paramObject);
      bool = false;
    }
    logUpdateProperty("removeProperty", paramInt, paramObject, bool);
    return bool;
  }
  
  public static boolean setProperty(int paramInt, @Nullable Object paramObject)
  {
    IPropertySetter localIPropertySetter = PropertyMng.a().b(paramInt);
    boolean bool;
    if (localIPropertySetter != null)
    {
      bool = localIPropertySetter.a(paramObject);
    }
    else
    {
      logIllegalProperty("setProperty", paramInt, paramObject);
      bool = false;
    }
    logUpdateProperty("setProperty", paramInt, paramObject, bool);
    SLAHelper.a().b();
    return bool;
  }
  
  public static boolean setProperty(int paramInt, String paramString)
  {
    IStringPropertySetter localIStringPropertySetter = PropertyMng.a().a(paramInt);
    boolean bool1;
    if (localIStringPropertySetter != null)
    {
      boolean bool2 = localIStringPropertySetter.a(paramString);
      bool1 = bool2;
      if (paramInt == 102)
      {
        bool1 = bool2;
        if (bool2)
        {
          int i = userMode;
          bool1 = bool2;
          if (i != 0)
          {
            Magnifier.a(i, true);
            bool1 = bool2;
          }
        }
      }
    }
    else
    {
      logIllegalProperty("setProperty", paramInt, paramString);
      bool1 = false;
    }
    logUpdateProperty("setProperty", paramInt, paramString, bool1);
    SLAHelper.a().b();
    return bool1;
  }
  
  public static void startMonitors(int paramInt)
  {
    if (!isInitOk())
    {
      Logger.b.e(new String[] { "RMonitor", "startMonitors fail for ", RMonitorUtil.b() });
      return;
    }
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMonitors, mode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", userMode: ");
    localStringBuilder.append(userMode);
    localLogger.i(new String[] { "RMonitor", localStringBuilder.toString() });
    Magnifier.a(paramInt, false);
    userMode = paramInt | userMode;
  }
  
  public static void stopMonitors(int paramInt)
  {
    if (!isInitOk())
    {
      Logger.b.e(new String[] { "RMonitor", "stopMonitors fail for ", RMonitorUtil.b() });
      return;
    }
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopMonitors, mode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", userMode: ");
    localStringBuilder.append(userMode);
    localLogger.i(new String[] { "RMonitor", localStringBuilder.toString() });
    Magnifier.a(paramInt);
    userMode = (paramInt ^ 0xFFFFFFFF) & userMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.RMonitor
 * JD-Core Version:    0.7.0.1
 */