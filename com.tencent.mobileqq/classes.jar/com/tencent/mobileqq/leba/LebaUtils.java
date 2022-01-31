package com.tencent.mobileqq.leba;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.statistics.EXReportController;
import com.tencent.mobileqq.statistics.exreportitem.DC03309ReportItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class LebaUtils
{
  public static int a = 1;
  
  public static int a()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    if ("1000".equals(str)) {
      return 1;
    }
    if ("1103".equals(str)) {
      return 2;
    }
    return 0;
  }
  
  public static int a(int paramInt)
  {
    return b() - 86400 * paramInt;
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, Object paramObject)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("new_leba_sp_name_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if ((paramObject instanceof Boolean)) {
      return Boolean.valueOf(paramQQAppInterface.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
    }
    if ((paramObject instanceof Float)) {
      return Float.valueOf(paramQQAppInterface.getFloat(paramString, ((Float)paramObject).floatValue()));
    }
    if ((paramObject instanceof Integer)) {
      return Integer.valueOf(paramQQAppInterface.getInt(paramString, ((Integer)paramObject).intValue()));
    }
    if ((paramObject instanceof Long)) {
      return Long.valueOf(paramQQAppInterface.getLong(paramString, ((Long)paramObject).longValue()));
    }
    if ((paramObject instanceof String)) {
      return paramQQAppInterface.getString(paramString, (String)paramObject);
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "星期日";
    case 2: 
      return "星期一";
    case 3: 
      return "星期二";
    case 4: 
      return "星期三";
    case 5: 
      return "星期四";
    case 6: 
      return "星期五";
    }
    return "星期六";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = ((LebaGridManager)paramQQAppInterface.getManager(211)).a(paramInt);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.resBigUrl;
    }
    return "";
  }
  
  public static void a()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    if ("1000".equals(str))
    {
      a = 1;
      return;
    }
    if ("1103".equals(str))
    {
      a = 2;
      return;
    }
    a = 3;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, LebaFeedInfo paramLebaFeedInfo, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (paramLebaFeedInfo == null) {
      return;
    }
    DC03309ReportItem localDC03309ReportItem = new DC03309ReportItem();
    localDC03309ReportItem.i = "trends_tab";
    localDC03309ReportItem.j = paramString1;
    localDC03309ReportItem.k = paramString2;
    localDC03309ReportItem.jdField_a_of_type_JavaLangString = String.valueOf(paramLebaFeedInfo.uiResID);
    localDC03309ReportItem.b = String.valueOf(paramLebaFeedInfo.feedID);
    localDC03309ReportItem.c = String.valueOf(paramInt + 1);
    localDC03309ReportItem.jdField_a_of_type_Long = paramLong;
    if (paramLebaFeedInfo.strFeedCookie == null) {}
    for (paramLebaFeedInfo = "";; paramLebaFeedInfo = paramLebaFeedInfo.strFeedCookie)
    {
      localDC03309ReportItem.d = paramLebaFeedInfo;
      EXReportController.b(paramQQAppInterface, localDC03309ReportItem);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, HashMap paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaUtils", 2, "jumpToFeedDetail url=" + paramString + ", params=" + paramHashMap);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      localObject = new StringBuilder();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramHashMap.get(str1);
        if (!TextUtils.isEmpty(str2))
        {
          if (((StringBuilder)localObject).length() != 0) {
            ((StringBuilder)localObject).append("&");
          }
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append("=");
          ((StringBuilder)localObject).append(str2);
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      if (paramString.indexOf('?') >= 0)
      {
        paramHashMap = paramString + "&" + (String)localObject;
        label207:
        paramString = paramHashMap;
        if (QLog.isColorLevel())
        {
          QLog.i("LebaUtils", 2, "jumpToDetail append params=" + (String)localObject + ", url=" + paramHashMap);
          paramString = paramHashMap;
        }
      }
    }
    for (;;)
    {
      if (paramString.startsWith("mqqapi"))
      {
        paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, paramString);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.b();
        return;
        paramHashMap = paramString + "?" + (String)localObject;
        break label207;
      }
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      paramHashMap = paramString;
      if (paramString.indexOf("plg_uin=1") > -1) {
        paramHashMap = paramString + "&mqquin=" + paramQQAppInterface.getCurrentAccountUin();
      }
      paramString = paramHashMap;
      if (paramHashMap.indexOf("plg_vkey=1") > -1) {
        paramString = paramHashMap + "&mqqvkey=" + paramQQAppInterface.b();
      }
      if (paramString.indexOf("plg_nld=1") > -1) {
        ((Intent)localObject).putExtra("reportNld", true);
      }
      ((Intent)localObject).putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject).putExtra("plugin_start_time", System.nanoTime());
      ((Intent)localObject).putExtra("click_start_time", System.currentTimeMillis());
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra("is_from_leba", true);
      ((Intent)localObject).putExtra("url", paramString);
      paramContext.startActivity((Intent)localObject);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Object paramObject)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("new_leba_sp_name_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    if ((paramObject instanceof Boolean)) {
      paramQQAppInterface.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    for (;;)
    {
      paramQQAppInterface.commit();
      return;
      if ((paramObject instanceof Float)) {
        paramQQAppInterface.putFloat(paramString, ((Float)paramObject).floatValue());
      } else if ((paramObject instanceof Integer)) {
        paramQQAppInterface.putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Long)) {
        paramQQAppInterface.putLong(paramString, ((Long)paramObject).longValue());
      } else {
        paramQQAppInterface.putString(paramString, (String)paramObject);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getCallState();
      return (i == 1) || (i == 2);
    }
    catch (Exception paramContext)
    {
      QLog.d("LebaUtils", 1, "isInCall obtain inCall info failed " + paramContext.toString());
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (NearbySPUtil.a(paramString))
    {
      long l3 = ((Long)NearbySPUtil.a(paramString, "nearby_enter_time", Long.valueOf(0L))).longValue();
      long l2 = -1L;
      long l4 = System.currentTimeMillis();
      long l1 = l2;
      if (l3 >= 0L)
      {
        l1 = l2;
        if (l4 >= l3) {
          l1 = l4 - l3;
        }
      }
      if ((l1 >= 0L) && (l1 <= 28800000L)) {
        return true;
      }
    }
    return false;
  }
  
  private static int b()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    return Integer.valueOf(String.valueOf(localCalendar.getTime().getTime() / 1000L)).intValue();
  }
  
  public static int b(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    long l = paramInt;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l * 1000L);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    return Integer.valueOf(String.valueOf(localCalendar.getTime().getTime() / 1000L)).intValue();
  }
  
  public static int c(int paramInt)
  {
    int i = 2131493444;
    switch (paramInt)
    {
    default: 
      return 2131492971;
    case 0: 
      switch (a)
      {
      }
      return 2131492971;
    case 1: 
      switch (a)
      {
      default: 
        i = 2131492971;
      }
      return i;
    case 2: 
      switch (a)
      {
      default: 
        return 2131492971;
      case 1: 
        return 2131493445;
      }
      return 2131493445;
    case 3: 
      paramInt = i;
      switch (a)
      {
      }
      for (paramInt = 2131492971;; paramInt = 2131494267) {
        return paramInt;
      }
    }
    switch (a)
    {
    case 1: 
    default: 
      return 2131492971;
    }
    return 2131494219;
  }
  
  public static int d(int paramInt)
  {
    switch (a)
    {
    }
    return 2130840610;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaUtils
 * JD-Core Version:    0.7.0.1
 */