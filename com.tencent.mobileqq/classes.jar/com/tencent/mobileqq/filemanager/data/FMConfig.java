package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.PreViewDataHandler;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class FMConfig
{
  public static boolean a;
  public static boolean b;
  public static boolean c = true;
  QQAppInterface a;
  
  public FMConfig(QQAppInterface paramQQAppInterface, FileManagerUtil.PreViewDataHandler paramPreViewDataHandler, long paramLong)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit();
    paramQQAppInterface.clear();
    Object localObject1 = (HashMap)paramPreViewDataHandler.a().get("OnlinePreView");
    Object localObject2 = ((HashMap)localObject1).keySet().iterator();
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = (HashMap)((HashMap)localObject1).get(localObject3);
      localObject5 = ((HashMap)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        str1 = (String)((Iterator)localObject5).next();
        String str2 = String.valueOf(((HashMap)localObject4).get(str1));
        paramQQAppInterface.putString(("OnlinePreView" + (String)localObject3 + str1).toLowerCase(), str2);
      }
    }
    paramPreViewDataHandler = (HashMap)paramPreViewDataHandler.a().get("OfflineConfig");
    localObject1 = paramPreViewDataHandler.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = paramPreViewDataHandler.get(localObject2);
      if ((localObject3 instanceof HashMap))
      {
        localObject3 = (HashMap)localObject3;
        localObject4 = ((HashMap)localObject3).keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          str1 = String.valueOf(((HashMap)localObject3).get(localObject5));
          paramQQAppInterface.putString(("OfflineConfig" + (String)localObject2 + (String)localObject5).toLowerCase(), str1);
        }
      }
      else if ((localObject3 instanceof String))
      {
        paramQQAppInterface.putString(("OfflineConfig" + (String)localObject2).toLowerCase(), (String)localObject3);
      }
    }
    paramQQAppInterface.putLong("FileOnlinePreviewVersionKey", paramLong);
    long l = MessageCache.a();
    paramQQAppInterface.putLong("FMConfigUpdateLastTime", l);
    paramQQAppInterface.commit();
    QLog.i("FMConfig<FileAssistant>", 1, "commit Config data, time[" + l + "], ver[" + paramLong + "]");
  }
  
  public static int a()
  {
    int i;
    try
    {
      i = Integer.parseInt(b(BaseApplicationImpl.getContext(), "TimAioCount"));
      if ((i != 0) && (TextUtils.isEmpty(a()))) {
        return 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = 0;
      }
    }
    return i;
  }
  
  public static long a()
  {
    long l1 = Long.parseLong(FileManagerUtil.c("OfflineConfigFlowSize"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplicationImpl.getContext(), "FlowSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return l1 * 1024L + 1L;
  }
  
  public static String a()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = b(BaseApplicationImpl.getContext(), "TimGuideUrl");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label14:
      break label14;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "http://mma.qq.com/tim/timoffice/office.html";
    }
    return localObject2;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("OfflineFileConfigV2", 0).getString(paramString.toLowerCase(), null);
    if ((paramContext != null) && (paramContext.length() > 0)) {
      return paramContext;
    }
    return FileManagerUtil.c(paramString);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "OnlinePreView", FileUtil.a(paramString1).replace(".", ""), paramString2);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return a(paramContext, paramString1 + paramString2 + paramString3);
  }
  
  public static boolean a()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131433586), "qqsetting_auto_receive_pic_key", true);
    QLog.i("FMConfig<FileAssistant>", 1, "PreloadThumb switch is[" + bool + "]");
    return bool;
  }
  
  public static int b()
  {
    try
    {
      i = Integer.parseInt(b(BaseApplicationImpl.getContext(), "TimFaCount"));
      int j = i;
      if (i != 0)
      {
        j = i;
        if (TextUtils.isEmpty(b())) {
          j = 0;
        }
      }
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 1;
      }
    }
  }
  
  public static long b()
  {
    long l1 = Long.parseLong(FileManagerUtil.c("OfflineConfigFlowTime"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplicationImpl.getContext(), "FlowTime"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return l1 * 60L;
  }
  
  public static String b()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = b(BaseApplicationImpl.getContext(), "AndroidTimDownUrl");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label14:
      break label14;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "https://eim.connect.qq.com/guide/install.html?install=1";
    }
    return localObject2;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return a(paramContext, "OfflineConfig", paramString, "");
  }
  
  public static int c()
  {
    try
    {
      i = Integer.parseInt(b(BaseApplicationImpl.getContext(), "TimFAViewDayCount"));
      int j = i;
      if (i != 0)
      {
        j = i;
        if (TextUtils.isEmpty(b())) {
          j = 0;
        }
      }
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 1;
      }
    }
  }
  
  public static long c()
  {
    long l1 = Long.parseLong(FileManagerUtil.c("OfflineConfigFtnThumbMaxSize"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplicationImpl.getContext(), "FtnThumbMaxSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return l1 * 1024L;
  }
  
  public static int d()
  {
    try
    {
      i = Integer.parseInt(b(BaseApplicationImpl.getContext(), "TimFAViewTotal"));
      int j = i;
      if (i != 0)
      {
        j = i;
        if (TextUtils.isEmpty(b())) {
          j = 0;
        }
      }
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMConfig
 * JD-Core Version:    0.7.0.1
 */