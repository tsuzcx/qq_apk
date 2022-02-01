package com.tencent.qqmini.sdk.core.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PreCacheInfo;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

public class PreCacheManager
{
  public static final String CACHE_TYPE_PERIODIC = "periodic";
  public static final String CACHE_TYPE_PRE = "pre";
  public static final String CACHE_TYPE_STATIC = "static";
  private static int PRECACHE_CONTENT_SIZE = WnsConfig.getConfig("qqminiapp", "mini_app_precache_size_limit", 262144);
  private static long PRECACHE_PERIOD_MILLIS = WnsConfig.getConfig("qqminiapp", "mini_app_precache_period_millis", 43200000L);
  private static int PRECACHE_RESOURCE_MAX_COUNT = WnsConfig.getConfig("qqminiapp", "mini_app_precache_resource_maxsize", 3);
  private static final String TAG = "minisdk-start_PreCacheManager";
  private static PreCacheManager instance;
  private static byte[] lock = new byte[0];
  
  private boolean doCachePre(MiniAppInfo paramMiniAppInfo, String paramString1, PreCacheManager.OnCacheListener paramOnCacheListener, String paramString2, PreCacheInfo paramPreCacheInfo)
  {
    if ("pre".equals(paramString1))
    {
      docachePre(paramMiniAppInfo, paramString1, paramOnCacheListener, paramString2, paramPreCacheInfo);
    }
    else if ("periodic".equals(paramString1))
    {
      String str = getBackgroundFetchToken(paramMiniAppInfo);
      if (TextUtils.isEmpty(str))
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append(paramString2);
        paramMiniAppInfo.append("token is null!");
        QMLog.e("minisdk-start_PreCacheManager", paramMiniAppInfo.toString());
        return true;
      }
      paramString2 = new StringBuilder();
      paramString2.append("appid=");
      paramString2.append(paramMiniAppInfo.appId);
      paramString2.append("&token=");
      paramString2.append(str);
      paramString2.append("&timestamp=");
      paramString2.append(System.currentTimeMillis());
      doRequestPreCacheData(paramMiniAppInfo, paramPreCacheInfo, paramString1, paramString2.toString(), paramOnCacheListener);
    }
    return false;
  }
  
  private void doFetchPreCacheData(MiniAppInfo paramMiniAppInfo, String paramString, PreCacheManager.OnCacheListener paramOnCacheListener)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    QMLog.i("minisdk-start_PreCacheManager", "doFetchPreCacheData last PreCache url:");
    if (paramMiniAppInfo.preCacheList != null)
    {
      if (paramMiniAppInfo.preCacheList.size() <= 0) {
        return;
      }
      int j = getCacheType(paramString);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" Cache]");
      localObject = ((StringBuilder)localObject).toString();
      Iterator localIterator = paramMiniAppInfo.preCacheList.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        PreCacheInfo localPreCacheInfo = (PreCacheInfo)localIterator.next();
        if (i <= 0) {
          return;
        }
        if ((localPreCacheInfo != null) && (localPreCacheInfo.cacheType == j))
        {
          PreCacheManager.PreCacheDescData localPreCacheDescData = getPreFetchAppCacheData(paramMiniAppInfo, paramString);
          if (localPreCacheDescData != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(" last PreCache url:");
            localStringBuilder.append(localPreCacheDescData.url);
            localStringBuilder.append(" timestamp:");
            localStringBuilder.append(localPreCacheDescData.timeStamp);
            QMLog.i("minisdk-start_PreCacheManager", localStringBuilder.toString());
            if (("periodic".equals(paramString)) && (localPreCacheInfo.getDataUrl.equals(localPreCacheDescData.url)) && (System.currentTimeMillis() - localPreCacheDescData.timeStamp < PRECACHE_PERIOD_MILLIS))
            {
              paramMiniAppInfo = new StringBuilder();
              paramMiniAppInfo.append((String)localObject);
              paramMiniAppInfo.append(" last PreCache is still in validity period.");
              QMLog.i("minisdk-start_PreCacheManager", paramMiniAppInfo.toString());
              if (paramOnCacheListener != null) {
                paramOnCacheListener.onCacheUpdated(true, false);
              }
              return;
            }
          }
          if (doCachePre(paramMiniAppInfo, paramString, paramOnCacheListener, (String)localObject, localPreCacheInfo)) {
            return;
          }
          i -= 1;
        }
      }
    }
  }
  
  private void doRequestPreCacheData(MiniAppInfo paramMiniAppInfo, PreCacheInfo paramPreCacheInfo, String paramString1, String paramString2, PreCacheManager.OnCacheListener paramOnCacheListener)
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
    QMLog.i("minisdk-start_PreCacheManager", localStringBuilder.toString());
    if (paramPreCacheInfo.useProxy > 0)
    {
      getContentAccelerate(paramMiniAppInfo, paramString1, paramOnCacheListener, str1, str2, (String)localObject);
      return;
    }
    downloadFile(paramMiniAppInfo, paramString1, paramOnCacheListener, str1, str2, (String)localObject);
  }
  
  private void docachePre(MiniAppInfo paramMiniAppInfo, String paramString1, PreCacheManager.OnCacheListener paramOnCacheListener, String paramString2, PreCacheInfo paramPreCacheInfo)
  {
    Object localObject1 = paramMiniAppInfo.launchParam.entryPath;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    Object localObject4;
    if (((String)localObject2).contains("?")) {
      localObject4 = ((String)localObject2).substring(((String)localObject2).indexOf("?") + 1);
    } else {
      localObject4 = "";
    }
    localObject1 = localObject2;
    try
    {
      localObject2 = URLEncoder.encode((String)localObject2, "UTF-8");
      localObject1 = localObject2;
      String str = URLEncoder.encode((String)localObject4, "UTF-8");
      localObject1 = localObject2;
      localObject4 = str;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_PreCacheManager", "", localThrowable);
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("appid=");
    ((StringBuilder)localObject3).append(paramMiniAppInfo.appId);
    ((StringBuilder)localObject3).append("&timestamp=");
    ((StringBuilder)localObject3).append(System.currentTimeMillis());
    ((StringBuilder)localObject3).append("&path=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("&query=");
    ((StringBuilder)localObject3).append((String)localObject4);
    ((StringBuilder)localObject3).append("&scene=");
    ((StringBuilder)localObject3).append(paramMiniAppInfo.launchParam.scene);
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = getBackgroundFetchToken(paramMiniAppInfo);
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).login(paramMiniAppInfo.appId, new PreCacheManager.2(this, paramString2, paramMiniAppInfo, paramPreCacheInfo, paramString1, (String)localObject1, paramOnCacheListener));
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append((String)localObject1);
    paramString2.append("&token=");
    paramString2.append((String)localObject3);
    doRequestPreCacheData(paramMiniAppInfo, paramPreCacheInfo, paramString1, paramString2.toString(), paramOnCacheListener);
  }
  
  private void downloadFile(MiniAppInfo paramMiniAppInfo, String paramString1, PreCacheManager.OnCacheListener paramOnCacheListener, String paramString2, String paramString3, String paramString4)
  {
    PreCacheManager.PreCacheDescData localPreCacheDescData = new PreCacheManager.PreCacheDescData();
    localPreCacheDescData.appid = paramMiniAppInfo.appId;
    localPreCacheDescData.url = paramString3;
    localPreCacheDescData.scene = paramMiniAppInfo.launchParam.scene;
    localPreCacheDescData.path = paramMiniAppInfo.launchParam.entryPath;
    paramString3 = MiniAppFileManager.getPreCacheFilePath(paramMiniAppInfo.appId, paramString1, localPreCacheDescData.getCacheKey(paramString1));
    new DownloaderProxyDefault().download(paramString4, null, paramString3, 20, new PreCacheManager.3(this, paramString2, paramString4, paramOnCacheListener, localPreCacheDescData, paramString3, paramMiniAppInfo, paramString1));
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
  
  private void getContentAccelerate(MiniAppInfo paramMiniAppInfo, String paramString1, PreCacheManager.OnCacheListener paramOnCacheListener, String paramString2, String paramString3, String paramString4)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getContentAccelerate(paramMiniAppInfo.appId, paramString4, 1, null, new PreCacheManager.4(this, paramString2, paramString1, paramMiniAppInfo, paramString3, paramOnCacheListener));
  }
  
  public void doFetchPreResourceIfNeed(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    if (paramMiniAppInfo.resourcePreCacheInfo != null)
    {
      if (paramMiniAppInfo.resourcePreCacheInfo.size() <= 0) {
        return;
      }
      int i = PRECACHE_RESOURCE_MAX_COUNT;
      Iterator localIterator = paramMiniAppInfo.resourcePreCacheInfo.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (ResourcePreCacheInfo)localIterator.next();
        if (i <= 0) {
          return;
        }
        if ((localObject2 != null) && (!TextUtils.isEmpty(((ResourcePreCacheInfo)localObject2).getDataUrl)))
        {
          i -= 1;
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[Resource Cache] fetch PreCache url:");
          ((StringBuilder)localObject1).append(((ResourcePreCacheInfo)localObject2).getDataUrl);
          ((StringBuilder)localObject1).append(" maxCount:");
          ((StringBuilder)localObject1).append(PRECACHE_RESOURCE_MAX_COUNT);
          QMLog.i("minisdk-start_PreCacheManager", ((StringBuilder)localObject1).toString());
          localObject1 = getResourcePreCachePath(paramMiniAppInfo.appId, ((ResourcePreCacheInfo)localObject2).getDataUrl);
          if (new File((String)localObject1).exists())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[Resource Cache] PreCache already exist. path=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QMLog.i("minisdk-start_PreCacheManager", ((StringBuilder)localObject2).toString());
          }
          else
          {
            DownloaderProxyDefault localDownloaderProxyDefault = new DownloaderProxyDefault();
            localObject2 = ((ResourcePreCacheInfo)localObject2).getDataUrl;
            localDownloaderProxyDefault.download((String)localObject2, null, (String)localObject1, 20, new PreCacheManager.6(this, (String)localObject2, (String)localObject1));
          }
        }
      }
    }
  }
  
  public void fetchPeriodicCacheIfNeed(MiniAppInfo paramMiniAppInfo, PreCacheManager.OnCacheListener paramOnCacheListener)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    doFetchPreCacheData(paramMiniAppInfo, "periodic", paramOnCacheListener);
  }
  
  public void fetchPreCacheData(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.executeOnDiskIOThreadPool(new PreCacheManager.1(this, paramMiniAppInfo));
  }
  
  public void fetchPreResourceIfNeed(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.executeOnDiskIOThreadPool(new PreCacheManager.5(this, paramMiniAppInfo));
  }
  
  public String getBackgroundFetchToken(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    SharedPreferences localSharedPreferences = StorageUtil.getPreference();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniAppInfo.appId);
    localStringBuilder.append("_precache_token");
    return localSharedPreferences.getString(localStringBuilder.toString(), null);
  }
  
  /* Error */
  public PreCacheManager.PreCacheDescData getPreFetchAppCacheData(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 187	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData
    //   12: dup
    //   13: aload_1
    //   14: aload_2
    //   15: invokespecial 403	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:<init>	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Ljava/lang/String;)V
    //   18: astore 4
    //   20: aload_1
    //   21: getfield 125	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   24: astore_1
    //   25: new 101	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   32: astore 6
    //   34: aload 6
    //   36: aload 4
    //   38: aload_2
    //   39: invokevirtual 306	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:getCacheKey	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 6
    //   48: ldc_w 405
    //   51: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_1
    //   56: aload_2
    //   57: aload 6
    //   59: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 312	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getPreCacheFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_1
    //   66: ldc 187
    //   68: aload_1
    //   69: invokestatic 411	com/tencent/qqmini/sdk/core/utils/ParcelableUtil:readParcelableFromFile	(Ljava/lang/Class;Ljava/lang/String;)Landroid/os/Parcelable;
    //   72: checkcast 187	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData
    //   75: astore_2
    //   76: goto +15 -> 91
    //   79: astore_1
    //   80: ldc 25
    //   82: ldc 254
    //   84: aload_1
    //   85: invokestatic 413	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: aload 4
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +180 -> 272
    //   95: aload_2
    //   96: getfield 416	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   99: ifnull +173 -> 272
    //   102: new 356	java/io/File
    //   105: dup
    //   106: aload_2
    //   107: getfield 416	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   110: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 362	java/io/File:exists	()Z
    //   118: ifne +5 -> 123
    //   121: aconst_null
    //   122: areturn
    //   123: new 418	java/io/FileInputStream
    //   126: dup
    //   127: aload_1
    //   128: invokespecial 421	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   131: astore 4
    //   133: aload 4
    //   135: astore_1
    //   136: aload 4
    //   138: invokevirtual 424	java/io/FileInputStream:available	()I
    //   141: istore_3
    //   142: aload 4
    //   144: astore_1
    //   145: iload_3
    //   146: newarray byte
    //   148: astore 5
    //   150: aload 4
    //   152: astore_1
    //   153: aload 4
    //   155: aload 5
    //   157: iconst_0
    //   158: iload_3
    //   159: invokevirtual 428	java/io/FileInputStream:read	([BII)I
    //   162: pop
    //   163: aload 4
    //   165: astore_1
    //   166: aload_2
    //   167: aload 5
    //   169: putfield 431	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:data	[B
    //   172: aload 4
    //   174: invokevirtual 434	java/io/FileInputStream:close	()V
    //   177: aload_2
    //   178: areturn
    //   179: astore_1
    //   180: ldc 25
    //   182: ldc 254
    //   184: aload_1
    //   185: invokestatic 268	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload_2
    //   189: areturn
    //   190: astore_1
    //   191: aload 4
    //   193: astore_2
    //   194: aload_1
    //   195: astore 4
    //   197: goto +14 -> 211
    //   200: astore_1
    //   201: aload 5
    //   203: astore_2
    //   204: goto +46 -> 250
    //   207: astore 4
    //   209: aconst_null
    //   210: astore_2
    //   211: aload_2
    //   212: astore_1
    //   213: ldc 25
    //   215: ldc 254
    //   217: aload 4
    //   219: invokestatic 268	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_2
    //   223: ifnull +49 -> 272
    //   226: aload_2
    //   227: invokevirtual 434	java/io/FileInputStream:close	()V
    //   230: aconst_null
    //   231: areturn
    //   232: astore_1
    //   233: ldc 25
    //   235: ldc 254
    //   237: aload_1
    //   238: invokestatic 268	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aconst_null
    //   242: areturn
    //   243: astore 4
    //   245: aload_1
    //   246: astore_2
    //   247: aload 4
    //   249: astore_1
    //   250: aload_2
    //   251: ifnull +19 -> 270
    //   254: aload_2
    //   255: invokevirtual 434	java/io/FileInputStream:close	()V
    //   258: goto +12 -> 270
    //   261: astore_2
    //   262: ldc 25
    //   264: ldc 254
    //   266: aload_2
    //   267: invokestatic 268	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: aload_1
    //   271: athrow
    //   272: aconst_null
    //   273: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	PreCacheManager
    //   0	274	1	paramMiniAppInfo	MiniAppInfo
    //   0	274	2	paramString	String
    //   141	18	3	i	int
    //   18	178	4	localObject1	Object
    //   207	11	4	localThrowable	Throwable
    //   243	5	4	localObject2	Object
    //   1	201	5	arrayOfByte	byte[]
    //   32	26	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   66	76	79	java/lang/Throwable
    //   172	177	179	java/lang/Throwable
    //   136	142	190	java/lang/Throwable
    //   145	150	190	java/lang/Throwable
    //   153	163	190	java/lang/Throwable
    //   166	172	190	java/lang/Throwable
    //   102	121	200	finally
    //   123	133	200	finally
    //   102	121	207	java/lang/Throwable
    //   123	133	207	java/lang/Throwable
    //   226	230	232	java/lang/Throwable
    //   136	142	243	finally
    //   145	150	243	finally
    //   153	163	243	finally
    //   166	172	243	finally
    //   213	222	243	finally
    //   254	258	261	java/lang/Throwable
  }
  
  public String getResourcePreCachePath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString2.hashCode());
    return MiniAppFileManager.getPreCacheFilePath(paramString1, "static", localStringBuilder.toString());
  }
  
  public void notifyPeriodicCacheUpdated(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    QMLog.i("minisdk-start_PreCacheManager", "[periodic Cache] notify PeriodicCacheUpdated");
  }
  
  public void setBackgroundFetchToken(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (paramMiniAppInfo != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      SharedPreferences.Editor localEditor = StorageUtil.getPreference().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMiniAppInfo.appId);
      localStringBuilder.append("_precache_token");
      localEditor.putString(localStringBuilder.toString(), paramString).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager
 * JD-Core Version:    0.7.0.1
 */