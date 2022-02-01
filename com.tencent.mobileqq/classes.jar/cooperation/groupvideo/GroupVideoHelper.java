package cooperation.groupvideo;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GroupVideoHelper
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
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
            paramString = Class.forName("com.gvideo.com.tencent.av.app.GroupVideoAppInterface");
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
          paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "group_video_plugin.apk");
          paramBaseApplicationImpl = paramString.loadClass("com.gvideo.com.tencent.av.app.GroupVideoAppInterface");
          BasicClassTypeUtil.setClassLoader(true, paramString);
          if (paramBaseApplicationImpl == null)
          {
            QLog.e("GroupVideoLog", 1, "*createGroupVideoAppInterface load class fail");
            return null;
          }
          paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
          if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface))) {
            continue;
          }
          paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
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
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    if (paramAppRuntime != null)
    {
      if (paramServiceConnection == null) {
        return;
      }
      try
      {
        paramAppRuntime.getApplication().unbindService(paramServiceConnection);
        return;
      }
      catch (IllegalArgumentException paramAppRuntime)
      {
        paramServiceConnection = new StringBuilder();
        paramServiceConnection.append("unbindService error");
        paramServiceConnection.append(paramAppRuntime.getMessage());
        QLog.d("GroupVideoHelper", 2, paramServiceConnection.toString());
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Class paramClass, ServiceConnection paramServiceConnection, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (paramServiceConnection == null) {
        return;
      }
      paramClass = new Intent(paramAppRuntime.getApplication(), paramClass);
      paramClass.putExtra("useSkinEngine", 1);
      paramClass.putExtra("userQqResources", 2);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
      localPluginParams.d = "group_video_plugin.apk";
      localPluginParams.g = PluginInfo.k;
      localPluginParams.c = paramAppRuntime.getAccount();
      localPluginParams.h = paramString;
      localPluginParams.j = paramClass;
      localPluginParams.o = paramServiceConnection;
      IPluginManager.c(paramAppRuntime.getApplication(), localPluginParams);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if ("com.tencent.mobileqq:groupvideo".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (paramAppInterface != null)
    {
      if (paramActivity == null) {
        return false;
      }
      if ((paramIntent != null) && (paramIntent.getIntExtra("Type", 0) == 0)) {
        paramIntent.putExtra("isInviteMode", true);
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (!(paramContext instanceof Activity)) {
        return false;
      }
      paramContext = (Activity)paramContext;
      IPluginManager localIPluginManager = (IPluginManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
      if (localIPluginManager == null) {
        return false;
      }
      if (localIPluginManager.isPlugininstalled("group_video_plugin.apk")) {
        return a(paramQQAppInterface, paramContext, paramIntent, paramInt);
      }
      paramContext.startActivityForResult(paramIntent, paramInt);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.groupvideo.GroupVideoHelper
 * JD-Core Version:    0.7.0.1
 */