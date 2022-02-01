package com.tencent.mobileqq.mini.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class PreCacheManager
{
  public static final String CACHE_TYPE_PERIODIC = "periodic";
  public static final String CACHE_TYPE_PRE = "pre";
  public static final String CACHE_TYPE_STATIC = "static";
  private static final String TAG = "miniapp-start_PreCacheManager";
  private static PreCacheManager instance;
  private static byte[] lock = new byte[0];
  private int PRECACHE_CONTENT_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_size_limit", 262144);
  private long PRECACHE_PERIOD_MILLIS = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_period_millis", 43200000L);
  private int PRECACHE_RESOURCE_MAX_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_resource_maxsize", 3);
  
  private void doFetchPreCacheData(MiniAppConfig paramMiniAppConfig, String paramString, PreCacheManager.OnCacheListener paramOnCacheListener)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {}
    label11:
    String str2;
    int i;
    PreCacheInfo localPreCacheInfo;
    Object localObject1;
    do
    {
      int j;
      do
      {
        do
        {
          Iterator localIterator;
          do
          {
            return;
            break label11;
            while ((paramMiniAppConfig.config.preCacheList == null) || (paramMiniAppConfig.config.preCacheList.size() <= 0)) {}
            j = getCacheType(paramString);
            str2 = "[" + paramString + " Cache]";
            i = 1;
            localIterator = paramMiniAppConfig.config.preCacheList.iterator();
          } while (!localIterator.hasNext());
          localPreCacheInfo = (PreCacheInfo)localIterator.next();
        } while (i <= 0);
      } while ((localPreCacheInfo == null) || (localPreCacheInfo.cacheType != j));
      localObject1 = getPreFetchAppCacheData(paramMiniAppConfig, paramString);
      if (localObject1 == null) {
        break;
      }
      QLog.i("miniapp-start_PreCacheManager", 1, str2 + " last PreCache url:" + ((PreCacheManager.PreCacheDescData)localObject1).url + " timestamp:" + ((PreCacheManager.PreCacheDescData)localObject1).timeStamp);
      if ((!"periodic".equals(paramString)) || (!localPreCacheInfo.getDataUrl.equals(((PreCacheManager.PreCacheDescData)localObject1).url)) || (System.currentTimeMillis() - ((PreCacheManager.PreCacheDescData)localObject1).timeStamp >= this.PRECACHE_PERIOD_MILLIS)) {
        break;
      }
      QLog.i("miniapp-start_PreCacheManager", 1, str2 + " last PreCache is still in validity period.");
    } while (paramOnCacheListener == null);
    paramOnCacheListener.onCacheUpdated(true, false);
    return;
    String str1;
    if ("pre".equals(paramString))
    {
      str1 = paramMiniAppConfig.launchParam.entryPath;
      localObject1 = "";
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      if (((String)localObject2).contains("?")) {
        localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf("?") + 1);
      }
    }
    for (;;)
    {
      try
      {
        str1 = URLEncoder.encode((String)localObject2, "UTF-8");
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject2 = URLEncoder.encode((String)localObject1, "UTF-8");
          localObject1 = localObject2;
          localObject2 = str1;
          localObject1 = "appid=" + paramMiniAppConfig.config.appId + "&timestamp=" + System.currentTimeMillis() + "&path=" + (String)localObject2 + "&query=" + (String)localObject1 + "&scene=" + paramMiniAppConfig.launchParam.scene;
          localObject2 = getBackgroundFetchToken(paramMiniAppConfig);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label496;
          }
          MiniAppCmdUtil.getInstance().getLoginCode(paramMiniAppConfig.config.appId, new PreCacheManager.2(this, str2, paramMiniAppConfig, localPreCacheInfo, paramString, (String)localObject1, paramOnCacheListener));
          i -= 1;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject2 = localThrowable1;
            Object localObject3 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
      }
      QLog.e("miniapp-start_PreCacheManager", 1, localThrowable1, new Object[0]);
      continue;
      label496:
      doRequestPreCacheData(paramMiniAppConfig, localPreCacheInfo, paramString, (String)localObject1 + "&token=" + (String)localObject2, paramOnCacheListener);
      continue;
      if ("periodic".equals(paramString))
      {
        localObject1 = getBackgroundFetchToken(paramMiniAppConfig);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.e("miniapp-start_PreCacheManager", 1, str2 + "token is null!");
          return;
        }
        doRequestPreCacheData(paramMiniAppConfig, localPreCacheInfo, paramString, "appid=" + paramMiniAppConfig.config.appId + "&token=" + (String)localObject1 + "&timestamp=" + System.currentTimeMillis(), paramOnCacheListener);
      }
    }
  }
  
  private void doRequestPreCacheData(MiniAppConfig paramMiniAppConfig, PreCacheInfo paramPreCacheInfo, String paramString1, String paramString2, PreCacheManager.OnCacheListener paramOnCacheListener)
  {
    String str2 = "[" + paramString1 + " Cache]";
    String str3 = paramPreCacheInfo.getDataUrl;
    int i = str3.indexOf("?");
    if (i >= 0) {}
    for (String str1 = str3.substring(0, i) + "?" + paramString2 + "&" + str3.substring(i + 1);; str1 = str3 + "?" + paramString2)
    {
      QLog.i("miniapp-start_PreCacheManager", 1, str2 + "doRequestPreCacheData requestUrl:" + str1 + " useProxy:" + paramPreCacheInfo.useProxy + " query:" + paramString2);
      if (paramPreCacheInfo.useProxy <= 0) {
        break;
      }
      MiniAppCmdUtil.getInstance().getContentAccelerate(paramMiniAppConfig.config.appId, str1, 1, null, new PreCacheManager.3(this, str2, paramString1, paramMiniAppConfig, str3, paramOnCacheListener));
      return;
    }
    paramPreCacheInfo = new PreCacheManager.PreCacheDescData();
    paramPreCacheInfo.appid = paramMiniAppConfig.config.appId;
    paramPreCacheInfo.url = str3;
    paramPreCacheInfo.scene = paramMiniAppConfig.launchParam.scene;
    paramPreCacheInfo.path = paramMiniAppConfig.launchParam.entryPath;
    MiniAppFileManager.getInstance();
    paramString2 = MiniAppFileManager.getPreCacheFilePath(paramMiniAppConfig.config.appId, paramString1, paramPreCacheInfo.getCacheKey(paramString1));
    MiniappDownloadUtil.getInstance().download(str1, paramString2, false, new PreCacheManager.4(this, str2, paramOnCacheListener, paramPreCacheInfo, paramString2, paramMiniAppConfig, paramString1), Downloader.DownloadMode.StrictMode, null);
  }
  
  public static PreCacheManager g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new PreCacheManager();
      }
      return instance;
    }
  }
  
  public static int getCacheType(String paramString)
  {
    if ("pre".equals(paramString)) {
      return 1;
    }
    if ("periodic".equals(paramString)) {
      return 2;
    }
    return 0;
  }
  
  public void doFetchPreResourceIfNeed(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      break label11;
    }
    label11:
    label231:
    for (;;)
    {
      return;
      if ((paramMiniAppConfig.config.resourcePreCacheInfo != null) && (paramMiniAppConfig.config.resourcePreCacheInfo.size() > 0))
      {
        int i = this.PRECACHE_RESOURCE_MAX_COUNT;
        Iterator localIterator = paramMiniAppConfig.config.resourcePreCacheInfo.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label231;
          }
          ResourcePreCacheInfo localResourcePreCacheInfo = (ResourcePreCacheInfo)localIterator.next();
          if (i <= 0) {
            break;
          }
          if ((localResourcePreCacheInfo != null) && (!TextUtils.isEmpty(localResourcePreCacheInfo.getDataUrl)))
          {
            i -= 1;
            QLog.i("miniapp-start_PreCacheManager", 1, "[Resource Cache] fetch PreCache url:" + localResourcePreCacheInfo.getDataUrl + " maxCount:" + this.PRECACHE_RESOURCE_MAX_COUNT);
            String str = getResourcePreCachePath(paramMiniAppConfig.config.appId, localResourcePreCacheInfo.getDataUrl);
            if (new File(str).exists()) {
              QLog.i("miniapp-start_PreCacheManager", 1, "[Resource Cache] PreCache already exist. path=" + str);
            } else {
              MiniappDownloadUtil.getInstance().download(localResourcePreCacheInfo.getDataUrl, str, false, new PreCacheManager.6(this, str), Downloader.DownloadMode.StrictMode, null);
            }
          }
        }
      }
    }
  }
  
  public void fetchPeriodicCacheIfNeed(MiniAppConfig paramMiniAppConfig, PreCacheManager.OnCacheListener paramOnCacheListener)
  {
    if (paramMiniAppConfig == null) {
      return;
    }
    doFetchPreCacheData(paramMiniAppConfig, "periodic", paramOnCacheListener);
  }
  
  public void fetchPreCacheData(MiniAppConfig paramMiniAppConfig)
  {
    ThreadManager.excute(new PreCacheManager.1(this, paramMiniAppConfig), 16, null, false);
  }
  
  public void fetchPreResourceIfNeed(MiniAppConfig paramMiniAppConfig)
  {
    ThreadManager.excute(new PreCacheManager.5(this, paramMiniAppConfig), 16, null, false);
  }
  
  public String getBackgroundFetchToken(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {
      return null;
    }
    return StorageUtil.getPreference().getString(paramMiniAppConfig.config.appId + "_precache_token", null);
  }
  
  /* Error */
  public PreCacheManager.PreCacheDescData getPreFetchAppCacheData(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_1
    //   6: aload_1
    //   7: areturn
    //   8: new 144	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData
    //   11: dup
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial 401	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;)V
    //   17: astore 5
    //   19: invokestatic 304	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   22: pop
    //   23: aload_1
    //   24: getfield 86	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   27: getfield 221	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   30: aload_2
    //   31: new 104	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   38: aload 5
    //   40: aload_2
    //   41: invokevirtual 308	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:getCacheKey	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 403
    //   50: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 312	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getPreCacheFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: ldc 144
    //   62: aload_1
    //   63: invokestatic 409	com/tencent/mobileqq/mini/util/ParcelableUtil:readParcelableFromFile	(Ljava/lang/Class;Ljava/lang/String;)Landroid/os/Parcelable;
    //   66: checkcast 144	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +173 -> 244
    //   74: aload_2
    //   75: getfield 412	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   78: ifnull +166 -> 244
    //   81: new 354	java/io/File
    //   84: dup
    //   85: aload_2
    //   86: getfield 412	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   89: invokespecial 357	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 360	java/io/File:exists	()Z
    //   97: istore 4
    //   99: iload 4
    //   101: ifne +45 -> 146
    //   104: iconst_0
    //   105: ifeq +11 -> 116
    //   108: new 414	java/lang/NullPointerException
    //   111: dup
    //   112: invokespecial 415	java/lang/NullPointerException:<init>	()V
    //   115: athrow
    //   116: aconst_null
    //   117: areturn
    //   118: astore_1
    //   119: ldc 17
    //   121: iconst_1
    //   122: ldc 195
    //   124: aload_1
    //   125: invokestatic 418	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload 5
    //   130: astore_2
    //   131: goto -61 -> 70
    //   134: astore_1
    //   135: ldc 17
    //   137: ldc 195
    //   139: aload_1
    //   140: invokestatic 423	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: goto -27 -> 116
    //   146: new 425	java/io/FileInputStream
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 428	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   154: astore 5
    //   156: aload 5
    //   158: astore_1
    //   159: aload 5
    //   161: invokevirtual 431	java/io/FileInputStream:available	()I
    //   164: istore_3
    //   165: aload 5
    //   167: astore_1
    //   168: iload_3
    //   169: newarray byte
    //   171: astore 6
    //   173: aload 5
    //   175: astore_1
    //   176: aload 5
    //   178: aload 6
    //   180: iconst_0
    //   181: iload_3
    //   182: invokevirtual 435	java/io/FileInputStream:read	([BII)I
    //   185: pop
    //   186: aload 5
    //   188: astore_1
    //   189: aload_2
    //   190: aload 6
    //   192: putfield 438	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:data	[B
    //   195: aload_2
    //   196: astore_1
    //   197: aload 5
    //   199: ifnull -193 -> 6
    //   202: aload 5
    //   204: invokevirtual 441	java/io/FileInputStream:close	()V
    //   207: aload_2
    //   208: areturn
    //   209: astore_1
    //   210: ldc 17
    //   212: ldc 195
    //   214: aload_1
    //   215: invokestatic 423	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   218: aload_2
    //   219: areturn
    //   220: astore 6
    //   222: aconst_null
    //   223: astore_2
    //   224: aload_2
    //   225: astore_1
    //   226: ldc 17
    //   228: iconst_1
    //   229: ldc 195
    //   231: aload 6
    //   233: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 441	java/io/FileInputStream:close	()V
    //   244: aconst_null
    //   245: areturn
    //   246: astore_1
    //   247: ldc 17
    //   249: ldc 195
    //   251: aload_1
    //   252: invokestatic 423	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: goto -11 -> 244
    //   258: astore_2
    //   259: aconst_null
    //   260: astore_1
    //   261: aload_1
    //   262: ifnull +7 -> 269
    //   265: aload_1
    //   266: invokevirtual 441	java/io/FileInputStream:close	()V
    //   269: aload_2
    //   270: athrow
    //   271: astore_1
    //   272: ldc 17
    //   274: ldc 195
    //   276: aload_1
    //   277: invokestatic 423	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   280: goto -11 -> 269
    //   283: astore_2
    //   284: goto -23 -> 261
    //   287: astore 6
    //   289: aload 5
    //   291: astore_2
    //   292: goto -68 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	PreCacheManager
    //   0	295	1	paramMiniAppConfig	MiniAppConfig
    //   0	295	2	paramString	String
    //   164	18	3	i	int
    //   97	3	4	bool	boolean
    //   17	273	5	localObject	Object
    //   171	20	6	arrayOfByte	byte[]
    //   220	12	6	localThrowable1	Throwable
    //   287	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   60	70	118	java/lang/Throwable
    //   108	116	134	java/lang/Throwable
    //   202	207	209	java/lang/Throwable
    //   81	99	220	java/lang/Throwable
    //   146	156	220	java/lang/Throwable
    //   240	244	246	java/lang/Throwable
    //   81	99	258	finally
    //   146	156	258	finally
    //   265	269	271	java/lang/Throwable
    //   159	165	283	finally
    //   168	173	283	finally
    //   176	186	283	finally
    //   189	195	283	finally
    //   226	236	283	finally
    //   159	165	287	java/lang/Throwable
    //   168	173	287	java/lang/Throwable
    //   176	186	287	java/lang/Throwable
    //   189	195	287	java/lang/Throwable
  }
  
  public String getResourcePreCachePath(String paramString1, String paramString2)
  {
    MiniAppFileManager.getInstance();
    return MiniAppFileManager.getPreCacheFilePath(paramString1, "static", "" + paramString2.hashCode());
  }
  
  public void notifyPeriodicCacheUpdated(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {}
    AppBrandRuntime localAppBrandRuntime;
    do
    {
      return;
      QLog.i("miniapp-start_PreCacheManager", 1, "[periodic Cache] notify PeriodicCacheUpdated");
      localAppBrandRuntime = AppBrandRuntimeContainer.g().getCurrentAppBrandRuntime();
    } while ((localAppBrandRuntime == null) || (localAppBrandRuntime.getApkgInfo() == null) || (localAppBrandRuntime.getApkgInfo().appConfig == null) || (!localAppBrandRuntime.getApkgInfo().appConfig.config.appId.equals(paramMiniAppConfig.config.appId)));
    localAppBrandRuntime.evaluateServiceSubcribeJS("onBackgroundFetchData", new JSONObject().toString());
  }
  
  public void setBackgroundFetchToken(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    StorageUtil.getPreference().edit().putString(paramMiniAppConfig.config.appId + "_precache_token", paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager
 * JD-Core Version:    0.7.0.1
 */