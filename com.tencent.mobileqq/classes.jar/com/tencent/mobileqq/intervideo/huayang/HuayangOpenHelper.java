package com.tencent.mobileqq.intervideo.huayang;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HuayangOpenHelper
{
  public static String a;
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramString != null) && (!paramString.equals(a)))
    {
      Monitor.a("2490051");
      a = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("HuayangOpenHelper", 2, "请求启动的类型与最近一次启动的类型不同，先杀死 :troophomework进程！");
      }
      paramString = paramContext.getPackageName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(":troophomework");
      b(paramContext, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(":troophomework");
      c(paramContext, localStringBuilder.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HuayangOpenHelper", 2, String.format("appType = %s,openType = %s, fromId = %s, uri = %s ，action = %s,pkgName = %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, paramString6 }));
    }
    MonitorConfig.a(paramQQAppInterface.getApp(), paramString1);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString6)))
    {
      if ("slientDownload".equals(paramString5)) {
        Monitor.a("2587808");
      } else if ("download".equals(paramString5)) {
        if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(paramString6)) {
          Monitor.a("2691701");
        } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(paramString6)) {
          Monitor.a("2597718");
        } else {
          MonitorConfig.b(paramQQAppInterface.getApp(), paramString1);
        }
      }
      paramString7 = IVPluginInfo.a(paramString7);
      paramString4 = paramString7;
      if (paramString7.size() == 0) {
        paramString4 = IVPluginInfo.a();
      }
      paramString7 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramString7 = "hy_sixgod";
      }
      ThreadManagerV2.executeOnSubThread(new HuayangOpenHelper.1(paramString7, HuayangDowanloadHelperUtil.a(paramQQAppInterface.getApp(), paramString6, paramString7), paramQQAppInterface, paramString3, paramString5, paramString4));
      a(paramString2, paramString2);
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "HyProxy";
    }
    StoryReportor.a("huayang", "openHy", 0, 0, new String[] { str, paramString2 });
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      if (paramContext.size() == 0) {
        return;
      }
      Object localObject = paramContext.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (paramString.equals(paramContext.processName))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("杀死进程：");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("HuayangOpenHelper", 2, ((StringBuilder)localObject).toString());
          }
          Process.killProcess(paramContext.pid);
        }
      }
    }
  }
  
  private static void c(Context paramContext, String paramString)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    int i;
    do
    {
      Object localObject = paramContext.getRunningAppProcesses();
      if (localObject == null) {
        break;
      }
      if (((List)localObject).size() == 0) {
        return;
      }
      int j = 0;
      localObject = ((List)localObject).iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName));
      i = 1;
    } while (i != 0);
    if (QLog.isColorLevel()) {
      QLog.d("HuayangOpenHelper", 2, "waitKillProcess done");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper
 * JD-Core Version:    0.7.0.1
 */