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
  private static boolean b = false;
  private static boolean c = false;
  private static boolean d = true;
  private static boolean e = true;
  AppRuntime a;
  
  public FMConfig(AppRuntime paramAppRuntime, QQFileManagerUtilImpl.PreViewDataHandler paramPreViewDataHandler, long paramLong)
  {
    this.a = paramAppRuntime;
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
    long l = MessageCache.a();
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
  
  public static int a()
  {
    try
    {
      i = Integer.parseInt(b(BaseApplication.getContext(), "TimAioCount"));
    }
    catch (Exception localException)
    {
      int i;
      label15:
      break label15;
    }
    i = 0;
    if ((i != 0) && (TextUtils.isEmpty(a()))) {
      return 0;
    }
    return i;
  }
  
  public static long a()
  {
    long l1 = Long.parseLong(QQFileManagerUtil.d("OfflineConfigFlowSize"));
    try
    {
      long l2 = Long.parseLong(b(BaseApplication.getContext(), "FlowSize"));
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
    try
    {
      str1 = b(BaseApplication.getContext(), "TimGuideUrl");
    }
    catch (Exception localException)
    {
      String str1;
      label12:
      String str2;
      break label12;
    }
    str1 = "";
    str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = "https://mma.qq.com/tim/timoffice/office.html";
    }
    return str2;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("OfflineFileConfigV2", 0).getString(paramString.toLowerCase(), null);
    if ((paramContext != null) && (paramContext.length() > 0)) {
      return paramContext;
    }
    return QQFileManagerUtilImpl.a(paramString);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "OnlinePreView", QQFileUtil.a(paramString1).replace(".", ""), paramString2);
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
    //   0: new 221	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 224	com/tencent/common/app/business/BaseQQAppInterface:getApplicationContext	()Landroid/content/Context;
    //   8: invokevirtual 228	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: ldc 230
    //   13: invokespecial 233	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload_0
    //   19: aload_1
    //   20: aload 4
    //   22: invokestatic 239	com/tencent/mobileqq/utils/HttpDownloadUtil:download	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/io/File;)Z
    //   25: ifeq +82 -> 107
    //   28: new 49	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$PreViewDataHandler
    //   31: dup
    //   32: invokespecial 240	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$PreViewDataHandler:<init>	()V
    //   35: astore_1
    //   36: invokestatic 246	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   39: invokevirtual 250	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   42: aload 4
    //   44: aload_1
    //   45: invokevirtual 256	javax/xml/parsers/SAXParser:parse	(Ljava/io/File;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   48: new 2	com/tencent/mobileqq/filemanager/data/FMConfig
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: lload_2
    //   55: invokespecial 258	com/tencent/mobileqq/filemanager/data/FMConfig:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl$PreViewDataHandler;J)V
    //   58: pop
    //   59: goto +135 -> 194
    //   62: astore_0
    //   63: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +128 -> 194
    //   69: new 88	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   76: astore_1
    //   77: aload_1
    //   78: ldc_w 263
    //   81: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: aload_0
    //   87: invokestatic 267	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   90: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc 133
    //   96: iconst_2
    //   97: aload_1
    //   98: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: goto +90 -> 194
    //   107: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +84 -> 194
    //   113: new 88	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   120: astore_0
    //   121: aload_0
    //   122: ldc_w 271
    //   125: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_0
    //   130: aload_1
    //   131: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: ldc 133
    //   137: iconst_2
    //   138: aload_0
    //   139: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: goto +49 -> 194
    //   148: astore_0
    //   149: goto +52 -> 201
    //   152: astore_0
    //   153: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +38 -> 194
    //   159: new 88	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   166: astore_1
    //   167: aload_1
    //   168: ldc_w 263
    //   171: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: aload_0
    //   177: invokestatic 267	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   180: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: ldc 133
    //   186: iconst_2
    //   187: aload_1
    //   188: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload 4
    //   196: invokevirtual 274	java/io/File:delete	()Z
    //   199: pop
    //   200: return
    //   201: aload 4
    //   203: invokevirtual 274	java/io/File:delete	()Z
    //   206: pop
    //   207: aload_0
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramBaseQQAppInterface	BaseQQAppInterface
    //   0	209	1	paramString	String
    //   0	209	2	paramLong	long
    //   16	186	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   36	59	62	java/lang/Throwable
    //   18	36	148	finally
    //   36	59	148	finally
    //   63	104	148	finally
    //   107	145	148	finally
    //   153	194	148	finally
    //   18	36	152	java/lang/Exception
    //   36	59	152	java/lang/Exception
    //   63	104	152	java/lang/Exception
    //   107	145	152	java/lang/Exception
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
    return b;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_c2c_up", false);
  }
  
  public static long b()
  {
    long l1 = Long.parseLong(QQFileManagerUtil.d("OfflineConfigFlowTime"));
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
    return c;
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
    long l1 = Long.parseLong(QQFileManagerUtil.d("OfflineConfigFtnThumbMaxSize"));
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
  
  public static void c(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("https_c2czip_down", paramBoolean).apply();
  }
  
  public static boolean c()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131713076), "qqsetting_auto_receive_pic_key", true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreloadThumb switch is[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.i("FMConfig<FileAssistant>", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_c2czip_down", false);
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
  
  public static boolean e(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Context localContext = paramBaseQQAppInterface.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_disc_up", false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMConfig
 * JD-Core Version:    0.7.0.1
 */