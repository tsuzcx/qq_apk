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
    for (String str1 = str3.substring(0, i) + paramString2 + str3.substring(i + 1);; str1 = str3 + "?" + paramString2)
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
    paramString2 = MiniAppFileManager.getPreCacheFilePath(paramMiniAppConfig.config.appId, paramString1, paramPreCacheInfo.getCacheKey());
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
    //   14: invokespecial 398	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;)V
    //   17: astore 5
    //   19: invokestatic 302	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   22: pop
    //   23: ldc 144
    //   25: aload_1
    //   26: getfield 86	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   29: getfield 221	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   32: aload_2
    //   33: new 104	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   40: aload 5
    //   42: invokevirtual 305	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:getCacheKey	()Ljava/lang/String;
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 400
    //   51: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 309	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getPreCacheFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 406	com/tencent/mobileqq/mini/util/ParcelableUtil:readParcelableFromFile	(Ljava/lang/Class;Ljava/lang/String;)Landroid/os/Parcelable;
    //   63: checkcast 144	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData
    //   66: astore 5
    //   68: aload 5
    //   70: ifnull +154 -> 224
    //   73: aload 5
    //   75: getfield 409	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   78: ifnull +146 -> 224
    //   81: new 351	java/io/File
    //   84: dup
    //   85: aload 5
    //   87: getfield 409	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   90: invokespecial 354	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 357	java/io/File:exists	()Z
    //   98: istore 4
    //   100: iload 4
    //   102: ifne +29 -> 131
    //   105: iconst_0
    //   106: ifeq +11 -> 117
    //   109: new 411	java/lang/NullPointerException
    //   112: dup
    //   113: invokespecial 412	java/lang/NullPointerException:<init>	()V
    //   116: athrow
    //   117: aconst_null
    //   118: areturn
    //   119: astore_1
    //   120: ldc 17
    //   122: ldc 195
    //   124: aload_1
    //   125: invokestatic 417	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: goto -11 -> 117
    //   131: new 419	java/io/FileInputStream
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 422	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore_2
    //   140: aload_2
    //   141: astore_1
    //   142: aload_2
    //   143: invokevirtual 425	java/io/FileInputStream:available	()I
    //   146: istore_3
    //   147: aload_2
    //   148: astore_1
    //   149: iload_3
    //   150: newarray byte
    //   152: astore 6
    //   154: aload_2
    //   155: astore_1
    //   156: aload_2
    //   157: aload 6
    //   159: iconst_0
    //   160: iload_3
    //   161: invokevirtual 429	java/io/FileInputStream:read	([BII)I
    //   164: pop
    //   165: aload_2
    //   166: astore_1
    //   167: aload 5
    //   169: aload 6
    //   171: putfield 432	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:data	[B
    //   174: aload 5
    //   176: astore_1
    //   177: aload_2
    //   178: ifnull -172 -> 6
    //   181: aload_2
    //   182: invokevirtual 435	java/io/FileInputStream:close	()V
    //   185: aload 5
    //   187: areturn
    //   188: astore_1
    //   189: ldc 17
    //   191: ldc 195
    //   193: aload_1
    //   194: invokestatic 417	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload 5
    //   199: areturn
    //   200: astore 5
    //   202: aconst_null
    //   203: astore_2
    //   204: aload_2
    //   205: astore_1
    //   206: ldc 17
    //   208: iconst_1
    //   209: ldc 195
    //   211: aload 5
    //   213: invokestatic 438	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload_2
    //   217: ifnull +7 -> 224
    //   220: aload_2
    //   221: invokevirtual 435	java/io/FileInputStream:close	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_1
    //   227: ldc 17
    //   229: ldc 195
    //   231: aload_1
    //   232: invokestatic 417	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   235: goto -11 -> 224
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_1
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 435	java/io/FileInputStream:close	()V
    //   249: aload_2
    //   250: athrow
    //   251: astore_1
    //   252: ldc 17
    //   254: ldc 195
    //   256: aload_1
    //   257: invokestatic 417	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -11 -> 249
    //   263: astore_2
    //   264: goto -23 -> 241
    //   267: astore 5
    //   269: goto -65 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	PreCacheManager
    //   0	272	1	paramMiniAppConfig	MiniAppConfig
    //   0	272	2	paramString	String
    //   146	15	3	i	int
    //   98	3	4	bool	boolean
    //   17	181	5	localPreCacheDescData	PreCacheManager.PreCacheDescData
    //   200	12	5	localThrowable1	Throwable
    //   267	1	5	localThrowable2	Throwable
    //   152	18	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   109	117	119	java/lang/Throwable
    //   181	185	188	java/lang/Throwable
    //   81	100	200	java/lang/Throwable
    //   131	140	200	java/lang/Throwable
    //   220	224	226	java/lang/Throwable
    //   81	100	238	finally
    //   131	140	238	finally
    //   245	249	251	java/lang/Throwable
    //   142	147	263	finally
    //   149	154	263	finally
    //   156	165	263	finally
    //   167	174	263	finally
    //   206	216	263	finally
    //   142	147	267	java/lang/Throwable
    //   149	154	267	java/lang/Throwable
    //   156	165	267	java/lang/Throwable
    //   167	174	267	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager
 * JD-Core Version:    0.7.0.1
 */