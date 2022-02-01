import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils.1;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.biz.pubaccount.util.Achilles;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class oxz
{
  private static long jdField_a_of_type_Long;
  private static oya jdField_a_of_type_Oya = new oya(null);
  private static oyb jdField_a_of_type_Oyb = new oyb(null);
  
  private static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "getSharedPreferences: return null for runtime is null");
      return null;
    }
    paramAppRuntime = "readinjoy_sp_kb_predownload_" + paramAppRuntime.getAccount();
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0);
  }
  
  private static String a()
  {
    label235:
    for (;;)
    {
      try
      {
        bnrf.e();
        Object localObject2 = Achilles.a();
        if ((localObject2 == null) || (((Set)localObject2).isEmpty()))
        {
          QLog.e("KBPreDownloadUtils", 1, "[queryKBPreDownloadInfoAladdin] empty param set.");
          return "";
        }
        Object localObject1 = null;
        Iterator localIterator = ((Set)localObject2).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (AchillesParams)localIterator.next();
          if (TextUtils.equals(((AchillesParams)localObject2).getPackageName(), "com.tencent.reading"))
          {
            localObject1 = localObject2;
            break label235;
          }
        }
        else
        {
          if (localObject1 == null)
          {
            QLog.e("KBPreDownloadUtils", 1, "[queryKBPreDownloadInfoAladdin] param not found for com.tencent.reading");
            return "";
          }
          localObject2 = bjyf.a().a("com.tencent.reading");
          boolean bool;
          if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).l)))
          {
            bool = new File(((DownloadInfo)localObject2).l).exists();
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("app_id", "101480433");
            ((JSONObject)localObject2).put("download_url", localObject1.getDownloadUrl());
            if (bool)
            {
              i = 1;
              ((JSONObject)localObject2).put("download_finished", i);
              if (!localObject1.isEnable()) {
                continue;
              }
              i = 1;
              ((JSONObject)localObject2).put("enable_predownload", i);
              return ((JSONObject)localObject2).toString();
            }
          }
          else
          {
            QLog.e("KBPreDownloadUtils", 1, "[queryKBPreDownloadInfoAladdin] download info not found");
            bool = false;
            continue;
          }
          int i = 0;
          continue;
          i = 0;
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("KBPreDownloadUtils", 1, "[queryKBDownloadInfo] ", localException);
        return "";
      }
    }
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    Object localObject = a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("app_id", "101480433");
      ((JSONObject)localObject).put("download_url", b(paramAppRuntime, "sp_key_kb_download_url"));
      if (a())
      {
        i = 1;
        ((JSONObject)localObject).put("download_finished", i);
        if (!b(paramAppRuntime, "sp_key_enable_pre_download")) {
          break label90;
        }
      }
      label90:
      for (int i = 1;; i = 0)
      {
        ((JSONObject)localObject).put("enable_predownload", i);
        paramAppRuntime = ((JSONObject)localObject).toString();
        return paramAppRuntime;
        i = 0;
        break;
      }
      return "";
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("KBPreDownloadUtils", 1, "[queryKBDownloadInfo] ", paramAppRuntime);
    }
  }
  
  public static void a()
  {
    int i = new Random().nextInt(5000);
    QLog.i("KBPreDownloadUtils", 1, "[maybePDKB] delay= " + i + "ms");
    ThreadManager.getFileThreadHandler().postDelayed(new KBPDUtils.1(), i);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[setString] val for key: " + paramString1 + " is null.");
      return;
    }
    QLog.d("KBPreDownloadUtils", 2, "[setString] set: " + paramString1 + " to: " + paramString2);
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[setString] sp is null");
      return;
    }
    paramAppRuntime.edit().putString(paramString1, paramString2).apply();
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    QLog.d("KBPreDownloadUtils", 2, "[setBoolean] set: " + paramString + " to: " + paramBoolean);
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[setBoolean] sp is null");
      return;
    }
    paramAppRuntime.edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  private static boolean a()
  {
    String str = b(ozs.a(), "sp_key_local_apk_path");
    QLog.d("KBPreDownloadUtils", 2, "[isPkgExist] localApkPath=" + str);
    return (!TextUtils.isEmpty(str)) && (new File(str).exists());
  }
  
  private static String b(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[getString] sp is null");
      return null;
    }
    return paramAppRuntime.getString(paramString, null);
  }
  
  private static void b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null)
    {
      a(ozs.a(), "sp_key_current_app_version_name", paramContext.versionName);
      QLog.d("KBPreDownloadUtils", 2, "[saveVersionInfo] versionName: " + paramContext.versionName);
      paramContext = bjtz.a(paramString);
      if (paramContext == null) {
        break label129;
      }
    }
    label129:
    for (paramContext = paramContext.toLowerCase();; paramContext = null)
    {
      a(ozs.a(), "sp_key_local_apk_path", paramString);
      a(ozs.a(), "sp_key_current_app_md5", paramContext);
      QLog.d("KBPreDownloadUtils", 2, "[saveVersionInfo] md5: " + paramContext);
      return;
      QLog.e("KBPreDownloadUtils", 1, "[saveVersionInfo] package info is null");
      break;
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    QLog.d("KBPreDownloadUtils", 2, "[persistDownloadInfo] url=" + paramString1 + " savedPath=" + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = "101480433";
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_d_of_type_JavaLangString = paramString1;
    localDownloadInfo.l = paramString2;
    localDownloadInfo.e = "com.tencent.reading";
    localDownloadInfo.h = "ANDROIDQQ.QNREADING";
    localDownloadInfo.a = false;
    localDownloadInfo.i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
    localDownloadInfo.jdField_d_of_type_Boolean = false;
    localDownloadInfo.m = "biz_src_feeds_kandian";
    bjyf.a().a(localDownloadInfo);
  }
  
  private static void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str = ozs.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    bdmc.a(ozs.a().getApplication()).a(str, "actKBPreDownload", paramBoolean, paramLong, 0L, localHashMap, null, false);
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = b(ozs.a(), "sp_key_current_app_version_name");
    String str1 = b(ozs.a(), "sp_key_latest_app_version_name");
    String str2 = b(ozs.a(), "sp_key_current_app_md5");
    String str3 = b(ozs.a(), "sp_key_latest_app_md5");
    QLog.d("KBPreDownloadUtils", 2, "[isCurrentVersionLatest] currentAppVersion: " + paramContext + " latestAppVersion: " + str1 + " currentAppMd5: " + str2 + " latestAppMd5: " + str3);
    boolean bool1;
    if ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str1))) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (!a())
        {
          QLog.i("KBPreDownloadUtils", 1, "[isCurrentVersionLatest] pkg not exists");
          return false;
        }
        if ((str3 == null) || (str2 == null)) {
          break;
        }
        bool1 = bool2;
      } while (!TextUtils.equals(str3.toLowerCase(), str2.toLowerCase()));
      if ((TextUtils.isEmpty(paramContext)) || (TextUtils.isEmpty(str1))) {
        break;
      }
      bool1 = bool2;
    } while (Achilles.a(paramContext, str1) < 0);
    return true;
  }
  
  private static boolean b(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[getBoolean] sp is null");
      return false;
    }
    return paramAppRuntime.getBoolean(paramString, false);
  }
  
  private static void c()
  {
    try
    {
      String str = b(ozs.a(), "sp_key_local_apk_path");
      if (str != null) {
        bhmi.d(str);
      }
      for (;;)
      {
        bjyf.a().a("101480433");
        return;
        QLog.i("KBPreDownloadUtils", 1, "[clearDownloadInfo] won't delete since apkPath is null");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("KBPreDownloadUtils", 1, "[clearDownloadInfo] ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxz
 * JD-Core Version:    0.7.0.1
 */