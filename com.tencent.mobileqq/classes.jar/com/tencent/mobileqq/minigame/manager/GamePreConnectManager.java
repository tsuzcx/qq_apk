package com.tencent.mobileqq.minigame.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

public class GamePreConnectManager
{
  private static final String CONNECTION_KEEP_ALIVE = "keep-alive";
  private static final String DELIMITER = ",";
  private static final String HEADER_CONNECTION = "Connection";
  private static final String HOST_HTTPS_PREFIX = "https://";
  public static final long MINI_APP_PRECONNECTION_DURATION_MS = GameWnsUtils.getPreconnectTimeInterval() * 1000L;
  private static final int PRE_CONNECTION_LIMIT = ;
  private static final String PRE_CONNECT_BLACK_APP_ID_LIST = GameWnsUtils.getPreConnectBlackAppIdList();
  private static final String SHARED_PREFERENCES_NAME = "MiniGamePreConnect";
  private static final String TAG = "GamePreConnectManager";
  private static Set<String> connectUrlSet;
  public static long lastMiniAppLaunched;
  private static boolean sHasSaveHostList;
  private static boolean sPreConnectDownloader = false;
  
  static
  {
    connectUrlSet = new HashSet();
    sHasSaveHostList = false;
  }
  
  public static void connectHost(MiniGamePkg paramMiniGamePkg)
  {
    if (PRE_CONNECTION_LIMIT <= 0) {
      return;
    }
    if ((paramMiniGamePkg != null) && (connectHostEnable(paramMiniGamePkg.appId)))
    {
      List localList = getSavedHost(paramMiniGamePkg.appId);
      if ((localList != null) && (!localList.isEmpty()))
      {
        GameLog.getInstance().i("GamePreConnectManager", "connect local host");
        connectHost(localList);
        return;
      }
      GameLog.getInstance().i("GamePreConnectManager", "connect remote host");
      if ((paramMiniGamePkg.appConfig != null) && (paramMiniGamePkg.appConfig.config != null) && (paramMiniGamePkg.appConfig.config.requestDomainList != null) && (paramMiniGamePkg.appConfig.config.requestDomainList.size() > 0)) {
        connectHost(paramMiniGamePkg.appConfig.config.requestDomainList);
      }
    }
  }
  
  private static void connectHost(List<String> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (i >= PRE_CONNECTION_LIMIT) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://");
      localStringBuilder.append(str);
      if (tryConnectHost(localStringBuilder.toString())) {
        i += 1;
      }
    }
  }
  
  private static boolean connectHostEnable(String paramString)
  {
    if (!TextUtils.isEmpty(PRE_CONNECT_BLACK_APP_ID_LIST))
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      String[] arrayOfString = PRE_CONNECT_BLACK_APP_ID_LIST.split(",");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.equals(arrayOfString[i])) {
            return false;
          }
          i += 1;
        }
      }
    }
    return true;
  }
  
  private static String getFromSharedPreference(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).getString(paramString2, null);
  }
  
  private static String getHost(String paramString)
  {
    try
    {
      localObject = new URL(paramString).getHost();
      return localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject;
      label14:
      StringBuilder localStringBuilder;
      break label14;
    }
    localObject = GameLog.getInstance();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getHost exception ");
    localStringBuilder.append(paramString);
    ((GameLog)localObject).e("GamePreConnectManager", localStringBuilder.toString());
    return null;
  }
  
  private static List<String> getSavedHost(String paramString)
  {
    paramString = getFromSharedPreference("MiniGamePreConnect", paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return Arrays.asList(paramString.split(","));
    }
    return null;
  }
  
  public static boolean isMiniAppRecentlyLaunched()
  {
    lastMiniAppLaunched = StorageUtil.getPreference().getLong("key_mini_app_last_use_time", 0L);
    long l1 = System.currentTimeMillis();
    long l2 = lastMiniAppLaunched;
    boolean bool;
    if ((l2 != 0L) && (l1 - l2 < MINI_APP_PRECONNECTION_DURATION_MS)) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("current time = ");
    localStringBuilder.append(l1);
    localStringBuilder.append("ms; lastMiniAppLaunchedTime = ");
    localStringBuilder.append(lastMiniAppLaunched);
    localStringBuilder.append("ms; time interval = ");
    localStringBuilder.append(l1 - lastMiniAppLaunched);
    localStringBuilder.append("ms; miniAppPreconnectionDuration = ");
    localStringBuilder.append(MINI_APP_PRECONNECTION_DURATION_MS);
    localStringBuilder.append("ms; isMiniAppRecentlyLaunched = ");
    localStringBuilder.append(bool);
    QLog.d("GamePreConnectManager", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static void onUrlConnect(String paramString, int paramInt)
  {
    ThreadPools.getComputationThreadPool().execute(new GamePreConnectManager.2(paramInt, paramString));
  }
  
  public static void preConnectDownloader()
  {
    if ((!sPreConnectDownloader) && (GameWnsUtils.enableDownloaderPreConnect()) && (Build.VERSION.SDK_INT > 19) && (MiniappDownloadUtil.getInstance().needPreConnect()) && (isMiniAppRecentlyLaunched()))
    {
      sPreConnectDownloader = true;
      ThreadPools.getComputationThreadPool().execute(new GamePreConnectManager.5());
    }
  }
  
  public static void preConnectDownloaderForSDK()
  {
    if ((!sPreConnectDownloader) && (GameWnsUtils.enableDownloaderPreConnect()) && (Build.VERSION.SDK_INT > 19) && (isMiniAppRecentlyLaunched()))
    {
      sPreConnectDownloader = true;
      ThreadPools.getComputationThreadPool().execute(new GamePreConnectManager.6());
    }
  }
  
  public static void reset()
  {
    ThreadPools.getComputationThreadPool().execute(new GamePreConnectManager.1());
  }
  
  public static void saveConnectHost(String paramString)
  {
    ThreadPools.getComputationThreadPool().execute(new GamePreConnectManager.3(paramString));
  }
  
  private static void saveToSharedPreference(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putString(paramString2, paramString3).apply();
  }
  
  private static boolean tryConnectHost(String paramString)
  {
    try
    {
      Object localObject = GameLog.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("try pre-connect:");
      localStringBuilder.append(paramString);
      ((GameLog)localObject).i("GamePreConnectManager", localStringBuilder.toString());
      long l = System.currentTimeMillis();
      localObject = new Request.Builder().url(paramString).addHeader("Connection", "keep-alive").head();
      paramString = new GamePreConnectManager.4(paramString, l);
      MiniOkHttpClientFactory.getRequestClient().newCall(((Request.Builder)localObject).build()).enqueue(paramString);
      return true;
    }
    catch (RuntimeException paramString)
    {
      GameLog.getInstance().e("GamePreConnectManager", "tryConnectHost exception ", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager
 * JD-Core Version:    0.7.0.1
 */