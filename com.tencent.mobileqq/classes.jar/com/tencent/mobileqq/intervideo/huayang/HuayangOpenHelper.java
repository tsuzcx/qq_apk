package com.tencent.mobileqq.intervideo.huayang;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
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
      b(paramContext, paramString + ":troophomework");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HuayangOpenHelper", 2, String.format("appType = %s,openType = %s, fromId = %s, uri = %s ，action = %s,pkgName = %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, paramString6 }));
    }
    a(paramQQAppInterface.getApp(), paramString2);
    MonitorConfig.a();
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString6)))
    {
      if (!"slientDownload".equals(paramString5)) {
        break label155;
      }
      Monitor.a("2587808");
      paramString7 = IVPluginInfo.a(paramString7);
      paramString4 = paramString7;
      if (paramString7.size() == 0) {
        paramString4 = IVPluginInfo.a();
      }
      if (!TextUtils.isEmpty(paramString1)) {
        break label254;
      }
      paramString1 = "hy_sixgod";
    }
    label155:
    label254:
    for (;;)
    {
      HuayangDowanloadHelper.a(paramQQAppInterface.getApp(), paramString6, paramString1).a(paramString1, paramQQAppInterface.c(), paramString3, paramString5, paramString4);
      a(paramString2, paramString2);
      return;
      if (!"download".equals(paramString5)) {
        break;
      }
      if (HuayangJsPlugin.a(paramString6))
      {
        Monitor.a("2691701");
        break;
      }
      if (HuayangJsPlugin.b(paramString6))
      {
        Monitor.a("2597718");
        break;
      }
      if (MonitorConfig.jdField_a_of_type_JavaUtilMap.get(paramString1) != null)
      {
        Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.jdField_a_of_type_JavaUtilMap.get(paramString1)).jdField_a_of_type_Int));
        break;
      }
      MonitorConfig.a(paramQQAppInterface);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("HuayangOpenHelper", 2, "没有找到匹配的monitor离线配置文件，重新拉取一次");
      break;
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
    if (paramString == null) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      return;
      while (!paramContext.hasNext())
      {
        do
        {
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while ((paramContext == null) || (paramContext.size() == 0));
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (!paramString.equals(localRunningAppProcessInfo.processName));
    if (QLog.isColorLevel()) {
      QLog.d("HuayangOpenHelper", 2, "杀死进程：" + paramString);
    }
    Process.killProcess(localRunningAppProcessInfo.pid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper
 * JD-Core Version:    0.7.0.1
 */