package com.tencent.mobileqq.startup.step;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import awot;
import awou;
import awrn;
import bace;
import bfcz;
import bfdr;
import bfdt;
import bgfa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class InstallPlugins
  extends Step
{
  public static awot a;
  public static awou a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "qzone_plugin.apk", "qwallet_plugin.apk" };
  }
  
  public static String a(Context paramContext, String paramString, File paramFile, boolean paramBoolean)
  {
    String str1 = "";
    PluginUtils.extractPlugin(paramContext, paramString, paramFile);
    if (bgfa.a(paramFile.getAbsolutePath()))
    {
      QLog.d("plugin_tag.InstallPlugins", 2, "start extract 7z file");
      long l1 = System.currentTimeMillis();
      File localFile = new File(paramFile.getAbsoluteFile() + ".7z");
      int i;
      int j;
      if (paramFile.renameTo(localFile))
      {
        long l2 = System.currentTimeMillis();
        i = LzmaUtils.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath(), paramFile.getParent());
        j = (int)(System.currentTimeMillis() - l2);
        QLog.i("plugin_tag.InstallPlugins", 1, "LzmaDecode,cost:" + j + ",ret:" + i);
        if (i != 0) {
          i <<= 2;
        }
      }
      for (;;)
      {
        j = (int)(System.currentTimeMillis() - l1);
        QLog.i("plugin_tag.InstallPlugins", 1, "end extract 7z file,cost:" + j + ".errorCode:" + i);
        if ((!TextUtils.isEmpty(str1)) || (!paramBoolean)) {
          break;
        }
        QLog.i("plugin_tag.InstallPlugins", 1, "retry extract 7z file");
        b();
        a(paramContext, paramString, paramFile, false);
        return str1;
        String str2 = paramString.replaceFirst("\\.apk$", ".jpg");
        boolean bool = new File(paramFile.getParent(), str2).renameTo(paramFile);
        localFile.delete();
        if (bool)
        {
          str1 = PluginStatic.encodeFile(paramFile.getAbsolutePath());
          i = 0;
        }
        else
        {
          i = -2;
          continue;
          i = -1;
        }
      }
      a(j, paramString, i);
      return str1;
    }
    return PluginStatic.encodeFile(paramFile.getAbsolutePath());
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_Awot != null)
      {
        Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject1 = ((AppRuntime)localObject1).getAccount();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            awrn.a(BaseApplicationImpl.getApplication()).a((String)localObject1, "qzonePrePluginInstall", jdField_a_of_type_Awot.jdField_a_of_type_Boolean, jdField_a_of_type_Awot.jdField_a_of_type_Long, 0L, null, null);
          }
          QLog.i("plugin_tag.InstallPlugins", 1, "install qzone:" + jdField_a_of_type_Awot.jdField_a_of_type_Boolean + ",cost:" + jdField_a_of_type_Awot.jdField_a_of_type_Long);
        }
        jdField_a_of_type_Awot = null;
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
    //   3: getstatic 195	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Awou	Lawou;
    //   6: ifnull +129 -> 135
    //   9: invokestatic 155	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   12: invokevirtual 159	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +114 -> 131
    //   20: aload_2
    //   21: invokevirtual 164	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +102 -> 131
    //   32: new 197	java/util/HashMap
    //   35: dup
    //   36: invokespecial 198	java/util/HashMap:<init>	()V
    //   39: astore_3
    //   40: aload_3
    //   41: ldc 200
    //   43: getstatic 195	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Awou	Lawou;
    //   46: getfield 205	awou:jdField_a_of_type_Int	I
    //   49: invokestatic 209	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload_3
    //   57: ldc 215
    //   59: iload_0
    //   60: invokestatic 209	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   63: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: invokestatic 155	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   70: invokestatic 169	awrn:a	(Landroid/content/Context;)Lawrn;
    //   73: astore 4
    //   75: new 60	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   82: getstatic 195	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Awou	Lawou;
    //   85: getfield 218	awou:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 220
    //   93: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 5
    //   101: getstatic 195	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Awou	Lawou;
    //   104: getfield 205	awou:jdField_a_of_type_Int	I
    //   107: ifne +32 -> 139
    //   110: iconst_1
    //   111: istore_1
    //   112: aload 4
    //   114: aload_2
    //   115: aload 5
    //   117: iload_1
    //   118: getstatic 195	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Awou	Lawou;
    //   121: getfield 222	awou:b	I
    //   124: i2l
    //   125: lconst_0
    //   126: aload_3
    //   127: aconst_null
    //   128: invokevirtual 182	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   131: aconst_null
    //   132: putstatic 195	com/tencent/mobileqq/startup/step/InstallPlugins:jdField_a_of_type_Awou	Lawou;
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
    //   73	40	4	localawrn	awrn
    //   99	17	5	str	String
    // Exception table:
    //   from	to	target	type
    //   3	16	144	finally
    //   20	110	144	finally
    //   112	131	144	finally
    //   131	135	144	finally
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      jdField_a_of_type_Awou = new awou();
      jdField_a_of_type_Awou.b = paramInt1;
      jdField_a_of_type_Awou.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Awou.jdField_a_of_type_Int = paramInt2;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
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
      bfdr.a(paramString, localFile1);
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
  
  private static boolean a(String paramString1, String paramString2)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    File localFile = new File(PluginUtils.getPluginInstallDir(localBaseApplicationImpl), paramString1);
    if ((localFile.exists()) && ("qwallet_plugin.apk".equals(paramString1)))
    {
      QLog.d("plugin_tag.InstallPlugins", 1, "installed");
      return true;
    }
    if (PluginStatic.getClassLoader(paramString1) != null)
    {
      QLog.d("plugin_tag.InstallPlugins", 1, "dexLoaded");
      return true;
    }
    a(paramString1);
    Object localObject1 = null;
    try
    {
      if (!"qzone_plugin.apk".equals(paramString1)) {
        break label297;
      }
      localObject2 = a(localBaseApplicationImpl, paramString1, localFile, true);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = PluginUtils.getPluginLibPath(localBaseApplicationImpl, paramString1).getCanonicalPath();
          localObject2 = PluginUtils.extractLibs(localFile.getCanonicalPath(), (String)localObject2);
          QLog.d("plugin_tag.InstallPlugins", 1, "extract" + (String)localObject2);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!bfdt.a(paramString1, localFile.getAbsolutePath()))) {
            continue;
          }
          localObject2 = PluginStatic.getOrCreateClassLoader(localBaseApplicationImpl, paramString1);
          try
          {
            localObject2 = ((ClassLoader)localObject2).loadClass(paramString2);
            QLog.d("plugin_tag.InstallPlugins", 1, "cls " + paramString2);
            if (localObject2 == null) {
              continue;
            }
            paramString2 = new PluginInfo();
            paramString2.mID = paramString1;
            paramString2.mMD5 = localObject1;
            paramString2.mUpdateType = 1;
            paramString2.mInstallType = 0;
            paramString2.mState = 4;
            paramString2.mLength = localFile.length();
            paramString2.mInstalledPath = localFile.getAbsolutePath();
            paramString2.mFingerPrint = bfdt.a();
            bfdr.a(paramString2, PluginUtils.getPluginInstallDir(localBaseApplicationImpl));
            QLog.d("plugin_tag.InstallPlugins", 1, "succ");
            return true;
          }
          catch (Exception paramString2)
          {
            float f;
            QLog.i("plugin_tag.InstallPlugins", 1, "", paramString2);
            PluginStatic.removeClassLoader(paramString1);
          }
          localObject2 = PluginUtils.extractPluginAndGetMd5Code(localBaseApplicationImpl, paramString1, localFile);
          localObject1 = localObject2;
        }
        catch (Exception paramString2)
        {
          QLog.e("plugin_tag.InstallPlugins", 1, "", paramString2);
          continue;
        }
        localException = localException;
        f = bace.a();
        QLog.e("plugin_tag", 1, "extractPluginAndGetMd5Code failed installPath = " + localFile + ", leftSpace = " + f, localException);
      }
    }
    if (!TextUtils.isEmpty(localObject1)) {}
    label297:
    a(paramString1);
    paramString2 = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_INSTALL_FAILED");
    paramString2.setPackage(MobileQQ.getContext().getPackageName());
    paramString2.putExtra("process", BaseApplicationImpl.processName);
    paramString2.putExtra("plugin", paramString1);
    localBaseApplicationImpl.sendBroadcast(paramString2);
    QLog.d("plugin_tag.InstallPlugins", 1, "failed");
    return false;
  }
  
  private static void b() {}
  
  protected boolean doStep()
  {
    long l = System.currentTimeMillis();
    QLog.i("plugin_tag.InstallPlugins", 1, " install");
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getMobileQQ().peekAppRuntime();
    Object localObject3;
    if (localObject1 != null)
    {
      QLog.i("plugin_tag.InstallPlugins", 1, "preinstall by pluginmanger");
      localObject1 = (bfcz)((QQAppInterface)localObject1).getManager(27);
      localObject3 = jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        ((bfcz)localObject1).installPlugin(localObject3[i], null);
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
        jdField_a_of_type_Awot = new awot();
        jdField_a_of_type_Awot.jdField_a_of_type_Boolean = a("qzone_plugin.apk", "com.qzone.Foo");
        jdField_a_of_type_Awot.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InstallPlugins
 * JD-Core Version:    0.7.0.1
 */