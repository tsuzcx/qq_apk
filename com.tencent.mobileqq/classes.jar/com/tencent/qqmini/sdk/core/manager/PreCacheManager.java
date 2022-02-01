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
  
  private void doFetchPreCacheData(MiniAppInfo paramMiniAppInfo, String paramString, PreCacheManager.OnCacheListener paramOnCacheListener)
  {
    if (paramMiniAppInfo == null) {}
    String str;
    int i;
    label73:
    PreCacheInfo localPreCacheInfo;
    Object localObject;
    do
    {
      do
      {
        return;
        QMLog.i("minisdk-start_PreCacheManager", "doFetchPreCacheData last PreCache url:");
      } while ((paramMiniAppInfo.preCacheList == null) || (paramMiniAppInfo.preCacheList.size() <= 0));
      int j = getCacheType(paramString);
      str = "[" + paramString + " Cache]";
      i = 1;
      Iterator localIterator = paramMiniAppInfo.preCacheList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break label280;
        }
        localPreCacheInfo = (PreCacheInfo)localIterator.next();
        if (i <= 0) {
          break;
        }
      } while ((localPreCacheInfo == null) || (localPreCacheInfo.cacheType != j));
      localObject = getPreFetchAppCacheData(paramMiniAppInfo, paramString);
      if (localObject == null) {
        break;
      }
      QMLog.i("minisdk-start_PreCacheManager", str + " last PreCache url:" + ((PreCacheManager.PreCacheDescData)localObject).url + " timestamp:" + ((PreCacheManager.PreCacheDescData)localObject).timeStamp);
      if ((!"periodic".equals(paramString)) || (!localPreCacheInfo.getDataUrl.equals(((PreCacheManager.PreCacheDescData)localObject).url)) || (System.currentTimeMillis() - ((PreCacheManager.PreCacheDescData)localObject).timeStamp >= PRECACHE_PERIOD_MILLIS)) {
        break;
      }
      QMLog.i("minisdk-start_PreCacheManager", str + " last PreCache is still in validity period.");
    } while (paramOnCacheListener == null);
    paramOnCacheListener.onCacheUpdated(true, false);
    return;
    if ("pre".equals(paramString)) {
      docachePre(paramMiniAppInfo, paramString, paramOnCacheListener, str, localPreCacheInfo);
    }
    for (;;)
    {
      i -= 1;
      break label73;
      label280:
      break;
      if ("periodic".equals(paramString))
      {
        localObject = getBackgroundFetchToken(paramMiniAppInfo);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QMLog.e("minisdk-start_PreCacheManager", str + "token is null!");
          return;
        }
        doRequestPreCacheData(paramMiniAppInfo, localPreCacheInfo, paramString, "appid=" + paramMiniAppInfo.appId + "&token=" + (String)localObject + "&timestamp=" + System.currentTimeMillis(), paramOnCacheListener);
      }
    }
  }
  
  private void doRequestPreCacheData(MiniAppInfo paramMiniAppInfo, PreCacheInfo paramPreCacheInfo, String paramString1, String paramString2, PreCacheManager.OnCacheListener paramOnCacheListener)
  {
    String str2 = "[" + paramString1 + " Cache]";
    String str3 = paramPreCacheInfo.getDataUrl;
    int i = str3.indexOf("?");
    if (i >= 0) {}
    for (String str1 = str3.substring(0, i) + "?" + paramString2 + "&" + str3.substring(i + 1);; str1 = str3 + "?" + paramString2)
    {
      QMLog.i("minisdk-start_PreCacheManager", str2 + "doRequestPreCacheData requestUrl:" + str1 + " useProxy:" + paramPreCacheInfo.useProxy + " query:" + paramString2);
      if (paramPreCacheInfo.useProxy <= 0) {
        break;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getContentAccelerate(paramMiniAppInfo.appId, str1, 1, null, new PreCacheManager.3(this, str2, paramString1, paramMiniAppInfo, str3, paramOnCacheListener));
      return;
    }
    paramPreCacheInfo = new PreCacheManager.PreCacheDescData();
    paramPreCacheInfo.appid = paramMiniAppInfo.appId;
    paramPreCacheInfo.url = str3;
    paramPreCacheInfo.scene = paramMiniAppInfo.launchParam.scene;
    paramPreCacheInfo.path = paramMiniAppInfo.launchParam.entryPath;
    paramString2 = MiniAppFileManager.getPreCacheFilePath(paramMiniAppInfo.appId, paramString1, paramPreCacheInfo.getCacheKey(paramString1));
    new DownloaderProxyDefault().download(str1, null, paramString2, 20, new PreCacheManager.4(this, str2, str1, paramOnCacheListener, paramPreCacheInfo, paramString2, paramMiniAppInfo, paramString1));
  }
  
  private void docachePre(MiniAppInfo paramMiniAppInfo, String paramString1, PreCacheManager.OnCacheListener paramOnCacheListener, String paramString2, PreCacheInfo paramPreCacheInfo)
  {
    String str = paramMiniAppInfo.launchParam.entryPath;
    Object localObject1 = "";
    localObject2 = str;
    if (str == null) {
      localObject2 = "";
    }
    if (((String)localObject2).contains("?")) {
      localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf("?") + 1);
    }
    for (;;)
    {
      try
      {
        str = URLEncoder.encode((String)localObject2, "UTF-8");
        QMLog.e("minisdk-start_PreCacheManager", "", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject2 = URLEncoder.encode((String)localObject1, "UTF-8");
          localObject1 = localObject2;
          localObject2 = str;
          localObject1 = "appid=" + paramMiniAppInfo.appId + "&timestamp=" + System.currentTimeMillis() + "&path=" + (String)localObject2 + "&query=" + (String)localObject1 + "&scene=" + paramMiniAppInfo.launchParam.scene;
          localObject2 = getBackgroundFetchToken(paramMiniAppInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).login(paramMiniAppInfo.appId, new PreCacheManager.2(this, paramString2, paramMiniAppInfo, paramPreCacheInfo, paramString1, (String)localObject1, paramOnCacheListener));
          return;
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
    }
    doRequestPreCacheData(paramMiniAppInfo, paramPreCacheInfo, paramString1, (String)localObject1 + "&token=" + (String)localObject2, paramOnCacheListener);
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
  
  public void doFetchPreResourceIfNeed(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      break label4;
    }
    label4:
    label220:
    for (;;)
    {
      return;
      if ((paramMiniAppInfo.resourcePreCacheInfo != null) && (paramMiniAppInfo.resourcePreCacheInfo.size() > 0))
      {
        int i = PRECACHE_RESOURCE_MAX_COUNT;
        Iterator localIterator = paramMiniAppInfo.resourcePreCacheInfo.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label220;
          }
          Object localObject = (ResourcePreCacheInfo)localIterator.next();
          if (i <= 0) {
            break;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((ResourcePreCacheInfo)localObject).getDataUrl)))
          {
            i -= 1;
            QMLog.i("minisdk-start_PreCacheManager", "[Resource Cache] fetch PreCache url:" + ((ResourcePreCacheInfo)localObject).getDataUrl + " maxCount:" + PRECACHE_RESOURCE_MAX_COUNT);
            String str = getResourcePreCachePath(paramMiniAppInfo.appId, ((ResourcePreCacheInfo)localObject).getDataUrl);
            if (new File(str).exists())
            {
              QMLog.i("minisdk-start_PreCacheManager", "[Resource Cache] PreCache already exist. path=" + str);
            }
            else
            {
              DownloaderProxyDefault localDownloaderProxyDefault = new DownloaderProxyDefault();
              localObject = ((ResourcePreCacheInfo)localObject).getDataUrl;
              localDownloaderProxyDefault.download((String)localObject, null, str, 20, new PreCacheManager.6(this, (String)localObject, str));
            }
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
    return StorageUtil.getPreference().getString(paramMiniAppInfo.appId + "_precache_token", null);
  }
  
  /* Error */
  public PreCacheManager.PreCacheDescData getPreFetchAppCacheData(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_1
    //   6: aload_1
    //   7: areturn
    //   8: new 142	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData
    //   11: dup
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial 393	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:<init>	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload_1
    //   20: getfield 200	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   23: aload_2
    //   24: new 102	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   31: aload 5
    //   33: aload_2
    //   34: invokevirtual 271	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:getCacheKey	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 395
    //   43: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 277	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getPreCacheFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_1
    //   53: ldc 142
    //   55: aload_1
    //   56: invokestatic 401	com/tencent/qqmini/sdk/core/utils/ParcelableUtil:readParcelableFromFile	(Ljava/lang/Class;Ljava/lang/String;)Landroid/os/Parcelable;
    //   59: checkcast 142	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +175 -> 239
    //   67: aload_2
    //   68: getfield 404	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   71: ifnull +168 -> 239
    //   74: new 346	java/io/File
    //   77: dup
    //   78: aload_2
    //   79: getfield 404	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   82: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 352	java/io/File:exists	()Z
    //   90: istore 4
    //   92: iload 4
    //   94: ifne +46 -> 140
    //   97: iconst_0
    //   98: ifeq +11 -> 109
    //   101: new 406	java/lang/NullPointerException
    //   104: dup
    //   105: invokespecial 407	java/lang/NullPointerException:<init>	()V
    //   108: athrow
    //   109: aconst_null
    //   110: areturn
    //   111: astore_1
    //   112: ldc 25
    //   114: ldc_w 295
    //   117: aload_1
    //   118: invokestatic 409	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload 5
    //   123: astore_2
    //   124: goto -61 -> 63
    //   127: astore_1
    //   128: ldc 25
    //   130: ldc_w 295
    //   133: aload_1
    //   134: invokestatic 324	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto -28 -> 109
    //   140: new 411	java/io/FileInputStream
    //   143: dup
    //   144: aload_1
    //   145: invokespecial 414	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   148: astore 5
    //   150: aload 5
    //   152: astore_1
    //   153: aload 5
    //   155: invokevirtual 417	java/io/FileInputStream:available	()I
    //   158: istore_3
    //   159: aload 5
    //   161: astore_1
    //   162: iload_3
    //   163: newarray byte
    //   165: astore 6
    //   167: aload 5
    //   169: astore_1
    //   170: aload 5
    //   172: aload 6
    //   174: iconst_0
    //   175: iload_3
    //   176: invokevirtual 421	java/io/FileInputStream:read	([BII)I
    //   179: pop
    //   180: aload 5
    //   182: astore_1
    //   183: aload_2
    //   184: aload 6
    //   186: putfield 424	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:data	[B
    //   189: aload_2
    //   190: astore_1
    //   191: aload 5
    //   193: ifnull -187 -> 6
    //   196: aload 5
    //   198: invokevirtual 427	java/io/FileInputStream:close	()V
    //   201: aload_2
    //   202: areturn
    //   203: astore_1
    //   204: ldc 25
    //   206: ldc_w 295
    //   209: aload_1
    //   210: invokestatic 324	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_2
    //   214: areturn
    //   215: astore 6
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_2
    //   220: astore_1
    //   221: ldc 25
    //   223: ldc_w 295
    //   226: aload 6
    //   228: invokestatic 324	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 427	java/io/FileInputStream:close	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_1
    //   242: ldc 25
    //   244: ldc_w 295
    //   247: aload_1
    //   248: invokestatic 324	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: goto -12 -> 239
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 427	java/io/FileInputStream:close	()V
    //   265: aload_2
    //   266: athrow
    //   267: astore_1
    //   268: ldc 25
    //   270: ldc_w 295
    //   273: aload_1
    //   274: invokestatic 324	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: goto -12 -> 265
    //   280: astore_2
    //   281: goto -24 -> 257
    //   284: astore 6
    //   286: aload 5
    //   288: astore_2
    //   289: goto -70 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	PreCacheManager
    //   0	292	1	paramMiniAppInfo	MiniAppInfo
    //   0	292	2	paramString	String
    //   158	18	3	i	int
    //   90	3	4	bool	boolean
    //   17	270	5	localObject	Object
    //   165	20	6	arrayOfByte	byte[]
    //   215	12	6	localThrowable1	Throwable
    //   284	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	63	111	java/lang/Throwable
    //   101	109	127	java/lang/Throwable
    //   196	201	203	java/lang/Throwable
    //   74	92	215	java/lang/Throwable
    //   140	150	215	java/lang/Throwable
    //   235	239	241	java/lang/Throwable
    //   74	92	254	finally
    //   140	150	254	finally
    //   261	265	267	java/lang/Throwable
    //   153	159	280	finally
    //   162	167	280	finally
    //   170	180	280	finally
    //   183	189	280	finally
    //   221	231	280	finally
    //   153	159	284	java/lang/Throwable
    //   162	167	284	java/lang/Throwable
    //   170	180	284	java/lang/Throwable
    //   183	189	284	java/lang/Throwable
  }
  
  public String getResourcePreCachePath(String paramString1, String paramString2)
  {
    return MiniAppFileManager.getPreCacheFilePath(paramString1, "static", "" + paramString2.hashCode());
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
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    StorageUtil.getPreference().edit().putString(paramMiniAppInfo.appId + "_precache_token", paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager
 * JD-Core Version:    0.7.0.1
 */