package com.tencent.mobileqq.vas;

import akpn;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class VasApngUtil
{
  public static AtomicBoolean a;
  public static int[] a;
  public static AtomicBoolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    b = new AtomicBoolean(false);
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 3, 4, 5, 6, 8 };
  }
  
  public static URLDrawable a(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    return a(paramAppRuntime, paramString1, paramString2, paramDrawable, paramArrayOfInt, paramString3, paramBundle, null);
  }
  
  public static URLDrawable a(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle, VasApngUtil.ApngSoLoadCallBack paramApngSoLoadCallBack)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    long l1 = SystemClock.uptimeMillis();
    if (!a(paramAppRuntime, paramApngSoLoadCallBack))
    {
      QLog.d("VasApngUtil", 1, "apng.so load fail");
      return null;
    }
    long l2 = SystemClock.uptimeMillis();
    QLog.d("ChatBackground_Time", 1, "apng.so load succ " + (l2 - l1));
    paramAppRuntime = paramBundle;
    if (paramBundle == null) {}
    for (;;)
    {
      try
      {
        paramAppRuntime = new Bundle();
        boolean bool = paramAppRuntime.getBoolean("key_play_apng", true);
        int i = paramAppRuntime.getInt("key_loop");
        paramBundle = new StringBuilder().append(paramString2);
        if (paramString2.contains("?"))
        {
          paramString2 = "&";
          paramString2 = paramString2;
          paramString2 = paramString2 + "p=" + bool;
          paramBundle = new StringBuilder().append(paramString2);
          if (i == 0)
          {
            paramString2 = "";
            paramString2 = paramString2;
            paramBundle = new URL("vasapngdownloader", paramString1, paramString2);
            paramApngSoLoadCallBack = URLDrawable.URLDrawableOptions.obtain();
            paramApngSoLoadCallBack.mUseApngImage = bool;
            paramApngSoLoadCallBack.mUseMemoryCache = paramAppRuntime.getBoolean("key_use_cache", true);
            i = paramAppRuntime.getInt("key_width", 0);
            int j = paramAppRuntime.getInt("key_height", 0);
            if ((i > 0) && (j > 0))
            {
              paramApngSoLoadCallBack.mRequestWidth = i;
              paramApngSoLoadCallBack.mRequestHeight = j;
            }
            paramApngSoLoadCallBack.mLoadingDrawable = paramDrawable;
            paramApngSoLoadCallBack.mFailedDrawable = paramDrawable;
            paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
            paramAppRuntime.putString("key_name", paramString3);
            paramApngSoLoadCallBack.mExtraInfo = paramAppRuntime;
            if ("-Dynamic-".equals(paramString2)) {
              paramApngSoLoadCallBack.mUseAutoScaleParams = false;
            }
            paramAppRuntime = URLDrawable.getDrawable(paramBundle, paramApngSoLoadCallBack);
            if (QLog.isColorLevel()) {
              QLog.d("VasApngUtil", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
            }
          }
          else
          {
            paramString2 = "&l=" + i;
            continue;
          }
          return paramAppRuntime;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("VasApngUtil", 1, "getApngDrawable ApngImage err:" + paramAppRuntime.toString() + ", path:" + paramString1 + ", name=" + paramString3);
        return null;
      }
      paramString2 = "?";
    }
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasApngUtil", 2, "VasApngUtil#onDownloadCompleted: errCode=" + paramInt);
    }
    String str1;
    String str2;
    if (paramInt == 0)
    {
      str1 = VasUtils.a();
      str2 = FontManager.a + File.separator + "apng.zip";
      if (VasUtils.a(str2, str1, "libAPNG765.so"))
      {
        QLog.d("VasApngUtil", 1, "unzip apng zip success");
        a();
        VasQuickUpdateEngine.safeDeleteFile(new File(str2));
      }
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      QLog.e("VasApngUtil", 1, new Object[] { "unzip error, libDir=" + str1, " zipPath=" + str2 });
      continue;
      QLog.e("VasApngUtil", 1, "apng download error: " + paramInt);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (QLog.isColorLevel()) {
        QLog.d("VasApngUtil", 2, "downloadSo: is downloading from=" + paramString);
      }
    }
    do
    {
      return;
      paramAppRuntime = (VasQuickUpdateManager)paramAppRuntime.getManager(183);
      if (paramAppRuntime != null)
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        paramAppRuntime.a(1004L, "libAPNG_765", paramString);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VasApngUtil", 2, "VasApngUtil#downloadSo: manager is null from=" + paramString);
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 20	com/tencent/mobileqq/vas/VasApngUtil:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   11: ifeq +27 -> 38
    //   14: iload_1
    //   15: istore_0
    //   16: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +14 -> 33
    //   22: ldc 48
    //   24: iconst_2
    //   25: ldc_w 276
    //   28: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iload_1
    //   32: istore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: iload_0
    //   37: ireturn
    //   38: invokestatic 207	com/tencent/mobileqq/utils/VasUtils:a	()Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +107 -> 153
    //   49: new 60	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   56: aload_2
    //   57: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 221
    //   62: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_2
    //   69: invokestatic 278	com/tencent/mobileqq/vas/VasApngUtil:b	()Z
    //   72: istore_0
    //   73: iload_0
    //   74: ifeq +79 -> 153
    //   77: aload_2
    //   78: invokestatic 283	java/lang/System:load	(Ljava/lang/String;)V
    //   81: getstatic 20	com/tencent/mobileqq/vas/VasApngUtil:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   84: iconst_1
    //   85: invokevirtual 240	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   88: ldc 48
    //   90: iconst_1
    //   91: ldc_w 285
    //   94: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: iload_1
    //   98: istore_0
    //   99: goto -66 -> 33
    //   102: astore_3
    //   103: ldc 48
    //   105: iconst_1
    //   106: ldc_w 287
    //   109: aload_3
    //   110: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: new 214	java/io/File
    //   116: dup
    //   117: aload_2
    //   118: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: invokestatic 237	com/tencent/mobileqq/vas/VasQuickUpdateEngine:safeDeleteFile	(Ljava/io/File;)Z
    //   124: pop
    //   125: aconst_null
    //   126: ldc_w 292
    //   129: ldc 105
    //   131: ldc 105
    //   133: ldc_w 294
    //   136: ldc_w 296
    //   139: iconst_0
    //   140: iconst_0
    //   141: ldc_w 298
    //   144: ldc 105
    //   146: ldc 105
    //   148: ldc 105
    //   150: invokestatic 303	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   153: iconst_0
    //   154: istore_0
    //   155: goto -122 -> 33
    //   158: astore_2
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_2
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	140	0	bool1	boolean
    //   1	97	1	bool2	boolean
    //   41	77	2	str	String
    //   158	5	2	localObject	Object
    //   102	8	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   77	97	102	java/lang/Throwable
    //   5	14	158	finally
    //   16	31	158	finally
    //   38	73	158	finally
    //   77	97	158	finally
    //   103	153	158	finally
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    return a(paramAppRuntime, null);
  }
  
  public static boolean a(AppRuntime paramAppRuntime, VasApngUtil.ApngSoLoadCallBack paramApngSoLoadCallBack)
  {
    if (!b.get())
    {
      if (b()) {
        break label87;
      }
      if (paramAppRuntime != null) {
        break label94;
      }
      if (BaseApplicationImpl.getApplication() == null) {
        break label56;
      }
      paramAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    }
    label56:
    label61:
    label87:
    label94:
    for (;;)
    {
      if (paramAppRuntime != null)
      {
        if (!(paramAppRuntime instanceof QQAppInterface)) {
          break label61;
        }
        a(paramAppRuntime, "VasApngUtil");
      }
      for (;;)
      {
        return b.get();
        paramAppRuntime = null;
        break;
        paramAppRuntime = new akpn(paramApngSoLoadCallBack);
        QIPCClientHelper.getInstance().callServer("VasApngIPCModule", VasApngIPCModule.a, null, paramAppRuntime);
        continue;
        a();
      }
    }
  }
  
  public static boolean b()
  {
    String str = VasUtils.a();
    if (!TextUtils.isEmpty(str))
    {
      str = str + "libAPNG765.so";
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d("VasApngUtil", 2, "isSoExists: path=" + str + " exist=" + bool);
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngUtil
 * JD-Core Version:    0.7.0.1
 */