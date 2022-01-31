package com.tencent.mobileqq.startup.step;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Process;
import android.text.TextUtils;
import azkd;
import azke;
import azmz;
import bimg;
import bimy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class InstallPlugins
  extends Step
{
  public static azkd a;
  public static azke a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "qzone_plugin.apk", "qwallet_plugin.apk" };
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_Azkd != null)
      {
        Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject1 = ((AppRuntime)localObject1).getAccount();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            azmz.a(BaseApplicationImpl.getApplication()).a((String)localObject1, "qzonePrePluginInstall", jdField_a_of_type_Azkd.jdField_a_of_type_Boolean, jdField_a_of_type_Azkd.jdField_a_of_type_Long, 0L, null, null);
          }
          QLog.i("plugin_tag.InstallPlugins", 1, "install qzone:" + jdField_a_of_type_Azkd.jdField_a_of_type_Boolean + ",cost:" + jdField_a_of_type_Azkd.jdField_a_of_type_Long);
        }
        jdField_a_of_type_Azkd = null;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 95	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Azke	Lazke;
    //   6: ifnull +129 -> 135
    //   9: invokestatic 30	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   12: invokevirtual 34	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +114 -> 131
    //   20: aload_2
    //   21: invokevirtual 40	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +102 -> 131
    //   32: new 97	java/util/HashMap
    //   35: dup
    //   36: invokespecial 98	java/util/HashMap:<init>	()V
    //   39: astore_3
    //   40: aload_3
    //   41: ldc 100
    //   43: getstatic 95	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Azke	Lazke;
    //   46: getfield 105	azke:jdField_a_of_type_Int	I
    //   49: invokestatic 109	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 113	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload_3
    //   57: ldc 115
    //   59: iload_0
    //   60: invokestatic 109	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   63: invokevirtual 113	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: invokestatic 30	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   70: invokestatic 51	azmz:a	(Landroid/content/Context;)Lazmz;
    //   73: astore 4
    //   75: new 68	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   82: getstatic 95	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Azke	Lazke;
    //   85: getfield 118	azke:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 120
    //   93: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 5
    //   101: getstatic 95	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Azke	Lazke;
    //   104: getfield 105	azke:jdField_a_of_type_Int	I
    //   107: ifne +32 -> 139
    //   110: iconst_1
    //   111: istore_1
    //   112: aload 4
    //   114: aload_2
    //   115: aload 5
    //   117: iload_1
    //   118: getstatic 95	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Azke	Lazke;
    //   121: getfield 123	azke:b	I
    //   124: i2l
    //   125: lconst_0
    //   126: aload_3
    //   127: aconst_null
    //   128: invokevirtual 64	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   131: aconst_null
    //   132: putstatic 95	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Azke	Lazke;
    //   135: ldc 2
    //   137: monitorexit
    //   138: return
    //   139: iconst_0
    //   140: istore_1
    //   141: goto -29 -> 112
    //   144: astore_2
    //   145: ldc 2
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramInt	int
    //   111	30	1	bool	boolean
    //   15	100	2	localObject1	Object
    //   144	5	2	localObject2	Object
    //   39	88	3	localHashMap	java.util.HashMap
    //   73	40	4	localazmz	azmz
    //   99	17	5	str	String
    // Exception table:
    //   from	to	target	type
    //   3	16	144	finally
    //   20	110	144	finally
    //   112	131	144	finally
    //   131	135	144	finally
  }
  
  private static void a(String paramString)
  {
    try
    {
      File localFile1 = PluginUtils.getPluginInstallDir(BaseApplicationImpl.sApplication);
      File localFile2 = new File(localFile1, paramString);
      if (localFile2.exists()) {
        localFile2.delete();
      }
      bimy.a(paramString, localFile1);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("plugin_tag.InstallPlugins", 1, "", paramString);
      }
    }
    QLog.d("plugin_tag.InstallPlugins", 1, "uninstallPlugin");
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (TextUtils.equals(arrayOfString[i], paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 130	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: astore 5
    //   5: new 138	java/io/File
    //   8: dup
    //   9: aload 5
    //   11: invokestatic 136	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   14: aload_0
    //   15: invokespecial 141	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload 6
    //   22: invokevirtual 145	java/io/File:exists	()Z
    //   25: ifeq +22 -> 47
    //   28: ldc 16
    //   30: aload_0
    //   31: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +13 -> 47
    //   37: ldc 66
    //   39: iconst_1
    //   40: ldc 175
    //   42: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: iconst_1
    //   46: ireturn
    //   47: aload_0
    //   48: invokestatic 181	com/tencent/mobileqq/pluginsdk/PluginStatic:getClassLoader	(Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   51: ifnull +13 -> 64
    //   54: ldc 66
    //   56: iconst_1
    //   57: ldc 183
    //   59: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: iconst_1
    //   63: ireturn
    //   64: aload_0
    //   65: invokestatic 185	com/tencent/mobileqq/startup/step/InstallPlugins:a	(Ljava/lang/String;)V
    //   68: aconst_null
    //   69: astore_3
    //   70: aload 5
    //   72: aload_0
    //   73: aload 6
    //   75: invokestatic 189	com/tencent/mobileqq/pluginsdk/PluginUtils:extractPluginAndGetMd5Code	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Ljava/lang/String;
    //   78: astore 4
    //   80: aload 4
    //   82: astore_3
    //   83: aload_3
    //   84: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +260 -> 347
    //   90: aload 5
    //   92: aload_0
    //   93: invokestatic 193	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   96: invokevirtual 196	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload 6
    //   103: invokevirtual 196	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   106: aload 4
    //   108: invokestatic 200	com/tencent/mobileqq/pluginsdk/PluginUtils:extractLibs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 4
    //   113: ldc 66
    //   115: iconst_1
    //   116: new 68	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   123: ldc 202
    //   125: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload 4
    //   130: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload 4
    //   141: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifeq +203 -> 347
    //   147: aload_0
    //   148: aload 6
    //   150: invokevirtual 205	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   153: invokestatic 209	bina:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   156: ifeq +191 -> 347
    //   159: aload 5
    //   161: aload_0
    //   162: invokestatic 213	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   165: astore 4
    //   167: aload 4
    //   169: aload_1
    //   170: invokevirtual 219	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   173: astore 4
    //   175: ldc 66
    //   177: iconst_1
    //   178: new 68	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   185: ldc 221
    //   187: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_1
    //   191: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload 4
    //   202: ifnull +145 -> 347
    //   205: new 223	cooperation/plugin/PluginInfo
    //   208: dup
    //   209: invokespecial 224	cooperation/plugin/PluginInfo:<init>	()V
    //   212: astore_1
    //   213: aload_1
    //   214: aload_0
    //   215: putfield 227	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   218: aload_1
    //   219: aload_3
    //   220: putfield 230	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   223: aload_1
    //   224: iconst_1
    //   225: putfield 233	cooperation/plugin/PluginInfo:mUpdateType	I
    //   228: aload_1
    //   229: iconst_0
    //   230: putfield 236	cooperation/plugin/PluginInfo:mInstallType	I
    //   233: aload_1
    //   234: iconst_4
    //   235: putfield 239	cooperation/plugin/PluginInfo:mState	I
    //   238: aload_1
    //   239: aload 6
    //   241: invokevirtual 243	java/io/File:length	()J
    //   244: putfield 246	cooperation/plugin/PluginInfo:mLength	J
    //   247: aload_1
    //   248: aload 6
    //   250: invokevirtual 205	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   253: putfield 249	cooperation/plugin/PluginInfo:mInstalledPath	Ljava/lang/String;
    //   256: aload_1
    //   257: invokestatic 251	bina:a	()Ljava/lang/String;
    //   260: putfield 254	cooperation/plugin/PluginInfo:mFingerPrint	Ljava/lang/String;
    //   263: aload_1
    //   264: aload 5
    //   266: invokestatic 136	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   269: invokestatic 257	bimy:a	(Lcooperation/plugin/PluginInfo;Ljava/io/File;)V
    //   272: ldc 66
    //   274: iconst_1
    //   275: ldc_w 259
    //   278: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: iconst_1
    //   282: ireturn
    //   283: astore 4
    //   285: invokestatic 264	bdcs:a	()F
    //   288: fstore_2
    //   289: ldc_w 266
    //   292: iconst_1
    //   293: new 68	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 268
    //   303: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 6
    //   308: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   311: ldc_w 273
    //   314: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: fload_2
    //   318: invokevirtual 276	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   321: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aload 4
    //   326: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   329: goto -246 -> 83
    //   332: astore_1
    //   333: ldc 66
    //   335: iconst_1
    //   336: ldc 160
    //   338: aload_1
    //   339: invokestatic 278	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   342: aload_0
    //   343: invokestatic 281	com/tencent/mobileqq/pluginsdk/PluginStatic:removeClassLoader	(Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   346: pop
    //   347: aload_0
    //   348: invokestatic 185	com/tencent/mobileqq/startup/step/InstallPlugins:a	(Ljava/lang/String;)V
    //   351: new 283	android/content/Intent
    //   354: dup
    //   355: ldc_w 285
    //   358: invokespecial 287	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   361: astore_1
    //   362: aload_1
    //   363: invokestatic 293	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   366: invokevirtual 298	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   369: invokevirtual 302	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   372: pop
    //   373: aload_1
    //   374: ldc_w 304
    //   377: getstatic 307	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   380: invokevirtual 311	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   383: pop
    //   384: aload_1
    //   385: ldc_w 313
    //   388: aload_0
    //   389: invokevirtual 311	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   392: pop
    //   393: aload 5
    //   395: aload_1
    //   396: invokevirtual 319	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   399: ldc 66
    //   401: iconst_1
    //   402: ldc_w 321
    //   405: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: iconst_0
    //   409: ireturn
    //   410: astore_1
    //   411: ldc 66
    //   413: iconst_1
    //   414: ldc 160
    //   416: aload_1
    //   417: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: goto -73 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	paramString1	String
    //   0	423	1	paramString2	String
    //   288	30	2	f	float
    //   69	151	3	localObject1	Object
    //   78	123	4	localObject2	Object
    //   283	42	4	localException	Exception
    //   3	391	5	localBaseApplicationImpl	BaseApplicationImpl
    //   18	289	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   70	80	283	java/lang/Exception
    //   167	200	332	java/lang/Exception
    //   205	281	332	java/lang/Exception
    //   90	167	410	java/lang/Exception
    //   333	347	410	java/lang/Exception
  }
  
  protected boolean doStep()
  {
    long l = System.currentTimeMillis();
    QLog.i("plugin_tag.InstallPlugins", 1, " install");
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getMobileQQ().peekAppRuntime();
    Object localObject3;
    if (localObject1 != null)
    {
      QLog.i("plugin_tag.InstallPlugins", 1, "preinstall by pluginmanger");
      localObject1 = (bimg)((QQAppInterface)localObject1).getManager(27);
      localObject3 = jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        ((bimg)localObject1).installPlugin(localObject3[i], null);
        i += 1;
      }
      try
      {
        Thread.sleep(5000L);
        QLog.d("plugin_tag.InstallPlugins", 1, " install" + (System.currentTimeMillis() - l));
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = ((ActivityManager)BaseApplicationImpl.sApplication.getSystemService("activity")).getRunningAppProcesses();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
            if (!((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith(":qzone")) {
              break label295;
            }
            Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject3).pid);
            QLog.d("plugin_tag.InstallPlugins", 1, "kill qzone");
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("plugin_tag.InstallPlugins", 1, "", localThrowable);
        QLog.i("plugin_tag.InstallPlugins", 1, "qzone");
        jdField_a_of_type_Azkd = new azkd();
        jdField_a_of_type_Azkd.jdField_a_of_type_Boolean = a("qzone_plugin.apk", "com.qzone.Foo");
        jdField_a_of_type_Azkd.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
        QLog.i("plugin_tag.InstallPlugins", 1, "qwallet");
        a("qwallet_plugin.apk", "com.qwallet.utils.Foo");
      }
      label295:
      if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith(":tool"))
      {
        Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject3).pid);
        QLog.d("plugin_tag.InstallPlugins", 1, "kill tool");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InstallPlugins
 * JD-Core Version:    0.7.0.1
 */