package cooperation.qzone.patch;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class QZonePatchService
{
  public static final String PATCH_MERGE_DIR = "patchs_merge";
  public static final String PATCH_O_DEX_DIR = "dex";
  public static final String PATCH_SUFFIX = ".jar";
  public static final String PATCH_SUFFIX_DEX = ".dex";
  public static final int RET_PATCH_DEL_SUCCEED = 11;
  public static final int RET_PATCH_DOWNLOAD_SUCCEED = 10;
  public static final int RET_PATCH_VERIFY_FAILED = 12;
  public static final String SP_MERGE_LENGTH = "p_merge_len";
  public static final String SP_MERGE_ODEX_LENGTH = "p_merge_odex_len";
  public static final String SP_QZONE_LENGTH = "p_qzone_len";
  public static final String SP_VERSION = "p_ver";
  public static final String TAG = "qz_patch";
  private static volatile boolean bPatchUpdating = false;
  private static String curPatchMd5;
  private static Object lock = new Object();
  private static QZonePatchService mInstance;
  private static int sPatchVersion = 0;
  
  public static void cachePatchVersion(String paramString)
  {
    int i = getPatchVersion(paramString);
    sPatchVersion = i;
    resetPatchVersion(i);
  }
  
  private static void deleteMergeAndOdexFiles()
  {
    deleteMergedFiles();
    deleteMergedOdexFiles();
  }
  
  private static void deleteMergedFiles()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext();
    int i = 0;
    localObject1 = ((BaseApplication)localObject1).getDir("patchs_merge", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!localObject2.isDirectory()) {
          localObject2.delete();
        }
        i += 1;
      }
    }
    saveConfigPatchMergeFileLength(0L);
  }
  
  private static void deleteMergedOdexFiles()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext();
    int i = 0;
    localObject1 = ((BaseApplication)localObject1).getDir("dex", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!localObject2.isDirectory()) {
          localObject2.delete();
        }
        i += 1;
      }
    }
    saveConfigPatchMergeOdexFileLength(0L);
  }
  
  private static void downloadPatchAndClear(String paramString1, String paramString2)
  {
    Object localObject = getPatchPath(paramString1);
    if (HttpDownloadUtil.download((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString2, new File((String)localObject))) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(HardCodeUtil.a(2131909643));
        localStringBuilder1.append((String)localObject);
        log(localStringBuilder1.toString());
        localObject = BaseApplicationImpl.getContext();
        int i = 0;
        localObject = ((BaseApplication)localObject).getDir("patchs", 0);
        if (((File)localObject).exists())
        {
          File[] arrayOfFile = ((File)localObject).listFiles();
          int j = arrayOfFile.length;
          while (i < j)
          {
            File localFile = arrayOfFile[i];
            if (!localFile.isDirectory())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString1);
              ((StringBuilder)localObject).append(".jar");
              boolean bool = ((StringBuilder)localObject).toString().endsWith(localFile.getName());
              if (bool)
              {
                try
                {
                  localObject = PluginStatic.encodeFile(localFile.getAbsolutePath());
                  try
                  {
                    localStringBuilder1 = new StringBuilder();
                    localStringBuilder1.append("补丁包文件md5值：");
                    localStringBuilder1.append((String)localObject);
                    log(localStringBuilder1.toString());
                  }
                  catch (Exception localException1) {}
                  QLog.w("qz_patch", 1, QLog.getStackTraceString(localException2));
                }
                catch (Exception localException2)
                {
                  localObject = null;
                }
                StringBuilder localStringBuilder2;
                if (paramString1.equalsIgnoreCase((String)localObject))
                {
                  log("补丁包md5和网络md5相同");
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(QUA.getQUA3());
                  ((StringBuilder)localObject).append("p_len");
                  localObject = ((StringBuilder)localObject).toString();
                  long l = localFile.length();
                  localStringBuilder2 = new StringBuilder();
                  localStringBuilder2.append((String)localObject);
                  localStringBuilder2.append(" = ");
                  localStringBuilder2.append(l);
                  log(localStringBuilder2.toString());
                  LocalMultiProcConfig.putLong((String)localObject, l);
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("download patch success. md5=");
                  ((StringBuilder)localObject).append(paramString1);
                  ((StringBuilder)localObject).append(";len=");
                  ((StringBuilder)localObject).append(l);
                  QLog.d("qz_patch", 2, ((StringBuilder)localObject).toString());
                  cachePatchVersion(paramString2);
                  localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                  int k = getPatchResultCode(10, null);
                  localStringBuilder2 = new StringBuilder();
                  localStringBuilder2.append("md5=");
                  localStringBuilder2.append(paramString1);
                  localStringBuilder2.append(";len=");
                  localStringBuilder2.append(l);
                  QZoneHelper.preloadQZoneForHaboReport((AppRuntime)localObject, "qz_patch", k, localStringBuilder2.toString(), 1, System.currentTimeMillis());
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("report [qz_patch] succeed download : ");
                  ((StringBuilder)localObject).append(getPatchResultCode(10, null));
                  QLog.d("qz_patch", 1, ((StringBuilder)localObject).toString());
                  processPatchForAboveAndroidN(BaseApplicationImpl.getContext(), localFile.getAbsolutePath(), paramString1);
                }
                else
                {
                  log("补丁包md5和网络md5不相同");
                  localStringBuilder2 = new StringBuilder();
                  localStringBuilder2.append("file md5: ");
                  localStringBuilder2.append((String)localObject);
                  localStringBuilder2.append("but server md5 is: ");
                  localStringBuilder2.append(paramString1);
                  localStringBuilder2.append(" please check the server patch md5 configuration.");
                  QLog.d("qz_patch", 1, localStringBuilder2.toString());
                  localFile.delete();
                }
              }
              else
              {
                localFile.delete();
              }
            }
            i += 1;
          }
        }
        return;
      }
      catch (Error paramString1)
      {
        QLog.w("qz_patch", 1, QLog.getStackTraceString(paramString1));
      }
    }
  }
  
  private static long getConfigPatchMergeFileLength()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QUA.getQUA3());
    localStringBuilder.append("p_merge_len");
    return LocalMultiProcConfig.getLong(localStringBuilder.toString(), 0L);
  }
  
  private static long getConfigPatchMergeOdexFileLength()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QUA.getQUA3());
    localStringBuilder.append("p_merge_odex_len");
    return LocalMultiProcConfig.getLong(localStringBuilder.toString(), 0L);
  }
  
  private static long getConfigQZonePatchFileLength()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QUA.getQUA3());
    localStringBuilder.append("p_len");
    return LocalMultiProcConfig.getLong(localStringBuilder.toString(), 0L);
  }
  
  private static long getFileLength(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.length();
    }
    return 0L;
  }
  
  public static QZonePatchService getInstance()
  {
    if (mInstance == null) {
      synchronized (lock)
      {
        if (mInstance == null) {
          mInstance = new QZonePatchService();
        }
      }
    }
    return mInstance;
  }
  
  private static String getPatchMergeOdexPath(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".dex");
    paramString = ((StringBuilder)localObject).toString();
    localObject = BaseApplicationImpl.getContext().getDir("dex", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String getPatchMergePath(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".jar");
    paramString = ((StringBuilder)localObject).toString();
    localObject = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String getPatchPath(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".jar");
    paramString = ((StringBuilder)localObject).toString();
    localObject = BaseApplicationImpl.getContext().getDir("patchs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static int getPatchResultCode(int paramInt, String paramString)
  {
    if (paramString == null) {
      return sPatchVersion * 10000 + paramInt;
    }
    return paramInt;
  }
  
  private static int getPatchVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = Uri.parse(paramString).getLastPathSegment();
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = Pattern.compile("_r(\\d+)").matcher(paramString);
    if (paramString.find()) {
      paramString = paramString.group(1);
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
    return 0;
  }
  
  private static String getQZonePluginPath()
  {
    File localFile = PluginUtils.getInstalledPluginPath(BaseApplicationImpl.sApplication, "qzone_plugin.apk");
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return null;
  }
  
  public static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qz_patch", 2, paramString);
    }
  }
  
  private static DexClassLoader preCompileMergePatch(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramContext = new DexClassLoader(paramString, paramContext.getDir("dex", 0).getAbsolutePath(), paramString, paramClassLoader);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("preCompileMergePatch failed :");
      paramString.append(paramContext.getMessage());
      paramString.append("  stacktrace: ");
      paramString.append(Log.getStackTraceString(paramContext));
      log(paramString.toString());
    }
    return null;
  }
  
  private static void processPatchForAboveAndroidN(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      log("start to merge...");
      if ((getConfigQZonePatchFileLength() == 0L) || (getConfigPatchMergeFileLength() == 0L)) {
        deleteMergeAndOdexFiles();
      }
      if (getConfigPatchMergeOdexFileLength() == 0L) {
        deleteMergedOdexFiles();
      }
      String str2 = getQZonePluginPath();
      if (str2 != null)
      {
        if ((getConfigQZonePatchFileLength() != 0L) && (getConfigQZonePatchFileLength() != getFileLength(paramString1)))
        {
          deleteMergeAndOdexFiles();
          saveConfigQZonePatchFileLength(getFileLength(paramString1));
        }
        String str1 = getPatchMergePath(paramString2);
        if ((getConfigPatchMergeFileLength() != 0L) && (getConfigPatchMergeFileLength() == getFileLength(str1)))
        {
          paramString1 = new StringBuilder();
          paramString1.append("---> merge : not merge share_pref len:");
          paramString1.append(getConfigPatchMergeFileLength());
          paramString1.append("  file len:");
          paramString1.append(getFileLength(str1));
          log(paramString1.toString());
        }
        else
        {
          deleteMergeAndOdexFiles();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("---> merge :");
          localStringBuilder.append(str1);
          log(localStringBuilder.toString());
          if (!PatchMergeUtils.MergeApk(str2, paramString1, str1)) {
            break label395;
          }
          saveConfigPatchMergeFileLength(getFileLength(str1));
        }
        paramString1 = getPatchMergeOdexPath(paramString2);
        if ((getConfigPatchMergeOdexFileLength() != 0L) && (getConfigPatchMergeOdexFileLength() == getFileLength(paramString1)))
        {
          paramContext = new StringBuilder();
          paramContext.append("---> merge : not compile share_pref len:");
          paramContext.append(getConfigPatchMergeOdexFileLength());
          paramContext.append(" file len:");
          paramContext.append(getFileLength(paramString1));
          log(paramContext.toString());
        }
        else
        {
          deleteMergedOdexFiles();
          paramString2 = new StringBuilder();
          paramString2.append("---> compile :");
          paramString2.append(paramString1);
          log(paramString2.toString());
          if (preCompileMergePatch(paramContext, str1, paramContext.getClassLoader()) != null)
          {
            saveConfigPatchMergeOdexFileLength(getFileLength(paramString1));
            paramContext = new StringBuilder();
            paramContext.append("---> succeed to merge and compile, merge len:");
            paramContext.append(getFileLength(str1));
            paramContext.append("   odex len:");
            paramContext.append(getFileLength(paramString1));
            log(paramContext.toString());
            break label399;
            label395:
            deleteMergeAndOdexFiles();
            return;
          }
        }
      }
      label399:
      log("end to merge...");
      return;
    }
    log("not need to merge...");
  }
  
  private static void resetPatchVersion(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppSetting.b());
    localStringBuilder.append("p_ver");
    LocalMultiProcConfig.putInt(localStringBuilder.toString(), paramInt);
  }
  
  private static void saveConfigPatchMergeFileLength(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QUA.getQUA3());
    localStringBuilder.append("p_merge_len");
    LocalMultiProcConfig.putLong(localStringBuilder.toString(), paramLong);
  }
  
  private static void saveConfigPatchMergeOdexFileLength(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QUA.getQUA3());
    localStringBuilder.append("p_merge_odex_len");
    LocalMultiProcConfig.putLong(localStringBuilder.toString(), paramLong);
  }
  
  private static void saveConfigQZonePatchFileLength(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QUA.getQUA3());
    localStringBuilder.append("p_qzone_len");
    LocalMultiProcConfig.putLong(localStringBuilder.toString(), paramLong);
  }
  
  private static void updatePatchDex(String paramString1, String paramString2)
  {
    log(HardCodeUtil.a(2131909644));
    if (TextUtils.isEmpty(paramString1))
    {
      log(HardCodeUtil.a(2131909649));
      return;
    }
    if (bPatchUpdating) {
      return;
    }
    bPatchUpdating = true;
    if (curPatchMd5 == null)
    {
      QLog.d("qz_patch", 1, "本地没有补丁包");
      if ((!"del".equals(paramString1)) && (paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        downloadPatchAndClear(paramString1, paramString2);
        curPatchMd5 = paramString1;
      }
    }
    else
    {
      QLog.d("qz_patch", 1, "本地有补丁包");
      if (curPatchMd5.equals(paramString1))
      {
        log(HardCodeUtil.a(2131909645));
        processPatchForAboveAndroidN(BaseApplicationImpl.getContext(), getPatchPath(paramString1), paramString1);
      }
      else if ((!paramString1.equals("del")) && (!paramString1.equals("delete")))
      {
        log(HardCodeUtil.a(2131909642));
        deleteMergeAndOdexFiles();
        if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
        {
          downloadPatchAndClear(paramString1, paramString2);
          curPatchMd5 = paramString1;
        }
      }
      else
      {
        QLog.d("qz_patch", 1, "md5是del，直接删除旧的Patch");
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramString1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
        if (paramString1.exists())
        {
          paramString1 = paramString1.listFiles();
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            paramString2 = paramString1[i];
            if (paramString2.isDirectory()) {
              break label392;
            }
            paramString2.delete();
            break label392;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append(QUA.getQUA3());
        paramString1.append("p_len");
        LocalMultiProcConfig.putLong(paramString1.toString(), 0L);
        curPatchMd5 = null;
        deleteMergeAndOdexFiles();
      }
      catch (Throwable paramString1)
      {
        QLog.w("qz_patch", 1, QLog.getStackTraceString(paramString1));
      }
      paramString1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramString2 = new StringBuilder();
      paramString2.append("clear patch:");
      paramString2.append(curPatchMd5);
      QZoneHelper.preloadQZoneForHaboReport(paramString1, "qz_patch", 11, paramString2.toString(), 1, System.currentTimeMillis());
      paramString1 = new StringBuilder();
      paramString1.append("report [qz_patch] clear patch:");
      paramString1.append(curPatchMd5);
      QLog.d("qz_patch", 1, paramString1.toString());
      bPatchUpdating = false;
      return;
      label392:
      i += 1;
    }
  }
  
  private static void verifyPatchFile()
  {
    log(HardCodeUtil.a(2131909646));
    curPatchMd5 = null;
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
    if (((File)localObject1).exists())
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(QUA.getQUA3());
      ((StringBuilder)localObject3).append("p_len");
      localObject3 = ((StringBuilder)localObject3).toString();
      long l = LocalMultiProcConfig.getLong((String)localObject3, 0L);
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(" = ");
      ((StringBuilder)localObject4).append(l);
      log(((StringBuilder)localObject4).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131909641));
      ((StringBuilder)localObject3).append(l);
      log(((StringBuilder)localObject3).toString());
      localObject3 = ((File)localObject1).listFiles();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          localObject4 = localObject3[i];
          if ((localObject4 != null) && (!((File)localObject4).isDirectory())) {
            if (l != ((File)localObject4).length())
            {
              ((File)localObject4).delete();
            }
            else
            {
              try
              {
                localObject1 = PluginStatic.encodeFile(((File)localObject4).getAbsolutePath()).toLowerCase();
              }
              catch (Exception localException)
              {
                QLog.w("qz_patch", 1, QLog.getStackTraceString(localException));
                localObject2 = null;
              }
              Object localObject5 = ((File)localObject4).getName();
              String str = ((String)localObject5).substring(0, ((String)localObject5).length() - 4);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append(".jar");
              if (localStringBuilder.toString().endsWith(((String)localObject5).toLowerCase()))
              {
                curPatchMd5 = str;
                break;
              }
              ((File)localObject4).delete();
              deleteMergeAndOdexFiles();
              localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("patch verify failed: file md5: ");
              ((StringBuilder)localObject5).append((String)localObject2);
              ((StringBuilder)localObject5).append(" but expected md5: ");
              ((StringBuilder)localObject5).append(str);
              QZoneHelper.preloadQZoneForHaboReport((AppRuntime)localObject4, "qz_patch", 12, ((StringBuilder)localObject5).toString(), 1, System.currentTimeMillis());
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("report [qz_patch] patch verify failed: file md5: ");
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append(" but expected md5: ");
              ((StringBuilder)localObject4).append(str);
              QLog.d("qz_patch", 1, ((StringBuilder)localObject4).toString());
              curPatchMd5 = null;
            }
          }
          i += 1;
        }
      }
    }
    if (TextUtils.isEmpty(curPatchMd5))
    {
      log(HardCodeUtil.a(2131909640));
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("当前补丁包的md5是");
    ((StringBuilder)localObject2).append(curPatchMd5);
    log(((StringBuilder)localObject2).toString());
  }
  
  public void onPatchResponse(String paramString1, String paramString2)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "isPatchEnable", 1) == 0) {
      return;
    }
    ThreadManager.postDownLoadTask(new QZonePatchService.1(this, paramString1, paramString2), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.patch.QZonePatchService
 * JD-Core Version:    0.7.0.1
 */