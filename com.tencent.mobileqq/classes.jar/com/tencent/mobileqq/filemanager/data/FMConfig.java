package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.tem.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AppRuntime;
import org.xml.sax.helpers.DefaultHandler;

public class FMConfig
{
  public static boolean a;
  private static boolean b = false;
  private static boolean c = false;
  private static boolean d = true;
  private static boolean e = true;
  AppRuntime a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public FMConfig(AppRuntime paramAppRuntime, DefaultHandler paramDefaultHandler, long paramLong)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    paramAppRuntime = paramAppRuntime.getApplicationContext().getSharedPreferences("OfflineFileConfigV2", 0).edit();
    paramAppRuntime.clear();
    Object localObject1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMapResultFromPreViewDataHandler(paramDefaultHandler, "OnlinePreView");
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
        paramAppRuntime.putString(("OnlinePreView" + (String)localObject3 + str1).toLowerCase(), str2);
      }
    }
    paramDefaultHandler = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMapResultFromPreViewDataHandler(paramDefaultHandler, "OfflineConfig");
    localObject1 = paramDefaultHandler.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = paramDefaultHandler.get(localObject2);
      if ((localObject3 instanceof HashMap))
      {
        localObject3 = (HashMap)localObject3;
        localObject4 = ((HashMap)localObject3).keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          str1 = String.valueOf(((HashMap)localObject3).get(localObject5));
          paramAppRuntime.putString(("OfflineConfig" + (String)localObject2 + (String)localObject5).toLowerCase(), str1);
        }
      }
      else if ((localObject3 instanceof String))
      {
        paramAppRuntime.putString(("OfflineConfig" + (String)localObject2).toLowerCase(), (String)localObject3);
      }
    }
    paramAppRuntime.putLong("FileOnlinePreviewVersionKey", paramLong);
    long l = MessageCache.a();
    paramAppRuntime.putLong("FMConfigUpdateLastTime", l);
    paramAppRuntime.commit();
    QLog.i("FMConfig<FileAssistant>", 1, "commit Config data, time[" + l + "], ver[" + paramLong + "]");
  }
  
  public static int a()
  {
    int i;
    try
    {
      i = Integer.parseInt(b(BaseApplication.getContext(), "TimAioCount"));
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
    long l1 = Long.parseLong(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHardCodeConfigByFileManagerUtil("OfflineConfigFlowSize"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplication.getContext(), "FlowSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label33:
      break label33;
    }
    return l1 * 1024L + 1L;
  }
  
  public static String a()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = b(BaseApplication.getContext(), "TimGuideUrl");
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
      localObject2 = "https://mma.qq.com/tim/timoffice/office.html";
    }
    return localObject2;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("OfflineFileConfigV2", 0).getString(paramString.toLowerCase(), null);
    if ((paramContext != null) && (paramContext.length() > 0)) {
      return paramContext;
    }
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHardCodeConfigByFileManagerUtil(paramString);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "OnlinePreView", FileUtil.a(paramString1).replace(".", ""), paramString2);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return a(paramContext, paramString1 + paramString2 + paramString3);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong)
  {
    localFile = new File(paramBaseQQAppInterface.getApplicationContext().getFilesDir(), "FileOnlinePreviewConfigV2");
    for (;;)
    {
      try
      {
        if (!HttpDownloadUtil.download(paramBaseQQAppInterface, paramString, localFile)) {
          continue;
        }
        paramString = new DefaultHandler();
      }
      catch (Exception paramBaseQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FMConfig<FileAssistant>", 2, "updateGuide with: " + QLog.getStackTraceString(paramBaseQQAppInterface));
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FMConfig<FileAssistant>", 2, "updateGuide download xml failed: " + paramString);
        continue;
      }
      finally
      {
        localFile.delete();
      }
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(localFile, paramString);
        new FMConfig(paramBaseQQAppInterface, paramString, paramLong);
        localFile.delete();
        return;
      }
      catch (Throwable paramBaseQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FMConfig<FileAssistant>", 2, "updateGuide with: " + QLog.getStackTraceString(paramBaseQQAppInterface));
      }
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).edit().putBoolean("https_c2c_up", paramBoolean).apply();
  }
  
  public static boolean a()
  {
    return b;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).getBoolean("https_c2c_up", false);
  }
  
  public static long b()
  {
    long l1 = Long.parseLong(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHardCodeConfigByFileManagerUtil("OfflineConfigFlowTime"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplication.getContext(), "FlowTime"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    return l1 * 60L;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return a(paramContext, "OfflineConfig", paramString, "");
  }
  
  public static void b(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).edit().putBoolean("https_c2c_down", paramBoolean).apply();
  }
  
  public static boolean b()
  {
    return c;
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).getBoolean("https_c2c_down", false);
  }
  
  public static long c()
  {
    long l1 = Long.parseLong(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHardCodeConfigByFileManagerUtil("OfflineConfigFtnThumbMaxSize"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplication.getContext(), "FtnThumbMaxSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    return l1 * 1024L;
  }
  
  public static void c(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).edit().putBoolean("https_c2czip_down", paramBoolean).apply();
  }
  
  public static boolean c()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131713101), "qqsetting_auto_receive_pic_key", true);
    QLog.i("FMConfig<FileAssistant>", 1, "PreloadThumb switch is[" + bool + "]");
    return bool;
  }
  
  public static boolean c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).getBoolean("https_c2czip_down", false);
  }
  
  public static void d(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).edit().putBoolean("https_c2c_thumb", paramBoolean).apply();
  }
  
  public static boolean d(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).getBoolean("https_c2c_thumb", false);
  }
  
  public static void e(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).edit().putBoolean("https_disc_up", paramBoolean).apply();
  }
  
  public static boolean e(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).getBoolean("https_disc_up", false);
  }
  
  public static void f(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).edit().putBoolean("https_disc_down", paramBoolean).apply();
  }
  
  public static boolean f(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).getBoolean("https_disc_down", false);
  }
  
  public static void g(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).edit().putBoolean("https_disczip_down", paramBoolean).apply();
  }
  
  public static boolean g(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).getBoolean("https_disczip_down", false);
  }
  
  public static void h(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).edit().putBoolean("https_disc_thumb", paramBoolean).apply();
  }
  
  public static boolean h(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getApplicationContext().getSharedPreferences("file_config_" + paramBaseQQAppInterface.getCurrentUin(), 0).getBoolean("https_disc_thumb", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMConfig
 * JD-Core Version:    0.7.0.1
 */