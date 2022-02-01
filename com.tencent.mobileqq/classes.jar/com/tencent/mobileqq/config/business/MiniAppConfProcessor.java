package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public class MiniAppConfProcessor
  extends IQConfigProcessor<MiniAppConfBean>
{
  public static volatile int a = -1;
  public static volatile int b = -1;
  
  public static int a()
  {
    if (b == -1)
    {
      b = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappfullscreenminedatamaxnum", 50);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniAppUserAppInfoListManager].maxtopnum = ");
      localStringBuilder.append(b);
      QLog.d("MiniAppConfProcessor", 1, localStringBuilder.toString());
    }
    return b;
  }
  
  public static int a(int paramInt)
  {
    paramInt = a("miniapptriggerfullscreenheight", paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTriggerFullScreenHeight, height = ");
    localStringBuilder.append(paramInt);
    QLog.d("MiniAppConfProcessor", 2, localStringBuilder.toString());
    return paramInt;
  }
  
  public static int a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    try
    {
      paramString = paramString.toLowerCase();
      localObject = paramString;
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = paramString;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      localObject = paramString;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = paramString;
      localStringBuilder.append(str);
      localObject = paramString;
      localStringBuilder.append("_");
      localObject = paramString;
      localStringBuilder.append(paramString);
      localObject = paramString;
      int i = Integer.parseInt(localSharedPreferences.getString(localStringBuilder.toString(), String.valueOf(paramInt)));
      paramInt = i;
    }
    catch (Exception paramString)
    {
      QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, error!", paramString);
      paramString = (String)localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMiniAppHighPriorityConfig, secondaryKey: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", Value = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MiniAppConfProcessor", 1, ((StringBuilder)localObject).toString());
    }
    return paramInt;
  }
  
  public static MiniAppConfBean a()
  {
    return (MiniAppConfBean)QConfigManager.a().a(425);
  }
  
  public static String a()
  {
    MiniAppConfBean localMiniAppConfBean = a();
    if (localMiniAppConfBean != null) {
      return localMiniAppConfBean.a();
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    try
    {
      paramString1 = paramString1.toLowerCase();
      localObject = paramString1;
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = paramString1;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      localObject = paramString1;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = paramString1;
      localStringBuilder.append(str);
      localObject = paramString1;
      localStringBuilder.append("_");
      localObject = paramString1;
      localStringBuilder.append(paramString1);
      localObject = paramString1;
      str = localSharedPreferences.getString(localStringBuilder.toString(), paramString2);
      paramString2 = str;
    }
    catch (Exception paramString1)
    {
      QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, error!", paramString1);
      paramString1 = (String)localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMiniAppHighPriorityConfig, secondaryKey: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", Value = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("MiniAppConfProcessor", 1, ((StringBuilder)localObject).toString());
    }
    return paramString2;
  }
  
  public static boolean a()
  {
    Object localObject = a();
    boolean bool;
    if (localObject != null) {
      bool = ((MiniAppConfBean)localObject).a();
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("needShowMiniAppEntry: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("MiniAppConfProcessor", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static int b(int paramInt)
  {
    paramInt = a("pulldownRefreshMinDistance", paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTriggerRefreshMinHeight, height = ");
    localStringBuilder.append(paramInt);
    QLog.d("MiniAppConfProcessor", 2, localStringBuilder.toString());
    return paramInt;
  }
  
  public static String b()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
  }
  
  public static boolean b()
  {
    MiniAppConfBean localMiniAppConfBean = a();
    if (localMiniAppConfBean != null) {
      return localMiniAppConfBean.g();
    }
    return false;
  }
  
  public static String c()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationNickName", "小程序通知");
  }
  
  public static boolean c()
  {
    if (a == -1) {}
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append("miniappshowfullscreen");
      a = localSharedPreferences.getInt(localStringBuilder.toString(), 1);
    }
    catch (Exception localException)
    {
      Object localObject;
      label72:
      break label72;
    }
    a = 1;
    QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. needShowMiniAppFullScreen Exception");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[DesktopDataManager].needShowMiniAppFullScreen, showFullScreen = ");
    ((StringBuilder)localObject).append(a);
    QLog.d("MiniAppConfProcessor", 1, ((StringBuilder)localObject).toString());
    return a == 1;
  }
  
  public static String d()
  {
    String str2 = "QQ小程序";
    String str1 = str2;
    try
    {
      String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      str1 = str2;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      str1 = str2;
      StringBuilder localStringBuilder = new StringBuilder();
      str1 = str2;
      localStringBuilder.append(str3);
      str1 = str2;
      localStringBuilder.append("_");
      str1 = str2;
      localStringBuilder.append("miniappfullscreentitle");
      str1 = str2;
      str2 = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "QQ小程序");
      localObject = str2;
      str1 = str2;
      if (!QLog.isColorLevel()) {
        break label161;
      }
      str1 = str2;
      localObject = new StringBuilder();
      str1 = str2;
      ((StringBuilder)localObject).append("[DesktopDataManager]. desktopTitleConfig title: ");
      str1 = str2;
      ((StringBuilder)localObject).append(str2);
      str1 = str2;
      ((StringBuilder)localObject).append("，uin: ");
      str1 = str2;
      ((StringBuilder)localObject).append(str3);
      str1 = str2;
      QLog.d("MiniAppConfProcessor", 2, ((StringBuilder)localObject).toString());
      return str2;
    }
    catch (Exception localException)
    {
      Object localObject;
      label151:
      label161:
      break label151;
    }
    QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. desktopTitleConfig Exception");
    localObject = str1;
    return localObject;
  }
  
  public static boolean d()
  {
    boolean bool = false;
    if (a("miniappshowreddot", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e()
  {
    boolean bool = false;
    if (a("miniappshowmessagereddot", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f()
  {
    return a("miniappfullscreenshownotificationbtn", 1) == 1;
  }
  
  public static boolean g()
  {
    int i;
    if (a("miniappfullscreenshownotificationreddot", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    return (f()) && (i != 0);
  }
  
  public static boolean h()
  {
    return i() ^ true;
  }
  
  public static boolean i()
  {
    boolean bool = false;
    try
    {
      localObject1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_");
      localStringBuilder.append("miniappfullscreenshowsetting");
      i = ((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 0);
      j = i;
    }
    catch (Exception localException1)
    {
      Object localObject1;
      Object localObject2;
      int i;
      int j;
      label132:
      label134:
      break label132;
    }
    try
    {
      if (!QLog.isColorLevel()) {
        break label144;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[DesktopDataManager]. needShowSettingButton settingValue: ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("，uin: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("MiniAppConfProcessor", 2, ((StringBuilder)localObject2).toString());
      j = i;
    }
    catch (Exception localException2)
    {
      break label134;
    }
    i = 0;
    QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. needShowSettingButton Exception.");
    j = i;
    label144:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[DesktopDataManager].needShowSettingButton, settingValue = ");
    ((StringBuilder)localObject1).append(j);
    QLog.d("MiniAppConfProcessor", 1, ((StringBuilder)localObject1).toString());
    if (j == 1) {
      bool = true;
    }
    return bool;
  }
  
  @NonNull
  public MiniAppConfBean a(int paramInt)
  {
    return new MiniAppConfBean();
  }
  
  @Nullable
  public MiniAppConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new MiniAppConfBean();
      return MiniAppConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(MiniAppConfBean paramMiniAppConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramMiniAppConfBean.toString());
      QLog.d("MiniAppConfProcessor", 2, localStringBuilder.toString());
    }
    paramMiniAppConfBean = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramMiniAppConfBean instanceof QQAppInterface))
    {
      paramMiniAppConfBean = ((QQAppInterface)paramMiniAppConfBean).getBusinessHandler(BusinessHandlerFactory.MINI_APP_ENTRY_HANDLER);
      if (paramMiniAppConfBean != null) {
        paramMiniAppConfBean.notifyUI(0, true, null);
      }
    }
  }
  
  public Class<MiniAppConfBean> clazz()
  {
    return MiniAppConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 425;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MiniAppConfProcessor
 * JD-Core Version:    0.7.0.1
 */