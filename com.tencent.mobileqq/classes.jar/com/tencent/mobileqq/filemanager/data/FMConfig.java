package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.PreViewDataHandler;
import com.tencent.mobileqq.filemanager.util.QQFileUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;

public class FMConfig
{
  public static boolean a = true;
  private static boolean c = false;
  private static boolean d = false;
  private static boolean e = true;
  private static boolean f = true;
  AppRuntime b;
  
  public FMConfig(AppRuntime paramAppRuntime, QQFileManagerUtilImpl.PreViewDataHandler paramPreViewDataHandler, long paramLong)
  {
    this.b = paramAppRuntime;
    paramAppRuntime = paramAppRuntime.getApplicationContext().getSharedPreferences("OfflineFileConfigV2", 0).edit();
    paramAppRuntime.clear();
    Object localObject1 = (HashMap)paramPreViewDataHandler.a().get("OnlinePreView");
    Object localObject2 = ((HashMap)localObject1).keySet().iterator();
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str;
    Object localObject6;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = (HashMap)((HashMap)localObject1).get(localObject3);
      localObject5 = ((HashMap)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        str = (String)((Iterator)localObject5).next();
        localObject6 = String.valueOf(((HashMap)localObject4).get(str));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnlinePreView");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(str);
        paramAppRuntime.putString(localStringBuilder.toString().toLowerCase(), (String)localObject6);
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
          str = String.valueOf(((HashMap)localObject3).get(localObject5));
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("OfflineConfig");
          ((StringBuilder)localObject6).append((String)localObject2);
          ((StringBuilder)localObject6).append((String)localObject5);
          paramAppRuntime.putString(((StringBuilder)localObject6).toString().toLowerCase(), str);
        }
      }
      else if ((localObject3 instanceof String))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("OfflineConfig");
        ((StringBuilder)localObject4).append((String)localObject2);
        paramAppRuntime.putString(((StringBuilder)localObject4).toString().toLowerCase(), (String)localObject3);
      }
    }
    paramAppRuntime.putLong("FileOnlinePreviewVersionKey", paramLong);
    long l = MessageCache.c();
    paramAppRuntime.putLong("FMConfigUpdateLastTime", l);
    paramAppRuntime.commit();
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("commit Config data, time[");
    paramAppRuntime.append(l);
    paramAppRuntime.append("], ver[");
    paramAppRuntime.append(paramLong);
    paramAppRuntime.append("]");
    QLog.i("FMConfig<FileAssistant>", 1, paramAppRuntime.toString());
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("OfflineFileConfigV2", 0).getString(paramString.toLowerCase(), null);
    if ((paramContext != null) && (paramContext.length() > 0)) {
      return paramContext;
    }
    return QQFileManagerUtilImpl.h(paramString);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "OnlinePreView", QQFileUtil.f(paramString1).replace(".", ""), paramString2);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    return a(paramContext, localStringBuilder.toString());
  }
  
  /* Error */
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 180	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 183	com/tencent/common/app/business/BaseQQAppInterface:getApplicationContext	()Landroid/content/Context;
    //   8: invokevirtual 187	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: ldc 189
    //   13: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload_0
    //   19: aload_1
    //   20: aload 4
    //   22: invokestatic 198	com/tencent/mobileqq/utils/HttpDownloadUtil:download	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/io/File;)Z
    //   25: ifeq +81 -> 106
    //   28: new 50	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$PreViewDataHandler
    //   31: dup
    //   32: invokespecial 199	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$PreViewDataHandler:<init>	()V
    //   35: astore_1
    //   36: invokestatic 205	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   39: invokevirtual 209	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   42: aload 4
    //   44: aload_1
    //   45: invokevirtual 215	javax/xml/parsers/SAXParser:parse	(Ljava/io/File;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   48: new 2	com/tencent/mobileqq/filemanager/data/FMConfig
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: lload_2
    //   55: invokespecial 217	com/tencent/mobileqq/filemanager/data/FMConfig:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$PreViewDataHandler;J)V
    //   58: pop
    //   59: goto +132 -> 191
    //   62: astore_0
    //   63: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +125 -> 191
    //   69: new 89	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   76: astore_1
    //   77: aload_1
    //   78: ldc 222
    //   80: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: aload_0
    //   86: invokestatic 226	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   89: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 134
    //   95: iconst_2
    //   96: aload_1
    //   97: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: goto +88 -> 191
    //   106: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +82 -> 191
    //   112: new 89	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   119: astore_0
    //   120: aload_0
    //   121: ldc 230
    //   123: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_0
    //   128: aload_1
    //   129: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc 134
    //   135: iconst_2
    //   136: aload_0
    //   137: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: goto +48 -> 191
    //   146: astore_0
    //   147: goto +51 -> 198
    //   150: astore_0
    //   151: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +37 -> 191
    //   157: new 89	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   164: astore_1
    //   165: aload_1
    //   166: ldc 222
    //   168: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_1
    //   173: aload_0
    //   174: invokestatic 226	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   177: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 134
    //   183: iconst_2
    //   184: aload_1
    //   185: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload 4
    //   193: invokevirtual 233	java/io/File:delete	()Z
    //   196: pop
    //   197: return
    //   198: aload 4
    //   200: invokevirtual 233	java/io/File:delete	()Z
    //   203: pop
    //   204: aload_0
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramBaseQQAppInterface	BaseQQAppInterface
    //   0	206	1	paramString	String
    //   0	206	2	paramLong	long
    //   16	183	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   36	59	62	java/lang/Throwable
    //   18	36	146	finally
    //   36	59	146	finally
    //   63	103	146	finally
    //   106	143	146	finally
    //   151	191	146	finally
    //   18	36	150	java/lang/Exception
    //   36	59	150	java/lang/Exception
    //   63	103	150	java/lang/Exception
    //   106	143	150	java/lang/Exception
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_c2c_up", paramBoolean).apply();
  }
  
  public static boolean a()
  {
    return c;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_c2c_up", false);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return a(paramContext, "OfflineConfig", paramString, "");
  }
  
  public static void b(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_c2c_down", paramBoolean).apply();
  }
  
  public static boolean b()
  {
    return d;
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_c2c_down", false);
  }
  
  public static long c()
  {
    long l1 = Long.parseLong(QQFileManagerUtil.l("OfflineConfigFlowSize"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplication.getContext(), "FlowSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return l1 * 1024L + 1L;
  }
  
  public static void c(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_c2czip_down", paramBoolean).apply();
  }
  
  public static boolean c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_c2czip_down", false);
  }
  
  public static long d()
  {
    long l1 = Long.parseLong(QQFileManagerUtil.l("OfflineConfigFlowTime"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplication.getContext(), "FlowTime"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return l1 * 60L;
  }
  
  public static void d(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_c2c_thumb", paramBoolean).apply();
  }
  
  public static boolean d(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_c2c_thumb", false);
  }
  
  public static void e(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_disc_up", paramBoolean).apply();
  }
  
  public static boolean e()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131910637), "qqsetting_auto_receive_pic_key", true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreloadThumb switch is[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.i("FMConfig<FileAssistant>", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean e(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_disc_up", false);
  }
  
  public static long f()
  {
    long l1 = Long.parseLong(QQFileManagerUtil.l("OfflineConfigFtnThumbMaxSize"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplication.getContext(), "FtnThumbMaxSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return l1 * 1024L;
  }
  
  public static void f(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_disc_down", paramBoolean).apply();
  }
  
  public static boolean f(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_disc_down", false);
  }
  
  public static int g()
  {
    try
    {
      i = Integer.parseInt(b(BaseApplication.getContext(), "TimAioCount"));
    }
    catch (Exception localException)
    {
      int i;
      label16:
      break label16;
    }
    i = 0;
    if ((i != 0) && (TextUtils.isEmpty(h()))) {
      return 0;
    }
    return i;
  }
  
  public static void g(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_disczip_down", paramBoolean).apply();
  }
  
  public static boolean g(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_disczip_down", false);
  }
  
  public static String h()
  {
    try
    {
      str1 = b(BaseApplication.getContext(), "TimGuideUrl");
    }
    catch (Exception localException)
    {
      String str1;
      label13:
      String str2;
      break label13;
    }
    str1 = "";
    str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = "https://mma.qq.com/tim/timoffice/office.html";
    }
    return str2;
  }
  
  public static void h(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_disc_thumb", paramBoolean).apply();
  }
  
  public static boolean h(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_disc_thumb", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMConfig
 * JD-Core Version:    0.7.0.1
 */