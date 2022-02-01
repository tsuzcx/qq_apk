package com.tencent.mobileqq.mini.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
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
    Object localObject1 = paramMiniAppConfig;
    String str1 = "UTF-8";
    if (localObject1 != null)
    {
      if (((MiniAppConfig)localObject1).config == null) {
        return;
      }
      if (((MiniAppConfig)localObject1).config.preCacheList != null)
      {
        if (((MiniAppConfig)localObject1).config.preCacheList.size() <= 0) {
          return;
        }
        int i = getCacheType(paramString);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" Cache]");
        String str3 = ((StringBuilder)localObject2).toString();
        Iterator localIterator = ((MiniAppConfig)localObject1).config.preCacheList.iterator();
        int j = 1;
        for (;;)
        {
          localObject2 = paramOnCacheListener;
          if (!localIterator.hasNext()) {
            break;
          }
          PreCacheInfo localPreCacheInfo = (PreCacheInfo)localIterator.next();
          if (j <= 0) {
            return;
          }
          if ((localPreCacheInfo != null) && (localPreCacheInfo.cacheType == i))
          {
            Object localObject3 = getPreFetchAppCacheData(paramMiniAppConfig, paramString);
            Object localObject4;
            if (localObject3 != null)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(str3);
              ((StringBuilder)localObject4).append(" last PreCache url:");
              ((StringBuilder)localObject4).append(((PreCacheManager.PreCacheDescData)localObject3).url);
              ((StringBuilder)localObject4).append(" timestamp:");
              ((StringBuilder)localObject4).append(((PreCacheManager.PreCacheDescData)localObject3).timeStamp);
              QLog.i("miniapp-start_PreCacheManager", 1, ((StringBuilder)localObject4).toString());
              if (("periodic".equals(paramString)) && (localPreCacheInfo.getDataUrl.equals(((PreCacheManager.PreCacheDescData)localObject3).url)) && (System.currentTimeMillis() - ((PreCacheManager.PreCacheDescData)localObject3).timeStamp < this.PRECACHE_PERIOD_MILLIS))
              {
                paramMiniAppConfig = new StringBuilder();
                paramMiniAppConfig.append(str3);
                paramMiniAppConfig.append(" last PreCache is still in validity period.");
                QLog.i("miniapp-start_PreCacheManager", 1, paramMiniAppConfig.toString());
                if (localObject2 != null) {
                  ((PreCacheManager.OnCacheListener)localObject2).onCacheUpdated(true, false);
                }
                return;
              }
            }
            if ("pre".equals(paramString))
            {
              localObject4 = ((MiniAppConfig)localObject1).launchParam.entryPath;
              localObject3 = "";
              if (localObject4 == null) {
                localObject4 = "";
              }
              if (((String)localObject4).contains("?")) {
                localObject3 = ((String)localObject4).substring(((String)localObject4).indexOf("?") + 1);
              }
              localObject2 = localObject4;
              Object localObject5;
              try
              {
                localObject4 = URLEncoder.encode((String)localObject4, str1);
                localObject2 = localObject4;
                String str2 = URLEncoder.encode((String)localObject3, str1);
                localObject2 = str2;
              }
              catch (Throwable localThrowable)
              {
                QLog.e("miniapp-start_PreCacheManager", 1, localThrowable, new Object[0]);
                localObject5 = localObject2;
                localObject2 = localObject3;
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("appid=");
              ((StringBuilder)localObject3).append(((MiniAppConfig)localObject1).config.appId);
              ((StringBuilder)localObject3).append("&timestamp=");
              ((StringBuilder)localObject3).append(System.currentTimeMillis());
              ((StringBuilder)localObject3).append("&path=");
              ((StringBuilder)localObject3).append((String)localObject5);
              ((StringBuilder)localObject3).append("&query=");
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append("&scene=");
              localObject2 = paramMiniAppConfig;
              ((StringBuilder)localObject3).append(((MiniAppConfig)localObject2).launchParam.scene);
              localObject1 = ((StringBuilder)localObject3).toString();
              localObject3 = getBackgroundFetchToken(paramMiniAppConfig);
              if (TextUtils.isEmpty((CharSequence)localObject3))
              {
                MiniAppCmdUtil.getInstance().getLoginCode(((MiniAppConfig)localObject2).config.appId, new PreCacheManager.2(this, str3, paramMiniAppConfig, localPreCacheInfo, paramString, (String)localObject1, paramOnCacheListener));
              }
              else
              {
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append((String)localObject1);
                ((StringBuilder)localObject5).append("&token=");
                ((StringBuilder)localObject5).append((String)localObject3);
                doRequestPreCacheData(paramMiniAppConfig, localPreCacheInfo, paramString, ((StringBuilder)localObject5).toString(), paramOnCacheListener);
              }
            }
            else
            {
              localObject2 = localObject1;
              if ("periodic".equals(paramString))
              {
                localObject2 = getBackgroundFetchToken(paramMiniAppConfig);
                if (TextUtils.isEmpty((CharSequence)localObject2))
                {
                  paramMiniAppConfig = new StringBuilder();
                  paramMiniAppConfig.append(str3);
                  paramMiniAppConfig.append("token is null!");
                  QLog.e("miniapp-start_PreCacheManager", 1, paramMiniAppConfig.toString());
                  return;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("appid=");
                ((StringBuilder)localObject3).append(((MiniAppConfig)localObject1).config.appId);
                ((StringBuilder)localObject3).append("&token=");
                ((StringBuilder)localObject3).append((String)localObject2);
                ((StringBuilder)localObject3).append("&timestamp=");
                ((StringBuilder)localObject3).append(System.currentTimeMillis());
                doRequestPreCacheData(paramMiniAppConfig, localPreCacheInfo, paramString, ((StringBuilder)localObject3).toString(), paramOnCacheListener);
                localObject2 = localObject1;
              }
            }
            j -= 1;
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  private void doRequestPreCacheData(MiniAppConfig paramMiniAppConfig, PreCacheInfo paramPreCacheInfo, String paramString1, String paramString2, PreCacheManager.OnCacheListener paramOnCacheListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" Cache]");
    String str1 = ((StringBuilder)localObject).toString();
    String str2 = paramPreCacheInfo.getDataUrl;
    int i = str2.indexOf("?");
    if (i >= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str2.substring(0, i));
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(str2.substring(i + 1));
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("doRequestPreCacheData requestUrl:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" useProxy:");
    localStringBuilder.append(paramPreCacheInfo.useProxy);
    localStringBuilder.append(" query:");
    localStringBuilder.append(paramString2);
    QLog.i("miniapp-start_PreCacheManager", 1, localStringBuilder.toString());
    if (paramPreCacheInfo.useProxy > 0)
    {
      MiniAppCmdUtil.getInstance().getContentAccelerate(paramMiniAppConfig.config.appId, (String)localObject, 1, null, new PreCacheManager.3(this, str1, paramString1, paramMiniAppConfig, str2, paramOnCacheListener));
      return;
    }
    paramPreCacheInfo = new PreCacheManager.PreCacheDescData();
    paramPreCacheInfo.appid = paramMiniAppConfig.config.appId;
    paramPreCacheInfo.url = str2;
    paramPreCacheInfo.scene = paramMiniAppConfig.launchParam.scene;
    paramPreCacheInfo.path = paramMiniAppConfig.launchParam.entryPath;
    MiniAppFileManager.getInstance();
    paramString2 = MiniAppFileManager.getPreCacheFilePath(paramMiniAppConfig.config.appId, paramString1, paramPreCacheInfo.getCacheKey(paramString1));
    MiniappDownloadUtil.getInstance().download((String)localObject, paramString2, false, new PreCacheManager.4(this, str1, paramOnCacheListener, paramPreCacheInfo, paramString2, paramMiniAppConfig, paramString1), Downloader.DownloadMode.StrictMode, null);
  }
  
  public static PreCacheManager g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new PreCacheManager();
        }
      }
    }
    return instance;
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
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.config == null) {
        return;
      }
      if (paramMiniAppConfig.config.resourcePreCacheInfo != null)
      {
        if (paramMiniAppConfig.config.resourcePreCacheInfo.size() <= 0) {
          return;
        }
        int i = this.PRECACHE_RESOURCE_MAX_COUNT;
        Iterator localIterator = paramMiniAppConfig.config.resourcePreCacheInfo.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (ResourcePreCacheInfo)localIterator.next();
          if (i <= 0) {
            return;
          }
          if ((localObject1 != null) && (!TextUtils.isEmpty(((ResourcePreCacheInfo)localObject1).getDataUrl)))
          {
            i -= 1;
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[Resource Cache] fetch PreCache url:");
            ((StringBuilder)localObject2).append(((ResourcePreCacheInfo)localObject1).getDataUrl);
            ((StringBuilder)localObject2).append(" maxCount:");
            ((StringBuilder)localObject2).append(this.PRECACHE_RESOURCE_MAX_COUNT);
            QLog.i("miniapp-start_PreCacheManager", 1, ((StringBuilder)localObject2).toString());
            localObject2 = getResourcePreCachePath(paramMiniAppConfig.config.appId, ((ResourcePreCacheInfo)localObject1).getDataUrl);
            if (new File((String)localObject2).exists())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[Resource Cache] PreCache already exist. path=");
              ((StringBuilder)localObject1).append((String)localObject2);
              QLog.i("miniapp-start_PreCacheManager", 1, ((StringBuilder)localObject1).toString());
            }
            else
            {
              MiniappDownloadUtil.getInstance().download(((ResourcePreCacheInfo)localObject1).getDataUrl, (String)localObject2, false, new PreCacheManager.6(this, (String)localObject2), Downloader.DownloadMode.StrictMode, null);
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
    SharedPreferences localSharedPreferences = StorageUtil.getPreference();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniAppConfig.config.appId);
    localStringBuilder.append("_precache_token");
    return localSharedPreferences.getString(localStringBuilder.toString(), null);
  }
  
  /* Error */
  public PreCacheManager.PreCacheDescData getPreFetchAppCacheData(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 146	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData
    //   12: dup
    //   13: aload_1
    //   14: aload_2
    //   15: invokespecial 401	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;)V
    //   18: astore 4
    //   20: invokestatic 304	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   23: pop
    //   24: aload_1
    //   25: getfield 88	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   28: getfield 225	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   31: astore_1
    //   32: new 106	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   39: astore 6
    //   41: aload 6
    //   43: aload 4
    //   45: aload_2
    //   46: invokevirtual 308	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:getCacheKey	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 6
    //   55: ldc_w 403
    //   58: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: aload_2
    //   64: aload 6
    //   66: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 312	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getPreCacheFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_1
    //   73: ldc 146
    //   75: aload_1
    //   76: invokestatic 409	com/tencent/mobileqq/mini/util/ParcelableUtil:readParcelableFromFile	(Ljava/lang/Class;Ljava/lang/String;)Landroid/os/Parcelable;
    //   79: checkcast 146	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData
    //   82: astore_2
    //   83: goto +16 -> 99
    //   86: astore_1
    //   87: ldc 17
    //   89: iconst_1
    //   90: ldc 197
    //   92: aload_1
    //   93: invokestatic 412	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: aload 4
    //   98: astore_2
    //   99: aload_2
    //   100: ifnull +181 -> 281
    //   103: aload_2
    //   104: getfield 415	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   107: ifnull +174 -> 281
    //   110: new 354	java/io/File
    //   113: dup
    //   114: aload_2
    //   115: getfield 415	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   118: invokespecial 357	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 360	java/io/File:exists	()Z
    //   126: ifne +5 -> 131
    //   129: aconst_null
    //   130: areturn
    //   131: new 417	java/io/FileInputStream
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 420	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 4
    //   141: aload 4
    //   143: astore_1
    //   144: aload 4
    //   146: invokevirtual 423	java/io/FileInputStream:available	()I
    //   149: istore_3
    //   150: aload 4
    //   152: astore_1
    //   153: iload_3
    //   154: newarray byte
    //   156: astore 5
    //   158: aload 4
    //   160: astore_1
    //   161: aload 4
    //   163: aload 5
    //   165: iconst_0
    //   166: iload_3
    //   167: invokevirtual 427	java/io/FileInputStream:read	([BII)I
    //   170: pop
    //   171: aload 4
    //   173: astore_1
    //   174: aload_2
    //   175: aload 5
    //   177: putfield 430	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:data	[B
    //   180: aload 4
    //   182: invokevirtual 433	java/io/FileInputStream:close	()V
    //   185: aload_2
    //   186: areturn
    //   187: astore_1
    //   188: ldc 17
    //   190: ldc 197
    //   192: aload_1
    //   193: invokestatic 438	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_2
    //   197: areturn
    //   198: astore_1
    //   199: aload 4
    //   201: astore_2
    //   202: aload_1
    //   203: astore 4
    //   205: goto +14 -> 219
    //   208: astore_1
    //   209: aload 5
    //   211: astore_2
    //   212: goto +47 -> 259
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_2
    //   220: astore_1
    //   221: ldc 17
    //   223: iconst_1
    //   224: ldc 197
    //   226: aload 4
    //   228: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_2
    //   232: ifnull +49 -> 281
    //   235: aload_2
    //   236: invokevirtual 433	java/io/FileInputStream:close	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_1
    //   242: ldc 17
    //   244: ldc 197
    //   246: aload_1
    //   247: invokestatic 438	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: aconst_null
    //   251: areturn
    //   252: astore 4
    //   254: aload_1
    //   255: astore_2
    //   256: aload 4
    //   258: astore_1
    //   259: aload_2
    //   260: ifnull +19 -> 279
    //   263: aload_2
    //   264: invokevirtual 433	java/io/FileInputStream:close	()V
    //   267: goto +12 -> 279
    //   270: astore_2
    //   271: ldc 17
    //   273: ldc 197
    //   275: aload_2
    //   276: invokestatic 438	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload_1
    //   280: athrow
    //   281: aconst_null
    //   282: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	PreCacheManager
    //   0	283	1	paramMiniAppConfig	MiniAppConfig
    //   0	283	2	paramString	String
    //   149	18	3	i	int
    //   18	186	4	localObject1	Object
    //   215	12	4	localThrowable	Throwable
    //   252	5	4	localObject2	Object
    //   1	209	5	arrayOfByte	byte[]
    //   39	26	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	83	86	java/lang/Throwable
    //   180	185	187	java/lang/Throwable
    //   144	150	198	java/lang/Throwable
    //   153	158	198	java/lang/Throwable
    //   161	171	198	java/lang/Throwable
    //   174	180	198	java/lang/Throwable
    //   110	129	208	finally
    //   131	141	208	finally
    //   110	129	215	java/lang/Throwable
    //   131	141	215	java/lang/Throwable
    //   235	239	241	java/lang/Throwable
    //   144	150	252	finally
    //   153	158	252	finally
    //   161	171	252	finally
    //   174	180	252	finally
    //   221	231	252	finally
    //   263	267	270	java/lang/Throwable
  }
  
  public String getResourcePreCachePath(String paramString1, String paramString2)
  {
    MiniAppFileManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString2.hashCode());
    return MiniAppFileManager.getPreCacheFilePath(paramString1, "static", localStringBuilder.toString());
  }
  
  public void setBackgroundFetchToken(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if (paramMiniAppConfig != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      SharedPreferences.Editor localEditor = StorageUtil.getPreference().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMiniAppConfig.config.appId);
      localStringBuilder.append("_precache_token");
      localEditor.putString(localStringBuilder.toString(), paramString).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager
 * JD-Core Version:    0.7.0.1
 */