package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.i;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TbsExtensionFunctionManager
{
  public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
  public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
  public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
  public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
  public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
  public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
  public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
  public static final int SWITCH_BYTE_COOKIE = 1;
  public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
  public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
  public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
  public static final String USEX5_FILE_NAME = "usex5.txt";
  private static TbsExtensionFunctionManager b;
  private boolean a;
  
  public static TbsExtensionFunctionManager getInstance()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TbsExtensionFunctionManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  /* Error */
  public boolean canUseFunction(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 56	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokevirtual 62	android/content/Context:getFilesDir	()Ljava/io/File;
    //   10: aload_2
    //   11: invokespecial 65	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 69	java/io/File:exists	()Z
    //   19: ifeq +18 -> 37
    //   22: aload_1
    //   23: invokevirtual 72	java/io/File:isFile	()Z
    //   26: istore_3
    //   27: iload_3
    //   28: ifeq +9 -> 37
    //   31: iconst_1
    //   32: istore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_3
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_3
    //   39: goto -6 -> 33
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: goto +5 -> 50
    //   48: aload_1
    //   49: athrow
    //   50: goto -2 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	TbsExtensionFunctionManager
    //   0	53	1	paramContext	Context
    //   0	53	2	paramString	String
    //   26	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	42	finally
  }
  
  public int getRomCookieDBVersion(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        paramContext = paramContext.getSharedPreferences("cookie_compatiable", 4);
      } else {
        paramContext = paramContext.getSharedPreferences("cookie_compatiable", 0);
      }
      if (paramContext == null) {
        return -1;
      }
      int i = paramContext.getInt("cookie_db_version", -1);
      return i;
    }
    finally {}
  }
  
  public void initTbsBuglyIfNeed(Context paramContext)
  {
    try
    {
      boolean bool = this.a;
      if (bool) {
        return;
      }
      if (!canUseFunction(paramContext, "bugly_switch.txt"))
      {
        TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
        return;
      }
      Object localObject1;
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        localObject1 = TbsShareManager.c(paramContext);
      }
      else
      {
        localObject1 = p.a().r(paramContext);
        if (localObject1 == null) {
          TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
        }
        if ((((File)localObject1).listFiles() == null) || (((File)localObject1).listFiles().length <= 0)) {
          break label336;
        }
        localObject1 = ((File)localObject1).getAbsolutePath();
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
        return;
      }
      Object localObject4 = p.a().r(paramContext);
      if (localObject4 == null)
      {
        TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
        return;
      }
      Object localObject3 = new File((String)localObject1, "tbs_bugly_dex.jar");
      try
      {
        Object localObject2 = ((File)localObject3).getParent();
        localObject3 = ((File)localObject3).getAbsolutePath();
        localObject4 = ((File)localObject4).getAbsolutePath();
        Map localMap = QbSdk.getSettings();
        localObject2 = new DexLoader((String)localObject2, paramContext, new String[] { localObject3 }, (String)localObject4, localMap).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager");
        int i = WebView.getTbsSDKVersion(paramContext);
        int j = WebView.getTbsCoreVersion(paramContext);
        i.a((Class)localObject2, "initBugly", new Class[] { Context.class, String.class, String.class, String.class }, new Object[] { paramContext, localObject1, String.valueOf(i), String.valueOf(j) });
        this.a = true;
        TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
        return;
      }
      catch (Throwable paramContext)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("bugly init ,try init bugly failed(need new core):");
        ((StringBuilder)localObject1).append(Log.getStackTraceString(paramContext));
        TbsLog.i("TbsExtensionFunMana", ((StringBuilder)localObject1).toString());
        return;
      }
      label336:
      TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
      return;
    }
    finally {}
  }
  
  public boolean setFunctionEnable(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = new File(paramContext.getFilesDir(), paramString);
      if (paramBoolean)
      {
        paramBoolean = paramContext.exists();
        if (!paramBoolean) {
          try
          {
            paramBoolean = paramContext.createNewFile();
            if (!paramBoolean) {
              break label146;
            }
            return true;
          }
          catch (IOException paramContext)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setFunctionEnable,createNewFile fail:");
            localStringBuilder.append(paramString);
            TbsLog.e("TbsExtensionFunMana", localStringBuilder.toString());
            paramContext.printStackTrace();
            return false;
          }
        }
      }
      else if (paramContext.exists())
      {
        paramBoolean = paramContext.delete();
        if (paramBoolean) {
          return true;
        }
        paramContext = new StringBuilder();
        paramContext.append("setFunctionEnable,file.delete fail:");
        paramContext.append(paramString);
        TbsLog.e("TbsExtensionFunMana", paramContext.toString());
        return false;
      }
      label146:
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsExtensionFunctionManager
 * JD-Core Version:    0.7.0.1
 */