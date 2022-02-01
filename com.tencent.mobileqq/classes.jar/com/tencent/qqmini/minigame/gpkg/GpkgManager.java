package com.tencent.qqmini.minigame.gpkg;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class GpkgManager
{
  public static final int NO_PRELOAD = 0;
  public static final int PRELOAD_APPINFI = 1;
  public static final int PRELOAD_GPKG = 2;
  public static final String SUFFIX_TQAPKG = ".tqapkg";
  public static final String SUFFIX_WXAPKG = ".wxapkg";
  public static final String SUFFIX_ZIP = ".zip";
  private static final String TAG = "[minigame] GpkgManager";
  private static final int UNZIP_MAXCOUNT = 3;
  public static volatile long downloadDuration;
  
  private static boolean checkOfflineResourceContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("offlineconfig.json");
      paramString = localStringBuilder.toString();
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          paramString = FileUtils.readFileToString(paramString);
          if (!TextUtils.isEmpty(paramString))
          {
            boolean bool = new JSONObject(paramString).optBoolean("offlineResourceReady", false);
            return bool;
          }
        }
      }
      catch (Throwable paramString)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Gpkg] checkOfflineResourceContent error:");
        localStringBuilder.append(DebugUtil.getPrintableStackTrace(paramString));
        QMLog.i("[minigame] GpkgManager", localStringBuilder.toString());
      }
    }
    return false;
  }
  
  private static boolean checkPkgFolderContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("game.js");
      paramString = localStringBuilder.toString();
      try
      {
        boolean bool = new File(paramString).exists();
        if (bool) {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Gpkg] checkPkgFolderContent error:");
        localStringBuilder.append(DebugUtil.getPrintableStackTrace(paramString));
        QMLog.i("[minigame] GpkgManager", localStringBuilder.toString());
      }
    }
    return false;
  }
  
  private static void downloadGpkgByResumableDownloader(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString)
  {
    if (paramMiniAppInfo == null)
    {
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, game config null", null);
      }
      QMLog.e("[minigame] GpkgManager", "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, game config null");
      return;
    }
    if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
      MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, false);
    }
    long l = System.currentTimeMillis();
    if (paramMiniAppInfo.firstPage != null)
    {
      localObject2 = paramMiniAppInfo.firstPage.subPkgName;
      if (paramMiniAppInfo.subpkgs != null)
      {
        localObject3 = paramMiniAppInfo.subpkgs.iterator();
        localObject1 = null;
        for (i = -1; ((Iterator)localObject3).hasNext(); i = ((SubPkgInfo)localObject5).fileSize)
        {
          label91:
          localObject5 = (SubPkgInfo)((Iterator)localObject3).next();
          if ((localObject5 == null) || (localObject2 == null) || (!((String)localObject2).equals(((SubPkgInfo)localObject5).subPkgName))) {
            break label91;
          }
          if (((SubPkgInfo)localObject5).independent == 1)
          {
            localObject4 = ((SubPkgInfo)localObject5).downloadUrl;
            i = ((SubPkgInfo)localObject5).fileSize;
            localObject3 = localObject1;
            localObject1 = localObject4;
            break label216;
          }
          localObject1 = ((SubPkgInfo)localObject5).downloadUrl;
        }
        localObject4 = null;
        localObject2 = localObject4;
        localObject3 = localObject1;
        localObject1 = localObject4;
        break label216;
      }
    }
    Object localObject2 = null;
    Object localObject3 = localObject2;
    Object localObject1 = localObject3;
    int i = -1;
    label216:
    Object localObject4 = localObject1;
    if (localObject1 == null)
    {
      localObject4 = paramMiniAppInfo.downloadUrl;
      i = paramMiniAppInfo.fileSize;
    }
    if (TextUtils.isEmpty((CharSequence)localObject4))
    {
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, downloadUrl null", null);
      }
      QMLog.e("[minigame] GpkgManager", "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, downloadUrl null");
      return;
    }
    Object localObject5 = ((String)localObject4).toLowerCase();
    localObject1 = ".zip";
    if (!((String)localObject5).endsWith(".zip")) {
      localObject1 = ".tqapkg";
    }
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(ApkgManager.getPkgRoot(paramMiniAppInfo));
    ((StringBuilder)localObject5).append(paramMiniAppInfo.appId);
    ((StringBuilder)localObject5).append('_');
    ((StringBuilder)localObject5).append(paramMiniAppInfo.versionId);
    ((StringBuilder)localObject5).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject5).toString();
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("[Gpkg]download gpkgUrl=");
    ((StringBuilder)localObject5).append((String)localObject4);
    ((StringBuilder)localObject5).append(" ,subApkUrl=");
    ((StringBuilder)localObject5).append((String)localObject3);
    ((StringBuilder)localObject5).append(" ,independentPath=");
    ((StringBuilder)localObject5).append((String)localObject2);
    ((StringBuilder)localObject5).append(" ,savePath=");
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append(" ,fileSize=");
    ((StringBuilder)localObject5).append(i);
    QMLog.i("[minigame] GpkgManager", ((StringBuilder)localObject5).toString());
    MiniReportManager.reportEventType(paramMiniAppInfo, 619, "1");
    localObject5 = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
    new HashMap(1).put("Connection", "keep-alive");
    ((DownloaderProxy)localObject5).download((String)localObject4, null, (String)localObject1, 60, getGpkgDownloadListener(paramMiniAppInfo, paramOnInitGpkgListener, paramString, l, (String)localObject1, i, (String)localObject2, (String)localObject3));
  }
  
  private static void downloadGpkgPlugin(MiniGamePluginInfo paramMiniGamePluginInfo, GpkgManager.DownloadPluginCallback paramDownloadPluginCallback, File paramFile1, File paramFile2)
  {
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramMiniGamePluginInfo.url, null, paramFile2.getAbsolutePath(), 60, new GpkgManager.3(paramMiniGamePluginInfo, paramDownloadPluginCallback, paramFile2, paramFile1));
  }
  
  public static void downloadSubPack(MiniAppInfo paramMiniAppInfo, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    String str2 = paramMiniGamePkg.getRootPath(paramString);
    Object localObject = getSubPkgDownloadUrl(paramMiniAppInfo, paramMiniGamePkg, paramString);
    String str1;
    if (localObject != null) {
      str1 = ((SubPkgInfo)localObject).downloadUrl;
    } else {
      str1 = null;
    }
    if (TextUtils.isEmpty(str1))
    {
      if (paramOnInitGpkgListener != null)
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("unknown subpackage:");
        paramMiniAppInfo.append(paramString);
        paramOnInitGpkgListener.onInitGpkgInfo(2012, paramMiniGamePkg, paramMiniAppInfo.toString(), null);
      }
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("[Gpkg] downloadSubPack | downPage(subName)=");
      paramMiniAppInfo.append(paramString);
      paramMiniAppInfo.append("; subPackDownloadUrl=");
      paramMiniAppInfo.append(str1);
      paramMiniAppInfo.append(" error, unknown subpackage");
      QMLog.e("[minigame] GpkgManager subpackage", paramMiniAppInfo.toString());
      return;
    }
    String str3 = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    int i;
    if (localObject != null) {
      i = ((SubPkgInfo)localObject).fileSize;
    } else {
      i = -1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Gpkg] downloadSubPack | downPage(subName)=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("; subPackDownloadUrl=");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append("; folder:");
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append("; fileSize:");
    ((StringBuilder)localObject).append(i);
    QMLog.i("[minigame] GpkgManager subpackage", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(str3))
    {
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2007, null, "downloadSubPack but pkg folder not exist", null);
      }
      return;
    }
    if (new File(str3, str2).exists())
    {
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(0, paramMiniGamePkg, "downloadSubPack succeed, sub pkg already exist", null);
      }
      return;
    }
    if (!TextUtils.isEmpty(str1))
    {
      localObject = str1.toLowerCase();
      paramString = ".zip";
      if (!((String)localObject).endsWith(".zip")) {
        paramString = ".tqapkg";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ApkgManager.getPkgRoot(paramMiniAppInfo));
      ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
      ((StringBuilder)localObject).append('_');
      ((StringBuilder)localObject).append(paramMiniAppInfo.versionId);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(System.nanoTime());
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      MiniReportManager.reportEventType(paramMiniAppInfo, 613, "1");
      localObject = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
      new HashMap(1).put("Connection", "keep-alive");
      downloadSubpackUrl(paramMiniGamePkg, paramOnInitGpkgListener, paramMiniAppInfo, str2, str1, i, paramString, (DownloaderProxy)localObject);
      return;
    }
    paramOnInitGpkgListener.onInitGpkgInfo(2008, null, "sub pkg download url empty", null);
  }
  
  private static void downloadSubpackUrl(MiniGamePkg paramMiniGamePkg, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt, String paramString3, DownloaderProxy paramDownloaderProxy)
  {
    paramDownloaderProxy.download(paramString2, null, paramString3, 60, new GpkgManager.6(paramMiniAppInfo, paramOnInitGpkgListener, paramString3, paramString1, paramMiniGamePkg, paramInt));
  }
  
  private static DownloaderProxy.DownloadListener getGpkgDownloadListener(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString1, long paramLong, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    return new GpkgManager.4(paramMiniAppInfo, paramOnInitGpkgListener, paramLong, paramString2, paramString1, paramString4, paramString3, paramInt);
  }
  
  /* Error */
  private static String getGpkgFilePath(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: iload_3
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: ldc 21
    //   16: aload_0
    //   17: invokestatic 347	com/tencent/qqmini/sdk/core/utils/FileUtils:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +386 -> 409
    //   26: aload_0
    //   27: ldc 21
    //   29: ldc_w 349
    //   32: invokevirtual 353	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   35: astore 9
    //   37: aload_0
    //   38: ldc 21
    //   40: ldc 15
    //   42: invokevirtual 353	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   45: astore 8
    //   47: aconst_null
    //   48: astore 4
    //   50: iconst_0
    //   51: istore_1
    //   52: aload 4
    //   54: astore 6
    //   56: aload 4
    //   58: astore 7
    //   60: aload_0
    //   61: aload 9
    //   63: invokestatic 359	com/tencent/qqmini/sdk/core/utils/ZipUtil:unZipFolder	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: ifne +226 -> 292
    //   69: aload 4
    //   71: astore 6
    //   73: aload 4
    //   75: astore 7
    //   77: aload 9
    //   79: invokestatic 362	com/tencent/qqmini/sdk/core/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   82: ifeq +210 -> 292
    //   85: aload 4
    //   87: astore 7
    //   89: aload 9
    //   91: iconst_0
    //   92: iconst_0
    //   93: invokestatic 366	com/tencent/qqmini/sdk/core/utils/FileUtils:getFiles	(Ljava/lang/String;ZI)Ljava/util/ArrayList;
    //   96: astore 6
    //   98: aload 4
    //   100: astore 5
    //   102: aload 6
    //   104: ifnull +115 -> 219
    //   107: aload 4
    //   109: astore 5
    //   111: aload 4
    //   113: astore 7
    //   115: aload 6
    //   117: invokevirtual 372	java/util/ArrayList:size	()I
    //   120: ifle +99 -> 219
    //   123: aload 4
    //   125: astore 7
    //   127: aload 6
    //   129: invokevirtual 373	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   132: astore 6
    //   134: aload 4
    //   136: astore 5
    //   138: aload 4
    //   140: astore 7
    //   142: aload 6
    //   144: invokeinterface 174 1 0
    //   149: ifeq +70 -> 219
    //   152: aload 4
    //   154: astore 7
    //   156: aload 6
    //   158: invokeinterface 178 1 0
    //   163: checkcast 375	com/tencent/qqmini/sdk/core/utils/FileInfo
    //   166: astore 5
    //   168: aload 4
    //   170: astore 7
    //   172: ldc 15
    //   174: aload 5
    //   176: invokevirtual 378	com/tencent/qqmini/sdk/core/utils/FileInfo:getPath	()Ljava/lang/String;
    //   179: invokestatic 347	com/tencent/qqmini/sdk/core/utils/FileUtils:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   182: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: ifne +23 -> 208
    //   188: aload 4
    //   190: astore 7
    //   192: ldc 18
    //   194: aload 5
    //   196: invokevirtual 378	com/tencent/qqmini/sdk/core/utils/FileInfo:getPath	()Ljava/lang/String;
    //   199: invokestatic 347	com/tencent/qqmini/sdk/core/utils/FileUtils:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq -71 -> 134
    //   208: aload 4
    //   210: astore 7
    //   212: aload 5
    //   214: invokevirtual 378	com/tencent/qqmini/sdk/core/utils/FileInfo:getPath	()Ljava/lang/String;
    //   217: astore 5
    //   219: aload 5
    //   221: astore 6
    //   223: aload 5
    //   225: astore 7
    //   227: aload 5
    //   229: invokestatic 362	com/tencent/qqmini/sdk/core/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   232: ifeq +60 -> 292
    //   235: aload 5
    //   237: astore 7
    //   239: new 68	java/io/File
    //   242: dup
    //   243: aload 5
    //   245: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   248: new 68	java/io/File
    //   251: dup
    //   252: aload 8
    //   254: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: invokestatic 382	com/tencent/qqmini/sdk/core/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   260: istore_3
    //   261: aload 5
    //   263: astore 6
    //   265: iload_3
    //   266: ifeq +26 -> 292
    //   269: aload 9
    //   271: iconst_0
    //   272: invokestatic 386	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   275: pop2
    //   276: aload 8
    //   278: astore 4
    //   280: goto +129 -> 409
    //   283: astore 4
    //   285: aload 8
    //   287: astore 6
    //   289: goto +20 -> 309
    //   292: iload_1
    //   293: iconst_1
    //   294: iadd
    //   295: istore_2
    //   296: goto +93 -> 389
    //   299: astore_0
    //   300: goto +107 -> 407
    //   303: astore 4
    //   305: aload 7
    //   307: astore 6
    //   309: new 61	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   316: astore 5
    //   318: aload 5
    //   320: ldc_w 388
    //   323: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 5
    //   329: aload_0
    //   330: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 5
    //   336: ldc_w 390
    //   339: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 5
    //   345: aload 9
    //   347: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 5
    //   353: ldc_w 392
    //   356: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 5
    //   362: iload_1
    //   363: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: ldc 24
    //   369: aload 5
    //   371: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: aload 4
    //   376: invokestatic 395	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   379: aload 9
    //   381: iconst_0
    //   382: invokestatic 386	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   385: pop2
    //   386: goto -94 -> 292
    //   389: iload_2
    //   390: istore_1
    //   391: aload 6
    //   393: astore 4
    //   395: iload_2
    //   396: iconst_3
    //   397: if_icmplt -345 -> 52
    //   400: aload 6
    //   402: astore 4
    //   404: goto +5 -> 409
    //   407: aload_0
    //   408: athrow
    //   409: aload 4
    //   411: invokestatic 362	com/tencent/qqmini/sdk/core/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   414: ifeq +29 -> 443
    //   417: aload 4
    //   419: astore 5
    //   421: aload 4
    //   423: aload_0
    //   424: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   427: ifne +19 -> 446
    //   430: aload_0
    //   431: iconst_0
    //   432: invokestatic 386	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   435: pop2
    //   436: aload 4
    //   438: astore 5
    //   440: goto +6 -> 446
    //   443: aload_0
    //   444: astore 5
    //   446: new 61	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   453: astore 4
    //   455: aload 4
    //   457: ldc_w 397
    //   460: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 4
    //   466: aload 5
    //   468: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 4
    //   474: ldc_w 399
    //   477: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 4
    //   483: aload_0
    //   484: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: ldc 24
    //   490: aload 4
    //   492: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 113	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: aload 5
    //   500: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	paramString	String
    //   51	340	1	i	int
    //   295	103	2	j	int
    //   4	262	3	bool	boolean
    //   6	273	4	localObject1	Object
    //   283	1	4	localThrowable1	Throwable
    //   303	72	4	localThrowable2	Throwable
    //   393	98	4	localObject2	Object
    //   100	399	5	localObject3	Object
    //   54	347	6	localObject4	Object
    //   58	248	7	localObject5	Object
    //   45	241	8	str1	String
    //   35	345	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   269	276	283	java/lang/Throwable
    //   60	69	299	finally
    //   77	85	299	finally
    //   89	98	299	finally
    //   115	123	299	finally
    //   127	134	299	finally
    //   142	152	299	finally
    //   156	168	299	finally
    //   172	188	299	finally
    //   192	208	299	finally
    //   212	219	299	finally
    //   227	235	299	finally
    //   239	261	299	finally
    //   269	276	299	finally
    //   309	386	299	finally
    //   60	69	303	java/lang/Throwable
    //   77	85	303	java/lang/Throwable
    //   89	98	303	java/lang/Throwable
    //   115	123	303	java/lang/Throwable
    //   127	134	303	java/lang/Throwable
    //   142	152	303	java/lang/Throwable
    //   156	168	303	java/lang/Throwable
    //   172	188	303	java/lang/Throwable
    //   192	208	303	java/lang/Throwable
    //   212	219	303	java/lang/Throwable
    //   227	235	303	java/lang/Throwable
    //   239	261	303	java/lang/Throwable
  }
  
  public static void getGpkgInfoByConfig(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null", null);
      }
      return;
    }
    paramOnInitGpkgListener = new GpkgManager.1(paramMiniAppInfo, paramOnInitGpkgListener);
    ApkgMainProcessManager.queueSubProcessLoadTask(paramMiniAppInfo);
    loadGpkgInMiniProcess(paramMiniAppInfo, paramOnInitGpkgListener);
  }
  
  private static GpkgManager.Info getInfoFromDownloadResult(DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    if (paramDownloadResult == null) {
      return null;
    }
    GpkgManager.Info localInfo = new GpkgManager.Info();
    localInfo.url = paramDownloadResult.url;
    localInfo.timeCostMs = paramDownloadResult.totalTimeMs;
    localInfo.queueTimeMs = paramDownloadResult.queueTimeMs;
    localInfo.connectionTimeMs = paramDownloadResult.connectionTimeMs;
    localInfo.contentSize = paramDownloadResult.contentLength;
    localInfo.dnsTimeMs = paramDownloadResult.dnsTimeMs;
    localInfo.httpStatusCode = paramDownloadResult.httpStatusCode;
    localInfo.message = paramDownloadResult.message;
    localInfo.isFromReusedConnection = paramDownloadResult.isFromReusedConnection;
    localInfo.receiveTimeMs = paramDownloadResult.receiveTimeMs;
    return localInfo;
  }
  
  private static SubPkgInfo getSubPkgDownloadUrl(MiniAppInfo paramMiniAppInfo, MiniGamePkg paramMiniGamePkg, String paramString)
  {
    paramMiniAppInfo = paramMiniAppInfo.subpkgs;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        paramMiniGamePkg = (SubPkgInfo)paramMiniAppInfo.next();
        if (paramString.equals(paramMiniGamePkg.subPkgName)) {
          return paramMiniGamePkg;
        }
      }
    }
    return null;
  }
  
  private static void handleGpkgDownloadSuccess(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString3, String paramString4, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    Object localObject = new File(paramString1);
    MiniReportManager.reportEventType(paramMiniAppInfo, 621, "1");
    boolean bool = WxapkgUnpacker.unpackSync(((File)localObject).getAbsolutePath(), paramString2);
    MiniReportManager.reportEventType(paramMiniAppInfo, 622, null, null, null, bool ^ true, "1", 0L, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Gpkg] handleGpkgDownloadSuccess path:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",unpack:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",hasUnpack:");
    ((StringBuilder)localObject).append(bool);
    QMLog.i("[minigame] GpkgManager", ((StringBuilder)localObject).toString());
    if (bool)
    {
      paramString1 = MiniGamePkg.loadGamePkgFromFolderPath(paramString2, paramString4, paramMiniAppInfo);
      if (paramString3 != null)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[Gpkg] downloadSubPack after gpk succeed, subApkUrl=");
        paramString2.append(paramString3);
        QMLog.i("[minigame] GpkgManager", paramString2.toString());
        downloadSubPack(paramMiniAppInfo, paramString1, paramString3, new GpkgManager.5(paramOnInitGpkgListener));
        return;
      }
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(0, paramString1, "download pkg and unpack succeed", getInfoFromDownloadResult(paramDownloadResult));
      }
    }
    else
    {
      SDKMiniProgramLpReportDC04239.reportForSDK(paramMiniAppInfo, "1", null, "page_view", "load_fail", "unpkg_fail", "");
      MiniAppReportManager2.reportPageView("2launch_fail", "unpkg_fail", null, paramMiniAppInfo);
      paramString1 = new StringBuilder();
      paramString1.append("[Gpkg] handleGpkgDownloadSuccess hasUnpack=");
      paramString1.append(bool);
      QMLog.e("[minigame] GpkgManager", paramString1.toString());
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2005, null, "download pkg succeed but unpack fail", getInfoFromDownloadResult(paramDownloadResult));
      }
    }
  }
  
  public static boolean isGpkgValid(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return false;
    }
    paramMiniAppInfo = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    if (new File(paramMiniAppInfo).exists()) {
      return checkPkgFolderContent(paramMiniAppInfo);
    }
    return false;
  }
  
  public static boolean isOfflineResourceReady(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return false;
    }
    paramMiniAppInfo = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    if ((new File(paramMiniAppInfo).exists()) && (checkPkgFolderContent(paramMiniAppInfo))) {
      return checkOfflineResourceContent(paramMiniAppInfo);
    }
    return false;
  }
  
  private static void loadGpkgInMiniProcess(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    performGetGpkgInfoByConfig(paramMiniAppInfo, paramOnInitGpkgListener);
  }
  
  private static void performDownloadGpkg(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString)
  {
    StringBuilder localStringBuilder;
    if (new File(paramString).exists())
    {
      if (checkPkgFolderContent(paramString))
      {
        QMLog.i("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent success");
        paramString = MiniGamePkg.loadGamePkgFromFolderPath(paramString, null, paramMiniAppInfo);
        if (paramOnInitGpkgListener != null) {
          paramOnInitGpkgListener.onInitGpkgInfo(0, paramString, "gpkg exist, no need download", null);
        }
        if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
          MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, true);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Gpkg] checkPkgFolderContent failed, delete folder:");
        localStringBuilder.append(paramString);
        QMLog.i("[minigame] GpkgManager", localStringBuilder.toString());
        FileUtils.delete(paramString, false);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Gpkg] download gpkg by url1:");
        localStringBuilder.append(paramMiniAppInfo.downloadUrl);
        QMLog.i("[minigame] GpkgManager", localStringBuilder.toString());
        downloadGpkgByResumableDownloader(paramMiniAppInfo, paramOnInitGpkgListener, paramString);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Gpkg] download gpkg by url2:");
      localStringBuilder.append(paramMiniAppInfo.downloadUrl);
      QMLog.i("[minigame] GpkgManager", localStringBuilder.toString());
      downloadGpkgByResumableDownloader(paramMiniAppInfo, paramOnInitGpkgListener, paramString);
    }
  }
  
  private static void performDownloadGpkgPlugin(MiniGamePluginInfo paramMiniGamePluginInfo, GpkgManager.DownloadPluginCallback paramDownloadPluginCallback)
  {
    File localFile = new File(ApkgManager.getGpkgPluginFolderPath(paramMiniGamePluginInfo));
    Object localObject;
    if (localFile.exists())
    {
      if (new File(localFile, "plugin.js").exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Gpkg] plugin existed:");
        ((StringBuilder)localObject).append(localFile.getAbsolutePath());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramMiniGamePluginInfo);
        QMLog.i("[minigame] GpkgManager", ((StringBuilder)localObject).toString());
        if (paramDownloadPluginCallback != null) {
          paramDownloadPluginCallback.onPluginDownloadComplete(true, null, null);
        }
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Gpkg] plugin corrupted:");
      ((StringBuilder)localObject).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMiniGamePluginInfo);
      QMLog.e("[minigame] GpkgManager", ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gpkg_plugin_");
      ((StringBuilder)localObject).append(paramMiniGamePluginInfo.id);
      localObject = File.createTempFile(((StringBuilder)localObject).toString(), ".wxapkg");
      if (TextUtils.isEmpty(paramMiniGamePluginInfo.url))
      {
        if (paramDownloadPluginCallback != null) {
          paramDownloadPluginCallback.onPluginDownloadComplete(false, null, null);
        }
        QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin failed pluginInfo.url null");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Gpkg] start download plugin to:");
      localStringBuilder.append(localFile.getAbsolutePath());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramMiniGamePluginInfo);
      QMLog.i("[minigame] GpkgManager", localStringBuilder.toString());
      downloadGpkgPlugin(paramMiniGamePluginInfo, paramDownloadPluginCallback, localFile, (File)localObject);
      return;
    }
    catch (IOException paramMiniGamePluginInfo)
    {
      if (paramDownloadPluginCallback != null) {
        paramDownloadPluginCallback.onPluginDownloadComplete(false, paramMiniGamePluginInfo, null);
      }
    }
  }
  
  public static void performGetGpkgInfoByConfig(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    MiniReportManager.addCostTimeEventAttachInfo(paramMiniAppInfo, 2, "0");
    if (paramMiniAppInfo == null)
    {
      QMLog.e("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null", null);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Gpkg] getGpkgInfoByConfig version:");
    ((StringBuilder)localObject).append(paramMiniAppInfo.version);
    ((StringBuilder)localObject).append(", appid=");
    ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
    ((StringBuilder)localObject).append(",size=");
    ((StringBuilder)localObject).append(paramMiniAppInfo.fileSize);
    QMLog.i("[minigame] GpkgManager", ((StringBuilder)localObject).toString());
    localObject = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Gpkg] getGpkgInfoByConfig folderPath:");
    localStringBuilder.append((String)localObject);
    QMLog.i("[minigame] GpkgManager", localStringBuilder.toString());
    if ((paramMiniAppInfo.verType != 3) && ((!paramMiniAppInfo.isSupportOffline) || (paramMiniAppInfo.launchParam.scene == 1011)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Gpkg]verType is not online ");
      localStringBuilder.append(paramMiniAppInfo.verType);
      localStringBuilder.append(", delete path ");
      localStringBuilder.append((String)localObject);
      QMLog.i("[minigame] GpkgManager", localStringBuilder.toString());
      if (new File((String)localObject).exists()) {
        FileUtils.delete((String)localObject, false);
      }
    }
    paramOnInitGpkgListener = new GpkgManager.MergedOnInitListener(paramMiniAppInfo, paramOnInitGpkgListener);
    performDownloadGpkg(paramMiniAppInfo, paramOnInitGpkgListener, (String)localObject);
    if (paramMiniAppInfo.miniGamePluginInfo != null)
    {
      performDownloadGpkgPlugin(paramMiniAppInfo.miniGamePluginInfo, paramOnInitGpkgListener);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Gpkg] game don't have plugin ");
    ((StringBuilder)localObject).append(paramMiniAppInfo.name);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
    QMLog.i("[minigame] GpkgManager", ((StringBuilder)localObject).toString());
    paramOnInitGpkgListener.onPluginDownloadComplete(true, null, null);
  }
  
  public static boolean pkgExists(MiniAppInfo paramMiniAppInfo)
  {
    return new File(ApkgManager.getApkgFolderPath(paramMiniAppInfo)).exists();
  }
  
  public static void preloadGpkgByConfig(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.executeOnNetworkIOThreadPool(new GpkgManager.2(paramMiniAppInfo));
  }
  
  public static void setOfflineResourceContent(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    paramMiniAppInfo = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    if (new File(paramMiniAppInfo).exists()) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("offlineResourceReady", paramBoolean);
        localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
        FileUtils.writeFile(new File(paramMiniAppInfo, "offlineconfig.json").getAbsolutePath(), (String)localObject);
        return;
      }
      catch (Throwable paramMiniAppInfo)
      {
        paramMiniAppInfo.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager
 * JD-Core Version:    0.7.0.1
 */